package divinerpg.effect.mob.armor;

import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;

public abstract class ArmorEffect extends MobEffect {
	protected ArmorEffect(int color) {super(MobEffectCategory.BENEFICIAL, color);}
//	@Override public List<ItemStack> getCurativeItems() {return new ArrayList<ItemStack>();}
	@Override public void applyInstantenousEffect(Entity entity, Entity e, LivingEntity living, int i, double d) {}
}