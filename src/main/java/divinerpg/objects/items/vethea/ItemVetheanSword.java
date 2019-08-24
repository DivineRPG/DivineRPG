package divinerpg.objects.items.vethea;

import java.util.List;

import javax.annotation.Nullable;

import divinerpg.objects.items.base.ItemModSword;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemVetheanSword extends ItemModSword {
	ToolMaterial mat;
    public ItemVetheanSword(String name, ToolMaterial toolMaterial) {
        super(toolMaterial, name);
        setMaxDamage(-1);
        setCreativeTab(DivineRPGTabs.vethea);
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