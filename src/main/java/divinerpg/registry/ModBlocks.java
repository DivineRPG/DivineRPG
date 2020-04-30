package divinerpg.registry;

import divinerpg.DivineRPG;
import divinerpg.dimensions.TwilightTree;
import divinerpg.dimensions.eden.EdenTree;
import divinerpg.dimensions.iceika.IceTreeGen;
import divinerpg.dimensions.mortum.MortumTree;
import divinerpg.dimensions.wildwood.WildWoodTree;
import divinerpg.enums.EnumBlockType;
import divinerpg.enums.ParticleType;
import divinerpg.enums.StatueType;
import divinerpg.objects.blocks.*;
import divinerpg.objects.blocks.arcana.*;
import divinerpg.objects.blocks.iceika.*;
import divinerpg.objects.blocks.twilight.*;
import divinerpg.objects.blocks.vanilla.*;
import divinerpg.objects.blocks.vethea.*;
import divinerpg.objects.entities.entity.twilight.EntitySunstorm;
import divinerpg.objects.entities.entity.twilight.EntityTermasect;
import divinerpg.world.DivineTree;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
@ObjectHolder("divinerpg")
public class ModBlocks {
    private static int WOOD_GOLD = 0, STONE = 1, IRON = 2, DIAMOND = 3, EDEN = 6, WILDWOOD = 7, APALACHIA = 8, SKYTHERN = 9, MORTUM = 10;
    private static List<Block> blockList = new ArrayList<Block>();
    private static List<Item> blockItemList = new ArrayList<>();
    // Vanilla dimensions

    // Ores
    @ObjectHolder("arlemite_ore")
    public static final Block arlemiteOre = null;
    @ObjectHolder("realmite_ore")
    public static final Block realmiteOre = null;
    @ObjectHolder("rupee_ore")
    public static final Block rupeeOre = null;
    @ObjectHolder("bloodgem_ore")
    public static final Block bloodgemOre = null;
    @ObjectHolder("netherite_ore")
    public static final Block netheriteOre = null;

    // Compressed ore blocks
    @ObjectHolder("arlemite_block")
    public static final Block arlemiteBlock = null;
    @ObjectHolder("realmite_block")
    public static final Block realmiteBlock = null;
    @ObjectHolder("rupee_block")
    public static final Block rupeeBlock = null;
    @ObjectHolder("bloodgem_block")
    public static final Block bloodgemBlock = null;
    @ObjectHolder("netherite_block")
    public static final Block netheriteBlock = null;

    // Mob pumpkins
    @ObjectHolder("blaze_pumpkin")
    public static final Block blazePumpkin = null;
    @ObjectHolder("creeper_pumpkin")
    public static final Block creeperPumpkin = null;
    @ObjectHolder("cyclops_pumpkin")
    public static final Block cyclopsPumpkin = null;
    @ObjectHolder("ender_pumpkin")
    public static final Block enderPumpkin = null;
    @ObjectHolder("ender_watcher_pumpkin")
    public static final Block enderWatcherPumpkin = null;
    @ObjectHolder("frost_pumpkin")
    public static final Block frostPumpkin = null;
    @ObjectHolder("ghast_pumpkin")
    public static final Block ghastPumpkin = null;
    @ObjectHolder("glacon_pumpkin")
    public static final Block glaconPumpkin = null;
    @ObjectHolder("hellspider_pumpkin")
    public static final Block hellspiderPumpkin = null;
    @ObjectHolder("jungle_spider_pumpkin")
    public static final Block jungleSpiderPumpkin = null;
    @ObjectHolder("skeleton_pumpkin")
    public static final Block skeletonPumpkin = null;
    @ObjectHolder("spider_pumpkin")
    public static final Block spiderPumpkin = null;
    @ObjectHolder("zombie_pumpkin")
    public static final Block zombiePumpkin = null;

    // Torches
    @ObjectHolder("aqua_torch")
    public static final Block aquaTorch = null;
    @ObjectHolder("skeleton_torch")
    public static final Block skeletonTorch = null;

    // Decoration blocks

    // Steel
    @ObjectHolder("black_steel")
    public static final Block blackSteel = null;
    @ObjectHolder("blue_steel")
    public static final Block blueSteel = null;
    @ObjectHolder("bright_red_steel")
    public static final Block brightRedSteel = null;
    @ObjectHolder("green_steel")
    public static final Block greenSteel = null;
    @ObjectHolder("orange_steel")
    public static final Block orangeSteel = null;
    @ObjectHolder("purple_steel")
    public static final Block purpleSteel = null;
    @ObjectHolder("red_steel")
    public static final Block redSteel = null;
    @ObjectHolder("teal_steel")
    public static final Block tealSteel = null;
    @ObjectHolder("white_steel")
    public static final Block whiteSteel = null;
    @ObjectHolder("yellow_steel")
    public static final Block yellowSteel = null;

    // Vanes
    @ObjectHolder("blue_vane")
    public static final Block blueVane = null;
    @ObjectHolder("cyan_vane")
    public static final Block cyanVane = null;
    @ObjectHolder("purple_vane")
    public static final Block purpleVane = null;
    @ObjectHolder("red_vane")
    public static final Block redVane = null;
    @ObjectHolder("yellow_vane")
    public static final Block yellowVane = null;

    // Bricks
    @ObjectHolder("aquatonic_bricks")
    public static final Block aquatonicBricks = null;
    @ObjectHolder("arlemite_bricks")
    public static final Block arlemiteBricks = null;
    @ObjectHolder("darkstone_bricks")
    public static final Block darkstoneBricks = null;
    @ObjectHolder("diamond_bricks")
    public static final Block diamondBricks = null;
    @ObjectHolder("gold_bricks")
    public static final Block goldBricks = null;
    @ObjectHolder("green_bricks")
    public static final Block greenBricks = null;
    @ObjectHolder("iron_bricks")
    public static final Block ironBricks = null;
    @ObjectHolder("lapis_lazuli_bricks")
    public static final Block lapisLazuliBricks = null;
    @ObjectHolder("lava_bricks")
    public static final Block lavaBricks = null;
    @ObjectHolder("milk_stone_bricks")
    public static final Block milkStoneBricks = null;
    @ObjectHolder("netherite_bricks")
    public static final Block netheriteBricks = null;
    @ObjectHolder("pink_bricks")
    public static final Block pinkBricks = null;
    @ObjectHolder("purple_bricks")
    public static final Block purpleBricks = null;
    @ObjectHolder("realmite_bricks")
    public static final Block realmiteBricks = null;
    @ObjectHolder("redstone_bricks")
    public static final Block redstoneBricks = null;
    @ObjectHolder("eden_bricks")
    public static final Block edenBricks = null;
    @ObjectHolder("wildwood_bricks")
    public static final Block wildwoodBricks = null;
    @ObjectHolder("apalachia_bricks")
    public static final Block apalachiaBricks = null;

    // Minibricks
    @ObjectHolder("minibricks")
    public static final Block minibricks = null;
    @ObjectHolder("arlemite_minibricks")
    public static final Block arlemiteMinibricks = null;
    @ObjectHolder("bedrock_minibricks")
    public static final Block bedrockMinibricks = null;
    @ObjectHolder("bloodgem_minibricks")
    public static final Block bloodgemMinibricks = null;
    @ObjectHolder("netherite_minibricks")
    public static final Block netheriteMinibricks = null;
    @ObjectHolder("realmite_minibricks")
    public static final Block realmiteMinibricks = null;
    @ObjectHolder("rupee_minibricks")
    public static final Block rupeeMinibricks = null;

    // Lamps
    @ObjectHolder("aqua_lamp")
    public static final Block aquaLamp = null;
    @ObjectHolder("arlemite_lamp")
    public static final Block arlemiteLamp = null;
    @ObjectHolder("blaze_lamp")
    public static final Block blazeLamp = null;
    @ObjectHolder("bluefire_lamp")
    public static final Block bluefireLamp = null;
    @ObjectHolder("diamond_lamp")
    public static final Block diamondLamp = null;
    @ObjectHolder("divine_lamp")
    public static final Block divineLamp = null;
    @ObjectHolder("draken_lamp")
    public static final Block drakenLamp = null;
    @ObjectHolder("eden_lamp")
    public static final Block edenLamp = null;
    @ObjectHolder("ender_lamp")
    public static final Block enderLamp = null;
    @ObjectHolder("ender_stone_lamp")
    public static final Block enderStoneLamp = null;
    @ObjectHolder("gold_lamp")
    public static final Block goldLamp = null;
    @ObjectHolder("ice_lamp")
    public static final Block iceLamp = null;
    @ObjectHolder("jungle_lamp")
    public static final Block jungleLamp = null;
    @ObjectHolder("kraken_lamp")
    public static final Block krakenLamp = null;
    @ObjectHolder("lapis_lazuli_lamp")
    public static final Block lapisLazuliLamp = null;
    @ObjectHolder("lava_lamp")
    public static final Block lavaLamp = null;
    @ObjectHolder("milky_lamp")
    public static final Block milkyLamp = null;
    @ObjectHolder("molten_lamp")
    public static final Block moltenLamp = null;
    @ObjectHolder("netherite_lamp")
    public static final Block netheriteLamp = null;
    @ObjectHolder("realmite_lamp")
    public static final Block realmiteLamp = null;
    @ObjectHolder("redstone_ore_lamp")
    public static final Block redstoneOreLamp = null;
    @ObjectHolder("rupee_lamp")
    public static final Block rupeeLamp = null;
    @ObjectHolder("terran_lamp")
    public static final Block terranLamp = null;

    // Powered fences
    @ObjectHolder("blue_fence")
    public static final Block blueFence = null;
    @ObjectHolder("blue_fence_on")
    public static final Block blueFenceOn = null;
    @ObjectHolder("green_fence")
    public static final Block greenFence = null;
    @ObjectHolder("green_fence_on")
    public static final Block greenFenceOn = null;
    @ObjectHolder("red_fence")
    public static final Block redFence = null;
    @ObjectHolder("red_fence_on")
    public static final Block redFenceOn = null;

    // Miscellaneous decorative blocks
    @ObjectHolder("asphalt")
    public static final Block asphalt = null;
    @ObjectHolder("blue_stone")
    public static final Block blueStone = null;
    @ObjectHolder("checker")
    public static final Block checker = null;
    @ObjectHolder("crate")
    public static final Block crate = null;
    @ObjectHolder("darkstone")
    public static final Block darkstone = null;
    @ObjectHolder("fancy_wool")
    public static final Block fancyWool = null;
    @ObjectHolder("milk_stone")
    public static final Block milkStone = null;
    @ObjectHolder("plank_design")
    public static final Block plankDesign = null;
    @ObjectHolder("rainbow_wool")
    public static final Block rainbowWool = null;

