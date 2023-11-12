package divinerpg.entities.ai;

import java.util.function.Predicate;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;

public class ProtectBabyFromPlayerGoal extends NearestAttackableTargetGoal<Player> {
	public ProtectBabyFromPlayerGoal(Mob mob) {
		super(mob, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
	}
	@SuppressWarnings("resource") @Override
	public boolean canUse() {
		if(mob.isBaby()) return false;
		if(super.canUse()) for(Mob m : mob.level().getEntitiesOfClass(mob.getClass(), mob.getBoundingBox().inflate(8D, 4D, 8D))) if(m.isBaby()) return true;
		return false;
	}
}