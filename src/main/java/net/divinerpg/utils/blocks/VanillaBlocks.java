package net.divinerpg.utils.blocks;

import net.divinerpg.blocks.base.BlockMod;
import net.divinerpg.blocks.base.BlockModLeaves;
import net.divinerpg.blocks.base.BlockModLog;
import net.divinerpg.blocks.base.BlockModSlab;
import net.divinerpg.blocks.base.BlockModStairs;
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
import net.divinerpg.utils.Util;
import net.divinerpg.utils.material.EnumBlockType;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;

public class VanillaBlocks {

    // Harvest Levels
    private static int WOOD_GOLD = 0, STONE = 1, IRON = 2, DIAMOND = 3;

    public static Block rupeeOre     = new VanillaBlock(EnumBlockType.ROCK, "rupeeOre", 3.0F, DIAMOND).setResistance(2000.0F);
    public static Block arlemiteOre  = new VanillaBlock(EnumBlockType.ROCK, "arlemiteOre", 3.0F, DIAMOND).setResistance(2000.0F);
    public static Block realmiteOre  = new VanillaBlock(EnumBlockType.ROCK, "realmiteOre", 3.0F, IRON).setResistance(2000.0F);
    public static Block bloodgemOre  = new BlockBloodgemOre();
    public static Block netheriteOre = new VanillaBlock(EnumBlockType.ROCK, "netheriteOre", 3.0F, DIAMOND).setResistance(2000.0F);

    public static Block rupeeBlock     = new VanillaBlock(EnumBlockType.ROCK, "rupeeBlock", 5.0F, DIAMOND).setResistance(10F);
    public static Block arlemiteBlock  = new VanillaBlock(EnumBlockType.ROCK, "arlemiteBlock", 5.0F, DIAMOND).setResistance(10F);
    public static Block realmiteBlock  = new VanillaBlock(EnumBlockType.ROCK, "realmiteBlock", 5.0F, IRON).setResistance(10F);
    public static Block bloodgemBlock  = new VanillaBlock(EnumBlockType.ROCK, "bloodgemBlock", 5.0F, DIAMOND).setResistance(10F);
    public static Block netheriteBlock = new VanillaBlock(EnumBlockType.ROCK, "netheriteBlock", 5.0F, DIAMOND).setResistance(10F);

    public static Block spiderPumpkin       = new BlockMobPumpkin().setName("spiderPumpkin");
    public static Block enderPumpkin        = new BlockMobPumpkin().setName("enderPumpkin");
    public static Block creeperPumpkin      = new BlockMobPumpkin().setName("creeperPumpkin");
    public static Block skeletonPumpkin     = new BlockMobPumpkin().setName("skeletonPumpkin");
    public static Block blazePumpkin        = new BlockMobPumpkin().setName("blazePumpkin");
    public static Block zombiePumpkin       = new BlockMobPumpkin().setName("zombiePumpkin");
    public static Block frostPumpkin        = new BlockMobPumpkin().setName("frostPumpkin");
    public static Block cyclopsPumpkin      = new BlockMobPumpkin().setName("cyclopsPumpkin");
    public static Block ghastPumpkin        = new BlockMobPumpkin().setName("ghastPumpkin");
    public static Block glaconPumpkin       = new BlockMobPumpkin().setName("glaconPumpkin");
    public static Block enderWatcherPumpkin = new BlockMobPumpkin().setName("enderWatcherPumpkin");
    public static Block jungleSpiderPumpkin = new BlockMobPumpkin().setName("jungleSpiderPumpkin");
    public static Block hellspiderPumpkin   = new BlockMobPumpkin().setName("hellspiderPumpkin");

    public static Block aquaTorch     = new BlockModTorch("aquaTorch", "blueFlame");
    public static Block skeletonTorch = new BlockModTorch("skeletonTorch", "blackFlame");

    public static Block checker     = new VanillaBlock(EnumBlockType.WOOL, "checker", 0.8F, WOOD_GOLD);
    public static Block rainbowWool = new VanillaBlock(EnumBlockType.WOOL, "rainbowWool", 0.8F, WOOD_GOLD);
    public static Block crate       = new VanillaBlock(EnumBlockType.WOOD, "crate", 2.5F, WOOD_GOLD);
    public static Block plankDesign = new VanillaBlock(EnumBlockType.WOOD, "plankDesign", 2.5F, WOOD_GOLD);
    public static Block blueStone   = new VanillaBlock(EnumBlockType.ROCK, "blueStone", 1.5F, WOOD_GOLD).setResistance(10F).setLightLevel(1);

    public static Block blueVane   = new VanillaBlock(EnumBlockType.ROCK, "blueVane", 2.0F, IRON).setResistance(10F);
    public static Block cyanVane   = new VanillaBlock(EnumBlockType.ROCK, "cyanVane", 2.0F, IRON).setResistance(10F);
    public static Block purpleVane = new VanillaBlock(EnumBlockType.ROCK, "purpleVane", 2.0F, IRON).setResistance(10F);
    public static Block redVane    = new VanillaBlock(EnumBlockType.ROCK, "redVane", 2.0F, IRON).setResistance(10F);
    public static Block yellowVane = new VanillaBlock(EnumBlockType.ROCK, "yellowVane", 2.0F, IRON).setResistance(10F);

    public static Block divineRock = new VanillaBlock(EnumBlockType.ROCK, "divineRock", 1.5F, STONE).setResistance(10F);
    public static Block tar        = new BlockTar();

