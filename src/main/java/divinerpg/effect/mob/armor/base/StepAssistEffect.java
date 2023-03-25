package divinerpg.effect.mob.armor.base;

import divinerpg.effect.mob.armor.ArmorEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

@SuppressWarnings("deprecation")
public class StepAssistEffect extends ArmorEffect {
	public StepAssistEffect() {super(10991286);}
	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap map, int i) {
		super.addAttributeModifiers(entity, map, i);
		entity.maxUpStep = 1F;
	}
	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap map, int i) {
		super.removeAttributeModifiers(entity, map, i);
		entity.maxUpStep = .6F;
	}
	@Override public boolean isDurationEffectTick(int i, int j) {return false;}
}