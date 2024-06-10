package divinerpg.blocks.vanilla;

import divinerpg.blocks.base.BlockModWallTorch;
import divinerpg.registries.ParticleRegistry;
import net.minecraft.core.*;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.*;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;

public class BlockAquaWallTorch extends BlockModWallTorch implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public BlockAquaWallTorch() {registerDefaultState(stateDefinition.any().setValue(WATERLOGGED, Boolean.FALSE));}
    @Nullable
    @Override public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        BlockState blockstate = defaultBlockState();
        LevelReader levelreader = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        Direction[] adirection = context.getNearestLookingDirections();
        for(Direction direction : adirection) {
            if (direction.getAxis().isHorizontal()) {
                Direction direction1 = direction.getOpposite();
                blockstate = blockstate.setValue(FACING, direction1).setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
                if(blockstate.canSurvive(levelreader, blockpos)) return blockstate;
            }
        } return null;
    }
    @Override public BlockState updateShape(BlockState state, Direction dir, BlockState state1, LevelAccessor level, BlockPos pos, BlockPos pos1) {
        if(state.getValue(WATERLOGGED)) level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        return super.updateShape(state, dir, state1, level, pos, pos1);
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
        state.add(WATERLOGGED);
        super.createBlockStateDefinition(state);
    }
    @Override public FluidState getFluidState(BlockState state) {return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : Fluids.EMPTY.defaultFluidState();}
    @OnlyIn(Dist.CLIENT)
    @Override public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        double d0 = pos.getX() + .5;
        double d1 = pos.getY() + .7;
        double d2 = pos.getZ() + .5;
        double d3 = .22;
        double d4 = .27;
        Direction dir1 = state.getValue(FACING).getOpposite();
        if(state.getValue(WATERLOGGED)) level.addParticle(ParticleTypes.BUBBLE, d0 + d4 * dir1.getStepX(), d1 + d3, d2 + d4 * dir1.getStepZ(), 0, 0, 0);
        else level.addParticle(ParticleTypes.SMOKE, d0 + d4 * dir1.getStepX(), d1 + d3, d2 + d4 * dir1.getStepZ(), 0, 0, 0);
        level.addParticle(ParticleRegistry.BLUE_FLAME.get(), d0 + d4 * dir1.getStepX(), d1 + d3, d2 + d4 * dir1.getStepZ(), 0, 0, 0);
    }
}