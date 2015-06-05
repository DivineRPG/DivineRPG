package net.divinerpg.utils.blocks;

import net.divinerpg.blocks.base.BlockMod;
import net.divinerpg.blocks.base.BlockModLeaves;
import net.divinerpg.blocks.base.BlockModLog;
import net.divinerpg.blocks.base.BlockModTorch;
import net.divinerpg.blocks.base.BlockStatue;
import net.divinerpg.blocks.base.BlockStupidSpawner;
import net.divinerpg.blocks.vanilla.BlockAltarOfCorruption;
import net.divinerpg.blocks.vanilla.BlockAyeracoBeam;
import net.divinerpg.blocks.vanilla.BlockAyeracoSpawn;
import net.divinerpg.blocks.vanilla.BlockBloodgemOre;
import net.divinerpg.blocks.vanilla.BlockBoneChest;
import net.divinerpg.blocks.vanilla.BlockDarkBridge;
import net.divinerpg.blocks.vanilla.BlockDivineBricks;
import net.divinerpg.blocks.vanilla.BlockHotSpike;
import net.divinerpg.blocks.vanilla.BlockLamp1;
import net.divinerpg.blocks.vanilla.BlockLamp2;
import net.divinerpg.blocks.vanilla.BlockLightFence;
import net.divinerpg.blocks.vanilla.BlockMinibricks;
import net.divinerpg.blocks.vanilla.BlockMobPumpkin;
import net.divinerpg.blocks.vanilla.BlockMushroom;
import net.divinerpg.blocks.vanilla.BlockSlimeLight;
import net.divinerpg.blocks.vanilla.BlockSpike;
import net.divinerpg.blocks.vanilla.BlockSteel;
import net.divinerpg.blocks.vanilla.BlockTar;
import net.divinerpg.blocks.vanilla.BlockTomato;
import net.divinerpg.blocks.vanilla.VanillaBlock;
import net.divinerpg.client.render.block.model.ModelAncientStatue;
import net.divinerpg.client.render.block.model.ModelAyeracoStatue;
import net.divinerpg.client.render.block.model.ModelDensosStatue;
import net.divinerpg.client.render.block.model.ModelDramixStatue;
import net.divinerpg.client.render.block.model.ModelEternArcherStatue;
import net.divinerpg.client.render.block.model.ModelKarotStatue;
import net.divinerpg.client.render.block.model.ModelKingStatue;
import net.divinerpg.client.render.block.model.ModelReyvorStatue;
import net.divinerpg.client.render.block.model.ModelSoulStatue;
import net.divinerpg.client.render.block.model.ModelTwilightStatue;
import net.divinerpg.client.render.block.model.ModelVamacheronStatue;
import net.divinerpg.client.render.block.model.ModelWatcherStatue;
import net.divinerpg.utils.material.EnumBlockType;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;

public class VanillaBlocks {

	//Harvest Levels
	private static int WOOD_GOLD = 0, STONE = 1, IRON = 2, DIAMOND = 3;  
	
	public static Block rupeeOre;
	public static Block arlemiteOre;
	public static Block realmiteOre;
	public static Block bloodgemOre;
	public static Block netheriteOre;

	public static Block rupeeBlock;
	public static Block arlemiteBlock;
	public static Block realmiteBlock;
	public static Block bloodgemBlock;
	public static Block netheriteBlock;

	public static Block spiderPumpkin;
	public static Block enderPumpkin;
	public static Block creeperPumpkin;
	public static Block skeletonPumpkin;
	public static Block blazePumpkin;
	public static Block zombiePumpkin;
	public static Block frostPumpkin;
	public static Block cyclopsPumpkin;
	public static Block ghastPumpkin;
	public static Block glaconPumpkin;
	public static Block enderWatcherPumpkin;
	public static Block jungleSpiderPumpkin;
	public static Block hellspiderPumpkin;
	
	public static Block aquaTorch;
	public static Block skeletonTorch;

