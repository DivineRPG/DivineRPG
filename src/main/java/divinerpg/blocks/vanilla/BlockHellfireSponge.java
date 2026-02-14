package divinerpg.blocks.vanilla;

import java.util.Optional;
import divinerpg.blocks.base.BlockMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;

import static divinerpg.registries.BlockRegistry.coldHellfireSponge;
import static net.minecraft.core.particles.ParticleTypes.SMOKE;
import static net.minecraft.sounds.SoundEvents.GENERIC_EXTINGUISH_FIRE;
import static net.minecraft.sounds.SoundSource.BLOCKS;
import static net.minecraft.world.level.block.LevelEvent.PARTICLES_WATER_EVAPORATING;
import static net.minecraft.world.level.block.state.properties.BlockStateProperties.WATERLOGGED;
import static net.minecraft.world.level.material.MapColor.FIRE;

public class BlockHellfireSponge extends BlockMod {
	public BlockHellfireSponge() {super(Properties.ofFullCopy(Blocks.SPONGE).mapColor(FIRE));}
	@Override public void onPlace(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
		if(tryRemoveWater(level, pos.above(), 64) | tryRemoveWater(level, pos.below(), 64) | tryRemoveWater(level, pos.north(), 64) | tryRemoveWater(level, pos.south(), 64) | tryRemoveWater(level, pos.east(), 64) | tryRemoveWater(level, pos.west(), 64)) {
			level.setBlock(pos, coldHellfireSponge.get().defaultBlockState(), UPDATE_ALL);
			level.levelEvent(PARTICLES_WATER_EVAPORATING, pos, 0);
			level.playSound(null, pos, GENERIC_EXTINGUISH_FIRE, BLOCKS, 1, 1);
		}
	}
	protected boolean tryRemoveWater(Level level, BlockPos pos, int distance) {
		if(distance > 0) {
			distance--;
			boolean b = false;
			BlockState state = level.getBlockState(pos);
			if(state.is(Blocks.WATER) || state.is(Blocks.BUBBLE_COLUMN) || state.is(Blocks.SEAGRASS) || state.is(Blocks.TALL_SEAGRASS)) {
				level.setBlock(pos, Blocks.AIR.defaultBlockState(), UPDATE_ALL);
				b = true;
			} else if(state.is(Blocks.KELP) || state.is(Blocks.KELP_PLANT)) {
				state.onDestroyedByPlayer(level, pos, null, true, level.getFluidState(pos));
				level.setBlock(pos, Blocks.AIR.defaultBlockState(), UPDATE_ALL);
				b = true;
			} else {
				Optional<Boolean> o = state.getOptionalValue(WATERLOGGED);
				if(o.isPresent() && o.get()) {
					level.setBlock(pos, state.setValue(WATERLOGGED, false), UPDATE_ALL);
					b = true;
				}
			} if(b) {
				level.addParticle(SMOKE, pos.getX(), pos.getY(), pos.getZ(), 0, .1, 0); //TODO: either this doesn't do anything or the impact is insignificant
				tryRemoveWater(level, pos.above(), distance);
				tryRemoveWater(level, pos.below(), distance);
				tryRemoveWater(level, pos.north(), distance);
				tryRemoveWater(level, pos.south(), distance);
				tryRemoveWater(level, pos.east(), distance);
				tryRemoveWater(level, pos.west(), distance);
			} return b;
		} return false;
	}
}