package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.state.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.server.*;

import java.util.*;

import net.minecraft.block.AbstractBlock.Properties;

public class BlockModPowered extends BlockMod {
    public static final BooleanProperty POWERED = BooleanProperty.create("powered");

    public BlockModPowered(String name, Properties properties) {
        super(name, properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(POWERED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }

    @Override
    public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        handleBlockState(state, worldIn, pos);
    }

    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        handleBlockState(state, worldIn, pos);
        super.neighborChanged(state, worldIn, pos, blockIn, fromPos, isMoving);
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        handleBlockState(state, worldIn, pos);
    }

    public void handleBlockState(BlockState state, World worldIn, BlockPos pos) {
        if (!worldIn.isClientSide) {
            if (state.getValue(POWERED) && !worldIn.hasNeighborSignal(pos)) {
                worldIn.setBlock(pos, this.defaultBlockState(), 2);
            } else if (!state.getValue(POWERED) && worldIn.hasNeighborSignal(pos)) {
                worldIn.setBlock(pos, this.defaultBlockState().setValue(POWERED, true), 2);
            }
        }
    }
}
