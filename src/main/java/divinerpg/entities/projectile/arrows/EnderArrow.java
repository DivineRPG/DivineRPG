package divinerpg.entities.projectile.arrows;

import divinerpg.entities.projectile.DivineArrow;
import net.minecraft.advancements.triggers.CriteriaTriggers;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityReference;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.Nullable;

import static divinerpg.registries.EntityRegistry.ENDER_ARROW;
import static divinerpg.registries.ItemRegistry.ender_arrow;
import static net.minecraft.world.entity.projectile.ProjectileDeflection.REVERSE;

public class EnderArrow extends DivineArrow {
    public EnderArrow(EntityType<? extends DivineArrow> entityType, Level level) {super(entityType, level);}
    public EnderArrow(Level level, LivingEntity owner, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(ENDER_ARROW.get(), level, owner, pickupItemStack, firedFromWeapon);
    }
    public EnderArrow(Level level, double x, double y, double z, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(ENDER_ARROW.get(), level, x, y, z, pickupItemStack, firedFromWeapon);
    }
    @Override protected ItemStack getDefaultPickupItem() {return new ItemStack(ender_arrow.get());}
    @Override public float getArrowPower() {return 4;}
    @Override protected void onHitEntity(EntityHitResult result) {
        if(result.getEntity() instanceof LivingEntity e && e.isSensitiveToWater()) {
            Entity entity = result.getEntity();
            float f = (float)getDeltaMovement().length(), d0 = getArrowPower() * powerMultiplier;
            Entity owner = getOwner();
            DamageSource damagesource = damageSources().indirectMagic(this, owner);
            if(getWeaponItem() != null && level() instanceof ServerLevel s) d0 = EnchantmentHelper.modifyDamage(s, getWeaponItem(), entity, damagesource, d0);
            int j = Mth.ceil(Mth.clamp((double)f * d0, 0, Integer.MAX_VALUE)), i = entity.getRemainingFireTicks();
            if(isCritArrow()) j = (int)Math.min(random.nextInt(j / 2 + 2) + (long)j, 2147483647);
            if(owner instanceof LivingEntity livingOwner) livingOwner.setLastHurtMob(entity);
            if(isOnFire()) entity.igniteForSeconds(5);
            if(entity.hurtServer(level().getServer().getLevel(level().dimension()), damagesource, (float)j)) {
                if(entity instanceof LivingEntity livingentity) {
                    if(!level().isClientSide()) livingentity.setArrowCount(livingentity.getArrowCount() + 1);
                    if(level() instanceof ServerLevel s1) EnchantmentHelper.doPostAttackEffectsWithItemSource(s1, livingentity, damagesource, getWeaponItem());
                    doPostHurtEffects(livingentity);
                    if(!level().isClientSide() && owner instanceof ServerPlayer serverplayer && !entity.isAlive()/* && shotFromCrossbow()) CriteriaTriggers.KILLED_BY_CROSSBOW.trigger(serverplayer, List.of(entity)*/);
                } playSound(getHitGroundSoundEvent(), 1, 1.2F / (random.nextFloat() * .2F + .9F));
                discard();
            } else {
                entity.setRemainingFireTicks(i);
                deflect(REVERSE, entity, EntityReference.of(getOwner()), false);
                setDeltaMovement(getDeltaMovement().scale(.2));
                if(!level().isClientSide() && getDeltaMovement().lengthSqr() < 1-7) {
                    if(pickup == Pickup.ALLOWED) spawnAtLocation(level().getServer().getLevel(level().dimension()), getPickupItem(), .1F);
                    discard();
                }
            }
        } else super.onHitEntity(result);
    }
}