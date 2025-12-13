package divinerpg.compat.supplementaries;

import net.mehvahdjukaar.supplementaries.common.block.ModBlockProperties;
import net.mehvahdjukaar.supplementaries.common.block.blocks.RakedGravelBlock;
import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.*;

import static divinerpg.registries.BlockRegistry.frozenGravel;

public class RakedFrozenGravel extends RakedGravelBlock {
    public RakedFrozenGravel() {super(new ColorRGBA(13561077), Properties.ofFullCopy(frozenGravel.get()));}
    //TODO: to investigate the peculiar gravel dupe
    @Override public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.defaultBlockState();
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();
        if(!state.canSurvive(level, pos)) return Block.pushEntitiesUp(state, frozenGravel.get().defaultBlockState(), level, pos);
        else {
            Direction front = context.getHorizontalDirection();
            return getConnectedState(state, level, pos, front);
        }
    }
    private static boolean canConnect(BlockState state, Direction dir) {
        return state.getBlock() instanceof RakedGravelBlock && state.getValue(RAKE_DIRECTION).getDirections().contains(dir.getOpposite());
    }
    public static BlockState getConnectedState(BlockState blockstate, LevelAccessor level, BlockPos pos, Direction front) {
        List<Direction> directionList = new ArrayList<>();
        Direction back = front.getOpposite();
        if(canConnect(level.getBlockState(pos.relative(back)), back)) directionList.add(back);
        else directionList.add(front);
        Direction side = front.getClockWise();
        for(int i = 0; i < 2; ++i) {
            BlockState state = level.getBlockState(pos.relative(side));
            if(canConnect(state, side)) {
                directionList.add(side);
                break;
            } side = side.getOpposite();
        } return blockstate.setValue(RAKE_DIRECTION, ModBlockProperties.RakeDirection.fromDirections(directionList));
    }
    @Override public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.tick(state, level, pos, random);
        if(!state.canSurvive(level, pos)) turnToGravel(state, level, pos);
    }
    public static void turnToGravel(BlockState state, Level level, BlockPos pos) {
        level.setBlockAndUpdate(pos, pushEntitiesUp(state, frozenGravel.get().defaultBlockState(), level, pos));
    }
}