package net.divinerpg.utils.blocks;

import net.divinerpg.api.blocks.BlockMod;
import net.divinerpg.api.blocks.BlockModDoor;
import net.divinerpg.api.blocks.BlockModGlass;
import net.divinerpg.api.blocks.BlockModGrass;
import net.divinerpg.api.blocks.BlockModLadder;
import net.divinerpg.api.blocks.BlockStupidSpawner;
import net.divinerpg.api.blocks.BlockModTorch;
import net.divinerpg.api.blocks.BlockRedstonelessRails;
import net.divinerpg.blocks.arcana.BlockAquaMarine;
import net.divinerpg.blocks.arcana.BlockArcanaFrame;
import net.divinerpg.blocks.arcana.BlockArcanaPortal;
import net.divinerpg.blocks.arcana.BlockDemonFurnace;
import net.divinerpg.blocks.arcana.BlockDramixAltar;
import net.divinerpg.blocks.arcana.BlockElevantium;
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
import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.Block;

public class ArcanaBlocks {
	
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

    public static Block oreDoor1;
    public static Block oreDoor2;
    public static Block oreDoor3;
    public static Block oreDoor4;
    
    public static Block dramixAltar;
    public static Block parasectaAltar;
    public static Block arcanaExtractor;

    public static Block arcanaPortal;
    public static Block arcanaPortalFrame;
    
	public static Block aquamarine;
	public static Block eucalyptusRoot;
    public static Block hitchak;
    public static Block veilo;
    public static Block lamona;
    public static Block marsine;
    public static Block firestock;
    public static Block pinfly;

    public static Block greenlightFurnace;
    public static Block greenlightFurnaceOn;
    public static Block oceanfireFurnace;
    public static Block oceanfireFurnaceOn;
    public static Block moltenFurnace;
    public static Block moltenFurnaceOn;
    public static Block whitefireFurnace;
    public static Block whitefireFurnaceOn;
    public static Block moonlightFurnace;
    public static Block moonlightFurnaceOn;
    public static Block demonFurnace;
    public static Block demonFurnaceOn;
    
    public static Block arcaniumTorch;
    public static Block elevantium;
    public static BlockRedstonelessRails arcaniteRails;
	
	public static void init(){
		arcanaDirt            = new BlockMod(EnumBlockType.DIRT, "arcaniteDirt", 0.5F);
		arcanaGrass           = new BlockModGrass((BlockMod) arcanaDirt, "arcaniteGrass", "arcaniteDirt", 0.5F);
		arcaniumOre           = new BlockMod("arcaniumOre", 3.0F);
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
		dungenSpawnerPrisoner = new BlockStupidSpawner("dungeonPrisonerSpawner", "DungeonPrisoner", "arcanaSpawner", false).setBlockUnbreakable().setResistance(6000000F);
		razorbackSpawner      = new BlockStupidSpawner("razorbackSpawner", "Razorback", "arcanaSpawner", false).setBlockUnbreakable().setResistance(6000000F);
		deathHoundSpawner     = new BlockStupidSpawner("deathHoundSpawner", "DeathHound", "arcanaSpawner", false).setBlockUnbreakable().setResistance(6000000F);
		deathcryxSpawner      = new BlockStupidSpawner("deathcryxSpawner", "Deathcryx", "arcanaSpawner", false).setBlockUnbreakable().setResistance(6000000F);
		livingStatueSpawner   = new BlockStupidSpawner("livingStatueSpawner", "LivingStatue", "arcanaSpawner", false).setBlockUnbreakable().setResistance(6000000F);
		roamerSpawner         = new BlockStupidSpawner("roamerSpawner", "Roamer", "arcanaSpawner", false).setBlockUnbreakable().setResistance(6000000F);
		ancientTile           = new BlockMod("ancientTile", false);
		starBridge            = new BlockStarBridge("starBridge", false);
		starBridgeOn          = new BlockStarBridge("starBridgeOn", true);
		
		oreDoor1              = new BlockModDoor(EnumBlockType.IRON, "oreDoor1", -1F, false);
	    oreDoor2              = new BlockModDoor(EnumBlockType.IRON, "oreDoor2", -1F, false);
	    oreDoor3              = new BlockModDoor(EnumBlockType.IRON, "oreDoor3", -1F, false);
	    oreDoor4              = new BlockModDoor(EnumBlockType.IRON, "oreDoor4", -1F, false);
	    
	    dramixAltar           = new BlockDramixAltar("dramixAltar");
	    parasectaAltar        = new BlockParasectaAltar("parasectaAltar");
	    arcanaExtractor       = new BlockExtractor("arcanaExtractor");

	    arcanaPortal          = new BlockArcanaPortal("arcanaPortal");
	    arcanaPortalFrame     = new BlockArcanaFrame("arcanaPortalFrame", arcanaPortal);
	    
		aquamarine		  		= new BlockAquaMarine("aquamarinePlant");
		eucalyptusRoot	  		= new BlockEucalyptusRoot("eucalyptusPlant");
	    hitchak		  			= new BlockHitchak("hitchakPlant");
	    veilo		  			= new BlockVeilo("veiloPlant");
	    lamona		  			= new BlockLamona("lamonaPlant");
	    marsine		  			= new BlockMarsine("marsinePlant");
	    firestock		  		= new BlockStackPlant("firestockPlant");
	    pinfly		  			= new BlockStackPlant("pinflyPlant");

	    greenlightFurnace 		= new BlockGreenlightFurnace("greenlightFurnace", false);
	    greenlightFurnaceOn 	= new BlockGreenlightFurnace("greenlightFurnaceOn", true);
	    oceanfireFurnace 	    = new BlockOceanfireFurnace("oceanfireFurnace", false);
	    oceanfireFurnaceOn 		= new BlockOceanfireFurnace("oceanfireFurnaceOn", true);
	    moltenFurnace 	    	= new BlockMoltenFurnace("moltenFurnace", false);
	    moltenFurnaceOn 		= new BlockMoltenFurnace("moltenFurnaceOn", true);
	    whitefireFurnace 	    = new BlockWhitefireFurnace("whitefireFurnace", false);
	    whitefireFurnaceOn 		= new BlockWhitefireFurnace("whitefireFurnaceOn", true);
	    moonlightFurnace 	    = new BlockMoonlightFurnace("moonlightFurnace", false);
	    moonlightFurnaceOn 		= new BlockMoonlightFurnace("moonlightFurnaceOn", true);
	    demonFurnace 	    	= new BlockDemonFurnace("demonFurnace", false);
	    demonFurnaceOn 			= new BlockDemonFurnace("demonFurnaceOn", true);
	    
	    arcaniumTorch			= new BlockModTorch("arcaniumTorch", null);
	    elevantium				= new BlockElevantium("elevantium");
	    arcaniteRails			= new BlockRedstonelessRails("arcaniteRails");
	}
}