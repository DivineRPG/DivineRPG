package TeamDivineRPG.divinerpg.util;

import net.minecraft.item.Food;
import net.minecraft.potion.*;

public class FoodList {
    public static final Food ADVANCED_MUSHROOM_STEW = (new Food.Builder()).hunger(10).saturation(0.5F).build();
    public static final Food BACON = (new Food.Builder()).hunger(2).saturation(2.0F).meat().build();
    public static final Food BOILED_EGG = (new Food.Builder()).hunger(4).saturation(0.5F).build();
    public static final Food CHEESE = (new Food.Builder()).hunger(2).saturation(0.2F).build();
    public static final Food CHICKEN_DINNER = (new Food.Builder()).hunger(20).saturation(0.5F).meat().build();
    public static final Food CHOCOLATE_LOG = (new Food.Builder()).hunger(4).saturation(1.0F).build();
    public static final Food DONUT = (new Food.Builder()).hunger(16).saturation(0.3F).build();
    public static final Food DREAM_CAKE = (new Food.Builder()).hunger(8).saturation(0.8F).build();
    public static final Food DREAM_CARROT = (new Food.Builder()).hunger(3).saturation(0.4F).build();
    public static final Food DREAM_MELON = (new Food.Builder()).hunger(6).saturation(0.8F).build();
    public static final Food DREAM_PIE = (new Food.Builder()).hunger(4).saturation(0.8F).build();
    public static final Food EMPOWERED_MEAT = (new Food.Builder()).hunger(10).saturation(1.0F).meat().build();
    public static final Food FRUIT_CAKE = (new Food.Builder()).hunger(16).saturation(0.2F).build();
    public static final Food HITCHAK = (new Food.Builder()).hunger(2).saturation(3.0F).build();
    public static final Food HONEYCHUNK = (new Food.Builder()).hunger(1).saturation(0.2F).build();
    public static final Food HONEYSUCKLE = (new Food.Builder()).hunger(1).saturation(0.2F).build();
    public static final Food HOT_PUMPKIN_PIE = (new Food.Builder()).hunger(10).saturation(0.4F).build();
    public static final Food PEPPERMINTS = (new Food.Builder()).hunger(1).saturation(0.3F).build();
    public static final Food PINFLY = (new Food.Builder()).hunger(2).saturation(0.3F).effect(new EffectInstance(Effects.SPEED, 10, 2), 1.0F).build();
    public static final Food RAW_EMPOWERED_MEAT = (new Food.Builder()).hunger(5).saturation(1.0F).meat().build();
    public static final Food SNOW_CONES = (new Food.Builder()).hunger(2).saturation(0.3F).build();
    public static final Food TOMATO = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    public static final Food WHITE_MUSHROOM = (new Food.Builder()).hunger(1).saturation(0.1F).build();
    public static final Food WINTERBERRY = (new Food.Builder()).hunger(4).saturation(1.0F).build();

    public static final Food ENRICHED_MAGIC_MEAT = (new Food.Builder()).hunger(7).saturation(1.0F).build();
    public static final Food MAGIC_MEAT = (new Food.Builder()).hunger(5).saturation(1.0F).build();
    public static final Food MOONBULB = (new Food.Builder()).hunger(1).saturation(2.0F).build();
    public static final Food PINK_GLOWBONE = (new Food.Builder()).hunger(3).saturation(2.0F).build();
    public static final Food PURPLE_GLOWBONE = (new Food.Builder()).hunger(3).saturation(2.0F).build();


    public static final Food EGG_NOG = (new Food.Builder()).hunger(4).saturation(1.5F).build();
    public static final Food FORBIDDEN_FRUIT = (new Food.Builder()).hunger(3).saturation(0.5F).effect(new EffectInstance(Effects.REGENERATION, 100, 3), 20).effect(new EffectInstance(Effects.WITHER, 120, 1), 40).effect(new EffectInstance(Effects.POISON, 300, 1), 10).build();
}
