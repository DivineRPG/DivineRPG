package net.divinerpg.items.vethea;

import java.util.List;

import net.divinerpg.items.base.ItemModSword;
import net.divinerpg.libs.Reference;
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
        if (item.getMaxDurability() != -1) infoList.add(item.getMaxDurability() - item.getMetadata() + " Uses Remaining");
        else infoList.add(Util.GREEN + "Infinite Uses");
        if((int)this.mat.getDamageVsEntity() == this.mat.getDamageVsEntity())infoList.add((int)this.mat.getDamageVsEntity()+4 + " Melee Damage");
    	else infoList.add(this.mat.getDamageVsEntity()+4 + " Melee Damage");
        if(this instanceof ItemVetheanClaw) infoList.add("Cannot block");
        infoList.add(Util.GREEN + "Vethean");
    }
}