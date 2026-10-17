package divinerpg.world.feature.tree;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import divinerpg.world.config.tree.TreeConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;

public class CozybarkBush extends CozybarkTree {
	public static final MapCodec<CozybarkBush> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(TreeConfig.CODEC.fieldOf("config").forGetter(f -> f.config)).apply(instance, CozybarkBush::new));
	private TreeConfig config;
	public CozybarkBush(TreeConfig config) {
		super(config);
		this.config = config;
	}

	@Override
	public MapCodec<? extends Feature> codec() {
		return CODEC;
	}

	@Override
	public boolean place(TreeConfig config, WorldGenLevel level, ChunkGenerator chunkGen, RandomSource random, BlockPos pos) {
		if(canBeHere(level, random, pos, config) && heightCheck(level, pos, 2, 1)) {
			BlockState log = config.log, leaves = config.leaves;
			setBlock(level, pos, log, true);
			setBlockSensitive(level, random, pos.above(), leaves, 1F);
			setBlockSensitive(level, random, pos.north(), leaves, 1F);
			setBlockSensitive(level, random, pos.east(), leaves, 1F);
			setBlockSensitive(level, random, pos.south(), leaves, 1F);
			setBlockSensitive(level, random, pos.west(), leaves, 1F);
			if(random.nextBoolean()) {
				setBlockSensitive(level, random, pos.offset(-2, 0, -1), leaves, 1F);
				setBlockSensitive(level, random, pos.offset(-2, 0, 0), leaves, 1F);
				setBlockSensitive(level, random, pos.offset(-2, 0, 1), leaves, 1F);
				setBlockSensitive(level, random, pos.offset(-1, 0, -2), leaves, 1F);
				setBlockSensitive(level, random, pos.offset(-1, 0, -1), leaves, 1F);
				setBlockSensitive(level, random, pos.offset(-1, 0, 1), leaves, 1F);
				setBlockSensitive(level, random, pos.offset(-1, 0, 2), leaves, 1F);
				setBlockSensitive(level, random, pos.offset(0, 0, -2), leaves, 1F);
				setBlockSensitive(level, random, pos.offset(0, 0, 2), leaves, 1F);
				setBlockSensitive(level, random, pos.offset(1, 0, -2), leaves, 1F);
				setBlockSensitive(level, random, pos.offset(1, 0, -1), leaves, 1F);
				setBlockSensitive(level, random, pos.offset(1, 0, 1), leaves, 1F);
				setBlockSensitive(level, random, pos.offset(1, 0, 2), leaves, 1F);
				setBlockSensitive(level, random, pos.offset(2, 0, -1), leaves, 1F);
				setBlockSensitive(level, random, pos.offset(2, 0, 0), leaves, 1F);
				setBlockSensitive(level, random, pos.offset(2, 0, 1), leaves, 1F);
				setBlockSensitive(level, random, pos.offset(0, 1, 1), leaves, 1F);
				setBlockSensitive(level, random, pos.offset(0, 1, -1), leaves, 1F);
				setBlockSensitive(level, random, pos.offset(1, 1, 0), leaves, 1F);
				setBlockSensitive(level, random, pos.offset(-1, 1, 0), leaves, 1F);
			} return true;
		} return false;
	}
}