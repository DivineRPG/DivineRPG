package divinerpg.blocks.iceika;

import divinerpg.block_entities.block.RobbinHutBlockEntity;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.*;

public class BlockRobbinHut extends BaseEntityBlock {
	public BlockRobbinHut() {
		super(Block.Properties.copy(Blocks.SPRUCE_FENCE).randomTicks().noOcclusion().isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false).isRedstoneConductor((state, getter, pos) -> false));
		registerDefaultState(stateDefinition.any().setValue(HorizontalDirectionalBlock.FACING, Direction.NORTH));
	}
	@Override public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		if(level.getBlockEntity(pos) instanceof RobbinHutBlockEntity block && (block.robbin1 != null || block.robbin2 != null) && level.getBlockState(pos = pos.offset(state.getValue(HorizontalDirectionalBlock.FACING).getNormal())).isAir()) {
			if(block.robbin2 == null) {
				EntityRegistry.ROBBIN.get().spawn(level, block.robbin1, null, pos, MobSpawnType.DISPENSER, true, true);
				block.robbin1 = null;
			} else {
				EntityRegistry.ROBBIN.get().spawn(level, block.robbin2, null, pos, MobSpawnType.DISPENSER, true, true).wantsNest = block.robbin1 != null;
				block.robbin2 = null;
			}
		}
	}
	public static boolean hasSpace(ServerLevel level, BlockPos pos) {
		return level.getBlockEntity(pos) instanceof RobbinHutBlockEntity block && (block.robbin1 == null || block.robbin2 == null);
	}
	public static boolean isFull(ServerLevel level, BlockPos pos) {
		return level.getBlockEntity(pos) instanceof RobbinHutBlockEntity block && block.robbin1 != null && block.robbin2 != null;
	}
	@Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return BlockEntityRegistry.ROBBIN_HUT.get().create(pos, state);
	}
	@Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(HorizontalDirectionalBlock.FACING);
	}
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, context.getHorizontalDirection().getOpposite());
	}
	@Override public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(HorizontalDirectionalBlock.FACING, rot.rotate(state.getValue(HorizontalDirectionalBlock.FACING)));
	}
	@SuppressWarnings("deprecation") @Override public BlockState mirror(BlockState state, Mirror mir) {
		return state.rotate(mir.getRotation(state.getValue(HorizontalDirectionalBlock.FACING)));
	}
}