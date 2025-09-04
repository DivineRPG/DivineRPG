package divinerpg.blocks.iceika;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.shapes.*;

import static net.minecraft.world.level.block.SoundType.MOSS_CARPET;
import static net.minecraft.world.level.material.MapColor.GLOW_LICHEN;

public class BlockBrittleGrass extends BushBlock {
	public static final MapCodec<BlockBrittleGrass> CODEC = simpleCodec(BlockBrittleGrass::new);
	public static final BooleanProperty HANGING = BlockStateProperties.HANGING;
	protected static final VoxelShape SHAPE = box(2, 0, 2, 14, 12, 14), HANGING_SHAPE = box(2, 4, 2, 14, 16, 14);
	@Override public MapCodec<BlockBrittleGrass> codec() {return CODEC;}
	public BlockBrittleGrass(Properties properties) {
		super(properties.mapColor(GLOW_LICHEN).sound(MOSS_CARPET).dynamicShape().offsetType(OffsetType.XZ));
		registerDefaultState(stateDefinition.any().setValue(HANGING, false));
	}
	@Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(HANGING);}
	@Override public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
		return state.getValue(HANGING) ? HANGING_SHAPE : SHAPE;
	}
	@Override protected boolean mayPlaceOn(BlockState state, BlockGetter getter, BlockPos pos) {
		BlockState belowState = getter.getBlockState(pos.below());
		BlockState aboveState = getter.getBlockState(pos.above());
		boolean sturdyFace = belowState.isFaceSturdy(getter, pos.below(), Direction.UP)
				|| aboveState.isFaceSturdy(getter, pos.above(), Direction.DOWN);
		return sturdyFace || belowState.getBlock() instanceof FarmBlock;}
	@Override public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
		return getConnectedDirection(state).getOpposite() == direction && !state.canSurvive(level, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, neighborState, level, pos, neighborPos);
	}
	@Override public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {return mayPlaceOn(state, level, pos);}
	protected static Direction getConnectedDirection(BlockState state) {return state.getValue(HANGING) ? Direction.DOWN : Direction.UP;}
	@Override public BlockState getStateForPlacement(BlockPlaceContext context) {
		Direction[] var3 = context.getNearestLookingDirections();
		for(Direction direction : var3) {
			if(direction.getAxis() == Direction.Axis.Y) {
				BlockState blockstate = defaultBlockState().setValue(HANGING, direction == Direction.UP);
				if(blockstate.canSurvive(context.getLevel(), context.getClickedPos())) return blockstate;
			}
		} return null;
	}
    @Override public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 100;}
    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 60;}
}