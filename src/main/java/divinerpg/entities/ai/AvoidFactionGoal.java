package divinerpg.entities.ai;

import java.util.List;

import javax.annotation.Nullable;

import divinerpg.entities.base.FactionEntity.Faction;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.*;

public class AvoidFactionGoal<T extends LivingEntity> extends Goal {
	protected final PathfinderMob mob;
	protected final Faction myFaction;
	protected final float maxDist;
	protected final double walkSpeedModifier, sprintSpeedModifier;
	protected final TargetingConditions avoidingConditions;
	@Nullable protected T toAvoid;
	@Nullable protected Path path;
	protected final PathNavigation pathNav;
	public AvoidFactionGoal(PathfinderMob mob, Faction myFaction, float maxDist, double walkSpeedModifier, double sprintSpeedModifier) {
		this.mob = mob;
		this.myFaction = myFaction;
		this.maxDist = maxDist;
		this.walkSpeedModifier = walkSpeedModifier;
		this.sprintSpeedModifier = sprintSpeedModifier;
		pathNav = mob.getNavigation();
		avoidingConditions = TargetingConditions.forCombat().range(maxDist);
	}
	@SuppressWarnings("unchecked")
	public boolean canUse() {
		toAvoid = mob.level().getNearestEntity((List<? extends T>) mob.level().getEntities(mob, getTargetSearchArea(maxDist), (entity) -> entity instanceof LivingEntity ent && myFaction.isAgressiveTowards(ent)), avoidingConditions, mob, mob.getX(), mob.getY(), mob.getZ());
		if(toAvoid == null) return false;
		Vec3 vec3 = DefaultRandomPos.getPosAway(mob, 16, 7, toAvoid.position());
		if(vec3 == null || toAvoid.distanceToSqr(vec3) < toAvoid.distanceToSqr(mob)) return false;
		path = pathNav.createPath(vec3.x, vec3.y, vec3.z, 0);
		return path != null;
	}
	protected AABB getTargetSearchArea(double distance) {
		return mob.getBoundingBox().inflate(distance, distance / 2D, distance);
	}
	public boolean canContinueToUse() {
		return !pathNav.isDone();
	}
	public void start() {
		pathNav.moveTo(path, walkSpeedModifier);
	}
	public void stop() {
		toAvoid = null;
	}
	public void tick() {
		mob.getNavigation().setSpeedModifier(mob.distanceToSqr(toAvoid) < 49D ? sprintSpeedModifier : walkSpeedModifier);
	}
}