package divinerpg.world.feature.decoration;

import com.mojang.serialization.MapCodec;
import divinerpg.registries.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.*;

public class ThermalVent implements Feature {
	public static final MapCodec<ThermalVent> CODEC = MapCodec.unit(ThermalVent::new);

	@Override
	public MapCodec<ThermalVent> codec() {
		return CODEC;
	}

	@Override
	public boolean place(WorldGenLevel level, ChunkGenerator g, RandomSource random, BlockPos pos) {
		BlockState state = level.getBlockState(pos);
		if(state.isAir()) {
			state = level.getBlockState(pos.below());
			if(!state.isAir() && !state.is(Blocks.WATER)) {
				setBlock(level, pos.below(), BlockRegistry.coalstone.get().defaultBlockState());
				return true;
			}
		} else if(state.is(Blocks.WATER)) {
			state = level.getBlockState(pos.below());
			if(!state.isAir() && !state.is(Blocks.WATER)) {
				setBlock(level, pos.below(), BlockRegistry.coalstone.get().defaultBlockState());
				setBlock(level, pos, BlockRegistry.thermalVent.get().defaultBlockState());
				return true;
			}
		} else {
			state = level.getBlockState(pos.above());
			if(state.isAir()) {
				setBlock(level, pos, BlockRegistry.coalstone.get().defaultBlockState());
				return true;
			} else if(state.is(Blocks.WATER)) {
				setBlock(level, pos, BlockRegistry.coalstone.get().defaultBlockState());
				setBlock(level, pos.above(), BlockRegistry.thermalVent.get().defaultBlockState());
				return true;
			}
		}
		return false;
	}
}