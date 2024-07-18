package divinerpg.effect.mob.armor.base;

import divinerpg.effect.mob.armor.ArmorEffect;
import net.minecraft.world.entity.LivingEntity;

public class PreventFallDamageEffect extends ArmorEffect {
	public PreventFallDamageEffect() {super(10991286);}
	@Override public boolean applyEffectTick(LivingEntity entity, int i) {
		if(entity.fallDistance > .1F) entity.fallDistance = .1F;
        return false;
    }
}