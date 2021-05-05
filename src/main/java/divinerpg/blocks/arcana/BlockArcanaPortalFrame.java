package divinerpg.blocks.arcana;

import com.google.common.base.*;
import divinerpg.blocks.base.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.block.pattern.*;
import net.minecraft.item.*;
import net.minecraft.pathfinding.*;
import net.minecraft.state.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.shapes.*;
import net.minecraft.world.*;

public class BlockArcanaPortalFrame extends BlockMod {
    public static final DirectionProperty FACING = HorizontalBlock.FACING;
    protected static final VoxelShape BASE_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 13.0D, 16.0D);
    private static BlockPattern portalShape;

    public BlockArcanaPortalFrame(String name, Properties props) {
        super(name, props);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    public boolean useShapeForLightOcclusion(BlockState p_220074_1_) {
        return true;
    }

    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        return BASE_SHAPE;
    }

    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        return this.defaultBlockState().setValue(FACING, p_196258_1_.getHorizontalDirection().getOpposite());
    }


    public BlockState rotate(BlockState p_185499_1_, Rotation p_185499_2_) {
        return p_185499_1_.setValue(FACING, p_185499_2_.rotate(p_185499_1_.getValue(FACING)));
    }

    public BlockState mirror(BlockState p_185471_1_, Mirror p_185471_2_) {
        return p_185471_1_.rotate(p_185471_2_.getRotation(p_185471_1_.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(FACING);
    }

    public static BlockPattern getOrCreatePortalShape() {
        if (portalShape == null) {
            portalShape = BlockPatternBuilder.start().aisle("?vvv?", ">???<", ">???<", ">???<", "?^^^?").where('?', CachedBlockInfo.hasState(BlockStateMatcher.ANY)).where('^', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(BlockRegistry.arcanaPortalFrame).where(FACING, Predicates.equalTo(Direction.SOUTH)))).where('>', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(BlockRegistry.arcanaPortalFrame).where(FACING, Predicates.equalTo(Direction.WEST)))).where('v', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(BlockRegistry.arcanaPortalFrame).where(FACING, Predicates.equalTo(Direction.NORTH)))).where('<', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(BlockRegistry.arcanaPortalFrame).where(FACING, Predicates.equalTo(Direction.EAST)))).build();
        }

        return portalShape;
    }

    public boolean isPathfindable(BlockState p_196266_1_, IBlockReader p_196266_2_, BlockPos p_196266_3_, PathType p_196266_4_) {
        return false;
    }

    @Override
    public void neighborChanged(BlockState state, World world, BlockPos pos, Block block, BlockPos pos2, boolean unknown) {
        super.neighborChanged(state, world, pos, block, pos2, unknown);
        BlockPattern.PatternHelper frame = getOrCreatePortalShape().find(world, pos);
        if (frame != null) {
            BlockPos blockpos1 = frame.getFrontTopLeft().offset(-3, 0, -3);

            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    world.setBlock(blockpos1.offset(i, 0, j), BlockRegistry.arcanaPortal.defaultBlockState(), 2);
                }
            }

            world.globalLevelEvent(1038, blockpos1.offset(1, 0, 1), 0);
        }
    }

}
