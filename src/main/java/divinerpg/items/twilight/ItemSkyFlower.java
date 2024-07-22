package divinerpg.items.twilight;

import com.mojang.datafixers.util.Pair;
import divinerpg.items.base.ItemModFood;
import divinerpg.util.FoodList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.api.distmarker.*;
import java.util.*;

public class ItemSkyFlower extends ItemModFood {
    public ItemSkyFlower() {super(FoodList.SKY_FLOWER, true);}
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        stack.get(DataComponents.POTION_CONTENTS).addPotionTooltip(FoodList.SKY_FLOWER.effects().stream().map(Pair::getFirst).toList(), 1, context.tickRate());
        super.appendHoverText(stack, context, tooltip, flagIn);
    }
}