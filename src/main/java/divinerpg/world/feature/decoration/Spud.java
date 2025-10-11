package divinerpg.world.feature.decoration;

import divinerpg.world.feature.config.decoration.SpudConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.List;

public class Spud extends Feature<SpudConfig> {
	public Spud() {super(SpudConfig.CODEC);}
	@Override
	public boolean place(FeaturePlaceContext<SpudConfig> context) {
		return place(context.config(), context.level(), null, context.random(), context.origin());
	}
	@Override
	public boolean place(SpudConfig config, WorldGenLevel level, ChunkGenerator c, RandomSource random, BlockPos pos) {
		if(level.ensureCanWrite(pos) && GemCluster.canBeHere(level, random, pos, config.rules())) {
            config.center().ifPresent(s -> setBlock(level, pos, s));
			if(config.edge().isPresent()) {
                List<RuleTest> rules = config.edgerules().orElse(config.rules());
				BlockState edge = config.edge().get();
				if(GemCluster.rule(rules, random, level.getBlockState(pos.above()))) setBlock(level, pos.above(), edge);
				if(GemCluster.rule(rules, random, level.getBlockState(pos.below()))) setBlock(level, pos.below(), edge);
				if(GemCluster.rule(rules, random, level.getBlockState(pos.north()))) setBlock(level, pos.north(), edge);
				if(GemCluster.rule(rules, random, level.getBlockState(pos.east()))) setBlock(level, pos.east(), edge);
				if(GemCluster.rule(rules, random, level.getBlockState(pos.south()))) setBlock(level, pos.south(), edge);
				if(GemCluster.rule(rules, random, level.getBlockState(pos.west()))) setBlock(level, pos.west(), edge);
			} return true;
		} return false;
	}
}