package divinerpg.blocks.vanilla;

import divinerpg.block_entities.block.DistributorBlockEntity;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class Distributor extends Inserter implements SimpleWaterloggedBlock {
    public static final VoxelShape shape = Block.box(0D, 0D, 0D, 16D, 8D, 16D);

    public Distributor(Properties p) {
        super(p);
        registerDefaultState(stateDefinition.any().setValue(BlockStateProperties.ENABLED, true).setValue(BlockStateProperties.WATERLOGGED, false).setValue(BlockStateProperties.FACING, Direction.NORTH));
    }
    @Override protected boolean useShapeForLightOcclusion(BlockState state) {return true;}
    @Override protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {return shape;}
    @Override protected FluidState getFluidState(BlockState state) {return state.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);}
    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
        if (state.getValue(BlockStateProperties.WATERLOGGED)) {
            ticks.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        return super.updateShape(state, level, ticks, pos, directionToNeighbour, neighbourPos, neighbourState, random);
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(BlockStateProperties.ENABLED, BlockStateProperties.WATERLOGGED, BlockStateProperties.FACING);}
    @Override public BlockState getStateForPlacement(BlockPlaceContext context) {return defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, context.getLevel().getFluidState(context.getClickedPos()).is(Fluids.WATER)).setValue(BlockStateProperties.FACING, context.getNearestLookingDirection());}
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return BlockEntityRegistry.DISTRIBUTOR.get().create(pos, state);
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTicker(level, type, BlockEntityRegistry.DISTRIBUTOR.get());
    }
    @Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createTicker(Level level, BlockEntityType<T> type, BlockEntityType<? extends DistributorBlockEntity> entityType) {
        return level.isClientSide() ? null : createTickerHelper(type, entityType, DistributorBlockEntity::serverTick);
    }
}