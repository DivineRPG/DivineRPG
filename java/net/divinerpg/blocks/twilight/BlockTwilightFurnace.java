package net.divinerpg.blocks.twilight;

import java.util.Random;

import net.divinerpg.DivineRPG;
import net.divinerpg.api.blocks.BlockModFurnace;
import net.divinerpg.client.GuiHandler;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.blocks.TwilightBlocks;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTwilightFurnace extends BlockModFurnace {

	@SideOnly(Side.CLIENT)
	protected IIcon side, top, front;
	
	public BlockTwilightFurnace(String name, boolean act) {
		super(name, act, GuiHandler.twilightFurnace);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IIconRegister) {
		this.side = par1IIconRegister.registerIcon(Reference.PREFIX + "divineRock");
		this.front = par1IIconRegister.registerIcon(active ? Reference.PREFIX + "divineFurnace_front_On" : Reference.PREFIX + "divineFurnace_front_Off");
		this.top = par1IIconRegister.registerIcon(Reference.PREFIX + "divineRock");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int size, int meta) {
		return size == 1 ? this.top : (size == 0 ? this.top : (size != meta ? side : this.front));
	}

	public static void updateFurnaceBlockState(boolean act, World par1World, int par2, int par3, int par4) {
		int l = par1World.getBlockMetadata(par2, par3, par4);
		TileEntity tileentity = par1World.getTileEntity(par2, par3, par4);
		keepInventory = true;
		if(act) par1World.setBlock(par2, par3, par4, TwilightBlocks.twilightFurnaceOn);
		else par1World.setBlock(par2, par3, par4, TwilightBlocks.twilightFurnace);
		keepInventory = false;
		par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
		if(tileentity != null) {
			tileentity.validate();
			par1World.setTileEntity(par2, par3, par4, tileentity);
		}
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityTwilightFurnace();
	}
}