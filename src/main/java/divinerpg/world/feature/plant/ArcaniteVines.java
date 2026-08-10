package divinerpg.world.feature.plant;

import divinerpg.registries.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class ArcaniteVines extends Feature<NoneFeatureConfiguration> {
	public ArcaniteVines() {super(NoneFeatureConfiguration.CODEC);}
	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		return place(null, context.level(), null, context.random(), context.origin());
	}
	@Override
	public boolean place(NoneFeatureConfiguration c, WorldGenLevel level, ChunkGenerator g, RandomSource random, BlockPos pos) {
		pos = new BlockPos(pos.getX(), 46, pos.getZ());
		while(!level.getBlockState(pos).is(BlockRegistry.arcaniteMoss.get())) {
			pos = pos.above();
			if(pos.getY() > 76) return false;
		}
		do {
			pos = pos.below();
			if(level.getBlockState(pos).isAir()) setBlock(level, pos, BlockRegistry.arcaniteVinesBody.get().defaultBlockState());
			else break;
		} while(random.nextBoolean());
		setBlock(level, pos, BlockRegistry.arcaniteVinesHead.get().defaultBlockState());
		return true;
	}
}