package divinerpg.effect.mob.armor.base;

import com.google.common.collect.*;

import divinerpg.effect.mob.armor.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraftforge.common.ForgeMod;

public class StepAssistEffect extends ArmorEffect implements UpdatableArmorEffect {
	private static final String STEP_MOD_ID = "c7b490d7-2bfc-400f-b7bb-e89670dbea62";
	public static final AttributeModifier STEP_MOD = new AttributeModifier(STEP_MOD_ID, .6, AttributeModifier.Operation.ADDITION);
	public StepAssistEffect() {super(10991286);}
	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap map, int i) {
		super.addAttributeModifiers(entity, map, i);
		AttributeInstance stepHeight = map.getInstance(ForgeMod.STEP_HEIGHT_ADDITION.get());
		if(stepHeight == null) {
			Multimap<Attribute, AttributeModifier> attributes = ArrayListMultimap.create();
			attributes.put(ForgeMod.STEP_HEIGHT_ADDITION.get(), STEP_MOD);
			map.addTransientAttributeModifiers(attributes);
		} else stepHeight.addTransientModifier(STEP_MOD);
	}
	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap map, int i) {
		super.removeAttributeModifiers(entity, map, i);
		AttributeInstance stepHeight = map.getInstance(ForgeMod.STEP_HEIGHT_ADDITION.get());
		if(stepHeight != null) stepHeight.removeModifier(STEP_MOD);
	}
	@Override public void update(LivingEntity entity) {
		AttributeMap map = entity.getAttributes();
		AttributeInstance stepHeight = map.getInstance(ForgeMod.STEP_HEIGHT_ADDITION.get());
		if(stepHeight == null) {
			Multimap<Attribute, AttributeModifier> attributes = ArrayListMultimap.create();
			attributes.put(ForgeMod.STEP_HEIGHT_ADDITION.get(), STEP_MOD);
			map.addTransientAttributeModifiers(attributes);
		} else if(stepHeight.getModifier(STEP_MOD.getId()) == null) stepHeight.addTransientModifier(STEP_MOD);
	}
	@Override public boolean isDurationEffectTick(int i, int j) {return false;}
}