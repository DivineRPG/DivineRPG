package divinerpg.items.twilight;

import com.mojang.datafixers.util.Pair;
import divinerpg.items.base.ItemModFood;
import divinerpg.util.FoodList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.*;

public class ItemSkyFlower extends ItemModFood {
    public ItemSkyFlower() {super(FoodList.SKY_FLOWER, true);}
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        PotionUtils.addPotionTooltip(FoodList.SKY_FLOWER.getEffects().stream().map(Pair::getFirst).toList(), tooltip, 1);
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}