package divinerpg.effect.mob.armor.base;

import divinerpg.effect.mob.armor.ArmorEffect;
import net.minecraft.world.entity.LivingEntity;

import static net.minecraft.world.effect.MobEffects.WITHER;

public class WitherProtectionEffect extends ArmorEffect {
	public WitherProtectionEffect() {super(7868463);}
	@Override public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {return true;}
	@Override public boolean applyEffectTick(LivingEntity entity, int i) {
		if(entity.hasEffect(WITHER)) entity.removeEffect(WITHER);
        return true;
    }
}