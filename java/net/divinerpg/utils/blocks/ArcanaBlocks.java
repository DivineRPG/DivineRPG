package net.divinerpg.utils.blocks;

import net.divinerpg.api.blocks.BlockMod;
import net.divinerpg.api.blocks.BlockModDoor;
import net.divinerpg.api.blocks.BlockModGlass;
import net.divinerpg.api.blocks.BlockModGrass;
import net.divinerpg.api.blocks.BlockModLadder;
import net.divinerpg.api.blocks.BlockModSpawner;
import net.divinerpg.blocks.arcana.BlockAquaMarine;
import net.divinerpg.blocks.arcana.BlockArcanaFrame;
import net.divinerpg.blocks.arcana.BlockArcanaPortal;
import net.divinerpg.blocks.arcana.BlockDemonFurnace;
import net.divinerpg.blocks.arcana.BlockDramixAltar;
import net.divinerpg.blocks.arcana.BlockEucalyptusRoot;
import net.divinerpg.blocks.arcana.BlockExtractor;
import net.divinerpg.blocks.arcana.BlockGreenlightFurnace;
import net.divinerpg.blocks.arcana.BlockHeatTrap;
import net.divinerpg.blocks.arcana.BlockHitchak;
import net.divinerpg.blocks.arcana.BlockLamona;
import net.divinerpg.blocks.arcana.BlockMarsine;
import net.divinerpg.blocks.arcana.BlockMoltenFurnace;
import net.divinerpg.blocks.arcana.BlockMoonlightFurnace;
import net.divinerpg.blocks.arcana.BlockOceanfireFurnace;
import net.divinerpg.blocks.arcana.BlockParasectaAltar;
import net.divinerpg.blocks.arcana.BlockStackPlant;
import net.divinerpg.blocks.arcana.BlockStarBridge;
import net.divinerpg.blocks.arcana.BlockVeilo;
import net.divinerpg.blocks.arcana.BlockWhitefireFurnace;
import net.divinerpg.utils.items.ArcanaItems;
import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.Block;

public class ArcanaBlocks {
	
	public static void init(){
		arcanaDirt            = new BlockMod(EnumBlockType.DIRT, "arcaniteDirt", 0.5F);
		arcanaGrass           = new BlockModGrass((BlockMod) arcanaDirt, "arcaniteGrass", 0.5F);
		arcaniumOre           = new BlockMod("arcaniumOre", 0.2F);
		arcaniumMetal         = new BlockMod("arcaniumMetal", false);
		arcanitetubes         = new BlockModLadder("arcaniteTubes");
		arcaniumPower         = new BlockMod("arcaniumPower", 0.1F);
		dungenLamp            = new BlockMod("dungeonLamp", false).setLightLevel(1.0F);
		heatTrap              = new BlockHeatTrap("heatTrap", -1F);
		heatTrapOn            = new BlockHeatTrap("heatTrapOn", -1F);
		soulStone             = new BlockMod("soulStone", false);
		soulSludge            = new BlockMod("soulSludge", false);
		degradedBrick         = new BlockMod("degradedBrick", false);
		darkDegradedBrick     = new BlockMod("darkDegradedBrick", false);
		ancientBrick          = new BlockMod("ancientBrick", false);
		ancientStone          = new BlockMod("ancientStone", false);
		lightDegradedBrick    = new BlockMod("lightDegradedBrick", false);
		stainedGlass          = new BlockModGlass("stainedGlass", 0.3F);
		stainedGlass2         = new BlockModGlass("stainedGlass2", 0.3F);
		stainedGlass3         = new BlockModGlass("stainedGlass3", 0.3F);
		stainedGlass4         = new BlockModGlass("stainedGlass4", 0.3F);
		stainedGlass5         = new BlockModGlass("stainedGlass5", 0.3F);
		stainedGlass6         = new BlockModGlass("stainedGlass6", 0.3F);
		stainedGlass7         = new BlockModGlass("stainedGlass7", 0.3F);
		stainedGlass8         = new BlockModGlass("stainedGlass8", 0.3F);
		dungenSpawnerPrisoner = new BlockModSpawner("dungeonSpawnerPrisoner", "Dungeon Prisoner", "arcanaSpawner");
		razorbackSpawner      = new BlockModSpawner("razorbackSpawner", "Razorback", "arcanaSpawner");
		deathHoundSpawner     = new BlockModSpawner("deathHoundSpawner", "DeathHound", "arcanaSpawner");
		deathcryxSpawner      = new BlockModSpawner("deathcryxSpawner", "Deathcryx", "arcanaSpawner");
		livingStatueSpawner   = new BlockModSpawner("livingStatueSpawner", "LivingStatue", "arcanaSpawner");
		roamerSpawner         = new BlockModSpawner("roamerSpawner", "Roamer", "arcanaSpawner");
		ancientTile           = new BlockMod("ancientTile", false);
		starBridge            = new BlockStarBridge("starBridge", false);
		starBridgeOn          = new BlockStarBridge("starBridgeOn", true);
	}

