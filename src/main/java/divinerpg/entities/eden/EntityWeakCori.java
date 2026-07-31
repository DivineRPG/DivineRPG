package divinerpg.entities.eden;

import divinerpg.entities.base.EntityDivineFlyingMonster;
import divinerpg.registries.EntityRegistry;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;

public class EntityWeakCori extends EntityDivineFlyingMonster implements RangedAttackMob {

    public EntityWeakCori(EntityType<? extends EntityWeakCori> type, Level worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0D, 40, 20.0F));
    }

    @Override
    public void performRangedAttack(LivingEntity entity, float range) {
        if(isAlive() && getTarget() != null && !level().isClientSide()) {
            playSound(SoundRegistry.CORI_SHOOT.get());
            ThrowableProjectile projectile = EntityRegistry.CORI_SHOT.get().create(level(), EntitySpawnReason.EVENT);
            projectile.setOwner(this);
            projectile.setPos(getEyePosition());
            double d0 = getTarget().getX() - this.getX();
            double d1 = getTarget().getY(0.3333333333333333D) - projectile.getY();
            double d2 = getTarget().getZ() - this.getZ();
            double d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
            projectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, 0.8F);
            this.level().addFreshEntity(projectile);
        }
    }

    @Override
    public int getMaxSpawnClusterSize() {return 1;}

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.CORI_IDLE.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.CORI_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.CORI_HURT.get();
    }

    public static boolean weakCoriSpawnRule(BlockPos pos) {
        return pos.getY() > 128;
    }
}