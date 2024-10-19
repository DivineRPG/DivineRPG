package divinerpg.effect.mob.armor.twilight;

import divinerpg.effect.mob.armor.*;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class WildwoodHealEffect extends ArmorEffect {
	public WildwoodHealEffect() {super(10991286);}

	@Override public void onMobRemoved(LivingEntity entity, int amplifier, Entity.RemovalReason reason) {
		super.onMobRemoved(entity, amplifier, reason);
		if(entity.getEffect(MobEffects.REGENERATION) instanceof ArmorEffectInstance) entity.removeEffect(MobEffects.REGENERATION);
	}

	@Override public boolean applyEffectTick(LivingEntity entity, int i) {
		if(entity.isInWater()) {
            float current = entity.getHealth();
            if((current > 0F) && (current < 20F)) entity.heal(.25f);
        } if(entity.level().isRainingAt(entity.blockPosition())) entity.addEffect(new ArmorEffectInstance(Holder.direct(MobEffects.REGENERATION.value()), 1, true, true, true));
        else if(entity.getEffect(MobEffects.REGENERATION) instanceof ArmorEffectInstance) entity.removeEffect(MobEffects.REGENERATION);
		return false;
	}
}