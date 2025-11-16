package divinerpg.items.base;

import divinerpg.compat.farmersdelight.DelightLoader;
import divinerpg.util.LocalizeUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionContents;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

import static net.neoforged.api.distmarker.Dist.CLIENT;

public class ItemModFoodEffect extends ItemModFood {
    private final FoodProperties food;
    //Stacks to 64
    public ItemModFoodEffect(FoodProperties food) {
        super(food);
        this.food = food;
    }
    //Stacks to 1 or 16
    public ItemModFoodEffect(boolean stacksToOne, FoodProperties food) {
        super(stacksToOne, food);
        this.food = food;
    }
    //Stacks to 64, instant consumption
    public ItemModFoodEffect(FoodProperties food, boolean instantConsumption) {
        super(food, instantConsumption);
        this.food = food;
    }
    //Stacks to 1 or 16, instant consumption
    public ItemModFoodEffect(boolean stacksToOne, FoodProperties food, boolean instantConsumption) {
        super(stacksToOne, food, instantConsumption);
        this.food = food;
    }
    @OnlyIn(CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, context, tooltip, flagIn);
        boolean tooltipAdded = false;
        if(DelightLoader.foodEffectTooltipEnabled()) {
            for(FoodProperties.PossibleEffect effect : food.effects()) {
                float chance = effect.probability();
                //Only shows the chance of the first effect
                if(chance < 1 && !tooltipAdded) tooltip.add(LocalizeUtils.i18n(ChatFormatting.GRAY, "chance", (int)(chance * 100)));
                tooltipAdded = true;
            } PotionContents.addPotionTooltip(food.effects().stream().map(FoodProperties.PossibleEffect::effect).toList(), tooltip::add, 1, context.tickRate());
        }
    }
}