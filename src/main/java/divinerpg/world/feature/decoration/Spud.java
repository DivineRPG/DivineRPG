package divinerpg.world.feature.decoration;

import divinerpg.world.feature.config.decoration.SpudConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.*;

public class Spud extends Feature<SpudConfig> {
	public Spud() {super(SpudConfig.CODEC);}
	@Override
	public boolean place(FeaturePlaceContext<SpudConfig> context) {
		return place(context.config(), context.level(), null, context.random(), context.origin());
	}
	@Override
	public boolean place(SpudConfig config, WorldGenLevel level, ChunkGenerator c, RandomSource random, BlockPos pos) {
		if(GemCluster.canBeHere(level, random, pos, config.rules)) {
			setBlock(level, pos, config.center);
			if(config.edge.isPresent()) {
				BlockState edge = config.edge.get();
				if(GemCluster.rule(config.rules, random, level.getBlockState(pos.above()))) setBlock(level, pos.above(), edge);
				if(GemCluster.rule(config.rules, random, level.getBlockState(pos.below()))) setBlock(level, pos.below(), edge);
				if(GemCluster.rule(config.rules, random, level.getBlockState(pos.north()))) setBlock(level, pos.north(), edge);
				if(GemCluster.rule(config.rules, random, level.getBlockState(pos.east()))) setBlock(level, pos.east(), edge);
				if(GemCluster.rule(config.rules, random, level.getBlockState(pos.south()))) setBlock(level, pos.south(), edge);
				if(GemCluster.rule(config.rules, random, level.getBlockState(pos.west()))) setBlock(level, pos.west(), edge);
			} return true;
		} return false;
	}
}