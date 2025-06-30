package divinerpg.entities.projectile;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;

public class DivineThrowableProjectile extends ThrowableProjectile {
    public float baseDamage = 1;
    public DivineThrowableProjectile(EntityType<? extends ThrowableProjectile> entityType, Level level, float damage) {
        this(entityType, level);
        baseDamage = damage;
    }
    public DivineThrowableProjectile(EntityType<? extends ThrowableProjectile> entityType, Level level) {
        super(entityType, level);
    }
    @Override public ProjectileDeflection deflection(Projectile projectile) {return ProjectileDeflection.NONE;}
    @Override public void tick() {
        super.tick();
        if(tickCount > 200) discard();
    }
    public DamageSource getDamageSource(EntityHitResult result) {
        return damageSources().mobProjectile(this, getOwner() instanceof LivingEntity l ? l : null);
    }
    protected void doPostHurtEffects(LivingEntity living) {}
    @Override protected void onHitEntity(EntityHitResult result) {
        Entity entity = result.getEntity();
        float f = (float)getDeltaMovement().length(), d0 = baseDamage;
        Entity owner = getOwner();
        DamageSource damageSource = getDamageSource(result);
        if(getWeaponItem() != null && level() instanceof ServerLevel s) d0 = EnchantmentHelper.modifyDamage(s, getWeaponItem(), entity, damageSource, baseDamage);
        int j = Mth.ceil(Mth.clamp(f * d0, 0, Integer.MAX_VALUE)), i = entity.getRemainingFireTicks();
        if(owner instanceof LivingEntity livingOwner) livingOwner.setLastHurtMob(entity);
        if(isOnFire()) entity.igniteForSeconds(5);
        if(entity.hurt(damageSource, j)) {
            if(entity instanceof LivingEntity livingEntity) {
                if(level() instanceof ServerLevel s1) EnchantmentHelper.doPostAttackEffectsWithItemSource(s1, livingEntity, damageSource, getWeaponItem());
                doPostHurtEffects(livingEntity);
            } discard();
        } else {
            entity.setRemainingFireTicks(i);
            if(entity.invulnerableTime > 0 || entity.deflection(this) == ProjectileDeflection.NONE) discard();
            else {
                deflect(ProjectileDeflection.REVERSE, entity, getOwner(), false);
                setDeltaMovement(getDeltaMovement().scale(.2));
                if(!level().isClientSide && getDeltaMovement().lengthSqr() < 1E-7) discard();
            }
        }
    }
    @Override protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        discard();
    }
    protected void hitBlockNoDiscard(BlockHitResult result) {super.onHitBlock(result);}
    @Override protected void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putFloat("basDam", baseDamage);
    }
    @Override protected void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        baseDamage = compound.getFloat("basDam");
    }
    @Override protected void defineSynchedData(SynchedEntityData.Builder builder) {}
}