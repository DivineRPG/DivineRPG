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

    public static final Block arcanaDirt            = new BlockMod(EnumBlockType.DIRT, "arcaniteDirt", 0.5F);
    public static final Block arcanaGrass           = new BlockModGrass((BlockMod) arcanaDirt, "arcaniteGrass", 0.5F);
    public static final Block arcaniumOre           = new BlockMod("arcaniumOre", 0.2F);                                                                    //breakable
    public static final Block arcaniumMetal         = new BlockMod("arcaniumMetal", false);
    public static final Block arcanitetubes         = new BlockModLadder("arcaniteTubes");
    public static final Block arcaniumPower         = new BlockMod("arcaniumPower", 0.1F);                                                                  //breakable
    public static final Block dungenLamp            = new BlockMod("dungeonLamp", false).setLightLevel(1.0F);
    public static final Block heatTrap              = new BlockHeatTrap("heatTrap", -1F);
    public static final Block heatTrapOn            = new BlockHeatTrap("heatTrapOn", -1F);
    public static final Block soulStone             = new BlockMod("soulStone", false);
    public static final Block soulSludge            = new BlockMod("soulSludge", false);
    public static final Block degradedBrick         = new BlockMod("degradedBrick", false);
    public static final Block darkDegradedBrick     = new BlockMod("darkDegradedBrick", false);
    public static final Block ancientBrick          = new BlockMod("ancientBrick", false);
    public static final Block ancientStone          = new BlockMod("ancientStone", false);
    public static final Block lightDegradedBrick    = new BlockMod("lightDegradedBrick", false);
    public static final Block stainedGlass          = new BlockModGlass("stainedGlass", 0.3F);
    public static final Block stainedGlass2         = new BlockModGlass("stainedGlass2", 0.3F);
    public static final Block stainedGlass3         = new BlockModGlass("stainedGlass3", 0.3F);
    public static final Block stainedGlass4         = new BlockModGlass("stainedGlass4", 0.3F);
    public static final Block stainedGlass5         = new BlockModGlass("stainedGlass5", 0.3F);
    public static final Block stainedGlass6         = new BlockModGlass("stainedGlass6", 0.3F);
    public static final Block stainedGlass7         = new BlockModGlass("stainedGlass7", 0.3F);
    public static final Block stainedGlass8         = new BlockModGlass("stainedGlass8", 0.3F);
    public static final Block dungenSpawnerPrisoner = new BlockModSpawner("dungeonSpawnerPrisoner", "Dungeon Prisoner", "arcanaSpawner");
    public static final Block razorbackSpawner      = new BlockModSpawner("razorbackSpawner", "Razorback", "arcanaSpawner");
    public static final Block deathHoundSpawner     = new BlockModSpawner("deathHoundSpawner", "Death Hound", "arcanaSpawner");
    public static final Block deathcryxSpawner      = new BlockModSpawner("deathcryxSpawner", "Deathcryx", "arcanaSpawner");
    public static final Block livingStatueSpawner   = new BlockModSpawner("livingStatueSpawner", "Living Statue", "arcanaSpawner");
    public static final Block roamerSpawner         = new BlockModSpawner("roamerSpawner", "Roamer", "arcanaSpawner");
    public static final Block ancientTile           = new BlockMod("ancientTile", false);
    public static final Block blockOfLight          = new BlockMod("blockOfLight", 0.3F);
    public static final Block starBridge            = new BlockStarBridge("starBridge", false);
    public static final Block starBridgeOn          = new BlockStarBridge("starBridgeOn", true);

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