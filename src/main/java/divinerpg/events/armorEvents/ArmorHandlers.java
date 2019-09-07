package divinerpg.events.armorEvents;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.List;
import java.util.function.Function;

public class ArmorHandlers {

    private static final String[] walkSpeed = new String[]{"field_75097_g", "walkSpeed"};

    public static void onAngelicEquipped(EntityPlayer player, boolean isFullEquipped) {
        // in creative mode we do not need any checks
        if (player.capabilities.isCreativeMode && isFullEquipped == player.capabilities.allowFlying) {
            return;
        }

        player.capabilities.allowFlying = isFullEquipped;
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

    public static void handleDamageSource(LivingHurtEvent e, Function<DamageSource, Boolean> canApply, Function<Float, Float> damageConversionFunc) {
        DamageSource source = e.getSource();
        if (!(source.getTrueSource() instanceof EntityPlayer) || !canApply.apply(source))
            return;

        e.setAmount(damageConversionFunc.apply(e.getAmount()));
    }

    public static void refillHunger(TickEvent.PlayerTickEvent e) {
        EntityPlayer player = e.player;

        if (player.getFoodStats().needFood()) {
            player.getFoodStats().addStats(1, 0);
        }
    }

    /**
     * Speeds up player. 1 - regular speed, 2 - 2 times faster, etc.
     */
    public static void speedUpPlayer(EntityPlayer player, float speedMultiplier, boolean force) {
        float walk = 0.1f * speedMultiplier;

        // setting the most speed
        if (force || player.capabilities.getWalkSpeed() < walk) {
            ObfuscationReflectionHelper.setPrivateValue(PlayerCapabilities.class,
                    player.capabilities,
                    walk,
                    walkSpeed);
        }

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
            ((EntityMob) mob).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 40, 1, true, false));
        }
    }


    public static boolean isMeeleeDamage(DamageSource source) {
        return !source.isExplosion() && !source.isMagicDamage() && !source.isFireDamage() && !source.isProjectile()
                && !source.isDamageAbsolute() && !source.isUnblockable();
    }
}
