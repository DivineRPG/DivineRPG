package net.divinerpg.dimensions.vethea.all;

import java.util.Random;

import net.divinerpg.dimensions.vethea.IVetheanStructure;
import net.divinerpg.dimensions.vethea.VetheaChunk;
import net.divinerpg.utils.blocks.VetheaBlocks;

public class WorldGenVetheanPillar implements IVetheanStructure {

	private static Random rand = new Random();
	
	@Override
	public void generate(VetheaChunk par1, int par3, int par4, int par5) {
		int var1 = 34;
		int var2 = rand.nextInt(4) + 3;
		for (int i = 0; i < var1; i++) {
			this.placeBlockCircle(par1, par3, i + par4, par5, Math.abs(((var1 / 2) - i)) / 5 + var2);
		}
	}
	
	private int getSize(VetheaChunk chunk, int par2, int par3, int par4) {
		if(par2 >= 16)par2 = 15;
		if(par3 >= 256)par2 = 255;
		if(par4 >= 16)par4 = 15;
		int i = par3;
		int var1 = 0;
		if (chunk.getBlock(par2, i, par4) != null) {
			while (chunk.getBlock(par2, i, par4) != null) {
				i++;
			}
		} else {

			while (chunk.getBlock(par2, i, par4) == null && i >= 0) {
				if (chunk.getBlock(par2, i-1, par4) == null) {
					i--;
				}
				else break;
			}
		}
		
		while(i <= 255 && chunk.getBlock(par2, i, par4) == null) {
			i++;
			var1++;
		}
		
		return var1;
	}
	
	private void placeBlockCircle(VetheaChunk chunk, int x, int y, int z, int radius) {
		if(radius >= 9) radius = 8;
		if(y >= 256) y = 255;
		for (float i = 0; i < radius; i += 0.5) {
			for (float j = 0; j < 2 * Math.PI * i; j += 0.5) {
				chunk.setBlock((int)Math.floor(x + Math.sin(j) * i), y, (int)Math.floor(z + Math.cos(j) * i), VetheaBlocks.dreamStone);
			}
		}
	}
}