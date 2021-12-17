package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.particles.*;
import net.minecraft.pathfinding.*;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.*;
import net.minecraft.world.*;

import java.util.*;

public class EntityAequorea extends EntityDivineWaterMob {
    int colour;

    public EntityAequorea(EntityType<? extends EntityAequorea> type, World worldIn) {
        super(type, worldIn);
        colour = getRandom().nextInt(5);
    }


    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.3F;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(1, new MoveRandomGoal(this));
        goalSelector.addGoal(2, new StingAttack(this, EntityStats.aequoreaSpeed, false));
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.aequoreaHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.aequoreaDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.aequoreaSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.aequoreaFollowRange);
    }

    public int getColour() {
    return colour;
    }

    @Override
    public void tick() {
        if (level.isClientSide) {
            if (isInWater()) {
                Vector3d vec3d = getEyePosition(0.0F);
                for (int i = 0; i < 2; ++i)
                    level.addParticle(ParticleTypes.BUBBLE, getX() + (this.random.nextDouble() - 0.5D) * (double) this.getBbWidth() - vec3d.x * 1.5D, getY() + this.random.nextDouble() * (double) this.getBbHeight() - vec3d.y * 1.5D, getZ() + (this.random.nextDouble() - 0.5D) * (double) this.getBbWidth() - vec3d.z * 1.5D, 0.0D, 0.0D, 0.0D);
            }
        }

        if (isInWater()) {
            setAirSupply(300);
        } else if (onGround) {
            xRot = random.nextFloat() * 360.0F;
            onGround = false;
            this.jumping = true;
            if (level.getGameTime() % 5 == 0)
                level.playSound(null, getX(), getY(), getZ(), SoundEvents.GUARDIAN_FLOP, SoundCategory.HOSTILE, 1F, 1F);
            this.hurt(DamageSource.DROWN, 0.5F);
        }

        super.tick();
    }





    class MoveRandomGoal extends Goal {
        private final EntityAequorea jellyfish;

        public MoveRandomGoal(EntityAequorea jellyfish) {
            this.jellyfish = jellyfish;
        }

        public boolean canUse() {
            return true;
        }

        public void tick() {
            int i = this.jellyfish.getNoActionTime();
            if (i > 100) {
                this.jellyfish.setDeltaMovement(0.0F, 0.0F, 0.0F);
            } else if (this.jellyfish.getRandom().nextInt(50) == 0 || !this.jellyfish.isInWater() || !this.jellyfish.isMovementNoisy()) {
                float f = this.jellyfish.getRandom().nextFloat() * ((float)Math.PI * 2F);
                float f1 = MathHelper.cos(f) * 0.2F;
                float f2 = -0.1F + this.jellyfish.getRandom().nextFloat() * 0.1F;
                float f3 = MathHelper.sin(f) * 0.2F;
                this.jellyfish.setDeltaMovement(f1, f2, f3);
            }

        }
    }


     class StingAttack extends Goal {
        protected final CreatureEntity mob;
        private final double speedModifier;
        private final boolean followingTargetEvenIfNotSeen;
        private Path path;
        private double pathedTargetX;
        private double pathedTargetY;
        private double pathedTargetZ;
        private int ticksUntilNextPathRecalculation;
        private int ticksUntilNextAttack;
        private final int attackInterval = 20;
        private long lastCanUseCheck;
        private int failedPathFindingPenalty = 0;
        private boolean canPenalize = false;

        public StingAttack(CreatureEntity aequorea, double speed, boolean followAtAllCosts) {
            this.mob = aequorea;
            this.speedModifier = speed;
            this.followingTargetEvenIfNotSeen = followAtAllCosts;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        public boolean canUse() {
            long i = this.mob.level.getGameTime();
            if (i - this.lastCanUseCheck < 20L) {
                return false;
            } else {
                this.lastCanUseCheck = i;
                LivingEntity livingentity = this.mob.getTarget();
                if (livingentity == null) {
                    return false;
                } else if (!livingentity.isAlive()) {
                    return false;
                } else {
                    if (canPenalize) {
                        if (--this.ticksUntilNextPathRecalculation <= 0) {
                            this.path = this.mob.getNavigation().createPath(livingentity, 0);
                            this.ticksUntilNextPathRecalculation = 4 + this.mob.getRandom().nextInt(7);
                            return this.path != null;
                        } else {
                            return true;
                        }
                    }
                    this.path = this.mob.getNavigation().createPath(livingentity, 0);
                    if (this.path != null) {
                        return true;
                    } else {
                        return this.getAttackReachSqr(livingentity) >= this.mob.distanceToSqr(livingentity.getX(), livingentity.getY(), livingentity.getZ());
                    }
                }
            }
        }

        public boolean canContinueToUse() {
            LivingEntity livingentity = this.mob.getTarget();
            if (livingentity == null) {
                return false;
            } else if (!livingentity.isAlive()) {
                return false;
            } else if (!this.followingTargetEvenIfNotSeen) {
                return !this.mob.getNavigation().isDone();
            } else if (!this.mob.isWithinRestriction(livingentity.blockPosition())) {
                return false;
            } else {
                return !(livingentity instanceof PlayerEntity) || !livingentity.isSpectator() && !((PlayerEntity)livingentity).isCreative();
            }
        }

        public void start() {
            this.mob.getNavigation().moveTo(this.path, this.speedModifier);
            this.mob.setAggressive(true);
            this.ticksUntilNextPathRecalculation = 0;
            this.ticksUntilNextAttack = 0;
        }

        public void stop() {
            LivingEntity livingentity = this.mob.getTarget();
            if (!EntityPredicates.NO_CREATIVE_OR_SPECTATOR.test(livingentity)) {
                this.mob.setTarget((LivingEntity)null);
            }

            this.mob.setAggressive(false);
            this.mob.getNavigation().stop();
        }

        public void tick() {
            LivingEntity livingentity = this.mob.getTarget();
            this.mob.getLookControl().setLookAt(livingentity, 30.0F, 30.0F);
            double d0 = this.mob.distanceToSqr(livingentity.getX(), livingentity.getY(), livingentity.getZ());
            this.ticksUntilNextPathRecalculation = Math.max(this.ticksUntilNextPathRecalculation - 1, 0);
            if ((this.followingTargetEvenIfNotSeen || this.mob.getSensing().canSee(livingentity)) && this.ticksUntilNextPathRecalculation <= 0 && (this.pathedTargetX == 0.0D && this.pathedTargetY == 0.0D && this.pathedTargetZ == 0.0D || livingentity.distanceToSqr(this.pathedTargetX, this.pathedTargetY, this.pathedTargetZ) >= 1.0D || this.mob.getRandom().nextFloat() < 0.05F)) {
                this.pathedTargetX = livingentity.getX();
                this.pathedTargetY = livingentity.getY();
                this.pathedTargetZ = livingentity.getZ();
                this.ticksUntilNextPathRecalculation = 4 + this.mob.getRandom().nextInt(7);
                if (this.canPenalize) {
                    this.ticksUntilNextPathRecalculation += failedPathFindingPenalty;
                    if (this.mob.getNavigation().getPath() != null) {
                        net.minecraft.pathfinding.PathPoint finalPathPoint = this.mob.getNavigation().getPath().getEndNode();
                        if (finalPathPoint != null && livingentity.distanceToSqr(finalPathPoint.x, finalPathPoint.y, finalPathPoint.z) < 1)
                            failedPathFindingPenalty = 0;
                        else
                            failedPathFindingPenalty += 10;
                    } else {
                        failedPathFindingPenalty += 10;
                    }
                }
                if (d0 > 1024.0D) {
                    this.ticksUntilNextPathRecalculation += 10;
                } else if (d0 > 256.0D) {
                    this.ticksUntilNextPathRecalculation += 5;
                }

                if (!this.mob.getNavigation().moveTo(livingentity, this.speedModifier)) {
                    this.ticksUntilNextPathRecalculation += 15;
                }
            }

            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
            this.checkAndPerformAttack(livingentity, d0);
        }

        protected void checkAndPerformAttack(LivingEntity entity, double range) {
            double d0 = this.getAttackReachSqr(entity);
            if (range <= d0 && this.ticksUntilNextAttack <= 0) {
                this.resetAttackCooldown();
                this.mob.swing(Hand.MAIN_HAND);
                this.mob.doHurtTarget(entity);
                entity.addEffect(new EffectInstance(Effects.POISON, 3));
            }

        }

        protected void resetAttackCooldown() {
            this.ticksUntilNextAttack = 20;
        }


        protected double getAttackReachSqr(LivingEntity p_179512_1_) {
            return (double)(this.mob.getBbWidth() * 2.0F * this.mob.getBbWidth() * 2.0F + p_179512_1_.getBbWidth());
        }
    }

}