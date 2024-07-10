package divinerpg.world.feature.decoration;

import divinerpg.blocks.iceika.BlockThermalVent;
import divinerpg.registries.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class ThermalVent extends Feature<NoneFeatureConfiguration> {
	public ThermalVent() {super(NoneFeatureConfiguration.CODEC);}
	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		return place(null, context.level(), null, context.random(), context.origin());
	}
	@Override
	public boolean place(NoneFeatureConfiguration c, WorldGenLevel level, ChunkGenerator g, RandomSource random, BlockPos pos) {
		BlockState state = level.getBlockState(pos);
		if(state.isAir()) {
			state = level.getBlockState(pos.below());
			if(!state.isAir() && !state.is(Blocks.WATER)) {
				setBlock(level, pos.below(), BlockRegistry.coalstone.get().defaultBlockState());
				setBlock(level, pos, BlockRegistry.thermalVent.get().defaultBlockState().setValue(BlockThermalVent.WATERLOGGED, false));
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
				setBlock(level, pos.above(), BlockRegistry.thermalVent.get().defaultBlockState().setValue(BlockThermalVent.WATERLOGGED, false));
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