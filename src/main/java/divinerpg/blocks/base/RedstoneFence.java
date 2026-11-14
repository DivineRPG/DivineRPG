package divinerpg.blocks.base;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.redstone.Orientation;
import org.jspecify.annotations.Nullable;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.POWERED;

public class RedstoneFence extends FenceBlock {
    public RedstoneFence(Properties p) {
        super(p);
        registerDefaultState(stateDefinition.any().setValue(POWERED, false).setValue(NORTH, false).setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false).setValue(WATERLOGGED, false));
    }
    @Override public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return state.getValue(POWERED) ? 15 : 0;
    }
    @Override public void onPlace(BlockState state, Level worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        handleBlockState(state, worldIn, pos);
    }
    @Override protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, @Nullable Orientation orientation, boolean movedByPiston) {
        handleBlockState(state, level, pos);
    }
    @Override
    public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
        handleBlockState(state, worldIn, pos);
    }
    public void handleBlockState(BlockState state, Level worldIn, BlockPos pos) {
        if(!worldIn.isClientSide()) {
            if(state.getValue(POWERED) && !worldIn.hasNeighborSignal(pos)) worldIn.setBlock(pos, state.setValue(POWERED, false), 2);
            else if(!state.getValue(POWERED) && worldIn.hasNeighborSignal(pos)) worldIn.setBlock(pos, state.setValue(POWERED, true), 2);
        }
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, WEST, SOUTH, WATERLOGGED, POWERED);
    }
}