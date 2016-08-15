package net.divinerpg.dimensions.vethea;

import java.util.Random;

import net.divinerpg.dimensions.vethea.all.Bow;
import net.divinerpg.dimensions.vethea.all.FloatingTree1;
import net.divinerpg.dimensions.vethea.all.FloatingTree2;
import net.divinerpg.dimensions.vethea.all.FloatingTree3;
import net.divinerpg.dimensions.vethea.all.FloatingTree4;
import net.divinerpg.dimensions.vethea.all.FloatingTree5;
import net.divinerpg.dimensions.vethea.all.FloatingTree6;
import net.divinerpg.dimensions.vethea.all.FloatingTree7;
import net.divinerpg.dimensions.vethea.all.Hook;
import net.divinerpg.dimensions.vethea.all.InfusionOutpost;
import net.divinerpg.dimensions.vethea.all.Lamp1;
import net.divinerpg.dimensions.vethea.all.Lamp2;
import net.divinerpg.dimensions.vethea.all.Mushroom;
import net.divinerpg.dimensions.vethea.all.Pickaxe;
import net.divinerpg.dimensions.vethea.all.Pointedsquare;
import net.divinerpg.dimensions.vethea.all.Ring;
import net.divinerpg.dimensions.vethea.all.Sword;
import net.divinerpg.dimensions.vethea.all.Trident;
import net.divinerpg.dimensions.vethea.all.WorldGenVetheanPillar;
import net.divinerpg.dimensions.vethea.layer1.Tree4;
import net.divinerpg.dimensions.vethea.layer1.Tree5;
import net.divinerpg.dimensions.vethea.layer1.Tree6;
import net.divinerpg.dimensions.vethea.layer2.Tree3;
import net.divinerpg.utils.blocks.VetheaBlocks;

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
	private static IVetheanStructure[] items = {new Bow(), new Hook(), new Mushroom(), new Pickaxe(), new Pointedsquare(), new Ring(), new Sword(), new Trident()};
	private static IVetheanStructure[] l1Trees = {new Tree4(), new Tree5(), new Tree6()};
	private static IVetheanStructure[] l2Trees = {new Tree3(), new Tree6()};

	private static IVetheanStructure pillar = new WorldGenVetheanPillar();
	
	private static IVetheanStructure floorTexture = new FloorTexture();

	public static Random rand = new Random();
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
	private boolean containsItemL1 = false;
	private boolean containsItemL2 = false;
	private boolean containsItemL3 = false;
	private boolean containsItemL4 = false;
	
	private boolean containsl1Tree = false;
	private boolean containsl2Tree = false;

	public VetheaChunk buildChunk(int chunkX, int chunkZ){
		
		VetheaChunk chunk = new VetheaChunk();
		
		for(int x = 0; x < 16; x++){
			for(int y = 1; y < 17; y++){
				for(int z = 0; z < 16; z++){
					chunk.setBlock(x, y, z, VetheaBlocks.dreamStone);
					chunk.setBlock(x, y+48, z, VetheaBlocks.dreamStone);
					chunk.setBlock(x, y+96, z, VetheaBlocks.dreamStone);
					chunk.setBlock(x, y+144, z, VetheaBlocks.dreamStone);
					if(y == 16) {
						chunk.setBlock(x, y, z, VetheaBlocks.dreamGrass);
						chunk.setBlock(x, y-1, z, VetheaBlocks.dreamDirt);
						if(this.rand.nextInt(2) == 0) chunk.setBlock(x, y-2, z, VetheaBlocks.dreamDirt);
						chunk.setBlock(x, y+48, z, VetheaBlocks.dreamGrass);
						chunk.setBlock(x, y+47, z, VetheaBlocks.dreamDirt);
						if(this.rand.nextInt(2) == 0) chunk.setBlock(x, y+46, z, VetheaBlocks.dreamDirt);
						chunk.setBlock(x, y+96, z, VetheaBlocks.dreamGrass);
						chunk.setBlock(x, y+95, z, VetheaBlocks.dreamDirt);
						if(this.rand.nextInt(2) == 0) chunk.setBlock(x, y+94, z, VetheaBlocks.dreamDirt);
						chunk.setBlock(x, y+144, z, VetheaBlocks.dreamGrass);
						chunk.setBlock(x, y+143, z, VetheaBlocks.dreamDirt);
						if(this.rand.nextInt(2) == 0) chunk.setBlock(x, y+142, z, VetheaBlocks.dreamDirt);
					}
				}
			}
		}
					
					//Layer 1
					
					if(shouldGenTree1) floatingTree1.generate(chunk, rand.nextInt(11), 30+rand.nextInt(13)-rand.nextInt(13), rand.nextInt(9));
					
					if(shouldGenTree2) floatingTree2.generate(chunk, rand.nextInt(13), 30+rand.nextInt(13)-rand.nextInt(13), rand.nextInt(7));
					
					if(shouldGenTree3) floatingTree3.generate(chunk, rand.nextInt(11), 30+rand.nextInt(13)-rand.nextInt(13), rand.nextInt(13));
					
					if(shouldGenTree4) floatingTree4.generate(chunk, rand.nextInt(11), 30+rand.nextInt(13)-rand.nextInt(13), rand.nextInt(14));
					
					if(shouldGenTree5) floatingTree5.generate(chunk, rand.nextInt(12), 30+rand.nextInt(13)-rand.nextInt(13), rand.nextInt(7));
					
					if(shouldGenTree6) floatingTree6.generate(chunk, rand.nextInt(11), 30+rand.nextInt(13)-rand.nextInt(13), rand.nextInt(14));
					
					if(shouldGenTree7) floatingTree7.generate(chunk, rand.nextInt(11), 30+rand.nextInt(13)-rand.nextInt(13), rand.nextInt(14));
					
					//Layer 2
					
					if(shouldGenTree1) floatingTree1.generate(chunk, rand.nextInt(11), 80+rand.nextInt(13)-rand.nextInt(13), rand.nextInt(9));
					
					if(shouldGenTree2) floatingTree2.generate(chunk, rand.nextInt(13), 80+rand.nextInt(13)-rand.nextInt(13), rand.nextInt(7));
					
					if(shouldGenTree3) floatingTree3.generate(chunk, rand.nextInt(11), 80+rand.nextInt(13)-rand.nextInt(13), rand.nextInt(13));
					
					if(shouldGenTree4) floatingTree4.generate(chunk, rand.nextInt(11), 80+rand.nextInt(13)-rand.nextInt(13), rand.nextInt(14));
					
					if(shouldGenTree5) floatingTree5.generate(chunk, rand.nextInt(12), 80+rand.nextInt(13)-rand.nextInt(13), rand.nextInt(7));
					
					if(shouldGenTree6) floatingTree6.generate(chunk, rand.nextInt(11), 80+rand.nextInt(13)-rand.nextInt(13), rand.nextInt(14));
					
					if(shouldGenTree7) floatingTree7.generate(chunk, rand.nextInt(11), 80+rand.nextInt(13)-rand.nextInt(13), rand.nextInt(14));
					
					//Layer 3
					
					if(shouldGenTree1) floatingTree1.generate(chunk, rand.nextInt(11), 128+rand.nextInt(13)-rand.nextInt(13), rand.nextInt(9));
					
					if(shouldGenTree2) floatingTree2.generate(chunk, rand.nextInt(13), 128+rand.nextInt(13)-rand.nextInt(13), rand.nextInt(7));
					
					if(shouldGenTree3) floatingTree3.generate(chunk, rand.nextInt(11), 128+rand.nextInt(13)-rand.nextInt(13), rand.nextInt(13));
					
					if(shouldGenTree4) floatingTree4.generate(chunk, rand.nextInt(11), 128+rand.nextInt(13)-rand.nextInt(13), rand.nextInt(14));
					
					if(shouldGenTree5) floatingTree5.generate(chunk, rand.nextInt(12), 128+rand.nextInt(13)-rand.nextInt(13), rand.nextInt(7));
					
					if(shouldGenTree6) floatingTree6.generate(chunk, rand.nextInt(11), 128+rand.nextInt(13)-rand.nextInt(13), rand.nextInt(14));
					
					if(shouldGenTree7) floatingTree7.generate(chunk, rand.nextInt(11), 128+rand.nextInt(13)-rand.nextInt(13), rand.nextInt(14));
					
					//Layer 4
					
					if(shouldGenTree1) floatingTree1.generate(chunk, rand.nextInt(11), 176+rand.nextInt(13)-rand.nextInt(13), rand.nextInt(9));
					
					if(shouldGenTree2) floatingTree2.generate(chunk, rand.nextInt(13), 176+rand.nextInt(13)-rand.nextInt(13), rand.nextInt(7));
					
					if(shouldGenTree3) floatingTree3.generate(chunk, rand.nextInt(11), 176+rand.nextInt(13)-rand.nextInt(13), rand.nextInt(13));
					
					if(shouldGenTree4) floatingTree4.generate(chunk, rand.nextInt(11), 176+rand.nextInt(13)-rand.nextInt(13), rand.nextInt(14));
					
					if(shouldGenTree5) floatingTree5.generate(chunk, rand.nextInt(12), 176+rand.nextInt(13)-rand.nextInt(13), rand.nextInt(7));
					
					if(shouldGenTree6) floatingTree6.generate(chunk, rand.nextInt(11), 176+rand.nextInt(13)-rand.nextInt(13), rand.nextInt(14));
					
					if(shouldGenTree7) floatingTree7.generate(chunk, rand.nextInt(11), 176+rand.nextInt(13)-rand.nextInt(13), rand.nextInt(14));
					
					//L1
					if(rand.nextInt(43) == 0){
						containsInfusionTableL1 = true;
						infusion.generate(chunk, rand.nextInt(7), 17, rand.nextInt(7));
					}
					
					//L2
					if(rand.nextInt(43) == 0){
						containsInfusionTableL2 = true;
						infusion.generate(chunk, rand.nextInt(7), 65, rand.nextInt(7));
					}
					
					//L3
					if(rand.nextInt(43) == 0){
						containsInfusionTableL3 = true;
						infusion.generate(chunk, rand.nextInt(7), 113, rand.nextInt(7));
					}
					
					//L4
					if(rand.nextInt(43) == 0){
						containsInfusionTableL4 = true;
						infusion.generate(chunk, rand.nextInt(7), 161, rand.nextInt(7));
					}
					
					//L1
					if(rand.nextInt(30) == 0 && !containsInfusionTableL1){
						containsLampL1 = true;
						lamps[this.rand.nextInt(2)].generate(chunk, rand.nextInt(10), 17, rand.nextInt(11));
					}
					
					//L2
					if(rand.nextInt(30) == 0 && !containsInfusionTableL2){
						containsLampL2 = true;
						lamps[this.rand.nextInt(2)].generate(chunk, rand.nextInt(10), 65, rand.nextInt(11));
					}
					
					//L3
					if(rand.nextInt(30) == 0 && !containsInfusionTableL3){
						containsLampL3 = true;
						lamps[this.rand.nextInt(2)].generate(chunk, rand.nextInt(10), 113, rand.nextInt(11));
					}
					
					//L4
					if(rand.nextInt(30) == 0 && !containsInfusionTableL4){
						containsLampL4 = true;
						lamps[this.rand.nextInt(2)].generate(chunk, rand.nextInt(10), 161, rand.nextInt(11));
					}
					
					//L1
					if(!containsInfusionTableL1 && !containsLampL1 && rand.nextInt(16) == 0){
						containsPillarL1 = true;
						pillar.generate(chunk, 8, 17, 8);
					}
					
					//L2
					if(!containsInfusionTableL2 && !containsLampL2 && rand.nextInt(16) == 0){
						containsPillarL2 = true;
						pillar.generate(chunk, 8, 65, 8);
					}
					
					//L3
					if(!containsInfusionTableL3 && !containsLampL3 && rand.nextInt(16) == 0){
						containsPillarL3 = true;
						pillar.generate(chunk, 8, 113, 8);
					}
					
					//L1
					if(!containsPillarL1 && !containsInfusionTableL1 && !containsLampL1 && rand.nextInt(24) == 0){
						containsItemL1 = true;
						items[this.rand.nextInt(8)].generate(chunk, rand.nextInt(3), 17, rand.nextInt(16));
					}
					
					//L2
					if(!containsPillarL2 && !containsInfusionTableL2 && !containsLampL2 && rand.nextInt(24) == 0){
						containsItemL2 = true;
						items[this.rand.nextInt(8)].generate(chunk, rand.nextInt(3), 65, rand.nextInt(16));
					}
					
					//L3
					if(!containsPillarL3 && !containsInfusionTableL3 && !containsLampL3 && rand.nextInt(24) == 0){
						containsItemL3 = true;
						items[this.rand.nextInt(8)].generate(chunk, rand.nextInt(3), 113, rand.nextInt(16));
					}
					
					//L4
					if(!containsInfusionTableL4 && !containsLampL4 && rand.nextInt(24) == 0){
						containsItemL4 = true;
						items[this.rand.nextInt(8)].generate(chunk, rand.nextInt(3), 161, rand.nextInt(16));
					}
					
					if(!containsInfusionTableL1 && !containsLampL1 && !containsItemL1 && !containsPillarL1 && rand.nextInt(100) == 0){
						containsl1Tree = true;
						l1Trees[this.rand.nextInt(3)].generate(chunk, rand.nextInt(10), 17, rand.nextInt(11));
					}
					
					if(!containsInfusionTableL2 && !containsLampL2 && !containsItemL2 && !containsPillarL2 && rand.nextInt(100) == 0){
						containsl2Tree = true;
						l2Trees[this.rand.nextInt(2)].generate(chunk, 0, 65, 0);
					}
					
				if(rand.nextInt(5)==0) floorTexture.generate(chunk, 8, 16, 8);
				if(rand.nextInt(5)==0) floorTexture.generate(chunk, 8, 64, 8);
				if(rand.nextInt(5)==0) floorTexture.generate(chunk, 8, 112, 8);
				if(rand.nextInt(5)==0) floorTexture.generate(chunk, 8, 160, 8);
		
		return chunk;
		
	}
}