    // Spike blocks
    @ObjectHolder("spike_block")
    public static final Block spikeBlock = null;
    @ObjectHolder("hot_spike_block")
    public static final Block hotSpikeBlock = null;

    // Utility blocks
    @ObjectHolder("altar_of_corruption")
    public static final Block altarOfCorruption = null;
    @ObjectHolder("bone_chest")
    public static final Block boneChest = null;

    // Divine blocks
    @ObjectHolder("divine_sapling")
    public static final Block divineSapling = null;
    @ObjectHolder("divine_log")
    public static final Block divineLog = null;
    @ObjectHolder("divine_leaves")
    public static final Block divineLeaves = null;
    @ObjectHolder("divine_planks")
    public static final Block divinePlanks = null;
    @ObjectHolder("divine_stairs")
    public static final Block divineStairs = null;
    @ObjectHolder("divine_moss_stone")
    public static final Block divineMossStone = null;
    @ObjectHolder("divine_rock")
    public static final Block divineRock = null;

    // Miscellaneous utility
    @ObjectHolder("slime_light")
    public static final Block slimeLight = null;
    @ObjectHolder("dark_bridge")
    public static final Block darkBridge = null;

    // Crops
    @ObjectHolder("tomato_plant")
    public static final Block tomatoPlant = null;
    @ObjectHolder("white_mushroom_plant")
    public static final Block whiteMushroomPlant = null;

    // Boss statues
    @ObjectHolder("ancient_entity_statue")
    public static final Block ancientEntityStatue = null;
    @ObjectHolder("ayeraco_statue_blue")
    public static final Block ayeracoBlueStatue = null;
    @ObjectHolder("ayeraco_statue_red")
    public static final Block ayeracoRedStatue = null;
    @ObjectHolder("ayeraco_statue_green")
    public static final Block ayeracoGreenStatue = null;
    @ObjectHolder("ayeraco_statue_yellow")
    public static final Block ayeracoYellowStatue = null;
    @ObjectHolder("ayeraco_statue_purple")
    public static final Block ayeracoPurpleStatue = null;
    @ObjectHolder("densos_statue")
    public static final Block densosStatue = null;
    @ObjectHolder("dramix_statue")
    public static final Block dramixStatue = null;
    @ObjectHolder("eternal_archer_statue")
    public static final Block eternalArcherStatue = null;
    @ObjectHolder("karot_statue")
    public static final Block karotStatue = null;
    @ObjectHolder("king_of_scorchers_statue")
    public static final Block kingOfScorchersStatue = null;
    @ObjectHolder("parasecta_statue")
    public static final Block parasectaStatue = null;
    @ObjectHolder("reyvor_statue")
    public static final Block reyvorStatue = null;
    @ObjectHolder("soul_fiend_statue")
    public static final Block soulFiendStatue = null;
    @ObjectHolder("the_watcher_statue")
    public static final Block theWatcherStatue = null;
    @ObjectHolder("twilight_demon_statue")
    public static final Block twilightDemonStatue = null;
    @ObjectHolder("vamacheron_statue")
    public static final Block vamacheronStatue = null;
    @ObjectHolder("termasect_statue")
    public static final Block termasect_statue = null;
    @ObjectHolder("sunstorm_statue")
    public static final Block sunstorm_statue = null;

    // Liquid
    @ObjectHolder("tar")
    public static final Block tar = null;

    // Ayeraco technical blocks
    @ObjectHolder("ayeraco_beam_blue")
    public static final Block ayeracoBeamBlue = null;
    @ObjectHolder("ayeraco_beam_green")
    public static final Block ayeracoBeamGreen = null;
    @ObjectHolder("ayeraco_beam_purple")
    public static final Block ayeracoBeamPurple = null;
    @ObjectHolder("ayeraco_beam_red")
    public static final Block ayeracoBeamRed = null;
    @ObjectHolder("ayeraco_beam_yellow")
    public static final Block ayeracoBeamYellow = null;
    @ObjectHolder("ayeraco_spawn")
    public static final Block ayeracoSpawn = null;

    // Iceika

    // Terrain
    @ObjectHolder("frozen_dirt")
    public static final BlockModDirt frozenDirt = null;
    @ObjectHolder("frozen_grass")
    public static final BlockModGrass frozenGrass = null;
    @ObjectHolder("frozen_stone")
    public static final Block frozenStone = null;
    @ObjectHolder("frozen_log")
    public static final Block frozenLog = null;
    @ObjectHolder("brittle_leaves")
    public static final Block brittleLeaves = null;
    @ObjectHolder("frozen_planks")
    public static final Block frozenPlanks = null;
    @ObjectHolder("frozen_stairs")
    public static final Block frozenStairs = null;
    @ObjectHolder("frozen_sapling")
    public static final Block frozenSapling = null;

    // Structure blocks
    @ObjectHolder("coalstone")
    public static final Block coalstone = null;
    @ObjectHolder("coalstone_furnace")
    public static final Block coalstoneFurnace = null;
    @ObjectHolder("coalstone_furnace_on")
    public static final Block coalstoneFurnaceOn = null;
    @ObjectHolder("coalstone_stairs")
    public static final Block coalstoneStairs = null;
    @ObjectHolder("frost_archer_spawner")
    public static final Block frostArcherSpawner = null;
    @ObjectHolder("frosted_chest")
    public static final Block frostedChest = null;
    @ObjectHolder("frosted_glass")
    public static final Block frostedGlass = null;
    @ObjectHolder("icy_bricks")
    public static final Block icyBricks = null;
    @ObjectHolder("icy_stone")
    public static final Block icyStone = null;
    @ObjectHolder("rollum_spawner")
    public static final Block rollumSpawner = null;
    @ObjectHolder("snow_bricks")
    public static final Block snowBricks = null;
    @ObjectHolder("steel_door")
    public static final Block steelDoor = null;
    @ObjectHolder("workshop_bookcase")
    public static final Block workshopBookcase = null;
    @ObjectHolder("workshop_lamp")
    public static final Block workshopLamp = null;

    // Candy canes
    @ObjectHolder("blue_candy_cane")
    public static final Block blueCandyCane = null;
    @ObjectHolder("green_candy_cane")
    public static final Block greenCandyCane = null;
    @ObjectHolder("pink_candy_cane")
    public static final Block pinkCandyCane = null;
    @ObjectHolder("red_candy_cane")
    public static final Block redCandyCane = null;
    @ObjectHolder("yellow_candy_cane")
    public static final Block yellowCandyCane = null;

    // Christmas lights
    @ObjectHolder("blue_christmas_lights")
    public static final Block blueChristmasLights = null;
    @ObjectHolder("green_christmas_lights")
    public static final Block greenChristmasLights = null;
    @ObjectHolder("purple_christmas_lights")
    public static final Block purpleChristmasLights = null;
    @ObjectHolder("red_christmas_lights")
    public static final Block redChristmasLights = null;
    @ObjectHolder("yellow_christmas_lights")
    public static final Block yellowChristmasLights = null;

    // Chest
    @ObjectHolder("present_box")
    public static final Block presentBox = null;

    // Crops
    @ObjectHolder("winterberry_bush")
    public static final Block winterberryBush = null;
    @ObjectHolder("ripe_winterberry_bush")
    public static final Block ripeWinterberryBush = null;

    // Other
    @ObjectHolder("iceika_fire")
    public static final Block iceikaFire = null;
    @ObjectHolder("iceika_portal")
    public static final BlockModPortal iceikaPortal = null;

    // Twilight dimensions

    // Dirt
    @ObjectHolder("eden_dirt")
    public static final BlockModDirt edenDirt = null;
    @ObjectHolder("wildwood_dirt")
    public static final BlockModDirt wildwoodDirt = null;
    @ObjectHolder("apalachia_dirt")
    public static final BlockModDirt apalachiaDirt = null;
    @ObjectHolder("skythern_dirt")
    public static final BlockModDirt skythernDirt = null;
    @ObjectHolder("mortum_dirt")
    public static final BlockModDirt mortumDirt = null;

    // Grass
    @ObjectHolder("eden_grass")
    public static final BlockModGrass edenGrass = null;
    @ObjectHolder("wildwood_grass")
    public static final BlockModGrass wildwoodGrass = null;
    @ObjectHolder("apalachia_grass")
    public static final BlockModGrass apalachiaGrass = null;
    @ObjectHolder("skythern_grass")
    public static final BlockModGrass skythernGrass = null;
    @ObjectHolder("mortum_grass")
    public static final BlockModGrass mortumGrass = null;

    // Stone
    @ObjectHolder("twilight_stone")
    public static final Block twilightStone = null;

    // Ore
    @ObjectHolder("eden_ore")
    public static final Block edenOre = null;
    @ObjectHolder("wildwood_ore")
    public static final Block wildwoodOre = null;
    @ObjectHolder("apalachia_ore")
    public static final Block apalachiaOre = null;
    @ObjectHolder("skythern_ore")
    public static final Block skythernOre = null;
    @ObjectHolder("mortum_ore")
    public static final Block mortumOre = null;

    // Sapling
    @ObjectHolder("eden_sapling")
    public static final Block edenSapling = null;
    @ObjectHolder("wildwood_sapling")
    public static final Block wildwoodSapling = null;
    @ObjectHolder("apalachia_sapling")
    public static final Block apalachiaSapling = null;
    @ObjectHolder("skythern_sapling")
    public static final Block skythernSapling = null;
    @ObjectHolder("mortum_sapling")
    public static final Block mortumSapling = null;

    // Logs
    @ObjectHolder("eden_log")
    public static final Block edenLog = null;
    @ObjectHolder("wildwood_log")
    public static final Block wildwoodLog = null;
    @ObjectHolder("apalachia_log")
    public static final Block apalachiaLog = null;
    @ObjectHolder("skythern_log")
    public static final Block skythernLog = null;
    @ObjectHolder("mortum_log")
    public static final Block mortumLog = null;

    // Leaves
    @ObjectHolder("eden_leaves")
    public static final Block edenLeaves = null;
    @ObjectHolder("wildwood_leaves")
    public static final Block wildwoodLeaves = null;
    @ObjectHolder("apalachia_leaves")
    public static final Block apalachiaLeaves = null;
    @ObjectHolder("skythern_leaves")
    public static final Block skythernLeaves = null;
    @ObjectHolder("mortum_leaves")
    public static final Block mortumLeaves = null;

