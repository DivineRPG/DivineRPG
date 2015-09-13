package net.divinerpg.utils.blocks;

import net.divinerpg.blocks.base.BlockMod;
import net.divinerpg.blocks.base.BlockModDoor;
import net.divinerpg.blocks.base.BlockModGlass;
import net.divinerpg.blocks.base.BlockModGrass;
import net.divinerpg.blocks.base.BlockModLeaves;
import net.divinerpg.blocks.base.BlockModLog;
import net.divinerpg.blocks.base.BlockModVine;
import net.divinerpg.blocks.base.BlockStupidSpawner;
import net.divinerpg.blocks.vethea.BlockAcid;
import net.divinerpg.blocks.vethea.BlockDreamLamp;
import net.divinerpg.blocks.vethea.BlockHelioticBeam;
import net.divinerpg.blocks.vethea.BlockInfusionTable;
import net.divinerpg.blocks.vethea.BlockKarosCannon;
import net.divinerpg.blocks.vethea.BlockKarosHeatTile;
import net.divinerpg.blocks.vethea.BlockNightmareBed;
import net.divinerpg.blocks.vethea.BlockShimmer;
import net.divinerpg.blocks.vethea.BlockVetheaLog;
import net.divinerpg.blocks.vethea.BlockVetheaPlant;
import net.divinerpg.blocks.vethea.BlockVetheaPortal;
import net.divinerpg.utils.material.EnumBlockType;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class VetheaBlocks {

	public static Block vetheaPortal = new BlockVetheaPortal();
	public static Block dreamwreckerSpawner = new BlockStupidSpawner("dreamWreckerSpawner", "Dreamwrecker", "fireCrystal", true);
	public static Block vermenousSpawner = new BlockStupidSpawner("vermenousSpawner", "Vermenous", "fireCrystal", true);
	public static Block twinsSpawner = new BlockStupidSpawner("twinsSpawner", "Twins", "fireCrystal", true);
	public static Block biphronSpawner = new BlockStupidSpawner("biphronSpawner", "Biphron", "fireCrystal", true);
	public static Block gorgosionSpawner = new BlockStupidSpawner("gorgosionSpawner", "Gorgosion", "fireCrystal", true);

	public static Block wreckAltar = new BlockMod("wreckAltar", 0.7F, DivineRPGTabs.spawner);
	public static Block quadroticAltar = new BlockMod("quadroticAltar", 0.7F, DivineRPGTabs.spawner);
	public static Block karosAltar = new BlockMod("karosAltar", 0.7F, DivineRPGTabs.spawner);
	public static Block raglokAltar = new BlockMod("raglokAltar", 0.7F, DivineRPGTabs.spawner);
	public static Block lunicAltar = new BlockMod("lunicAltar", 0.7F, DivineRPGTabs.spawner);

	public static Block dreamStone = new BlockMod("dreamStone", 0.25F, DivineRPGTabs.vethea);
	public static Block dreamDirt = new BlockMod(EnumBlockType.DIRT, "dreamDirt", 0.3F, DivineRPGTabs.vethea);
	public static Block dreamGrass = new BlockModGrass((BlockMod) dreamDirt, "dreamGrass", "dreamDirt", 0.3F).setCreativeTab(DivineRPGTabs.vethea);
	public static Block fireCrystal = new BlockMod(EnumBlockType.GLASS, "fireCrystal", 1.0F, DivineRPGTabs.vethea).setLightLevel(0.7F);

	public static Block dreamWoodLog = new BlockVetheaLog("dreamwoodLog");
	public static Block dreamWoodLeaves = new BlockModLeaves("dreamwoodLeaves", 0.3F).setCreativeTab(DivineRPGTabs.vethea);
	public static Block lightDreamBricks = new BlockMod("lightDreamBricks", 1.0F, DivineRPGTabs.vethea);
	public static Block darkDreamBricks = new BlockMod("darkDreamBricks", 1.0F, DivineRPGTabs.vethea);
	public static Block lunaStone = new BlockMod("lunaStone", 1.0F, DivineRPGTabs.vethea);
	public static Block lunaBricks = new BlockMod("lunaBrick", 1.0F, DivineRPGTabs.vethea);
	public static Block metalCaging = new BlockModGlass("metalCaging", 1.0F).setStepSound(Block.soundTypeMetal).setCreativeTab(DivineRPGTabs.vethea);
	public static Block dreamLampOn = new BlockDreamLamp("dreamLampOn", true);
	public static Block dreamLamp = new BlockDreamLamp("dreamLampOff", false);
	public static Block weedwoodVine = new BlockModVine("weedWoodVine").setCreativeTab(DivineRPGTabs.vethea);
	public static Block blossomingWeedwoodVine = new BlockModVine("blossomedWeedWoodVine").setCreativeTab(DivineRPGTabs.vethea);
	public static Block cryptWall = new BlockMod("cryptWall", 1.0F, DivineRPGTabs.vethea);
	public static Block smoothGlass = new BlockModGlass("smoothGlass", 0.3F).setCreativeTab(DivineRPGTabs.vethea);
	public static Block villageLamp = new BlockMod(EnumBlockType.GLASS, "villageLamp", 1.0F, DivineRPGTabs.vethea).setLightLevel(1);
	public static Block cellLamp = new BlockMod(EnumBlockType.GLASS, "cellLamp", 1.0F, DivineRPGTabs.vethea).setLightLevel(1);
	public static Block barredDoor = new BlockModDoor(EnumBlockType.IRON, "barredDoorBlock", 0.5F, true);
	public static Block firelight = new BlockMod(EnumBlockType.GLASS, "firelight", 1.0F, DivineRPGTabs.vethea).setLightLevel(1).setResistance(1);
	public static Block hyrewood = new BlockVetheaLog("hyrewoodLog");
	public static Block mintwoodLeaves = new BlockModLeaves("mintwoodLeaves", 0.3F).setCreativeTab(DivineRPGTabs.vethea);
	public static Block redDreamBricks = new BlockMod("redDreamBricks", 1.0F, DivineRPGTabs.vethea);
	public static Block karosHeatTileGreen = new BlockMod(EnumBlockType.GLASS, "karosHeatTileGreen", false, DivineRPGTabs.vethea);
	public static Block karosHeatTileRed = new BlockKarosHeatTile();
	public static Block firewood = new BlockVetheaLog("firewoodLog");
	public static Block bacterialAcid = new BlockAcid("bacterialAcid", false);
	public static Block blockAcid = new BlockAcid("acidBlock", true);
	public static Block everstone = new BlockMod("greenEverstone", 3.0F, DivineRPGTabs.vethea);
	public static Block lunicAcid = new BlockAcid("lunicAcid", true, true);
	public static Block firewoodLeaves = new BlockModLeaves("firewoodLeaves", 0.3F).setCreativeTab(DivineRPGTabs.vethea);
	public static Block hyrewoodLeaves = new BlockModLeaves("hyrewoodLeaves", 0.3F).setCreativeTab(DivineRPGTabs.vethea);
	public static Block gemtopGreen = new BlockVetheaPlant("greenGemTop");
	public static Block gemtopPurple = new BlockVetheaPlant("purpleGemTop");
	public static Block purpleDulah = new BlockVetheaPlant("purpleDulah");
	public static Block yellowDulah = new BlockVetheaPlant("yellowDulah");
	public static Block greenDulah = new BlockVetheaPlant("greenDulah");
	public static Block mintwood = new BlockVetheaLog("mintwoodLog");
	public static Block cracklespike = new BlockVetheaPlant("crackleSpike");
	public static Block fernite = new BlockVetheaPlant("fernite");
	public static Block bulatobe = new BlockVetheaPlant("bulbatobe");
	public static Block shineGrass = new BlockVetheaPlant("shineGrass").setLightLevel(0.4F);
	public static Block shimmer = new BlockShimmer("shimmer").setLightLevel(0.4F);
	public static Block hiveWall = new BlockMod(EnumBlockType.GLASS, "hiveWalls", 1.0F, DivineRPGTabs.vethea).setLightLevel(0.533F);
	public static Block dreamglow = new BlockVetheaPlant("dreamglow").setLightLevel(0.4F);
	public static Block hyrewoodVine = new BlockModVine("hyreWoodVine").setCreativeTab(DivineRPGTabs.vethea);
	public static Block chamberWall = new BlockMod(EnumBlockType.ROCK, "chamberWall1", false, DivineRPGTabs.vethea).setUnlocalizedName("chamberWall");
	public static Block chamberWall1 = new BlockMod(EnumBlockType.ROCK, "chamberWall2", false, DivineRPGTabs.vethea).setUnlocalizedName("chamberWall");
	public static Block chamberWall2 = new BlockMod(EnumBlockType.ROCK, "chamberWall3", false, DivineRPGTabs.vethea).setUnlocalizedName("chamberWall");
	public static Block whiteEverstone = new BlockMod(EnumBlockType.ROCK, "whiteEverstone", false, DivineRPGTabs.vethea);
	public static Block darkEverstone = new BlockMod(EnumBlockType.ROCK, "darkEverstone", false, DivineRPGTabs.vethea);
	public static Block blackHungerstone = new BlockMod(EnumBlockType.ROCK, "blackHungerstone", false, DivineRPGTabs.vethea);
	public static Block greenHungerstone = new BlockMod(EnumBlockType.ROCK, "greenHungerstone", false, DivineRPGTabs.vethea);
	public static Block cryptFloor = new BlockMod(EnumBlockType.ROCK, "cryptFloor", false, DivineRPGTabs.vethea);
	public static Block hallWall = new BlockMod(EnumBlockType.ROCK, "hallWall", false, DivineRPGTabs.vethea);
	public static Block blueKarosBricks = new BlockMod(EnumBlockType.ROCK, "blueKarosBricks", false, DivineRPGTabs.vethea);
	public static Block blackKarosBricks = new BlockMod(EnumBlockType.ROCK, "blackKarosBricks", false, DivineRPGTabs.vethea);
	public static Block infusionTable = new BlockInfusionTable().setName("infusionTable").setBlockUnbreakable();
	public static BlockHelioticBeam helioticBeam = (BlockHelioticBeam) new BlockHelioticBeam("helioticBeam");
	public static BlockKarosCannon karosCannon = (BlockKarosCannon) new BlockKarosCannon(Material.rock).register();
	public static Block nightmareBedBlock = new BlockNightmareBed();
	
	public static void init(){}
}
