package divinerpg.effect.mob.armor.base;

import divinerpg.effect.mob.armor.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class StepAssistEffect extends ArmorEffect implements UpdatableArmorEffect {
	public StepAssistEffect() {super(10991286);}
	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap map, int i) {
		super.addAttributeModifiers(entity, map, i);
		entity.setMaxUpStep(1.1F);
	}
	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap map, int i) {
		super.removeAttributeModifiers(entity, map, i);
		entity.setMaxUpStep(.6F);
	}
	@Override public boolean isDurationEffectTick(int i, int j) {return false;}
	@Override public void update(LivingEntity entity) {entity.setMaxUpStep(1.1F);}
}