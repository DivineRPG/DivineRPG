package naturix.divinerpg.dimensions.eden;

import java.util.Random;

import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenEdenTree extends WorldGenerator {
	
	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		int i = pos.getX(), j = pos.getY(), k = pos.getZ();
		

			IBlockState log = ModBlocks.edenLog.getDefaultState();
			IBlockState leaves = ModBlocks.edenLeaves.getDefaultState();
			world.setBlockState(new BlockPos(i + 0, j + 7, k + 1), leaves);
			world.setBlockState(new BlockPos(i + 0, j + 7, k + 2), leaves);
			world.setBlockState(new BlockPos(i + 0, j + 7, k + 3), leaves);
			world.setBlockState(new BlockPos(i + 0, j + 8, k + 1), leaves);
			world.setBlockState(new BlockPos(i + 0, j + 8, k + 2), leaves);
			world.setBlockState(new BlockPos(i + 0, j + 8, k + 3), leaves);
			world.setBlockState(new BlockPos(i + 0, j + 9, k + 1), leaves);
			world.setBlockState(new BlockPos(i + 0, j + 9, k + 2), leaves);
			world.setBlockState(new BlockPos(i + 0, j + 9, k + 3), leaves);
			world.setBlockState(new BlockPos(i + 1, j + 6, k + 1), leaves);
			world.setBlockState(new BlockPos(i + 1, j + 6, k + 2), leaves);
			world.setBlockState(new BlockPos(i + 1, j + 6, k + 3), leaves);
			world.setBlockState(new BlockPos(i + 1, j + 7, k + 0), leaves);
			world.setBlockState(new BlockPos(i + 1, j + 7, k + 1), leaves);
			world.setBlockState(new BlockPos(i + 1, j + 7, k + 2), leaves);
			world.setBlockState(new BlockPos(i + 1, j + 7, k + 3), leaves);
			world.setBlockState(new BlockPos(i + 1, j + 7, k + 4), leaves);
			world.setBlockState(new BlockPos(i + 1, j + 8, k + 0), leaves);
			world.setBlockState(new BlockPos(i + 1, j + 8, k + 1), leaves);
			world.setBlockState(new BlockPos(i + 1, j + 8, k + 2), leaves);
			world.setBlockState(new BlockPos(i + 1, j + 8, k + 3), leaves);
			world.setBlockState(new BlockPos(i + 1, j + 8, k + 4), leaves);
			world.setBlockState(new BlockPos(i + 1, j + 9, k + 0), leaves);
			world.setBlockState(new BlockPos(i + 1, j + 9, k + 1), leaves);
			world.setBlockState(new BlockPos(i + 1, j + 9, k + 2), leaves);
			world.setBlockState(new BlockPos(i + 1, j + 9, k + 3), leaves);
			world.setBlockState(new BlockPos(i + 1, j + 9, k + 4), leaves);
			world.setBlockState(new BlockPos(i + 1, j + 10, k + 1), leaves);
			world.setBlockState(new BlockPos(i + 1, j + 10, k + 2), leaves);
			world.setBlockState(new BlockPos(i + 1, j + 10, k + 3), leaves);
			world.setBlockState(new BlockPos(i + 2, j + 6, k + 1), leaves);
			world.setBlockState(new BlockPos(i + 2, j + 6, k + 3), leaves);
			world.setBlockState(new BlockPos(i + 2, j + 7, k + 0), leaves);
			world.setBlockState(new BlockPos(i + 2, j + 7, k + 1), leaves);
			world.setBlockState(new BlockPos(i + 2, j + 7, k + 3), leaves);
			world.setBlockState(new BlockPos(i + 2, j + 7, k + 4), leaves);
			world.setBlockState(new BlockPos(i + 2, j + 8, k + 0), leaves);
			world.setBlockState(new BlockPos(i + 2, j + 8, k + 1), leaves);
			world.setBlockState(new BlockPos(i + 2, j + 8, k + 3), leaves);
			world.setBlockState(new BlockPos(i + 2, j + 8, k + 4), leaves);
			world.setBlockState(new BlockPos(i + 2, j + 9, k + 0), leaves);
			world.setBlockState(new BlockPos(i + 2, j + 9, k + 1), leaves);
			world.setBlockState(new BlockPos(i + 2, j + 9, k + 3), leaves);
			world.setBlockState(new BlockPos(i + 2, j + 9, k + 4), leaves);
			world.setBlockState(new BlockPos(i + 2, j + 10, k + 1), leaves);
			world.setBlockState(new BlockPos(i + 2, j + 10, k + 2), leaves);
			world.setBlockState(new BlockPos(i + 2, j + 10, k + 3), leaves);
			world.setBlockState(new BlockPos(i + 3, j + 6, k + 1), leaves);
			world.setBlockState(new BlockPos(i + 3, j + 6, k + 2), leaves);
			world.setBlockState(new BlockPos(i + 3, j + 6, k + 3), leaves);
			world.setBlockState(new BlockPos(i + 3, j + 7, k + 0), leaves);
			world.setBlockState(new BlockPos(i + 3, j + 7, k + 1), leaves);
			world.setBlockState(new BlockPos(i + 3, j + 7, k + 2), leaves);
			world.setBlockState(new BlockPos(i + 3, j + 7, k + 3), leaves);
			world.setBlockState(new BlockPos(i + 3, j + 7, k + 4), leaves);
			world.setBlockState(new BlockPos(i + 3, j + 8, k + 0), leaves);
			world.setBlockState(new BlockPos(i + 3, j + 8, k + 1), leaves);
			world.setBlockState(new BlockPos(i + 3, j + 8, k + 2), leaves);
			world.setBlockState(new BlockPos(i + 3, j + 8, k + 3), leaves);
			world.setBlockState(new BlockPos(i + 3, j + 8, k + 4), leaves);
			world.setBlockState(new BlockPos(i + 3, j + 9, k + 0), leaves);
			world.setBlockState(new BlockPos(i + 3, j + 9, k + 1), leaves);
			world.setBlockState(new BlockPos(i + 3, j + 9, k + 2), leaves);
			world.setBlockState(new BlockPos(i + 3, j + 9, k + 3), leaves);
			world.setBlockState(new BlockPos(i + 3, j + 9, k + 4), leaves);
			world.setBlockState(new BlockPos(i + 3, j + 10, k + 1), leaves);
			world.setBlockState(new BlockPos(i + 3, j + 10, k + 2), leaves);
			world.setBlockState(new BlockPos(i + 3, j + 10, k + 3), leaves);
			world.setBlockState(new BlockPos(i + 4, j + 7, k + 1), leaves);
			world.setBlockState(new BlockPos(i + 4, j + 7, k + 2), leaves);
			world.setBlockState(new BlockPos(i + 4, j + 7, k + 3), leaves);
			world.setBlockState(new BlockPos(i + 4, j + 8, k + 1), leaves);
			world.setBlockState(new BlockPos(i + 4, j + 8, k + 2), leaves);
			world.setBlockState(new BlockPos(i + 4, j + 8, k + 3), leaves);
			world.setBlockState(new BlockPos(i + 4, j + 9, k + 1), leaves);
			world.setBlockState(new BlockPos(i + 4, j + 9, k + 2), leaves);
			world.setBlockState(new BlockPos(i + 4, j + 9, k + 3), leaves);
			world.setBlockState(new BlockPos(i + 2, j + 4, k + 2), log);
			world.setBlockState(new BlockPos(i + 2, j + 5, k + 2), log);
			world.setBlockState(new BlockPos(i + 2, j + 7, k + 2), log);
			world.setBlockState(new BlockPos(i + 2, j + 6, k + 2), log);
			world.setBlockState(new BlockPos(i + 2, j + 8, k + 2), log);
			world.setBlockState(new BlockPos(i + 2, j + 9, k + 2), log);


		return true;
	}
}
