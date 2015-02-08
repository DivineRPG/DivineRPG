package net.divinerpg.items.arcana;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.divinerpg.api.items.ItemMod;
import net.divinerpg.entities.arcana.EntityConstructor;
import net.divinerpg.entities.vanilla.projectile.EntityScythe;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemChargedCollector extends ItemMod {

	public ItemChargedCollector(String name) {
		super(name);
	}
		
	@Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack var1, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("Use as fuel in a Extractor");
	}
}