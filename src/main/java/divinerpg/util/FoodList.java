package divinerpg.util;

import net.minecraft.world.effect.*;
import net.minecraft.world.food.*;

public class FoodList {
    public static final FoodProperties ADVANCED_MUSHROOM_STEW = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.5F).build();
    public static final FoodProperties BACON = (new FoodProperties.Builder()).nutrition(2).saturationMod(2.0F).meat().build();
    public static final FoodProperties BOILED_EGG = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.5F).build();
    public static final FoodProperties CHEESE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F).build();
    public static final FoodProperties CHICKEN_DINNER = (new FoodProperties.Builder()).nutrition(20).saturationMod(0.5F).build();
    public static final FoodProperties CHOCOLATE_LOG = (new FoodProperties.Builder()).nutrition(4).saturationMod(1.0F).build();
    public static final FoodProperties DONUT = (new FoodProperties.Builder()).nutrition(16).saturationMod(0.3F).build();
    public static final FoodProperties DREAM_CAKE = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.8F).build();
    public static final FoodProperties DREAM_CARROT = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.4F).build();
    public static final FoodProperties DREAM_MELON = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.8F).build();
    public static final FoodProperties DREAM_SWEETS = (new FoodProperties.Builder()).nutrition(2).saturationMod(0).build();
    public static final FoodProperties DREAM_SOURS = (new FoodProperties.Builder()).nutrition(8).saturationMod(0).build();
    public static final FoodProperties DREAM_PIE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.8F).build();
    public static final FoodProperties EMPOWERED_MEAT = (new FoodProperties.Builder()).nutrition(10).saturationMod(1.0F).meat().build();
    public static final FoodProperties FRUIT_CAKE = (new FoodProperties.Builder()).nutrition(16).saturationMod(0.2F).build();
    public static final FoodProperties HITCHAK = (new FoodProperties.Builder()).nutrition(2).saturationMod(3.0F).build();
    public static final FoodProperties HONEYCHUNK = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.2F).build();
    public static final FoodProperties HONEYSUCKLE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.2F).build();
    public static final FoodProperties HOT_PUMPKIN_PIE = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.4F).build();
    public static final FoodProperties PEPPERMINTS = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).build();
    public static final FoodProperties PINFLY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, 2), 1.0F).build();
    public static final FoodProperties RAW_EMPOWERED_MEAT = (new FoodProperties.Builder()).nutrition(5).saturationMod(1.0F).meat().build();
    public static final FoodProperties SNOW_CONES = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).build();
    public static final FoodProperties TOMATO = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).build();
    public static final FoodProperties WHITE_MUSHROOM = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).build();
    public static final FoodProperties WINTERBERRY = (new FoodProperties.Builder()).nutrition(4).saturationMod(1.0F).build();

    public static final FoodProperties ENRICHED_MAGIC_MEAT = (new FoodProperties.Builder()).nutrition(7).saturationMod(1.0F).meat().build();
    public static final FoodProperties MAGIC_MEAT = (new FoodProperties.Builder()).nutrition(5).saturationMod(1.0F).meat().build();
    public static final FoodProperties MOONBULB = (new FoodProperties.Builder()).nutrition(1).saturationMod(2.0F).build();
    public static final FoodProperties PINK_GLOWBONE = (new FoodProperties.Builder()).nutrition(3).saturationMod(2.0F).build();
    public static final FoodProperties PURPLE_GLOWBONE = (new FoodProperties.Builder()).nutrition(3).saturationMod(2.0F).build();

    public static final FoodProperties SKY_FLOWER = (new FoodProperties.Builder()).nutrition(1).saturationMod(1).build();

    public static final FoodProperties EGG_NOG = (new FoodProperties.Builder()).nutrition(4).saturationMod(1.5F).build();
    public static final FoodProperties RAW_SENG_MEAT = (new FoodProperties.Builder()).nutrition(4).saturationMod(1.75F).meat().build();
    public static final FoodProperties COOKED_SENG_STEAK = (new FoodProperties.Builder()).nutrition(8).saturationMod(2.5F).meat().build();
    public static final FoodProperties RAW_WOLPERTINGER_MEAT = (new FoodProperties.Builder()).nutrition(5).saturationMod(1.85F).meat().build();
    public static final FoodProperties COOKED_WOLPERTINGER_STEAK = (new FoodProperties.Builder()).nutrition(10).saturationMod(3.0F).meat().build();
    public static final FoodProperties FORBIDDEN_FRUIT = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.5F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 3), 20).effect(() -> new MobEffectInstance(MobEffects.WITHER, 120, 1), 40).effect(() -> new MobEffectInstance(MobEffects.POISON, 300, 1), 10).build();
}
