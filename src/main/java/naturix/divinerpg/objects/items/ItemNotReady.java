package naturix.divinerpg.objects.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemNotReady extends ItemBase {
    public ItemNotReady(String name, CreativeTabs tab) {
        super(name);
        this.setCreativeTab(tab);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("Not yet finished");
    }
}
