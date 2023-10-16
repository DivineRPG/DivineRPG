package divinerpg.effect.mob;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;

public class GruzzorlugTargetEffect extends MobEffect {
	public GruzzorlugTargetEffect() {super(MobEffectCategory.HARMFUL, 10991286);}
	@Override public boolean isDurationEffectTick(int i, int j) {return true;}
	@Override public void applyEffectTick(LivingEntity entity, int i) {
		if(entity.level() instanceof ServerLevel level) {
	        if(level.getDifficulty() == Difficulty.PEACEFUL) return;
	        //TODO: raids
//	        if(level.isVillage(entity.blockPosition())) level.getRaids().createOrExtendRaid(entity);
		}
	}
	@Override public void applyInstantenousEffect(Entity entity, Entity e, LivingEntity living, int i, double d) {}
}