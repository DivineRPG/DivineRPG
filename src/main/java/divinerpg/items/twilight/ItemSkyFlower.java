package divinerpg.items.twilight;

import divinerpg.items.base.ItemModFood;
import divinerpg.util.FoodList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionContents;
import net.neoforged.api.distmarker.*;

import java.util.List;

public class ItemSkyFlower extends ItemModFood {
    public ItemSkyFlower() {super(FoodList.SKY_FLOWER, true);}
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        PotionContents.addPotionTooltip(FoodList.SKY_FLOWER.effects().stream().map(FoodProperties.PossibleEffect::effect).toList(), tooltip::add, 1, context.tickRate());
        super.appendHoverText(stack, context, tooltip, flagIn);
    }
}