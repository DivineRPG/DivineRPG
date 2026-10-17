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

public class Lowsprout extends Glowsprout {
	public static final MapCodec<Lowsprout> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(TreeConfig.CODEC.fieldOf("config").forGetter(f -> f.config)).apply(instance, Lowsprout::new));
	private TreeConfig config;
	public Lowsprout(TreeConfig config) {
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
		pos = pos.offset(0, -1, 0);
		grow(level, pos, leaves, 1, 0);
		pos = pos.offset(0, -1, 0);
		grow(level, pos, Blocks.VERDANT_FROGLIGHT.defaultBlockState(), 1, 0);
		grow(level, pos, leaves, 1, 1);
		grow(level, pos, leaves, 2, 0);
		if(random.nextBoolean()) {
			pos = pos.offset(0, -1, 0);
			grow(level, pos, leaves, 2, -1);
			grow(level, pos, leaves, 2, 1);
			grow(level, pos, leaves, 3, 0);
		}
	}
}