    // Planks
    @ObjectHolder("eden_planks")
    public static final Block edenPlanks = null;
    @ObjectHolder("wildwood_planks")
    public static final Block wildwoodPlanks = null;
    @ObjectHolder("apalachia_planks")
    public static final Block apalachiaPlanks = null;
    @ObjectHolder("skythern_planks")
    public static final Block skythernPlanks = null;
    @ObjectHolder("mortum_planks")
    public static final Block mortumPlanks = null;

    // Stairs
    @ObjectHolder("eden_stairs")
    public static final Block edenStairs = null;
    @ObjectHolder("wildwood_stairs")
    public static final Block wildwoodStairs = null;
    @ObjectHolder("apalachia_stairs")
    public static final Block apalachiaStairs = null;
    @ObjectHolder("skythern_stairs")
    public static final Block skythernStairs = null;
    @ObjectHolder("mortum_stairs")
    public static final Block mortumStairs = null;

    // Slab
    @ObjectHolder("eden_slab")
    public static final Block edenSlab = null;
    @ObjectHolder("wildwood_slab")
    public static final Block wildwoodSlab = null;
    @ObjectHolder("apalachia_slab")
    public static final Block apalachiaSlab = null;
    @ObjectHolder("skythern_slab")
    public static final Block skythernSlab = null;
    @ObjectHolder("mortum_slab")
    public static final Block mortumSlab = null;
    @ObjectHolder("divine_slab")
    public static final Block divineSlab = null;
    @ObjectHolder("frozen_slab")
    public static final Block frozenSlab = null;
    @ObjectHolder("eucalyptus_slab")
    public static final Block eucalyptusSlab = null;

    //Double Slab
    @ObjectHolder("eden_double_slab")
    public static final Block edenDoubleSlab = null;
    @ObjectHolder("wildwood_double_slab")
    public static final Block wildwoodDoubleSlab = null;
    @ObjectHolder("apalachia_double_slab")
    public static final Block apalachiaDoubleSlab = null;
    @ObjectHolder("skythern_double_slab")
    public static final Block skythernDoubleSlab = null;
    @ObjectHolder("mortum_double_slab")
    public static final Block mortumDoubleSlab = null;
    @ObjectHolder("divine_double_slab")
    public static final Block divineDoubleSlab = null;
    @ObjectHolder("frozen_double_slab")
    public static final Block frozenDoubleSlab = null;
    @ObjectHolder("eucalyptus_double_slab")
    public static final Block eucalyptusDoubleSlab = null;

    // Compressed blocks
    @ObjectHolder("eden_block")
    public static final Block edenBlock = null;
    @ObjectHolder("wildwood_block")
    public static final Block wildwoodBlock = null;
    @ObjectHolder("apalachia_block")
    public static final Block apalachiaBlock = null;
    @ObjectHolder("skythern_block")
    public static final Block skythernBlock = null;
    @ObjectHolder("mortum_block")
    public static final Block mortumBlock = null;

    // Ground foliage
    @ObjectHolder("sunbloom")
    public static final Block sunbloom = null;
    @ObjectHolder("sun_blossom")
    public static final Block sunBlossom = null;
    @ObjectHolder("moonlight_fern")
    public static final Block moonlightFern = null;
    @ObjectHolder("moon_bud")
    public static final Block moonBud = null;
    @ObjectHolder("dusk_bloom")
    public static final Block duskBloom = null;
    @ObjectHolder("dust_lily")
    public static final Block dustLily = null;
    @ObjectHolder("eye_plant")
    public static final Block eyePlant = null;

    @ObjectHolder("eden_brush")
    public static final Block edenBrush = null;
    @ObjectHolder("apalachia_tallgrass")
    public static final Block apalachiaTallgrass = null;
    @ObjectHolder("skythern_brush")
    public static final Block skythernBrush = null;
    @ObjectHolder("mortum_brush")
    public static final Block mortumBrush = null;

    @ObjectHolder("wildwood_tallgrass")
    public static final Block wildwoodTallgrass = null;
    @ObjectHolder("dusk_flower")
    public static final Block duskFlower = null;

    @ObjectHolder("dust_brambles")
    public static final Block dustBrambles = null;
    @ObjectHolder("demon_brambles")
    public static final Block demonBrambles = null;

    // Crops
    @ObjectHolder("moonbulb_plant")
    public static final Block moonbulbPlant = null;
    @ObjectHolder("pink_glowbone_plant")
    public static final Block pinkGlowbonePlant = null;
    @ObjectHolder("purple_glowbone_plant")
    public static final Block purpleGlowbonePlant = null;
    @ObjectHolder("sky_plant")
    public static final Block skyPlant = null;

    // Vine
    @ObjectHolder("wildwood_vine")
    public static final Block wildwoodVine = null;

    // Portal
    @ObjectHolder("eden_portal")
    public static final BlockModPortal edenPortal = null;
    @ObjectHolder("wildwood_portal")
    public static final BlockModPortal wildwoodPortal = null;
    @ObjectHolder("apalachia_portal")
    public static final BlockModPortal apalachiaPortal = null;
    @ObjectHolder("skythern_portal")
    public static final BlockModPortal skythernPortal = null;
    @ObjectHolder("mortum_portal")
    public static final BlockModPortal mortumPortal = null;

    // Other
    @ObjectHolder("blue_fire")
    public static final Block blueFire = null;
    @ObjectHolder("eden_torch")
    public static final Block edenTorch = null;
    @ObjectHolder("eden_chest")
    public static final Block edenChest = null;
    @ObjectHolder("truffle")
    public static final Block truffle = null;

    // Arcana

    // Dirt
    @ObjectHolder("arcanite_dirt")
    public static final BlockModDirt arcaniteDirt = null;

    // Grass
    @ObjectHolder("arcanite_grass")
    public static final BlockModGrass arcaniteGrass = null;

    // Ore
    @ObjectHolder("arcanium_ore")
    public static final Block arcaniumOre = null;

    // Structure blocks
    // Normal
    @ObjectHolder("ancient_brick")
    public static final Block ancientBrick = null;
    @ObjectHolder("ancient_stone")
    public static final Block ancientStone = null;
    @ObjectHolder("ancient_tile")
    public static final Block ancientTile = null;
    @ObjectHolder("arcanite_tubes")
    public static final Block arcaniteTubes = null;
    @ObjectHolder("arcanium_metal")
    public static final Block arcaniumMetal = null;
    @ObjectHolder("arcanium_power")
    public static final Block arcaniumPower = null;
    @ObjectHolder("dark_degraded_brick")
    public static final Block darkDegradedBrick = null;
    @ObjectHolder("degraded_brick")
    public static final Block degradedBrick = null;
    @ObjectHolder("dungeon_lamp")
    public static final Block dungeonLamp = null;
    @ObjectHolder("heat_trap")
    public static final Block heatTrap = null;
    @ObjectHolder("heat_trap_on")
    public static final Block heatTrapOn = null;
    @ObjectHolder("light_degraded_brick")
    public static final Block lightDegradedBrick = null;
    @ObjectHolder("soul_sludge")
    public static final Block soulSludge = null;
    @ObjectHolder("soul_stone")
    public static final Block soulStone = null;

    // Door
    @ObjectHolder("ancient_brick_door")
    public static final Block ancientBrickDoor = null;
    @ObjectHolder("degraded_brick_door")
    public static final Block degradedBrickDoor = null;
    @ObjectHolder("soul_sludge_door")
    public static final Block soulSludgeDoor = null;
    @ObjectHolder("soul_stone_door")
    public static final Block soulStoneDoor = null;

    // Spawner
    @ObjectHolder("death_hound_spawner")
    public static final Block deathHoundSpawner = null;
    @ObjectHolder("deathcryx_spawner")
    public static final Block deathcryxSpawner = null;
    @ObjectHolder("dungeon_prisoner_spawner")
    public static final Block dungeonPrisonerSpawner = null;
    @ObjectHolder("living_statue_spawner")
    public static final Block livingStatueSpawner = null;
    @ObjectHolder("razorback_spawner")
    public static final Block razorbackSpawner = null;
    @ObjectHolder("roamer_spawner")
    public static final Block roamerSpawner = null;

    // Utility
    @ObjectHolder("arcanium_extractor")
    public static final Block arcaniumExtractor = null;

    // Boss altars
    @ObjectHolder("dramix_altar")
    public static final Block dramixAltar = null;
    @ObjectHolder("parasecta_altar")
    public static final Block parasectaAltar = null;

    // Stained glass
    @ObjectHolder("stained_glass")
    public static final Block stainedGlass = null;
    @ObjectHolder("stained_glass2")
    public static final Block stainedGlass2 = null;
    @ObjectHolder("stained_glass3")
    public static final Block stainedGlass3 = null;
    @ObjectHolder("stained_glass4")
    public static final Block stainedGlass4 = null;
    @ObjectHolder("stained_glass5")
    public static final Block stainedGlass5 = null;
    @ObjectHolder("stained_glass6")
    public static final Block stainedGlass6 = null;
    @ObjectHolder("stained_glass7")
    public static final Block stainedGlass7 = null;
    @ObjectHolder("stained_glass8")
    public static final Block stainedGlass8 = null;

    // Portal blocks
    @ObjectHolder("arcana_portal")
    public static final Block arcanaPortal = null;
    @ObjectHolder("arcana_portal_frame")
    public static final Block arcanaPortalFrame = null;
    @ObjectHolder("arcana_hard_portal_frame")
    public static final Block arcanaHardPortalFrame = null;

    // Eucalyptus
    @ObjectHolder("eucalyptus_log")
    public static final Block eucalyptusLog = null;
    @ObjectHolder("eucalyptus_planks")
    public static final Block eucalyptusPlanks = null;
    @ObjectHolder("eucalyptus_stairs")
    public static final Block eucalyptusStairs = null;

    // Crops
    @ObjectHolder("aquamarine_plant")
    public static final Block aquamarinePlant = null;
    @ObjectHolder("eucalyptus_plant")
    public static final Block eucalyptusPlant = null;
    @ObjectHolder("firestock_plant")
    public static final Block firestockPlant = null;
    @ObjectHolder("hitchak_plant")
    public static final Block hitchakPlant = null;
    @ObjectHolder("lamona_plant")
    public static final Block lamonaPlant = null;
    @ObjectHolder("marsine_plant")
    public static final Block marsinePlant = null;
    @ObjectHolder("pinfly_plant")
    public static final Block pinflyPlant = null;
    @ObjectHolder("veilo_plant")
    public static final Block veiloPlant = null;

