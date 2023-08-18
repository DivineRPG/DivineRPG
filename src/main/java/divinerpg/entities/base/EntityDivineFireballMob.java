package divinerpg.entities.base;

import javax.annotation.Nullable;

import divinerpg.entities.ai.EscapeWaterGoal;
import net.minecraft.sounds.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;

public abstract class EntityDivineFireballMob extends EntityDivineMonster implements RangedAttackMob {
	Integer preferredY = null;
	public EntityDivineFireballMob(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        xpReward = 20;
        setPathfindingMalus(BlockPathTypes.WATER, -1F);
    }
	@Override
	protected void registerGoals() {
        goalSelector.addGoal(1, new EscapeWaterGoal(this));
        goalSelector.addGoal(2, new FloatGoal(this));
        goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1D));
        goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1D, 0F));
        goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8F));
        goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        targetSelector.addGoal(1, new HurtByTargetGoal(this));
        goalSelector.addGoal(1, new MeleeAttackGoal(this, 1, false));
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        //to your entity, add goalSelector.addGoal(0, new RangedAttackGoal(this, getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), minAttackInterval, maxAttackInterval, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
    }
	@Override
    protected void customServerAiStep() {
    	if(!onGround() && getDeltaMovement().y < 0D) setDeltaMovement(getDeltaMovement().multiply(1D, .6, 1D));
    	LivingEntity target = getTarget();
    	if(preferredY == null || (target != null && (preferredY < target.getBlockY() || preferredY > target.getBlockY() + 3))) {
    		if(target != null && canAttack(target)) preferredY = target.getBlockY() + random.nextInt(2);
    		else preferredY = null;
    	} else if(getBlockY() < preferredY) setDeltaMovement(getDeltaMovement().add(0D, (preferredY - getY()) / 12D * getAttributeValue(Attributes.FLYING_SPEED), 0D));
    }
	@Override
    public void performRangedAttack(LivingEntity entity, float f) {
		if(!level().isClientSide()) {
	    	LivingEntity target = getTarget();
	        if(isAlive() && target != null) {
	        	Fireball projectile = getProjectile();
	        	projectile.setPos(new Vec3(getX(), getEyeY(), getZ()));
	            projectile.shoot(target.getX() - getX() + random.nextDouble() - random.nextDouble(), target.getEyeY() - getEyeY() - random.nextDouble() / 2D, target.getZ() - getZ() + random.nextDouble() - random.nextDouble(), 1.6F, .8F);
	            level().addFreshEntity(projectile);
	        }
		}
		if(getShootSound() != null && isAlive() && getTarget() != null) playSound(getShootSound());
    }
	protected abstract Fireball getProjectile();
	protected @Nullable SoundEvent getShootSound() {
		return null;
	}
	@Override
    public boolean causeFallDamage(float distance, float damageMultiplier, DamageSource source) {
    	return false;
    }
	@Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.BLAZE_HURT;
    }
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BLAZE_DEATH;
    }
}