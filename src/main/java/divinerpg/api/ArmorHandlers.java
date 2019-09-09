package divinerpg.api;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

public class ArmorHandlers {

    // REMEMBER - HERE NO DIVINERPG REFERENCES!!!

    private static final UUID ARMOR_SPEED_UUID = UUID.fromString("2ae05d96-4b26-420b-8406-156e8febb45f");

    /**
     * Managing player's fly ability
     * @param player - Server side client
     * @param canFly - can we fly or not
     */
    public static void onCanFlyChanged(EntityPlayer player, boolean canFly) {
        // in creative mode we do not need any checks
        if (player.capabilities.isCreativeMode || canFly == player.capabilities.allowFlying) {
            return;
        }

        player.capabilities.allowFlying = canFly;
        if (!canFly && player.capabilities.isFlying) {
            player.capabilities.isFlying = false;
        }

        player.sendPlayerAbilities();
    }

    /**
     * Adding melee damage from player
     * @param e - Server side event
     * @param damageConversionFunc - function modifying original damage amount
     */
    public static void onAddMeleeDamage(LivingHurtEvent e, Function<Float, Float> damageConversionFunc) {
        DamageSource source = e.getSource();
        if (!(source.getTrueSource() instanceof EntityPlayer) || source.isMagicDamage() || source.isProjectile())
            return;

        e.setAmount(damageConversionFunc.apply(e.getAmount()));
    }

    /**
     * Adding ranged damage from player
     * @param e - Server side event
     * @param damageConversionFunc - function modifying original damage amount
     */
    public static void onAddRangedDamage(LivingHurtEvent e, Function<Float, Float> damageConversionFunc) {
        DamageSource source = e.getSource();
        if (!(source.getTrueSource() instanceof EntityPlayer) || !source.isProjectile())
            return;

        e.setAmount(damageConversionFunc.apply(e.getAmount()));
    }

    /**
     * Canceling damage received by player by condition
     * @param e - server side event
     * @param canApply - can block current damage source
     */
    public static void onCancelPlayerReceiveDamage(LivingHurtEvent e, Function<DamageSource, Boolean> canApply) {
        onPlayerReceiveDamage(e, canApply, aFloat -> 0.f);
    }

    /**
     * refilling hunger of player
     * @param e - server side event
     */
    public static void refillHunger(TickEvent.PlayerTickEvent e) {
        EntityPlayer player = e.player;

        if (player.getFoodStats().needFood()) {
            player.getFoodStats().addStats(1, 0);
        }
    }

    /**
     * Managing amount of damage receiving by player
     * @param e - server side event
     * @param canApply - can manage damage with current source
     * @param damageConversionFunc - function returning final damage. If equals/less zero, damage is canceled
     */
    public static void onPlayerReceiveDamage(LivingHurtEvent e, Function<DamageSource, Boolean> canApply, Function<Float, Float> damageConversionFunc) {
        DamageSource source = e.getSource();
        if (!(e.getEntity() instanceof EntityPlayer) || !canApply.apply(source))
            return;

        Float damage = damageConversionFunc.apply(e.getAmount());
        if (damage <= 0) {
            e.setCanceled(true);
        } else {
            e.setAmount(damage);
        }
    }

