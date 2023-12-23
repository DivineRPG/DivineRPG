package divinerpg.blocks.iceika;

import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.sounds.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.portal.PortalShape;
import java.util.Optional;

public class BlockIceikaFire extends BaseFireBlock {
	public BlockIceikaFire() {
		super(BlockBehaviour.Properties.copy(Blocks.SOUL_FIRE).lightLevel((state) -> 7), 1F);
	}
	private static boolean inPortalDimension(Level level) {
		return level.dimension() == Level.OVERWORLD || level.dimension() == LevelRegistry.ICEIKA;
	}
	@Override
	public void entityInside(BlockState p_49260_, Level level, BlockPos p_49262_, Entity entity) {
		if(entity.canFreeze()) {
			entity.setTicksFrozen(entity.getTicksFrozen() + 4);
			if(entity.tickCount % 15 == 0) entity.hurt(level.damageSources().freeze(), 1);
		}
	}
	@Override
	public void animateTick(BlockState p_220763_, Level p_220764_, BlockPos p_220765_, RandomSource p_220766_) {
		if (p_220766_.nextInt(24) == 0) {
			p_220764_.playLocalSound((double)p_220765_.getX() + 0.5D, (double)p_220765_.getY() + 0.5D, (double)p_220765_.getZ() + 0.5D, SoundEvents.FIRE_AMBIENT, SoundSource.BLOCKS, 1.0F + p_220766_.nextFloat(), p_220766_.nextFloat() * 0.7F + 0.3F, false);
		}
		BlockPos blockpos = p_220765_.below();
		BlockState blockstate = p_220764_.getBlockState(blockpos);
		if (!this.canBurn(blockstate) && !blockstate.isFaceSturdy(p_220764_, blockpos, Direction.UP)) {
			if (this.canBurn(p_220764_.getBlockState(p_220765_.west()))) {
				for(int j = 0; j < 2; ++j) {
					double d3 = (double)p_220765_.getX() + p_220766_.nextDouble() * (double)0.1F;
					double d8 = (double)p_220765_.getY() + p_220766_.nextDouble();
					double d13 = (double)p_220765_.getZ() + p_220766_.nextDouble();
					p_220764_.addParticle(ParticleRegistry.FROST.get(), d3, d8, d13, 0.0D, 0.0D, 0.0D);
				}
			}

			if (this.canBurn(p_220764_.getBlockState(p_220765_.east()))) {
				for(int k = 0; k < 2; ++k) {
					double d4 = (double)(p_220765_.getX() + 1) - p_220766_.nextDouble() * (double)0.1F;
					double d9 = (double)p_220765_.getY() + p_220766_.nextDouble();
					double d14 = (double)p_220765_.getZ() + p_220766_.nextDouble();
					p_220764_.addParticle(ParticleRegistry.FROST.get(), d4, d9, d14, 0.0D, 0.0D, 0.0D);
				}
			}

			if (this.canBurn(p_220764_.getBlockState(p_220765_.north()))) {
				for(int l = 0; l < 2; ++l) {
					double d5 = (double)p_220765_.getX() + p_220766_.nextDouble();
					double d10 = (double)p_220765_.getY() + p_220766_.nextDouble();
					double d15 = (double)p_220765_.getZ() + p_220766_.nextDouble() * (double)0.1F;
					p_220764_.addParticle(ParticleRegistry.FROST.get(), d5, d10, d15, 0.0D, 0.0D, 0.0D);
				}
			}

			if (this.canBurn(p_220764_.getBlockState(p_220765_.south()))) {
				for(int i1 = 0; i1 < 2; ++i1) {
					double d6 = (double)p_220765_.getX() + p_220766_.nextDouble();
					double d11 = (double)p_220765_.getY() + p_220766_.nextDouble();
					double d16 = (double)(p_220765_.getZ() + 1) - p_220766_.nextDouble() * (double)0.1F;
					p_220764_.addParticle(ParticleRegistry.FROST.get(), d6, d11, d16, 0.0D, 0.0D, 0.0D);
				}
			}

			if (this.canBurn(p_220764_.getBlockState(p_220765_.above()))) {
				for(int j1 = 0; j1 < 2; ++j1) {
					double d7 = (double)p_220765_.getX() + p_220766_.nextDouble();
					double d12 = (double)(p_220765_.getY() + 1) - p_220766_.nextDouble() * (double)0.1F;
					double d17 = (double)p_220765_.getZ() + p_220766_.nextDouble();
					p_220764_.addParticle(ParticleRegistry.FROST.get(), d7, d12, d17, 0.0D, 0.0D, 0.0D);
				}
			}
		} else {
			for(int i = 0; i < 3; ++i) {
				double d0 = (double)p_220765_.getX() + p_220766_.nextDouble();
				double d1 = (double)p_220765_.getY() + p_220766_.nextDouble() * 0.5D + 0.5D;
				double d2 = (double)p_220765_.getZ() + p_220766_.nextDouble();
				p_220764_.addParticle(ParticleRegistry.FROST.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
			}
		}

	}
	@Override
	public void onPlace(BlockState state, Level level, BlockPos pos, BlockState s, boolean p_49283_) {
		if(!s.is(state.getBlock())) {
			if(inPortalDimension(level)) {
	            Optional<PortalShape> optional = PortalShape.findEmptyPortalShape(level, pos, Direction.Axis.X);
				optional = net.minecraftforge.event.ForgeEventFactory.onTrySpawnPortal(level, pos, optional);
				if (optional.isPresent()) {
					optional.get().createPortalBlocks();
					return;
				}
			}
			if(!canBurn(level.getBlockState(pos.below()))) level.removeBlock(pos, false);
		}
	}
	@Override
	public BlockState updateShape(BlockState state, Direction dir, BlockState s, LevelAccessor level, BlockPos pos, BlockPos p) {
		return canBurn(level.getBlockState(pos.below())) ? defaultBlockState() : Blocks.AIR.defaultBlockState();
	}
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return defaultBlockState();
	}
	@Override
	public boolean canSurvive(BlockState s, LevelReader level, BlockPos pos) {
		return canBurn(level.getBlockState(pos.below()));
	}
	@Override
	protected boolean canBurn(BlockState state) {
		return state.is(BlockTags.SNOW) || state.is(BlockTags.ICE);
	}
}