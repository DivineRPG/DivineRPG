/*
*** MADE BY MITHION'S .SCHEMATIC TO JAVA CONVERTING TOOL v1.6 ***
*/

package net.divinerpg.dimensions.vethea.all;
import java.util.Random;

import net.divinerpg.utils.blocks.VetheaBlocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class Ring extends WorldGenerator
{
	protected int[] GetValidSpawnBlocks() {
		return new int[] {
		};
	}

	public Ring() { }

	public boolean generate(World world, Random rand, int i, int j, int k) {

		world.setBlock(i + 0, j + 3, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 0, j + 4, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 1, j + 2, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 1, j + 3, k + 0, VetheaBlocks.everstone);
		world.setBlock(i + 1, j + 4, k + 0, VetheaBlocks.everstone);
		world.setBlock(i + 1, j + 5, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 2, j + 1, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 2, j + 2, k + 0, VetheaBlocks.everstone);
		world.setBlock(i + 2, j + 3, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 2, j + 4, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 2, j + 5, k + 0, VetheaBlocks.everstone);
		world.setBlock(i + 2, j + 6, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 3, j + 0, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 3, j + 1, k + 0, VetheaBlocks.everstone);
		world.setBlock(i + 3, j + 2, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 3, j + 5, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 3, j + 6, k + 0, VetheaBlocks.everstone);
		world.setBlock(i + 3, j + 7, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 4, j + 0, k + 0, VetheaBlocks.everstone);
		world.setBlock(i + 4, j + 1, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 4, j + 6, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 4, j + 7, k + 0, VetheaBlocks.everstone);
		world.setBlock(i + 4, j + 8, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 5, j + 0, k + 0, VetheaBlocks.everstone);
		world.setBlock(i + 5, j + 1, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 5, j + 6, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 5, j + 7, k + 0, VetheaBlocks.everstone);
		world.setBlock(i + 5, j + 8, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 6, j + 0, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 6, j + 1, k + 0, VetheaBlocks.everstone);
		world.setBlock(i + 6, j + 2, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 6, j + 5, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 6, j + 6, k + 0, VetheaBlocks.everstone);
		world.setBlock(i + 6, j + 7, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 7, j + 1, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 7, j + 2, k + 0, VetheaBlocks.everstone);
		world.setBlock(i + 7, j + 3, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 7, j + 4, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 7, j + 5, k + 0, VetheaBlocks.everstone);
		world.setBlock(i + 7, j + 6, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 8, j + 2, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 8, j + 3, k + 0, VetheaBlocks.everstone);
		world.setBlock(i + 8, j + 4, k + 0, VetheaBlocks.everstone);
		world.setBlock(i + 8, j + 5, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 9, j + 3, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 9, j + 4, k + 0, VetheaBlocks.darkEverstone);

		return true;
	}
}