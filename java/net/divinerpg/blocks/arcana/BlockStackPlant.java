package net.divinerpg.blocks.arcana;

import java.util.Random;

import net.divinerpg.api.blocks.BlockMod;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockStackPlant extends BlockMod implements IPlantable {
	
	private Item dropped, seeds;
	
	public BlockStackPlant(String name, Item drop, Item Seeds) {
		super(EnumBlockType.PLANT, name, true);
		float var3 = 0.375F;
		this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 1.0F, 0.5F + var3);
		this.setTickRandomly(true);
		setCreativeTab(null);
		dropped = drop;
		seeds = Seeds;
	}

 
	public void onBlockAdded(World par1World, int par2, int par3, int par4) { }

	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		if(par1World.isAirBlock(par2, par3 + 1, par4)) {
			if(this == ArcanaBlocks.firestock) {
				par1World.setBlock(par2, par3 + 1, par4, ArcanaBlocks.firestock2);
			}
			if(this == ArcanaBlocks.pinfly) {
				par1World.setBlock(par2, par3 + 1, par4, ArcanaBlocks.pinfly2);
			}
			if(this == ArcanaBlocks.moonbulb) {
				par1World.setBlock(par2, par3 + 1, par4, ArcanaBlocks.moonbulb2);
			}
		}
	}
	
	@Override
	public boolean canBlockStay(World w, int x, int y, int z) {
		return w.getBlock(x, y - 1, z) != Blocks.air;
	}
	
	@Override
	public void onNeighborBlockChange(World w, int x, int y, int z, Block b) {
		this.checkBlockCoordValid(w, x, y, z);
	}

	protected void checkBlockCoordValid(World par1World, int par2, int par3, int par4) {
		if(!this.canBlockStay(par1World, par2, par3, par4)) {
			this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
			par1World.func_147480_a(par2, par3, par4, false);
		}
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World w, int x, int y, int z) {
		return null;
	}

	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3) {
		return dropped;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
    public int quantityDropped(Random par1Random) {
        return 1 + par1Random.nextInt(5);
    } 

	@Override
    public int getRenderType() {
        return 1;
    }

	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World par1World, int par2, int par3, int par4) {
		return seeds;
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return EnumPlantType.Beach;
	}

	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z) {
		return this;
	}

	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
		return world.getBlockMetadata(x, y, z);
	}
}