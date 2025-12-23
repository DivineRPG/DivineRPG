package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.*;
import org.jetbrains.annotations.*;

public class SimplePortalBlock extends PortalBlock {
    public static final VoxelShape X_AXIS_AABB = Block.box(0.0, 0.0, 6.0, 16.0, 16.0, 10.0), Z_AXIS_AABB = Block.box(6.0, 0.0, 0.0, 10.0, 16.0, 16.0);

	public SimplePortalBlock(ResourceKey<Level> rootDimension, ResourceKey<Level> chainDimension, Block frameBlock, ResourceLocation particle) {
		super(Properties.ofFullCopy(Blocks.NETHER_PORTAL), rootDimension, chainDimension, frameBlock, particle);
        registerDefaultState(stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_AXIS, Direction.Axis.X));
	}
    public SimplePortalBlock(Properties properties, ResourceLocation rootDimension, ResourceLocation chainDimension, Block frameBlock, ResourceLocation particle) {
        super(properties, ResourceKey.create(Registries.DIMENSION, rootDimension), ResourceKey.create(Registries.DIMENSION, chainDimension), frameBlock, particle);
        registerDefaultState(stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_AXIS, Direction.Axis.X));
    }
    @Override
    public boolean isSupported(BlockState state, LevelReader level, BlockPos pos) {
        Axis axis = state.getValue(BlockStateProperties.HORIZONTAL_AXIS);
        return supportedBy(level.getBlockState(pos.above())) && supportedBy(level.getBlockState(pos.below())) && supportedBy(level.getBlockState(pos.relative(axis, 1))) && supportedBy(level.getBlockState(pos.relative(axis, -1)));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.HORIZONTAL_AXIS);
    }
    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return rotate(defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_AXIS, context.getHorizontalDirection().getAxis()), Rotation.CLOCKWISE_90);
    }
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(BlockStateProperties.HORIZONTAL_AXIS) == Axis.Z ? Z_AXIS_AABB : X_AXIS_AABB;
    }
    @Override
    protected BlockState rotate(BlockState state, Rotation rot) {
        return switch (rot) {
            case COUNTERCLOCKWISE_90, CLOCKWISE_90 -> switch (state.getValue(BlockStateProperties.HORIZONTAL_AXIS)) {
                case Z -> state.setValue(BlockStateProperties.HORIZONTAL_AXIS, Axis.X);
                case X -> state.setValue(BlockStateProperties.HORIZONTAL_AXIS, Axis.Z);
                default -> state;
            };
            default -> state;
        };
    }
}