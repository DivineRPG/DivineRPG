package divinerpg.registry;

import java.util.ArrayList;
import java.util.List;

import divinerpg.dimensions.apalachia.ApalachiaTree;
import divinerpg.dimensions.eden.EdenTree;
import divinerpg.dimensions.mortum.MortumTree;
import divinerpg.dimensions.skythern.SkythernTree;
import divinerpg.dimensions.wildwood.WildWoodTree;
import divinerpg.enums.EnumBlockType;
import divinerpg.enums.ParticleType;
import divinerpg.enums.StatueType;
import divinerpg.enums.WoodType;
import divinerpg.objects.blocks.*;
import divinerpg.objects.blocks.arcana.*;
import divinerpg.objects.blocks.iceika.*;
import divinerpg.objects.blocks.twilight.*;
import divinerpg.objects.blocks.vanilla.*;
import divinerpg.objects.blocks.vethea.*;
import divinerpg.world.DivineTree;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemSlab;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    private static int WOOD_GOLD = 0, STONE = 1, IRON = 2, DIAMOND = 3;

    // Vanilla
    public static Block rupeeOre = new BlockModOre("rupee_ore", 3.0F, 2000F, DIAMOND, null);
    public static Block arlemiteOre = new BlockModOre("arlemite_ore", 3.0F, 2000F, DIAMOND, null);
    public static Block realmiteOre = new BlockModOre("realmite_ore", 3.0F, 2000F, IRON, null);
    public static Block bloodgemOre = new BlockModOre("bloodgem_ore", 3.0F, 2000F, DIAMOND, ModItems.bloodgem);
    public static Block netheriteOre = new BlockNetheriteOre("netherite_ore", 3.0F, 2000F, DIAMOND, null);

    public static Block rupeeBlock = new BlockMod(EnumBlockType.ROCK, "rupee_block", 5.0F, DIAMOND, true);
    public static Block arlemiteBlock = new BlockMod(EnumBlockType.ROCK, "arlemite_block", 5.0F, DIAMOND, true);
    public static Block realmiteBlock = new BlockMod(EnumBlockType.ROCK, "realmite_block", 5.0F, IRON, true);
    public static Block bloodgemBlock = new BlockMod(EnumBlockType.ROCK, "bloodgem_block", 5.0F, DIAMOND, true);
    public static Block netheriteBlock = new BlockMod(EnumBlockType.ROCK, "netherite_block", 5.0F, DIAMOND, true);

    public static Block spiderPumpkin = new BlockMobPumpkin("spider_pumpkin", SoundEvents.ENTITY_SPIDER_AMBIENT);
    public static Block enderPumpkin = new BlockMobPumpkin("ender_pumpkin", SoundEvents.ENTITY_ENDERMEN_SCREAM);
    public static Block creeperPumpkin = new BlockMobPumpkin("creeper_pumpkin", SoundEvents.ENTITY_CREEPER_PRIMED);
    public static Block skeletonPumpkin = new BlockMobPumpkin("skeleton_pumpkin", SoundEvents.ENTITY_SKELETON_AMBIENT);
    public static Block blazePumpkin = new BlockMobPumpkin("blaze_pumpkin", SoundEvents.ENTITY_BLAZE_AMBIENT);
    public static Block zombiePumpkin = new BlockMobPumpkin("zombie_pumpkin", SoundEvents.ENTITY_ZOMBIE_AMBIENT);
    public static Block frostPumpkin = new BlockMobPumpkin("frost_pumpkin", ModSounds.FROST);
    public static Block cyclopsPumpkin = new BlockMobPumpkin("cyclops_pumpkin", ModSounds.CYCLOPS);
    public static Block ghastPumpkin = new BlockMobPumpkin("ghast_pumpkin", SoundEvents.ENTITY_GHAST_SCREAM);
    public static Block glaconPumpkin = new BlockMobPumpkin("glacon_pumpkin", ModSounds.GLACIDE);
    public static Block enderWatcherPumpkin = new BlockMobPumpkin("ender_watcher_pumpkin", SoundEvents.ENTITY_ENDERMEN_AMBIENT);
    public static Block jungleSpiderPumpkin = new BlockMobPumpkin("jungle_spider_pumpkin", ModSounds.HELL_SPIDER);
    public static Block hellspiderPumpkin = new BlockMobPumpkin("hellspider_pumpkin", ModSounds.HELL_SPIDER);

    public static Block aquaTorch = new BlockModTorch("aqua_torch", ParticleType.BLUE_FLAME);
    public static Block skeletonTorch = new BlockModTorch("skeleton_torch", ParticleType.BLACK_FLAME);

    public static Block checker = new BlockMod(EnumBlockType.WOOL, "checker", 0.8F, WOOD_GOLD, false);
    public static Block rainbowWool = new BlockMod(EnumBlockType.WOOL, "rainbow_wool", 0.8F, WOOD_GOLD, false);
    public static Block crate = new BlockMod(EnumBlockType.WOOD, "crate", 2.5F, WOOD_GOLD, false);
    public static Block plankDesign = new BlockMod(EnumBlockType.WOOD, "plank_design", 2.5F, WOOD_GOLD, false);
    public static Block blueStone = new BlockMod(EnumBlockType.ROCK, "blue_stone", 1.5F, WOOD_GOLD, false).setResistance(10F)
            .setLightLevel(1);

    public static Block blueVane = new BlockMod(EnumBlockType.ROCK, "blue_vane", 2.0F, IRON, false).setResistance(10F);
    public static Block cyanVane = new BlockMod(EnumBlockType.ROCK, "cyan_vane", 2.0F, IRON, false).setResistance(10F);
    public static Block purpleVane = new BlockMod(EnumBlockType.ROCK, "purple_vane", 2.0F, IRON, false).setResistance(10F);
    public static Block redVane = new BlockMod(EnumBlockType.ROCK, "red_vane", 2.0F, IRON, false).setResistance(10F);
    public static Block yellowVane = new BlockMod(EnumBlockType.ROCK, "yellow_vane", 2.0F, IRON, false).setResistance(10F);

    public static Block divineRock = new BlockMod(EnumBlockType.ROCK, "divine_rock", 1.5F, STONE, false).setResistance(10F);
    public static Block tar = new BlockTar("tar", ModLiquids.tar);

    public static Block asphalt = new BlockMod("asphalt", 2.0F); //The texture is a placeholder

    public static Block fancyWool = new BlockMod(EnumBlockType.WOOL, "fancy_wool", 0.8F, WOOD_GOLD, false);

    public static Block tealSteel = new BlockMod(EnumBlockType.ROCK, "teal_steel", 10.0F, DIAMOND, false).setResistance(60.0F);
    public static Block redSteel = new BlockMod(EnumBlockType.ROCK, "red_steel", 10.0F, DIAMOND, false).setResistance(60.0F);
    public static Block purpleSteel = new BlockMod(EnumBlockType.ROCK, "purple_steel", 10.0F, DIAMOND, false)
            .setResistance(60.0F);
    public static Block greenSteel = new BlockMod(EnumBlockType.ROCK, "green_steel", 10.0F, DIAMOND, false)
            .setResistance(60.0F);
    public static Block yellowSteel = new BlockMod(EnumBlockType.ROCK, "yellow_steel", 10.0F, DIAMOND, false)
            .setResistance(60.0F);
    public static Block blueSteel = new BlockMod(EnumBlockType.ROCK, "blue_steel", 10.0F, DIAMOND, false).setResistance(60.0F);
    public static Block whiteSteel = new BlockMod(EnumBlockType.ROCK, "white_steel", 10.0F, DIAMOND, false)
            .setResistance(60.0F);
    public static Block blackSteel = new BlockMod(EnumBlockType.ROCK, "black_steel", 10.0F, DIAMOND, false)
            .setResistance(60.0F);
    public static Block orangeSteel = new BlockMod(EnumBlockType.ROCK, "orange_steel", 10.0F, DIAMOND, false)
            .setResistance(60.0F);
    public static Block brightRedSteel = new BlockMod(EnumBlockType.ROCK, "bright_red_steel", 10.0F, DIAMOND, false)
            .setResistance(60.0F);

    public static Block aquatonicBricks = new BlockMod(EnumBlockType.ROCK, "aquatonic_bricks", 3.0F, IRON, false)
            .setResistance(30.0F);
    public static Block arlemiteBricks = new BlockMod(EnumBlockType.ROCK, "arlemite_bricks", 3.0F, IRON, false)
            .setResistance(30.0F);
    public static Block darkstoneBricks = new BlockMod(EnumBlockType.ROCK, "darkstone_bricks", 3.0F, IRON, false)
            .setResistance(30.0F);
    public static Block diamondBricks = new BlockMod(EnumBlockType.ROCK, "diamond_bricks", 3.0F, IRON, false)
            .setResistance(30.0F);
    public static Block goldBricks = new BlockMod(EnumBlockType.ROCK, "gold_bricks", 3.0F, IRON, false).setResistance(30.0F);
    public static Block greenBricks = new BlockMod(EnumBlockType.ROCK, "green_bricks", 3.0F, IRON, false).setResistance(30.0F);
    public static Block ironBricks = new BlockMod(EnumBlockType.ROCK, "iron_bricks", 3.0F, IRON, false).setResistance(30.0F);
    public static Block lapisLazuliBricks = new BlockMod(EnumBlockType.ROCK, "lapis_lazuli_bricks", 3.0F, IRON, false)
            .setResistance(30.0F);
    public static Block lavaBricks = new BlockMod(EnumBlockType.ROCK, "lava_bricks", 3.0F, IRON, false).setResistance(30.0F);
    public static Block netheriteBricks = new BlockMod(EnumBlockType.ROCK, "netherite_bricks", 3.0F, IRON, false)
            .setResistance(30.0F);
    public static Block pinkBricks = new BlockMod(EnumBlockType.ROCK, "pink_bricks", 3.0F, IRON, false).setResistance(30.0F);
    public static Block purpleBricks = new BlockMod(EnumBlockType.ROCK, "purple_bricks", 3.0F, IRON, false)
            .setResistance(30.0F);
    public static Block realmiteBricks = new BlockMod(EnumBlockType.ROCK, "realmite_bricks", 3.0F, IRON, false)
            .setResistance(30.0F);
    public static Block redstoneBricks = new BlockMod(EnumBlockType.ROCK, "redstone_bricks", 3.0F, IRON, false)
            .setResistance(30.0F);
    public static Block milkStoneBricks = new BlockMod(EnumBlockType.ROCK, "milk_stone_bricks", 3.0F, IRON, false)
            .setResistance(30.0F);

    public static Block rupeeMinibricks = new BlockMod(EnumBlockType.ROCK, "rupee_minibricks", 3.0F, IRON, false)
            .setResistance(30.0F);
    public static Block realmiteMinibricks = new BlockMod(EnumBlockType.ROCK, "realmite_minibricks", 3.0F, IRON, false)
            .setResistance(30.0F);
    public static Block arlemiteMinibricks = new BlockMod(EnumBlockType.ROCK, "arlemite_minibricks", 3.0F, IRON, false)
            .setResistance(30.0F);
    public static Block minibricks = new BlockMod(EnumBlockType.ROCK, "minibricks", 3.0F, IRON, false).setResistance(30.0F);
    public static Block bloodgemMinibricks = new BlockMod(EnumBlockType.ROCK, "bloodgem_minibricks", 3.0F, IRON, false)
            .setResistance(30.0F);
    public static Block netheriteMinibricks = new BlockMod(EnumBlockType.ROCK, "netherite_minibricks", 3.0F, IRON, false)
            .setResistance(30.0F);
    public static Block bedrockMinibricks = new BlockMod(EnumBlockType.ROCK, "bedrock_minibricks", 3.0F, IRON, false)
            .setResistance(30.0F);

    public static Block aquaLamp = new BlockModLamp(EnumBlockType.GLASS, "aqua_lamp", 3.0F).setResistance(30.0F);
    public static Block arlemiteLamp = new BlockModLamp(EnumBlockType.GLASS, "arlemite_lamp", 3.0F)
            .setResistance(30.0F);
    public static Block blazeLamp = new BlockModLamp(EnumBlockType.GLASS, "blaze_lamp", 3.0F).setResistance(30.0F);
    public static Block bluefireLamp = new BlockModLamp(EnumBlockType.GLASS, "bluefire_lamp", 3.0F)
            .setResistance(30.0F);
    public static Block diamondLamp = new BlockModLamp(EnumBlockType.GLASS, "diamond_lamp", 3.0F).setResistance(30.0F);
    public static Block divineLamp = new BlockModLamp(EnumBlockType.GLASS, "divine_lamp", 3.0F).setResistance(30.0F);
    public static Block drakenLamp = new BlockModLamp(EnumBlockType.GLASS, "draken_lamp", 3.0F).setResistance(30.0F);
    public static Block edenLamp = new BlockModLamp(EnumBlockType.GLASS, "eden_lamp", 3.0F).setResistance(30.0F);
    public static Block enderLamp = new BlockModLamp(EnumBlockType.GLASS, "ender_lamp", 3.0F).setResistance(30.0F);
    public static Block enderStoneLamp = new BlockModLamp(EnumBlockType.GLASS, "ender_stone_lamp", 3.0F)
            .setResistance(30.0F);
    public static Block goldLamp = new BlockModLamp(EnumBlockType.GLASS, "gold_lamp", 3.0F).setResistance(30.0F);
    public static Block iceLamp = new BlockModLamp(EnumBlockType.GLASS, "ice_lamp", 3.0F).setResistance(30.0F);
    public static Block jungleLamp = new BlockModLamp(EnumBlockType.GLASS, "jungle_lamp", 3.0F).setResistance(30.0F);
    public static Block krakenLamp = new BlockModLamp(EnumBlockType.GLASS, "kraken_lamp", 3.0F).setResistance(30.0F);
    public static Block lapisLazuliLamp = new BlockModLamp(EnumBlockType.GLASS, "lapis_lazuli_lamp", 3.0F)
            .setResistance(30.0F);
    public static Block lavaLamp = new BlockModLamp(EnumBlockType.GLASS, "lava_lamp", 3.0F).setResistance(30.0F);
    public static Block milkyLamp = new BlockModLamp(EnumBlockType.GLASS, "milky_lamp", 3.0F).setResistance(30.0F);
    public static Block moltenLamp = new BlockModLamp(EnumBlockType.GLASS, "molten_lamp", 3.0F).setResistance(30.0F);
    public static Block netheriteLamp = new BlockModLamp(EnumBlockType.GLASS, "netherite_lamp", 3.0F)
            .setResistance(30.0F);
    public static Block realmiteLamp = new BlockModLamp(EnumBlockType.GLASS, "realmite_lamp", 3.0F)
            .setResistance(30.0F);
    public static Block redstoneOrekLamp = new BlockModLamp(EnumBlockType.GLASS, "redstone_ore_lamp", 3.0F)
            .setResistance(30.0F);
    public static Block rupeeLamp = new BlockModLamp(EnumBlockType.GLASS, "rupee_lamp", 3.0F).setResistance(30.0F);
    public static Block terranLamp = new BlockModLamp(EnumBlockType.GLASS, "terran_lamp", 3.0F).setResistance(30.0F);

    public static Block milkStone = new BlockMod(EnumBlockType.ROCK, "milk_stone", 1.5F, WOOD_GOLD, false).setResistance(10F);
    public static Block darkstone = new BlockMod(EnumBlockType.ROCK, "darkstone", 50f, DIAMOND, false).setResistance(2000.0F)
            .setLightLevel(1);
    public static Block spikeBlock = new BlockSpike("spike_block");
    public static Block hotSpikeBlock = new BlockHotSpike("hot_spike_block");
    public static Block slimeLight = new BlockModLight("slime_light", 1.5F);
    public static Block darkBridge = new BlockModBridge("dark_bridge", 1.5F);

    public static Block redFence = new BlockLightFence(MapColor.RED, "red_fence", false, 0.5F);
    public static Block greenFence = new BlockLightFence(MapColor.GREEN, "green_fence", false, 0.5F);
    public static Block blueFence = new BlockLightFence(MapColor.BLUE, "blue_fence", false, 0.5F);
    public static Block redFenceOn = new BlockLightFence(MapColor.RED, "red_fence_on", true, 0.5F);
    public static Block greenFenceOn = new BlockLightFence(MapColor.GREEN, "green_fence_on", true, 0.5F);
    public static Block blueFenceOn = new BlockLightFence(MapColor.BLUE, "blue_fence_on", true, 0.5F);

    public static Block ayeracoBeamBlue = new BlockAyeracoBeam("ayeraco_beam_blue", "blue");
    public static Block ayeracoBeamGreen = new BlockAyeracoBeam("ayeraco_beam_green", "green");
    public static Block ayeracoBeamRed = new BlockAyeracoBeam("ayeraco_beam_red", "red");
    public static Block ayeracoBeamYellow = new BlockAyeracoBeam("ayeraco_beam_yellow", "yellow");
    public static Block ayeracoBeamPurple = new BlockAyeracoBeam("ayeraco_beam_purple", "purple");
    public static Block ayeracoSpawn = new BlockAyeracoSpawn();

    public static BlockStatue ancientEntityStatue = new BlockStatue("ancient_entity_statue",
            StatueType.ANCIENT_ENTITY_STATUE);
    public static BlockStatue ayeracoStatue = new BlockStatue("ayeraco_statue", StatueType.AYERACO_STATUE);
    public static BlockStatue densosStatue = new BlockStatue("densos_statue", StatueType.DENSOS_STATUE);
    public static BlockStatue dramixStatue = new BlockStatue("dramix_statue", StatueType.DRAMIX_STATUE);
    public static BlockStatue eternalArcherStatue = new BlockStatue("eternal_archer_statue",
            StatueType.ETERNAL_ARCHER_STATUE);
    public static BlockStatue karotStatue = new BlockStatue("karot_statue", StatueType.KAROT_STATUE);
    public static BlockStatue kingOfScorchersStatue = new BlockStatue("king_of_scorchers_statue",
            StatueType.KING_OF_SCORCHERS_STATUE);
    public static BlockStatue parasectaStatue = new BlockStatue("parasecta_statue", StatueType.PARASECTA_STATUE);
    public static BlockStatue reyvorStatue = new BlockStatue("reyvor_statue", StatueType.REYVOR_STATUE);
    public static BlockStatue soulFiendStatue = new BlockStatue("soul_fiend_statue", StatueType.SOUL_FIEND_STATUE);
    public static BlockStatue theWatcherStatue = new BlockStatue("the_watcher_statue", StatueType.THE_WATCHER_STATUE);
    public static BlockStatue twilightDemonStatue = new BlockStatue("twilight_demon_statue",
            StatueType.TWILIGHT_DEMON_STATUE);
    public static BlockStatue vamacheronStatue = new BlockStatue("vamacheron_statue", StatueType.VAMACHERON_STATUE);

    public static Block tomatoPlant = new BlockTomatoPlant();
    public static Block whiteMushroomPlant = new BlockWhiteMushroomPlant();

    public static Block divineSapling = new BlockModSapling("divine_sapling", Blocks.GRASS, Blocks.DIRT,
            new DivineTree(true));
    public static Block divineLogs = new BlockModLog("divine_log", MapColor.YELLOW);
    public static Block divineLeaves = new BlockModLeaves("divine_leaves", 0.3F, divineSapling, MapColor.YELLOW);
    public static Block divineMossystone = new BlockMod("divine_moss_stone", 2.0F).setResistance(10);

    public static Block altarOfCorruption = new BlockAltarOfCorruption("altar_of_corruption");
    public static Block boneChest = new BlockBoneChest("bone_chest");

    // Iceika
    public static Block frozenDirt = new BlockModDirt("frozen_dirt", 2.5F, MapColor.WHITE_STAINED_HARDENED_CLAY);
    public static Block frozenGrass = new BlockModGrass((BlockMod) frozenDirt, "frozen_grass", 2.5F, MapColor.LIGHT_BLUE);
    public static Block frozenStone = new BlockMod("frozen_stone", 6.0F);
    public static Block frozenLogs = new BlockModLog("frozen_log", MapColor.WHITE_STAINED_HARDENED_CLAY).setHardness(5.0F);
    public static Block brittleLeaves = new BlockModLeaves("brittle_leaves", 0.1F, MapColor.WHITE_STAINED_HARDENED_CLAY);

    public static Block winterberryBush = new BlockWinterberryBush(false, "winterberry_bush");
    public static Block ripeWinterberryBush = new BlockWinterberryBush(true, "ripe_winterberry_bush");

    public static Block icyStone = new BlockModUnbreakable("icy_stone");
    public static Block icyBricks = new BlockModUnbreakable("icy_bricks");
    public static Block frostedChest = new BlockFrostedChest("frosted_chest").setHardness(2.5F);
    public static Block rollumSpawner = new BlockModSpawner("rollum_spawner", "rollum");
    public static Block frostArcherSpawner = new BlockModSpawner("frost_archer_spawner", "frost_archer");
    public static Block snowBricks = new BlockMod("snow_bricks", 6.0F);
    public static Block coalstone = new BlockMod("coalstone", 3.0F);
    public static Block coalstoneStairs = new BlockModStairs(coalstone, "coalstone_stairs");
    public static Block workshopCarpet = new BlockMod(EnumBlockType.WOOL, "workshop_carpet", 0.1F);
    public static Block frostedGlass = new BlockModGlass("frosted_glass", 1.0F);
    public static Block workshopBookcase = new BlockMod(EnumBlockType.ROCK, "workshop_bookcase", 1.5F);
    public static Block workshopLamp = new BlockModLamp(EnumBlockType.GLASS, "workshop_lamp", 0.3F);
    public static Block steelDoor = new BlockModDoor("steel_door", Material.IRON, 7.0f);
    public static Block coalstoneFurnace = new BlockCoalstoneFurnace("coalstone_furnace", false);
    public static Block coalstoneFurnaceOn = new BlockCoalstoneFurnace("coalstone_furnace_on", true);

    public static Block redChristmasLights = new BlockChristmasLights("red_christmas_lights");
    public static Block greenChristmasLights = new BlockChristmasLights("green_christmas_lights");
    public static Block blueChristmasLights = new BlockChristmasLights("blue_christmas_lights");
    public static Block yellowChristmasLights = new BlockChristmasLights("yellow_christmas_lights");
    public static Block purpleChristmasLights = new BlockChristmasLights("purple_christmas_lights");
    public static Block blueCandyCane = new BlockCandyCane("blue_candy_cane");
    public static Block greenCandyCane = new BlockCandyCane("green_candy_cane");
    public static Block pinkCandyCane = new BlockCandyCane("pink_candy_cane");
    public static Block redCandyCane = new BlockCandyCane("red_candy_cane");
    public static Block yellowCandyCane = new BlockCandyCane("yellow_candy_cane");

    public static Block presentBox = new BlockPresentBox("present_box");

    public static Block iceikaFire = new BlockModFire("iceika_fire");
    public static BlockModPortal iceikaPortal = new BlockModPortal("iceika_portal",
            ModDimensions.iceikaDimension.getId(), iceikaFire, Blocks.SNOW, ParticleType.FROST);

    // Twilight
    public static Block edenDirt = new BlockModDirt("eden_dirt", 5.0F, MapColor.YELLOW);
    public static Block wildwoodDirt = new BlockModDirt("wildwood_dirt", 5.0F, MapColor.BLUE);
    public static Block apalachiaDirt = new BlockModDirt("apalachia_dirt", 5.0F, MapColor.PURPLE);
    public static Block skythernDirt = new BlockModDirt("skythern_dirt", 5.0F, MapColor.GRAY);
    public static Block mortumDirt = new BlockModDirt("mortum_dirt", 5.0F, MapColor.BLACK);
    public static Block edenGrass = new BlockModGrass((BlockMod) edenDirt, "eden_grass", 5.0F, MapColor.YELLOW);
    public static Block wildwoodGrass = new BlockModGrass((BlockMod) wildwoodDirt, "wildwood_grass", 5.0F, MapColor.BLUE);
    public static Block apalachiaGrass = new BlockModGrass((BlockMod) apalachiaDirt, "apalachia_grass", 5.0F, MapColor.PURPLE);
    public static Block skythernGrass = new BlockModGrass((BlockMod) skythernDirt, "skythern_grass", 5.0F, MapColor.CLOTH);
    public static Block mortumGrass = new BlockModGrass((BlockMod) mortumDirt, "mortum_grass", 5.0F, MapColor.BLACK);

    public static Block edenOre = new BlockTwilightOre("eden_ore", 9, 2000F, DIAMOND, ModItems.edenFragments);
    public static Block wildwoodOre = new BlockTwilightOre("wildwood_ore", 9, 2000F, DIAMOND,
            ModItems.wildwoodFragments);
    public static Block apalachiaOre = new BlockTwilightOre("apalachia_ore", 9, 2000F, DIAMOND,
            ModItems.apalachiaFragments);
    public static Block skythernOre = new BlockTwilightOre("skythern_ore", 9, 2000F, DIAMOND,
            ModItems.skythernFragments);
    public static Block mortumOre = new BlockTwilightOre("mortum_ore", 9, 2000F, DIAMOND, ModItems.mortumFragments);

    public static Block edenBlock = new BlockMod("eden_block", 9, true);
    public static Block wildwoodBlock = new BlockMod("wildwood_block", 9, true);
    public static Block apalachiaBlock = new BlockMod("apalachia_block", 9, true);
    public static Block skythernBlock = new BlockMod("skythern_block", 9, true);
    public static Block mortumBlock = new BlockMod("mortum_block", 9, true);

    public static Block edenSapling = new BlockModSapling("eden_sapling", edenGrass, edenDirt, new EdenTree(true));
    public static Block wildwoodSapling = new BlockModSapling("wildwood_sapling", wildwoodGrass, wildwoodDirt,
            new WildWoodTree(true));
    public static Block apalachiaSapling = new BlockModSapling("apalachia_sapling", apalachiaGrass, apalachiaDirt,
            new ApalachiaTree(true));
    public static Block skythernSapling = new BlockModSapling("skythern_sapling", skythernGrass, skythernDirt,
            new SkythernTree(true));
    public static Block mortumSapling = new BlockModSapling("mortum_sapling", mortumGrass, mortumDirt,
            new MortumTree(true));

    public static Block edenLeaves = new BlockModLeaves("eden_leaves", 0.5F, edenSapling, MapColor.YELLOW);
    public static Block wildwoodLeaves = new BlockModLeaves("wildwood_leaves", 0.5F, wildwoodSapling, MapColor.LIGHT_BLUE);
    public static Block apalachiaLeaves = new BlockModLeaves("apalachia_leaves", 0.5F, apalachiaSapling, MapColor.PINK).setLightLevel(0.5F);
    public static Block skythernLeaves = new BlockModLeaves("skythern_leaves", 0.5F, skythernSapling, MapColor.CLOTH);
    public static Block mortumLeaves = new BlockModLeaves("mortum_leaves", 0.5F, mortumSapling, MapColor.RED);

    public static Block edenLogs = new BlockModLog("eden_log", MapColor.YELLOW);
    public static Block wildwoodLogs = new BlockModLog("wildwood_log", MapColor.BLUE);
    public static Block apalachiaLogs = new BlockModLog("apalachia_log", MapColor.PURPLE);
    public static Block skythernLogs = new BlockModLog("skythern_log", MapColor.GRAY);
    public static Block mortumLogs = new BlockModLog("mortum_log", MapColor.RED);

    public static Block twilightStone = new BlockMod("twilight_stone", 6.0F);
    public static Block wildwoodVine = new BlockModVine("wildwood_vine");
    public static Block blueFire = new BlockModFire("blue_fire");
    public static BlockModPortal edenPortal = new BlockModPortal("eden_portal", ModDimensions.edenDimension.getId(),
            blueFire, divineRock, ParticleType.EDEN_PORTAL);
    public static BlockModPortal wildwoodPortal = new BlockModPortal("wildwood_portal",
            ModDimensions.wildWoodDimension.getId(), blueFire, edenBlock, ParticleType.WILDWOOD_PORTAL);
    public static BlockModPortal apalachiaPortal = new BlockModPortal("apalachia_portal",
            ModDimensions.apalachiaDimension.getId(), blueFire, wildwoodBlock, ParticleType.APALACHIA_PORTAL);
    public static BlockModPortal skythernPortal = new BlockModPortal("skythern_portal",
            ModDimensions.skythernDimension.getId(), blueFire, apalachiaBlock, ParticleType.SKYTHERN_PORTAL);
    public static BlockModPortal mortumPortal = new BlockModPortal("mortum_portal",
            ModDimensions.mortumDimension.getId(), blueFire, skythernBlock, ParticleType.MORTUM_PORTAL);

    public static Block edenTorch = new BlockModTorch("eden_torch", ParticleType.GREEN_FLAME);
    public static Block edenChest = new BlockEdenChest("eden_chest");

    public static Block moonbulb = new BlockMoonbulb().setLightLevel(0.6f);
    public static Block purpleGlowbone = new BlockPurpleGlowbone().setLightLevel(0.6f);
    public static Block pinkGlowbone = new BlockPinkGlowbone().setLightLevel(0.6f);
    public static Block skyPlant = new BlockSkyPlant();

    public static Block sunbloom = new BlockTwilightFlower("sunbloom", edenGrass, MapColor.YELLOW);
    public static Block edenBrush = new BlockTwilightGrass("eden_brush", edenGrass, MapColor.YELLOW);
    public static Block sunBlossom = new BlockTwilightFlower("sun_blossom", edenGrass, 0.9, 0.6, MapColor.YELLOW);
    public static Block moonlightFern = new BlockTwilightFlower("moonlight_fern", wildwoodGrass, 0.8, 0.8, MapColor.BLUE);
    public static Block moonBud = new BlockTwilightFlower("moon_bud", wildwoodGrass, 0.8, 0.7, MapColor.BLUE);
    public static Block wildwoodTallgrass = new BlockModDoublePlant("wildwood_tallgrass", wildwoodGrass, MapColor.BLUE);
    public static Block duskFlower = new BlockModDoublePlant("dusk_flower", apalachiaGrass, MapColor.PURPLE);
    public static Block duskBloom = new BlockTwilightFlower("dusk_bloom", apalachiaGrass, 0.5, 0.5, MapColor.PURPLE);
    public static Block apalachiaTallgrass = new BlockTwilightGrass("apalachia_tallgrass", apalachiaGrass, MapColor.PURPLE);
    public static Block skythernBrush = new BlockTwilightGrass("skythern_brush", skythernGrass, MapColor.GRAY);
    public static Block dustLily = new BlockTwilightFlower("dust_lily", skythernGrass, MapColor.GRAY);
    public static Block dustBrambles = new BlockBrambles("dust_brambles", skythernGrass, MapColor.GRAY);
    public static Block demonBrambles = new BlockBrambles("demon_brambles", mortumGrass, MapColor.BLACK);
    public static Block eyePlant = new BlockTwilightFlower("eye_plant", mortumGrass, 0.5, 0.5, MapColor.BLACK);
    public static Block mortumBrush = new BlockTwilightGrass("mortum_brush", mortumGrass, MapColor.BLACK);

    public static Block truffle = new BlockMod(EnumBlockType.PLANT, "truffle", 1.0F);

    // Arcana
    public static Block arcanaDirt = new BlockModDirt("arcanite_dirt", 0.5F, MapColor.BLUE);
    public static Block arcanaGrass = new BlockModGrass((BlockMod) arcanaDirt, "arcanite_grass", 0.5F, MapColor.BLUE);
    public static Block ancientTile = new BlockModUnbreakable("ancient_tile");
    public static Block arcaniumOre = new BlockMod("arcanium_ore", 3.0F);
    public static Block arcaniumMetal = new BlockModUnbreakable("arcanium_metal");
    public static Block arcaniteTubes = new BlockModLadder("arcanite_tubes");
    public static Block arcaniumPower = new BlockModUnbreakable("arcanium_power");
    public static Block dungeonLamp = new BlockModUnbreakable("dungeon_lamp").setLightLevel(1.0F);
    public static Block heatTrap = new BlockHeatTrap("heat_trap");
    public static Block heatTrapOn = new BlockHeatTrap("heat_trap_on");
    public static Block soulStone = new BlockModUnbreakable("soul_stone");
    public static Block soulSludge = new BlockModUnbreakable("soul_sludge");
    public static Block degradedBrick = new BlockModUnbreakable("degraded_brick");
    public static Block darkDegradedBrick = new BlockModUnbreakable("dark_degraded_brick");
    public static Block ancientBrick = new BlockModUnbreakable("ancient_brick");
    public static Block ancientStone = new BlockModUnbreakable("ancient_stone");
    public static Block lightDegradedBrick = new BlockModUnbreakable("light_degraded_brick");
    public static Block stainedGlass = new BlockModGlass("stained_glass", 0.3F).setUnlocalizedName("stained_glass");
    public static Block stainedGlass2 = new BlockModGlass("stained_glass2", 0.3F).setUnlocalizedName("stained_glass");
    public static Block stainedGlass3 = new BlockModGlass("stained_glass3", 0.3F).setUnlocalizedName("stained_glass");
    public static Block stainedGlass4 = new BlockModGlass("stained_glass4", 0.3F).setUnlocalizedName("stained_glass");
    public static Block stainedGlass5 = new BlockModGlass("stained_glass5", 0.3F).setUnlocalizedName("stained_glass");
    public static Block stainedGlass6 = new BlockModGlass("stained_glass6", 0.3F).setUnlocalizedName("stained_glass");
    public static Block stainedGlass7 = new BlockModGlass("stained_glass7", 0.3F).setUnlocalizedName("stained_glass");
    public static Block stainedGlass8 = new BlockModGlass("stained_glass8", 0.3F).setUnlocalizedName("stained_glass");
    public static Block dungeonSpawnerPrisoner = new BlockArcanaSpawner("dungeon_prisoner_spawner", "dungeon_prisoner");
    public static Block razorbackSpawner = new BlockArcanaSpawner("razorback_spawner", "razorback");
    public static Block deathHoundSpawner = new BlockArcanaSpawner("death_hound_spawner", "death_hound");
    public static Block deathcryxSpawner = new BlockArcanaSpawner("deathcryx_spawner", "deathcryx");
    public static Block livingStatueSpawner = new BlockArcanaSpawner("living_statue_spawner", "living_statue");
    public static Block roamerSpawner = new BlockArcanaSpawner("roamer_spawner", "roamer");
    public static Block starBridge = new BlockModBridge("star_bridge", 1.5F);
    public static Block soulSludgeDoor = new BlockArcanaDoor("soul_sludge_door", ModItems.sludgeKey);
    public static Block ancientBrickDoor = new BlockArcanaDoor("ancient_brick_door", ModItems.ancientKey);
    public static Block soulStoneDoor = new BlockArcanaDoor("soul_stone_door", ModItems.soulKey);
    public static Block degradedBrickDoor = new BlockArcanaDoor("degraded_brick_door", ModItems.degradedKey);

    public static Block dramixAltar = new BlockDramixAltar("dramix_altar");
    public static Block parasectaAltar = new BlockParasectaAltar("parasecta_altar");
    public static Block arcaniumExtractor = new BlockArcaniumExtractor("arcanium_extractor");

    public static Block arcanaPortal = new BlockArcanaPortal("arcana_portal", ModDimensions.arcanaDimension.getId());
    public static Block arcanaPortalFrame = new BlockArcanaPortalFrame("arcana_portal_frame", arcanaPortal);
    public static Block arcanaHardPortalFrame = new BlockArcanaPortalFrame("arcana_hard_portal_frame", arcanaPortal)
            .setBlockUnbreakable().setResistance(6000000F).setCreativeTab(null);

    public static Block aquamarine = new BlockAquaMarine("aquamarine_plant");
    public static Block eucalyptusRoot = new BlockEucalyptusRoot("eucalyptus_plant");
    public static Block hitchak = new BlockHitchak("hitchak_plant");
    public static Block veilo = new BlockVeilo("veilo_plant");
    public static Block lamona = new BlockLamona("lamona_plant");
    public static Block marsine = new BlockMarsine("marsine_plant");
    public static Block firestock = new BlockFirestock();
    public static Block pinfly = new BlockPinfly();
    public static Block eucalyptusLogs = new BlockModLog("eucalyptus_log", MapColor.CLOTH);

    public static Block greenlightFurnace = new BlockGreenlightFurnace("greenlight_furnace", false);
    public static Block greenlightFurnaceOn = new BlockGreenlightFurnace("greenlight_furnace_on", true);
    public static Block oceanfireFurnace = new BlockOceanfireFurnace("oceanfire_furnace", false);
    public static Block oceanfireFurnaceOn = new BlockOceanfireFurnace("oceanfire_furnace_on", true);
    public static Block moltenFurnace = new BlockMoltenFurnace("molten_furnace", false);
    public static Block moltenFurnaceOn = new BlockMoltenFurnace("molten_furnace_on", true);
    public static Block whitefireFurnace = new BlockWhitefireFurnace("whitefire_furnace", false);
    public static Block whitefireFurnaceOn = new BlockWhitefireFurnace("whitefire_furnace_on", true);
    public static Block moonlightFurnace = new BlockMoonlightFurnace("moonlight_furnace", false);
    public static Block moonlightFurnaceOn = new BlockMoonlightFurnace("moonlight_furnace_on", true);
    public static Block demonFurnace = new BlockDemonFurnace("demon_furnace", false);
    public static Block demonFurnaceOn = new BlockDemonFurnace("demon_furnace_on", true);

    public static Block arcaniumTorch = new BlockModTorch("arcanium_torch", ParticleType.PURPLE_FLAME);
    public static Block elevantium = new BlockElevantium("elevantium");
    //We are avoiding rails for now
    //public static Block arcaniteRails = new BlockRedstonelessRails("arcanite_rails");
    public static Block acceleron = new BlockAcceleron("acceleron");

    /* EVERYTHING BELOW THIS POINT IS VETHEA */

    public static Block dreamDirt = new BlockModDirt("dream_dirt", 2.5F, MapColor.LIME_STAINED_HARDENED_CLAY);
    public static Block dreamGrass = new BlockModGrass((BlockMod) dreamDirt, "dream_grass", 2.5F, MapColor.LIGHT_BLUE);
    public static Block dreamStone = new BlockMod("dream_stone", 6.0F);
    public static BlockModPortal vetheaPortal = new BlockModPortal("vethea_portal",
            ModDimensions.vetheaDimension.getId(), ModBlocks.blueFire, ModBlocks.mortumBlock, ParticleType.MORTUM_PORTAL);

    public static Block everstone = new BlockModUnbreakable("everstone");
    public static Block darkEverstone = new BlockModUnbreakable("dark_everstone");
    public static Block whiteEverstone = new BlockModUnbreakable("white_everstone");

    public static Block fireCrystal = new BlockModLamp(EnumBlockType.GLASS,"fire_crystal", 1.0F);
    public static Block firelight = new BlockModLamp(EnumBlockType.GLASS, "firelight", 1.0F);

    public static Block firewoodLog = new BlockModLog("firewood_log", MapColor.RED).setHardness(5.0F);
    public static Block hyrewoodLog = new BlockModLog("hyrewood_log", MapColor.RED).setHardness(5.0F);
    public static Block mintwoodLog = new BlockModLog("mintwood_log", MapColor.RED).setHardness(5.0F);
    public static Block dreamwoodLog = new BlockModLog("dreamwood_log", MapColor.RED).setHardness(5.0F);

    public static Block firewoodLeaves = new BlockModLeaves("firewood_leaves", 0.1F, MapColor.RED);
    public static Block hyrewoodLeaves = new BlockModLeaves("hyrewood_leaves", 0.1F, MapColor.RED);
    public static Block mintwoodLeaves = new BlockModLeaves("mintwood_leaves", 0.1F, MapColor.RED);
    public static Block dreamWoodLeaves = new BlockModLeaves("dreamwood_leaves", 0.1F, MapColor.RED);

    public static Block dreamLamp = new BlockModUnbreakable("dream_lamp");
    public static Block infusionTable = new BlockInfusionTable("infusion_table");
    public static Block cryptFloor = new BlockModUnbreakable("crypt_floor");
    public static Block greenHungerstone = new BlockModUnbreakable("green_hungerstone");
    public static Block blackHungerstone = new BlockModUnbreakable("black_hungerstone");
    public static Block hallWall = new BlockModUnbreakable("hall_wall");
    public static Block blueKarosBricks = new BlockModUnbreakable("blue_karos_bricks");
    public static Block blackKarosBricks = new BlockModUnbreakable("black_karos_bricks");

    public static Block karosCannon = new BlockModUnbreakable("karos_cannon");
    public static Block helioticBeam = new BlockModUnbreakable("heliotic_beam");

    public static Block wreckAltar = new BlockWreckAltar("wreck_altar");
    public static Block quadroticAltar = new BlockQuadroticAltar("quadrotic_altar");
    public static Block karosAltar = new BlockKarosAltar("karos_altar");
    public static Block raglokAltar = new BlockRaglokAltar("raglok_altar");
    public static Block lunicAltar = new BlockLunicAltar("lunic_altar");

    public static Block lightDreamBricks = new BlockMod("light_dream_bricks", 1.0F);
    public static Block darkDreamBricks = new BlockMod("dark_dream_bricks", 1.0F);
    public static Block redDreamBricks = new BlockMod("red_dream_bricks", 1.0F);
    public static Block lunaStone = new BlockMod("luna_stone", 1.0F);
    public static Block lunaBricks = new BlockMod("luna_bricks", 1.0F);
    public static Block weedwoodVine = new BlockModVine("weedwood_vine");
    public static Block blossomingWeedwoodVine = new BlockModVine("blossomed_weedwood_vine");
    public static Block cryptWall = new BlockMod("crypt_wall", 1.0F);
    public static Block smoothGlass = new BlockModGlass("smooth_glass", 0.3F);
    public static Block villageLamp = new BlockModLamp(EnumBlockType.GLASS, "village_lamp", 1.0F);
    public static Block cellLamp = new BlockModLamp(EnumBlockType.GLASS, "cell_lamp", 1.0F);
    public static Block hiveWall = new BlockMod(EnumBlockType.GLASS, "hive_wall", 1.0F).setLightLevel(0.533F);

    public static Block chamberWall = new BlockModUnbreakable("chamber_wall");
    public static Block shiftedChamberWall = new BlockModUnbreakable("shifted_chamber_wall");
    public static Block stackedChamberWall = new BlockModUnbreakable("stacked_chamber_wall");

    public static Block bacterialAcid = new BlockModUnbreakable("bacterial_acid");
    public static Block blockAcid = new BlockModUnbreakable("acid_block");
    public static Block lunicAcid = new BlockModUnbreakable("lunic_acid");

    public static Block karosHeatTileGreen = new BlockModUnbreakable("karos_heat_tile_green");
    public static Block karosHeatTileRed = new BlockModUnbreakable("karos_heat_tile_red");

    public static Block metalCaging = new BlockModGlass("metal_caging", 1.0F);

    public static Block cracklespike = new BlockTwilightFlower("cracklespike", dreamGrass, MapColor.GREEN);
    public static Block fernite = new BlockTwilightFlower("fernite", dreamGrass, MapColor.GREEN);
    public static Block bulbatobe = new BlockTwilightFlower("bulbatobe", dreamGrass, MapColor.GREEN);
    public static Block shineGrass = new BlockTwilightFlower("shine_grass", dreamGrass, MapColor.GREEN);
    public static Block shimmer = new BlockTwilightFlower("shimmer", dreamGrass, MapColor.GREEN);
    public static Block dreamglow = new BlockTwilightFlower("dreamglow", dreamGrass, MapColor.GREEN);
    public static Block greenGemtop = new BlockTwilightFlower("green_gemtop", dreamGrass, MapColor.GREEN);
    public static Block purpleGemtop = new BlockTwilightFlower("purple_gemtop", dreamGrass, MapColor.GREEN);
    public static Block yellowDulah = new BlockTwilightFlower("yellow_dulah", dreamGrass, MapColor.GREEN);
    public static Block greenDulah = new BlockTwilightFlower("green_dulah", dreamGrass, MapColor.GREEN);
    
    public static Block nightmareBed = new BlockNightmareBed();

    //TEMPROARY
    public static Block dreamwreckerSpawner = new BlockModSpawner("dreamwrecker_spawner", "Deathcryx");
    public static Block vermenousSpawner = new BlockModSpawner("vermenous_spawner", "Deathcryx");
    public static Block twinsSpawner = new BlockModSpawner("twins_spawner", "Deathcryx");
    public static Block biphronSpawner = new BlockModSpawner("biphron_spawner", "Deathcryx");
    public static Block gorgosionSpawner = new BlockModSpawner("gorgosion_spawner", "Deathcryx");



    public static void AddWoodVariants() {
        for (WoodType woodType : WoodType.values()) {
            String woodName = woodType.getName();

            // Make special property key that allows ONLY one value because slabs are special level of stupid
            final PropertyEnum<WoodType> restrictedKey = PropertyEnum.create("variant", WoodType.class,
                    input -> input == woodType);

            BlockModPlank planks = new BlockModPlank(woodType);
            Block stairs = new BlockModStairs(planks, woodName + "_stairs");
            Block singleSlab = new BlockModSlab(planks, null, woodType) {
                @Override
                public boolean isDouble() {
                    return false;
                }

                protected Block getSingle() {
                    return this;
                }

                @Override
                public IProperty<WoodType> getVariantProperty() {
                    return restrictedKey;
                }
            };

            Block doubleSlab = new BlockModSlab(planks, singleSlab, woodType) {
                @Override
                public boolean isDouble() {
                    return true;
                }

                protected Block getSingle() {
                    return singleSlab;
                }

                @Override
                public IProperty<WoodType> getVariantProperty() {
                    return restrictedKey;
                }
            };

            woodType.setPlank(planks);
            woodType.setStair(stairs);
            woodType.setSingleSlab(singleSlab);
            woodType.setDoubleSlab(doubleSlab);

            ModItems.ITEMS.add(new ItemSlab(singleSlab, (BlockSlab) singleSlab, (BlockSlab) doubleSlab)
                    .setRegistryName(singleSlab.getRegistryName()));
            ModItems.ITEMS.add(new ItemSlab(doubleSlab, (BlockSlab) singleSlab, (BlockSlab) doubleSlab)
                    .setRegistryName(doubleSlab.getRegistryName()));
        }
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        ModBlocks.AddWoodVariants();
        event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
    }
}