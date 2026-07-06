package net.divinerpg.items.base;

import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import java.util.function.Consumer;

public class ItemModFoodEffect extends ItemModFood {
    private final FoodProperties food;
    public ItemModFoodEffect(FoodProperties food, Properties properties) {
        super(food, properties);
        this.food = food;
    }
    public ItemModFoodEffect(boolean stacksToOne, FoodProperties food, Properties properties) {
        super(stacksToOne, food, properties);
        this.food = food;
    }
    public ItemModFoodEffect(boolean stacksToOne, Item craftRemainder, FoodProperties food, Properties properties) {
        super(stacksToOne, craftRemainder, food, properties);
        this.food = food;
    }
    public ItemModFoodEffect(FoodProperties food, boolean instantConsumption, Properties properties) {
        super(food, instantConsumption, properties);
        this.food = food;
    }
    public ItemModFoodEffect(boolean stacksToOne, FoodProperties food, boolean instantConsumption, Properties properties) {
        super(stacksToOne, food, instantConsumption, properties);
        this.food = food;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltip, Consumer<Component> builder, TooltipFlag flagIn) {
        super.appendHoverText(stack, context, tooltip, builder, flagIn);
        //TODO - effect tooltips
        boolean tooltipAdded = false;
//        if(!ModList.get().isLoaded("farmersdelight") || DelightLoader.foodEffectTooltipEnabled()) {
//            for(FoodProperties.PossibleEffect effect : food.effects()) {
//                float chance = effect.probability();
//                //Only shows the chance of the first effect
//                if(chance < 1 && !tooltipAdded) tooltip.add(LocalizeUtils.i18n(ChatFormatting.GRAY, "chance", (int)(chance * 100)));
//                tooltipAdded = true;
//            } PotionContents.addPotionTooltip(food.effects().stream().map(FoodProperties.PossibleEffect::effect).toList(), tooltip::add, 1, context.tickRate());
//        }
    }
}