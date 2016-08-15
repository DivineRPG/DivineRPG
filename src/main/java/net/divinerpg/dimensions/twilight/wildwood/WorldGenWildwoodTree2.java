package net.divinerpg.dimensions.twilight.wildwood;

import java.util.Random;

import net.divinerpg.dimensions.base.WorldGenAPI;
import net.divinerpg.utils.blocks.TwilightBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenWildwoodTree2 extends WorldGenerator {

	@Override
	public boolean generate(World w, Random rand, int x, int y, int z) {
		int height = rand.nextInt(7) + 16;
		if(w.getBlock(x, y, z) != Blocks.air || w.getBlock(x+3, y, z) != Blocks.air || w.getBlock(x-3, y, z) != Blocks.air || w.getBlock(x, y, z+3) != Blocks.air || w.getBlock(x, y, z-3) != Blocks.air || w.getBlock(x, y+height, z) != Blocks.air || w.getBlock(x, y-1, z) != TwilightBlocks.wildwoodGrass) return false;
		
		
		for(int j = 3; j < height; j+=4) {
			int radius = 4-(int)Math.round(j/4);
			WorldGenAPI.addCornerlessRectangle(radius*2+1, radius*2+1, 1, w, x-radius, y+j, z-radius, TwilightBlocks.wildwoodLeaves);
			
			WorldGenAPI.addCornerlessRectangle((radius-1)*2+1, (radius-1)*2+1, 1, w, x-(radius-1), y+j-1, z-(radius-1), TwilightBlocks.wildwoodLeaves);
			WorldGenAPI.addCornerlessRectangle((radius-1)*2+1, (radius-1)*2+1, 1, w, x-(radius-1), y+j+1, z-(radius-1), TwilightBlocks.wildwoodLeaves);
		}
		
		int bareCounter = 0;
		
		for(int c = 0; c<height; c++) {
			w.setBlock(x, y+c, z, TwilightBlocks.wildwoodLogs);
			if(w.getBlock(x+1, y+c, z) != TwilightBlocks.wildwoodLeaves) bareCounter++;
			else bareCounter = 0;
			if(bareCounter == 1 && c==height-1) w.setBlock(x, y+c, z, TwilightBlocks.wildwoodLeaves);
			if(bareCounter == 3 || (bareCounter == 2 && c == height-1)){
				w.setBlock(x, y+c, z, Blocks.air);
				w.setBlock(x, y+c-1, z, Blocks.air);
				w.setBlock(x, y+c-2, z, TwilightBlocks.wildwoodLeaves);
				break;
			}
		}
		
		for(int c = 0; c<height; c++) {
			if(w.getBlock(x, y+c, z) == TwilightBlocks.wildwoodLogs && w.getBlock(x+1, y+c, z) == Blocks.air) {
				if(rand.nextInt(3) == 0) w.setBlock(x+1, y+c, z, TwilightBlocks.wildwoodVine, 2, 2);
				if(rand.nextInt(3) == 0) w.setBlock(x-1, y+c, z, TwilightBlocks.wildwoodVine, 8, 2);
				if(rand.nextInt(3) == 0) w.setBlock(x, y+c, z-1, TwilightBlocks.wildwoodVine, 1, 2);
				if(rand.nextInt(3) == 0) w.setBlock(x, y+c, z+1, TwilightBlocks.wildwoodVine, 4, 2);
			}
		}
		
		
		return true;
	}

}
