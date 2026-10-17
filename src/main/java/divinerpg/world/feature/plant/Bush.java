package divinerpg.world.feature.plant;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import divinerpg.world.config.tree.TreeConfig;
import divinerpg.world.feature.tree.DivineTree;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;

public class Bush extends DivineTree {
	public static final MapCodec<Bush> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(TreeConfig.CODEC.fieldOf("config").forGetter(f -> f.config)).apply(instance, Bush::new));
	private final TreeConfig config;
	public Bush(TreeConfig config) {
		super(config);
		this.config = config;
	}

	@Override
	protected boolean defaultGrowOn(BlockState state) {
		return state.is(Blocks.SNOW_BLOCK) || state.is(Blocks.DIRT);
	}
	@Override
	public boolean place(TreeConfig config, WorldGenLevel level, ChunkGenerator chunkGen, RandomSource random, BlockPos pos) {
		if(canBeHere(level, random, pos, config)) {
			BlockState leaves = config.leaves;
			setBlock(level, pos, config.log, true);
			setBlock(level, pos.above(), leaves);
			grow(level, pos, leaves, 1, 0);
			grow(level, pos.below(), leaves, 1, 0);
			if(random.nextBoolean()) {
				grow(level, pos, leaves, 1, 1);
				grow(level, pos, leaves, 2, 0);
				grow(level, pos, leaves, 2, 1);
				grow(level, pos, leaves, 2, -1);
				grow(level, pos.above(), leaves, 1, 0);
			}
			return true;
		}
		return false;
	}
}