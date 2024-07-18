package divinerpg.effect.mob.armor.base;

import divinerpg.effect.mob.armor.ArmorEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class PoisonProtectionEffect extends ArmorEffect {
	public PoisonProtectionEffect() {super(10991286);}
	@Override public boolean applyEffectTick(LivingEntity entity, int i) {
		if(entity.hasEffect(MobEffects.POISON)) entity.removeEffect(MobEffects.POISON);
        return false;
    }
}