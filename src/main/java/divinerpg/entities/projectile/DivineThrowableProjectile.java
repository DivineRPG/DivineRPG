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
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.*;

public class DivineThrowableProjectile extends ThrowableProjectile {
    public float baseDamage = 1.0F;

    public DivineThrowableProjectile(EntityType<? extends ThrowableProjectile> entityType, Level level, float damage) {
        this(entityType, level);
        this.baseDamage = damage;
    }

    public DivineThrowableProjectile(EntityType<? extends ThrowableProjectile> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public ProjectileDeflection deflection(Projectile projectile) {
        return ProjectileDeflection.NONE;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.tickCount > 200) {
            this.discard();
        }
    }

    public DamageSource getDamageSource(EntityHitResult result) {
        return this.damageSources().mobProjectile(this, getOwner() instanceof LivingEntity l ? l : null);
    }

    protected void doPostHurtEffects(LivingEntity living) {}

    @Override
    protected void onHitEntity(EntityHitResult result) {
        Entity entity = result.getEntity();

        if (level().isClientSide()) {
            return;
        }

        float f = (float) getDeltaMovement().length();
        float d0 = baseDamage;
        Entity owner = getOwner();
        DamageSource damageSource = getDamageSource(result);

        if (getWeaponItem() != null && level() instanceof ServerLevel s) {
            d0 = EnchantmentHelper.modifyDamage(s, getWeaponItem(), entity, damageSource, baseDamage);
        }

        int damage = Mth.ceil(Mth.clamp(f * d0, 0.0F, (float) Integer.MAX_VALUE));
        int remainingFire = entity.getRemainingFireTicks();

        if (owner instanceof LivingEntity livingOwner) {
            livingOwner.setLastHurtMob(entity);
        }

        if (isOnFire()) {
            entity.igniteForSeconds(5);
        }

        if (entity.hurtServer(level().getServer().getLevel(level().dimension()), damageSource, damage)) {
            if (entity instanceof LivingEntity livingEntity) {
                if (level() instanceof ServerLevel s1) {
                    EnchantmentHelper.doPostAttackEffectsWithItemSource(s1, livingEntity, damageSource, getWeaponItem());
                }
                doPostHurtEffects(livingEntity);
            }
            discard();
        } else {
            entity.setRemainingFireTicks(remainingFire);
            if (entity.invulnerableTime > 0 || entity.deflection(this) == ProjectileDeflection.NONE) {
                discard();
            } else {
                deflect(ProjectileDeflection.REVERSE, entity, EntityReference.of(getOwner()), false);
                setDeltaMovement(getDeltaMovement().scale(0.2));
                if (!level().isClientSide() && getDeltaMovement().lengthSqr() < 1E-7) {
                    discard();
                }
            }
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        discard();
    }

    protected void hitBlockNoDiscard(BlockHitResult result) {
        super.onHitBlock(result);
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput compound) {
        super.addAdditionalSaveData(compound);
        compound.putFloat("basDam", baseDamage);
    }

    @Override
    protected void readAdditionalSaveData(ValueInput compound) {
        super.readAdditionalSaveData(compound);
            baseDamage = compound.getFloatOr("basDam", 0);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {}
}