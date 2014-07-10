/*
*** MADE BY MITHION'S .SCHEMATIC TO JAVA CONVERTING TOOL v1.6 ***
*/

package net.divinerpg.dimensions.vethea.all;
import java.util.Random;

import net.divinerpg.utils.blocks.VetheaBlocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class FloatingTree4 extends WorldGenerator
{
	private WorldAddition world1;
	
	protected int[] GetValidSpawnBlocks() {
		return new int[] {
		};
	}

	public FloatingTree4() { }

	public boolean generate(World world, Random rand, int i, int j, int k) {

		world.setBlock(i + 0, j + 2, k + 1, VetheaBlocks.dreamStone);
		world.setBlock(i + 1, j + 2, k + 0, VetheaBlocks.dreamStone);
		world.setBlock(i + 1, j + 2, k + 1, VetheaBlocks.dreamStone);
		world.setBlock(i + 1, j + 2, k + 2, VetheaBlocks.dreamStone);
		world.setBlock(i + 1, j + 3, k + 1, VetheaBlocks.hyrewood);
		world1.setBlockWithMetadata(i + 1, j + 4, k + 1, VetheaBlocks.hyrewood, 4);
		world.setBlock(i + 2, j + 2, k + 1, VetheaBlocks.dreamStone);
		world1.setBlockWithMetadata(i + 2, j + 4, k + 1, VetheaBlocks.hyrewood, 4);
		world.setBlock(i + 3, j + 1, k + 1, VetheaBlocks.hyrewoodLeaves);
		world1.setBlockWithMetadata(i + 3, j + 4, k + 1, VetheaBlocks.hyrewood, 4);
		world.setBlock(i + 4, j + 0, k + 1, VetheaBlocks.hyrewoodLeaves);
		world.setBlock(i + 4, j + 1, k + 0, VetheaBlocks.hyrewoodLeaves);
		world.setBlock(i + 4, j + 1, k + 1, VetheaBlocks.hyrewood);
		world.setBlock(i + 4, j + 1, k + 2, VetheaBlocks.hyrewoodLeaves);
		world.setBlock(i + 4, j + 2, k + 1, VetheaBlocks.hyrewood);
		world.setBlock(i + 4, j + 3, k + 1, VetheaBlocks.hyrewood);
		world.setBlock(i + 4, j + 4, k + 1, VetheaBlocks.hyrewood);
		world.setBlock(i + 5, j + 1, k + 1, VetheaBlocks.hyrewoodLeaves);

		return true;
	}
}