    // Furnace
    @ObjectHolder("greenlight_furnace")
    public static final Block greenlightFurnace = null;
    @ObjectHolder("greenlight_furnace_on")
    public static final Block greenlightFurnaceOn = null;
    @ObjectHolder("oceanfire_furnace")
    public static final Block oceanfireFurnace = null;
    @ObjectHolder("oceanfire_furnace_on")
    public static final Block oceanfireFurnaceOn = null;
    @ObjectHolder("molten_furnace")
    public static final Block moltenFurnace = null;
    @ObjectHolder("molten_furnace_on")
    public static final Block moltenFurnaceOn = null;
    @ObjectHolder("whitefire_furnace")
    public static final Block whitefireFurnace = null;
    @ObjectHolder("whitefire_furnace_on")
    public static final Block whitefireFurnaceOn = null;
    @ObjectHolder("moonlight_furnace")
    public static final Block moonlightFurnace = null;
    @ObjectHolder("moonlight_furnace_on")
    public static final Block moonlightFurnaceOn = null;
    @ObjectHolder("demon_furnace")
    public static final Block demonFurnace = null;
    @ObjectHolder("demon_furnace_on")
    public static final Block demonFurnaceOn = null;

    // Miscellaneous utility
    @ObjectHolder("acceleron")
    public static final Block acceleron = null;
    @ObjectHolder("arcanium_torch")
    public static final Block arcaniumTorch = null;
    @ObjectHolder("elevantium")
    public static final Block elevantium = null;
    @ObjectHolder("star_bridge")
    public static final Block starBridge = null;

    //We are avoiding rails for now
    //public static final Block arcaniteRails = new BlockRedstonelessRails("arcanite_rails");

    // Vethea
    // Terrain
    @ObjectHolder("dream_dirt")
    public static final BlockModDirt dreamDirt = null;
    @ObjectHolder("dream_grass")
    public static final BlockModGrass dreamGrass = null;
    @ObjectHolder("dream_stone")
    public static final Block dreamStone = null;

    // Logs
    @ObjectHolder("dreamwood_log")
    public static final Block dreamwoodLog = null;
    @ObjectHolder("firewood_log")
    public static final Block firewoodLog = null;
    @ObjectHolder("hyrewood_log")
    public static final Block hyrewoodLog = null;
    @ObjectHolder("mintwood_log")
    public static final Block mintwoodLog = null;

    // Leaves
    @ObjectHolder("dreamwood_leaves")
    public static final Block dreamwoodLeaves = null;
    @ObjectHolder("firewood_leaves")
    public static final Block firewoodLeaves = null;
    @ObjectHolder("hyrewood_leaves")
    public static final Block hyrewoodLeaves = null;
    @ObjectHolder("mintwood_leaves")
    public static final Block mintwoodLeaves = null;

    // Ground foliage
    @ObjectHolder("bulbatobe")
    public static final Block bulbatobe = null;
    @ObjectHolder("cracklespike")
    public static final Block cracklespike = null;
    @ObjectHolder("dreamglow")
    public static final Block dreamglow = null;
    @ObjectHolder("fernite")
    public static final Block fernite = null;
    @ObjectHolder("green_dulah")
    public static final Block greenDulah = null;
    @ObjectHolder("green_gemtop")
    public static final Block greenGemtop = null;
    @ObjectHolder("purple_gemtop")
    public static final Block purpleGemtop = null;
    @ObjectHolder("shimmer")
    public static final Block shimmer = null;
    @ObjectHolder("shine_grass")
    public static final Block shineGrass = null;
    @ObjectHolder("yellow_dulah")
    public static final Block yellowDulah = null;

    // Vines
    @ObjectHolder("weedwood_vine")
    public static final Block weedwoodVine = null;
    @ObjectHolder("blossomed_weedwood_vine")
    public static final Block blossomedWeedwoodVine = null;

    // Building blocks
    @ObjectHolder("dark_dream_bricks")
    public static final Block darkDreamBricks = null;
    @ObjectHolder("light_dream_bricks")
    public static final Block lightDreamBricks = null;
    @ObjectHolder("red_dream_bricks")
    public static final Block redDreamBricks = null;
    @ObjectHolder("smooth_glass")
    public static final Block smoothGlass = null;

    // Door
    @ObjectHolder("barred_door")
    public static final Block barredDoor = null;

    // Lighting
    @ObjectHolder("fire_crystal")
    public static final Block fireCrystal = null;
    @ObjectHolder("firelight")
    public static final Block firelight = null;

    // Structure
    // General
    @ObjectHolder("dream_lamp")
    public static final Block dreamLamp = null;
    @ObjectHolder("everstone")
    public static final Block everstone = null;
    @ObjectHolder("dark_everstone")
    public static final Block darkEverstone = null;
    @ObjectHolder("white_everstone")
    public static final Block whiteEverstone = null;

    // Crypt
    @ObjectHolder("black_hungerstone")
    public static final Block blackHungerstone = null;
    @ObjectHolder("green_hungerstone")
    public static final Block greenHungerstone = null;
    @ObjectHolder("crypt_floor")
    public static final Block cryptFloor = null;
    @ObjectHolder("crypt_wall")
    public static final Block cryptWall = null;
    @ObjectHolder("metal_caging")
    public static final Block metalCaging = null;

    // Village
    @ObjectHolder("village_lamp")
    public static final Block villageLamp = null;

    // Hive
    @ObjectHolder("cell_lamp")
    public static final Block cellLamp = null;
    @ObjectHolder("hive_wall")
    public static final Block hiveWall = null;

    // Karos Madhouse
    @ObjectHolder("black_karos_bricks")
    public static final Block blackKarosBricks = null;
    @ObjectHolder("blue_karos_bricks")
    public static final Block blueKarosBricks = null;
    @ObjectHolder("heliotic_beam")
    public static final Block helioticBeam = null;
    @ObjectHolder("karos_dispenser")
    public static final Block karosDispenser = null;
    @ObjectHolder("karos_heat_tile_green")
    public static final Block karosHeatTileGreen = null;
    @ObjectHolder("karos_heat_tile_red")
    public static final Block karosHeatTileRed = null;

    // Lunic Garden
    @ObjectHolder("luna_bricks")
    public static final Block lunaBricks = null;
    @ObjectHolder("luna_stone")
    public static final Block lunaStone = null;

    // Raglok Chamber
    @ObjectHolder("chamber_wall")
    public static final Block chamberWall = null;
    @ObjectHolder("shifted_chamber_wall")
    public static final Block shiftedChamberWall = null;
    @ObjectHolder("stacked_chamber_wall")
    public static final Block stackedChamberWall = null;

    // Wreck Hall
    @ObjectHolder("hall_wall")
    public static final Block hallWall = null;

    // Utility
    @ObjectHolder("infusion_table")
    public static final Block infusionTable = null;

    // Hive egg
    @ObjectHolder("hive_egg")
    public static final Block hiveEgg = null;

    // Boss altars
    @ObjectHolder("karos_altar")
    public static final Block karosAltar = null;
    @ObjectHolder("lunic_altar")
    public static final Block lunicAltar = null;
    @ObjectHolder("quadrotic_altar")
    public static final Block quadroticAltar = null;
    @ObjectHolder("raglok_altar")
    public static final Block raglokAltar = null;
    @ObjectHolder("wreck_altar")
    public static final Block wreckAltar = null;

    // Mob spawners
    @ObjectHolder("biphron_spawner")
    public static final Block biphronSpawner = null;
    @ObjectHolder("dreamwrecker_spawner")
    public static final Block dreamwreckerSpawner = null;
    @ObjectHolder("gorgosion_spawner")
    public static final Block gorgosionSpawner = null;
    @ObjectHolder("twins_spawner")
    public static final Block twinsSpawner = null;
    @ObjectHolder("vermenous_spawner")
    public static final Block vermenousSpawner = null;

    // Acid
    @ObjectHolder("acid_block")
    public static final Block acidBlock = null;
    @ObjectHolder("bacterial_acid")
    public static final Block bacterialAcid = null;
    @ObjectHolder("lunic_acid")
    public static final Block lunicAcid = null;

    // Portal blocks
    @ObjectHolder("nightmare_bed_block")
    public static final Block nightmareBed = null;
    @ObjectHolder("vethea_portal")
    public static final BlockModPortal vetheaPortal = null;

    @ObjectHolder("king_compression")
    public static final Block king_compression = null;

    @ObjectHolder("king_compression_still")
    public static final Block king_compression_still = null;

    //newSpawners
    @ObjectHolder("sunstorm_spawner")
    public static final Block sunstormSpawner = null;
    @ObjectHolder("termasect_spawner")
    public static final Block termasectSpawner = null;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        DivineRPG.logger.info("Registering DivineRPG blocks");

        IForgeRegistry<Block> registry = event.getRegistry();

        // Vanilla dimensions

        // Ores
        register(registry, new BlockModOre("arlemite_ore", 3.0F, 2000F, DIAMOND, () -> null));
        register(registry, new BlockModOre("realmite_ore", 3.0F, 2000F, IRON, () -> null));
        register(registry, new BlockModOre("rupee_ore", 3.0F, 2000F, DIAMOND, () -> null));
        register(registry, new BlockModOre("bloodgem_ore", 3.0F, 2000F, DIAMOND, () -> ModItems.bloodgem));
        register(registry, new BlockNetheriteOre("netherite_ore", 3.0F, 2000F, DIAMOND));

        // Compressed ore blocks
        register(registry, new BlockBeaconBase(EnumBlockType.ROCK, "arlemite_block", 5.0F, DIAMOND));
        register(registry, new BlockBeaconBase(EnumBlockType.ROCK, "realmite_block", 5.0F, IRON));
        register(registry, new BlockBeaconBase(EnumBlockType.ROCK, "rupee_block", 5.0F, DIAMOND));
        register(registry, new BlockBeaconBase(EnumBlockType.ROCK, "bloodgem_block", 5.0F, DIAMOND));
        register(registry, new BlockBeaconBase(EnumBlockType.ROCK, "netherite_block", 5.0F, DIAMOND));

