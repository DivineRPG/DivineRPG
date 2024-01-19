package divinerpg.effect.mob.armor.base;

import com.google.common.collect.*;

import divinerpg.effect.mob.armor.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.*;
import net.neoforged.neoforge.common.NeoForgeMod;

public class StepAssistEffect extends ArmorEffect implements UpdatableArmorEffect {
	private static final String STEP_MOD_ID = "c7b490d7-2bfc-400f-b7bb-e89670dbea62";
	public static final AttributeModifier STEP_MOD = new AttributeModifier(STEP_MOD_ID, .6, AttributeModifier.Operation.ADDITION);
	public StepAssistEffect() {super(10991286);}

	@Override
	public void removeAttributeModifiers(AttributeMap map) {
		super.removeAttributeModifiers(map);
		AttributeInstance stepHeight = map.getInstance(NeoForgeMod.STEP_HEIGHT.value());
		if(stepHeight != null) stepHeight.removeModifier(STEP_MOD.getId());
	}

	@Override
	public void addAttributeModifiers(AttributeMap map, int i) {
		AttributeInstance stepHeight = map.getInstance(NeoForgeMod.STEP_HEIGHT.value());
		if(stepHeight == null) {
			Multimap<Attribute, AttributeModifier> attributes = ArrayListMultimap.create();
			attributes.put(NeoForgeMod.STEP_HEIGHT.value(), STEP_MOD);
			map.addTransientAttributeModifiers(attributes);
		} else stepHeight.addTransientModifier(STEP_MOD);
	}

	@Override public void update(LivingEntity entity) {
		AttributeMap map = entity.getAttributes();
		AttributeInstance stepHeight = map.getInstance(NeoForgeMod.STEP_HEIGHT.value());
		if(stepHeight == null) {
			Multimap<Attribute, AttributeModifier> attributes = ArrayListMultimap.create();
			attributes.put(NeoForgeMod.STEP_HEIGHT.value(), STEP_MOD);
			map.addTransientAttributeModifiers(attributes);
		} else if(stepHeight.getModifier(STEP_MOD.getId()) == null) stepHeight.addTransientModifier(STEP_MOD);
	}
	@Override public boolean isDurationEffectTick(int i, int j) {return false;}
}