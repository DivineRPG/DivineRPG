package divinerpg.objects.blocks.arcana;

import java.util.Random;

import javax.annotation.Nullable;

import divinerpg.objects.blocks.BlockMod;
import divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockStarBridgeOn extends BlockMod {
	private boolean red = false;

	public BlockStarBridgeOn(String name) {
		super(Material.ROCK, name);
		this.setHardness(2);
		setTickRandomly(true);
	}

	@Override
	public boolean canConnectRedstone(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
		return true;
	}

	@Override
	@Deprecated
	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return NULL_AABB;
	}
	
	@Override 
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{ 
	return Item.getItemFromBlock(ModBlocks.starBridge); 
	}
	  
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(Item.getItemFromBlock(ModBlocks.starBridge), 1, this.damageDropped(state));
    }
	 

	@Override
	public int getStrongPower(IBlockState state, IBlockAccess baccess, BlockPos pos, EnumFacing side) {
		return red ? 15 : 0;
	}

	@Override
	public int getWeakPower(IBlockState state, IBlockAccess baccess, BlockPos pos, EnumFacing side) {
		return red ? 15 : 0;
	}

	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block neighborBlock, BlockPos fromPos) {
		super.neighborChanged(state, world, pos, neighborBlock, fromPos);
		Minecraft.getMinecraft();
		if (world.isBlockIndirectlyGettingPowered(pos) > 0) {
			{
			world.setBlockState(pos, ModBlocks.starBridgeOn.getDefaultState(), 3);}
		} else {
			world.setBlockState(pos, ModBlocks.starBridge.getDefaultState(), 3);
		}
	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		world.scheduleUpdate(pos, this, 5);
	}
}
