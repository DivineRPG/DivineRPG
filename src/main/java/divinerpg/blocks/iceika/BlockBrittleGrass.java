package divinerpg.blocks.iceika;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.*;

public class BlockBrittleGrass extends BushBlock {
	public static final MapCodec<BlockBrittleGrass> CODEC = simpleCodec(BlockBrittleGrass::new);
	public static final BooleanProperty HANGING = BlockStateProperties.HANGING;
	protected static final VoxelShape SHAPE = Block.box(2, 0, 2, 14, 12, 14), HANGING_SHAPE = Block.box(2, 4, 2, 14, 16, 14);
	@Override public MapCodec<BlockBrittleGrass> codec() {return CODEC;}
	public BlockBrittleGrass(Properties properties) {
		super(properties.mapColor(MapColor.GLOW_LICHEN).sound(SoundType.MOSS_CARPET).dynamicShape().offsetType(BlockBehaviour.OffsetType.XZ));
		registerDefaultState(this.stateDefinition.any().setValue(HANGING, false));
	}
	@Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HANGING);
    }
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter p_154526_, BlockPos p_154527_, CollisionContext p_154528_) {
		return state.getValue(HANGING) ? HANGING_SHAPE : SHAPE;
	}
	@Override
	protected boolean mayPlaceOn(BlockState state, BlockGetter getter, BlockPos pos) {
		return getter.getBlockState(pos.below()).isFaceSturdy(getter, pos.below(), Direction.UP) || getter.getBlockState(pos.above()).isFaceSturdy(getter, pos.above(), Direction.DOWN);
	}
	@Override
	public BlockState updateShape(BlockState state, Direction direction, BlockState s, LevelAccessor level, BlockPos pos, BlockPos p) {
		return level.getBlockState(pos.above()).isFaceSturdy(level, pos.above(), Direction.DOWN) ? defaultBlockState().setValue(HANGING, true) : level.getBlockState(pos.below()).isFaceSturdy(level, pos.below(), Direction.UP) ? defaultBlockState() : Blocks.AIR.defaultBlockState();
	}
	@Override
	public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
		return mayPlaceOn(null, level, pos);
	}
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return context.getLevel().getBlockState(context.getClickedPos().above()).isFaceSturdy(context.getLevel(), context.getClickedPos().above(), Direction.DOWN) ? defaultBlockState().setValue(HANGING, true) : context.getLevel().getBlockState(context.getClickedPos().below()).isFaceSturdy(context.getLevel(), context.getClickedPos().below(), Direction.UP) ? defaultBlockState() : Blocks.AIR.defaultBlockState();
	}

        @Override
        public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
            return 100;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
            return 60;
    }
}