        // Mob pumpkins
        register(registry, new BlockMobPumpkin("blaze_pumpkin", SoundEvents.ENTITY_BLAZE_AMBIENT));
        register(registry, new BlockMobPumpkin("creeper_pumpkin", SoundEvents.ENTITY_CREEPER_PRIMED));
        register(registry, new BlockMobPumpkin("cyclops_pumpkin", ModSounds.CYCLOPS));
        register(registry, new BlockMobPumpkin("ender_pumpkin", SoundEvents.ENTITY_ENDERMEN_SCREAM));
        register(registry, new BlockMobPumpkin("ender_watcher_pumpkin", SoundEvents.ENTITY_ENDERMEN_AMBIENT));
        register(registry, new BlockMobPumpkin("frost_pumpkin", ModSounds.FROST));
        register(registry, new BlockMobPumpkin("ghast_pumpkin", SoundEvents.ENTITY_GHAST_SCREAM));
        register(registry, new BlockMobPumpkin("glacon_pumpkin", ModSounds.GLACIDE));
        register(registry, new BlockMobPumpkin("hellspider_pumpkin", ModSounds.HELL_SPIDER));
        register(registry, new BlockMobPumpkin("jungle_spider_pumpkin", ModSounds.HELL_SPIDER));
        register(registry, new BlockMobPumpkin("skeleton_pumpkin", SoundEvents.ENTITY_SKELETON_AMBIENT));
        register(registry, new BlockMobPumpkin("spider_pumpkin", SoundEvents.ENTITY_SPIDER_AMBIENT));
        register(registry, new BlockMobPumpkin("zombie_pumpkin", SoundEvents.ENTITY_ZOMBIE_AMBIENT));

        // Torches
        register(registry, new BlockModTorch("aqua_torch", ParticleType.BLUE_FLAME));
        register(registry, new BlockModTorch("skeleton_torch", ParticleType.BLACK_FLAME));

        // Decorative blocks

        // Steel
        register(registry, new BlockMod(EnumBlockType.ROCK, "black_steel", 10.0F, DIAMOND).setResistance(60.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "blue_steel", 10.0F, DIAMOND).setResistance(60.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "bright_red_steel", 10.0F, DIAMOND).setResistance(60.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "green_steel", 10.0F, DIAMOND).setResistance(60.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "orange_steel", 10.0F, DIAMOND).setResistance(60.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "purple_steel", 10.0F, DIAMOND).setResistance(60.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "red_steel", 10.0F, DIAMOND).setResistance(60.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "white_steel", 10.0F, DIAMOND).setResistance(60.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "yellow_steel", 10.0F, DIAMOND).setResistance(60.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "teal_steel", 10.0F, DIAMOND).setResistance(60.0F));

        // Vanes
        register(registry, new BlockMod(EnumBlockType.ROCK, "blue_vane", 2.0F, IRON).setResistance(10F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "cyan_vane", 2.0F, IRON).setResistance(10F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "purple_vane", 2.0F, IRON).setResistance(10F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "red_vane", 2.0F, IRON).setResistance(10F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "yellow_vane", 2.0F, IRON).setResistance(10F));

        // Bricks
        register(registry, new BlockMod(EnumBlockType.ROCK, "aquatonic_bricks", 3.0F, IRON).setResistance(30.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "lava_bricks", 3.0F, IRON).setResistance(30.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "arlemite_bricks", 3.0F, IRON).setResistance(30.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "darkstone_bricks", 3.0F, IRON).setResistance(30.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "diamond_bricks", 3.0F, IRON).setResistance(30.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "gold_bricks", 3.0F, IRON).setResistance(30.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "green_bricks", 3.0F, IRON).setResistance(30.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "iron_bricks", 3.0F, IRON).setResistance(30.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "lapis_lazuli_bricks", 3.0F, IRON).setResistance(30.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "milk_stone_bricks", 3.0F, IRON).setResistance(30.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "netherite_bricks", 3.0F, IRON).setResistance(30.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "pink_bricks", 3.0F, IRON).setResistance(30.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "purple_bricks", 3.0F, IRON).setResistance(30.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "realmite_bricks", 3.0F, IRON).setResistance(30.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "redstone_bricks", 3.0F, IRON).setResistance(30.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "eden_bricks", 3.0F, IRON).setResistance(30.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "wildwood_bricks", 3.0F, IRON).setResistance(30.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "apalachia_bricks", 3.0F, IRON).setResistance(30.0F));

        // Minibricks
        register(registry, new BlockMod(EnumBlockType.ROCK, "minibricks", 3.0F, IRON).setResistance(30.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "arlemite_minibricks", 3.0F, IRON).setResistance(30.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "bedrock_minibricks", 3.0F, IRON).setResistance(30.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "netherite_minibricks", 3.0F, IRON).setResistance(30.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "realmite_minibricks", 3.0F, IRON).setResistance(30.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "bloodgem_minibricks", 3.0F, IRON).setResistance(30.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "rupee_minibricks", 3.0F, IRON).setResistance(30.0F));

        // Lamps
        register(registry, new BlockModLamp(EnumBlockType.GLASS, "aqua_lamp", 3.0F).setResistance(30.0F));
        register(registry, new BlockModLamp(EnumBlockType.GLASS, "arlemite_lamp", 3.0F).setResistance(30.0F));
        register(registry, new BlockModLamp(EnumBlockType.GLASS, "blaze_lamp", 3.0F).setResistance(30.0F));
        register(registry, new BlockModLamp(EnumBlockType.GLASS, "bluefire_lamp", 3.0F).setResistance(30.0F));
        register(registry, new BlockModLamp(EnumBlockType.GLASS, "diamond_lamp", 3.0F).setResistance(30.0F));
        register(registry, new BlockModLamp(EnumBlockType.GLASS, "divine_lamp", 3.0F).setResistance(30.0F));
        register(registry, new BlockModLamp(EnumBlockType.GLASS, "draken_lamp", 3.0F).setResistance(30.0F));
        register(registry, new BlockModLamp(EnumBlockType.GLASS, "eden_lamp", 3.0F).setResistance(30.0F));
        register(registry, new BlockModLamp(EnumBlockType.GLASS, "ender_lamp", 3.0F).setResistance(30.0F));
        register(registry, new BlockModLamp(EnumBlockType.GLASS, "ender_stone_lamp", 3.0F).setResistance(30.0F));
        register(registry, new BlockModLamp(EnumBlockType.GLASS, "gold_lamp", 3.0F).setResistance(30.0F));
        register(registry, new BlockModLamp(EnumBlockType.GLASS, "ice_lamp", 3.0F).setResistance(30.0F));
        register(registry, new BlockModLamp(EnumBlockType.GLASS, "jungle_lamp", 3.0F).setResistance(30.0F));
        register(registry, new BlockModLamp(EnumBlockType.GLASS, "kraken_lamp", 3.0F).setResistance(30.0F));
        register(registry, new BlockModLamp(EnumBlockType.GLASS, "lapis_lazuli_lamp", 3.0F).setResistance(30.0F));
        register(registry, new BlockModLamp(EnumBlockType.GLASS, "lava_lamp", 3.0F).setResistance(30.0F));
        register(registry, new BlockModLamp(EnumBlockType.GLASS, "milky_lamp", 3.0F).setResistance(30.0F));
        register(registry, new BlockModLamp(EnumBlockType.GLASS, "molten_lamp", 3.0F).setResistance(30.0F));
        register(registry, new BlockModLamp(EnumBlockType.GLASS, "netherite_lamp", 3.0F).setResistance(30.0F));
        register(registry, new BlockModLamp(EnumBlockType.GLASS, "realmite_lamp", 3.0F).setResistance(30.0F));
        register(registry, new BlockModLamp(EnumBlockType.GLASS, "redstone_ore_lamp", 3.0F).setResistance(30.0F));
        register(registry, new BlockModLamp(EnumBlockType.GLASS, "rupee_lamp", 3.0F).setResistance(30.0F));
        register(registry, new BlockModLamp(EnumBlockType.GLASS, "terran_lamp", 3.0F).setResistance(30.0F));

        // Powered fences
        register(registry, new BlockLightFence(MapColor.BLUE, "blue_fence", false, 0.5F));
        register(registry, new BlockLightFence(MapColor.BLUE, "blue_fence_on", true, 0.5F));
        register(registry, new BlockLightFence(MapColor.GREEN, "green_fence", false, 0.5F));
        register(registry, new BlockLightFence(MapColor.GREEN, "green_fence_on", true, 0.5F));
        register(registry, new BlockLightFence(MapColor.RED, "red_fence", false, 0.5F));
        register(registry, new BlockLightFence(MapColor.RED, "red_fence_on", true, 0.5F));

        // Miscellaneous decorative blocks
        register(registry, new BlockMod("asphalt", 2.0F));
        register(registry, new BlockMod(EnumBlockType.ROCK, "blue_stone", 1.5F, WOOD_GOLD).setResistance(10F).setLightLevel(1));
        register(registry, new BlockMod(EnumBlockType.WOOL, "checker", 0.8F, WOOD_GOLD));
        register(registry, new BlockMod(EnumBlockType.WOOD, "crate", 2.5F, WOOD_GOLD));
        register(registry, new BlockMod(EnumBlockType.ROCK, "darkstone", 50f, DIAMOND).setResistance(2000.0F).setLightLevel(1));
        register(registry, new BlockMod(EnumBlockType.WOOL, "fancy_wool", 0.8F, WOOD_GOLD));
        register(registry, new BlockMod(EnumBlockType.ROCK, "milk_stone", 1.5F, WOOD_GOLD).setResistance(10F));
        register(registry, new BlockMod(EnumBlockType.WOOD, "plank_design", 2.5F, WOOD_GOLD));
        register(registry, new BlockMod(EnumBlockType.WOOL, "rainbow_wool", 0.8F, WOOD_GOLD));

        // Spike blocks
        register(registry, new BlockSpike("spike_block"));
        register(registry, new BlockHotSpike("hot_spike_block"));

        // Utility blocks
        register(registry, new BlockAltarOfCorruption("altar_of_corruption"));
        register(registry, new BlockBoneChest("bone_chest"));

        // Divine blocks
        register(registry, new BlockModSapling("divine_sapling", () -> Blocks.GRASS, () -> Blocks.DIRT, new DivineTree(true)));
        register(registry, new BlockModLog("divine_log", MapColor.YELLOW));
        register(registry, new BlockModLeaves("divine_leaves", 0.3F, () -> divineSapling, MapColor.YELLOW));
        Block divinePlanks = new BlockMod(EnumBlockType.WOOD, "divine_planks", 2.0F);
        register(registry, divinePlanks);
        register(registry, new BlockModStairs("divine_stairs", divinePlanks));
        register(registry, new BlockMod("divine_moss_stone", 2.0F).setResistance(10));
        register(registry, new BlockMod(EnumBlockType.ROCK, "divine_rock", 1.5F, STONE).setResistance(10F));

        // Miscellaneous utility
        register(registry, new BlockModLight("slime_light", 1.5F));
        register(registry, new BlockModBridge("dark_bridge", 1.5F));

        // Crops
        register(registry, new BlockTomatoPlant());
        register(registry, new BlockWhiteMushroomPlant());

        // Boss statues
        register(registry, new BlockStatue("ancient_entity_statue", StatueType.ANCIENT_ENTITY_STATUE));

