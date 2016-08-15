package net.divinerpg.utils.blocks;

import net.divinerpg.blocks.arcana.BlockAcceleron;
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
import net.divinerpg.blocks.base.BlockMod;
import net.divinerpg.blocks.base.BlockModDoor;
import net.divinerpg.blocks.base.BlockModGlass;
import net.divinerpg.blocks.base.BlockModGrass;
import net.divinerpg.blocks.base.BlockModLadder;
import net.divinerpg.blocks.base.BlockModLog;
import net.divinerpg.blocks.base.BlockModTorch;
import net.divinerpg.blocks.base.BlockRedstonelessRails;
import net.divinerpg.blocks.base.BlockStupidSpawner;
import net.divinerpg.utils.material.EnumBlockType;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;

public class ArcanaBlocks {

	public static Block arcanaDirt = new BlockMod(EnumBlockType.DIRT, "arcaniteDirt", 0.5F);
	public static Block arcanaGrass = new BlockModGrass((BlockMod) arcanaDirt, "arcaniteGrass", "arcaniteDirt", 0.5F);
	public static Block arcaniumOre = new BlockMod("arcaniumOre", 3.0F);
	public static Block arcaniumMetal = new BlockMod("arcaniumMetal", false);
	public static Block arcanitetubes = new BlockModLadder("arcaniteTubes");
	public static Block arcaniumPower = new BlockMod("arcaniumPower", false);
	public static Block dungenLamp = new BlockMod("dungeonLamp", false).setLightLevel(1.0F);
	public static Block heatTrap = new BlockHeatTrap("heatTrap", -1F);
	public static Block heatTrapOn = new BlockHeatTrap("heatTrapOn", -1F);
	public static Block soulStone = new BlockMod("soulStone", false);
	public static Block soulSludge = new BlockMod("soulSludge", false);
	public static Block degradedBrick = new BlockMod("degradedBrick", false);
	public static Block darkDegradedBrick = new BlockMod("darkDegradedBrick", false);
	public static Block ancientBrick = new BlockMod("ancientBrick", false);
	public static Block ancientStone = new BlockMod("ancientStone", false);
	public static Block lightDegradedBrick = new BlockMod("lightDegradedBrick", false);
	public static Block stainedGlass = new BlockModGlass("stainedGlass", 0.3F).setUnlocalizedName("stainedGlass");
	public static Block stainedGlass2 = new BlockModGlass("stainedGlass2", 0.3F).setUnlocalizedName("stainedGlass");
	public static Block stainedGlass3 = new BlockModGlass("stainedGlass3", 0.3F).setUnlocalizedName("stainedGlass");
	public static Block stainedGlass4 = new BlockModGlass("stainedGlass4", 0.3F).setUnlocalizedName("stainedGlass");
	public static Block stainedGlass5 = new BlockModGlass("stainedGlass5", 0.3F).setUnlocalizedName("stainedGlass");
	public static Block stainedGlass6 = new BlockModGlass("stainedGlass6", 0.3F).setUnlocalizedName("stainedGlass");
	public static Block stainedGlass7 = new BlockModGlass("stainedGlass7", 0.3F).setUnlocalizedName("stainedGlass");
	public static Block stainedGlass8 = new BlockModGlass("stainedGlass8", 0.3F).setUnlocalizedName("stainedGlass");
	public static Block dungenSpawnerPrisoner = new BlockStupidSpawner("dungeonPrisonerSpawner", "DungeonPrisoner", "arcanaSpawner", false).setBlockUnbreakable().setResistance(6000000F);
	public static Block razorbackSpawner = new BlockStupidSpawner("razorbackSpawner", "Razorback", "arcanaSpawner", false).setBlockUnbreakable().setResistance(6000000F);
	public static Block deathHoundSpawner = new BlockStupidSpawner("deathHoundSpawner", "DeathHound", "arcanaSpawner", false).setBlockUnbreakable().setResistance(6000000F);
	public static Block deathcryxSpawner = new BlockStupidSpawner("deathcryxSpawner", "Deathcryx", "arcanaSpawner", false).setBlockUnbreakable().setResistance(6000000F);
	public static Block livingStatueSpawner = new BlockStupidSpawner("livingStatueSpawner", "LivingStatue", "arcanaSpawner", false).setBlockUnbreakable().setResistance(6000000F);
	public static Block roamerSpawner = new BlockStupidSpawner("roamerSpawner", "Roamer", "arcanaSpawner", false).setBlockUnbreakable().setResistance(6000000F);
	public static Block ancientTile = new BlockMod("ancientTile", false);
	public static Block starBridge = new BlockStarBridge("starBridge", false);
	public static Block starBridgeOn = new BlockStarBridge("starBridgeOn", true);
	public static Block soulSludgeDoor = new BlockModDoor(EnumBlockType.IRON, "soulSludgeDoor", -1F, false);
	public static Block ancientBrickDoor = new BlockModDoor(EnumBlockType.IRON, "ancientBrickDoor", -1F, false);
	public static Block soulStoneDoor = new BlockModDoor(EnumBlockType.IRON, "soulStoneDoor", -1F, false);
	public static Block degradedBrickDoor = new BlockModDoor(EnumBlockType.IRON, "degradedBrickDoor", -1F, false);

