package divinerpg.effect.mob;

import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.entity.*;

import static net.minecraft.world.effect.MobEffectCategory.BENEFICIAL;

public class FreezeReductionEffect extends InstantenousMobEffect {
	public FreezeReductionEffect() {super(BENEFICIAL, 5813483);}
	@Override public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {return true;}
	@Override public void applyInstantenousEffect(Entity source, Entity indirectSource, LivingEntity living, int i, double d) {
		if(living.getTicksFrozen() > 0) living.setTicksFrozen(living.getTicksFrozen() / 4);
	}
}