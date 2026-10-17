package divinerpg.blocks.arcana;

import com.google.common.base.Predicates;
import com.mojang.logging.LogUtils;
import divinerpg.registries.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;

public class BlockArcanaPortalFrame extends Block {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;
    protected static final VoxelShape BASE_SHAPE = Block.column(16.0, 0.0, 13.0);
    private static @Nullable BlockPattern portalShape;

    public BlockArcanaPortalFrame(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    public BlockArcanaPortalFrame() {
        this(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).requiresCorrectToolForDrops().pushReaction(PushReaction.IMMOVEABLE).strength(5.0F, 6.0F).sound(SoundType.METAL));
    }

    @Override
    protected boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return BASE_SHAPE;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType type) {
        return false;
    }

    public static BlockPattern getOrCreatePortalShape() {
        if (portalShape == null) {
            portalShape = BlockPatternBuilder.start().aisle("?vvv?", ">???<", ">???<", ">???<", "?^^^?").where('?', BlockInWorld.hasState(BlockStatePredicate.ANY)).where('^', BlockInWorld.hasState(BlockStatePredicate.forBlock(BlockRegistry.arcanaPortalFrame.get()).where(FACING, Predicates.equalTo(Direction.SOUTH)))).where('>', BlockInWorld.hasState(BlockStatePredicate.forBlock(BlockRegistry.arcanaPortalFrame.get()).where(FACING, Predicates.equalTo(Direction.WEST)))).where('v', BlockInWorld.hasState(BlockStatePredicate.forBlock(BlockRegistry.arcanaPortalFrame.get()).where(FACING, Predicates.equalTo(Direction.NORTH)))).where('<', BlockInWorld.hasState(BlockStatePredicate.forBlock(BlockRegistry.arcanaPortalFrame.get()).where(FACING, Predicates.equalTo(Direction.EAST)))).build();
        }
        return portalShape;
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!oldState.is(state.getBlock())) {
            checkAndCreatePortal(level, pos);
        }
    }

    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, @Nullable Orientation orientation, boolean isMoving) {
        checkAndCreatePortal(level, pos);
    }

    private void checkAndCreatePortal(Level level, BlockPos pos) {
        if (level.isClientSide()) return;
        BlockPattern pattern = getOrCreatePortalShape();
        for (int xOffset = -4; xOffset <= 0; ++xOffset) {
            for (int zOffset = -4; zOffset <= 0; ++zOffset) {
                BlockPos searchPos = pos.offset(xOffset, 0, zOffset);
                BlockPattern.BlockPatternMatch match = pattern.find(level, searchPos);
                if (match != null) {
                    BlockPos corner1 = match.getBlock(0, 0, 0).getPos();
                    BlockPos corner2 = match.getBlock(4, 0, 4).getPos();
                    int minX = Math.min(corner1.getX(), corner2.getX());
                    int maxX = Math.max(corner1.getX(), corner2.getX());
                    int minZ = Math.min(corner1.getZ(), corner2.getZ());
                    int maxZ = Math.max(corner1.getZ(), corner2.getZ());
                    int centerX = (minX + maxX) / 2;
                    int centerZ = ((minZ + maxZ) / 2) - 2;
                    int portalY = pos.getY();
                    BlockPos centerPos = new BlockPos(centerX, portalY, centerZ);
                    for (int x = -1; x <= 1; ++x) {
                        for (int z = -1; z <= 1; ++z) {
                            BlockPos portalTarget = centerPos.offset(x, 0, z);
                            level.setBlock(portalTarget, BlockRegistry.arcanaPortal.get().defaultBlockState(), Block.UPDATE_ALL);
                        }
                    }
                    level.globalLevelEvent(1038, centerPos, 0);
                    return;
                }
            }
        }
    }
}