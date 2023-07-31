package divinerpg.entities.vanilla.end;

import divinerpg.entities.base.EntityDivineFlyingMob;
import divinerpg.entities.projectile.EntityEnderTripletsFireball;
import net.minecraft.sounds.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class EntityEnderTriplets extends EntityDivineFlyingMob implements RangedAttackMob {
    public EntityEnderTriplets(EntityType<? extends EntityDivineFlyingMob> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 5;
    }

    @Override
    public boolean fireImmune() {
        return true;
    }
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.0F;
    }
    @Override
    protected float getSoundVolume() {
        return 10.0F;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.GHAST_SCREAM;
    }
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.GHAST_DEATH;
    }

    @Override
    public boolean isAggressive() {
        return true;
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0D, 40, 64.0F));
    }

    @Override
    public void performRangedAttack(LivingEntity entity, float range) {
        if (this.isAlive()) {
            if (getTarget() != null) {
                Vec3 vector3d = this.getViewVector(1.0F);
                double d0 = getTarget().getX() - (this.getX() + vector3d.x * 4.0D);
                double d1 = getTarget().getY(0.5D) - (0.5D + this.getY(0.5D));
                double d2 = getTarget().getZ() - (this.getZ() + vector3d.z * 4.0D);
                double d3 = (double) Math.sqrt(d0 * d0 + d2 * d2);
                EntityEnderTripletsFireball shot = new EntityEnderTripletsFireball(level(), this, d0, d1, d2);
                shot.shoot(d0, d1 + d3 * (double) 0.2F, d2, 3.3F, 0.2F);
                if (!this.level().isClientSide())
                    this.level().addFreshEntity(shot);
            }
        }
    }
}