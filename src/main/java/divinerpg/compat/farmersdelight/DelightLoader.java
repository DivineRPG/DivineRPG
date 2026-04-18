package divinerpg.compat.farmersdelight;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.*;

import static vectorwing.farmersdelight.common.Configuration.*;
import static vectorwing.farmersdelight.common.registry.ModEffects.NOURISHMENT;

public class DelightLoader {
    public static Item create(Tier tier) {return new CookingKnife(tier);}
    public static MobEffectInstance getNourishmentEffect(int seconds) {
        return new MobEffectInstance(NOURISHMENT, seconds * 20, 0);
    }
    public static boolean foodEffectTooltipEnabled() {return ENABLE_FOOD_EFFECT_TOOLTIP.get();}
}