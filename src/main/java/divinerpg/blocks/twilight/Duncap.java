package divinerpg.blocks.twilight;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.phys.shapes.*;

import static net.minecraft.core.Direction.Plane.HORIZONTAL;

public class Duncap extends BushBlock {
    public static final VoxelShape
            SHAPENORTH = Block.box(2, 0, 7, 14, 16, 16), SHAPESOUTH = Block.box(2, 0, 0, 14, 16, 9),
            SHAPEWEST = Block.box(7, 0, 2, 16, 16, 14), SHAPEEAST = Block.box(0, 0, 2, 9, 16, 14);
    public static final MapCodec<Duncap> CODEC = simpleCodec(Duncap::new);
    public Duncap() {
        this(Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK));
    }
    public Duncap(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any().setValue(HorizontalDirectionalBlock.FACING, Direction.NORTH));
    }
    @Override protected MapCodec<? extends BushBlock> codec() {return CODEC;}
    @Override protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        for(Direction d : HORIZONTAL) {
            BlockPos p = pos.relative(d);
            if(level.getBlockState(p).isFaceSturdy(level, p, d.getOpposite())) return true;
        } return false;
    }
    @Override protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        Direction d = state.getValue(HorizontalDirectionalBlock.FACING);
        BlockPos p = pos.relative(d.getOpposite());
        return level.getBlockState(p).isFaceSturdy(level, p, d);
    }
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(HorizontalDirectionalBlock.FACING);
        return switch(direction) {
            case SOUTH -> SHAPESOUTH;
            case WEST -> SHAPEWEST;
            case EAST -> SHAPEEAST;
            default -> SHAPENORTH;
        };
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, context.getHorizontalDirection().getOpposite());
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HorizontalDirectionalBlock.FACING);
    }
}