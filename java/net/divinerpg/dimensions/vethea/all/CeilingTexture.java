package net.divinerpg.dimensions.vethea.all;

import java.util.Random;

import net.divinerpg.dimensions.vethea.IVetheanStructure;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class CeilingTexture implements IVetheanStructure
{
	private int height;
	private static Random rand = new Random();

	@Override
	public void generate(Block[][][] chunk, int par3, int par4, int par5) {
		int var2 = rand.nextInt(4) + height;
		height = rand.nextInt(3)+1;
		while(chunk[par3][par4][par5] == null){
			height--;
			for (int i = 0; i < var2; i++) {
				this.placeBlockCircle(chunk, par3, par4 + i, par5, var2 - i);
			}
		}
	}

	void placeBlockCircle (Block[][][] chunk, int x, int y, int z, int radius) {
		for (float i = 0; i < radius; i += 0.5) {
			for (float j = 0; j < 2 * Math.PI * i; j += 0.5) {
				chunk[(int)Math.floor(x + Math.sin(j) * i)][y][(int)Math.floor(z + Math.cos(j) * i)] = Blocks.air;
			}
		}
	}
}