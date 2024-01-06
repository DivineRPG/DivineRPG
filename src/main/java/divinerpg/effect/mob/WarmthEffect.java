package divinerpg.effect.mob;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class WarmthEffect extends MobEffect {
	public WarmthEffect() {super(MobEffectCategory.BENEFICIAL, 15899441);}
	@Override public void applyInstantenousEffect(Entity entity, Entity e, LivingEntity living, int i, double d) {}
	@Override public boolean isDurationEffectTick(int i, int j) {return true;}
	@Override public void applyEffectTick(LivingEntity entity, int i) {
		if(entity.getTicksFrozen() > 0) entity.setTicksFrozen(0);
	}
}