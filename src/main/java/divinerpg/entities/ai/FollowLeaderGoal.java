package divinerpg.entities.ai;

import java.util.EnumSet;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

public class FollowLeaderGoal extends Goal {
	protected final Mob mob;
	protected final Class<? extends Mob> leader;
	protected final double speedModifier;
	protected final float stopDistance, areaSize;
	protected final Predicate<LivingEntity> followPredicate;
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
		followPredicate = (entity) -> entity != null && entity.getClass() == leader;
		navigation = mob.getNavigation();
		setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		conditions = TargetingConditions.forNonCombat().range(areaSize).selector(followPredicate);
	}
	public boolean canUse() {
		following = mob.level().getNearestEntity(leader, conditions, mob, stopDistance, speedModifier, areaSize, mob.getBoundingBox().inflate(areaSize));
		return following != null;
	}
	public boolean canContinueToUse() {
		return following != null && !navigation.isDone() && mob.distanceToSqr(following) > stopDistance * stopDistance;
	}
	public void start() {
		timetorecalcpath = 0;
		oldWaterCost = mob.getPathfindingMalus(BlockPathTypes.WATER);
		mob.setPathfindingMalus(BlockPathTypes.WATER, 0F);
	}
	public void stop() {
		following = null;
		navigation.stop();
		mob.setPathfindingMalus(BlockPathTypes.WATER, oldWaterCost);
	}
	public void tick() {
		if(following != null && !mob.isLeashed()) {
			mob.getLookControl().setLookAt(following, 10F, mob.getMaxHeadXRot());
			if(--timetorecalcpath <= 0) {
				timetorecalcpath = adjustedTickDelay(10);
				double dx = mob.getX() - following.getX(), dy = mob.getY() - following.getY(), dz = mob.getZ() - following.getZ(), dsquared = dx*dx+dy*dy+dz*dz;
				if(dsquared > stopDistance * stopDistance) navigation.moveTo(following, speedModifier);
				else {
					navigation.stop();
					LookControl lookcontrol = following.getLookControl();
					if(dsquared <= stopDistance || (lookcontrol.getWantedX() == mob.getX() && lookcontrol.getWantedY() == mob.getY() && lookcontrol.getWantedZ() == mob.getZ())) navigation.moveTo(mob.getX() + dx, mob.getY(), mob.getZ() + dz, speedModifier);
				}
			}
		}
	}
}