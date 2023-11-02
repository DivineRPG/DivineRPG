package divinerpg.effect.mob;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class FreezeReductionEffect extends MobEffect {
	public FreezeReductionEffect() {super(MobEffectCategory.BENEFICIAL, 5813483);}
	@Override public boolean isDurationEffectTick(int i, int j) {return false;}
	@Override public void applyEffectTick(LivingEntity entity, int i) {}
	@Override public boolean isInstantenous() {return true;}
	@Override public void applyInstantenousEffect(Entity enitty, Entity e, LivingEntity living, int i,double d) {
		if(living.getTicksFrozen() > 0) living.setTicksFrozen(living.getTicksFrozen() / 4);
	}
}