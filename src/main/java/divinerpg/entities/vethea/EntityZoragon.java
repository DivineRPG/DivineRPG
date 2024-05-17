package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineFlyingMob;
import divinerpg.entities.projectile.EntityShooterBullet;
import divinerpg.enums.BulletType;
import divinerpg.registries.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.*;

public class EntityZoragon extends EntityDivineFlyingMob implements RangedAttackMob {
    public EntityZoragon(EntityType<? extends EntityDivineFlyingMob> type, Level worldIn) {super(type, worldIn, 20);}
    @Override protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {return 2;}
    @Override public boolean isAggressive() {return true;}
    @Override protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(2, new RangedAttackGoal(this, 1, 40, 20));
    }
    @Override public void performRangedAttack(LivingEntity entity, float range) {
        if(isAlive() && getTarget() != null && !level().isClientSide) {
            ThrowableProjectile projectile = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET.get(), this, level(), BulletType.ZORAGON_BOMB);
            double d0 = getTarget().getX() - getX();
            double d1 = getTarget().getY(.3333333333333333) - projectile.getY();
            double d2 = getTarget().getZ() - getZ();
            double d3 = Math.sqrt(d0 * d0 + d2 * d2);
            projectile.shoot(d0, d1 + d3 * .2, d2, 1.6F, .8F);
            level().addFreshEntity(projectile);
        }
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.ZORAGON.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.ZORAGON_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.ZORAGON_HURT.get();}
    @Override protected float getSoundVolume() {return 2;}
}