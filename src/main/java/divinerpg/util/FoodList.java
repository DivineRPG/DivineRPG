package divinerpg.util;

import net.minecraft.world.effect.*;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class FoodList {
    public static final FoodProperties
        ADVANCED_MUSHROOM_STEW = (new FoodProperties.Builder()).usingConvertsTo(Items.BOWL).nutrition(10).saturationModifier(.6F).build(),
        BACON = (new FoodProperties.Builder()).nutrition(1).saturationModifier(.2F).build(),
        BOILED_EGG = (new FoodProperties.Builder()).nutrition(4).saturationModifier(.1F).build(),
        CHEESE = (new FoodProperties.Builder()).nutrition(4).saturationModifier(.4F).build(),
        CHICKEN_DINNER = (new FoodProperties.Builder()).usingConvertsTo(Items.BOWL).nutrition(20).saturationModifier(.5F).build(),
        DONUT = (new FoodProperties.Builder()).nutrition(4).saturationModifier(.5F).build(),
        HOT_PUMPKIN_PIE = (new FoodProperties.Builder()).nutrition(9).saturationModifier(.3F).build(),
        TOMATO = (new FoodProperties.Builder()).nutrition(4).saturationModifier(.3F).build(),
        WHITE_MUSHROOM = (new FoodProperties.Builder()).nutrition(2).saturationModifier(.1F).build(),

    //Iceika
        EGG_NOG = (new FoodProperties.Builder()).usingConvertsTo(Items.BUCKET).nutrition(4).saturationModifier(.8F).build(),
        CAULDRON_FLESH = new FoodProperties.Builder().nutrition(3).saturationModifier(.3F)
                .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 300, 0), .8F).build(),
        CHOCOLATE_LOG = (new FoodProperties.Builder()).nutrition(5).saturationModifier(.7F).build(),
        FRUIT_CAKE = (new FoodProperties.Builder()).nutrition(8).saturationModifier(.3F).build(),
        PEPPERMINTS = (new FoodProperties.Builder()).nutrition(1).saturationModifier(.4F).build(),
        RAW_SENG_MEAT = (new FoodProperties.Builder()).nutrition(2).saturationModifier(.3F).build(),
        COOKED_SENG_STEAK = (new FoodProperties.Builder()).nutrition(5).saturationModifier(.6F).build(),
        SNOW_CONES = (new FoodProperties.Builder()).nutrition(3).saturationModifier(.4F).build(),
        WINTERBERRY = (new FoodProperties.Builder()).nutrition(3).saturationModifier(.1F).build(),
        RAW_WOLPERTINGER_MEAT = (new FoodProperties.Builder()).nutrition(3).saturationModifier(.3F).build(),
        COOKED_WOLPERTINGER_STEAK = (new FoodProperties.Builder()).nutrition(6).saturationModifier(.6F).build(),

    //Arcana
        HITCHAK = (new FoodProperties.Builder()).nutrition(4).saturationModifier(.4F).build(),
        PINFLY = (new FoodProperties.Builder()).nutrition(4).saturationModifier(.3F)
                .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 30, 2), 1).build(),
        WEAK_ARCANA_POTION = (new FoodProperties.Builder()).alwaysEdible().build(),
        STRONG_ARCANA_POTION = (new FoodProperties.Builder()).alwaysEdible().build(),

    //Eden
        RAW_EMPOWERED_MEAT = (new FoodProperties.Builder()).nutrition(3).saturationModifier(.4F).build(),
        EMPOWERED_MEAT = (new FoodProperties.Builder()).nutrition(7).saturationModifier(1).build(),
        FORBIDDEN_FRUIT = (new FoodProperties.Builder()).nutrition(4).saturationModifier(.3F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 3), 1)
            .effect(() -> new MobEffectInstance(MobEffects.WITHER, 120, 1), 1)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 300, 1), 1).build(),

    //Wildwood
        MAGIC_MEAT = (new FoodProperties.Builder()).nutrition(5).saturationModifier(.8F).build(),
        MOONBULB = (new FoodProperties.Builder()).nutrition(3).saturationModifier(.5F).build(),

    //Apalachia
        ENRICHED_MAGIC_MEAT = (new FoodProperties.Builder()).nutrition(7).saturationModifier(.8F).build(),
        PURPLE_GLOWBONE = (new FoodProperties.Builder()).nutrition(3).saturationModifier(.5F).build(),
        PINK_GLOWBONE = (new FoodProperties.Builder()).nutrition(3).saturationModifier(.5F).build(),

    //Skythern
        SKY_FLOWER = (new FoodProperties.Builder()).nutrition(3).saturationModifier(.2F)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0), 1)
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 600, 0), 1).build(),

    //Vethea
        DREAM_CAKE = (new FoodProperties.Builder()).nutrition(8).saturationModifier(.8F).build(),
        DREAM_CARROT = (new FoodProperties.Builder()).nutrition(3).saturationModifier(.6F).build(),
        DREAM_MELON = (new FoodProperties.Builder()).nutrition(6).saturationModifier(.8F).build(),
        DREAM_PIE = (new FoodProperties.Builder()).nutrition(8).saturationModifier(.3F).build(),
        DREAM_SWEETS = (new FoodProperties.Builder()).nutrition(2).saturationModifier(0).build(),
        DREAM_SOURS = (new FoodProperties.Builder()).nutrition(8).saturationModifier(0).build(),
        HONEYCHUNK = (new FoodProperties.Builder()).nutrition(1).saturationModifier(.3F).build(),
        HONEYSUCKLE = (new FoodProperties.Builder()).nutrition(1).saturationModifier(.3F).build();
}