    public static Block arcanaDirt;
    public static Block arcanaGrass;
    public static Block arcaniumOre;                                                                    //breakable
    public static Block arcaniumMetal;
    public static Block arcanitetubes;
    public static Block arcaniumPower;                                                                  //breakable
    public static Block dungenLamp;
    public static Block heatTrap;
    public static Block heatTrapOn;
    public static Block soulStone;
    public static Block soulSludge;
    public static Block degradedBrick;
    public static Block darkDegradedBrick;
    public static Block ancientBrick;
    public static Block ancientStone;
    public static Block lightDegradedBrick;
    public static Block stainedGlass;
    public static Block stainedGlass2;
    public static Block stainedGlass3;
    public static Block stainedGlass4;
    public static Block stainedGlass5;
    public static Block stainedGlass6;
    public static Block stainedGlass7;
    public static Block stainedGlass8 ;
    public static Block dungenSpawnerPrisoner;
    public static Block razorbackSpawner;
    public static Block deathHoundSpawner;
    public static Block deathcryxSpawner;
    public static Block livingStatueSpawner;
    public static Block roamerSpawner;
    public static Block ancientTile;
    public static Block starBridge;
    public static Block starBridgeOn;

    public static final Block oreDoor1              = new BlockModDoor(EnumBlockType.IRON, "oreDoor1", -1F, ArcanaItems.key1);
    public static final Block oreDoor2              = new BlockModDoor(EnumBlockType.IRON, "oreDoor2", -1F, ArcanaItems.key2);
    public static final Block oreDoor3              = new BlockModDoor(EnumBlockType.IRON, "oreDoor3", -1F, ArcanaItems.key3);
    public static final Block oreDoor4              = new BlockModDoor(EnumBlockType.IRON, "oreDoor4", -1F, ArcanaItems.key4);
    
    public static final Block dramixAltar           = new BlockDramixAltar("dramixAltar");
    public static final Block parasectaAltar        = new BlockParasectaAltar("parasectaAltar");
    public static final Block arcanaExtractor       = new BlockExtractor("arcanaExtractor");

    public static final Block arcanaPortal          = new BlockArcanaPortal("arcanaPortal");
    public static final Block arcanaPortalFrame     = new BlockArcanaFrame("arcanaPortalFrame", arcanaPortal);
    
	public static final Block aquamarine		  	= new BlockAquaMarine("aquamarinePlant");
	public static final Block eucalyptusRoot	  	= new BlockEucalyptusRoot("eucalyptusPlant");
    public static final Block hitchak		  		= new BlockHitchak("hitchakPlant");
    public static final Block veilo		  			= new BlockVeilo("veiloPlant");
    public static final Block lamona		  		= new BlockLamona("lamonaPlant");
    public static final Block marsine		  		= new BlockMarsine("marsinePlant");
    public static final Block firestock		  		= new BlockStackPlant("firestock_bottom", ArcanaItems.firestock, ArcanaItems.firestockSeeds);
    public static final Block firestock2		  	= new BlockStackPlant("firestock_top", ArcanaItems.firestock, ArcanaItems.firestockSeeds);
    public static final Block pinfly		  		= new BlockStackPlant("pinfly_bottom", ArcanaItems.pinfly, ArcanaItems.pinflySeeds);
    public static final Block pinfly2		  	    = new BlockStackPlant("pinfly_top", ArcanaItems.pinfly, ArcanaItems.pinflySeeds);
    public static final Block moonbulb		  		= new BlockStackPlant("moonbulb_bottom", ArcanaItems.moonbulb, ArcanaItems.moonbulbSeeds);
    public static final Block moonbulb2		  		= new BlockStackPlant("moonbulb_top", ArcanaItems.moonbulb, ArcanaItems.moonbulbSeeds);

    public static final Block greenlightFurnace 	= new BlockGreenlightFurnace("greenlightFurnace", false);
    public static final Block greenlightFurnaceOn 	= new BlockGreenlightFurnace("greenlightFurnaceOn", true);
    public static final Block oceanfireFurnace 	    = new BlockOceanfireFurnace("oceanfireFurnace", false);
    public static final Block oceanfireFurnaceOn 	= new BlockOceanfireFurnace("oceanfireFurnaceOn", true);
    public static final Block moltenFurnace 	    = new BlockMoltenFurnace("moltenFurnace", false);
    public static final Block moltenFurnaceOn 		= new BlockMoltenFurnace("moltenFurnaceOn", true);
    public static final Block whitefireFurnace 	    = new BlockWhitefireFurnace("whitefireFurnace", false);
    public static final Block whitefireFurnaceOn 	= new BlockWhitefireFurnace("whitefireFurnaceOn", true);
    public static final Block moonlightFurnace 	    = new BlockMoonlightFurnace("moonlightFurnace", false);
    public static final Block moonlightFurnaceOn 	= new BlockMoonlightFurnace("moonlightFurnaceOn", true);
    public static final Block demonFurnace 	    	= new BlockDemonFurnace("demonFurnace", false);
    public static final Block demonFurnaceOn 		= new BlockDemonFurnace("demonFurnaceOn", true);
    
}