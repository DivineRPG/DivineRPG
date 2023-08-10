package divinerpg.blocks.vanilla;

import java.util.Optional;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockHellfireSponge extends BlockMod {
	public BlockHellfireSponge() {
		super(Block.Properties.copy(Blocks.SPONGE));
	}
	@Override
	public void onPlace(BlockState state, Level level, BlockPos pos, BlockState s, boolean b) {
//		BlockPos position;
//		for(int x = pos.getX() - 16; x < pos.getX() + 16; x++) for(int y = pos.getY() - 16; y < pos.getY() + 16; y++) for(int z = pos.getZ() - 16; z < pos.getZ() + 16; z++) {
//			BlockState st = level.getBlockState(position = new BlockPos(x, y, z));
//			if(st.is(Blocks.WATER)) {
//				level.setBlock(position, Blocks.AIR.defaultBlockState(), UPDATE_ALL);
//				level.addParticle(ParticleTypes.SMOKE, x, y, z, 0D, .1, 0D);
//				bu = true;
//				continue;
//			}
//			Optional<Boolean> o = st.getOptionalValue(BlockStateProperties.WATERLOGGED);
//			if(o.isPresent() && o.get()) {
//				level.setBlock(position, st.setValue(BlockStateProperties.WATERLOGGED, false), UPDATE_ALL);
//				level.addParticle(ParticleTypes.SMOKE, x, y, z, 0D, .1, 0D);
//				bu = true;
//			}
//		}
		boolean bu = tryRemoveWater(level, pos.above(), 16) | tryRemoveWater(level, pos.below(), 16) | tryRemoveWater(level, pos.north(), 16) | tryRemoveWater(level, pos.south(), 16) | tryRemoveWater(level, pos.east(), 16) | tryRemoveWater(level, pos.west(), 16);
		if(bu) {
			level.setBlock(pos, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "cold_hellfire_sponge")).defaultBlockState(), UPDATE_ALL);
			level.playLocalSound(pos, SoundEvents.GENERIC_EXTINGUISH_FIRE, SoundSource.BLOCKS, 1F, 1F, false);
		}
	}
	protected boolean tryRemoveWater(Level level, BlockPos pos, int distance) {
		BlockState state = level.getBlockState(pos);
		if(state.is(Blocks.WATER)) {
			removeWater(level, pos, Blocks.AIR.defaultBlockState(), distance);
			return true;
		}
		Optional<Boolean> o = state.getOptionalValue(BlockStateProperties.WATERLOGGED);
		if(o.isPresent() && o.get()) {
			removeWater(level, pos, state.setValue(BlockStateProperties.WATERLOGGED, false), distance);
			return true;
		} return false;
	}
	protected void removeWater(Level level, BlockPos pos, BlockState replace, int distance) {
		level.setBlock(pos, replace, UPDATE_ALL);
		level.addParticle(ParticleTypes.SMOKE, pos.getX(), pos.getY(), pos.getZ(), 0, 0.1, 0);
		if(distance > 0) {
			distance--;
			tryRemoveWater(level, pos.above(), distance);
			tryRemoveWater(level, pos.below(), distance);
			tryRemoveWater(level, pos.north(), distance);
			tryRemoveWater(level, pos.south(), distance);
			tryRemoveWater(level, pos.east(), distance);
			tryRemoveWater(level, pos.west(), distance);
		}
	}
}