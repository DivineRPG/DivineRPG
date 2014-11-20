package net.divinerpg.dimensions.vethea;

import java.util.Random;

import net.divinerpg.dimensions.vethea.all.FloatingTree1;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.minecraft.block.Block;

public class VetheanChunkBuilder {
	
	private static IVetheanStructure floatingTree1 = new FloatingTree1();
	private static Random rand = new Random();
	private int tree1Count = 0;
	private boolean shouldGenTree1 = rand.nextInt(2) == 0;
	
	public Block[][][] buildChunk(){
		
		Block[][][] chunk = new Block[16][256][16];
		
		for(int x = 0; x < 16; x++){
			for(int y = 0; y < 256; y++){
				for(int z = 0; z < 16; z++){
					if((y>0 && y<=16) || (y>48 && y <= 64) || (y>96 && y <= 112) || (y>144 && y <= 160)) chunk[x][y][z] = VetheaBlocks.dreamStone;
					
					if(tree1Count <= 1 && y == 30+rand.nextInt(5) && rand.nextInt(55) == 0 && x+5<16 && z+7<16 && shouldGenTree1){
						tree1Count++;
						floatingTree1.generate(chunk, x, y, z);
					}

				}
			}
		}
		
		
		return chunk;
		
	}
	
	public static void toTerrainArray(Block[][][] chunk, Block[] output) {
		for(int x = 0; x<16; x++){
			for(int y = 0; y<256; y++){
				for(int z = 0; z<16; z++){
					output[(x*256)+(z*4096)+y] = chunk[x][y][z];
				}
			}
		}
	}

}