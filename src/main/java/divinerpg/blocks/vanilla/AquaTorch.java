package divinerpg.blocks.vanilla;

import divinerpg.registries.ParticleRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.*;
import net.neoforged.api.distmarker.*;

import javax.annotation.Nullable;

public class AquaTorch extends TorchBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public AquaTorch(Properties p) {
        super(ParticleRegistry.BLUE_FLAME.get(), p);
        registerDefaultState(stateDefinition.any().setValue(WATERLOGGED, false));
    }
    @Nullable
    @Override public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        return super.getStateForPlacement(context).setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
        state.add(WATERLOGGED);
        super.createBlockStateDefinition(state);
    }
    @Override public FluidState getFluidState(BlockState state) {return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : Fluids.EMPTY.defaultFluidState();}
    @Override public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        double d0 = pos.getX() + .5;
        double d1 = pos.getY() + .7;
        double d2 = pos.getZ() + .5;
        if(state.getValue(WATERLOGGED)) level.addParticle(ParticleTypes.BUBBLE, d0, d1, d2, 0, 0, 0);
        else level.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0, 0, 0);
        level.addParticle(flameParticle, d0, d1, d2, 0, 0, 0);
    }
}