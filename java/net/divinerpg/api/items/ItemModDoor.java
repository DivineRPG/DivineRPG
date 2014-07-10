package net.divinerpg.api.items;

import cpw.mods.fml.common.registry.GameRegistry;

import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemModDoor extends ItemMod {

	private Block door;

	public ItemModDoor(Block block, String name) {
		super(name);
		this.door = block;
		setCreativeTab(DivineRPGTabs.blocks);
		setTextureName(Reference.PREFIX + name);
		setUnlocalizedName(name);
		GameRegistry.registerItem(this, name);
		LangRegistry.addItem(this);
	}

	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if(par7 != 1) 
			return false;
		else {
			if(!par3World.isRemote){
				++par5;
				Block block = door;

				int rotation = MathHelper.floor_double((double)((par2EntityPlayer.rotationYaw + 180.0F) * 4.0F / 360.0F) - 0.5D) & 3;
				ItemDoor.placeDoorBlock(par3World, par4, par5, par6, rotation, block);
				--par1ItemStack.stackSize;
				return true;
			}
		}
		return false;
	}
}