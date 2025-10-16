package divinerpg.effect.mob.armor.base;

import divinerpg.effect.mob.armor.ArmorEffect;
import net.minecraft.world.entity.LivingEntity;

import static net.minecraft.world.effect.MobEffects.POISON;

public class PoisonProtectionEffect extends ArmorEffect {
	public PoisonProtectionEffect() {super(4411962);}
	@Override public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {return true;}
	@Override public boolean applyEffectTick(LivingEntity entity, int i) {
		if(entity.hasEffect(POISON)) entity.removeEffect(POISON);
        return true;
    }
}