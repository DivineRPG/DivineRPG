package net.divinerpg.dimensions.vethea;

import java.util.Random;

import net.divinerpg.utils.blocks.VetheaBlocks;
import net.minecraft.init.Blocks;

public class FloorTexture implements IVetheanStructure {
	private static Random rand = new Random();
	@Override
	public void generate(VetheaChunk chunk, int x, int y, int z) {
		for (double r = 0; r < 7; r+=0.5) {
			for(double theta = 0; theta < Math.PI*2; theta += 0.2) {
				chunk.setBlock((int) Math.round(x+Math.cos(theta)*r), y, (int) Math.round(z+Math.sin(theta)*r), Blocks.air);
				chunk.setBlock((int) Math.round(x+Math.cos(theta)*r), y-1, (int) Math.round(z+Math.sin(theta)*r), VetheaBlocks.dreamGrass);
			}
		}
	}

}
