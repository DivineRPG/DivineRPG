package divinerpg.objects.items.base;

import divinerpg.utils.LocalizeUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemFastFood extends ItemModFood {

    public ItemFastFood(int healAmount, float saturation, boolean isWolfFood, String name) {
        super(healAmount, saturation, isWolfFood, name);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        super.addInformation(item, worldIn, list, flagIn);
        list.add(LocalizeUtils.instantConsumption());
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 1;
    }

}
