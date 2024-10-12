package divinerpg.effect.mob.armor.base;

import com.google.common.collect.*;

import divinerpg.effect.mob.armor.*;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.*;

public class StepAssistEffect extends ArmorEffect implements UpdatableArmorEffect {
	public static final AttributeModifier STEP_MOD = new AttributeModifier(Attributes.STEP_HEIGHT.getKey().location(), .6, AttributeModifier.Operation.ADD_VALUE);
	public StepAssistEffect() {super(10991286);}
	@Override public void addAttributeModifiers(AttributeMap map, int i) {
		super.addAttributeModifiers(map, i);
		AttributeInstance stepHeight = map.getInstance(Attributes.STEP_HEIGHT);
		if(stepHeight == null) {
			Multimap<Holder<Attribute>, AttributeModifier> attributes = ArrayListMultimap.create();
			attributes.put(Attributes.STEP_HEIGHT, STEP_MOD);
			map.addTransientAttributeModifiers(attributes);
		} else stepHeight.addTransientModifier(STEP_MOD);
	}
	@Override public void removeAttributeModifiers(AttributeMap map) {
		super.removeAttributeModifiers(map);
		AttributeInstance stepHeight = map.getInstance(Attributes.STEP_HEIGHT);
		if(stepHeight != null) stepHeight.removeModifier(STEP_MOD);
	}
	@Override public void update(LivingEntity entity) {
		AttributeMap map = entity.getAttributes();
		AttributeInstance stepHeight = map.getInstance(Attributes.STEP_HEIGHT);
		if(stepHeight == null) {
			Multimap<Holder<Attribute>, AttributeModifier> attributes = ArrayListMultimap.create();
			attributes.put(Attributes.STEP_HEIGHT, STEP_MOD);
			map.addTransientAttributeModifiers(attributes);
		} else if(stepHeight.getModifier(STEP_MOD.id()) == null) stepHeight.addTransientModifier(STEP_MOD);
	}
//	@Override public boolean isDurationEffectTick(int i, int j) {return false;}
}