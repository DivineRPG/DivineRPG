package naturix.divinerpg.objects.blocks.arcana;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.blocks.BlockMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class StarBridgeOn extends BlockMod {
	private boolean red = false;

	public StarBridgeOn(String name) {
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
	//FIXME
	/**
	 * @Override public Item getItemDropped(IBlockState state, Random rand, int
	 *           fortune) { return Item.getItemFromBlock(ModBlocks.starBridge); }
	 * 
	 * @Override public ItemStack getPickBlock(IBlockState state, RayTraceResult
	 *           target, World world, BlockPos pos, EntityPlayer player) { return
	 *           new ItemStack(ModBlocks.starBridge); }
	 */

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
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		Minecraft.getMinecraft();
		if (world.isBlockIndirectlyGettingPowered(new BlockPos(x, y, z)) > 0) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
			    //FIXME
				// world.setBlockState(new BlockPos(x, y, z),
				// ModBlocks.starBridgeOn.getDefaultState(), 3);
			}
		} else {
			// world.setBlockState(new BlockPos(x, y, z),
			// ModBlocks.starBridge.getDefaultState(), 3);
		}
	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		world.scheduleUpdate(pos, this, 5);
	}
}
