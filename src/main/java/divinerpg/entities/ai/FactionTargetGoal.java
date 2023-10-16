package divinerpg.entities.ai;

import java.util.*;

import javax.annotation.Nullable;

import divinerpg.entities.base.FactionEntity.Faction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.phys.AABB;

public class FactionTargetGoal<T extends LivingEntity> extends TargetGoal {
	public static final int DEFAULT_RANDOM_INTERVAL = 10;
	@Nullable protected LivingEntity target;
	protected final int randomInterval;
	public final Faction myFaction;
	protected TargetingConditions targetConditions;
	public FactionTargetGoal(Mob mob, Faction faction, boolean mustSee, boolean mustReach) {
		this(mob, faction, mustSee, mustReach, DEFAULT_RANDOM_INTERVAL);
	}
	public FactionTargetGoal(Mob mob, Faction faction, boolean mustSee, boolean mustReach, int interval) {
		super(mob, mustSee, mustReach);
		myFaction = faction;
		randomInterval = reducedTickDelay(interval);
		setFlags(EnumSet.of(Goal.Flag.TARGET));
	    targetConditions = TargetingConditions.forCombat().range(getFollowDistance());
	}
	@Override
	public boolean canUse() {
		if(randomInterval > 0 && mob.getRandom().nextInt(randomInterval) != 0) return false;
		findTarget();
		return target != null;
	}
	@SuppressWarnings("unchecked")
	protected void findTarget() {
		target = mob.level().getNearestEntity((List<? extends T>) mob.level().getEntities(mob, getTargetSearchArea(getFollowDistance()), (entity) -> entity instanceof LivingEntity ent && myFaction.isAgressiveTowards(ent)), targetConditions, mob, mob.getX(), mob.getEyeY(), mob.getZ());
	}
	protected AABB getTargetSearchArea(double distance) {
		return mob.getBoundingBox().inflate(distance, distance / 2D, distance);
	}
	@Override
	public void start() {
		mob.setTarget(target);
		super.start();
	}
	public void setTarget(@Nullable LivingEntity entity) {
		target = entity;
	}
}