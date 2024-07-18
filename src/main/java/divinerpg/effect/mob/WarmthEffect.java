package divinerpg.effect.mob;

import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;

public class WarmthEffect extends MobEffect {
	public WarmthEffect() {super(MobEffectCategory.BENEFICIAL, 15899441);}
	@Override public void applyInstantenousEffect(Entity entity, Entity e, LivingEntity living, int i, double d) {}
//	@Override public boolean isDurationEffectTick(int i, int j) {return true;}
	@Override public boolean applyEffectTick(LivingEntity entity, int i) {
		if(entity.getTicksFrozen() > 0) entity.setTicksFrozen(0);
		return false;
	}
}