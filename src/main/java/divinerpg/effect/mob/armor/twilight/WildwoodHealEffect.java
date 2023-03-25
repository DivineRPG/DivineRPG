package divinerpg.effect.mob.armor.twilight;

import divinerpg.effect.mob.armor.ArmorEffect;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class WildwoodHealEffect extends ArmorEffect {
	public WildwoodHealEffect() {super(10991286);}
	@Override public void removeAttributeModifiers(LivingEntity entity, AttributeMap map, int i) {
		super.removeAttributeModifiers(entity, map, i);
		MobEffectInstance regen = entity.getEffect(MobEffects.REGENERATION);
		if(regen != null && regen.isInfiniteDuration()) entity.removeEffect(MobEffects.REGENERATION);
	}
	@Override public void applyEffectTick(LivingEntity entity, int i) {
		if(entity.isInWater()) {
            float current = entity.getHealth();
            if((current > 0F) && (current < 20F)) entity.heal(.25f);
        }
		if(entity.level.isRainingAt(entity.blockPosition())) entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 1, true, true, true));
        else {
        	MobEffectInstance regen = entity.getEffect(MobEffects.REGENERATION);
        	if(regen != null && regen.isInfiniteDuration()) entity.removeEffect(MobEffects.REGENERATION);
        }
	}
}