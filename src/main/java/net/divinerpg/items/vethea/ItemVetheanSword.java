package net.divinerpg.items.vethea;

import java.util.List;

import net.divinerpg.items.base.ItemModSword;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.TooltipLocalizer;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemVetheanSword extends ItemModSword {
	

    public ItemVetheanSword(String name, ToolMaterial toolMaterial) {
        super(toolMaterial, name);
        setMaxDurability(-1);
        setCreativeTab(DivineRPGTabs.vethea);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, EntityPlayer player, List infoList, boolean par4) {
        if (item.getMaxDurability() != -1) infoList.add(TooltipLocalizer.usesRemaining(item.getMaxDurability() - item.getMetadata()));
        else infoList.add(TooltipLocalizer.infiniteUses());
    	infoList.add(TooltipLocalizer.meleeDam(this.mat.getDamageVsEntity()+5));
        if(this instanceof ItemVetheanClaw) infoList.add(TooltipLocalizer.cantBlock());
        infoList.add(TooltipLocalizer.vethean());
    }
}