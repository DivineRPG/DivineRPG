package divinerpg.entities.goals;

import divinerpg.entities.vanilla.overworld.EntityAequorea;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.pathfinder.*;

import java.util.EnumSet;

import static divinerpg.registries.DamageRegistry.TURTLE;
import static net.minecraft.world.entity.EntitySelector.NO_CREATIVE_OR_SPECTATOR;

public class TurtleEatAequoreaGoal extends Goal {
    Turtle turtle;
    private final double speedModifier;
    private final boolean followingTargetEvenIfNotSeen;
    private Path path;
    private double pathedTargetX;
    private double pathedTargetY;
    private double pathedTargetZ;
    private int ticksUntilNextPathRecalculation;
    private int ticksUntilNextAttack;
//    private final int attackInterval = 20;
//    private long lastCanUseCheck;
    private int failedPathFindingPenalty = 0;
    //TODO: to add a hunting cooldown I guess
    public TurtleEatAequoreaGoal(Turtle turtle, double speed, boolean followAtAllCosts) {
        this.turtle = turtle;
        speedModifier = speed;
        followingTargetEvenIfNotSeen = followAtAllCosts;
        setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }
    @Override public boolean canUse() {return turtle.getTarget() instanceof EntityAequorea;}
    @Override public boolean canContinueToUse() {
        LivingEntity livingentity = turtle.getTarget();
        if(livingentity == null) return false;
        else if(!livingentity.isAlive()) return false;
        else if(!followingTargetEvenIfNotSeen) return !turtle.getNavigation().isDone();
        else if(!turtle.isWithinRestriction(livingentity.blockPosition())) return false;
        else return !(livingentity instanceof Player) || !livingentity.isSpectator() && !((Player)livingentity).isCreative();
    }
    @Override public void start() {
        turtle.getNavigation().moveTo(path, speedModifier);
        turtle.setAggressive(true);
        ticksUntilNextPathRecalculation = 0;
        ticksUntilNextAttack = 0;
    }
    @Override public void stop() {
        LivingEntity livingentity = turtle.getTarget();
        if(!NO_CREATIVE_OR_SPECTATOR.test(livingentity)) turtle.setTarget(null);
        turtle.setAggressive(false);
        turtle.getNavigation().stop();
    }
    @Override public void tick() {
        LivingEntity livingentity = turtle.getTarget();
        turtle.getLookControl().setLookAt(livingentity, 30, 30);
        double d0 = turtle.distanceToSqr(livingentity.getX(), livingentity.getY(), livingentity.getZ());
        ticksUntilNextPathRecalculation = Math.max(ticksUntilNextPathRecalculation - 1, 0);
        if((followingTargetEvenIfNotSeen || turtle.getSensing().hasLineOfSight(livingentity)) && ticksUntilNextPathRecalculation <= 0 && (pathedTargetX == 0 && pathedTargetY == 0 && pathedTargetZ == 0 || livingentity.distanceToSqr(pathedTargetX, pathedTargetY, pathedTargetZ) >= 1 || turtle.getRandom().nextFloat() < .05F)) {
            pathedTargetX = livingentity.getX();
            pathedTargetY = livingentity.getY();
            pathedTargetZ = livingentity.getZ();
            ticksUntilNextPathRecalculation = 4 + turtle.getRandom().nextInt(7);
            boolean canPenalize = false;
            if(canPenalize) {
                ticksUntilNextPathRecalculation += failedPathFindingPenalty;
                if(turtle.getNavigation().getPath() != null) {
                    Node finalPathPoint = turtle.getNavigation().getPath().getEndNode();
                    if(finalPathPoint != null && livingentity.distanceToSqr(finalPathPoint.x, finalPathPoint.y, finalPathPoint.z) < 1) failedPathFindingPenalty = 0;
                    else failedPathFindingPenalty += 10;
                } else failedPathFindingPenalty += 10;
            } if(d0 > 1024) ticksUntilNextPathRecalculation += 10;
            else if (d0 > 256) ticksUntilNextPathRecalculation += 5;
            if(!turtle.getNavigation().moveTo(livingentity, speedModifier)) ticksUntilNextPathRecalculation += 15;
        } ticksUntilNextAttack = Math.max(ticksUntilNextAttack - 1, 0);
        checkAndPerformAttack(livingentity, d0);
    }
    protected void checkAndPerformAttack(LivingEntity entity, double range) {
        double d0 = getAttackReachSqr(entity);
        if(range <= d0 && ticksUntilNextAttack <= 0) {
            resetAttackCooldown();
            entity.hurt(entity.level().damageSources().source(TURTLE.getKey()), entity.getHealth());
        }
    }
    protected void resetAttackCooldown() {ticksUntilNextAttack = 20;}
    protected double getAttackReachSqr(LivingEntity entity) {return turtle.getBbWidth() * 2 * turtle.getBbWidth() * 2 + entity.getBbWidth();}
}