package divinerpg.blocks.vanilla;

import com.mojang.serialization.MapCodec;
import divinerpg.block_entities.block.InserterBlockEntity;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.Containers;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.redstone.Orientation;

import javax.annotation.Nullable;

public class BlockInserter extends BaseEntityBlock {
    public static final MapCodec<BlockInserter> CODEC = simpleCodec(BlockInserter::new);
    @Override public MapCodec<BlockInserter> codec() {return CODEC;}
    public BlockInserter() {
        super(Properties.ofFullCopy(Blocks.HOPPER));
        registerDefaultState(stateDefinition.any().setValue(BlockStateProperties.ENABLED, true).setValue(BlockStateProperties.FACING, Direction.NORTH));
    }
    public BlockInserter(Properties properties) {
        super(properties);
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.ENABLED, BlockStateProperties.FACING);
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(BlockStateProperties.FACING, context.getNearestLookingDirection());
    }
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(BlockStateProperties.FACING, rot.rotate(state.getValue(BlockStateProperties.FACING)));
    }
    @Override
    public BlockState mirror(BlockState state, Mirror mir) {
        return rotate(state, mir.getRotation(state.getValue(BlockStateProperties.FACING)));
    }
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return BlockEntityRegistry.INSERTER.get().create(pos, state);
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createCrateTicker(level, type, BlockEntityRegistry.INSERTER.get());
    }
    @Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createCrateTicker(Level level, BlockEntityType<T> type, BlockEntityType< ? extends InserterBlockEntity> entityType) {
        return level.isClientSide() ? null : createTickerHelper(type, entityType, InserterBlockEntity::serverTick);
    }

    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, @Nullable Orientation orientation, boolean movedByPiston) {
        boolean signal = !level.hasNeighborSignal(pos);
        if(state.getValue(BlockStateProperties.ENABLED) ^ signal) level.setBlock(pos, state.setValue(BlockStateProperties.ENABLED, signal), 4);
    }
    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    protected int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos, Direction direction) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(level.getBlockEntity(pos));
    }
    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public void destroy(LevelAccessor level, BlockPos pos, BlockState state) {
        BlockState s = level.getBlockState(pos);
        if (!state.is(s.getBlock()) || !s.hasBlockEntity()) {
            if (level instanceof Level serverLevel) {
                if (level.getBlockEntity(pos) instanceof InserterBlockEntity block && !block.isEmpty()) {
                    Containers.dropContents(serverLevel, pos, block);
                }
            }
            level.removeBlock(pos, true);

            if (level instanceof Level serverLevel) {
                serverLevel.updateNeighborsAt(pos, this);
            }
        }
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack destroyedWith) {
        if(level.getBlockEntity(pos) instanceof InserterBlockEntity block) {
            if(!block.isEmpty()) Containers.dropContents(level, pos, block);
            level.removeBlockEntity(pos);
            level.updateNeighbourForOutputSignal(pos, this);
        }
        super.playerDestroy(level, player, pos, state, blockEntity, destroyedWith);
    }
}