        register(registry, new BlockStatue("ayeraco_statue_blue", StatueType.BLUE_AYERACO_STATUE));
        register(registry, new BlockStatue("ayeraco_statue_red", StatueType.RED_AYERACO_STATUE));
        register(registry, new BlockStatue("ayeraco_statue_yellow", StatueType.YELLOW_AYERACO_STATUE));
        register(registry, new BlockStatue("ayeraco_statue_green", StatueType.GREEN_AYERACO_STATUE));
        register(registry, new BlockStatue("ayeraco_statue_purple", StatueType.PURPLE_AYERACO_STATUE));

        register(registry, new BlockStatue("densos_statue", StatueType.DENSOS_STATUE));
        register(registry, new BlockStatue("dramix_statue", StatueType.DRAMIX_STATUE));
        register(registry, new BlockStatue("eternal_archer_statue", StatueType.ETERNAL_ARCHER_STATUE));
        register(registry, new BlockStatue("karot_statue", StatueType.KAROT_STATUE));
        register(registry, new BlockStatue("king_of_scorchers_statue", StatueType.KING_OF_SCORCHERS_STATUE));
        register(registry, new BlockStatue("parasecta_statue", StatueType.PARASECTA_STATUE));
        register(registry, new BlockStatue("reyvor_statue", StatueType.REYVOR_STATUE));
        register(registry, new BlockStatue("soul_fiend_statue", StatueType.SOUL_FIEND_STATUE));
        register(registry, new BlockStatue("the_watcher_statue", StatueType.THE_WATCHER_STATUE));
        register(registry, new BlockStatue("twilight_demon_statue", StatueType.TWILIGHT_DEMON_STATUE));
        register(registry, new BlockStatue("vamacheron_statue", StatueType.VAMACHERON_STATUE));

        register(registry, new BlockStatue("termasect_statue", StatueType.TERMASECT_STATUE));
        register(registry, new BlockStatue("sunstorm_statue", StatueType.SUNSTORM_STATUE));

        // Ayeraco technical blocks
        registerItemlessBlock(registry, new BlockAyeracoBeam("ayeraco_beam_blue", "blue"));
        registerItemlessBlock(registry, new BlockAyeracoBeam("ayeraco_beam_green", "green"));
        registerItemlessBlock(registry, new BlockAyeracoBeam("ayeraco_beam_purple", "purple"));
        registerItemlessBlock(registry, new BlockAyeracoBeam("ayeraco_beam_red", "red"));
        registerItemlessBlock(registry, new BlockAyeracoBeam("ayeraco_beam_yellow", "yellow"));
        registerItemlessBlock(registry, new BlockAyeracoSpawn());

        // Liquid
        register(registry, new BlockTar("tar", ModLiquids.tar));

        // Iceika

        // Terrain
        register(registry, new BlockModDirt("frozen_dirt", 2.5F, MapColor.WHITE_STAINED_HARDENED_CLAY));
        register(registry, new BlockModGrass("frozen_grass", () -> frozenDirt, 2.5F, MapColor.LIGHT_BLUE));
        register(registry, new BlockMod("frozen_stone", 6.0F));
        register(registry, new BlockModLog("frozen_log", MapColor.WHITE_STAINED_HARDENED_CLAY).setHardness(5.0F));
        register(registry, new BlockModLeaves("brittle_leaves", 0.1F, () -> frozenSapling,
                MapColor.WHITE_STAINED_HARDENED_CLAY, 10));
        Block frozenPlanks = new BlockMod(EnumBlockType.WOOD, "frozen_planks", 2.0F);
        register(registry, frozenPlanks);
        register(registry, new BlockModStairs("frozen_stairs", frozenPlanks));
        register(registry, new BlockModSapling("frozen_sapling", () -> frozenGrass, () -> frozenDirt, new IceTreeGen(true, true)));


        // Structure blocks
        Block coalstone = new BlockMod("coalstone", 3.0F);
        register(registry, coalstone);
        register(registry, new BlockModStairs("coalstone_stairs", coalstone));
        register(registry, new BlockCoalstoneFurnace("coalstone_furnace", false));
        register(registry, new BlockCoalstoneFurnace("coalstone_furnace_on", true));
        register(registry, new BlockModSpawner("frost_archer_spawner", "frost_archer"));
        register(registry, new BlockFrostedChest("frosted_chest").setHardness(2.5F));
        register(registry, new BlockModGlass("frosted_glass", 1.0F));
        register(registry, new BlockModUnbreakable("icy_bricks"));
        register(registry, new BlockModUnbreakable("icy_stone"));
        register(registry, new BlockModSpawner("rollum_spawner", "rollum"));
        register(registry, new BlockMod("snow_bricks", 6.0F));
        registerItemlessBlock(registry, new BlockModDoor("steel_door", Material.IRON, 7.0f));
        register(registry, new BlockMod(EnumBlockType.ROCK, "workshop_bookcase", 1.5F));
        register(registry, new BlockMod(EnumBlockType.WOOL, "workshop_carpet", 0.1F));
        register(registry, new BlockModLamp(EnumBlockType.GLASS, "workshop_lamp", 0.3F));

        // Candy canes
        register(registry, new BlockCandyCane("blue_candy_cane"));
        register(registry, new BlockCandyCane("green_candy_cane"));
        register(registry, new BlockCandyCane("pink_candy_cane"));
        register(registry, new BlockCandyCane("red_candy_cane"));
        register(registry, new BlockCandyCane("yellow_candy_cane"));

        // Christmas lights
        register(registry, new BlockChristmasLights("blue_christmas_lights"));
        register(registry, new BlockChristmasLights("green_christmas_lights"));
        register(registry, new BlockChristmasLights("purple_christmas_lights"));
        register(registry, new BlockChristmasLights("red_christmas_lights"));
        register(registry, new BlockChristmasLights("yellow_christmas_lights"));

        // Chest
        register(registry, new BlockPresentBox("present_box"));

        // Crops
        register(registry, new BlockWinterberryBush(false, "winterberry_bush"));
        register(registry, new BlockWinterberryBush(true, "ripe_winterberry_bush"));

        // Other
        register(registry, new BlockModFire("iceika_fire"));

        // Twilight dimensions

        // Dirt
        register(registry, new BlockModDirt("eden_dirt", 5.0F, MapColor.YELLOW));
        register(registry, new BlockModDirt("wildwood_dirt", 5.0F, MapColor.BLUE));
        register(registry, new BlockModDirt("apalachia_dirt", 5.0F, MapColor.PURPLE));
        register(registry, new BlockModDirt("skythern_dirt", 5.0F, MapColor.GRAY));
        register(registry, new BlockModDirt("mortum_dirt", 5.0F, MapColor.BLACK));

        // Grass
        register(registry, new BlockModGrass("eden_grass", () -> edenDirt, 5.0F, MapColor.YELLOW));
        register(registry, new BlockModGrass("wildwood_grass", () -> wildwoodDirt, 5.0F, MapColor.BLUE));
        register(registry, new BlockModGrass("apalachia_grass", () -> apalachiaDirt, 5.0F, MapColor.PURPLE));
        register(registry, new BlockModGrass("skythern_grass", () -> skythernDirt, 5.0F, MapColor.CLOTH));
        register(registry, new BlockModGrass("mortum_grass", () -> mortumDirt, 5.0F, MapColor.BLACK));

        // Stone
        register(registry, new BlockMod("twilight_stone", 6.0F));

        // Ore
        register(registry, new BlockTwilightOre("eden_ore", 5, 2000F, DIAMOND, () -> ModItems.edenFragments));
        register(registry, new BlockTwilightOre("wildwood_ore", 6, 2000F, EDEN, () -> ModItems.wildwoodFragments));
        register(registry, new BlockTwilightOre("apalachia_ore", 7, 2000F, WILDWOOD, () -> ModItems.apalachiaFragments));
        register(registry, new BlockTwilightOre("skythern_ore", 8, 2000F, APALACHIA, () -> ModItems.skythernFragments));
        register(registry, new BlockTwilightOre("mortum_ore", 9, 2000F, SKYTHERN, () -> ModItems.mortumFragments));

        // Sapling
        register(registry, new BlockModSapling("eden_sapling", () -> edenGrass, () -> edenDirt, new EdenTree(true)));
        register(registry, new BlockModSapling("wildwood_sapling", () -> wildwoodGrass, () -> wildwoodDirt, new WildWoodTree(true)));
        register(registry, new BlockModSapling("apalachia_sapling", () -> apalachiaGrass, () -> apalachiaDirt,
                new TwilightTree(true,
                        5,
                        () -> ModBlocks.apalachiaLog.getDefaultState(),
                        () -> ModBlocks.apalachiaLeaves.getDefaultState(),
                        () -> ModBlocks.apalachiaSapling)
        ));
        register(registry, new BlockModSapling("skythern_sapling", () -> skythernGrass, () -> skythernDirt,
                new TwilightTree(true,
                        5,
                        () -> ModBlocks.skythernLog.getDefaultState(),
                        () -> ModBlocks.skythernLeaves.getDefaultState(),
                        () -> ModBlocks.skythernSapling)));
        register(registry, new BlockModSapling("mortum_sapling", () -> mortumGrass, () -> mortumDirt, new MortumTree(true)));

        // Logs
        register(registry, new BlockModLog("eden_log", MapColor.YELLOW));
        register(registry, new BlockModLog("wildwood_log", MapColor.BLUE));
        register(registry, new BlockModLog("apalachia_log", MapColor.PURPLE));
        register(registry, new BlockModLog("skythern_log", MapColor.GRAY));
        register(registry, new BlockModLog("mortum_log", MapColor.RED));

        // Leaves
        register(registry, new BlockModLeaves("eden_leaves", 0.5F, () -> edenSapling, MapColor.YELLOW));
        register(registry, new BlockModLeaves("wildwood_leaves", 0.5F, () -> wildwoodSapling, MapColor.LIGHT_BLUE));
        register(registry, new BlockModLeaves("apalachia_leaves", 0.5F, () -> apalachiaSapling, MapColor.PINK).setLightLevel(0.5F));
        register(registry, new BlockModLeaves("skythern_leaves", 0.5F, () -> skythernSapling, MapColor.CLOTH));
        register(registry, new BlockModLeaves("mortum_leaves", 0.5F, () -> mortumSapling, MapColor.RED));

        // Planks
        Block edenPlanks = new BlockMod(EnumBlockType.WOOD, "eden_planks", 2.0F);
        Block wildwoodPlanks = new BlockMod(EnumBlockType.WOOD, "wildwood_planks", 2.0F);
        Block apalachiaPlanks = new BlockMod(EnumBlockType.WOOD, "apalachia_planks", 2.0F);
        Block skythernPlanks = new BlockMod(EnumBlockType.WOOD, "skythern_planks", 2.0F);
        Block mortumPlanks = new BlockMod(EnumBlockType.WOOD, "mortum_planks", 2.0F);

