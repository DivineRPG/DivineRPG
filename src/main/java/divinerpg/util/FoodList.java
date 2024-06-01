package divinerpg.util;

import net.minecraft.world.effect.*;
import net.minecraft.world.food.FoodProperties;

public class FoodList {
    public static final FoodProperties ADVANCED_MUSHROOM_STEW = (new FoodProperties.Builder()).nutrition(10).saturationMod(.6F).build();
    public static final FoodProperties BACON = (new FoodProperties.Builder()).nutrition(1).saturationMod(.2F).meat().build();
    public static final FoodProperties BOILED_EGG = (new FoodProperties.Builder()).nutrition(4).saturationMod(.1F).build();
    public static final FoodProperties CHEESE = (new FoodProperties.Builder()).nutrition(4).saturationMod(.4F).build();
    public static final FoodProperties CHICKEN_DINNER = (new FoodProperties.Builder()).nutrition(20).saturationMod(.5F).build();
    public static final FoodProperties DONUT = (new FoodProperties.Builder()).nutrition(4).saturationMod(.5F).build();
    public static final FoodProperties HOT_PUMPKIN_PIE = (new FoodProperties.Builder()).nutrition(9).saturationMod(.3F).build();
    public static final FoodProperties TOMATO = (new FoodProperties.Builder()).nutrition(4).saturationMod(.3F).build();
    public static final FoodProperties WHITE_MUSHROOM = (new FoodProperties.Builder()).nutrition(2).saturationMod(.1F).build();

    //Iceika
    public static final FoodProperties EGG_NOG = (new FoodProperties.Builder()).nutrition(4).saturationMod(.8F).build();
    public static final FoodProperties CAULDRON_FLESH = new FoodProperties.Builder().nutrition(3).saturationMod(.3F).meat().effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 300, 0), .8F).build();
    public static final FoodProperties CHOCOLATE_LOG = (new FoodProperties.Builder()).nutrition(5).saturationMod(.7F).build();
    public static final FoodProperties FRUIT_CAKE = (new FoodProperties.Builder()).nutrition(8).saturationMod(.3F).build();
    public static final FoodProperties PEPPERMINTS = (new FoodProperties.Builder()).nutrition(1).saturationMod(.4F).build();
    public static final FoodProperties RAW_SENG_MEAT = (new FoodProperties.Builder()).nutrition(2).saturationMod(.3F).meat().build();
    public static final FoodProperties COOKED_SENG_STEAK = (new FoodProperties.Builder()).nutrition(5).saturationMod(.6F).meat().build();
    public static final FoodProperties SNOW_CONES = (new FoodProperties.Builder()).nutrition(3).saturationMod(.4F).build();
    public static final FoodProperties WINTERBERRY = (new FoodProperties.Builder()).nutrition(3).saturationMod(.1F).build();
    public static final FoodProperties RAW_WOLPERTINGER_MEAT = (new FoodProperties.Builder()).nutrition(3).saturationMod(.3F).meat().build();
    public static final FoodProperties COOKED_WOLPERTINGER_STEAK = (new FoodProperties.Builder()).nutrition(6).saturationMod(.6F).meat().build();

    //Arcana
    public static final FoodProperties HITCHAK = (new FoodProperties.Builder()).nutrition(4).saturationMod(.4F).build();
    public static final FoodProperties PINFLY = (new FoodProperties.Builder()).nutrition(4).saturationMod(.3F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 30, 2), 1).build();
    public static final FoodProperties WEAK_ARCANA_POTION = (new FoodProperties.Builder()).alwaysEat().build();
    public static final FoodProperties STRONG_ARCANA_POTION = (new FoodProperties.Builder()).alwaysEat().build();

    //Eden
    public static final FoodProperties RAW_EMPOWERED_MEAT = (new FoodProperties.Builder()).nutrition(3).saturationMod(.4F).meat().build();
    public static final FoodProperties EMPOWERED_MEAT = (new FoodProperties.Builder()).nutrition(7).saturationMod(1).meat().build();
    public static final FoodProperties FORBIDDEN_FRUIT = (new FoodProperties.Builder()).nutrition(4).saturationMod(.3F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 3), 1).effect(() -> new MobEffectInstance(MobEffects.WITHER, 120, 1), 1).effect(() -> new MobEffectInstance(MobEffects.POISON, 300, 1), 1).build();

    //Wildwood
    public static final FoodProperties MAGIC_MEAT = (new FoodProperties.Builder()).nutrition(5).saturationMod(.8F).meat().build();
    public static final FoodProperties MOONBULB = (new FoodProperties.Builder()).nutrition(3).saturationMod(.5F).build();

    //Apalachia
    public static final FoodProperties ENRICHED_MAGIC_MEAT = (new FoodProperties.Builder()).nutrition(7).saturationMod(.8F).meat().build();
    public static final FoodProperties PURPLE_GLOWBONE = (new FoodProperties.Builder()).nutrition(3).saturationMod(.5F).build();
    public static final FoodProperties PINK_GLOWBONE = (new FoodProperties.Builder()).nutrition(3).saturationMod(.5F).build();

    //Skythern
    public static final FoodProperties SKY_FLOWER = (new FoodProperties.Builder()).nutrition(3).saturationMod(.2F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0), 1).effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 600, 0), 1).build();

    //Vethea
    public static final FoodProperties DREAM_CAKE = (new FoodProperties.Builder()).nutrition(8).saturationMod(.8F).build();
    public static final FoodProperties DREAM_CARROT = (new FoodProperties.Builder()).nutrition(3).saturationMod(.6F).build();
    public static final FoodProperties DREAM_MELON = (new FoodProperties.Builder()).nutrition(6).saturationMod(.8F).build();
    public static final FoodProperties DREAM_PIE = (new FoodProperties.Builder()).nutrition(8).saturationMod(.3F).build();
    public static final FoodProperties DREAM_SWEETS = (new FoodProperties.Builder()).nutrition(2).saturationMod(0).build();
    public static final FoodProperties DREAM_SOURS = (new FoodProperties.Builder()).nutrition(8).saturationMod(0).build();
    public static final FoodProperties HONEYCHUNK = (new FoodProperties.Builder()).nutrition(1).saturationMod(.3F).build();
    public static final FoodProperties HONEYSUCKLE = (new FoodProperties.Builder()).nutrition(1).saturationMod(.3F).build();
}