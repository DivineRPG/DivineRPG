package naturix.divinerpg.objects.items.vethea;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.enums.BulletType;
import naturix.divinerpg.enums.DiskType;
import naturix.divinerpg.objects.items.base.ItemThrowable;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemVetheanDisk extends ItemThrowable  {
    DiskType projectileType;
    public ItemVetheanDisk(String name, DiskType projectileType) {
        super(name, projectileType);
        this.setCreativeTab(DRPGCreativeTabs.vethea);
        this.projectileType=projectileType;
    }
    
    //FIXME - Still needs to spawn the returning entity
    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add(TooltipLocalizer.rangedDam(projectileType.getDamage()));
        list.add("Returns to sender");
        list.add(TooltipLocalizer.vethean());
    }

}
