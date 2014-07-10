package net.divinerpg.blocks.arcana;

import net.divinerpg.api.blocks.BlockModFurnace;
import net.divinerpg.blocks.arcana.container.tile_entity.TileEntityGreenlightFurnace;
import net.divinerpg.client.GuiHandler;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGreenlightFurnace extends BlockModFurnace {

	@SideOnly(Side.CLIENT)
	protected IIcon side, top, front;
	
	public BlockGreenlightFurnace(String name, boolean act) {
		super(name, act, GuiHandler.greenlight);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IIconRegister) {
		this.side = par1IIconRegister.registerIcon(Reference.PREFIX + "greenlightFurnace_side");
		this.front = par1IIconRegister.registerIcon(active ? Reference.PREFIX + "greenlightFurnace_front_on" : Reference.PREFIX + "greenlightFurnace_front_off");
		this.top = par1IIconRegister.registerIcon(Reference.PREFIX + "greenlightFurnace_top");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int size, int meta) {
		return size == 1 ? this.top : (size == 0 ? this.top : (size != meta ? side : this.front));
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityGreenlightFurnace();
	}
	
	public static void updateFurnaceBlockState(boolean act, World par1World, int par2, int par3, int par4) {
		int l = par1World.getBlockMetadata(par2, par3, par4);
		TileEntity tileentity = par1World.getTileEntity(par2, par3, par4);
		keepInventory = true;
		if(act) par1World.setBlock(par2, par3, par4, ArcanaBlocks.greenlightFurnaceOn);
		else par1World.setBlock(par2, par3, par4, ArcanaBlocks.greenlightFurnace);
		keepInventory = false;
		par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
		if(tileentity != null) {
			tileentity.validate();
			par1World.setTileEntity(par2, par3, par4, tileentity);
		}
	}

}