package net.divinerpg.utils.blocks;

import net.divinerpg.api.blocks.BlockMod;
import net.divinerpg.api.blocks.BlockModLeaves;
import net.divinerpg.api.blocks.BlockModLog;
import net.divinerpg.api.blocks.BlockModSpawner;
import net.divinerpg.api.blocks.BlockStatue;
import net.divinerpg.blocks.vanilla.*;
import net.divinerpg.client.render.block.model.*;
import net.divinerpg.utils.material.EnumBlockType;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;

public class VanillaBlocks {

	//Harvest Levels
	private static int WOOD_GOLD = 0, STONE = 1, IRON = 2, DIAMOND = 3;  
	
	public static final Block rupeeOre            = new VanillaBlock(EnumBlockType.ROCK, "rupeeOre", 3.0F, DIAMOND);
	public static final Block arlemiteOre         = new VanillaBlock(EnumBlockType.ROCK, "arlemiteOre", 3.0F, DIAMOND);
	public static final Block realmiteOre         = new VanillaBlock(EnumBlockType.ROCK, "realmiteOre", 3.0F, IRON);
	public static final Block bloodgemOre         = new VanillaBlock(EnumBlockType.ROCK, "bloodgemOre", 3.0F, DIAMOND);
	public static final Block netheriteOre        = new VanillaBlock(EnumBlockType.ROCK, "netheriteOre", 3.0F, DIAMOND);

	public static final Block rupeeBlock          = new VanillaBlock(EnumBlockType.ROCK, "rupeeBlock", 3.0F, DIAMOND);
	public static final Block arlemiteBlock       = new VanillaBlock(EnumBlockType.ROCK, "arlemiteBlock", 3.0F, DIAMOND);
	public static final Block realmiteBlock       = new VanillaBlock(EnumBlockType.ROCK, "realmiteBlock", 3.0F, IRON);
	public static final Block bloodgemBlock       = new VanillaBlock(EnumBlockType.ROCK, "bloodgemBlock", 3.0F, DIAMOND);
	public static final Block netheriteBlock      = new VanillaBlock(EnumBlockType.ROCK, "netheriteBlock", 3.0F, DIAMOND);

	public static final Block spiderPumpkin       = new MobPumpkin().setName("spiderPumpkin");
	public static final Block enderPumpkin        = new MobPumpkin().setName("enderPumpkin");
	public static final Block creeperPumpkin      = new MobPumpkin().setName("creeperPumpkin");
	public static final Block skeletonPumpkin     = new MobPumpkin().setName("skeletonPumpkin");
	public static final Block blazePumpkin        = new MobPumpkin().setName("blazePumpkin");
	public static final Block zombiePumpkin       = new MobPumpkin().setName("zombiePumpkin");
	public static final Block frostPumpkin        = new MobPumpkin().setName("frostPumpkin");
	public static final Block cyclopsPumpkin      = new MobPumpkin().setName("cyclopsPumpkin");
	public static final Block ghastPumpkin        = new MobPumpkin().setName("ghastPumpkin");
	public static final Block glaconPumpkin       = new MobPumpkin().setName("glaconPumpkin");
	public static final Block enderWatcherPumpkin = new MobPumpkin().setName("enderWatcherPumpkin");
	public static final Block jungleSpiderPumpkin = new MobPumpkin().setName("jungleSpiderPumpkin");
	public static final Block hellSpiderPumpkin   = new MobPumpkin().setName("hellSpiderPumpkin");

	public static final Block checker             = new VanillaBlock(EnumBlockType.WOOL, "checker", 0.5F, WOOD_GOLD);
	public static final Block rainbowWool         = new VanillaBlock(EnumBlockType.WOOL, "rainbowWool", 0.5F, WOOD_GOLD);
	public static final Block crate               = new VanillaBlock(EnumBlockType.WOOD, "crate", 1.0F, WOOD_GOLD);
	public static final Block blueStone           = new VanillaBlock(EnumBlockType.ROCK, "blueStone", 1.0F, WOOD_GOLD);
	public static final Block purpleStone         = new VanillaBlock(EnumBlockType.ROCK, "purpleStone", 1.0F, WOOD_GOLD);

