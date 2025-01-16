package divinerpg.effect.mob;

import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;

public class FreezeReductionEffect extends InstantenousMobEffect {
	public FreezeReductionEffect() {super(MobEffectCategory.BENEFICIAL, 5813483);}
	@Override public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {return true;}
	@Override public void applyInstantenousEffect(Entity enitty, Entity e, LivingEntity living, int i,double d) {
		if(living.getTicksFrozen() > 0) living.setTicksFrozen(living.getTicksFrozen() / 4);
	}
}