    /**
     * Speeds up ONLY CLIENT player. 1 - regular speed, 2 - 2 times faster, etc.
     * Algorythm tying to set the most speed value, can ignore it with force flag
     * @param player - client side player
     * @param speedMultiplier - Speed Multiplier 1 - regular speed, 2 - 2 times faster, etc. Negatives disables ability
     * @param force - should force to set passed value to player
     */
    public static void speedUpPlayer(EntityPlayerSP player, float speedMultiplier, boolean force) {
        if (player == null){
            return;
        }

        IAttribute speedAttr = SharedMonsterAttributes.MOVEMENT_SPEED;
        IAttributeInstance playerSpeedAttribute = player.getEntityAttribute(speedAttr);
        AttributeModifier modifier = playerSpeedAttribute.getModifier(ARMOR_SPEED_UUID);

        speedMultiplier = (float) (speedMultiplier * playerSpeedAttribute.getBaseValue() - playerSpeedAttribute.getBaseValue());

        // removing speed modifier if can set faster
        if (force || modifier == null || modifier.getAmount() < speedMultiplier) {
            playerSpeedAttribute.removeModifier(ARMOR_SPEED_UUID);

            // Detect if removing speed modifier
            boolean isRemove = speedMultiplier < 0;

            if (!isRemove) {
                modifier = (new AttributeModifier(ARMOR_SPEED_UUID, "Armor speed modifier", speedMultiplier, 0));
                playerSpeedAttribute.applyModifier(modifier);
            }

            // Managing the step height ON CLIENT SIDE
            player.stepHeight = isRemove ? 0.6F : 1.0625F;
        }
    }

    /**
     * Remove Armor speed modifier at all
     * @param player - client side player
     */
    public static void removeSpeed(EntityPlayerSP player) {
        speedUpPlayer(player, -1, true);
    }

    /**
     * Froze near mobs on server side
     * @param e - server side event
     * @param skipTicks - tick delay
     * @param radius - radius of mobs should be frozen
     */
    public static void frozeNearMobs(TickEvent.PlayerTickEvent e, int skipTicks, int radius) {
        EntityPlayer player = e.player;
        World world = player.world;

        if (world.isRemote || world.getTotalWorldTime() % skipTicks != 0) {
            return;
        }

        // TODO EntityMob?..
        List<Entity> entities = player.world.getEntitiesWithinAABB(EntityMob.class,
                player.getEntityBoundingBox().grow(radius));

        for (Entity mob : entities) {
            ((EntityMob) mob).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 40, 1, true, true));
        }
    }

    /**
     * Speeds up CLIENT SIDE player in water
     * @param playerSP - client side player
     * @param speed - speed modifier
     */
    public static void speedUpInWater(EntityPlayerSP playerSP, float speed) {
        if (playerSP == null || !playerSP.isInWater())
            return;

        // Motion should determine by client
        // Server only receive position changed status
        if (!isMaxSpeed(playerSP.motionX, speed)) {
            playerSP.motionX *= speed;
        }
        if (!isMaxSpeed(playerSP.motionZ, speed)) {
            playerSP.motionZ *= speed;
        }

        if (!isMaxSpeed(playerSP.motionY, speed)) {
            // max X/Z speed. If moving faster, should not change
            // Y cord
            double maxSpeed = 0.3D;

            // managing Y pos if sneaking or just come out the water
            // on full speed should stay on same Y level
            if (playerSP.isSneaking() ||
                    playerSP.motionX < maxSpeed && playerSP.motionZ < maxSpeed) {
                playerSP.motionY *= speed;
            }
        }
    }

    /**
     * Trying to check wherever player motion is more than passed maxSpeed
     * @param motion - player motion (can be negative)
     * @param speed - speed (always not negative)
     * @return is Player reached max speed
     */
    private static boolean isMaxSpeed(double motion, float speed) {
        if (speed < 0) {
            throw new IllegalArgumentException("Speed cannot be less than zero");
        }

        return !(motion > -speed && motion < speed);
    }

    /**
     * Disabling fall damage on server side
     * @param event - server side event
     */
    public static void disableFallDamage(TickEvent.PlayerTickEvent event) {
        event.player.fallDistance -= 0.5F;
    }

    /**
     * Implements infinite water breating on server side
     * @param event - server side event
     */
    public static void breatheUnderwater(TickEvent.PlayerTickEvent event) {
        event.player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 40, 0, true, false));
    }

    /**
     * Check wherever DamageSource is melee damage
     * @param source - Damage source
     * @return true is it only melee damage
     */
    public static boolean isMeeleeDamage(DamageSource source) {
        return !source.isExplosion() && !source.isMagicDamage() && !source.isFireDamage() && !source.isProjectile()
                && !source.isDamageAbsolute() && !source.isUnblockable();
    }
}