	public static Block checker;
	public static Block rainbowWool;
	public static Block crate;
	public static Block plankDesign;
	public static Block blueStone;

	public static Block blueVane;
	public static Block cyanVane;
	public static Block purpleVane;
	public static Block redVane;
	public static Block yellowVane;

	public static Block divineRock;
	public static Block tar;
	
	public static Block fancyWool;
	//public static Block dirtBlock;
	//public static Block soulSandBlock;
	//public static Block sandBlock;
	
	public static Block steel;
	public static Block divineBricks;
	public static Block minibricks;
	public static Block lamp1;
	public static Block lamp2;
	public static Block milkStone;
	public static Block darkStone;
	public static Block spikeBlock;
	public static Block hotSpikeBlock;
	public static Block slimeLight, slimeLightOn;
	public static Block darkBridge, darkBridgeOn;
	
	public static Block lightFenceBlue;
    public static Block lightFenceRed;
    public static Block lightFenceGreen;
    public static Block lightFenceBlueOn;
    public static Block lightFenceRedOn;
    public static Block lightFenceGreenOn;
    
    public static Block ayeracoBeamBlue;
    public static Block ayeracoBeamGreen; 
    public static Block ayeracoBeamRed;
    public static Block ayeracoBeamYellow; 
    public static Block ayeracoBeamPurple; 
    public static Block ayeracoSpawn;
    
	public static BlockStatue kosStatue;
	public static BlockStatue ancientEntityStatue;
	public static BlockStatue ayeracoStatue;
	public static BlockStatue twilightDemonStatue;
	public static BlockStatue vamacheronStatue;
	public static BlockStatue densosStatue;
	public static BlockStatue reyvorStatue;
	public static BlockStatue dramixStatue;
	//public static BlockStatue parasectaStatue;
	public static BlockStatue soulFiendStatue;
	public static BlockStatue watcherStatue;
	public static BlockStatue eternalArcherStatue;
	public static BlockStatue karotStatue;
	
	public static Block tomato;
	public static Block mushroom;
	
	public static Block divineWood;
	public static Block divinePlank;
	public static Block divineLeaves;
	public static Block divineMossystone;
	public static Block enthralledDramcryxSpawner;
	public static Block rotatickSpawner;
	