        register(registry, edenPlanks);
        register(registry, wildwoodPlanks);
        register(registry, apalachiaPlanks);
        register(registry, skythernPlanks);
        register(registry, mortumPlanks);

        // Stairs
        register(registry, new BlockModStairs("eden_stairs", edenPlanks));
        register(registry, new BlockModStairs("wildwood_stairs", wildwoodPlanks));
        register(registry, new BlockModStairs("apalachia_stairs", apalachiaPlanks));
        register(registry, new BlockModStairs("skythern_stairs", skythernPlanks));
        register(registry, new BlockModStairs("mortum_stairs", mortumPlanks));

        // Compressed blocks
        register(registry, new BlockBeaconBase("eden_block", 9.0F));
        register(registry, new BlockBeaconBase("wildwood_block", 9.0F));
        register(registry, new BlockBeaconBase("apalachia_block", 9.0F));
        register(registry, new BlockBeaconBase("skythern_block", 9.0F));
        register(registry, new BlockBeaconBase("mortum_block", 9.0F));

        // Ground foliage
        register(registry, new BlockTwilightFlower("sunbloom", () -> edenGrass, MapColor.YELLOW));
        register(registry, new BlockTwilightFlower("sun_blossom", () -> edenGrass, 0.9, 0.6, MapColor.YELLOW));
        register(registry, new BlockTwilightFlower("moonlight_fern", () -> wildwoodGrass, 0.8, 0.8, MapColor.BLUE));
        register(registry, new BlockTwilightFlower("moon_bud", () -> wildwoodGrass, 0.8, 0.7, MapColor.BLUE));
        register(registry, new BlockTwilightFlower("dusk_bloom", () -> apalachiaGrass, 0.5, 0.5, MapColor.PURPLE));
        register(registry, new BlockTwilightFlower("dust_lily", () -> skythernGrass, MapColor.GRAY));
        register(registry, new BlockTwilightFlower("eye_plant", () -> mortumGrass, 0.5, 0.5, MapColor.BLACK));

        register(registry, new BlockTwilightGrass("eden_brush", () -> edenGrass, MapColor.YELLOW));
        register(registry, new BlockTwilightGrass("apalachia_tallgrass", () -> apalachiaGrass, MapColor.PURPLE));
        register(registry, new BlockTwilightGrass("skythern_brush", () -> skythernGrass, MapColor.GRAY));
        register(registry, new BlockTwilightGrass("mortum_brush", () -> mortumGrass, MapColor.BLACK));

        register(registry, new BlockModDoublePlant("wildwood_tallgrass", () -> wildwoodGrass, MapColor.BLUE));
        register(registry, new BlockModDoublePlant("dusk_flower", () -> apalachiaGrass, MapColor.PURPLE));

        register(registry, new BlockBrambles("dust_brambles", () -> skythernGrass, MapColor.GRAY));
        register(registry, new BlockBrambles("demon_brambles", () -> mortumGrass, MapColor.BLACK));


        // Crops
        register(registry, new BlockMoonbulb().setLightLevel(0.6f));
        register(registry, new BlockPinkGlowbone().setLightLevel(0.6f));
        register(registry, new BlockPurpleGlowbone().setLightLevel(0.6f));
        register(registry, new BlockSkyPlant());

        // Vine
        register(registry, new BlockModVine("wildwood_vine"));


        // Other
        register(registry, new BlockModFire("blue_fire"));
        register(registry, new BlockModTorch("eden_torch", ParticleType.GREEN_FLAME));
        register(registry, new BlockEdenChest("eden_chest"));
        register(registry, new BlockMod(EnumBlockType.PLANT, "truffle", 1.0F));

        // Arcana

        // Dirt
        register(registry, new BlockModDirt("arcanite_dirt", 0.5F, MapColor.BLUE));

        // Grass
        register(registry, new BlockModGrass("arcanite_grass", () -> arcaniteDirt, 0.5F, MapColor.BLUE));

        // Ore
        register(registry, new BlockMod("arcanium_ore", 3.0F));

        // Structure blocks
        // Normal
        register(registry, new BlockModUnbreakable("ancient_brick"));
        register(registry, new BlockModUnbreakable("ancient_stone"));
        register(registry, new BlockModUnbreakable("ancient_tile"));
        register(registry, new BlockModLadder("arcanite_tubes"));
        register(registry, new BlockModUnbreakable("arcanium_metal"));
        register(registry, new BlockModUnbreakable("arcanium_power"));
        register(registry, new BlockModUnbreakable("dark_degraded_brick"));
        register(registry, new BlockModUnbreakable("degraded_brick"));
        register(registry, new BlockModUnbreakable("dungeon_lamp").setLightLevel(1.0F));
        register(registry, new BlockHeatTrap("heat_trap"));
        register(registry, new BlockHeatTrap("heat_trap_on"));
        register(registry, new BlockModUnbreakable("light_degraded_brick"));
        register(registry, new BlockModUnbreakable("soul_sludge"));
        register(registry, new BlockModUnbreakable("soul_stone"));

        // Door
        registerItemlessBlock(registry, new BlockArcanaDoor("ancient_brick_door", () -> ModItems.ancientKey));
        registerItemlessBlock(registry, new BlockArcanaDoor("degraded_brick_door", () -> ModItems.degradedKey));
        registerItemlessBlock(registry, new BlockArcanaDoor("soul_sludge_door", () -> ModItems.sludgeKey));
        registerItemlessBlock(registry, new BlockArcanaDoor("soul_stone_door", () -> ModItems.soulKey));

        // Spawner
        register(registry, new BlockArcanaSpawner("death_hound_spawner", "death_hound"));
        register(registry, new BlockArcanaSpawner("deathcryx_spawner", "deathcryx"));
        register(registry, new BlockArcanaSpawner("dungeon_prisoner_spawner", "dungeon_prisoner"));
        register(registry, new BlockArcanaSpawner("living_statue_spawner", "living_statue"));
        register(registry, new BlockArcanaSpawner("razorback_spawner", "razorback"));
        register(registry, new BlockArcanaSpawner("roamer_spawner", "roamer"));

        // Utility
        register(registry, new BlockArcaniumExtractor("arcanium_extractor"));

        // Boss altars
        register(registry, new BlockDramixAltar("dramix_altar"));
        register(registry, new BlockParasectaAltar("parasecta_altar"));

        // Stained glass
        register(registry, new BlockModGlass("stained_glass", 0.3F).setUnlocalizedName("stained_glass"));
        register(registry, new BlockModGlass("stained_glass2", 0.3F).setUnlocalizedName("stained_glass"));
        register(registry, new BlockModGlass("stained_glass3", 0.3F).setUnlocalizedName("stained_glass"));
        register(registry, new BlockModGlass("stained_glass4", 0.3F).setUnlocalizedName("stained_glass"));
        register(registry, new BlockModGlass("stained_glass5", 0.3F).setUnlocalizedName("stained_glass"));
        register(registry, new BlockModGlass("stained_glass6", 0.3F).setUnlocalizedName("stained_glass"));
        register(registry, new BlockModGlass("stained_glass7", 0.3F).setUnlocalizedName("stained_glass"));
        register(registry, new BlockModGlass("stained_glass8", 0.3F).setUnlocalizedName("stained_glass"));

        // Portal blocks
        register(registry, new BlockArcanaPortal("arcana_portal", ModDimensions.arcanaDimension.getId()));
        register(registry, new BlockArcanaPortalFrame("arcana_portal_frame"));
        register(registry, new BlockArcanaPortalFrame("arcana_hard_portal_frame").setBlockUnbreakable().setResistance(6000000F).setCreativeTab(null));

        // Eucalyptus
        register(registry, new BlockModLog("eucalyptus_log", MapColor.CLOTH));
        Block eucalyptusPlanks = new BlockMod(EnumBlockType.WOOD, "eucalyptus_planks", 2.0F);
        register(registry, eucalyptusPlanks);
        register(registry, new BlockModStairs("eucalyptus_stairs", eucalyptusPlanks));

        // Crops
        register(registry, new BlockAquaMarine("aquamarine_plant"));
        register(registry, new BlockEucalyptusRoot("eucalyptus_plant"));
        register(registry, new BlockFirestock());
        register(registry, new BlockHitchak("hitchak_plant"));
        register(registry, new BlockLamona("lamona_plant"));
        register(registry, new BlockMarsine("marsine_plant"));
        register(registry, new BlockPinfly());
        register(registry, new BlockVeilo("veilo_plant"));

        // Furnace
        register(registry, new BlockGreenlightFurnace("greenlight_furnace", false));
        register(registry, new BlockGreenlightFurnace("greenlight_furnace_on", true));
        register(registry, new BlockOceanfireFurnace("oceanfire_furnace", false));
        register(registry, new BlockOceanfireFurnace("oceanfire_furnace_on", true));
        register(registry, new BlockMoltenFurnace("molten_furnace", false));
        register(registry, new BlockMoltenFurnace("molten_furnace_on", true));
        register(registry, new BlockWhitefireFurnace("whitefire_furnace", false));
        register(registry, new BlockWhitefireFurnace("whitefire_furnace_on", true));
        register(registry, new BlockMoonlightFurnace("moonlight_furnace", false));
        register(registry, new BlockMoonlightFurnace("moonlight_furnace_on", true));
        register(registry, new BlockDemonFurnace("demon_furnace", false));
        register(registry, new BlockDemonFurnace("demon_furnace_on", true));

        // Miscellaneous utility
        register(registry, new BlockAcceleron("acceleron"));
        register(registry, new BlockModTorch("arcanium_torch", ParticleType.PURPLE_FLAME));
        register(registry, new BlockElevantium("elevantium"));
        register(registry, new BlockModBridge("star_bridge", 1.5F));

        // Vethea

        // Terrain
        register(registry, new BlockModDirt("dream_dirt", 0.5F, MapColor.LIME_STAINED_HARDENED_CLAY).setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockModGrass("dream_grass", () -> dreamDirt, 0.6F, MapColor.LIGHT_BLUE).setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockMod("dream_stone", 6.0F).setCreativeTab(DivineRPGTabs.vethea));

        // Logs
        register(registry, new BlockVetheaLog("dreamwood_log", MapColor.LIGHT_BLUE).setHardness(5.0F).setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockVetheaLog("firewood_log", MapColor.RED).setHardness(5.0F).setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockVetheaLog("hyrewood_log", MapColor.BLUE).setHardness(5.0F).setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockVetheaLog("mintwood_log", MapColor.LIGHT_BLUE).setHardness(5.0F).setCreativeTab(DivineRPGTabs.vethea));

