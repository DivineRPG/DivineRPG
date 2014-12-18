package net.divinerpg.dimensions.vethea.all;

import java.util.Random;

import net.divinerpg.utils.blocks.VetheaBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenConeUp extends WorldGenerator
{
	private final Block block;
	private int height;

	public WorldGenConeUp(Block b) {
		block = b;
	}

	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		int var2 = rand.nextInt(4) + height;
		for (int i = 0; i < var2; i++) {
			this.placeBlockCircle(world, rand, x, y+i, z, var2-i);
		}
		return true;
	}

	public boolean generate(World world, Random rand, int x, int y, int z, int h) {
		height = h;
		return generate(world, rand, x, y, z);
	}

	void placeBlockCircle (World world, Random rand, int x, int y, int z, int radius) {
		for (float i = 0; i < radius; i += 0.5) {
			for (float j = 0; j < 2 * Math.PI * i; j += 0.5) {
				world.setBlock((int)Math.floor(x + Math.sin(j) * i), y, (int)Math.floor(z + Math.cos(j) * i), block);
				if(rand.nextInt(6)==0)world.setBlock((int)Math.floor(x + Math.sin(j) * i)+rand.nextInt(2)-rand.nextInt(2), y+1, (int)Math.floor(z + Math.cos(j) * i)+rand.nextInt(2)-rand.nextInt(2), block);
				if(rand.nextInt(6)==0)world.setBlock((int)Math.floor(x + Math.sin(j) * i)+rand.nextInt(2)-rand.nextInt(2), y-1, (int)Math.floor(z + Math.cos(j) * i)+rand.nextInt(2)-rand.nextInt(2), block);
			}
		}
	}
}