package divinerpg.world.feature.tree;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import divinerpg.world.config.tree.TreeConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;

public class Slowsprout extends Glowsprout {
	public static final MapCodec<Slowsprout> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(TreeConfig.CODEC.fieldOf("config").forGetter(f -> f.config)).apply(instance, Slowsprout::new));
	private TreeConfig config;
	public Slowsprout(TreeConfig config) {
		super(config);
		this.config = config;
	}

	@Override
	public MapCodec<? extends Feature> codec() {
		return CODEC;
	}

	@Override
	protected void growLeaves(WorldGenLevel level, RandomSource random, BlockPos pos, BlockState leaves) {
		setBlock(level, pos, leaves, false);
		grow(level, pos, leaves, 1, 0);
		grow(level, pos, leaves, 1, 1);
		grow(level, pos, leaves, 2, -1);
		grow(level, pos, leaves, 2, 0);
		grow(level, pos, leaves, 2, 1);
		pos = pos.offset(0, -1, 0);
		grow(level, pos, Blocks.PEARLESCENT_FROGLIGHT.defaultBlockState(), 1, 0);
		grow(level, pos, leaves, 2, 2);
		grow(level, pos, leaves, 3, -2);
		grow(level, pos, leaves, 3, -1);
		grow(level, pos, leaves, 3, 0);
		grow(level, pos, leaves, 3, 1);
		grow(level, pos, leaves, 3, 2);
		if(random.nextBoolean()) {
			pos = pos.offset(0, -1, 0);
			grow(level, pos, leaves, 3, 3);
			grow(level, pos, leaves, 4, -2);
			grow(level, pos, leaves, 4, -1);
			grow(level, pos, leaves, 4, 0);
			grow(level, pos, leaves, 4, 1);
			grow(level, pos, leaves, 4, 2);
		}
	}
}