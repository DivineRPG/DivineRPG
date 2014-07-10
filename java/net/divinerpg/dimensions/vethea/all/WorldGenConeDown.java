package net.divinerpg.dimensions.vethea.all;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenConeDown extends WorldGenerator {
	
	@Override
	public boolean generate(World par1, Random par2, int par3, int par4, int par5) {
		int var2 = par2.nextInt(4) + 3;
		for (int i = 0; i < var2; i++)
		{
			this.placeBlockCircle(par1, par3, par4 - i, par5, var2 - i);
		}
		return true;
	}
	
	void placeBlockCircle (World par1World, int x, int y, int z, int radius) {
		for (int i = 0; i < radius; i++) {
			for (float j = 0; j < 2*Math.PI*i; j += 0.5)
			{
				par1World.setBlock((int)Math.floor(x + Math.sin(j) * i), y, (int)Math.floor(z + Math.cos(j) * i), Blocks.obsidian);
			}
		}
	}
}