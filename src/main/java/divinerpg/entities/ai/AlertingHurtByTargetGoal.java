package divinerpg.entities.ai;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;

public class AlertingHurtByTargetGoal extends HurtByTargetGoal {
	public AlertingHurtByTargetGoal(PathfinderMob mob) {
		super(mob);
	}
	@Override
	public void start() {
		super.start();
		alertOthers();
		if(mob.isBaby()) stop();
	}
	@Override
	protected void alertOther(Mob mob, LivingEntity entity) {
		if(mob.getType().equals(this.mob.getType()) && !mob.isBaby()) super.alertOther(mob, entity);
	}
}