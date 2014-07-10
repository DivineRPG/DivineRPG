/*
*** MADE BY MITHION'S .SCHEMATIC TO JAVA CONVERTING TOOL v1.6 ***
*/

package net.divinerpg.dimensions.vethea.village;
import java.util.Random;

import net.divinerpg.entities.vethea.EntityHungerHungry;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class LightUp4 extends WorldGenerator
{
	protected int[] GetValidSpawnBlocks() {
		return new int[] {
		};
	}

	public LightUp4() { }

	public boolean generate(World world, Random rand, int i, int j, int k) {

		EntityLiving entity = new EntityHungerHungry(world);
		entity.setLocationAndAngles(i-1.0F, j +1.0F, k-1.0F, 0.0F, 0.0F);
		world.spawnEntityInWorld(entity);
		
		world.setBlock(i + 0, j + 0, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 0, j + 0, k + 2, VetheaBlocks.darkEverstone);
		world.setBlock(i + 0, j + 1, k + 0, VetheaBlocks.firelight);
		world.setBlock(i + 0, j + 1, k + 2, VetheaBlocks.firelight);
		world.setBlock(i + 0, j + 2, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 0, j + 2, k + 1, VetheaBlocks.darkEverstone);
		world.setBlock(i + 0, j + 2, k + 2, VetheaBlocks.darkEverstone);
		world.setBlock(i + 0, j + 3, k + 0, VetheaBlocks.firelight);
		world.setBlock(i + 0, j + 3, k + 2, VetheaBlocks.firelight);
		world.setBlock(i + 0, j + 4, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 0, j + 4, k + 1, VetheaBlocks.darkEverstone);
		world.setBlock(i + 0, j + 4, k + 2, VetheaBlocks.darkEverstone);
		world.setBlock(i + 0, j + 5, k + 0, VetheaBlocks.firelight);
		world.setBlock(i + 0, j + 5, k + 2, VetheaBlocks.firelight);
		world.setBlock(i + 0, j + 6, k + 0, VetheaBlocks.firelight);
		world.setBlock(i + 0, j + 6, k + 2, VetheaBlocks.firelight);
		world.setBlock(i + 1, j + 2, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 1, j + 2, k + 2, VetheaBlocks.darkEverstone);
		world.setBlock(i + 1, j + 4, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 1, j + 4, k + 2, VetheaBlocks.darkEverstone);
		world.setBlock(i + 2, j + 0, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 2, j + 0, k + 2, VetheaBlocks.darkEverstone);
		world.setBlock(i + 2, j + 1, k + 0, VetheaBlocks.firelight);
		world.setBlock(i + 2, j + 1, k + 2, VetheaBlocks.firelight);
		world.setBlock(i + 2, j + 2, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 2, j + 2, k + 1, VetheaBlocks.darkEverstone);
		world.setBlock(i + 2, j + 2, k + 2, VetheaBlocks.darkEverstone);
		world.setBlock(i + 2, j + 3, k + 0, VetheaBlocks.firelight);
		world.setBlock(i + 2, j + 3, k + 2, VetheaBlocks.firelight);
		world.setBlock(i + 2, j + 4, k + 0, VetheaBlocks.darkEverstone);
		world.setBlock(i + 2, j + 4, k + 1, VetheaBlocks.darkEverstone);
		world.setBlock(i + 2, j + 4, k + 2, VetheaBlocks.darkEverstone);
		world.setBlock(i + 2, j + 5, k + 0, VetheaBlocks.firelight);
		world.setBlock(i + 2, j + 5, k + 2, VetheaBlocks.firelight);
		world.setBlock(i + 2, j + 6, k + 0, VetheaBlocks.firelight);
		world.setBlock(i + 2, j + 6, k + 2, VetheaBlocks.firelight);

		return true;
	}
}