package divinerpg.world.feature.tree;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class Slowsprout extends Glowsprout {
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