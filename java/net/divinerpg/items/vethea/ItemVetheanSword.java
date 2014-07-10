package net.divinerpg.items.vethea;

import java.util.List;

import net.divinerpg.api.items.ItemModSword;
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
        setMaxDamage(-1);
        setCreativeTab(DivineRPGTabs.vethea);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, EntityPlayer player, List infoList, boolean par4) {
        if (item.getMaxDamage() != -1) infoList.add(item.getMaxDamage() - item.getItemDamage() + " Uses Remaining");
        else infoList.add(Util.GREEN + "Infinite Uses");
        if(this instanceof ItemVetheanClaw) infoList.add("Cannot block");
        infoList.add(Util.GREEN + "Vethean");
        infoList.add(Util.RED + Reference.MOD_NAME);
    }
}