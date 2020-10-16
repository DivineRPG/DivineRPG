package TeamDivineRPG.divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.state.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class BlockModPowered extends BlockMod {
    public static final BooleanProperty POWERED = BooleanProperty.create("powered");

    public BlockModPowered(String name, Properties properties) {
        super(name, properties);
        this.setDefaultState(getStateContainer().getBaseState().with(POWERED, false));
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }

    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
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
        if (!worldIn.isRemote) {
            if (state.get(POWERED) && !worldIn.isBlockPowered(pos)) {
                worldIn.setBlockState(pos, this.getDefaultState(), 2);
            } else if (!state.get(POWERED) && worldIn.isBlockPowered(pos)) {
                worldIn.setBlockState(pos, this.getDefaultState().with(POWERED, true), 2);
            }
        }
    }
}
