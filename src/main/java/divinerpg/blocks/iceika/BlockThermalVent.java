package divinerpg.blocks.iceika;

import javax.annotation.Nullable;

import divinerpg.blocks.base.BlockMod;
import net.minecraft.core.*;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.shapes.*;

public class BlockThermalVent extends BlockMod implements SimpleWaterloggedBlock {
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final VoxelShape AABB = Block.box(2D, 0D, 2D, 14D, 14D, 14D);
	public BlockThermalVent() {
		super(Properties.copy(Blocks.POINTED_DRIPSTONE).color(MaterialColor.STONE).requiresCorrectToolForDrops());
		registerDefaultState(stateDefinition.any().setValue(WATERLOGGED, Boolean.valueOf(true)));
	}
	@Override
	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
		if(state.getValue(WATERLOGGED)) level.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, pos.getX() + 0.5, pos.getY() + 0.8, pos.getZ() + 0.5, 0D, 0.1, 0D);
		else if(random.nextBoolean()) level.addParticle(ParticleTypes.SMOKE, pos.getX() + 0.5, pos.getY() + 0.8, pos.getZ() + 0.5, 0D, 0.1, 0D);
	}
	@Override
	public boolean canSurvive(BlockState p_49169_, LevelReader p_49170_, BlockPos p_49171_) {
		BlockPos blockpos = p_49171_.below();
		return p_49170_.getBlockState(blockpos).isFaceSturdy(p_49170_, blockpos, Direction.UP);
	}
	@Override @Nullable
	public BlockState getStateForPlacement(BlockPlaceContext p_49163_) {
		FluidState fluidstate = p_49163_.getLevel().getFluidState(p_49163_.getClickedPos());
		return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluidstate.is(FluidTags.WATER) && fluidstate.getAmount() == 8));
	}
	@Override
	public VoxelShape getShape(BlockState p_49182_, BlockGetter p_49183_, BlockPos p_49184_, CollisionContext p_49185_) {
		return AABB;
	}
	@Override
	public BlockState updateShape(BlockState state, Direction direction, BlockState s, LevelAccessor level, BlockPos pos, BlockPos p) {
		if (direction == Direction.DOWN && !state.canSurvive(level, pos)) return Blocks.AIR.defaultBlockState();
		if (state.getValue(WATERLOGGED)) level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
	    return state;
	}
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49180_) {
		p_49180_.add(WATERLOGGED);
	}
	@Override
	public FluidState getFluidState(BlockState p_49191_) {
		return p_49191_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : Fluids.EMPTY.defaultFluidState();
	}
}