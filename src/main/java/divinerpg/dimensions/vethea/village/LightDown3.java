/*
*** MADE BY MITHION'S .SCHEMATIC TO JAVA CONVERTING TOOL v1.6 ***
*/

package divinerpg.dimensions.vethea.village;
import java.util.Random;

import divinerpg.dimensions.vethea.VetheaWorldGenerator;
import divinerpg.registry.ModBlocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class LightDown3 extends VetheaWorldGenerator
{
	protected int[] GetValidSpawnBlocks() {
		return new int[] {
		};
	}

	public LightDown3() { }

	public boolean generate(World world, Random rand, int i, int j, int k) {

		setBlock(world, i + 0, j + 7, k + 0, ModBlocks.darkEverstone);
		setBlock(world, i + 0, j + 7, k + 1, ModBlocks.darkEverstone);
		setBlock(world, i + 0, j + 7, k + 2, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 0, k + 1, ModBlocks.firelight);
		setBlock(world, i + 1, j + 1, k + 1, ModBlocks.firelight);
		setBlock(world, i + 1, j + 2, k + 1, ModBlocks.firelight);
		setBlock(world, i + 1, j + 3, k + 1, ModBlocks.firelight);
		setBlock(world, i + 1, j + 4, k + 1, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 5, k + 1, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 7, k + 0, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 7, k + 1, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 7, k + 2, ModBlocks.darkEverstone);
		setBlock(world, i + 2, j + 5, k + 1, ModBlocks.darkEverstone);
		setBlock(world, i + 2, j + 6, k + 1, ModBlocks.darkEverstone);
		setBlock(world, i + 2, j + 7, k + 0, ModBlocks.darkEverstone);
		setBlock(world, i + 2, j + 7, k + 1, ModBlocks.darkEverstone);
		setBlock(world, i + 2, j + 7, k + 2, ModBlocks.darkEverstone);

		return true;
	}
}