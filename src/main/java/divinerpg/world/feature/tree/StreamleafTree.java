package divinerpg.world.feature.tree;

import divinerpg.world.feature.config.tree.TreeConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;

public class StreamleafTree extends AuroraoakTree {
	@Override
	public boolean canBeHere(WorldGenLevel level, RandomSource random, BlockPos pos, TreeConfig config) {
		return super.canBeHere(level, random, pos, config) && (level.getBlockState(pos.offset(-1, -1, 0)).is(Blocks.WATER) || level.getBlockState(pos.offset(1, -1, 0)).is(Blocks.WATER) || level.getBlockState(pos.offset(0, -1, -1)).is(Blocks.WATER) || level.getBlockState(pos.offset(0, -1, 1)).is(Blocks.WATER));
	}
	@Override
	public boolean place(TreeConfig config, WorldGenLevel level, ChunkGenerator chunkGen, RandomSource random, BlockPos pos) {
		if(canBeHere(level, random, pos, config)) {
			int treeHeight = 3 + random.nextInt(3), extraHeight = treeHeight + 1;
			if(heightCheck(level, pos, extraHeight, 1)) {
				grow(level, pos, config.log, 1, 0, true);
				grow(level, pos.below(), config.log, 1, 0, true);
				gradualGrowth(level, random, pos.mutable(), config.log, config.leaves, treeHeight, .35F, .18F, true);
				return true;
			}
		} return false;
	}
	@Override
	protected void growLeaves(WorldGenLevel level, RandomSource random, BlockPos pos, BlockState leaves) {
		setBlock(level, pos, leaves, false);
		grow(level, pos, leaves, 1, 0);
		pos = pos.below();
		grow(level, pos, leaves, 1, 1);
		grow(level, pos, leaves, 2, 1);
		grow(level, pos, leaves, 2, 0);
		grow(level, pos, leaves, 2, -1);
		pos = pos.below();
		growHangingLeaves(level, random, pos, leaves, 2, 1);
		growHangingLeaves(level, random, pos, leaves, 2, 0);
		growHangingLeaves(level, random, pos, leaves, 2, -1);
	}
	protected void hangingLeaves(WorldGenLevel level, RandomSource random, MutableBlockPos pos, BlockState leaves) {
		setBlock(level, pos, leaves, false);
		while(random.nextInt(4) == 0) {
			pos.move(0, -1, 0);
			if(hasSpace(level, pos)) setBlock(level, pos, leaves);
			else return;
		}
	}
	protected void growHangingLeaves(WorldGenLevel level, RandomSource random, BlockPos pos, BlockState leaves, int width, int offset) {
		hangingLeaves(level, random, pos.offset(width, 0, offset).mutable(), leaves);
		hangingLeaves(level, random, pos.offset(-width, 0, -offset).mutable(), leaves);
		hangingLeaves(level, random, pos.offset(offset, 0, -width).mutable(), leaves);
		hangingLeaves(level, random, pos.offset(-offset, 0, width).mutable(), leaves);
	}
}