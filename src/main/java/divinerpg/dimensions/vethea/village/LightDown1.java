/*
*** MADE BY MITHION'S .SCHEMATIC TO JAVA CONVERTING TOOL v1.6 ***
*/

package divinerpg.dimensions.vethea.village;
import java.util.Random;

import divinerpg.dimensions.vethea.VetheaWorldGenerator;
import divinerpg.registry.ModBlocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class LightDown1 extends VetheaWorldGenerator
{
	protected int[] GetValidSpawnBlocks() {
		return new int[] {
		};
	}

	public LightDown1() { }

	public boolean generate(World world, Random rand, int i, int j, int k) {

		setBlock(world, i + 0, j + 0, k + 1, ModBlocks.firelight);
		setBlock(world, i + 0, j + 1, k + 1, ModBlocks.darkEverstone);
		setBlock(world, i + 0, j + 2, k + 1, ModBlocks.darkEverstone);
		setBlock(world, i + 0, j + 6, k + 3, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 0, k + 5, ModBlocks.firelight);
		setBlock(world, i + 1, j + 1, k + 5, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 1, k + 6, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 2, k + 0, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 2, k + 1, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 2, k + 6, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 3, k + 0, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 3, k + 3, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 3, k + 4, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 3, k + 5, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 3, k + 6, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 4, k + 0, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 4, k + 1, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 4, k + 2, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 4, k + 3, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 5, k + 3, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 6, k + 2, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 6, k + 3, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 6, k + 4, ModBlocks.darkEverstone);
		setBlock(world, i + 2, j + 2, k + 3, ModBlocks.darkEverstone);
		setBlock(world, i + 2, j + 3, k + 3, ModBlocks.darkEverstone);
		setBlock(world, i + 2, j + 6, k + 3, ModBlocks.darkEverstone);
		setBlock(world, i + 3, j + 2, k + 3, ModBlocks.darkEverstone);
		setBlock(world, i + 4, j + 0, k + 4, ModBlocks.firelight);
		setBlock(world, i + 4, j + 1, k + 4, ModBlocks.darkEverstone);
		setBlock(world, i + 4, j + 2, k + 3, ModBlocks.darkEverstone);
		setBlock(world, i + 4, j + 2, k + 4, ModBlocks.darkEverstone);

		return true;
	}
}