    public static Block fancyWool = new VanillaBlock(EnumBlockType.WOOL, "fancyWool", 0.8F, WOOD_GOLD);

    public static Block steel         = new BlockSteel();
    public static Block divineBricks  = new BlockDivineBricks();
    public static Block minibricks    = new BlockMinibricks();
    public static Block lamp1         = new BlockLamp1();
    public static Block lamp2         = new BlockLamp2();
    public static Block milkStone     = new VanillaBlock(EnumBlockType.ROCK, "milkStone", 1.5F, WOOD_GOLD).setResistance(10F);
    public static Block darkStone     = new VanillaBlock(EnumBlockType.ROCK, "darkstone", 50f, DIAMOND).setResistance(2000.0F).setLightLevel(1);
    public static Block spikeBlock    = new BlockSpike();
    public static Block hotSpikeBlock = new BlockHotSpike();
    public static Block slimeLight    = new BlockSlimeLight(false);
    public static Block slimeLightOn  = new BlockSlimeLight(true);
    public static Block darkBridge    = new BlockDarkBridge(false);
    public static Block darkBridgeOn  = new BlockDarkBridge(true);

    public static Block lightFenceBlue    = new BlockLightFence(false, "blueFence", 0.5F);
    public static Block lightFenceRed     = new BlockLightFence(false, "redFence", 0.5F);
    public static Block lightFenceGreen   = new BlockLightFence(false, "greenFence", 0.5F);
    public static Block lightFenceBlueOn  = new BlockLightFence(true, "blueFenceOn", 0.5F);
    public static Block lightFenceRedOn   = new BlockLightFence(true, "redFenceOn", 0.5F);
    public static Block lightFenceGreenOn = new BlockLightFence(true, "greenFenceOn", 0.5F);

    public static Block ayeracoBeamBlue   = new BlockAyeracoBeam("ayeracoBeamBlue", "Blue");
    public static Block ayeracoBeamGreen  = new BlockAyeracoBeam("ayeracoBeamGreen", "Green");
    public static Block ayeracoBeamRed    = new BlockAyeracoBeam("ayeracoBeamRed", "Red");
    public static Block ayeracoBeamYellow = new BlockAyeracoBeam("ayeracoBeamYellow", "Yellow");
    public static Block ayeracoBeamPurple = new BlockAyeracoBeam("ayeracoBeamPurple", "Purple");
    public static Block ayeracoSpawn      = new BlockAyeracoSpawn();

    public static BlockStatue kosStatue           = new BlockStatue("kingOfScorchersStatue", new ModelKingStatue());
    public static BlockStatue ancientEntityStatue = new BlockStatue("ancientEntityStatue", new ModelAncientStatue());
    public static BlockStatue ayeracoStatue       = new BlockStatue("ayeracoStatue", new ModelAyeracoStatue());
    public static BlockStatue twilightDemonStatue = new BlockStatue("twilightDemonStatue", new ModelTwilightStatue());
    public static BlockStatue vamacheronStatue    = new BlockStatue("vamacheronStatue", new ModelVamacheronStatue());
    public static BlockStatue densosStatue        = new BlockStatue("densosStatue", new ModelDensosStatue());
    public static BlockStatue reyvorStatue        = new BlockStatue("reyvorStatue", new ModelReyvorStatue());
    public static BlockStatue dramixStatue        = new BlockStatue("dramixStatue", new ModelDramixStatue());
    // public static BlockStatue parasectaStatue = new BlockStatue("parasectaStatue", new ModelParasectaStatue());
    public static BlockStatue soulFiendStatue     = new BlockStatue("soulFiendStatue", new ModelSoulStatue());
    public static BlockStatue watcherStatue       = new BlockStatue("watcherStatue", new ModelWatcherStatue());
    public static BlockStatue eternalArcherStatue = new BlockStatue("eternalArcherStatue", new ModelEternArcherStatue());
    public static BlockStatue karotStatue         = new BlockStatue("karotStatue", new ModelKarotStatue());

    public static Block tomato   = new BlockTomato("tomatoPlant");
    public static Block mushroom = new BlockMushroom("mushroomPlant");

    public static Block divineWood                = new BlockModLog("divineLog");
    public static Block divineLeaves              = new BlockModLeaves("divineLeaves", 0.3F);
    public static Block divineMossystone          = new BlockMod("divineMossStone", 2.0F).setResistance(10);
    public static Block enthralledDramcryxSpawner = new BlockStupidSpawner("enthralledDramcryxSpawner", "EnthralledDramcryx", "divineSpawner", true);
    public static Block rotatickSpawner           = new BlockStupidSpawner("rotatickSpawner", "Rotatick", "divineSpawner", true);

    public static Block divinePlanks     = new BlockMod(EnumBlockType.WOOD, "divinePlanks", 2, DivineRPGTabs.blocks).setResistance(5);
    public static Block divineStairs     = new BlockModStairs(divinePlanks, "divineStairs");
    public static Block divineSlab       = new BlockModSlab((BlockMod) divinePlanks, false, "Planks", null);
    public static Block divineSlabDouble = new BlockModSlab((BlockMod) divinePlanks, true, "Planks", divineSlab);

    public static Block altarOfCorruption = new BlockAltarOfCorruption("altarOfCorruption");
    public static Block boneChest         = new BlockBoneChest("boneChest");

    public static void init() {
        Util.registerSlab(divineSlab, divineSlabDouble);
    }
}
