package divinerpg.world.feature.tree;

import divinerpg.world.feature.config.tree.TreeConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;

public class DreamwoodTree extends FirewoodTree {
	@Override
	public boolean place(TreeConfig config, WorldGenLevel level, ChunkGenerator chunkGen, RandomSource random, BlockPos pos) {
		if(canBeHere(level, random, pos, config)) {
			if(direction == Direction.UP && random.nextInt(8) == 0) placeBigTree(config, level, random, pos);
			else {
				MutableBlockPos mutable = pos.mutable();
				for(int size = 0; size < 3 + random.nextInt(6); size++) {
					mutable.move(direction);
					setBlock(level, mutable, config.log, true);
				}
				pos = mutable;
				setBlock(level, pos.above(), config.leaves, false);
				setBlock(level, pos.north(), config.leaves, false);
				setBlock(level, pos.east(), config.leaves, false);
				setBlock(level, pos.south(), config.leaves, false);
				setBlock(level, pos.west(), config.leaves, false);
				setBlock(level, pos.below(), config.leaves, false);
			}
			return true;
		}
		return false;
	}
}
