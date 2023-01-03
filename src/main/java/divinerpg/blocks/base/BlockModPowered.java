package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.network.protocol.game.DebugPackets;
import net.minecraft.server.level.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;

public class BlockModPowered extends BlockMod {
    public static final BooleanProperty POWERED = BooleanProperty.create("powered");

    public BlockModPowered(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(POWERED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
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
                worldIn.setBlock(pos, this.defaultBlockState(), 2);
            } else if (!state.getValue(POWERED) && worldIn.hasNeighborSignal(pos)) {
                worldIn.setBlock(pos, this.defaultBlockState().setValue(POWERED, true), 2);
            }
        }
    }
}
