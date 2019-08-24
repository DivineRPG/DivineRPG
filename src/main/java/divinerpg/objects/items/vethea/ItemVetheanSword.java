package divinerpg.objects.items.vethea;

import divinerpg.objects.items.base.ItemModSword;
import divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemVetheanSword extends ItemModSword {
	ToolMaterial mat;
    public ItemVetheanSword(String name, ToolMaterial toolMaterial) {
        super(toolMaterial, name);
        setMaxDamage(-1);
//        setCreativeTab(DivineRPGTabs.vethea);
        mat = toolMaterial;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        if (item.getMaxDamage() != -1) list.add(TooltipLocalizer.usesRemaining(item.getMaxDamage() - item.getItemDamage()));
        else list.add(TooltipLocalizer.infiniteUses());
    	list.add(TooltipLocalizer.meleeDam(this.mat.getAttackDamage()+5));
        list.add(TooltipLocalizer.vethean());
    }
}