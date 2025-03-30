package divinerpg.blocks.vanilla;

import divinerpg.block_entities.block.*;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.shapes.*;

import javax.annotation.Nullable;

public class BlockDistributor extends BlockInserter implements SimpleWaterloggedBlock {
    public static final VoxelShape shape = Block.box(0D, 0D, 0D, 16D, 8D, 16D);
    public BlockDistributor() {
        super(Properties.ofFullCopy(Blocks.HOPPER));
        registerDefaultState(stateDefinition.any().setValue(BlockStateProperties.ENABLED, true).setValue(BlockStateProperties.WATERLOGGED, false));
    }
    @Override
    protected boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return shape;
    }
    @Override protected FluidState getFluidState(BlockState state) {
        return state.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }
    protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        if(state.getValue(BlockStateProperties.WATERLOGGED)) level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(BlockStateProperties.ENABLED, BlockStateProperties.WATERLOGGED);}
    @Override public BlockState getStateForPlacement(BlockPlaceContext context) {return defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, context.getLevel().getFluidState(context.getClickedPos()).is(Fluids.WATER));}
    @Override public BlockState rotate(BlockState state, Rotation rot) {return state;}
    @Override public BlockState mirror(BlockState state, Mirror mir) {return state;}
    @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return BlockEntityRegistry.DISTRIBUTOR.get().create(pos, state);
    }
    @Nullable @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTicker(level, type, BlockEntityRegistry.DISTRIBUTOR.get());
    }
    @Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createTicker(Level level, BlockEntityType<T> type, BlockEntityType<? extends DistributorBlockEntity> entityType) {
        return level.isClientSide ? null : createTickerHelper(type, entityType, DistributorBlockEntity::serverTick);
    }
}