	public static Block dramixAltar = new BlockDramixAltar("dramixAltar");
	public static Block parasectaAltar = new BlockParasectaAltar("parasectaAltar");
	public static Block arcanaExtractor = new BlockExtractor("arcanaExtractor");

	public static Block arcanaPortal = new BlockArcanaPortal("arcanaPortal");
	public static Block arcanaPortalFrame = new BlockArcanaFrame("arcanaPortalFrame", arcanaPortal);
	public static Block arcanaHardPortalFrame = new BlockArcanaFrame("arcanaHardPortalFrame", arcanaPortal).setBlockUnbreakable().setResistance(6000000F).setCreativeTab(null);

	public static Block aquamarine = new BlockAquaMarine("aquamarinePlant");
	public static Block eucalyptusRoot = new BlockEucalyptusRoot("eucalyptusPlant");
	public static Block hitchak = new BlockHitchak("hitchakPlant");
	public static Block veilo = new BlockVeilo("veiloPlant");
	public static Block lamona = new BlockLamona("lamonaPlant");
	public static Block marsine = new BlockMarsine("marsinePlant");
	public static Block firestock = new BlockStackPlant("firestockPlant");
	public static Block pinfly = new BlockStackPlant("pinflyPlant");

	public static Block eucalyptusWood = new BlockModLog("eucalyptus");
	public static Block eucalyptusPlank = new BlockMod(EnumBlockType.WOOD, "eucalyptusPlanks", 2, DivineRPGTabs.blocks).setResistance(5);

	public static Block greenlightFurnace = new BlockGreenlightFurnace("greenlightFurnace", false);
	public static Block greenlightFurnaceOn = new BlockGreenlightFurnace("greenlightFurnaceOn", true);
	public static Block oceanfireFurnace = new BlockOceanfireFurnace("oceanfireFurnace", false);
	public static Block oceanfireFurnaceOn = new BlockOceanfireFurnace("oceanfireFurnaceOn", true);
	public static Block moltenFurnace = new BlockMoltenFurnace("moltenFurnace", false);
	public static Block moltenFurnaceOn = new BlockMoltenFurnace("moltenFurnaceOn", true);
	public static Block whitefireFurnace = new BlockWhitefireFurnace("whitefireFurnace", false);
	public static Block whitefireFurnaceOn = new BlockWhitefireFurnace("whitefireFurnaceOn", true);
	public static Block moonlightFurnace = new BlockMoonlightFurnace("moonlightFurnace", false);
	public static Block moonlightFurnaceOn = new BlockMoonlightFurnace("moonlightFurnaceOn", true);
	public static Block demonFurnace = new BlockDemonFurnace("demonFurnace", false);
	public static Block demonFurnaceOn = new BlockDemonFurnace("demonFurnaceOn", true);

	public static Block arcaniumTorch = new BlockModTorch("arcaniumTorch", null);
	public static Block elevantium = new BlockElevantium("elevantium");
	public static Block arcaniteRails = new BlockRedstonelessRails("arcaniteRails");
	public static Block acceleron = new BlockAcceleron();
	
	public static void init() {}
}