package divinerpg.blocks.iceika;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.ticks.TickPriority;

public class OxdriteLamp extends Block {
    public OxdriteLamp(Properties p) {
        super(p);
        registerDefaultState(defaultBlockState().setValue(BlockStateProperties.POWER, 0));
    }
    @Override
    public boolean hasDynamicLightEmission(BlockState state) {
        return true;
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.POWER);
    }
    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, Orientation orientation, boolean movedByPiston) {
        if(!level.isClientSide() && level.getBestNeighborSignal(pos) != state.getValue(BlockStateProperties.POWER)) level.scheduleTick(pos, this, 1, TickPriority.LOW);
    }
    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        level.setBlock(pos, state.setValue(BlockStateProperties.POWER, level.getBestNeighborSignal(pos)), 3);
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(BlockStateProperties.POWER, context.getLevel().getBestNeighborSignal(context.getClickedPos()));
    }
}