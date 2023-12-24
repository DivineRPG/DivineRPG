package divinerpg.blocks.iceika;

import net.minecraft.core.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;

public class BlockIceikaFire extends BaseFireBlock {
	public BlockIceikaFire() {
		super(BlockBehaviour.Properties.copy(Blocks.SOUL_FIRE).lightLevel((state) -> 7), 1F);
	}
	@Override
	public void entityInside(BlockState p_49260_, Level level, BlockPos p_49262_, Entity entity) {
		if(entity.canFreeze()) {
			entity.setTicksFrozen(entity.getTicksFrozen() + 4);
			if(entity.tickCount % 15 == 0) entity.hurt(level.damageSources().freeze(), 1);
		}
	}
	@Override
	public BlockState updateShape(BlockState state, Direction dir, BlockState s, LevelAccessor level, BlockPos pos, BlockPos p) {
		return canBurn(level.getBlockState(pos.below())) ? defaultBlockState() : Blocks.AIR.defaultBlockState();
	}
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return defaultBlockState();
	}
	@Override
	public boolean canSurvive(BlockState s, LevelReader level, BlockPos pos) {
		return canBurn(level.getBlockState(pos.below()));
	}
	@Override
	protected boolean canBurn(BlockState state) {
		return state.is(BlockTags.SNOW) || state.is(BlockTags.ICE);
	}
}