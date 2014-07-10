/*
*** MADE BY MITHION'S .SCHEMATIC TO JAVA CONVERTING TOOL v1.6 ***
*/

package net.divinerpg.dimensions.vethea.all;
import java.util.Random;

import net.divinerpg.utils.blocks.VetheaBlocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TreeFloating1 extends WorldGenerator
{ 
	protected int[] GetValidSpawnBlocks() {
		return new int[] {
		};
	}
	
	private WorldAddition world1;

	public TreeFloating1() { }

	public boolean generate(World world, Random rand, int i, int j, int k) {

		world.setBlock(i + 0, j + 1, k + 1, VetheaBlocks.dreamStone);
		world.setBlock(i + 0, j + 1, k + 2, VetheaBlocks.dreamStone);
		world.setBlock(i + 0, j + 2, k + 1, VetheaBlocks.dreamStone);
		world.setBlock(i + 0, j + 2, k + 2, VetheaBlocks.dreamStone);
		world.setBlock(i + 1, j + 1, k + 1, VetheaBlocks.dreamStone);
		world.setBlock(i + 1, j + 1, k + 2, VetheaBlocks.dreamStone);
		world1.setBlockWithMetadata(i + 1, j + 1, k + 3, VetheaBlocks.firewood, 8);
		world1.setBlockWithMetadata(i + 1, j + 1, k + 4, VetheaBlocks.firewood, 8);
		world1.setBlockWithMetadata(i + 1, j + 1, k + 5, VetheaBlocks.firewood, 8);
		world1.setBlockWithMetadata(i + 1, j + 1, k + 6, VetheaBlocks.firewood, 8);
		world.setBlock(i + 1, j + 2, k + 1, VetheaBlocks.dreamStone);
		world.setBlock(i + 1, j + 2, k + 2, VetheaBlocks.dreamStone);
		world1.setBlockWithMetadata(i + 2, j + 1, k + 6, VetheaBlocks.firewood, 4);
		world1.setBlockWithMetadata(i + 2, j + 2, k + 1, VetheaBlocks.firewood, 4);
		world1.setBlockWithMetadata(i + 3, j + 1, k + 6, VetheaBlocks.firewood, 4);
		world1.setBlockWithMetadata(i + 3, j + 2, k + 1, VetheaBlocks.firewood, 4);
		world.setBlock(i + 4, j + 0, k + 6, VetheaBlocks.firewoodLeaves);
		world.setBlock(i + 4, j + 1, k + 1, VetheaBlocks.firewoodLeaves);
		world.setBlock(i + 4, j + 1, k + 5, VetheaBlocks.firewoodLeaves);
		world1.setBlockWithMetadata(i + 4, j + 1, k + 6, VetheaBlocks.firewood, 4);
		world.setBlock(i + 4, j + 1, k + 7, VetheaBlocks.firewoodLeaves);
		world.setBlock(i + 4, j + 2, k + 0, VetheaBlocks.firewoodLeaves);
		world1.setBlockWithMetadata(i + 4, j + 2, k + 1, VetheaBlocks.firewood, 4);
		world.setBlock(i + 4, j + 2, k + 2, VetheaBlocks.firewoodLeaves);
		world.setBlock(i + 4, j + 2, k + 6, VetheaBlocks.firewoodLeaves);
		world.setBlock(i + 5, j + 1, k + 6, VetheaBlocks.firewoodLeaves);
		world.setBlock(i + 5, j + 2, k + 1, VetheaBlocks.firewoodLeaves);

		return true;
	}
}