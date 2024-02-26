package divinerpg.blocks.twilight;

import net.minecraft.core.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.MapColor;

public class BlockBlueFire extends BaseFireBlock {
	public BlockBlueFire() {
		super(BlockBehaviour.Properties.copy(Blocks.FIRE).mapColor(MapColor.WATER), 1F);
	}
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return defaultBlockState();
	}
	@Override
	public BlockState updateShape(BlockState state, Direction dir, BlockState s, LevelAccessor level, BlockPos pos, BlockPos p) {
		BlockPos po = pos.below();
		BlockState st = level.getBlockState(po);
		return !st.isAir() && st.isFaceSturdy(level, po, Direction.UP) ? defaultBlockState() : Blocks.AIR.defaultBlockState();
	}
	@Override
	public boolean canSurvive(BlockState s, LevelReader level, BlockPos pos) {
		BlockPos p = pos.below();
		BlockState state = level.getBlockState(p);
		return !state.isAir() && state.isFaceSturdy(level, p, Direction.UP);
	}
	@Override
	protected boolean canBurn(BlockState state) {
		return !state.isAir();
	}
}