package divinerpg.objects.items;

import java.util.List;

import javax.annotation.Nullable;

import divinerpg.objects.items.base.ItemMod;
import divinerpg.utils.TooltipHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemNotReady extends ItemMod {
    public ItemNotReady(String name, CreativeTabs tab) {
        super(name);
        this.setCreativeTab(tab);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TooltipHelper.getInfoText("tooltip.not_done"));
    }
}
