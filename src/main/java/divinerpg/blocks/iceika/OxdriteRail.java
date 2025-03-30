package divinerpg.blocks.iceika;

import net.minecraft.core.*;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.RailShape;
import org.jetbrains.annotations.Nullable;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.POWER;

public class OxdriteRail extends PoweredRailBlock {
    public OxdriteRail() {
        super(Properties.ofFullCopy(Blocks.POWERED_RAIL), true);
    }
    @Override
    protected void registerDefaultState() {
        registerDefaultState(stateDefinition.any().setValue(SHAPE, RailShape.NORTH_SOUTH).setValue(POWER, 0).setValue(POWERED, false).setValue(WATERLOGGED, false));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(getShapeProperty(), POWER, POWERED, WATERLOGGED);
    }
    @Override
    public float getRailMaxSpeed(BlockState state, Level level, BlockPos pos, AbstractMinecart cart) {
        return super.getRailMaxSpeed(state, level, pos, cart) * (state.getValue(POWER) + 1) / 16F;
    }
    @Override
    public boolean canConnectRedstone(BlockState state, BlockGetter level, BlockPos pos, @Nullable Direction direction) {
        return true;
    }
    @Override protected void updateState(BlockState state, Level level, BlockPos pos, Block block) {
        RailShape railshape = state.getValue(getShapeProperty());
        int max = level.getBestNeighborSignal(pos);
        if(max < 15 && hasAscendingConnection(railshape, Direction.NORTH)) max = Math.max(max, level.getSignal(pos.north().below(), Direction.NORTH));
        if(max < 15 && hasAscendingConnection(railshape, Direction.SOUTH)) max = Math.max(max, level.getSignal(pos.south().below(), Direction.SOUTH));
        if(max < 15 && hasAscendingConnection(railshape, Direction.WEST)) max = Math.max(max, level.getSignal(pos.west().below(), Direction.WEST));
        if(max < 15 && hasAscendingConnection(railshape, Direction.EAST)) max = Math.max(max, level.getSignal(pos.east().below(), Direction.EAST));
        max = Math.max(0, max - 1);
        if(state.getValue(POWER) != max) level.setBlock(pos, state.setValue(POWER, max).setValue(POWERED, max > 0), UPDATE_ALL);
    }
    @Override
    protected boolean isSignalSource(BlockState state) {
        return state.getValue(POWERED);
    }
    @Override
    protected int getSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        RailShape railshape = state.getValue(getShapeProperty());
        int power = state.getValue(POWER);
        return power > 0 && hasConnection(railshape, direction) ? power : 0;
    }
    public boolean hasAscendingConnection(RailShape railshape, Direction dir) {
        return switch(dir) {
            case NORTH -> railshape == RailShape.NORTH_SOUTH || railshape == RailShape.ASCENDING_NORTH;
            case SOUTH -> railshape == RailShape.NORTH_SOUTH || railshape == RailShape.ASCENDING_SOUTH;
            case WEST -> railshape == RailShape.EAST_WEST || railshape == RailShape.ASCENDING_WEST;
            case EAST -> railshape == RailShape.EAST_WEST || railshape == RailShape.ASCENDING_EAST;
            default -> false;
        };
    }
    public boolean hasConnection(RailShape railshape, Direction dir) {
        return switch(dir) {
            case NORTH, SOUTH -> railshape == RailShape.NORTH_SOUTH || railshape == RailShape.ASCENDING_NORTH || railshape == RailShape.ASCENDING_SOUTH;
            case WEST, EAST -> railshape == RailShape.EAST_WEST || railshape == RailShape.ASCENDING_EAST || railshape == RailShape.ASCENDING_WEST;
            default -> false;
        };
    }
    @Override
    protected int getDirectSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return getSignal(state, level, pos, direction);
    }
}