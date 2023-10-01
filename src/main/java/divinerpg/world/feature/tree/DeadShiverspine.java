package divinerpg.world.feature.tree;

import divinerpg.world.feature.config.tree.TreeConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction.Axis;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.ChunkGenerator;

public class DeadShiverspine extends ShiverspineTree {
	@Override
	public boolean place(TreeConfig config, WorldGenLevel level, ChunkGenerator chunkGen, RandomSource random, BlockPos pos) {
		if(canBeHere(level, random, pos, config)) {
			int treeType = random.nextInt(8);
			boolean wide = treeType == 0;
			int treeHeight = wide ? 6 + random.nextInt(6) : 3 + random.nextInt(5);
			if(heightCheck(level, pos, treeHeight, wide ? 2 : 1)) {
				BlockState log = config.log, xlog = log.setValue(BlockStateProperties.AXIS, Axis.X), zlog = log.setValue(BlockStateProperties.AXIS, Axis.Z);
				MutableBlockPos p = pos.mutable().move(0, 1, 0);
				if(wide) wideGrow(level, pos, log, treeHeight, 0, 0, true);
				else grow(level, pos, log, treeHeight, true);
				int shift = random.nextBoolean() ? 2 : 0;
				for(int i = 0; i < treeHeight - 1; i++) {
					if((i + shift) % 4 == 0) {
						if(wide) angledWideGrow(level, p, xlog, zlog, 1, 0);
						else {
							setBlock(level, p.offset(1, 0, 0), xlog, true);
							setBlock(level, p.offset(-1, 0, 0), xlog, true);
						}
					} else if((i + shift) % 4 == 2) {
						if(wide) angledWideGrow(level, p, xlog, zlog, 1, 1);
						else {
							setBlock(level, p.offset(0, 0, 1), zlog, true);
							setBlock(level, p.offset(0, 0, -1), zlog, true);
						}
					}
					p.move(0, 1, 0);
				} return true;
			}
		} return false;
	}
	protected void angledWideGrow(WorldGenLevel world, BlockPos pos, BlockState xlog, BlockState zlog, int width, int offset) {
		setBlock(world, pos.offset(width + 1, 0, offset), xlog, true);
		setBlock(world, pos.offset(-width, 0, 1 - offset), xlog, true);
		setBlock(world, pos.offset(offset, 0, -width), zlog, true);
		setBlock(world, pos.offset(1 - offset, 0, width + 1), zlog, true);
    }
}