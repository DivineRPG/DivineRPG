package divinerpg.entities.goals;

import java.util.EnumSet;
import org.jspecify.annotations.Nullable;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.level.pathfinder.PathType;

public class FollowLeaderGoal extends Goal {
    protected final Mob mob;
    protected final Class<? extends Mob> leader;
    protected final double speedModifier;
    protected final float stopDistance, areaSize;
    protected final TargetingConditions.Selector followSelector;
    protected final PathNavigation navigation;
    protected final TargetingConditions conditions;
    @Nullable protected Mob following;
    protected int timetorecalcpath;
    protected float oldWaterCost;

    public FollowLeaderGoal(Mob mob, Class<? extends Mob> leader, double speedModifier, float stopDistance, float areaSize) {
        this.mob = mob;
        this.leader = leader;
        this.speedModifier = speedModifier;
        this.stopDistance = stopDistance;
        this.areaSize = areaSize;
        this.followSelector = (target, level) -> target != null && target.getClass() == leader;
        this.navigation = mob.getNavigation();
        setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        this.conditions = TargetingConditions.forNonCombat().range(areaSize).selector(followSelector);
    }

    @Override
    public boolean canUse() {
        if (mob.level() instanceof ServerLevel serverLevel) {
            following = serverLevel.getNearestEntity(
                    leader,
                    conditions,
                    mob,
                    mob.getX(),
                    mob.getY(),
                    mob.getZ(),
                    mob.getBoundingBox().inflate(areaSize)
            );
        } else {
            following = null;
        }
        return following != null;
    }

    @Override
    public boolean canContinueToUse() {
        return following != null && !navigation.isDone() && mob.distanceToSqr(following) > stopDistance * stopDistance;
    }

    @Override
    public void start() {
        timetorecalcpath = 0;
        oldWaterCost = mob.getPathfindingMalus(PathType.WATER);
        mob.setPathfindingMalus(PathType.WATER, 0F);
    }

    @Override
    public void stop() {
        following = null;
        navigation.stop();
        mob.setPathfindingMalus(PathType.WATER, oldWaterCost);
    }

    @Override
    public void tick() {
        if (following != null && !mob.isLeashed()) {
            mob.getLookControl().setLookAt(following, 10F, mob.getMaxHeadXRot());
            if (--timetorecalcpath <= 0) {
                timetorecalcpath = adjustedTickDelay(10);
                double dx = mob.getX() - following.getX();
                double dy = mob.getY() - following.getY();
                double dz = mob.getZ() - following.getZ();
                double dsquared = dx * dx + dy * dy + dz * dz;

                if (dsquared > stopDistance * stopDistance) {
                    navigation.moveTo(following, speedModifier);
                } else {
                    navigation.stop();
                    LookControl lookcontrol = following.getLookControl();
                    if (dsquared <= stopDistance || (lookcontrol.getWantedX() == mob.getX() && lookcontrol.getWantedY() == mob.getY() && lookcontrol.getWantedZ() == mob.getZ())) {
                        navigation.moveTo(mob.getX() + dx, mob.getY(), mob.getZ() + dz, speedModifier);
                    }
                }
            }
        }
    }
}