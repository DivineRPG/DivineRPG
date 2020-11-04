package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.*;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.EnumSet;

public class EntityFrost extends EntityDivineMob {

    private float heightOffset = 0.5F;
    private int heightOffsetUpdateTime;

    public EntityFrost(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        this.experienceValue = 20;
        this.setPathPriority(PathNodeType.WATER, -1.0F);
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.6F;
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.frostHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.frostDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.frostSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.follow);
    }
    protected void registerGoals() {
        this.goalSelector.addGoal(4, new EntityFrost.AIFrostShotAttack(this));
        this.goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D, 0.0F));
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }

    @Override
    public void livingTick() {
        if (!this.onGround && this.getMotion().y < 0.0D) {
            this.setMotion(this.getMotion().mul(1.0D, 0.6D, 1.0D));
        }
        if (!this.world.isRemote) {
            this.setAttackTarget(this.world.getClosestPlayer(this, 22.0D));
        }
        super.livingTick();
    }

    @Override
    protected void updateAITasks() {
        --this.heightOffsetUpdateTime;
        if (this.heightOffsetUpdateTime <= 0) {
            this.heightOffsetUpdateTime = 100;
            this.heightOffset = 0.5F + (float)this.rand.nextGaussian() * 3.0F;
        }

        LivingEntity livingentity = this.getAttackTarget();
        if (livingentity != null && livingentity.getPosYEye() > this.getPosYEye() + (double)this.heightOffset && this.canAttack(livingentity)) {
            Vector3d vector3d = this.getMotion();
            this.setMotion(this.getMotion().add(0.0D, ((double)0.3F - vector3d.y) * (double)0.3F, 0.0D));
            this.isAirBorne = true;
        }

        super.updateAITasks();
    }

    static class AIFrostShotAttack extends Goal {
        private final EntityFrost frost;
        private int attackStep;
        private int attackTime;
        private int field_223527_d;

        public AIFrostShotAttack(EntityFrost frost) {
            this.frost = frost;
            this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            LivingEntity livingentity = this.frost.getAttackTarget();
            return livingentity != null && livingentity.isAlive() && this.frost.canAttack(livingentity);
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            this.attackStep = 0;
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask() {
            this.field_223527_d = 0;
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            --this.attackTime;
            LivingEntity livingentity = this.frost.getAttackTarget();
            if (livingentity != null) {
                boolean flag = this.frost.getEntitySenses().canSee(livingentity);
                if (flag) {
                    this.field_223527_d = 0;
                } else {
                    ++this.field_223527_d;
                }

                double d0 = this.frost.getDistanceSq(livingentity);
                if (d0 < 4.0D) {
                    if (!flag) {
                        return;
                    }

                    if (this.attackTime <= 0) {
                        this.attackTime = 20;
                        this.frost.attackEntityAsMob(livingentity);
                    }

                    this.frost.getMoveHelper().setMoveTo(livingentity.getPosX(), livingentity.getPosY(), livingentity.getPosZ(), 1.0D);
                } else if (d0 < this.getFollowDistance() * this.getFollowDistance() && flag) {
                    double d1 = livingentity.getPosX() - this.frost.getPosX();
                    double d2 = livingentity.getPosYHeight(0.5D) - this.frost.getPosYHeight(0.5D);
                    double d3 = livingentity.getPosZ() - this.frost.getPosZ();
                    if (this.attackTime <= 0) {
                        ++this.attackStep;
                        if (this.attackStep == 1) {
                            this.attackTime = 60;
                        } else if (this.attackStep <= 4) {
                            this.attackTime = 6;
                        } else {
                            this.attackTime = 100;
                            this.attackStep = 0;
                        }

                        if (this.attackStep > 1) {
                            float f = MathHelper.sqrt(MathHelper.sqrt(d0)) * 0.5F;
                            if (!this.frost.isSilent()) {
                                this.frost.world.playEvent((PlayerEntity) null, 1018, this.frost.getPosition(), 0);
                            }

                            for (int i = 0; i < 1; ++i) {
                                //TODO - change to frost projectile
                                SmallFireballEntity smallfireballentity = new SmallFireballEntity(this.frost.world, this.frost, d1 + this.frost.getRNG().nextGaussian() * (double) f, d2, d3 + this.frost.getRNG().nextGaussian() * (double) f);
                                smallfireballentity.setPosition(smallfireballentity.getPosX(), this.frost.getPosYHeight(0.5D) + 0.5D, smallfireballentity.getPosZ());
                                this.frost.world.addEntity(smallfireballentity);
                            }
                        }
                    }

                    this.frost.getLookController().setLookPositionWithEntity(livingentity, 10.0F, 10.0F);
                } else if (this.field_223527_d < 5) {
                    this.frost.getMoveHelper().setMoveTo(livingentity.getPosX(), livingentity.getPosY(), livingentity.getPosZ(), 1.0D);
                }

                super.tick();
            }
        }
        private double getFollowDistance() {
            return this.frost.getAttributeValue(Attributes.FOLLOW_RANGE);
        }
    }

    @Override
    public boolean onLivingFall(float distance, float damageMultiplier) {
        return false;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.FROST;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_BLAZE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_BLAZE_DEATH;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_FROST;
    }

}