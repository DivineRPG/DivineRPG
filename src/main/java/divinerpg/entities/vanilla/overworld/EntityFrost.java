package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.ai.EscapeWaterGoal;
import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.entities.projectile.EntityFrostShot;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.*;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

public class EntityFrost extends EntityDivineMonster implements RangedAttackMob {
    public EntityFrost(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 20;
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
    }
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 0.6F;
    }
    protected void registerGoals() {
        goalSelector.addGoal(1, new EscapeWaterGoal(this));
        goalSelector.addGoal(2, new FloatGoal(this));
        this.goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.0F));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        goalSelector.addGoal(0, new MeleeAttackGoal(this, 1, true));
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        goalSelector.addGoal(0, new RangedAttackGoal(this, this.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 3, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
    }

    @Override
    public void tick() {
        if (!this.onGround && this.getDeltaMovement().y < 0.0D) {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.6D, 1.0D));
        }
        super.tick();
    }

    @Override
    public void performRangedAttack(LivingEntity entity, float p_82196_2_) {
        if(isAlive() && getTarget() != null && !level.isClientSide && this.tickCount % 50 == 0) {
            EntityFrostShot projectile = new EntityFrostShot(level, this, 0, 0, 0);
            double d0 = getTarget().getX() - this.getX();
            double d1 = getTarget().getY(0.3333333333333333D) - projectile.getY();
            double d2 = getTarget().getZ() - this.getZ();
            double d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
            projectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, 0.8F);
            this.level.addFreshEntity(projectile);
        }
    }

    @Override
    public boolean causeFallDamage(float distance, float damageMultiplier, DamageSource source) {
    	return false;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.FROST.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.BLAZE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BLAZE_DEATH;
    }

    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader reader) {
        return 0.0F;
    }
}