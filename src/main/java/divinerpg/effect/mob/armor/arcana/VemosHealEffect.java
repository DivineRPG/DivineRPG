package divinerpg.effect.mob.armor.arcana;

import divinerpg.effect.mob.armor.ArmorEffect;
import net.minecraft.world.entity.LivingEntity;

public class VemosHealEffect extends ArmorEffect {
	public VemosHealEffect() {super(10991286);}
	@Override public void applyEffectTick(LivingEntity entity, int i) {
		float current = entity.getHealth();
        if((current > 0.0F) && (current < 20.0F)) entity.heal(.1F);
	}
}