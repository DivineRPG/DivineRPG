package divinerpg.events.armorEvents;

import divinerpg.DivineRPG;
import divinerpg.utils.PositionHelper;
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
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

public class ArmorHandlers {

    // private static final String[] walkSpeed = new String[]{"field_75097_g", "walkSpeed"};

    private static final UUID ARMOR_SPEED_UUID = UUID.fromString("2ae05d96-4b26-420b-8406-156e8febb45f");

    public static void onAddMeleeDamage(LivingHurtEvent e, Function<Float, Float> damageConversionFunc) {
        DamageSource source = e.getSource();
        if (!(source.getTrueSource() instanceof EntityPlayer) || source.isMagicDamage() || source.isProjectile())
            return;

        e.setAmount(damageConversionFunc.apply(e.getAmount()));
    }

    public static void onAngelicEquipped(EntityPlayer player, boolean isFullEquipped) {
        // in creative mode we do not need any checks
        if (player.capabilities.isCreativeMode || isFullEquipped == player.capabilities.allowFlying) {
            return;
        }

        player.capabilities.allowFlying = isFullEquipped;
        if (!isFullEquipped && player.capabilities.isFlying) {
            player.capabilities.isFlying = false;
        }

        player.sendPlayerAbilities();
    }

    public static void onAddMeleeDamage(LivingHurtEvent e, Function<Float, Float> damageConversionFunc) {
        DamageSource source = e.getSource();
        if (!(source.getTrueSource() instanceof EntityPlayer) || source.isMagicDamage() || source.isProjectile())
            return;

        e.setAmount(damageConversionFunc.apply(e.getAmount()));
    }

    public static void cancelDamageSource(LivingHurtEvent e, Function<DamageSource, Boolean> canApply) {
        DamageSource source = e.getSource();
        if (!(source.getTrueSource() instanceof EntityPlayer) || !canApply.apply(source))
            return;

        e.setCanceled(true);
    }

    public static void cancelDamageSource(LivingAttackEvent e, Function<DamageSource, Boolean> canApply) {
        DamageSource source = e.getSource();
        if (!canApply.apply(source))
            return;

        e.setCanceled(true);
    }

    public static void onCancelPlayerReceiveDamage(LivingHurtEvent e, Function<DamageSource, Boolean> canApply) {
        onPlayerReceiveDamage(e, canApply, aFloat -> 0.f);
    }

    public static void refillHunger(TickEvent.PlayerTickEvent e) {
        EntityPlayer player = e.player;

        if (player.getFoodStats().needFood()) {
            player.getFoodStats().addStats(1, 0);
        }
    }

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
     * Speeds up player. 1 - regular speed, 2 - 2 times faster, etc.
     * Zero is disabled speed ability at all
     * Algorythm tying to set the most speed value, can ignore it with force flag
     */
    public static void speedUpPlayer(EntityPlayer player, float speedMultiplier, boolean force) {
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
            DivineRPG.proxy.getPlayer().stepHeight = isRemove ? 0.6F : 1.0625F;
        }
    }

    public static void removeSpeed(EntityPlayer player) {
        speedUpPlayer(player, -1, true);
    }

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

    public static void speedUpInWater(float speed) {
        EntityPlayer player = DivineRPG.proxy.getPlayer();
        if (player == null || !player.isInWater())
            return;

        // Motion should determine by client
        // Server only receive position changed status
        if (!PositionHelper.isMaxSpeed(player.motionX, speed)) {
            player.motionX *= speed;
        }
        if (!PositionHelper.isMaxSpeed(player.motionZ, speed)) {
            player.motionZ *= speed;
        }

        if (!PositionHelper.isMaxSpeed(player.motionY, speed)) {
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

    public static void disableFallDamage(TickEvent.PlayerTickEvent event) {
        event.player.fallDistance -= 0.5F;
    }

    public static void breatheUnderwater(TickEvent.PlayerTickEvent event) {
        event.player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 40, 0, true, false));
    }


    public static boolean isMeeleeDamage(DamageSource source) {
        return !source.isExplosion() && !source.isMagicDamage() && !source.isFireDamage() && !source.isProjectile()
                && !source.isDamageAbsolute() && !source.isUnblockable();
    }
}
