package divinerpg.blocks.iceika;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.ticks.TickPriority;
import org.jetbrains.annotations.Nullable;

public class RedstoneLimiter extends DiodeBlock {
    public static final MapCodec<RedstoneLimiter> CODEC = simpleCodec(RedstoneLimiter::new);
    public RedstoneLimiter(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(POWERED, false));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, POWERED);
    }
    @Override
    protected MapCodec<? extends DiodeBlock> codec() {
        return CODEC;
    }
    @Override
    protected int getDelay(BlockState blockState) {
        return 2;
    }
    @Override
    public boolean canConnectRedstone(BlockState state, BlockGetter level, BlockPos pos, @Nullable Direction direction) {
        return true;
    }
    protected int getSignal(BlockState blockState, BlockGetter blockAccess, BlockPos pos, Direction side) {
        return blockState.getValue(FACING) == side && blockState.getValue(POWERED) ? 15 : 0;
    }
    @Override
    protected boolean shouldTurnOn(Level level, BlockPos pos, BlockState state) {
        return RedstoneBooster.getCombinedInputSignal(level, pos, state.getValue(FACING)) > 15;
    }
    @Override
    protected void checkTickOnNeighbor(Level level, BlockPos pos, BlockState state) {
        if(!level.getBlockTicks().willTickThisTick(pos, this)) {
            TickPriority tickpriority = TickPriority.HIGH;
            if(shouldPrioritize(level, pos, state)) tickpriority = TickPriority.EXTREMELY_HIGH;
            else if(state.getValue(POWERED)) tickpriority = TickPriority.VERY_HIGH;
            level.scheduleTick(pos, this, getDelay(state), tickpriority);
        }
    }
    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        boolean shouldpower = shouldTurnOn(level, pos, state);
        if(shouldpower ^ state.getValue(POWERED)) level.setBlock(pos, state.setValue(POWERED, shouldpower), 3);
    }
}