	public static final Block blueVane            = new VanillaBlock(EnumBlockType.ROCK, "blueVane", 2.0F, STONE);
	public static final Block cyanVane            = new VanillaBlock(EnumBlockType.ROCK, "cyanVane", 2.0F, STONE);
	public static final Block purpleVane          = new VanillaBlock(EnumBlockType.ROCK, "purpleVane", 2.0F, STONE);
	public static final Block redVane             = new VanillaBlock(EnumBlockType.ROCK, "redVane", 2.0F, STONE);
	public static final Block yellowVane          = new VanillaBlock(EnumBlockType.ROCK, "yellowVane", 2.0F, STONE);

	public static final Block divineRock          = new VanillaBlock(EnumBlockType.ROCK, "divineRock", 1.5F, STONE);
	public static final Block divineCraftingTable = new BlockDivineTable();
	public static final Block acceleron		  	  = new BlockAcceleron();
	public static final Block tar 				  = new BlockTar();

	public static final Block dyeBlockWhite 	  = new VanillaBlock(EnumBlockType.ROCK, "dyeBlock", 1.5F, WOOD_GOLD);
	public static final Block dyeBlockBlack 	  = new VanillaBlock(EnumBlockType.ROCK, "blackDyeBlock", 1.5F, WOOD_GOLD);
	public static final Block dyeBlockBrown 	  = new VanillaBlock(EnumBlockType.ROCK, "brownDyeBlock", 1.5F, WOOD_GOLD);
	public static final Block dyeBlockRed   	  = new VanillaBlock(EnumBlockType.ROCK, "redDyeBlock", 1.5F, WOOD_GOLD);
	public static final Block dyeBlockGreen 	  = new VanillaBlock(EnumBlockType.ROCK, "greenDyeBlock", 1.5F, WOOD_GOLD);
	public static final Block dyeBlockBlue  	  = new VanillaBlock(EnumBlockType.ROCK, "blueDyeBlock", 1.5F, WOOD_GOLD);
	public static final Block dyeBlockYellow	  = new VanillaBlock(EnumBlockType.ROCK, "yellowDyeBlock", 1.5F, WOOD_GOLD);
	public static final Block dyeBlockGray  	  = new VanillaBlock(EnumBlockType.ROCK, "grayDyeBlock", 1.5F, WOOD_GOLD);
	public static final Block dyeBlockLightGray   = new VanillaBlock(EnumBlockType.ROCK, "lightGrayDyeBlock", 1.5F, WOOD_GOLD);
	public static final Block dyeBlockOrange   	  = new VanillaBlock(EnumBlockType.ROCK, "orangeDyeBlock", 1.5F, WOOD_GOLD);
	public static final Block dyeBlockLightGreen  = new VanillaBlock(EnumBlockType.ROCK, "lightGreenDyeBlock", 1.5F, WOOD_GOLD);
	public static final Block dyeBlockLightBlue   = new VanillaBlock(EnumBlockType.ROCK, "lightBlueDyeBlock", 1.5F, WOOD_GOLD);
	public static final Block dyeBlockCyan   	  = new VanillaBlock(EnumBlockType.ROCK, "cyanDyeBlock", 1.5F, WOOD_GOLD);
	public static final Block dyeBlockPink        = new VanillaBlock(EnumBlockType.ROCK, "pinkDyeBlock", 1.5F, WOOD_GOLD);
	public static final Block dyeBlockPurple   	  = new VanillaBlock(EnumBlockType.ROCK, "purpleDyeBlock", 1.5F, WOOD_GOLD);
	public static final Block dyeBlockMagenta     = new VanillaBlock(EnumBlockType.ROCK, "magentaDyeBlock", 1.5F, WOOD_GOLD);
	
