package divinerpg.blocks.iceika;

import divinerpg.blocks.base.BlockMod;
import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;

import javax.annotation.Nullable;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.POWER;

public class Capacitor extends BlockMod {
    public Capacitor() {
        super(Properties.ofFullCopy(Blocks.COPPER_BLOCK));
        registerDefaultState(stateDefinition.any().setValue(POWER, 0));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWER);
    }
    @Override
    public boolean canConnectRedstone(BlockState state, BlockGetter level, BlockPos pos, @Nullable Direction direction) {
        return true;
    }
    @Override
    protected int getSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return state.getValue(POWER);
    }
    @Override
    protected boolean isSignalSource(BlockState state) {
        return state.getValue(POWER) > 0;
    }
    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(POWER, Math.max(0, context.getLevel().getBestNeighborSignal(context.getClickedPos()) - 1));
    }
    @Override
    protected int getDirectSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return getSignal(state, level, pos, direction);
    }
    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, BlockPos neighborPos, boolean movedByPiston) {
        int pow = Math.max(0, level.getBestNeighborSignal(pos) - 1), current = state.getValue(POWER);
        if(pow < current) level.scheduleTick(pos, this, 8);
        else if(pow > current) level.setBlock(pos, state.setValue(POWER, pow), 3);
    }
    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int pow = Math.max(0, level.getBestNeighborSignal(pos) - 1);
        if(pow != state.getValue(POWER)) level.setBlock(pos, state.setValue(POWER, pow), 3);
    }
}