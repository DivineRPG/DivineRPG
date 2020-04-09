package divinerpg.api;

import divinerpg.api.armor.cap.IArmorPowers;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

public class ArmorHandlers {

    // REMEMBER - HERE NO DIVINERPG REFERENCES!!!

    private static final UUID ARMOR_SPEED_UUID = UUID.fromString("2ae05d96-4b26-420b-8406-156e8febb45f");

    /**
     * Managing player's fly ability on server side
     *
     * @param player - player
     * @param canFly - can we fly or not
     */
    public static void onCanFlyChanged(EntityPlayer player, boolean canFly) {
        // in creative mode we do not need any checks
        if (player.capabilities.isCreativeMode
                || canFly == player.capabilities.allowFlying
                // Checking only on server
                || isRemote(player)) {
            return;
        }

        player.capabilities.allowFlying = canFly;
        if (!canFly && player.capabilities.isFlying) {
            player.capabilities.isFlying = false;
        }

        player.sendPlayerAbilities();
    }

    /**
     * Adding melee damage from player on server side
     *
     * @param e                    - event
     * @param damageConversionFunc - function modifying original damage amount
     */
    public static void onAddMeleeDamage(LivingHurtEvent e, Function<Float, Float> damageConversionFunc) {
        onPlayerAttacked(e, ArmorHandlers::isMeeleeDamage, damageConversionFunc);
    }

    /**
     * Adding ranged damage from player on Server side
     *
     * @param e                    - event
     * @param damageConversionFunc - function modifying original damage amount
     */
    public static void onAddRangedDamage(LivingHurtEvent e, Function<Float, Float> damageConversionFunc) {
        onPlayerAttacked(e, DamageSource::isProjectile, damageConversionFunc);
    }

    /**
     * Adding ranged damage from player on Server side
     *
     * @param e                    - event
     * @param damageConversionFunc - function modifying original damage amount
     */
    public static void onAddRangedDamage(LivingHurtEvent e, ResourceLocation armorId, Function<Float, Float> damageConversionFunc) {
        if (isRemote(e.getEntity()) || !(e.getSource().getTrueSource() instanceof EntityPlayer))
            return;

        DamageSource source = e.getSource();
        Entity entity = source.getTrueSource();
        IArmorPowers powers = DivineAPI.getArmorPowers(entity);

        // if ranged damage
        if (powers != null && (source.isProjectile() || source.getDamageType().equals("thrown"))) {
            // if armor is on
            if (powers.wearing(armorId)) {
                // set new amount
                e.setAmount(damageConversionFunc.apply(e.getAmount()));
            }
        }
    }

    /**
     * Handle player attack
     *
     * @param e                    - events
     * @param canApply             - can apply condition
     * @param damageConversionFunc - player attack amount conversion
     */
    public static void onPlayerAttacked(LivingHurtEvent e, Function<DamageSource, Boolean> canApply, Function<Float, Float> damageConversionFunc) {
        DamageSource source = e.getSource();
        if (!(source.getTrueSource() instanceof EntityPlayer)
                || !canApply.apply(source)) {
            return;
        }

        e.setAmount(damageConversionFunc.apply(e.getAmount()));
    }

    /**
     * Canceling damage received by player by condition on server side
     *
     * @param e        -  event
     * @param canApply - can block current damage source
     */
    public static void onCancelPlayerReceiveDamage(LivingHurtEvent e, Function<DamageSource, Boolean> canApply) {
        onPlayerReceiveDamage(e, canApply, aFloat -> 0.f);
    }

    /**
     * refilling hunger of player on server side
     *
     * @param e - tick event
     */
    public static void refillHunger(TickEvent.PlayerTickEvent e) {
        EntityPlayer player = e.player;

        if (!isRemote(player) && player.getFoodStats().needFood()) {
            player.getFoodStats().addStats(1, 0);
        }
    }