        // Leaves
        register(registry, new BlockModLeaves("dreamwood_leaves", 0.1F, MapColor.RED).setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockModLeaves("firewood_leaves", 0.1F, MapColor.RED).setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockModLeaves("hyrewood_leaves", 0.1F, MapColor.RED).setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockModLeaves("mintwood_leaves", 0.1F, MapColor.RED).setCreativeTab(DivineRPGTabs.vethea));

        // Ground foliage
        register(registry, new BlockTwilightFlower("bulbatobe", () -> dreamGrass, MapColor.GREEN).setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockTwilightFlower("cracklespike", () -> dreamGrass, MapColor.GREEN).setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockTwilightFlower("dreamglow", () -> dreamGrass, MapColor.GREEN).setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockTwilightFlower("fernite", () -> dreamGrass, MapColor.GREEN).setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockTwilightFlower("green_dulah", () -> dreamGrass, MapColor.GREEN).setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockTwilightFlower("green_gemtop", () -> dreamGrass, MapColor.GREEN).setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockTwilightFlower("purple_gemtop", () -> dreamGrass, MapColor.GREEN).setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockTwilightFlower("shimmer", () -> dreamGrass, MapColor.GREEN).setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockTwilightFlower("shine_grass", () -> dreamGrass, MapColor.GREEN).setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockTwilightFlower("yellow_dulah", () -> dreamGrass, MapColor.GREEN).setCreativeTab(DivineRPGTabs.vethea));

        // Vines
        register(registry, new BlockModVine("weedwood_vine").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockModVine("blossomed_weedwood_vine").setCreativeTab(DivineRPGTabs.vethea));

        // Building blocks
        register(registry, new BlockMod("dark_dream_bricks", 1.0F).setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockMod("light_dream_bricks", 1.0F).setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockMod("red_dream_bricks", 1.0F).setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockModGlass("smooth_glass", 0.3F).setCreativeTab(DivineRPGTabs.vethea));

        // Door
        registerItemlessBlock(registry, new BlockModDoor("barred_door", Material.IRON, 2.0f));

        // Lighting
        register(registry, new BlockModLamp(EnumBlockType.GLASS, "fire_crystal", 1.0F).setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockModLamp(EnumBlockType.GLASS, "firelight", 1.0F).setCreativeTab(DivineRPGTabs.vethea));

        // Structure
        // General
        register(registry, new BlockDreamLamp("dream_lamp").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockModUnbreakable("everstone").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockModUnbreakable("dark_everstone").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockModUnbreakable("white_everstone").setCreativeTab(DivineRPGTabs.vethea));

        // Crypt
        register(registry, new BlockModUnbreakable("black_hungerstone").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockModUnbreakable("green_hungerstone").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockModUnbreakable("crypt_floor").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockMod("crypt_wall", 1.0F).setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockModGlass("metal_caging", 1.0F).setCreativeTab(DivineRPGTabs.vethea));

        // Village
        register(registry, new BlockModLamp(EnumBlockType.GLASS, "village_lamp", 1.0F).setCreativeTab(DivineRPGTabs.vethea));

        // Hive
        register(registry, new BlockModLamp(EnumBlockType.GLASS, "cell_lamp", 1.0F).setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockMod(EnumBlockType.GLASS, "hive_wall", 1.0F).setLightLevel(0.533F).setCreativeTab(DivineRPGTabs.vethea));

        // Karos Madhouse
        register(registry, new BlockModUnbreakable("black_karos_bricks").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockModUnbreakable("blue_karos_bricks").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockHelioticBeam("heliotic_beam").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockKarosDispenser("karos_dispenser").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockKarosHeatTile("karos_heat_tile_green").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockKarosHeatTile("karos_heat_tile_red").setCreativeTab(DivineRPGTabs.vethea));

        // Lunic Garden
        register(registry, new BlockMod("luna_bricks", 1.0F).setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockMod("luna_stone", 1.0F).setCreativeTab(DivineRPGTabs.vethea));

        // Raglok Chamber
        register(registry, new BlockModUnbreakable("chamber_wall").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockModUnbreakable("shifted_chamber_wall").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockModUnbreakable("stacked_chamber_wall").setCreativeTab(DivineRPGTabs.vethea));

        // Wreck Hall
        register(registry, new BlockModUnbreakable("hall_wall").setCreativeTab(DivineRPGTabs.vethea));

        // Utility
        register(registry, new BlockInfusionTable("infusion_table").setCreativeTab(DivineRPGTabs.vethea));

        // Hive egg
        register(registry, new BlockHiveEgg("hive_egg").setCreativeTab(DivineRPGTabs.vethea));

        // Boss altars
        register(registry, new BlockKarosAltar("karos_altar").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockLunicAltar("lunic_altar").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockQuadroticAltar("quadrotic_altar").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockRaglokAltar("raglok_altar").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockWreckAltar("wreck_altar").setCreativeTab(DivineRPGTabs.vethea));

        // Mob spawners
        register(registry, new BlockModSpawner("biphron_spawner", "Biphron").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockModSpawner("dreamwrecker_spawner", "Dreamwrecker").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockModSpawner("gorgosion_spawner", "Gorgosion").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockModSpawner("twins_spawner", "Twins").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockModSpawner("vermenous_spawner", "Vermenous").setCreativeTab(DivineRPGTabs.vethea));

        // Acid
        register(registry, new BlockAcid("acid_block", true).setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockAcid("bacterial_acid", false).setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new BlockAcid("lunic_acid", true).setCreativeTab(DivineRPGTabs.vethea));

        // Nightmare bed
        registerItemlessBlock(registry, new BlockNightmareBed());

        // Portal blocks
        // Portal
        register(registry, new BlockModPortal("iceika_portal", ModDimensions.iceikaDimension, () -> iceikaFire, () -> Blocks.SNOW, ParticleType.FROST));
        register(registry, new BlockModPortal("eden_portal", ModDimensions.edenDimension, () -> blueFire, () -> divineRock, ParticleType.EDEN_PORTAL));
        register(registry, new BlockModPortal("wildwood_portal", ModDimensions.wildWoodDimension, () -> blueFire, () -> edenBlock, ParticleType.WILDWOOD_PORTAL));
        register(registry, new BlockModPortal("apalachia_portal", ModDimensions.apalachiaDimension, () -> blueFire, () -> wildwoodBlock, ParticleType.APALACHIA_PORTAL));
        register(registry, new BlockModPortal("skythern_portal", ModDimensions.skythernDimension, () -> blueFire, () -> apalachiaBlock, ParticleType.SKYTHERN_PORTAL));
        register(registry, new BlockModPortal("mortum_portal", ModDimensions.mortumDimension, () -> blueFire, () -> skythernBlock, ParticleType.MORTUM_PORTAL));
        register(registry, new BlockVetheaPortal("vethea_portal", ModDimensions.vetheaDimension, () -> blueFire, () -> mortumBlock, ParticleType.MORTUM_PORTAL));

        //Slab
        registerItemlessBlock(registry, new BlockModSlab("eden_slab", BlockModPlank.EnumType.EDEN, false));
        registerItemlessBlock(registry, new BlockModSlab("wildwood_slab", BlockModPlank.EnumType.WILDWOOD, false));
        registerItemlessBlock(registry, new BlockModSlab("apalachia_slab", BlockModPlank.EnumType.APALACHIA, false));
        registerItemlessBlock(registry, new BlockModSlab("skythern_slab", BlockModPlank.EnumType.SKYTHERN, false));
        registerItemlessBlock(registry, new BlockModSlab("mortum_slab", BlockModPlank.EnumType.MORTUM, false));
        registerItemlessBlock(registry, new BlockModSlab("divine_slab", BlockModPlank.EnumType.DIVINE, false));
        registerItemlessBlock(registry, new BlockModSlab("frozen_slab", BlockModPlank.EnumType.FROZEN, false));
        registerItemlessBlock(registry, new BlockModSlab("eucalyptus_slab", BlockModPlank.EnumType.EUCALYPTUS, false));

        //Double Slab
        registerItemlessBlock(registry, new BlockModSlab("eden_double_slab", BlockModPlank.EnumType.EDEN, true));
        registerItemlessBlock(registry, new BlockModSlab("wildwood_double_slab", BlockModPlank.EnumType.WILDWOOD, true));
        registerItemlessBlock(registry, new BlockModSlab("apalachia_double_slab", BlockModPlank.EnumType.APALACHIA, true));
        registerItemlessBlock(registry, new BlockModSlab("skythern_double_slab", BlockModPlank.EnumType.SKYTHERN, true));
        registerItemlessBlock(registry, new BlockModSlab("mortum_double_slab", BlockModPlank.EnumType.MORTUM, true));
        registerItemlessBlock(registry, new BlockModSlab("divine_double_slab", BlockModPlank.EnumType.DIVINE, true));
        registerItemlessBlock(registry, new BlockModSlab("frozen_double_slab", BlockModPlank.EnumType.FROZEN, true));
        registerItemlessBlock(registry, new BlockModSlab("eucalyptus_double_slab", BlockModPlank.EnumType.EUCALYPTUS, true));

        register(registry, new KingCompressor("king_compression", true));
        register(registry, new KingCompressor("king_compression_still", false));

        //
        // newSpawners
        //
        register(registry, new BlockSingleUseSpawner("sunstorm_spawner", EntitySunstorm.class, 20 * 5, 5));
        register(registry, new BlockSingleUseSpawner("termasect_spawner", EntityTermasect.class, 20 * 5, 5,
                // should spawn above
                new BlockPos(0, 11, 0)));
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerBlockItems(RegistryEvent.Register<Item> event) {
        DivineRPG.logger.info("Registering DivineRPG block items");

        for (Block block : blockList) {
            Item itemBlock = new ItemBlock(block).setRegistryName(block.getRegistryName());
            if (!itemBlock.equals(Item.getItemFromBlock(Blocks.AIR))) {
                ModItems.itemMap.put(itemBlock.getRegistryName().getResourcePath(), itemBlock);
            }
            event.getRegistry().register(itemBlock);
        }
    }

    private static void register(IForgeRegistry<Block> registry, Block block) {
        registry.register(block);
        blockList.add(block);
    }

    private static void registerItemlessBlock(IForgeRegistry<Block> registry, Block block) {
        registry.register(block);
    }
}