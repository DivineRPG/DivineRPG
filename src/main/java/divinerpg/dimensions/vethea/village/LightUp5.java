/*
*** MADE BY MITHION'S .SCHEMATIC TO JAVA CONVERTING TOOL v1.6 ***
*/

package divinerpg.dimensions.vethea.village;
import java.util.Random;

import divinerpg.dimensions.vethea.VetheaWorldGenerator;
import divinerpg.registry.ModBlocks;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class LightUp5 extends VetheaWorldGenerator
{
	protected int[] GetValidSpawnBlocks() {
		return new int[] {
		};
	}

	public LightUp5() { }

	public boolean generate(World world, Random rand, int i, int j, int k) {

		/*EntityLiving entity = new EntityTheHunger(world);
		entity.setLocationAndAngles(i+ 0F, j +1.0F, k+0F, 0.0F, 0.0F);
		world.spawnEntityInWorld(entity);*/
		
		setBlock(world, i + 0, j + 0, k + 2, ModBlocks.darkEverstone);
		setBlock(world, i + 0, j + 0, k + 3, ModBlocks.darkEverstone);
		setBlock(world, i + 0, j + 1, k + 3, ModBlocks.darkEverstone);
		setBlock(world, i + 0, j + 1, k + 4, ModBlocks.darkEverstone);
		setBlock(world, i + 0, j + 2, k + 4, ModBlocks.darkEverstone);
		setBlock(world, i + 0, j + 2, k + 5, ModBlocks.darkEverstone);
		setBlock(world, i + 0, j + 3, k + 5, ModBlocks.darkEverstone);
		setBlock(world, i + 0, j + 4, k + 5, ModBlocks.darkEverstone);
		setBlock(world, i + 0, j + 5, k + 4, ModBlocks.darkEverstone);
		setBlock(world, i + 0, j + 5, k + 5, ModBlocks.darkEverstone);
		setBlock(world, i + 0, j + 6, k + 3, ModBlocks.darkEverstone);
		setBlock(world, i + 0, j + 6, k + 4, ModBlocks.darkEverstone);
		setBlock(world, i + 0, j + 7, k + 0, ModBlocks.firelight);
		setBlock(world, i + 0, j + 7, k + 1, ModBlocks.darkEverstone);
		setBlock(world, i + 0, j + 7, k + 2, ModBlocks.darkEverstone);
		setBlock(world, i + 0, j + 7, k + 3, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 0, k + 2, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 0, k + 3, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 1, k + 3, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 1, k + 4, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 2, k + 4, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 2, k + 5, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 3, k + 5, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 4, k + 5, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 5, k + 4, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 5, k + 5, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 6, k + 3, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 6, k + 4, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 7, k + 0, ModBlocks.firelight);
		setBlock(world, i + 1, j + 7, k + 1, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 7, k + 2, ModBlocks.darkEverstone);
		setBlock(world, i + 1, j + 7, k + 3, ModBlocks.darkEverstone);

		return true;
	}
}