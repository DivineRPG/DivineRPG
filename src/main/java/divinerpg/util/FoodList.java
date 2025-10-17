package divinerpg.util;

import divinerpg.compat.farmersdelight.EffectLoader;
import divinerpg.registries.MobEffectRegistry;
import net.minecraft.world.effect.*;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;
import net.neoforged.fml.ModList;

import java.util.Optional;

public class FoodList {
    public static final FoodProperties
    //Overworld
        BACON = foodBuilder(1, .2F).fast().build(),
        COOKED_BACON = foodBuilder(3, .6F).fast().build(),
        BOILED_EGG = food(4, .1F),
        CHEESE = food(4, .4F),
        DONUT = food(4, .5F),
        HOT_PUMPKIN_PIE = foodBuilder(9, .3F)
            .effect(() -> new MobEffectInstance(MobEffectRegistry.WARMTH, 10 * 20, 0), 1).build(),
        TOMATO = food(4, .3F),
        WHITE_MUSHROOM = food(2, .1F),
        ADVANCED_MUSHROOM_STEW = foodBuilder(10, .6F).usingConvertsTo(Items.BOWL)
            .effect(() -> {
                if(ModList.get().isLoaded("farmersdelight")) return EffectLoader.getComfortEffect(3 * 60);
                return new MobEffectInstance(MobEffects.REGENERATION, 5 * 20, 2);
            }, 1)
            .effect(() -> new MobEffectInstance(MobEffectRegistry.WARMTH, 20 * 20, 0), 1).build(),
        CHICKEN_DINNER = foodBuilder(16, .6F).usingConvertsTo(Items.BOWL)
            .effect(() -> {
                if(ModList.get().isLoaded("farmersdelight")) return EffectLoader.getNourishmentEffect(5 * 60);
                return new MobEffectInstance(MobEffects.REGENERATION, 10 * 20, 2);
            }, 1)
            .effect(() -> new MobEffectInstance(MobEffectRegistry.WARMTH, 40 * 20, 0), 1).build(),

    //Iceika
        CAULDRON_FLESH = foodBuilder(3, .3F)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 15 * 20, 0), .8F).build(),
        RAW_SENG_MEAT = food(2, .3F),
        COOKED_SENG_MEAT = food(5, .6F),
        RAW_WOLPERTINGER_MEAT = food(3, .3F),
        COOKED_WOLPERTINGER_MEAT = food(6, .6F),
        CHOCOLATE_LOG = food(5, .7F),
        EGG_NOG = foodBuilder(4, .8F).usingConvertsTo(Items.BUCKET)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 12 * 20, 0), 1)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 12 * 20, 0), 1).build(),
        FRUIT_CAKE = food(8, .3F),
        PEPPERMINTS = foodBuilder(1, .4F).fast().build(),
        SNOW_CONES = food(3, .4F),
        WINTERBERRY = foodBuilder(3, .1F).build(),

    //Arcana
        HITCHAK = food(4, .4F),
        LAMONA = food(4, .4F),
        PINFLY = foodBuilder(4, .3F).fast()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3 * 20, 2), 1).build(),
        VEILO = foodBuilder(4, .3F).fast()
            .effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 3 * 20, 0), 1).build(),
        WEAK_ARCANA_POTION = new FoodProperties.Builder().alwaysEdible().fast().build(),
        STRONG_ARCANA_POTION = new FoodProperties.Builder().alwaysEdible().fast().build(),

    //Eden
        RAW_EMPOWERED_MEAT = food(3, .4F),
        EMPOWERED_MEAT = food(7, 1),
        FORBIDDEN_FRUIT = foodBuilder(4, .3F).alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 5 * 20, 3), 1)
            .effect(() -> new MobEffectInstance(MobEffects.WITHER, 6 * 20, 1), 1)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 15 * 20, 1), 1).build(),

    //Wildwood
        MAGIC_MEAT = food(5, .8F),
        MOONBULB = foodBuilder(3, .5F)
            .effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 6 * 20, 0), .5F).build(),

    //Apalachia
        ENRICHED_MAGIC_MEAT = food(7, .8F),
        PURPLE_GLOWBONE = foodBuilder(1, 0)
            .effect(() -> new MobEffectInstance(MobEffectRegistry.WITHER_PROTECTION, 5 * 20, 0), 1)
            .effect(() -> new MobEffectInstance(MobEffectRegistry.POISON_PROTECTION, 5 * 20, 0), 1).build(),
        PINK_GLOWBONE = foodBuilder(1, 0)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 4 * 20, 2), .7F).build(),

    //Skythern
        SKY_FLOWER = foodBuilder(1, 0)
            .effect(() -> new MobEffectInstance(MobEffectRegistry.PREVENT_FALL_DAMAGE, 30 * 20, 0), .6F).build(),

    //Vethea
        HONEYSUCKLE = foodBuilder(1, .3F).fast()
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 12 * 20, 0), .45F).build(),
        HONEYCHUNK = foodBuilder(1, .3F).fast()
            .effect(() -> new MobEffectInstance(MobEffectRegistry.KORMA_ARCANA, 4 * 20, 0), .45F).build(),
        DREAM_CARROT = food(3, .6F),
        DREAM_MELON = food(6, .8F),
        DREAM_PIE = food(8, .3F),
        DREAM_CAKE = food(8, .8F),
        DREAM_SWEETS = foodBuilder(1, 0).fast().alwaysEdible().build(),
        DREAM_SOURS = foodBuilder(4, 0).fast().alwaysEdible().build();

    public static FoodProperties food(int nutrition, float saturation) {
        return new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation).build();
    }
    public static FoodProperties.Builder foodBuilder(int nutrition, float saturation) {
        return new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation);
    }
}