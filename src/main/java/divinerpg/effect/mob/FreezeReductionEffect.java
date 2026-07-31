package divinerpg.effect.mob;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantaneousMobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jspecify.annotations.Nullable;

import static net.minecraft.world.effect.MobEffectCategory.BENEFICIAL;

public class FreezeReductionEffect extends InstantaneousMobEffect {
    public FreezeReductionEffect() {super(BENEFICIAL, 5813483);}
    @Override public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {return true;}

    @Override
    public void applyInstantaneousEffect(ServerLevel level, @Nullable Entity source, @Nullable Entity owner, LivingEntity mob, int amplification, double scale) {
        if(mob.getTicksFrozen() > 0) mob.setTicksFrozen(mob.getTicksFrozen() / 4);
    }
}