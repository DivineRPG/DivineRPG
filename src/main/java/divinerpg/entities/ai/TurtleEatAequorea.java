package divinerpg.entities.ai;

import divinerpg.entities.vanilla.overworld.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.pathfinding.*;
import net.minecraft.util.*;

import java.util.*;

public class TurtleEatAequorea extends Goal {
    TurtleEntity turtle;
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

    public TurtleEatAequorea(TurtleEntity turtle, double speed, boolean followAtAllCosts) {
    this.turtle = turtle;
        this.speedModifier = speed;
        this.followingTargetEvenIfNotSeen = followAtAllCosts;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }


    public boolean canUse() {
        return turtle.getTarget() instanceof EntityAequorea;
    }

    public boolean canContinueToUse() {
        LivingEntity livingentity = this.turtle.getTarget();
        if (livingentity == null) {
            return false;
        } else if (!livingentity.isAlive()) {
            return false;
        } else if (!this.followingTargetEvenIfNotSeen) {
            return !this.turtle.getNavigation().isDone();
        } else if (!this.turtle.isWithinRestriction(livingentity.blockPosition())) {
            return false;
        } else {
            return !(livingentity instanceof PlayerEntity) || !livingentity.isSpectator() && !((PlayerEntity)livingentity).isCreative();
        }
    }

    public void start() {
        this.turtle.getNavigation().moveTo(this.path, this.speedModifier);
        this.turtle.setAggressive(true);
        this.ticksUntilNextPathRecalculation = 0;
        this.ticksUntilNextAttack = 0;
    }

    public void stop() {
        LivingEntity livingentity = this.turtle.getTarget();
        if (!EntityPredicates.NO_CREATIVE_OR_SPECTATOR.test(livingentity)) {
            this.turtle.setTarget((LivingEntity)null);
        }

        this.turtle.setAggressive(false);
        this.turtle.getNavigation().stop();
    }

    public void tick() {
        LivingEntity livingentity = this.turtle.getTarget();
        this.turtle.getLookControl().setLookAt(livingentity, 30.0F, 30.0F);
        double d0 = this.turtle.distanceToSqr(livingentity.getX(), livingentity.getY(), livingentity.getZ());
        this.ticksUntilNextPathRecalculation = Math.max(this.ticksUntilNextPathRecalculation - 1, 0);
        if ((this.followingTargetEvenIfNotSeen || this.turtle.getSensing().canSee(livingentity)) && this.ticksUntilNextPathRecalculation <= 0 && (this.pathedTargetX == 0.0D && this.pathedTargetY == 0.0D && this.pathedTargetZ == 0.0D || livingentity.distanceToSqr(this.pathedTargetX, this.pathedTargetY, this.pathedTargetZ) >= 1.0D || this.turtle.getRandom().nextFloat() < 0.05F)) {
            this.pathedTargetX = livingentity.getX();
            this.pathedTargetY = livingentity.getY();
            this.pathedTargetZ = livingentity.getZ();
            this.ticksUntilNextPathRecalculation = 4 + this.turtle.getRandom().nextInt(7);
            if (this.canPenalize) {
                this.ticksUntilNextPathRecalculation += failedPathFindingPenalty;
                if (this.turtle.getNavigation().getPath() != null) {
                    PathPoint finalPathPoint = this.turtle.getNavigation().getPath().getEndNode();
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

            if (!this.turtle.getNavigation().moveTo(livingentity, this.speedModifier)) {
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
            entity.hurt(new DamageSource("turtle"), entity.getHealth());
        }

    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = 20;
    }


    protected double getAttackReachSqr(LivingEntity p_179512_1_) {
        return (double)(this.turtle.getBbWidth() * 2.0F * this.turtle.getBbWidth() * 2.0F + p_179512_1_.getBbWidth());
    }
}
