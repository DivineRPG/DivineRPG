package net.divinerpg.dimensions.vethea;

import java.util.Random;

import net.divinerpg.dimensions.vethea.all.FloatingTree1;
import net.divinerpg.dimensions.vethea.all.FloatingTree2;
import net.divinerpg.dimensions.vethea.all.FloatingTree3;
import net.divinerpg.dimensions.vethea.all.FloatingTree4;
import net.divinerpg.dimensions.vethea.all.FloatingTree5;
import net.divinerpg.dimensions.vethea.all.FloatingTree6;
import net.divinerpg.dimensions.vethea.all.FloatingTree7;
import net.divinerpg.dimensions.vethea.all.InfusionOutpost;
import net.divinerpg.dimensions.vethea.all.Lamp1;
import net.divinerpg.dimensions.vethea.all.Lamp2;
import net.divinerpg.dimensions.vethea.all.WorldGenVetheanPillar;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class VetheanChunkBuilder {
	
	private static IVetheanStructure floatingTree1 = new FloatingTree1();
	private static IVetheanStructure floatingTree2 = new FloatingTree2();
	private static IVetheanStructure floatingTree3 = new FloatingTree3();
	private static IVetheanStructure floatingTree4 = new FloatingTree4();
	private static IVetheanStructure floatingTree5 = new FloatingTree5();
	private static IVetheanStructure floatingTree6 = new FloatingTree6();
	private static IVetheanStructure floatingTree7 = new FloatingTree7();
	
	private static IVetheanStructure infusion = new InfusionOutpost();
	private static IVetheanStructure[] lamps = {new Lamp1(), new Lamp2()};
	
	private static IVetheanStructure pillar = new WorldGenVetheanPillar();

	private static Random rand = new Random();
	private int tree1Countl1 = 0;
	private int tree2Countl1 = 0;
	private int tree3Countl1 = 0;
	private int tree4Countl1 = 0;
	private int tree5Countl1 = 0;
	private int tree6Countl1 = 0;
	private int tree7Countl1 = 0;
	private int tree1Countl2 = 0;
	private int tree2Countl2 = 0;
	private int tree3Countl2 = 0;
	private int tree4Countl2 = 0;
	private int tree5Countl2 = 0;
	private int tree6Countl2 = 0;
	private int tree7Countl2 = 0;
	private int tree1Countl3 = 0;
	private int tree2Countl3 = 0;
	private int tree3Countl3 = 0;
	private int tree4Countl3 = 0;
	private int tree5Countl3 = 0;
	private int tree6Countl3 = 0;
	private int tree7Countl3 = 0;
	private int tree1Countl4 = 0;
	private int tree2Countl4 = 0;
	private int tree3Countl4 = 0;
	private int tree4Countl4 = 0;
	private int tree5Countl4 = 0;
	private int tree6Countl4 = 0;
	private int tree7Countl4 = 0;
	private boolean shouldGenTree1 = rand.nextInt(2) == 0;
	private boolean shouldGenTree2 = rand.nextInt(2) == 0;
	private boolean shouldGenTree3 = rand.nextInt(2) == 0;
	private boolean shouldGenTree4 = rand.nextInt(2) == 0;
	private boolean shouldGenTree5 = rand.nextInt(2) == 0;
	private boolean shouldGenTree6 = rand.nextInt(2) == 0;
	private boolean shouldGenTree7 = rand.nextInt(2) == 0;
	private boolean containsInfusionTableL1 = false;
	private boolean containsInfusionTableL2 = false;
	private boolean containsInfusionTableL3 = false;
	private boolean containsInfusionTableL4 = false;
	private boolean containsLampL1 = false;
	private boolean containsLampL2 = false;
	private boolean containsLampL3 = false;
	private boolean containsLampL4 = false;
	private boolean containsPillarL1 = false;
	private boolean containsPillarL2 = false;
	private boolean containsPillarL3 = false;


	public Block[][][] buildChunk(){
		
		Block[][][] chunk = new Block[16][256][16];
		
		for(int x = 0; x < 16; x++){
			for(int y = 0; y < 256; y++){
				for(int z = 0; z < 16; z++){
					if((y>0 && y<=16) || (y>48 && y <= 64) || (y>96 && y <= 112) || (y>144 && y <= 160)) chunk[x][y][z] = VetheaBlocks.dreamStone;
					
					if(y==16 || y == 64 || y == 112 || y == 160) {
						chunk[x][y][z] = VetheaBlocks.dreamGrass;
						chunk[x][y-1][z] = VetheaBlocks.dreamDirt;
						if(this.rand.nextInt(2) == 0) chunk[x][y-2][z] = VetheaBlocks.dreamDirt;
					}
					
					
					if(tree1Countl1 <= 1 && y == 30+rand.nextInt(5) && rand.nextInt(155) == 0 && x+5<16 && z+7<16 && shouldGenTree1){
						tree1Countl1++;
						floatingTree1.generate(chunk, x, y, z);
					}
					
					if(tree2Countl1 <= 1 && y == 30+rand.nextInt(5) && rand.nextInt(155) == 0 && x+3<16 && z+8<16 && shouldGenTree2){
						tree2Countl1++;
						floatingTree2.generate(chunk, x, y, z);
					}
					
					if(tree3Countl1 <= 1 && y == 30+rand.nextInt(5) && rand.nextInt(155) == 0 && x+3<16 && z+3<16 && shouldGenTree3){
						tree3Countl1++;
						floatingTree3.generate(chunk, x, y, z);
					}
					
					if(tree4Countl1 <= 1 && y == 30+rand.nextInt(5) && rand.nextInt(155) == 0 && x+5<16 && z+2<16 && shouldGenTree4){
						tree4Countl1++;
						floatingTree4.generate(chunk, x, y, z);
					}
					
					if(tree5Countl1 <= 1 && y == 30+rand.nextInt(5) && rand.nextInt(155) == 0 && x+4<16 && z+9<16 && shouldGenTree5){
						tree5Countl1++;
						floatingTree5.generate(chunk, x, y, z);
					}
					
					if(tree6Countl1 <= 1 && y == 30+rand.nextInt(5) && rand.nextInt(155) == 0 && x+5<16 && z+2<16 && shouldGenTree6){
						tree6Countl1++;
						floatingTree6.generate(chunk, x, y, z);
					}
					
					if(tree7Countl1 <= 1 && y == 30+rand.nextInt(5) && rand.nextInt(155) == 0 && x+5<16 && z+2<16 && shouldGenTree7){
						tree7Countl1++;
						floatingTree7.generate(chunk, x, y, z);
					}
					
					if(tree1Countl2 <= 1 && y == 80+rand.nextInt(5) && rand.nextInt(155) == 0 && x+5<16 && z+7<16 && shouldGenTree1){
						tree1Countl2++;
						floatingTree1.generate(chunk, x, y, z);
					}
					
					if(tree2Countl2 <= 1 && y == 80+rand.nextInt(5) && rand.nextInt(155) == 0 && x+3<16 && z+8<16 && shouldGenTree2){
						tree2Countl2++;
						floatingTree2.generate(chunk, x, y, z);
					}
					
					if(tree3Countl2 <= 1 && y == 80+rand.nextInt(5) && rand.nextInt(155) == 0 && x+3<16 && z+3<16 && shouldGenTree3){
						tree3Countl2++;
						floatingTree3.generate(chunk, x, y, z);
					}
					
					if(tree4Countl2 <= 1 && y == 80+rand.nextInt(5) && rand.nextInt(155) == 0 && x+5<16 && z+2<16 && shouldGenTree4){
						tree4Countl2++;
						floatingTree4.generate(chunk, x, y, z);
					}
					
					if(tree5Countl2 <= 1 && y == 80+rand.nextInt(5) && rand.nextInt(155) == 0 && x+4<16 && z+9<16 && shouldGenTree5){
						tree5Countl2++;
						floatingTree5.generate(chunk, x, y, z);
					}
					
					if(tree6Countl2 <= 1 && y == 80+rand.nextInt(5) && rand.nextInt(155) == 0 && x+5<16 && z+2<16 && shouldGenTree6){
						tree6Countl2++;
						floatingTree6.generate(chunk, x, y, z);
					}
					
					if(tree7Countl2 <= 1 && y == 80+rand.nextInt(5) && rand.nextInt(155) == 0 && x+5<16 && z+2<16 && shouldGenTree7){
						tree7Countl2++;
						floatingTree7.generate(chunk, x, y, z);
					}
					
					if(tree1Countl3 <= 1 && y == 128+rand.nextInt(5) && rand.nextInt(155) == 0 && x+5<16 && z+7<16 && shouldGenTree1){
						tree1Countl3++;
						floatingTree1.generate(chunk, x, y, z);
					}
					
					if(tree2Countl3 <= 1 && y == 128+rand.nextInt(5) && rand.nextInt(155) == 0 && x+3<16 && z+8<16 && shouldGenTree2){
						tree2Countl3++;
						floatingTree2.generate(chunk, x, y, z);
					}
					
					if(tree3Countl3 <= 1 && y == 128+rand.nextInt(5) && rand.nextInt(155) == 0 && x+3<16 && z+3<16 && shouldGenTree3){
						tree3Countl3++;
						floatingTree3.generate(chunk, x, y, z);
					}
					
					if(tree4Countl3 <= 1 && y == 128+rand.nextInt(5) && rand.nextInt(155) == 0 && x+5<16 && z+2<16 && shouldGenTree4){
						tree4Countl3++;
						floatingTree4.generate(chunk, x, y, z);
					}
					
					if(tree5Countl3 <= 1 && y == 128+rand.nextInt(5) && rand.nextInt(155) == 0 && x+4<16 && z+9<16 && shouldGenTree5){
						tree5Countl3++;
						floatingTree5.generate(chunk, x, y, z);
					}
					
					if(tree6Countl3 <= 1 && y == 128+rand.nextInt(5) && rand.nextInt(155) == 0 && x+5<16 && z+2<16 && shouldGenTree6){
						tree6Countl3++;
						floatingTree6.generate(chunk, x, y, z);
					}
					
					if(tree7Countl3 <= 1 && y == 128+rand.nextInt(5) && rand.nextInt(155) == 0 && x+5<16 && z+2<16 && shouldGenTree7){
						tree7Countl3++;
						floatingTree7.generate(chunk, x, y, z);
					}
					
					if(tree1Countl4 <= 1 && y == 176+rand.nextInt(5) && rand.nextInt(155) == 0 && x+5<16 && z+7<16 && shouldGenTree1){
						tree1Countl4++;
						floatingTree1.generate(chunk, x, y, z);
					}
					
					if(tree2Countl4 <= 1 && y == 176+rand.nextInt(5) && rand.nextInt(155) == 0 && x+3<16 && z+8<16 && shouldGenTree2){
						tree2Countl4++;
						floatingTree2.generate(chunk, x, y, z);
					}
					
					if(tree3Countl4 <= 1 && y == 176+rand.nextInt(5) && rand.nextInt(155) == 0 && x+3<16 && z+3<16 && shouldGenTree3){
						tree3Countl4++;
						floatingTree3.generate(chunk, x, y, z);
					}
					
					if(tree4Countl4 <= 1 && y == 176+rand.nextInt(5) && rand.nextInt(155) == 0 && x+5<16 && z+2<16 && shouldGenTree4){
						tree4Countl4++;
						floatingTree4.generate(chunk, x, y, z);
					}
					
					if(tree5Countl4 <= 1 && y == 176+rand.nextInt(5) && rand.nextInt(155) == 0 && x+4<16 && z+9<16 && shouldGenTree5){
						tree5Countl4++;
						floatingTree5.generate(chunk, x, y, z);
					}
					
					if(tree6Countl4 <= 1 && y == 176+rand.nextInt(5) && rand.nextInt(155) == 0 && x+5<16 && z+2<16 && shouldGenTree6){
						tree6Countl4++;
						floatingTree6.generate(chunk, x, y, z);
					}
					
					if(tree7Countl4 <= 1 && y == 176+rand.nextInt(5) && rand.nextInt(155) == 0 && x+5<16 && z+2<16 && shouldGenTree7){
						tree7Countl4++;
						floatingTree7.generate(chunk, x, y, z);
					}
					
					if(!containsInfusionTableL1 && y == 17 && rand.nextInt(1550) == 0 && x+9<16 && z+9<16){
						containsInfusionTableL1 = true;
						infusion.generate(chunk, x, y, z);
					}
					
					if(!containsInfusionTableL2 && y == 65 && rand.nextInt(1550) == 0 && x+9<16 && z+9<16){
						containsInfusionTableL2 = true;
						infusion.generate(chunk, x, y, z);
					}
					
					if(!containsInfusionTableL3 && y == 113 && rand.nextInt(1550) == 0 && x+9<16 && z+9<16){
						containsInfusionTableL3 = true;
						infusion.generate(chunk, x, y, z);
					}
					
					if(!containsInfusionTableL4 && y == 161 && rand.nextInt(1550) == 0 && x+9<16 && z+9<16){
						containsInfusionTableL4 = true;
						infusion.generate(chunk, x, y, z);
					}
					
					if(!containsLampL1 && !containsInfusionTableL1 && y == 17 && rand.nextInt(1550) == 0 && x+6<16 && z+5<16){
						containsLampL1 = true;
						lamps[this.rand.nextInt(2)].generate(chunk, x, y, z);
					}
					
					if(!containsLampL2 && !containsInfusionTableL2 && y == 65 && rand.nextInt(1550) == 0 && x+6<16 && z+5<16){
						containsLampL2 = true;
						lamps[this.rand.nextInt(2)].generate(chunk, x, y, z);
					}
					
					if(!containsLampL3 && !containsInfusionTableL3 && y == 113 && rand.nextInt(1550) == 0 && x+6<16 && z+5<16){
						containsLampL3 = true;
						lamps[this.rand.nextInt(2)].generate(chunk, x, y, z);
					}
					
					if(!containsLampL4 && !containsInfusionTableL4 && y == 161 && rand.nextInt(1550) == 0 && x+6<16 && z+5<16){
						containsLampL4 = true;
						lamps[this.rand.nextInt(2)].generate(chunk, x, y, z);
					}
					
					if(!containsPillarL1 && !containsInfusionTableL1 && !containsLampL1 && y == 17 && rand.nextInt(16) == 0 && x == 8 && z == 8){
						containsPillarL1 = true;
						pillar.generate(chunk, x, y, z);
					}
					
					if(!containsPillarL2 && !containsInfusionTableL2 && !containsLampL2 && y == 65 && rand.nextInt(16) == 0 && x == 8 && z == 8){
						containsPillarL2 = true;
						pillar.generate(chunk, x, y, z);
					}
					
					if(!containsPillarL3 && !containsInfusionTableL3 && !containsLampL3 && y == 113 && rand.nextInt(16) == 0 && x == 8 && z == 8){
						containsPillarL3 = true;
						pillar.generate(chunk, x, y, z);
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