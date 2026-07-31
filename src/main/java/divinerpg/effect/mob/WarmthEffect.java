package divinerpg.effect.mob;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class WarmthEffect extends MobEffect {
    public WarmthEffect() {super(MobEffectCategory.BENEFICIAL, 15899441);}
    @Override public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {return true;}
    @Override public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int i) {
        if(entity.getTicksFrozen() > 0) entity.setTicksFrozen(0);
        return true;
    }
}