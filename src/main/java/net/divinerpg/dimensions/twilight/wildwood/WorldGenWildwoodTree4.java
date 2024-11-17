package net.divinerpg.dimensions.twilight.wildwood;
import java.util.Random;

import net.divinerpg.utils.blocks.TwilightBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenWildwoodTree4 extends WorldGenerator {

	public boolean generate(World w, Random rand, int i, int j, int k) {
		
		i+=2;
		k+=2;
		int height = rand.nextInt(5) + 1;
		if(w.getBlock(i, j, k) != Blocks.air || w.getBlock(i+3, j, k) != Blocks.air || w.getBlock(i-3, j, k) != Blocks.air || w.getBlock(i, j, k+3) != Blocks.air || w.getBlock(i, j, k-3) != Blocks.air || w.getBlock(i, j+height, k) != Blocks.air || w.getBlock(i, j-1, k) != TwilightBlocks.wildwoodGrass) return false;
		
		for(int y = 0; y<height; y++) {
			w.setBlock(i, j+y, k, TwilightBlocks.wildwoodLogs);
			if(rand.nextInt(3) == 0) w.setBlock(i+1, j+y, k, TwilightBlocks.wildwoodVine, 2, 2);
			if(rand.nextInt(3) == 0) w.setBlock(i-1, j+y, k, TwilightBlocks.wildwoodVine, 8, 2);
			if(rand.nextInt(3) == 0) w.setBlock(i, j+y, k-1, TwilightBlocks.wildwoodVine, 1, 2);
			if(rand.nextInt(3) == 0) w.setBlock(i, j+y, k+1, TwilightBlocks.wildwoodVine, 4, 2);
		}
		
		i-=2;
		k-=2;
		j+=height;
		
		w.setBlock(i + 0, j + 1, k + 2, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 0, j + 5, k + 2, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 1, j + 1, k + 1, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 1, j + 1, k + 2, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 1, j + 1, k + 3, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 1, j + 2, k + 2, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 1, j + 5, k + 1, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 1, j + 5, k + 2, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 1, j + 5, k + 3, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 1, j + 6, k + 2, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 2, j + 0, k + 2, TwilightBlocks.wildwoodLogs);
		w.setBlock(i + 2, j + 1, k + 0, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 2, j + 1, k + 1, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 2, j + 1, k + 2, TwilightBlocks.wildwoodLogs);
		w.setBlock(i + 2, j + 1, k + 3, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 2, j + 1, k + 4, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 2, j + 2, k + 1, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 2, j + 2, k + 2, TwilightBlocks.wildwoodLogs);
		w.setBlock(i + 2, j + 2, k + 3, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 2, j + 3, k + 2, TwilightBlocks.wildwoodLogs);
		w.setBlock(i + 2, j + 4, k + 2, TwilightBlocks.wildwoodLogs);
		w.setBlock(i + 2, j + 5, k + 0, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 2, j + 5, k + 1, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 2, j + 5, k + 2, TwilightBlocks.wildwoodLogs);
		w.setBlock(i + 2, j + 5, k + 3, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 2, j + 5, k + 4, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 2, j + 6, k + 1, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 2, j + 6, k + 2, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 2, j + 6, k + 3, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 2, j + 7, k + 2, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 3, j + 1, k + 1, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 3, j + 1, k + 2, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 3, j + 1, k + 3, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 3, j + 2, k + 2, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 3, j + 5, k + 1, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 3, j + 5, k + 2, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 3, j + 5, k + 3, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 3, j + 6, k + 2, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 4, j + 1, k + 2, TwilightBlocks.wildwoodLeaves);
		w.setBlock(i + 4, j + 5, k + 2, TwilightBlocks.wildwoodLeaves);

		return true;
	}
}