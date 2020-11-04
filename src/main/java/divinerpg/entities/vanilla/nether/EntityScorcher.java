package divinerpg.entities.vanilla.nether;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.network.datasync.*;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.*;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.EnumSet;

public class EntityScorcher extends EntityDivineMob {
    private float heightOffset = 0.5F;
    private int heightOffsetUpdateTime;

    public EntityScorcher(EntityType<? extends EntityScorcher> type, World world) {
        super(type, world);
        this.setPathPriority(PathNodeType.WATER, -1.0F);
        this.setPathPriority(PathNodeType.LAVA, 8.0F);
        this.setPathPriority(PathNodeType.DANGER_FIRE, 0.0F);
        this.setPathPriority(PathNodeType.DAMAGE_FIRE, 0.0F);
        this.experienceValue = 20;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(4, new EntityScorcher.FireballAttackGoal(this));
        this.goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D, 0.0F));
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.scorcherDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.scorcherSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.scorcherFollowRange).createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.scorcherHealth);
    }

    @Override
    public boolean isImmuneToFire() {
        return true;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.SCORCHER;
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
        return LootTableRegistry.ENTITIES_SCORCHER;
    }
    public float getBrightness() {
        return 1.0F;
    }

    public void livingTick() {
        if (!this.onGround && this.getMotion().y < 0.0D) {
            this.setMotion(this.getMotion().mul(1.0D, 0.6D, 1.0D));
        }

        if (this.world.isRemote) {
            if (this.rand.nextInt(24) == 0 && !this.isSilent()) {
                this.world.playSound(this.getPosX() + 0.5D, this.getPosY() + 0.5D, this.getPosZ() + 0.5D, SoundEvents.ENTITY_BLAZE_BURN, this.getSoundCategory(), 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F, false);
            }

            for(int i = 0; i < 2; ++i) {
                this.world.addParticle(ParticleTypes.LARGE_SMOKE, this.getPosXRandom(0.5D), this.getPosYRandom(), this.getPosZRandom(0.5D), 0.0D, 0.0D, 0.0D);
            }
        } else {
            this.setAttackTarget(this.world.getClosestPlayer(this, 22.0D));
        }

        super.livingTick();
    }

    public boolean isWaterSensitive() {
        return true;
    }

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

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.6F;
    }
    public boolean onLivingFall(float distance, float damageMultiplier) {
        return false;
    }

    static class FireballAttackGoal extends Goal {
        private final EntityScorcher mob;
        private int attackStep;
        private int attackTime;
        private int firedRecentlyTimer;

        public FireballAttackGoal(EntityScorcher mob) {
            this.mob = mob;
            this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            LivingEntity livingentity = this.mob.getAttackTarget();
            return livingentity != null && livingentity.isAlive() && this.mob.canAttack(livingentity);
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
            this.firedRecentlyTimer = 0;
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            --this.attackTime;
            LivingEntity livingentity = this.mob.getAttackTarget();
            if (livingentity != null) {
                boolean flag = this.mob.getEntitySenses().canSee(livingentity);
                if (flag) {
                    this.firedRecentlyTimer = 0;
                } else {
                    ++this.firedRecentlyTimer;
                }

                double d0 = this.mob.getDistanceSq(livingentity);
                if (d0 < 4.0D) {
                    if (!flag) {
                        return;
                    }

                    if (this.attackTime <= 0) {
                        this.attackTime = 20;
                        this.mob.attackEntityAsMob(livingentity);
                    }

                    this.mob.getMoveHelper().setMoveTo(livingentity.getPosX(), livingentity.getPosY(), livingentity.getPosZ(), 1.0D);
                } else if (d0 < this.getFollowDistance() * this.getFollowDistance() && flag) {
                    double d1 = livingentity.getPosX() - this.mob.getPosX();
                    double d2 = livingentity.getPosYHeight(0.5D) - this.mob.getPosYHeight(0.5D);
                    double d3 = livingentity.getPosZ() - this.mob.getPosZ();
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
                            if (!this.mob.isSilent()) {
                                this.mob.world.playEvent((PlayerEntity)null, 1018, this.mob.getPosition(), 0);
                            }

                            for(int i = 0; i < 1; ++i) {
                                //TODO - scorcher projectile
                                SmallFireballEntity smallfireballentity = new SmallFireballEntity(this.mob.world, this.mob, d1 + this.mob.getRNG().nextGaussian() * (double)f, d2, d3 + this.mob.getRNG().nextGaussian() * (double)f);
                                smallfireballentity.setPosition(smallfireballentity.getPosX(), this.mob.getPosYHeight(0.5D) + 0.5D, smallfireballentity.getPosZ());
                                this.mob.world.addEntity(smallfireballentity);
                            }
                        }
                    }

                    this.mob.getLookController().setLookPositionWithEntity(livingentity, 10.0F, 10.0F);
                } else if (this.firedRecentlyTimer < 5) {
                    this.mob.getMoveHelper().setMoveTo(livingentity.getPosX(), livingentity.getPosY(), livingentity.getPosZ(), 1.0D);
                }

                super.tick();
            }
        }

        private double getFollowDistance() {
            return this.mob.getAttributeValue(Attributes.FOLLOW_RANGE);
        }
    }
}
