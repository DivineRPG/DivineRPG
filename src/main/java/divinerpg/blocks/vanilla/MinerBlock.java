package divinerpg.blocks.vanilla;

import divinerpg.blocks.base.BlockMod;
import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class MinerBlock extends BlockMod {
    public MinerBlock() {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.DROPPER));
        registerDefaultState(stateDefinition.any().setValue(DirectionalBlock.FACING, Direction.NORTH).setValue(BlockStateProperties.TRIGGERED, false));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DirectionalBlock.FACING, BlockStateProperties.TRIGGERED);
    }
    @Override public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(DirectionalBlock.FACING, context.getNearestLookingDirection().getOpposite());
    }
    @Override public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(DirectionalBlock.FACING, rot.rotate(state.getValue(DirectionalBlock.FACING)));
    }
    @Override public BlockState mirror(BlockState state, Mirror mir) {
        return rotate(state, mir.getRotation(state.getValue(DirectionalBlock.FACING)));
    }
    @Override public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos p, boolean b) {
        if(level instanceof ServerLevel s) {
            boolean hasSignal = level.hasNeighborSignal(pos) || level.hasNeighborSignal(pos.above()), triggered = state.getValue(BlockStateProperties.TRIGGERED);
            if(triggered && !hasSignal) level.setBlock(pos, state.setValue(BlockStateProperties.TRIGGERED, false), UPDATE_NONE);
            else if(hasSignal && !triggered) {
                level.setBlock(pos, state.setValue(BlockStateProperties.TRIGGERED, true), 4);
                p = pos.relative(state.getValue(BlockStateProperties.FACING));
                if(!s.getBlockState(p).is(BlockTags.WITHER_IMMUNE)) s.destroyBlock(p, true);
            }
        }
    }
}
