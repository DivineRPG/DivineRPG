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

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.*;

public class RedstoneBooster extends DiodeBlock {
    public static final MapCodec<RedstoneBooster> CODEC = simpleCodec(RedstoneBooster::new);
    public RedstoneBooster(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(POWERED, false).setValue(POWER, 0));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, POWERED, POWER);
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
        return blockState.getValue(FACING) == side ? blockState.getValue(POWER) : 0;
    }
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int power = getCombinedInputSignal(level, pos, state.getValue(FACING)) & 0xF;
        if(power != state.getValue(POWER)) level.setBlock(pos, state.setValue(POWER, power).setValue(POWERED, power > 0), 3);
    }
    @Override
    protected boolean shouldTurnOn(Level level, BlockPos pos, BlockState state) {
        return getInputSignal(level, pos, state) > 0 || getAlternateSignal(level, pos, state) > 0;
    }
    public static int getCombinedInputSignal(Level level, BlockPos pos, Direction facing) {
        return level.getSignal(pos.relative(facing), facing) + level.getSignal(pos.relative(facing.getClockWise()), facing.getClockWise()) + level.getSignal(pos.relative(facing.getCounterClockWise()), facing.getCounterClockWise());
    }
    @Override
    protected void checkTickOnNeighbor(Level level, BlockPos pos, BlockState state) {
        if(!level.getBlockTicks().willTickThisTick(pos, this)) {
            TickPriority tickpriority = TickPriority.HIGH;
            if(shouldPrioritize(level, pos, state)) tickpriority = TickPriority.EXTREMELY_HIGH;
            else if(state.getValue(POWERED)) tickpriority = TickPriority.VERY_HIGH;
            level.scheduleTick(pos, this, 2, tickpriority);
        }
    }
}