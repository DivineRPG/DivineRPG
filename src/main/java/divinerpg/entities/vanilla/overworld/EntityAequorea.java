package divinerpg.entities.vanilla.overworld;

import net.minecraft.core.particles.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.Path;

import java.util.EnumSet;

public class EntityAequorea extends Squid {
	private static final EntityDataAccessor<Byte> VARIANT = SynchedEntityData.defineId(Mob.class, EntityDataSerializers.BYTE);
	public EntityAequorea(EntityType<EntityAequorea> type, Level level) {
		super(type, level);
		if(!level.isClientSide()) entityData.set(VARIANT, (byte) getRandom().nextInt(6));
	}
	@Override
    protected void defineSynchedData() {
		super.defineSynchedData();
    	entityData.define(VARIANT, (byte)0);
	}
	@Override
	protected float getStandingEyeHeight(Pose p_29975_, EntityDimensions p_29976_) {
		return 0.25F;
	}
	@Override
	protected void registerGoals() {
		goalSelector.addGoal(1, new RandomMovementGoal(this));
		goalSelector.addGoal(2, new StingAttack(this, getAttributeBaseValue(Attributes.MOVEMENT_SPEED), false));
	    goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
	    targetSelector.addGoal(1, new HurtByTargetGoal(this));
	    targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
	}
	public byte getColor() {
		return entityData.get(VARIANT);
	}
	@Override
	protected ParticleOptions getInkParticle() {
		return ParticleTypes.SPLASH;
	}
	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putByte("color_variant", entityData.get(VARIANT));
	}
	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		entityData.set(VARIANT, tag.contains("color_variant") ? tag.getByte("color_variant") : (byte) getRandom().nextInt(6));
	}
	class RandomMovementGoal extends Goal {
	      private final EntityAequorea aequorea;

	      public RandomMovementGoal(EntityAequorea entity) {
	         this.aequorea = entity;
	      }

	      public boolean canUse() {
	         return true;
	      }

	      public void tick() {
	         int i = this.aequorea.getNoActionTime();
	         if (i > 100) {
	            this.aequorea.setMovementVector(0.0F, 0.0F, 0.0F);
	         } else if (this.aequorea.getRandom().nextInt(reducedTickDelay(50)) == 0 || !this.aequorea.wasTouchingWater || !this.aequorea.hasMovementVector()) {
	            float f = this.aequorea.getRandom().nextFloat() * ((float)Math.PI * 2F);
	            float f1 = Mth.cos(f) * 0.2F;
	            float f2 = -0.1F + this.aequorea.getRandom().nextFloat() * 0.2F;
	            float f3 = Mth.sin(f) * 0.2F;
	            this.aequorea.setMovementVector(f1, f2, f3);
	         }
	      }
	 }
     class StingAttack extends Goal {
        protected final PathfinderMob mob;
        private final double speedModifier;
        private final boolean followingTargetEvenIfNotSeen;
        private Path path;
        private double pathedTargetX;
        private double pathedTargetY;
        private double pathedTargetZ;
        private int ticksUntilNextPathRecalculation;
        private int ticksUntilNextAttack;
//        private final int attackInterval = 20;
        private long lastCanUseCheck;
        private int failedPathFindingPenalty = 0;
        private boolean canPenalize = false;

        public StingAttack(PathfinderMob aequorea, double speed, boolean followAtAllCosts) {
            this.mob = aequorea;
            this.speedModifier = speed;
            this.followingTargetEvenIfNotSeen = followAtAllCosts;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        public boolean canUse() {
            long i = this.mob.level().getGameTime();
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
                return !(livingentity instanceof Player) || !livingentity.isSpectator() && !((Player)livingentity).isCreative();
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
            if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(livingentity)) {
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
            if ((this.followingTargetEvenIfNotSeen || this.mob.getSensing().hasLineOfSight(livingentity)) && this.ticksUntilNextPathRecalculation <= 0 && (this.pathedTargetX == 0.0D && this.pathedTargetY == 0.0D && this.pathedTargetZ == 0.0D || livingentity.distanceToSqr(this.pathedTargetX, this.pathedTargetY, this.pathedTargetZ) >= 1.0D || this.mob.getRandom().nextFloat() < 0.05F)) {
                this.pathedTargetX = livingentity.getX();
                this.pathedTargetY = livingentity.getY();
                this.pathedTargetZ = livingentity.getZ();
                this.ticksUntilNextPathRecalculation = 4 + this.mob.getRandom().nextInt(7);
                if (this.canPenalize) {
                    this.ticksUntilNextPathRecalculation += failedPathFindingPenalty;
                    if (this.mob.getNavigation().getPath() != null) {
                        net.minecraft.world.level.pathfinder.Node finalPathPoint = this.mob.getNavigation().getPath().getEndNode();
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
                this.mob.swing(InteractionHand.MAIN_HAND);
                this.mob.doHurtTarget(entity);
                entity.addEffect(new MobEffectInstance(MobEffects.POISON, 3));
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