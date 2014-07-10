/*
*** MADE BY MITHION'S .SCHEMATIC TO JAVA CONVERTING TOOL v1.6 ***
*/

package net.divinerpg.dimensions.vethea.all;
import java.util.Random;

import net.divinerpg.utils.blocks.VetheaBlocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TreeFloating2 extends WorldGenerator
{
	protected int[] GetValidSpawnBlocks() {
		return new int[] {
		};
	}
	
	private WorldAddition world1;

	public TreeFloating2() { }

	public boolean generate(World world, Random rand, int i, int j, int k) {

		world.setBlock(i + 0, j + 1, k + 1, VetheaBlocks.mintwoodLeaves);
		world.setBlock(i + 0, j + 1, k + 2, VetheaBlocks.mintwoodLeaves);
		world.setBlock(i + 0, j + 1, k + 8, VetheaBlocks.dreamStone);
		world.setBlock(i + 0, j + 2, k + 2, VetheaBlocks.mintwoodLeaves);
		world.setBlock(i + 0, j + 2, k + 3, VetheaBlocks.mintwoodLeaves);
		world.setBlock(i + 0, j + 2, k + 8, VetheaBlocks.dreamStone);
		world.setBlock(i + 1, j + 0, k + 2, VetheaBlocks.mintwoodLeaves);
		world.setBlock(i + 1, j + 0, k + 8, VetheaBlocks.dreamStone);
		world.setBlock(i + 1, j + 1, k + 0, VetheaBlocks.mintwoodLeaves);
		world.setBlock(i + 1, j + 1, k + 1, VetheaBlocks.mintwoodLeaves);
		world1.setBlockWithMetadata(i + 1, j + 1, k + 2, VetheaBlocks.mintwood, 8);
		world1.setBlockWithMetadata(i + 1, j + 1, k + 3, VetheaBlocks.mintwood, 8);
		world1.setBlockWithMetadata(i + 1, j + 1, k + 4, VetheaBlocks.mintwood, 8);
		world1.setBlockWithMetadata(i + 1, j + 1, k + 5, VetheaBlocks.mintwood, 8);
		world1.setBlockWithMetadata(i + 1, j + 1, k + 6, VetheaBlocks.mintwood, 8);
		world.setBlock(i + 1, j + 1, k + 7, VetheaBlocks.dreamStone);
		world.setBlock(i + 1, j + 1, k + 8, VetheaBlocks.dreamStone);
		world.setBlock(i + 1, j + 2, k + 1, VetheaBlocks.mintwoodLeaves);
		world1.setBlockWithMetadata(i + 1, j + 2, k + 2, VetheaBlocks.mintwood, 8);
		world1.setBlockWithMetadata(i + 1, j + 2, k + 3, VetheaBlocks.mintwood, 8);
		world1.setBlockWithMetadata(i + 1, j + 2, k + 4, VetheaBlocks.mintwood, 8);
		world1.setBlockWithMetadata(i + 1, j + 2, k + 5, VetheaBlocks.mintwood, 8);
		world1.setBlockWithMetadata(i + 1, j + 2, k + 6, VetheaBlocks.mintwood, 8);
		world.setBlock(i + 1, j + 2, k + 7, VetheaBlocks.dreamStone);
		world.setBlock(i + 1, j + 2, k + 8, VetheaBlocks.dreamStone);
		world.setBlock(i + 1, j + 3, k + 2, VetheaBlocks.mintwoodLeaves);
		world.setBlock(i + 1, j + 3, k + 3, VetheaBlocks.mintwoodLeaves);
		world.setBlock(i + 1, j + 3, k + 8, VetheaBlocks.dreamStone);
		world.setBlock(i + 2, j + 0, k + 2, VetheaBlocks.mintwoodLeaves);
		world.setBlock(i + 2, j + 0, k + 8, VetheaBlocks.dreamStone);
		world.setBlock(i + 2, j + 1, k + 1, VetheaBlocks.mintwoodLeaves);
		world1.setBlockWithMetadata(i + 2, j + 1, k + 2, VetheaBlocks.mintwood, 8);
		world1.setBlockWithMetadata(i + 2, j + 1, k + 3, VetheaBlocks.mintwood, 8);
		world1.setBlockWithMetadata(i + 2, j + 1, k + 4, VetheaBlocks.mintwood, 8);
		world1.setBlockWithMetadata(i + 2, j + 1, k + 5, VetheaBlocks.mintwood, 8);
		world1.setBlockWithMetadata(i + 2, j + 1, k + 6, VetheaBlocks.mintwood, 8);
		world.setBlock(i + 2, j + 1, k + 7, VetheaBlocks.dreamStone);
		world.setBlock(i + 2, j + 1, k + 8, VetheaBlocks.dreamStone);
		world.setBlock(i + 2, j + 2, k + 1, VetheaBlocks.mintwoodLeaves);
		world1.setBlockWithMetadata(i + 2, j + 2, k + 2, VetheaBlocks.mintwood, 8);
		world1.setBlockWithMetadata(i + 2, j + 2, k + 3, VetheaBlocks.mintwood, 8);
		world1.setBlockWithMetadata(i + 2, j + 2, k + 4, VetheaBlocks.mintwood, 8);
		world1.setBlockWithMetadata(i + 2, j + 2, k + 5, VetheaBlocks.mintwood, 8);
		world1.setBlockWithMetadata(i + 2, j + 2, k + 6, VetheaBlocks.mintwood, 8);
		world.setBlock(i + 2, j + 2, k + 7, VetheaBlocks.dreamStone);
		world.setBlock(i + 2, j + 2, k + 8, VetheaBlocks.dreamStone);
		world.setBlock(i + 2, j + 3, k + 2, VetheaBlocks.mintwoodLeaves);
		world.setBlock(i + 2, j + 3, k + 8, VetheaBlocks.dreamStone);
		world.setBlock(i + 3, j + 0, k + 2, VetheaBlocks.mintwoodLeaves);
		world.setBlock(i + 3, j + 1, k + 2, VetheaBlocks.mintwoodLeaves);
		world.setBlock(i + 3, j + 1, k + 8, VetheaBlocks.dreamStone);
		world.setBlock(i + 3, j + 2, k + 2, VetheaBlocks.mintwoodLeaves);
		world.setBlock(i + 3, j + 2, k + 3, VetheaBlocks.mintwoodLeaves);
		world.setBlock(i + 3, j + 2, k + 8, VetheaBlocks.dreamStone);

		return true;
	}
}