package divinerpg.blocks.iceika;

import net.minecraft.core.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.vehicle.minecart.AbstractMinecart;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.RailShape;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.POWER;

public class OxdriteRail extends PoweredRailBlock {
    public OxdriteRail(Properties p) {
        super(p, true);
    }
    @Override
    protected void registerDefaultState() {
        registerDefaultState(stateDefinition.any().setValue(SHAPE, RailShape.NORTH_SOUTH).setValue(POWER, 0).setValue(POWERED, false).setValue(WATERLOGGED, false));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(getShapeProperty(), POWER, POWERED, WATERLOGGED);
    }
    @Override //TODO: test if new implementation works
    public RailShape getRailDirection(BlockState state, BlockGetter world, BlockPos pos, @Nullable AbstractMinecart cart) {
        if(cart != null) {
            double scale = cart.isVehicle() ? .75 : 1D;
            double maxSpeed = (cart.isInWater() ? .2F : .4F) * (state.getValue(POWER) + 1) / 16F;
            cart.move(MoverType.SELF, new Vec3(Mth.clamp(scale * cart.getDeltaMovement().x, -maxSpeed, maxSpeed), 0D, Mth.clamp(scale * cart.getDeltaMovement().z, -maxSpeed, maxSpeed)));
        } return super.getRailDirection(state, world, pos, cart);
    }
    @Override
    protected boolean shouldRedstoneWireConnectTo(BlockState state, BlockGetter level, BlockPos pos, @org.jspecify.annotations.Nullable Direction direction) {
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