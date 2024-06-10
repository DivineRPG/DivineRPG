package divinerpg.blocks.vanilla;

import divinerpg.blocks.base.BlockModTorch;
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

public class BlockAquaTorch extends BlockModTorch implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public BlockAquaTorch() {registerDefaultState(stateDefinition.any().setValue(WATERLOGGED, Boolean.FALSE));}
    @Nullable
    @Override public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        return super.getStateForPlacement(context).setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
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
        if(state.getValue(WATERLOGGED)) level.addParticle(ParticleTypes.BUBBLE, d0, d1, d2, 0, 0, 0);
        else level.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0, 0, 0);
        level.addParticle(ParticleRegistry.BLUE_FLAME.get(), d0, d1, d2, 0, 0, 0);
    }
}