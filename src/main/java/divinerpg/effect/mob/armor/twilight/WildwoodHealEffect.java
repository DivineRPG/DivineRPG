package divinerpg.effect.mob.armor.twilight;

import divinerpg.effect.mob.armor.*;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class WildwoodHealEffect extends ArmorEffect {
	public WildwoodHealEffect() {super(10991286);}

	@Override public void onMobRemoved(LivingEntity entity, int amplifier, Entity.RemovalReason reason) {
		MobEffectInstance m = entity.getEffect(MobEffects.REGENERATION);
		if(m != null && m.isInfiniteDuration()) entity.removeEffect(MobEffects.REGENERATION);
	}
	@Override public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {return true;}
	@Override public boolean applyEffectTick(LivingEntity entity, int i) {
		if(entity.isInWater()) {
            float current = entity.getHealth();
            if((current > 0F) && (current < 20F)) entity.heal(.25f);
        } if(entity.level().isRainingAt(entity.blockPosition())) entity.addEffect(new ArmorEffectInstance(MobEffects.REGENERATION, 1, true, true, true));
        else {
			MobEffectInstance m = entity.getEffect(MobEffects.REGENERATION);
			if(m != null && m.isInfiniteDuration()) entity.removeEffect(MobEffects.REGENERATION);
		} return true;
	}
}