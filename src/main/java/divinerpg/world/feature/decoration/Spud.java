package divinerpg.world.feature.decoration;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import divinerpg.world.config.tree.TreeConfig;
import divinerpg.world.feature.config.decoration.SpudConfig;
import divinerpg.world.feature.plant.Bush;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.List;

public class Spud implements Feature {
	public static final MapCodec<Spud> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(SpudConfig.CODEC.fieldOf("config").forGetter(f -> f.config)).apply(instance, Spud::new));
	private final SpudConfig config;
	public Spud(SpudConfig config) {
		this.config = config;
	}
	@Override
	public boolean place(WorldGenLevel level, ChunkGenerator chunkGenerator, RandomSource randomSource, BlockPos blockPos) {
		return place(config, level, chunkGenerator, randomSource, blockPos);
	}
	public boolean place(SpudConfig config, WorldGenLevel level, ChunkGenerator c, RandomSource random, BlockPos pos) {
		if(level.ensureCanWrite(pos) && GemCluster.canBeHere(level, random, pos, config.rules())) {
            config.center().ifPresent(s -> setBlock(level, pos, s));
			if(config.edge().isPresent()) {
                List<RuleTest> rules = config.edgerules().orElse(config.rules());
				BlockState edge = config.edge().get();
				if(GemCluster.rule(rules, random, level.getBlockState(pos.above()), pos)) setBlock(level, pos.above(), edge);
				if(GemCluster.rule(rules, random, level.getBlockState(pos.below()), pos)) setBlock(level, pos.below(), edge);
				if(GemCluster.rule(rules, random, level.getBlockState(pos.north()), pos)) setBlock(level, pos.north(), edge);
				if(GemCluster.rule(rules, random, level.getBlockState(pos.east()), pos)) setBlock(level, pos.east(), edge);
				if(GemCluster.rule(rules, random, level.getBlockState(pos.south()), pos)) setBlock(level, pos.south(), edge);
				if(GemCluster.rule(rules, random, level.getBlockState(pos.west()), pos)) setBlock(level, pos.west(), edge);
			} return true;
		} return false;
	}

	@Override
	public MapCodec<? extends Feature> codec() {
		return CODEC;
	}

}