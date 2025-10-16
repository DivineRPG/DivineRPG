package divinerpg.effect.mob.armor.vanilla;

import divinerpg.effect.mob.armor.ArmorEffect;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;

public class SkelemanFeedEffect extends ArmorEffect {
	public SkelemanFeedEffect() {super(14926705);}
	@Override public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {return true;}
	@Override public boolean applyEffectTick(LivingEntity entity, int i) {
		if(entity instanceof ServerPlayer player && player.getFoodData().needsFood()) player.getFoodData().eat(1, 0);
        return true;
    }
}