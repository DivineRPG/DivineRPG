package divinerpg.effect.mob.armor.twilight;

import divinerpg.effect.mob.armor.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;

import static net.minecraft.world.effect.MobEffects.REGENERATION;

public class WildwoodHealEffect extends ArmorEffect {
	public WildwoodHealEffect() {super(1484773);}

	@Override public void onMobRemoved(LivingEntity entity, int amplifier, Entity.RemovalReason reason) {
		MobEffectInstance effect = entity.getEffect(REGENERATION);
		if(effect != null && effect.isInfiniteDuration()) entity.removeEffect(REGENERATION);
	}
	@Override public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {return true;}
	@Override public boolean applyEffectTick(LivingEntity entity, int i) {
		if(entity.isInWater()) {
            float current = entity.getHealth();
            if((current > 0) && (current < 20)) entity.heal(.25F);
        } if(entity.level().isRainingAt(entity.blockPosition())) entity.addEffect(new ArmorEffectInstance(REGENERATION, 1, true, true, true));
        else {
			MobEffectInstance effect = entity.getEffect(REGENERATION);
			if(effect != null && effect.isInfiniteDuration()) entity.removeEffect(REGENERATION);
		} return true;
	}
}