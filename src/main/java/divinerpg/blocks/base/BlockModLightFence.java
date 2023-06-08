package divinerpg.blocks.base;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.DebugPackets;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.*;

public class BlockModLightFence extends FenceBlock {
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public BlockModLightFence(MapColor color) {
        super(Block.Properties.of().mapColor(color).dynamicShape().strength(0.3F).sound(SoundType.GLASS));
        this.registerDefaultState(this.stateDefinition.any().setValue(POWERED, Boolean.valueOf(false)).setValue(NORTH, Boolean.valueOf(false)).setValue(EAST, Boolean.valueOf(false)).setValue(SOUTH, Boolean.valueOf(false)).setValue(WEST, Boolean.valueOf(false)).setValue(WATERLOGGED, Boolean.valueOf(false)));

    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return state.getValue(POWERED) ? 15 : 0;
    }

    @Override
    public void onPlace(BlockState state, Level worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        handleBlockState(state, worldIn, pos);
    }

    @Override
    public void neighborChanged(BlockState state, Level worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        handleBlockState(state, worldIn, pos);
        DebugPackets.sendNeighborsUpdatePacket(worldIn, pos);
    }

    @Override
    public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
        handleBlockState(state, worldIn, pos);
    }



    public void handleBlockState(BlockState state, Level worldIn, BlockPos pos) {
        if (!worldIn.isClientSide) {
            if (state.getValue(POWERED) && !worldIn.hasNeighborSignal(pos)) {
                worldIn.setBlock(pos, state.setValue(POWERED, false), 2);
            } else if (!state.getValue(POWERED) && worldIn.hasNeighborSignal(pos)) {
                worldIn.setBlock(pos, state.setValue(POWERED, Boolean.valueOf(true)), 2);
            }
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, WEST, SOUTH, WATERLOGGED, POWERED);
    }
}