	public static Block altarOfCorruption;
	public static Block boneChest;
	
	
	public static void init() {
		rupeeOre            = new VanillaBlock(EnumBlockType.ROCK, "rupeeOre", 3.0F, DIAMOND).setResistance(2000.0F);
		arlemiteOre         = new VanillaBlock(EnumBlockType.ROCK, "arlemiteOre", 3.0F, DIAMOND).setResistance(2000.0F);
		realmiteOre         = new VanillaBlock(EnumBlockType.ROCK, "realmiteOre", 3.0F, IRON).setResistance(2000.0F);
		bloodgemOre         = new BlockBloodgemOre();
		netheriteOre        = new VanillaBlock(EnumBlockType.ROCK, "netheriteOre", 3.0F, DIAMOND).setResistance(2000.0F);

		rupeeBlock          = new VanillaBlock(EnumBlockType.ROCK, "rupeeBlock", 5.0F, DIAMOND).setResistance(10F);
		arlemiteBlock       = new VanillaBlock(EnumBlockType.ROCK, "arlemiteBlock", 5.0F, DIAMOND).setResistance(10F);
		realmiteBlock       = new VanillaBlock(EnumBlockType.ROCK, "realmiteBlock", 5.0F, IRON).setResistance(10F);
		bloodgemBlock       = new VanillaBlock(EnumBlockType.ROCK, "bloodgemBlock", 5.0F, DIAMOND).setResistance(10F);
		netheriteBlock      = new VanillaBlock(EnumBlockType.ROCK, "netheriteBlock", 5.0F, DIAMOND).setResistance(10F);

		spiderPumpkin       = new BlockMobPumpkin().setName("spiderPumpkin");
		enderPumpkin        = new BlockMobPumpkin().setName("enderPumpkin");
		creeperPumpkin      = new BlockMobPumpkin().setName("creeperPumpkin");
		skeletonPumpkin     = new BlockMobPumpkin().setName("skeletonPumpkin");
		blazePumpkin        = new BlockMobPumpkin().setName("blazePumpkin");
		zombiePumpkin       = new BlockMobPumpkin().setName("zombiePumpkin");
		frostPumpkin        = new BlockMobPumpkin().setName("frostPumpkin");
		cyclopsPumpkin      = new BlockMobPumpkin().setName("cyclopsPumpkin");
		ghastPumpkin        = new BlockMobPumpkin().setName("ghastPumpkin");
		glaconPumpkin       = new BlockMobPumpkin().setName("glaconPumpkin");
		enderWatcherPumpkin = new BlockMobPumpkin().setName("enderWatcherPumpkin");
		jungleSpiderPumpkin = new BlockMobPumpkin().setName("jungleSpiderPumpkin");
		hellspiderPumpkin   = new BlockMobPumpkin().setName("hellspiderPumpkin");
		
		aquaTorch			= new BlockModTorch("aquaTorch", "blueFlame");
		skeletonTorch		= new BlockModTorch("skeletonTorch", "blackFlame");

		checker             = new VanillaBlock(EnumBlockType.WOOL, "checker", 0.8F, WOOD_GOLD);
		rainbowWool         = new VanillaBlock(EnumBlockType.WOOL, "rainbowWool", 0.8F, WOOD_GOLD);
		crate               = new VanillaBlock(EnumBlockType.WOOD, "crate", 2.5F, WOOD_GOLD);
		plankDesign               = new VanillaBlock(EnumBlockType.WOOD, "plankDesign", 2.5F, WOOD_GOLD);
		blueStone           = new VanillaBlock(EnumBlockType.ROCK, "blueStone", 1.5F, WOOD_GOLD).setResistance(10F).setLightLevel(1);

		blueVane            = new VanillaBlock(EnumBlockType.ROCK, "blueVane", 2.0F, IRON).setResistance(10F);
		cyanVane            = new VanillaBlock(EnumBlockType.ROCK, "cyanVane", 2.0F, IRON).setResistance(10F);
		purpleVane          = new VanillaBlock(EnumBlockType.ROCK, "purpleVane", 2.0F, IRON).setResistance(10F);
		redVane             = new VanillaBlock(EnumBlockType.ROCK, "redVane", 2.0F, IRON).setResistance(10F);
		yellowVane          = new VanillaBlock(EnumBlockType.ROCK, "yellowVane", 2.0F, IRON).setResistance(10F);

		divineRock          = new VanillaBlock(EnumBlockType.ROCK, "divineRock", 1.5F, STONE).setResistance(10F);
		tar 				  = new BlockTar();
		
		fancyWool 		  = new VanillaBlock(EnumBlockType.WOOL, "fancyWool", 0.8F, WOOD_GOLD);
		//dirtBlock 		  = new VanillaBlock(EnumBlockType.DIRT, "dirtBlock", 1.5F, WOOD_GOLD);
		//soulSandBlock       = new VanillaBlock(EnumBlockType.DIRT, "soulSandBlock", 1.5F, WOOD_GOLD);
		//sandBlock 		  = new VanillaBlock(EnumBlockType.DIRT, "sandBlock", 1.5F, WOOD_GOLD);
		
		steel       		  = new BlockSteel();
		divineBricks          = new BlockDivineBricks();
		minibricks			  = new BlockMinibricks();
		lamp1				  = new BlockLamp1();
		lamp2				  = new BlockLamp2();
		milkStone			  = new VanillaBlock(EnumBlockType.ROCK, "milkStone", 1.5F, WOOD_GOLD).setResistance(10F);
		darkStone			  = new VanillaBlock(EnumBlockType.ROCK, "darkstone", 50f, DIAMOND).setResistance(2000.0F).setLightLevel(1);
		spikeBlock            = new BlockSpike();
		hotSpikeBlock         = new BlockHotSpike();
		slimeLight            = new BlockSlimeLight(false);
		slimeLightOn          = new BlockSlimeLight(true);
		darkBridge            = new BlockDarkBridge(false);
		darkBridgeOn          = new BlockDarkBridge(true);
		
		lightFenceBlue 	  = new BlockLightFence(false, "blueFence", 0.5F);
	    lightFenceRed 	  = new BlockLightFence(false, "redFence", 0.5F);
	    lightFenceGreen 	  = new BlockLightFence(false, "greenFence", 0.5F);
	    lightFenceBlueOn 	  = new BlockLightFence(true, "blueFenceOn", 0.5F);
	    lightFenceRedOn 	  = new BlockLightFence(true, "redFenceOn", 0.5F);
	    lightFenceGreenOn   = new BlockLightFence(true, "greenFenceOn", 0.5F);
	    
	    ayeracoBeamBlue 	  = new BlockAyeracoBeam("ayeracoBeamBlue", "Blue");
	    ayeracoBeamGreen 	  = new BlockAyeracoBeam("ayeracoBeamGreen", "Green"); 
	    ayeracoBeamRed 	  = new BlockAyeracoBeam("ayeracoBeamRed", "Red");
	    ayeracoBeamYellow   = new BlockAyeracoBeam("ayeracoBeamYellow", "Yellow"); 
	    ayeracoBeamPurple   = new BlockAyeracoBeam("ayeracoBeamPurple", "Purple");
	    ayeracoSpawn   = new BlockAyeracoSpawn();

		kosStatue 	  = new BlockStatue("kingOfScorchersStatue", new ModelKingStatue());
		ancientEntityStatue = new BlockStatue("ancientEntityStatue", new ModelAncientStatue());
		ayeracoStatue = new BlockStatue("ayeracoStatue", new ModelAyeracoStatue());
		twilightDemonStatue  = new BlockStatue("twilightDemonStatue", new ModelTwilightStatue());
		vamacheronStatue= new BlockStatue("vamacheronStatue", new ModelVamacheronStatue());
		densosStatue  = new BlockStatue("densosStatue", new ModelDensosStatue());
		reyvorStatue  = new BlockStatue("reyvorStatue", new ModelReyvorStatue());
		dramixStatue  = new BlockStatue("dramixStatue", new ModelDramixStatue());
		//parasectaStatue = new BlockStatue("parasectaStatue", new ModelParasectaStatue());
		soulFiendStatue = new BlockStatue("soulFiendStatue", new ModelSoulStatue());
		watcherStatue = new BlockStatue("watcherStatue", new ModelWatcherStatue());
		eternalArcherStatue = new BlockStatue("eternalArcherStatue", new ModelEternArcherStatue());
		karotStatue = new BlockStatue("karotStatue", new ModelKarotStatue());
		
		tomato			  = new BlockTomato("tomatoPlant");
		mushroom			  = new BlockMushroom("mushroomPlant");
		
		divineWood	  	  = new BlockModLog("divineLog");
		divinePlank	  	  = new BlockMod(EnumBlockType.WOOD, "divinePlanks", 2, DivineRPGTabs.blocks).setResistance(5);
		divineLeaves	  	  = new BlockModLeaves("divineLeaves", 0.3F);
		divineMossystone	  = new BlockMod("divineMossStone", 2.0F).setResistance(10);
		enthralledDramcryxSpawner      = new BlockStupidSpawner("enthralledDramcryxSpawner", "EnthralledDramcryx", "divineSpawner", true);
		rotatickSpawner   = new BlockStupidSpawner("rotatickSpawner", "Rotatick", "divineSpawner", true);
		
		altarOfCorruption	  = new BlockAltarOfCorruption("altarOfCorruption");
		boneChest			  = new BlockBoneChest("boneChest");
	}
}