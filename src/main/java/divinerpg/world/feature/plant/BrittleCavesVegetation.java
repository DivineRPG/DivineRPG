package divinerpg.world.feature.plant;

import divinerpg.registries.BlockRegistry;
import divinerpg.world.ConfiguredFeatureKeys;
import divinerpg.world.placement.Underground;
import net.minecraft.core.*;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class BrittleCavesVegetation extends Feature<NoneFeatureConfiguration> {
	public BrittleCavesVegetation() {super(NoneFeatureConfiguration.CODEC);}
	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		return place(null, context.level(), null, context.random(), context.origin());
	}
	@Override
	public boolean place(NoneFeatureConfiguration c, WorldGenLevel level, ChunkGenerator g, RandomSource random, BlockPos pos) {
		if(level.ensureCanWrite(pos) && Underground.isUnderground(level, pos) && pos.getY() < 63) {
			MutableBlockPos mut = pos.mutable();
			if(isAirOrVine(level.getBlockState(pos))) for(int i = 0; isAirOrVine(level.getBlockState(mut.move(Direction.UP))) && i < 16; i++);
			BlockState state = level.getBlockState(mut);
			if(state.is(Blocks.MOSS_BLOCK) || state.is(BlockTags.MOSS_REPLACEABLE) || state.is(BlockTags.SNOW)) {
				if(state.is(Blocks.MOSS_BLOCK)) {
					if(level.getBlockState(mut.move(Direction.UP)).isAir()) {
						if(random.nextBoolean()) setBlock(level, mut, Blocks.MOSS_CARPET.defaultBlockState());
						else if(random.nextBoolean()) setBlock(level, mut, Blocks.SHORT_GRASS.defaultBlockState());
						else if(random.nextBoolean()) setBlock(level, mut, Blocks.AZALEA.defaultBlockState());
						else if(random.nextBoolean()) setBlock(level, mut, Blocks.FLOWERING_AZALEA.defaultBlockState());
						else setBlock(level, mut, Blocks.BLUE_ORCHID.defaultBlockState());
					} else return false;
				} else if(level.getBlockState(mut.above()).isAir() || level.getBlockState(mut.below()).isAir()) {
					setBlock(level, mut, BlockRegistry.brittleMoss.get().defaultBlockState());
					if(random.nextBoolean()) ConfiguredFeatureKeys.getConfiguredFeature(level, ConfiguredFeatureKeys.BRITTLE_PLANTS).value().place(level, g, random, mut);
				} else
					return false;
				if(random.nextBoolean()) place(null, level, null, random, mut.offset(random.nextInt(5) - 2, random.nextInt(3) - 1, random.nextInt(5) - 2));
				if(random.nextBoolean()) place(null, level, null, random, mut.offset(random.nextInt(5) - 2, random.nextInt(3) - 1, random.nextInt(5) - 2));
				return true;
			}
		} return false;
	}
	public boolean isAirOrVine(BlockState state) {
		return state.isAir() || state.is(BlockRegistry.winterberryVinesHead) || state.is(BlockRegistry.winterberryVinesBody);
	}
}