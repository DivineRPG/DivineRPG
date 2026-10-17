package divinerpg.world.feature.tree;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import divinerpg.world.config.tree.TreeConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;

public class Stump extends CozybarkTree {
	public static final MapCodec<Stump> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(TreeConfig.CODEC.fieldOf("config").forGetter(f -> f.config)).apply(instance, Stump::new));
	private TreeConfig config;
	private BlockState decor = null;
	private RandomSource random = null;

	public Stump(TreeConfig config) {
		super(config);
		this.config = config;
	}

	@Override
	public MapCodec<? extends Feature> codec() {
		return CODEC;
	}

	@Override
	public boolean place(TreeConfig config, WorldGenLevel level, ChunkGenerator chunkGen, RandomSource random, BlockPos pos) {
		if(canBeHere(level, random, pos, config)) {
			BlockState log = config.log;
			decor = config.leaves;
			this.random = random;
			wideGrow(level, pos, log, 1, 0, 0, true);
			if(random.nextFloat() <= .2F)root(level, random, new MutableBlockPos(pos.getX() - 1, pos.getY(), pos.getZ()), log, 1, random.nextInt(2));
			if(random.nextFloat() <= .2F)root(level, random, new MutableBlockPos(pos.getX() - 1, pos.getY(), pos.getZ() + 1), log, 1, random.nextInt(2));
			if(random.nextFloat() <= .2F)root(level, random, new MutableBlockPos(pos.getX(), pos.getY(), pos.getZ() - 1), log, random.nextInt(2), 1);
			if(random.nextFloat() <= .2F)root(level, random, new MutableBlockPos(pos.getX() + 1, pos.getY(), pos.getZ() - 1), log, random.nextInt(2), 1);
			if(random.nextFloat() <= .2F)root(level, random, new MutableBlockPos(pos.getX(), pos.getY(), pos.getZ() + 2), log, random.nextInt(2), 0);
			if(random.nextFloat() <= .2F)root(level, random, new MutableBlockPos(pos.getX() + 1, pos.getY(), pos.getZ() + 2), log, random.nextInt(2), 0);
			if(random.nextFloat() <= .2F)root(level, random, new MutableBlockPos(pos.getX() + 2, pos.getY(), pos.getZ()), log, 0, random.nextInt(2));
			if(random.nextFloat() <= .2F)root(level, random, new MutableBlockPos(pos.getX() + 2, pos.getY(), pos.getZ() + 1), log, 0, random.nextInt(2));
			return true;
		} return false;
	}
	@Override
	protected void setBlock(WorldGenLevel level, BlockPos pos, BlockState state, boolean replace) {
		super.setBlock(level, pos, state, replace);
		if(random.nextBoolean() && level.getBlockState(pos.above()).isAir()) super.setBlock(level, pos, decor, false);
	}
}