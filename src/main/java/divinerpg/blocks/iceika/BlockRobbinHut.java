package divinerpg.blocks.iceika;

import com.mojang.serialization.MapCodec;
import divinerpg.block_entities.block.RobbinHutBlockEntity;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.phys.shapes.*;

public class BlockRobbinHut extends BaseEntityBlock {
	public static final MapCodec<BlockRobbinHut> CODEC = simpleCodec(BlockRobbinHut::new);
	protected static final VoxelShape BASE_SHAPE = box(2, 0, 2, 14, 16, 14);
	@Override public MapCodec<BlockRobbinHut> codec() {return CODEC;}
	public BlockRobbinHut(Properties properties) {
		super(properties);
	}
	@Override public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {return BASE_SHAPE;}
	@SuppressWarnings("deprecation")
	@Override public RenderShape getRenderShape(BlockState state) {return RenderShape.MODEL;}
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
	public static boolean hasSpace(ServerLevel level, BlockPos pos) {return level.getBlockEntity(pos) instanceof RobbinHutBlockEntity block && (block.robbin1 == null || block.robbin2 == null);}
	// public static boolean isFull(ServerLevel level, BlockPos pos) {return level.getBlockEntity(pos) instanceof RobbinHutBlockEntity block && block.robbin1 != null && block.robbin2 != null;}
	@Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {return BlockEntityRegistry.ROBBIN_HUT.get().create(pos, state);}
	@Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(HorizontalDirectionalBlock.FACING);}
	@Override public BlockState getStateForPlacement(BlockPlaceContext context) {return defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, context.getHorizontalDirection().getOpposite());}
	@SuppressWarnings("deprecation")
	@Override public BlockState rotate(BlockState state, Rotation rot) {return state.setValue(HorizontalDirectionalBlock.FACING, rot.rotate(state.getValue(HorizontalDirectionalBlock.FACING)));}
	@SuppressWarnings("deprecation")
	@Override public BlockState mirror(BlockState state, Mirror mir) {return state.rotate(mir.getRotation(state.getValue(HorizontalDirectionalBlock.FACING)));}
}