package divinerpg.entities.iceika;

import divinerpg.entities.base.EntityDivineFlyingMob;
import divinerpg.entities.projectile.EntityFractiteShot;
import divinerpg.registries.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class EntityFractite extends EntityDivineFlyingMob implements RangedAttackMob {
    public EntityFractite(EntityType<? extends EntityDivineFlyingMob> type, Level worldIn) {
        super(type, worldIn);
    }
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.875F;
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1D, 40, 40F));
    }
    @Override
    public void performRangedAttack(LivingEntity entity, float range) {
    	if(!level().isClientSide()) {
            LivingEntity target = getTarget();
            if(isAlive() && target != null) {
            	Fireball projectile = new EntityFractiteShot(level(), this, 0, 0, 0);
            	projectile.setPos(new Vec3(getX(), getEyeY(), getZ()));
                projectile.shoot(target.getX() - getX() + random.nextDouble() - random.nextDouble(), target.getEyeY() - getEyeY() - random.nextDouble() / 2D, target.getZ() - getZ() + random.nextDouble() - random.nextDouble(), 1.6F, .8F);
                level().addFreshEntity(projectile);
            }
    	}
        if(isAlive() && getTarget() != null) playSound(SoundRegistry.FRACTITE_ATTACK.get());
    }
    @Override
    public int getMaxSpawnClusterSize() {
        return 1;
    }
    @Override
    public boolean isMaxGroupSizeReached(int i) {
    	return i > 1;
    }
    @Override
    public SoundEvent getAmbientSound() {
        return SoundRegistry.FRACTITE.get();
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.FRACTITE_HURT.get();
    }
    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.FRACTITE_HURT.get();
    }
}