package divinerpg.items.twilight;

import divinerpg.items.base.ItemModFood;
import divinerpg.util.*;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.List;

public class ItemSkyFlower extends ItemModFood {
    public ItemSkyFlower() {super(FoodList.SKY_FLOWER, true);}
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.sky_flower.breath"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}