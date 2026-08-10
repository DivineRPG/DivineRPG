package divinerpg.blocks.twilight;

import com.google.common.collect.*;
import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.shapes.*;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static net.minecraft.stats.Stats.ITEM_USED;
import static net.minecraft.world.level.block.VineBlock.isAcceptableNeighbour;
import static net.minecraft.world.level.block.state.properties.BlockStateProperties.*;
import static net.neoforged.neoforge.common.ItemAbilities.SHEARS_DIG;

public class LandVine extends Block implements BonemealableBlock {
    public static final VoxelShape WEST_AABB = Block.box(0, 0, 0, 1, 16, 16),
            EAST_AABB = Block.box(15, 0, 0, 16, 16, 16),
            NORTH_AABB = Block.box(0, 0, 0, 16, 16, 1),
            SOUTH_AABB = Block.box(0, 0, 15, 16, 16, 16);
    public static final BooleanProperty[] PROPERTIES = {NORTH, SOUTH, WEST, EAST};
    final Map<BlockState, VoxelShape> shapesCache;
    public LandVine(Properties properties) {
        super(properties);
        registerDefaultState((stateDefinition.any()).setValue(NORTH, false).setValue(BlockStateProperties.EAST, false).setValue(BlockStateProperties.SOUTH, false).setValue(BlockStateProperties.WEST, false).setValue(BOTTOM, false));
        shapesCache = ImmutableMap.copyOf(stateDefinition.getPossibleStates().stream().collect(Collectors.toMap(Function.identity(), LandVine::calculateShape)));
    }
    public static BooleanProperty byDirection(Direction d) {return PROPERTIES[d.ordinal() - 2];}
    static VoxelShape calculateShape(BlockState state) {
        VoxelShape voxelshape = Shapes.empty();
        if(state.getValue(NORTH)) voxelshape = NORTH_AABB;
        if(state.getValue(BlockStateProperties.SOUTH)) voxelshape = Shapes.or(voxelshape, SOUTH_AABB);
        if(state.getValue(BlockStateProperties.EAST)) voxelshape = Shapes.or(voxelshape, EAST_AABB);
        if(state.getValue(BlockStateProperties.WEST)) voxelshape = Shapes.or(voxelshape, WEST_AABB);
        return voxelshape.isEmpty() ? Shapes.block() : voxelshape;
    }
    @Override protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {return shapesCache.get(state);}
    @Override protected boolean propagatesSkylightDown(BlockState state) {return true;}
    @Override protected float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
        float baseProgress = super.getDestroyProgress(state, player, level, pos);
        return player.getMainHandItem().canPerformAction(SHEARS_DIG) ? baseProgress * 2 : baseProgress;
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, ItemStack toolStack, boolean willHarvest, FluidState fluid) {
        if(player.getMainHandItem().getItem() instanceof ShearsItem) player.awardStat(ITEM_USED.get(player.getMainHandItem().getItem()));
        return super.onDestroyedByPlayer(state, level, pos, player, toolStack, willHarvest, fluid);
    }
    boolean canSupportAtFace(BlockGetter level, BlockPos pos, Direction direction) {
        if(direction.getAxis() == Direction.Axis.Y) return false;
        BlockPos blockpos = pos.relative(direction);
        if(isAcceptableNeighbour(level, blockpos, direction)) return true;
        BlockState blockstate = level.getBlockState(pos.above());
        return blockstate.is(this) && blockstate.getValue(byDirection(direction));
    }
    BlockState getUpdatedState(BlockState state, BlockGetter level, BlockPos pos) {
        BlockPos belowPos = pos.below();
        BlockState belowState = level.getBlockState(belowPos);
        state = state.setValue(BOTTOM, !(belowState.is(this) || belowState.isFaceSturdy(level, belowPos, Direction.UP)));
        for(Direction direction : Direction.Plane.HORIZONTAL) state = state.setValue(byDirection(direction), canSupportAtFace(level, pos, direction));
        return state;
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
        BlockState blockstate = getUpdatedState(state, level, pos);
        return hasFaces(blockstate) ? blockstate : state;
    }
    static boolean hasFaces(BlockState state) {
        for(BooleanProperty property : PROPERTIES) if(state.getValue(property)) return true;
        return false;
    }
    boolean canSpread(BlockGetter blockReader, BlockPos pos) {
        Iterable<BlockPos> iterable = BlockPos.betweenClosed(pos.getX() - 4, pos.getY() - 1, pos.getZ() - 4, pos.getX() + 4, pos.getY() + 1, pos.getZ() + 4);
        int j = 5;
        for(BlockPos blockpos : iterable) if(blockReader.getBlockState(blockpos).is(this)) if(--j == 0) return false;
        return true;
    }
    void spread(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if(state.getValue(BOTTOM) && level.getBlockState(pos.below()).isAir()) {
            BlockPos.MutableBlockPos m = pos.mutable();
            int i = 0;
            while(i < 3 && level.getBlockState(m.move(Direction.UP)).is(this)) i++;
            if(i < 3) level.setBlock(pos.below(), state, 3);
        } else {
            Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);
            if(!state.getValue(byDirection(direction)) && canSpread(level, pos)) {
                BlockPos relative = pos.relative(direction);
                if(level.getBlockState(relative).isAir()) {
                    BlockState spreadState = getUpdatedState(state, level, relative);
                    if(hasFaces(spreadState)) level.setBlock(relative, spreadState, 2);
                }
            }
        }
    }
    @Override protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if(level.getGameRules().get(GameRules.SPREAD_VINES) && random.nextInt(4) == 0 && level.isAreaLoaded(pos, 4)) spread(state, level, pos, random);
    }
    @Override public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos());
        boolean sameBlock = blockstate.is(this);
        BlockState state = sameBlock ? blockstate : defaultBlockState();
        for(Direction direction : context.getNearestLookingDirections()) if(direction.getAxis() != Direction.Axis.Y) {
            BooleanProperty booleanproperty = byDirection(direction);
            boolean flag1 = sameBlock && blockstate.getValue(booleanproperty);
            if(!flag1 && canSupportAtFace(context.getLevel(), context.getClickedPos(), direction)) return state.setValue(booleanproperty, true);
        } return sameBlock ? state : null;
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(NORTH, EAST, SOUTH, WEST, BOTTOM);}
    @Override protected BlockState rotate(BlockState state, Rotation rotation) {
        return switch(rotation) {
            case CLOCKWISE_180 -> state.setValue(NORTH, state.getValue(SOUTH)).setValue(EAST, state.getValue(WEST)).setValue(SOUTH, state.getValue(NORTH)).setValue(WEST, state.getValue(EAST));
            case COUNTERCLOCKWISE_90 -> state.setValue(NORTH, state.getValue(EAST)).setValue(EAST, state.getValue(SOUTH)).setValue(SOUTH, state.getValue(WEST)).setValue(WEST, state.getValue(NORTH));
            case CLOCKWISE_90 -> state.setValue(NORTH, state.getValue(WEST)).setValue(EAST, state.getValue(NORTH)).setValue(SOUTH, state.getValue(EAST)).setValue(WEST, state.getValue(SOUTH));
            default -> state;
        };
    }
    @Override protected BlockState mirror(BlockState state, Mirror mirror) {
        return switch(mirror) {
            case LEFT_RIGHT -> state.setValue(NORTH, state.getValue(SOUTH)).setValue(SOUTH, state.getValue(NORTH));
            case FRONT_BACK -> state.setValue(EAST, state.getValue(WEST)).setValue(WEST, state.getValue(EAST));
            default -> super.mirror(state, mirror);
        };
    }
    @Override public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {return true;}
    @Override public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {return true;}
    @Override public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        blockState = getUpdatedState(blockState, serverLevel, blockPos);
        serverLevel.setBlock(blockPos, blockState, 3);
        spread(blockState, serverLevel, blockPos, randomSource);
    }
    @Override public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 100;}
    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 15;}
}