    /**
     * Managing amount of damage receiving by player. Should work only on server side
     *
     * @param e                    - tick event
     * @param canApply             - can manage damage with current source
     * @param damageConversionFunc - function returning final damage. If equals/less zero, damage is canceled
     */
    public static void onPlayerReceiveDamage(LivingHurtEvent e, Function<DamageSource, Boolean> canApply, Function<Float, Float> damageConversionFunc) {
        DamageSource source = e.getSource();
        if (!(e.getEntity() instanceof EntityPlayer)
                // should call only on server
                || isRemote(e.getEntity())
                || !canApply.apply(source))
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
     *
     * @param player          - player
     * @param speedMultiplier - Speed Multiplier 1 - regular speed, 2 - 2 times faster, etc. Negatives disables ability
     * @param force           - should force to set passed value to player
     */
    public static void speedUpPlayer(EntityPlayer player, float speedMultiplier, boolean force) {
        IAttribute speedAttr = SharedMonsterAttributes.MOVEMENT_SPEED;
        IAttributeInstance playerSpeedAttribute = player.getEntityAttribute(speedAttr);
        AttributeModifier modifier = playerSpeedAttribute.getModifier(ARMOR_SPEED_UUID);

        speedMultiplier = (float) (speedMultiplier * playerSpeedAttribute.getBaseValue() - playerSpeedAttribute.getBaseValue());

        // Detect if removing speed modifier
        boolean isRemove = speedMultiplier < 0;

        // changing step height on client
        if (isRemote(player)) {
            player.stepHeight = isRemove ? 0.6F : 1.0625F;
        } else {
            // Change speed on server

            // removing speed modifier if can set faster
            if (force || modifier == null || modifier.getAmount() < speedMultiplier) {
                playerSpeedAttribute.removeModifier(ARMOR_SPEED_UUID);

                if (!isRemove) {
                    modifier = (new AttributeModifier(ARMOR_SPEED_UUID, "Armor speed modifier", speedMultiplier, 0));
                    playerSpeedAttribute.applyModifier(modifier);
                }
            }
        }
    }

    /**
     * Remove Armor speed modifier at all.
     *
     * @param player - player
     */
    public static void removeSpeed(EntityPlayer player) {
        speedUpPlayer(player, -1, true);
    }

    /**
     * Froze near mobs on server side
     *
     * @param e         - event
     * @param skipTicks - tick delay
     * @param radius    - radius of mobs should be frozen
     */
    public static void frozeNearMobs(TickEvent.PlayerTickEvent e, int skipTicks, int radius) {
        EntityPlayer player = e.player;
        World world = player.world;

        if (isRemote(player) || world.getTotalWorldTime() % skipTicks != 0) {
            return;
        }

        List<Entity> entities = player.world.getEntitiesWithinAABB(EntityMob.class,
                player.getEntityBoundingBox().grow(radius));

        for (Entity mob : entities) {
            ((EntityMob) mob).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 40, 1, true, true));
        }
    }

    /**
     * Should Speed up CLIENT SIDE player in water
     *
     * @param player - player
     * @param speed  - speed modifier
     */
    public static void speedUpInWater(EntityPlayer player, float speed) {
        if (player == null
                // Should call on client
                || !isRemote(player)
                || !player.isInWater()) {
            return;
        }

        // Motion should determine by client
        // Server only receive position changed status
        if (!isMaxSpeed(player.motionX, speed)) {
            player.motionX *= speed;
        }
        if (!isMaxSpeed(player.motionZ, speed)) {
            player.motionZ *= speed;
        }

        if (!isMaxSpeed(player.motionY, speed)) {
            // max X/Z speed. If moving faster, should not change
            // Y cord
            double maxSpeed = 0.3D;

            // managing Y pos if sneaking or just come out the water
            // on full speed should stay on same Y level
            if (player.isSneaking() ||
                    player.motionX < maxSpeed && player.motionZ < maxSpeed) {
                player.motionY *= speed;
            }
        }
    }

    /**
     * Trying to check wherever player motion is more than passed maxSpeed
     *
     * @param motion - player motion (can be negative)
     * @param speed  - speed (always not negative)
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
     *
     * @param event - tick event
     */
    public static void disableFallDamage(LivingFallEvent event) {
        event.setDistance(0);
    }

    /**
     * Implements infinite water breating on server side
     *
     * @param event - tick event
     */
    public static void breatheUnderwater(TickEvent.PlayerTickEvent event) {
        if (!isRemote(event.player) && event.player.world.getTotalWorldTime() % 30 == 0)
            event.player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 40, 0, true, false));
    }

    /**
     * Check wherever DamageSource is melee damage
     *
     * @param source - Damage source
     * @return true is it only melee damage
     */
    public static boolean isMeeleeDamage(DamageSource source) {
        return !source.isExplosion() && !source.isMagicDamage() && !source.isFireDamage() && !source.isProjectile()
                && !source.isDamageAbsolute() && !source.isUnblockable();
    }

    /**
     * Checks wherever entity contains in remote world
     *
     * @param e - entity
     * @return is remote world
     */
    private static boolean isRemote(Entity e) {
        return e == null || e.world.isRemote;
    }
}
