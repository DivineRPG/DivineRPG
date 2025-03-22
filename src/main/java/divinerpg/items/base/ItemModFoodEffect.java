package divinerpg.items.base;

import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionContents;
import net.neoforged.api.distmarker.*;

import java.util.List;

public class ItemModFoodEffect extends ItemModFood {
    FoodProperties food;
    public ItemModFoodEffect(FoodProperties food, boolean fastFood) {
        super(food, fastFood);
        this.food = food;
    }
    public ItemModFoodEffect(FoodProperties food) {
        super(food);
        this.food = food;
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        PotionContents.addPotionTooltip(food.effects().stream().map(FoodProperties.PossibleEffect::effect).toList(), tooltip::add, 1, context.tickRate());
        super.appendHoverText(stack, context, tooltip, flagIn);
    }
}