	public static final Block fancyWool 		  = new VanillaBlock(EnumBlockType.WOOL, "fancyWool", 0.5F, WOOD_GOLD);
	public static final Block dirtBlock 		  = new VanillaBlock(EnumBlockType.DIRT, "dirtBlock", 1.5F, WOOD_GOLD);
	public static final Block soulSandBlock       = new VanillaBlock(EnumBlockType.DIRT, "soulSandBlock", 1.5F, WOOD_GOLD);
	public static final Block sandBlock 		  = new VanillaBlock(EnumBlockType.DIRT, "sandBlock", 1.5F, WOOD_GOLD);
	
	public static final Block lightFenceBlue 	  = new BlockLightFence(false, "blueFence", 0.5F);
    public static final Block lightFenceRed 	  = new BlockLightFence(false, "redFence", 0.5F);
    public static final Block lightFenceGreen 	  = new BlockLightFence(false, "greenFence", 0.5F);
    public static final Block lightFenceBlueOn 	  = new BlockLightFence(true, "blueFenceOn", 0.5F);
    public static final Block lightFenceRedOn 	  = new BlockLightFence(true, "redFenceOn", 0.5F);
    public static final Block lightFenceGreenOn   = new BlockLightFence(true, "greenFenceOn", 0.5F);
    
    public static final Block ayeracoBeamBlue 	  = new BlockAyeracoBeam("ayeracoBeamBlue", "Blue");
    public static final Block ayeracoBeamGreen 	  = new BlockAyeracoBeam("ayeracoBeamGreen", "Green"); 
    public static final Block ayeracoBeamRed 	  = new BlockAyeracoBeam("ayeracoBeamRed", "Red");
    public static final Block ayeracoBeamYellow   = new BlockAyeracoBeam("ayeracoBeamYellow", "Yellow"); 
    public static final Block ayeracoBeamPurple   = new BlockAyeracoBeam("ayeracoBeamPurple", "Purple"); 

	public static final BlockStatue KingStatue 	  = new BlockStatue("kingOfScorchersStatue", new ModelKingStatue());
	public static final BlockStatue AncientStatue = new BlockStatue("ancientEntityStatue", new ModelAncientStatue());
	public static final BlockStatue AyeracoStatue = new BlockStatue("ayeracoStatue", new ModelAyeracoStatue());
	public static final BlockStatue TDemonStatue  = new BlockStatue("twilightDemonStatue", new ModelTwilightStatue());
	public static final BlockStatue VamacheronStatue= new BlockStatue("vamacheronStatue", new ModelVamacheronStatue());
	public static final BlockStatue DensosStatue  = new BlockStatue("densosStatue", new ModelDensosStatue());
	public static final BlockStatue DexStatue 	  = new BlockStatue("dexStatue", new ModelDexStatue());
	public static final BlockStatue DramixStatue  = new BlockStatue("dramixStatue", new ModelDramixStatue());
	//public static final BlockStatue ParasectaStatue = new BlockStatue("parasectaStatue", new ModelParasecta());
	public static final BlockStatue SoulFiendStatue = new BlockStatue("soulFiendStatue", new ModelSoulStatue());
	public static final BlockStatue WatcherStatue = new BlockStatue("theWatcherStatue", new ModelWatcherStatue());
	
	public static final Block tomato			  = new BlockTomato("tomatoPlant");
	public static final Block mushroom			  = new BlockMushroom("mushroomPlant");
	
	public static final Block eucalyptusWood	  = new BlockModLog("eucalyptusLog");
	public static final Block eucalyptusPlank	  = new BlockMod(EnumBlockType.WOOD, "eucalyptusPlanks", true, DivineRPGTabs.blocks);
	public static final Block divineWood	  	  = new BlockModLog("divineLog");
	public static final Block divinePlank	  	  = new BlockMod(EnumBlockType.WOOD, "divinePlanks", true, DivineRPGTabs.blocks);
	public static final Block divineLeaves	  	  = new BlockModLeaves("divineLeaves", 0.3F);
	public static final Block divineMossystone	  = new BlockMod("divineMossystone", 0.5F);
	public static final Block divineMobSpawner	  = new BlockModSpawner("divineSpawner", "null", "divineSpawner");
	
	public static final Block altarOfCorruption	  = new BlockAltarOfCorruption("altarOfCorruption");
}