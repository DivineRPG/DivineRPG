package divinerpg.compat.farmersdelight;

import net.minecraft.world.effect.MobEffectInstance;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class EffectLoader {
    public static MobEffectInstance getComfortEffect(int seconds) {
        return new MobEffectInstance(ModEffects.COMFORT, seconds * 20, 0);
    }
    public static MobEffectInstance getNourishmentEffect(int seconds) {
        return new MobEffectInstance(ModEffects.NOURISHMENT, seconds * 20, 0);
    }
}