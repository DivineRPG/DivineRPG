package divinerpg.compat.farmersdelight;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.*;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class DelightLoader {
    public static Item create(Tier tier) {return new CookingKnife(tier);}
    public static MobEffectInstance getComfortEffect(int seconds) {
        return new MobEffectInstance(ModEffects.COMFORT, seconds * 20, 0);
    }
    public static MobEffectInstance getNourishmentEffect(int seconds) {
        return new MobEffectInstance(ModEffects.NOURISHMENT, seconds * 20, 0);
    }
    public static boolean foodEffectTooltipEnabled() {return Configuration.FOOD_EFFECT_TOOLTIP.get();}
}