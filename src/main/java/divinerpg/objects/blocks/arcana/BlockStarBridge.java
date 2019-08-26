package divinerpg.objects.blocks.arcana;

import java.util.Random;

import divinerpg.DivineRPG;
import divinerpg.enums.EnumBlockType;
import divinerpg.objects.blocks.BlockMod;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockStarBridge extends BlockMod {

	private final boolean powered;
	public BlockStarBridge(String name, boolean powered) {
		super(EnumBlockType.GLASS, name, 1.0F, !powered ? DivineRPGTabs.BlocksTab : null);
		this.powered = powered;
		if(powered) this.setLightLevel(1.0F);
		this.setTickRandomly(true);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess w, BlockPos pos)
    {
		return w.getBlockState(pos) == ModBlocks.starBridge.getDefaultState() ? null : super.getCollisionBoundingBox(blockState, w, pos);
	}

	@Override
	@Deprecated
    public boolean isOpaqueCube(IBlockState state)
    {	return false;
	}

	@Override
	public void onBlockAdded(World w, BlockPos pos, IBlockState state)
    {w.scheduleUpdate(pos, this, 5);
		if(!w.isRemote) {
			if(this.powered && w.isBlockIndirectlyGettingPowered(pos) < 1)
				w.scheduleBlockUpdate(pos, this, 4, 1);
			else if (!this.powered && w.isBlockIndirectlyGettingPowered(pos)> 0)
				w.setBlockState(pos, ModBlocks.starBridgeOn.getDefaultState());
		}
	}

	@Override
	public void neighborChanged(IBlockState state, World w, BlockPos pos, Block blockIn, BlockPos fromPos)
    {	w.scheduleUpdate(pos, this, 5);
		if(!w.isRemote) {
			if(this.powered && w.isBlockIndirectlyGettingPowered(pos) < 1)
				w.scheduleBlockUpdate(pos, this, 4, 1);
			else if (!this.powered && w.isBlockIndirectlyGettingPowered(pos)> 0)
				w.setBlockState(pos, ModBlocks.starBridgeOn.getDefaultState());
		}
	}

	@Override
	public void updateTick(World w, BlockPos pos, IBlockState state, Random rand)
    {	
		if(!w.isRemote && this.powered && w.isBlockIndirectlyGettingPowered(pos)< 1)
			w.setBlockState(pos, ModBlocks.starBridge.getDefaultState());
	}
}