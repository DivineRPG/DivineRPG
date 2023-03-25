package divinerpg.effect.mob.armor;

import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;

public abstract class ArmorEffect extends MobEffect {
	protected ArmorEffect(int color) {super(MobEffectCategory.BENEFICIAL, color);}
	@Override public void applyEffectTick(LivingEntity entity, int i) {}
	@Override public void applyInstantenousEffect(Entity entity, Entity e, LivingEntity living, int i, double d) {}
	@Override public boolean isDurationEffectTick(int i, int j) {return true;}
}