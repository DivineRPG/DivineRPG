/*
*** MADE BY MITHION'S .SCHEMATIC TO JAVA CONVERTING TOOL v1.6 ***
*/

package net.divinerpg.dimensions.vethea.all;
import java.util.Random;

import net.divinerpg.utils.blocks.VetheaBlocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class Lamp1 extends WorldGenerator
{
	protected int[] GetValidSpawnBlocks() {
		return new int[] {
		};
	}
	public Lamp1() { }

	public boolean generate(World world, Random rand, int i, int j, int k) {

		world.setBlock(i + 1, j + 0, k + 2, VetheaBlocks.darkEverstone);
		world.setBlock(i + 1, j + 0, k + 3, VetheaBlocks.darkEverstone);
		world.setBlock(i + 1, j + 2, k + 0, VetheaBlocks.dreamLamp);
		world.setBlock(i + 1, j + 2, k + 5, VetheaBlocks.dreamLamp);
		world.setBlock(i + 1, j + 3, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 1, j + 3, k + 5, VetheaBlocks.darkEverstone);
		world.setBlock(i + 1, j + 4, k + 1, VetheaBlocks.darkEverstone);
		world.setBlock(i + 1, j + 4, k + 4, VetheaBlocks.darkEverstone);
		world.setBlock(i + 2, j + 0, k + 2, VetheaBlocks.darkEverstone);
		world.setBlock(i + 2, j + 0, k + 3, VetheaBlocks.darkEverstone);
		world.setBlock(i + 2, j + 2, k + 1, VetheaBlocks.darkEverstone);
		world.setBlock(i + 2, j + 2, k + 2, VetheaBlocks.darkEverstone);
		world.setBlock(i + 2, j + 2, k + 3, VetheaBlocks.darkEverstone);
		world.setBlock(i + 2, j + 2, k + 4, VetheaBlocks.darkEverstone);
		world.setBlock(i + 2, j + 3, k + 1, VetheaBlocks.darkEverstone);
		world.setBlock(i + 2, j + 3, k + 2, VetheaBlocks.darkEverstone);
		world.setBlock(i + 2, j + 3, k + 3, VetheaBlocks.darkEverstone);
		world.setBlock(i + 2, j + 3, k + 4, VetheaBlocks.darkEverstone);
		world.setBlock(i + 2, j + 4, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 2, j + 4, k + 1, VetheaBlocks.darkEverstone);
		world.setBlock(i + 2, j + 4, k + 4, VetheaBlocks.darkEverstone);
		world.setBlock(i + 2, j + 4, k + 5, VetheaBlocks.darkEverstone);
		world.setBlock(i + 3, j + 0, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 3, j + 0, k + 1, VetheaBlocks.darkEverstone);
		world.setBlock(i + 3, j + 0, k + 2, VetheaBlocks.darkEverstone);
		world.setBlock(i + 3, j + 0, k + 3, VetheaBlocks.darkEverstone);
		world.setBlock(i + 3, j + 0, k + 4, VetheaBlocks.darkEverstone);
		world.setBlock(i + 3, j + 0, k + 5, VetheaBlocks.darkEverstone);
		world.setBlock(i + 3, j + 1, k + 2, VetheaBlocks.darkEverstone);
		world.setBlock(i + 3, j + 1, k + 3, VetheaBlocks.darkEverstone);
		world.setBlock(i + 3, j + 2, k + 1, VetheaBlocks.darkEverstone);
		world.setBlock(i + 3, j + 2, k + 4, VetheaBlocks.darkEverstone);
		world.setBlock(i + 3, j + 3, k + 1, VetheaBlocks.darkEverstone);
		world.setBlock(i + 3, j + 3, k + 4, VetheaBlocks.darkEverstone);
		world.setBlock(i + 3, j + 4, k + 2, VetheaBlocks.darkEverstone);
		world.setBlock(i + 3, j + 4, k + 3, VetheaBlocks.darkEverstone);
		world.setBlock(i + 3, j + 5, k + 2, VetheaBlocks.darkEverstone);
		world.setBlock(i + 3, j + 5, k + 3, VetheaBlocks.darkEverstone);
		world.setBlock(i + 4, j + 0, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 4, j + 0, k + 1, VetheaBlocks.darkEverstone);
		world.setBlock(i + 4, j + 0, k + 2, VetheaBlocks.darkEverstone);
		world.setBlock(i + 4, j + 0, k + 3, VetheaBlocks.darkEverstone);
		world.setBlock(i + 4, j + 0, k + 4, VetheaBlocks.darkEverstone);
		world.setBlock(i + 4, j + 0, k + 5, VetheaBlocks.darkEverstone);
		world.setBlock(i + 4, j + 1, k + 2, VetheaBlocks.darkEverstone);
		world.setBlock(i + 4, j + 1, k + 3, VetheaBlocks.darkEverstone);
		world.setBlock(i + 4, j + 2, k + 1, VetheaBlocks.darkEverstone);
		world.setBlock(i + 4, j + 2, k + 4, VetheaBlocks.darkEverstone);
		world.setBlock(i + 4, j + 3, k + 1, VetheaBlocks.darkEverstone);
		world.setBlock(i + 4, j + 3, k + 4, VetheaBlocks.darkEverstone);
		world.setBlock(i + 4, j + 4, k + 2, VetheaBlocks.darkEverstone);
		world.setBlock(i + 4, j + 4, k + 3, VetheaBlocks.darkEverstone);
		world.setBlock(i + 4, j + 5, k + 2, VetheaBlocks.darkEverstone);
		world.setBlock(i + 4, j + 5, k + 3, VetheaBlocks.darkEverstone);
		world.setBlock(i + 5, j + 0, k + 2, VetheaBlocks.darkEverstone);
		world.setBlock(i + 5, j + 0, k + 3, VetheaBlocks.darkEverstone);
		world.setBlock(i + 5, j + 2, k + 1, VetheaBlocks.darkEverstone);
		world.setBlock(i + 5, j + 2, k + 2, VetheaBlocks.darkEverstone);
		world.setBlock(i + 5, j + 2, k + 3, VetheaBlocks.darkEverstone);
		world.setBlock(i + 5, j + 2, k + 4, VetheaBlocks.darkEverstone);
		world.setBlock(i + 5, j + 3, k + 1, VetheaBlocks.darkEverstone);
		world.setBlock(i + 5, j + 3, k + 2, VetheaBlocks.darkEverstone);
		world.setBlock(i + 5, j + 3, k + 3, VetheaBlocks.darkEverstone);
		world.setBlock(i + 5, j + 3, k + 4, VetheaBlocks.darkEverstone);
		world.setBlock(i + 5, j + 4, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 5, j + 4, k + 1, VetheaBlocks.darkEverstone);
		world.setBlock(i + 5, j + 4, k + 4, VetheaBlocks.darkEverstone);
		world.setBlock(i + 5, j + 4, k + 5, VetheaBlocks.darkEverstone);
		world.setBlock(i + 6, j + 0, k + 2, VetheaBlocks.darkEverstone);
		world.setBlock(i + 6, j + 0, k + 3, VetheaBlocks.darkEverstone);
		world.setBlock(i + 6, j + 2, k + 0, VetheaBlocks.dreamLamp);
		world.setBlock(i + 6, j + 3, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 6, j + 3, k + 5, VetheaBlocks.darkEverstone);
		world.setBlock(i + 6, j + 4, k + 1, VetheaBlocks.darkEverstone);
		world.setBlock(i + 6, j + 4, k + 4, VetheaBlocks.darkEverstone);

		return true;
	}
}