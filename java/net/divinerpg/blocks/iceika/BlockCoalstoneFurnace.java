package net.divinerpg.blocks.iceika;

import java.util.Random;

import net.divinerpg.DivineRPG;
import net.divinerpg.blocks.base.BlockModFurnace;
import net.divinerpg.blocks.base.tileentity.TileEntityModFurnace;
import net.divinerpg.blocks.iceika.tileentity.TileEntityCoalstoneFurnace;
import net.divinerpg.client.GuiHandler;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.IceikaBlocks;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCoalstoneFurnace extends BlockModFurnace {

	@SideOnly(Side.CLIENT)
	protected IIcon side, top, front;
	
	public BlockCoalstoneFurnace(String name, boolean act) {
		super(name, act, GuiHandler.coalstone);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
		this.side = icon.registerIcon(Reference.PREFIX + "coalstone");
		this.front = icon.registerIcon(active ? Reference.PREFIX + "coalstoneFurnace_front_on" : Reference.PREFIX + "coalstoneFurnace_front_off");
		this.top = icon.registerIcon(Reference.PREFIX + "coalstone");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int size, int meta){
		if(size == 3 && meta == 0)
			return front;
		else
			return size == 1 ? this.top : (size == 0 ? this.top : (size != meta ? side : this.front));
	}
	
	public static void updateActiveStates(boolean active, World w, int x, int y, int z) {
		int meta = w.getBlockMetadata(x, y, z);
		TileEntity tileentity = w.getTileEntity(x, y, z);
		keepInventory = true;
		if(active) w.setBlock(x, y, z, IceikaBlocks.coalstoneFurnaceOn);
		else w.setBlock(x, y, z, IceikaBlocks.coalstoneFurnace);
		keepInventory = false;
		w.setBlockMetadataWithNotify(x, y, z, meta, 2);
		if(tileentity != null) {
			tileentity.validate();
			w.setTileEntity(x, y, z, tileentity);
		}
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityCoalstoneFurnace();
	}
}