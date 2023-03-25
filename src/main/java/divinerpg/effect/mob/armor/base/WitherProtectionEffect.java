package divinerpg.effect.mob.armor.base;

import divinerpg.effect.mob.armor.ArmorEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class WitherProtectionEffect extends ArmorEffect {
	public WitherProtectionEffect() {super(10991286);}
	@Override public void applyEffectTick(LivingEntity entity, int i) {
		if(entity.hasEffect(MobEffects.WITHER)) entity.removeEffect(MobEffects.WITHER);
	}
}