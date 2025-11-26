package divinerpg.compat.brewinandchewin;

import net.minecraft.world.effect.MobEffectInstance;
import umpaz.brewinandchewin.common.registry.BnCEffects;

public class BrewinAndChewinLoader {
    public static MobEffectInstance getIntoxicationEffect(int seconds) {
        return new MobEffectInstance(BnCEffects.INTOXICATION, seconds * 20, 0);
    }
    public static MobEffectInstance getTipsyEffect(int seconds) {
        return new MobEffectInstance(BnCEffects.TIPSY, seconds * 20, 0);
    }
}