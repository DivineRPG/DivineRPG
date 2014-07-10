package net.divinerpg.dimensions.vethea.all;
import java.util.Random;

import net.divinerpg.utils.blocks.VetheaBlocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class FloatingTree5 extends WorldGenerator
{
	private WorldAddition world1;
	
	protected int[] GetValidSpawnBlocks() {
		return new int[] {
		};
	}

	public FloatingTree5() { }

	public boolean generate(World world, Random rand, int i, int j, int k) {

		world.setBlock(i + 0, j + 1, k + 8, VetheaBlocks.hyrewoodLeaves);
		world.setBlock(i + 1, j + 0, k + 8, VetheaBlocks.hyrewoodLeaves);
		world.setBlock(i + 1, j + 1, k + 5, VetheaBlocks.dreamStone);
		world1.setBlockWithMetadata(i + 1, j + 1, k + 6, VetheaBlocks.hyrewood, 8);
		world1.setBlockWithMetadata(i + 1, j + 1, k + 7, VetheaBlocks.hyrewood, 8);
		world1.setBlockWithMetadata(i + 1, j + 1, k + 8, VetheaBlocks.hyrewood, 8);
		world.setBlock(i + 1, j + 1, k + 9, VetheaBlocks.hyrewoodLeaves);
		world.setBlock(i + 1, j + 2, k + 1, VetheaBlocks.hyrewoodLeaves);
		world.setBlock(i + 1, j + 2, k + 5, VetheaBlocks.dreamStone);
		world.setBlock(i + 1, j + 2, k + 8, VetheaBlocks.hyrewoodLeaves);
		world.setBlock(i + 2, j + 0, k + 5, VetheaBlocks.dreamStone);
		world.setBlock(i + 2, j + 1, k + 1, VetheaBlocks.hyrewoodLeaves);
		world.setBlock(i + 2, j + 1, k + 4, VetheaBlocks.dreamStone);
		world.setBlock(i + 2, j + 1, k + 5, VetheaBlocks.dreamStone);
		world.setBlock(i + 2, j + 1, k + 6, VetheaBlocks.dreamStone);
		world.setBlock(i + 2, j + 1, k + 8, VetheaBlocks.hyrewoodLeaves);
		world.setBlock(i + 2, j + 2, k + 0, VetheaBlocks.hyrewoodLeaves);
		world.setBlock(i + 2, j + 2, k + 1, VetheaBlocks.hyrewoodLeaves);
		world1.setBlockWithMetadata(i + 2, j + 2, k + 2, VetheaBlocks.hyrewood, 8);
		world1.setBlockWithMetadata(i + 2, j + 2, k + 3, VetheaBlocks.hyrewood, 8);
		world.setBlock(i + 2, j + 2, k + 4, VetheaBlocks.dreamStone);
		world.setBlock(i + 2, j + 2, k + 5, VetheaBlocks.dreamStone);
		world.setBlock(i + 2, j + 2, k + 6, VetheaBlocks.dreamStone);
		world.setBlock(i + 2, j + 3, k + 1, VetheaBlocks.hyrewoodLeaves);
		world.setBlock(i + 2, j + 3, k + 5, VetheaBlocks.dreamStone);
		world.setBlock(i + 2, j + 5, k + 6, VetheaBlocks.hyrewoodLeaves);
		world.setBlock(i + 3, j + 0, k + 5, VetheaBlocks.dreamStone);
		world.setBlock(i + 3, j + 1, k + 4, VetheaBlocks.dreamStone);
		world.setBlock(i + 3, j + 1, k + 5, VetheaBlocks.dreamStone);
		world.setBlock(i + 3, j + 1, k + 6, VetheaBlocks.dreamStone);
		world.setBlock(i + 3, j + 2, k + 1, VetheaBlocks.hyrewoodLeaves);
		world.setBlock(i + 3, j + 2, k + 4, VetheaBlocks.dreamStone);
		world.setBlock(i + 3, j + 2, k + 5, VetheaBlocks.dreamStone);
		world.setBlock(i + 3, j + 2, k + 6, VetheaBlocks.dreamStone);
		world.setBlock(i + 3, j + 3, k + 5, VetheaBlocks.dreamStone);
		world.setBlock(i + 3, j + 3, k + 6, VetheaBlocks.hyrewood);
		world.setBlock(i + 3, j + 4, k + 6, VetheaBlocks.hyrewood);
		world.setBlock(i + 3, j + 5, k + 5, VetheaBlocks.hyrewoodLeaves);
		world.setBlock(i + 3, j + 5, k + 6, VetheaBlocks.dreamDirt);
		world.setBlock(i + 3, j + 5, k + 7, VetheaBlocks.hyrewoodLeaves);
		world.setBlock(i + 3, j + 6, k + 6, VetheaBlocks.hyrewoodLeaves);
		world.setBlock(i + 4, j + 1, k + 5, VetheaBlocks.dreamStone);
		world.setBlock(i + 4, j + 2, k + 5, VetheaBlocks.dreamStone);
		world.setBlock(i + 4, j + 5, k + 6, VetheaBlocks.hyrewoodLeaves);

		return true;
	}
}