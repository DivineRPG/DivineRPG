package divinerpg.registries;

import divinerpg.*;
import divinerpg.blocks.arcana.*;
import divinerpg.blocks.base.*;
import divinerpg.blocks.iceika.*;
import divinerpg.blocks.twilight.*;
import divinerpg.blocks.vanilla.*;
import divinerpg.blocks.vethea.*;
import divinerpg.client.renders.item.*;
import divinerpg.enums.*;
import divinerpg.items.base.*;
import divinerpg.world.gen.tree.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.item.*;
import net.minecraft.particles.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraftforge.common.*;
import net.minecraftforge.event.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.registries.*;

import java.util.*;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(DivineRPG.MODID)
public class BlockRegistry {
    private static final int WOOD_GOLD = 0;
    private static final int STONE = 1;
    private static final int IRON = 2;
    private static final int DIAMOND = 3;
    private static final int EDEN = 6;
    private static final int WILDWOOD = 7;
    private static final int APALACHIA = 8;
    private static final int SKYTHERN = 9;
    private static final int MORTUM = 10;
    private static final List<Block> blocks = new ArrayList<Block>();
    private static final List<Block> vethea = new ArrayList<Block>();
    private static final List<Block> utilities = new ArrayList<Block>();
    private static final List<Item> blockItemList = new ArrayList<>();
    private static final List<Block> slabList = new ArrayList<>();

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
    @ObjectHolder("torridite_ore")
    public static final Block torriditeOre = null;

    // Compressed ore blocks
    @ObjectHolder("arlemite_block")
    public static final Block arlemiteBlock = null;
    @ObjectHolder("realmite_block")
    public static final Block realmiteBlock = null;
    @ObjectHolder("rupee_block")
    public static final Block rupeeBlock = null;
    @ObjectHolder("bloodgem_block")
    public static final Block bloodgemBlock = null;
    @ObjectHolder("torridite_block")
    public static final Block torriditeBlock = null;

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
    @ObjectHolder("aqua_wall_torch")
    public static final Block aquaWallTorch = null;
    @ObjectHolder("skeleton_wall_torch")
    public static final Block skeletonWallTorch = null;

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
    @ObjectHolder("torridite_bricks")
    public static final Block torriditeBricks = null;
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
    @ObjectHolder("skythern_bricks")
    public static final Block skythernBricks = null;
    @ObjectHolder("mortum_bricks")
    public static final Block mortumBricks = null;

    // Minibricks
    @ObjectHolder("minibricks")
    public static final Block minibricks = null;
    @ObjectHolder("arlemite_minibricks")
    public static final Block arlemiteMinibricks = null;
    @ObjectHolder("bedrock_minibricks")
    public static final Block bedrockMinibricks = null;
    @ObjectHolder("bloodgem_minibricks")
    public static final Block bloodgemMinibricks = null;
    @ObjectHolder("torridite_minibricks")
    public static final Block torriditeMinibricks = null;
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
    @ObjectHolder("torridite_lamp")
    public static final Block torriditeLamp = null;
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
    @ObjectHolder("frosted_allure")
    public static final Block frostedAllure = null;

    // Divine blocks
    @ObjectHolder("divine_sapling")
    public static final Block divineSapling = null;
    @ObjectHolder("divine_log")
    public static final Block divineLog = null;
    @ObjectHolder("stripped_divine_log")
    public static final Block strippedDivineLog = null;
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
    @ObjectHolder("experienced_cori_statue")
    public static final Block experienced_cori_statue = null;

    // Liquid
    @ObjectHolder("smoldering_tar")
    public static final FlowingFluidBlock smolderingTar = null;

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
    public static final Block frozenDirt = null;
    @ObjectHolder("frozen_grass")
    public static final Block frozenGrass = null;
    @ObjectHolder("frozen_stone")
    public static final Block frozenStone = null;
    @ObjectHolder("frozen_log")
    public static final Block frozenLog = null;
    @ObjectHolder("stripped_frozen_log")
    public static final Block strippedFrozenLog = null;
    @ObjectHolder("brittle_leaves")
    public static final Block brittleLeaves = null;
    @ObjectHolder("frozen_planks")
    public static final Block frozenPlanks = null;
    @ObjectHolder("frozen_stairs")
    public static final Block frozenStairs = null;
    @ObjectHolder("frozen_sapling")
    public static final SaplingBlock frozenSapling = null;

    // Structure blocks
    @ObjectHolder("coalstone")
    public static final Block coalstone = null;
    @ObjectHolder("coalstone_furnace")
    public static final Block coalstoneFurnace = null;
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

    // Other
    @ObjectHolder("iceika_fire")
    public static final Block iceikaFire = null;
    @ObjectHolder("iceika_portal")
    public static final BlockModPortal iceikaPortal = null;

    // Twilight dimensions

    // Dirt
    @ObjectHolder("eden_dirt")
    public static final Block edenDirt = null;
    @ObjectHolder("wildwood_dirt")
    public static final Block wildwoodDirt = null;
    @ObjectHolder("apalachia_dirt")
    public static final Block apalachiaDirt = null;
    @ObjectHolder("skythern_dirt")
    public static final Block skythernDirt = null;
    @ObjectHolder("mortum_dirt")
    public static final Block mortumDirt = null;

    // Grass
    @ObjectHolder("eden_grass")
    public static final Block edenGrass = null;
    @ObjectHolder("wildwood_grass")
    public static final Block wildwoodGrass = null;
    @ObjectHolder("apalachia_grass")
    public static final Block apalachiaGrass = null;
    @ObjectHolder("skythern_grass")
    public static final Block skythernGrass = null;
    @ObjectHolder("mortum_grass")
    public static final Block mortumGrass = null;

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
    public static final SaplingBlock edenSapling = null;
    @ObjectHolder("wildwood_sapling")
    public static final SaplingBlock wildwoodSapling = null;
    @ObjectHolder("apalachia_sapling")
    public static final SaplingBlock apalachiaSapling = null;
    @ObjectHolder("skythern_sapling")
    public static final SaplingBlock skythernSapling = null;
    @ObjectHolder("mortum_sapling")
    public static final SaplingBlock mortumSapling = null;

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

    //Stripped Logs
    @ObjectHolder("stripped_eden_log")
    public static final Block strippedEdenLog = null;
    @ObjectHolder("stripped_wildwood_log")
    public static final Block strippedWildwoodLog = null;
    @ObjectHolder("stripped_apalachia_log")
    public static final Block strippedApalachiaLog = null;
    @ObjectHolder("stripped_skythern_log")
    public static final Block strippedSkythernLog = null;
    @ObjectHolder("stripped_mortum_log")
    public static final Block strippedMortumLog = null;

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
    @ObjectHolder("ancient_brick_slab")
    public static final Block ancientBrickSlab = null;
    @ObjectHolder("degraded_brick_slab")
    public static final Block degradedBrickSlab = null;

    // Walls
    @ObjectHolder("ancient_brick_wall")
    public static final Block ancientBrickWall = null;
    @ObjectHolder("degraded_brick_wall")
    public static final Block degradedBrickWall = null;

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

    // Boss spawners
    @ObjectHolder("sunstorm_spawner")
    public static final Block sunstormSpawner = null;
    @ObjectHolder("termasect_spawner")
    public static final Block termasectSpawner = null;
    @ObjectHolder("eternal_archer_spawner")
    public static final Block eternalArcherSpawner = null;
    @ObjectHolder("experienced_cori_spawner")
    public static final Block experiencedCoriSpawner = null;

    // Twilight dimension ground foliage
    // Eden
    @ObjectHolder("sun_blossom")
    public static final Block sunBlossom = null;
    @ObjectHolder("sunbloom")
    public static final Block sunbloom = null;
    @ObjectHolder("eden_brush")
    public static final Block edenBrush = null;

    // Wildwood
    @ObjectHolder("moon_bud")
    public static final Block moonBud = null;
    @ObjectHolder("moonlight_fern")
    public static final Block moonlightFern = null;
    @ObjectHolder("wildwood_tallgrass")
    public static final Block wildwoodTallgrass = null;

    // Apalachia
    @ObjectHolder("dusk_bloom")
    public static final Block duskBloom = null;
    @ObjectHolder("dusk_flower")
    public static final Block duskFlower = null;
    @ObjectHolder("apalachia_tallgrass")
    public static final Block apalachiaTallgrass = null;

    // Skythern
    @ObjectHolder("dust_brambles")
    public static final Block dustBrambles = null;
    @ObjectHolder("dust_lily")
    public static final Block dustLily = null;
    @ObjectHolder("skythern_brush")
    public static final Block skythernBrush = null;

    // Mortum
    @ObjectHolder("demon_brambles")
    public static final Block demonBrambles = null;
    @ObjectHolder("eye_plant")
    public static final Block eyePlant = null;
    @ObjectHolder("mortum_brush")
    public static final Block mortumBrush = null;

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
    @ObjectHolder("eden_wall_torch")
    public static final Block edenWallTorch = null;
    @ObjectHolder("eden_chest")
    public static final Block edenChest = null;
    @ObjectHolder("truffle")
    public static final Block truffle = null;

    // Arcana

    // Dirt
    @ObjectHolder("arcanite_dirt")
    public static final Block arcaniteDirt = null;

    // Grass
    @ObjectHolder("arcanite_grass")
    public static final Block arcaniteGrass = null;

    // Ore
    @ObjectHolder("raw_arcanium")
    public static final Block rawArcanium = null;

    // Storage block
    @ObjectHolder("arcanium_block")
    public static final Block arcaniumBlock = null;

    // Structure blocks
    // Normal
    @ObjectHolder("ancient_bricks")
    public static final Block ancientBricks = null;
    @ObjectHolder("ancient_brick_stairs")
    public static final Block ancientBrickStairs = null;
    @ObjectHolder("ancient_stone")
    public static final Block ancientStone = null;
    @ObjectHolder("ancient_tile")
    public static final Block ancientTile = null;
    @ObjectHolder("arcanite_tubes")
    public static final Block arcaniteTubes = null;
    @ObjectHolder("arcanite_ladder")
    public static final Block arcaniteLadder = null;
    @ObjectHolder("arcanium_metal")
    public static final Block arcaniumMetal = null;
    @ObjectHolder("arcanium_power")
    public static final Block arcaniumPower = null;
    @ObjectHolder("dark_degraded_brick")
    public static final Block darkDegradedBrick = null;
    @ObjectHolder("degraded_bricks")
    public static final Block degradedBricks = null;
    @ObjectHolder("degraded_brick_stairs")
    public static final Block degradedBrickStairs = null;
    @ObjectHolder("dungeon_bookshelf")
    public static final Block dungeonBookshelf = null;
    @ObjectHolder("dungeon_lamp")
    public static final Block dungeonLamp = null;
    @ObjectHolder("heat_trap")
    public static final Block heatTrap = null;
    @ObjectHolder("light_degraded_brick")
    public static final Block lightDegradedBrick = null;
    @ObjectHolder("soul_sludge")
    public static final Block soulSludge = null;
    @ObjectHolder("soul_stone")
    public static final Block soulStone = null;

    // Breakable
    @ObjectHolder("ancient_bricks_breakable")
    public static final Block ancientBricksBreakable = null;
    @ObjectHolder("ancient_brick_stairs_breakable")
    public static final Block ancientBrickStairsBreakable = null;
    @ObjectHolder("ancient_brick_slab_breakable")
    public static final Block ancientBrickSlabBreakable = null;
    @ObjectHolder("ancient_brick_wall_breakable")
    public static final Block ancientBrickWallBreakable = null;
    @ObjectHolder("ancient_stone_breakable")
    public static final Block ancientStoneBreakable = null;
    @ObjectHolder("ancient_tile_breakable")
    public static final Block ancientTileBreakable = null;
    @ObjectHolder("arcanium_metal_breakable")
    public static final Block arcaniumMetalBreakable = null;
    @ObjectHolder("arcanium_power_breakable")
    public static final Block arcaniumPowerBreakable = null;
    @ObjectHolder("degraded_bricks_breakable")
    public static final Block degradedBricksBreakable = null;
    @ObjectHolder("degraded_brick_stairs_breakable")
    public static final Block degradedBrickStairsBreakable = null;
    @ObjectHolder("degraded_brick_slab_breakable")
    public static final Block degradedBrickSlabBreakable = null;
    @ObjectHolder("degraded_brick_wall_breakable")
    public static final Block degradedBrickWallBreakable = null;
    @ObjectHolder("dungeon_lamp_breakable")
    public static final Block dungeonLampBreakable = null;
    @ObjectHolder("soul_sludge_breakable")
    public static final Block soulSludgeBreakable = null;
    @ObjectHolder("soul_stone_breakable")
    public static final Block soulStoneBreakable = null;

    // Door
    @ObjectHolder("ancient_brick_door")
    public static final Block ancientBrickDoor = null;
    @ObjectHolder("degraded_brick_door")
    public static final Block degradedBrickDoor = null;
    @ObjectHolder("soul_sludge_door")
    public static final Block soulSludgeDoor = null;
    @ObjectHolder("soul_stone_door")
    public static final Block soulStoneDoor = null;

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
    @ObjectHolder("stripped_eucalyptus_log")
    public static final Block strippedEucalyptusLog = null;
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
    @ObjectHolder("oceanfire_furnace")
    public static final Block oceanfireFurnace = null;
    @ObjectHolder("molten_furnace")
    public static final Block moltenFurnace = null;
    @ObjectHolder("whitefire_furnace")
    public static final Block whitefireFurnace = null;
    @ObjectHolder("moonlight_furnace")
    public static final Block moonlightFurnace = null;
    @ObjectHolder("demon_furnace")
    public static final Block demonFurnace = null;

    // Miscellaneous utility
    @ObjectHolder("acceleron")
    public static final Block acceleron = null;
    @ObjectHolder("arcanium_torch")
    public static final Block arcaniumTorch = null;
    @ObjectHolder("arcanium_wall_torch")
    public static final Block arcaniumWallTorch = null;
    @ObjectHolder("elevantium")
    public static final Block elevantium = null;
    @ObjectHolder("star_bridge")
    public static final Block starBridge = null;

    //We are avoiding rails for now
    //public static final Block arcaniteRails = new BlockRedstonelessRails("arcanite_rails");

    // Vethea
    // Terrain
    @ObjectHolder("dream_dirt")
    public static final Block dreamDirt = null;
    @ObjectHolder("dream_grass")
    public static final Block dreamGrass = null;
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

    // Stripped Logs
    @ObjectHolder("stripped_dreamwood_log")
    public static final Block strippedDreamwoodLog = null;
    @ObjectHolder("stripped_firewood_log")
    public static final Block strippedFirewoodLog = null;
    @ObjectHolder("stripped_hyrewood_log")
    public static final Block strippedHyrewoodLog = null;
    @ObjectHolder("stripped_mintwood_log")
    public static final Block strippedMintwoodLog = null;

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
    public static final Block vetheaPortal = null;


    @ObjectHolder("captain_merik_spawner")
    public static final Block captainMerikSpawner = null;
    @ObjectHolder("datticon_spawner")
    public static final Block datticonSpawner = null;
    @ObjectHolder("kazari_spawner")
    public static final Block kazariSpawner = null;
    @ObjectHolder("leorna_spawner")
    public static final Block leornaSpawner = null;
    @ObjectHolder("lord_vatticus_spawner")
    public static final Block lordVatticusSpawner = null;
    @ObjectHolder("war_general_spawner")
    public static final Block warGeneralSpawner = null;
    @ObjectHolder("zelus_spawner")
    public static final Block zelusSpawner = null;

    @ObjectHolder("hunger_spawner_ls")
    public static final Block hungerSpawnerLS = null;
    @ObjectHolder("hunger_spawner_sg")
    public static final Block hungerSpawnerSG = null;
    @ObjectHolder("structure_air")
    public static final Block structureAir = null;

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> registry) {
        DivineRPG.LOGGER.info("[DivineRPG] Registered blocks");
        // Vanilla dimensions
        // Ores
        register(registry, new BlockMod("arlemite_ore", Block.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().harvestLevel(DIAMOND).harvestTool(ToolType.PICKAXE).strength(3.0F, 2000.0F).sound(SoundType.STONE)));
        register(registry, new BlockMod("realmite_ore", Block.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().harvestLevel(IRON).harvestTool(ToolType.PICKAXE).strength(3.0F, 2000.0F).sound(SoundType.STONE)));
        register(registry, new BlockMod("rupee_ore", Block.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().harvestLevel(DIAMOND).harvestTool(ToolType.PICKAXE).strength(3.0F, 2000.0F).sound(SoundType.STONE)));
        register(registry, new BlockMod("bloodgem_ore", Block.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().harvestLevel(DIAMOND).harvestTool(ToolType.PICKAXE).strength(3.0F, 2000.0F).sound(SoundType.STONE)));
        register(registry, new BlockMod("torridite_ore", Block.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().harvestLevel(DIAMOND).harvestTool(ToolType.PICKAXE).strength(3.0F, 2000.0F).sound(SoundType.STONE)));

        // Compressed ore blocks
        register(registry, new BlockMod("arlemite_block", 5.0F, 3.0F, Material.METAL));
        register(registry, new BlockMod("realmite_block", 5.0F, 3.0F, Material.METAL));
        register(registry, new BlockMod("rupee_block", 5.0F, 3.0F, Material.METAL));
        register(registry, new BlockMod("bloodgem_block", 5.0F, 3.0F, Material.METAL));
        register(registry, new BlockMod("torridite_block", 5.0F, 3.0F, Material.METAL));

        // Boss spawners
        register(registry, new BlockSingleUseSpawner("sunstorm_spawner", EntityRegistry.SUNSTORM, () -> ItemRegistry.edenChunk, 20 * 5, 5));
        register(registry, new BlockSingleUseSpawner("termasect_spawner", EntityRegistry.TERMASECT, () -> ItemRegistry.wildwoodChunk,20 * 5, 5, new BlockPos(0, 11, 0)));
        register(registry, new BlockSingleUseSpawner("eternal_archer_spawner", EntityRegistry.ETERNAL_ARCHER, () -> ItemRegistry.apalachiaChunk, 20 * 5, 5));
        register(registry, new BlockSingleUseSpawner("experienced_cori_spawner", EntityRegistry.EXPERIENCED_CORI, () -> ItemRegistry.skythernChunk, 20 * 5, 5, new BlockPos(0, 11, 0)));

        // Mob pumpkins
        register(registry, new BlockMobPumpkin("blaze_pumpkin", SoundEvents.BLAZE_AMBIENT));
        register(registry, new BlockMobPumpkin("creeper_pumpkin", SoundEvents.CREEPER_PRIMED));
        register(registry, new BlockMobPumpkin("cyclops_pumpkin", SoundRegistry.CYCLOPS));
        register(registry, new BlockMobPumpkin("ender_pumpkin", SoundEvents.ENDERMAN_SCREAM));
        register(registry, new BlockMobPumpkin("ender_watcher_pumpkin", SoundEvents.ENDERMAN_AMBIENT));
        register(registry, new BlockMobPumpkin("frost_pumpkin", SoundRegistry.FROST));
        register(registry, new BlockMobPumpkin("ghast_pumpkin", SoundEvents.GHAST_SCREAM));
        register(registry, new BlockMobPumpkin("glacon_pumpkin", SoundRegistry.GLACIDE));
        register(registry, new BlockMobPumpkin("hellspider_pumpkin", SoundRegistry.HELL_SPIDER));
        register(registry, new BlockMobPumpkin("jungle_spider_pumpkin", SoundRegistry.HELL_SPIDER));
        register(registry, new BlockMobPumpkin("skeleton_pumpkin", SoundEvents.SKELETON_AMBIENT));
        register(registry, new BlockMobPumpkin("spider_pumpkin", SoundEvents.SPIDER_AMBIENT));
        register(registry, new BlockMobPumpkin("zombie_pumpkin", SoundEvents.ZOMBIE_AMBIENT));

        // Torches
        registerItemlessBlock(registry, new BlockModTorch("aqua_torch", ParticleTypes.FLAME));
        registerItemlessBlock(registry, new BlockModWallTorch("aqua_wall_torch", ParticleTypes.FLAME));
        registerItemlessBlock(registry, new BlockModWallTorch("skeleton_wall_torch", ParticleTypes.FLAME));
        registerItemlessBlock(registry, new BlockModTorch("skeleton_torch", ParticleTypes.FLAME));

        // Decorative blocks

        // Steel
        register(registry, new BlockMod("black_steel", 10.0F, 60.0F, Material.METAL, SoundType.METAL));
        register(registry, new BlockMod("blue_steel", 10.0F, 60.0F, Material.METAL, SoundType.METAL));
        register(registry, new BlockMod("bright_red_steel", 10.0F, 60.0F, Material.METAL, SoundType.METAL));
        register(registry, new BlockMod("green_steel", 10.0F, 60.0F, Material.METAL, SoundType.METAL));
        register(registry, new BlockMod("orange_steel", 10.0F, 60.0F, Material.METAL, SoundType.METAL));
        register(registry, new BlockMod("purple_steel", 10.0F, 60.0F, Material.METAL, SoundType.METAL));
        register(registry, new BlockMod("red_steel", 10.0F, 60.0F, Material.METAL, SoundType.METAL));
        register(registry, new BlockMod("white_steel", 10.0F, 60.0F, Material.METAL, SoundType.METAL));
        register(registry, new BlockMod("yellow_steel", 10.0F, 60.0F, Material.METAL, SoundType.METAL));
        register(registry, new BlockMod("teal_steel", 10.0F, 60.0F, Material.METAL, SoundType.METAL));

        // Vanes
        register(registry, new BlockMod("blue_vane", 2.0F, 10F));
        register(registry, new BlockMod("cyan_vane", 2.0F, 10F));
        register(registry, new BlockMod("purple_vane", 2.0F, 10F));
        register(registry, new BlockMod("red_vane", 2.0F, 10F));
        register(registry, new BlockMod("yellow_vane", 2.0F, 10F));

        // Bricks
        register(registry, new BlockMod("aquatonic_bricks", 3.0F, 30.0F));
        register(registry, new BlockMod("lava_bricks", 3.0F, 30.0F));
        register(registry, new BlockMod("arlemite_bricks", 3.0F, 30.0F));
        register(registry, new BlockMod("darkstone_bricks", 3.0F, 30.0F));
        register(registry, new BlockMod("diamond_bricks", 3.0F, 30.0F));
        register(registry, new BlockMod("gold_bricks", 3.0F, 30.0F));
        register(registry, new BlockMod("green_bricks", 3.0F, 30.0F));
        register(registry, new BlockMod("iron_bricks", 3.0F, 30.0F));
        register(registry, new BlockMod("lapis_lazuli_bricks", 3.0F, 30.0F));
        register(registry, new BlockMod("milk_stone_bricks", 3.0F, 30.0F));
        register(registry, new BlockMod("torridite_bricks", 3.0F, 30.0F));
        register(registry, new BlockMod("pink_bricks", 3.0F, 30.0F));
        register(registry, new BlockMod("purple_bricks", 3.0F, 30.0F));
        register(registry, new BlockMod("realmite_bricks", 3.0F, 30.0F));
        register(registry, new BlockMod("redstone_bricks", 3.0F, 30.0F));
        register(registry, new BlockMod("eden_bricks", 3.0F, 30.0F));
        register(registry, new BlockMod("wildwood_bricks", 3.0F, 30.0F));
        register(registry, new BlockMod("apalachia_bricks", 3.0F, 30.0F));
        register(registry, new BlockMod("skythern_bricks", 3.0F, 30.0F));
        register(registry, new BlockMod("mortum_bricks", 3.0F, 30.0F));

        // Minibricks
        register(registry, new BlockMod("minibricks", 3.0F, 30.0F));
        register(registry, new BlockMod("arlemite_minibricks", 3.0F, 30.0F));
        register(registry, new BlockMod("bedrock_minibricks", 3.0F, 30.0F));
        register(registry, new BlockMod("torridite_minibricks", 3.0F, 30.0F));
        register(registry, new BlockMod("realmite_minibricks", 3.0F, 30.0F));
        register(registry, new BlockMod("bloodgem_minibricks", 3.0F, 30.0F));
        register(registry, new BlockMod("rupee_minibricks", 3.0F, 30.0F));

        // Lamps
        register(registry, new BlockModLamp("aqua_lamp", 0.3F, 30.0F, 15));
        register(registry, new BlockModLamp("arlemite_lamp", 0.3F, 30.0F, 15));
        register(registry, new BlockModLamp("blaze_lamp", 0.3F, 30.0F, 15));
        register(registry, new BlockModLamp("bluefire_lamp", 0.3F, 30.0F, 15));
        register(registry, new BlockModLamp("diamond_lamp", 0.3F, 30.0F, 15));
        register(registry, new BlockModLamp("divine_lamp", 0.3F, 30.0F, 15));
        register(registry, new BlockModLamp("draken_lamp", 0.3F, 30.0F, 15));
        register(registry, new BlockModLamp("eden_lamp", 0.3F, 30.0F, 15));
        register(registry, new BlockModLamp("ender_lamp", 0.3F, 30.0F, 15));
        register(registry, new BlockModLamp("ender_stone_lamp", 0.3F, 30.0F, 15));
        register(registry, new BlockModLamp("gold_lamp", 0.3F, 30.0F, 15));
        register(registry, new BlockModLamp("ice_lamp", 0.3F, 30.0F, 15));
        register(registry, new BlockModLamp("jungle_lamp", 0.3F, 30.0F, 15));
        register(registry, new BlockModLamp("kraken_lamp", 0.3F, 30.0F, 15));
        register(registry, new BlockModLamp("lapis_lazuli_lamp", 0.3F, 30.0F, 15));
        register(registry, new BlockModLamp("lava_lamp", 0.3F, 30.0F, 15));
        register(registry, new BlockModLamp("milky_lamp", 0.3F, 30.0F, 15));
        register(registry, new BlockModLamp("molten_lamp", 0.3F, 30.0F, 15));
        register(registry, new BlockModLamp("torridite_lamp", 0.3F, 30.0F, 15));
        register(registry, new BlockModLamp("realmite_lamp", 0.3F, 30.0F, 15));
        register(registry, new BlockModLamp("redstone_ore_lamp", 0.3F, 30.0F, 15));
        register(registry, new BlockModLamp("rupee_lamp", 0.3F, 30.0F, 15));
        register(registry, new BlockModLamp("terran_lamp", 0.3F, 30.0F, 15));
        // Powered fences
        register(registry, new BlockModFence(MaterialColor.COLOR_BLUE, "blue_fence", false, 0.5F, 0));
        register(registry, new BlockModFence(MaterialColor.COLOR_BLUE, "blue_fence_on", true, 0.5F, 15));
        register(registry, new BlockModFence(MaterialColor.COLOR_GREEN, "green_fence", false, 0.5F, 0));
        register(registry, new BlockModFence(MaterialColor.COLOR_GREEN, "green_fence_on", true, 0.5F, 15));
        register(registry, new BlockModFence(MaterialColor.COLOR_RED, "red_fence", false, 0.5F, 0));
        register(registry, new BlockModFence(MaterialColor.COLOR_RED, "red_fence_on", true, 0.5F, 15));

        // Miscellaneous decorative blocks
        register(registry, new BlockMod("asphalt", 2.0F, 3.0F));
        register(registry, new BlockMod("blue_stone", Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(3.0F, 3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(WOOD_GOLD).sound(SoundType.STONE).lightLevel((p_235464_0_) -> {
            return 1;
        })));
        register(registry, new BlockMod("checker", 0.8F, 3.0F, Material.CLOTH_DECORATION));
        register(registry, new BlockMod("crate", 2.5F, 3.0F, Material.WOOD));
        register(registry, new BlockMod("darkstone", Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(50.0F, 3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(DIAMOND).sound(SoundType.STONE).lightLevel((p_235464_0_) -> {
            return 1;
        })));
        register(registry, new BlockMod("fancy_wool", 0.8F, 3.0F, Material.CLOTH_DECORATION));
        register(registry, new BlockMod("milk_stone", 1.5F, 10.0F));
        register(registry, new BlockMod("plank_design", 2.5F, 3.0F, Material.WOOD));
        register(registry, new BlockMod("rainbow_wool", 0.8F, 3.0F, Material.CLOTH_DECORATION));

        // Spike blocks
        register(registry, new BlockSpike("spike_block", false));
        register(registry, new BlockSpike("hot_spike_block", true));

        // Utility blocks
        register(registry, new BlockAltarOfCorruption("altar_of_corruption"));
        register(registry, new BlockBoneChest("bone_chest"));
        register(registry, new BlockFrostedAllure("frosted_allure"));

        // Divine blocks
        register(registry, new BlockModSapling("divine_sapling", () -> Blocks.GRASS, () -> Blocks.DIRT, new DivineTree()));
        register(registry, new BlockModLog("divine_log", MaterialColor.COLOR_YELLOW));
        register(registry, new BlockModLog("stripped_divine_log", MaterialColor.COLOR_YELLOW));
        register(registry, new BlockModLeaves("divine_leaves", MaterialColor.COLOR_YELLOW, 0.3F));
        Block divinePlanks = new BlockMod("divine_planks", 2.0F, 3.0F, Material.WOOD);
        register(registry, divinePlanks);
        register(registry, new BlockModStairs("divine_stairs", divinePlanks));
        register(registry, new BlockMod("divine_moss_stone", 2.0F, 10.0F));
        register(registry, new BlockMod("divine_rock", 1.5F, 10.0F));

        // Miscellaneous utility
        register(registry, new BlockModLight("slime_light", 1.5F));
        register(registry, new BlockModBridge("dark_bridge", 1.5F));

        // Crops
        register(registry, new BlockTomatoPlant());
        register(registry, new BlockWhiteMushroomPlant());

        // Boss statues
        register(registry, new BlockStatue("ancient_entity_statue", StatueType.ANCIENT_ENTITY_STATUE, SoundEvents.IRON_GOLEM_DEATH));
        register(registry, new BlockStatue("ayeraco_statue_blue", StatueType.BLUE_AYERACO_STATUE, SoundRegistry.AYERACO));
        register(registry, new BlockStatue("ayeraco_statue_red", StatueType.RED_AYERACO_STATUE, SoundRegistry.AYERACO));
        register(registry, new BlockStatue("ayeraco_statue_yellow", StatueType.YELLOW_AYERACO_STATUE, SoundRegistry.AYERACO));
        register(registry, new BlockStatue("ayeraco_statue_green", StatueType.GREEN_AYERACO_STATUE, SoundRegistry.AYERACO));
        register(registry, new BlockStatue("ayeraco_statue_purple", StatueType.PURPLE_AYERACO_STATUE, SoundRegistry.AYERACO));
        register(registry, new BlockStatue("densos_statue", StatueType.DENSOS_STATUE, SoundRegistry.DENSOS));
        register(registry, new BlockStatue("dramix_statue", StatueType.DRAMIX_STATUE, SoundRegistry.DRAMIX));
        register(registry, new BlockStatue("eternal_archer_statue", StatueType.ETERNAL_ARCHER_STATUE, SoundRegistry.ARCHER));
        register(registry, new BlockStatue("karot_statue", StatueType.KAROT_STATUE, null));
        register(registry, new BlockStatue("king_of_scorchers_statue", StatueType.KING_OF_SCORCHERS_STATUE, SoundRegistry.KING_OF_SCORCHERS));
        register(registry, new BlockStatue("parasecta_statue", StatueType.PARASECTA_STATUE, SoundRegistry.PARASECTA));
        register(registry, new BlockStatue("reyvor_statue", StatueType.REYVOR_STATUE, SoundRegistry.REYVOR));
        register(registry, new BlockStatue("soul_fiend_statue", StatueType.SOUL_FIEND_STATUE, null));
        register(registry, new BlockStatue("the_watcher_statue", StatueType.THE_WATCHER_STATUE, SoundRegistry.ROAR));
        register(registry, new BlockStatue("twilight_demon_statue", StatueType.TWILIGHT_DEMON_STATUE, SoundRegistry.INSECT));
        register(registry, new BlockStatue("vamacheron_statue", StatueType.VAMACHERON_STATUE, null));
        register(registry, new BlockStatue("termasect_statue", StatueType.TERMASECT_STATUE, SoundEvents.WOOD_STEP));
        register(registry, new BlockStatue("sunstorm_statue", StatueType.SUNSTORM_STATUE, SoundRegistry.SPARKLER));
        register(registry, new BlockStatue("experienced_cori_statue", StatueType.EXPERIENCED_CORI_STATUE, SoundRegistry.CORI));

        // Ayeraco technical blocks
        registerItemlessBlock(registry, new BlockAyeracoBeam("ayeraco_beam_blue", "blue"));
        registerItemlessBlock(registry, new BlockAyeracoBeam("ayeraco_beam_green", "green"));
        registerItemlessBlock(registry, new BlockAyeracoBeam("ayeraco_beam_purple", "purple"));
        registerItemlessBlock(registry, new BlockAyeracoBeam("ayeraco_beam_red", "red"));
        registerItemlessBlock(registry, new BlockAyeracoBeam("ayeraco_beam_yellow", "yellow"));
        registerItemlessBlock(registry, new BlockAyeracoSpawn());

        // Liquid
        registerFluidBlock(registry, new FlowingFluidBlock(() -> FluidRegistry.TAR.get(), AbstractBlock.Properties.copy(Blocks.LAVA).randomTicks().strength(100.0F).noDrops()), "smoldering_tar");

        // Iceika

        // Terrain
        register(registry, new BlockModDirt("frozen_dirt", 0.5F, MaterialColor.TERRACOTTA_WHITE));
        register(registry, new BlockModGrass("frozen_grass", () -> BlockRegistry.frozenDirt, 1, MaterialColor.COLOR_LIGHT_BLUE));
        register(registry, new BlockMod("frozen_stone", 6.0F, 3.0F));
        register(registry, new BlockModLog("frozen_log", MaterialColor.TERRACOTTA_WHITE));
        register(registry, new BlockModLog("stripped_frozen_log", MaterialColor.TERRACOTTA_WHITE));
        register(registry, new BlockModLeaves("brittle_leaves", MaterialColor.TERRACOTTA_WHITE, 10));
        Block frozenPlanks = new BlockMod("frozen_planks", 2.0F, 3.0F, Material.WOOD);
        register(registry, frozenPlanks);
        register(registry, new BlockModStairs("frozen_stairs", frozenPlanks));
        register(registry, new BlockModSapling("frozen_sapling", () -> frozenGrass, () -> frozenDirt, new FrozenTree()));

        // Structure blocks
        Block coalstone = new BlockMod("coalstone", 3.0F, 3.0F);
        register(registry, coalstone);
        register(registry, new BlockModStairs("coalstone_stairs", coalstone));
        register(registry, new BlockCoalstoneFurnace("coalstone_furnace"));
        register(registry, new BlockModSpawner("frost_archer_spawner", EntityRegistry.FROST_ARCHER));
        register(registry, new BlockFrostedChest("frosted_chest"));
        register(registry, new BlockModGlass("frosted_glass", 1.0F));
        register(registry, new BlockMod("icy_bricks", 1.5F, 3.0F));
        register(registry, new BlockMod("icy_stone", 2.0F, 3.0F));
        register(registry, new BlockModSpawner("rollum_spawner", EntityRegistry.ROLLUM));
        register(registry, new BlockMod("snow_bricks", 6.0F, 3.0F));
        register(registry, new BlockModDoor("steel_door", Material.METAL, 7.0F, () -> steelDoor.asItem()));
        register(registry, new BlockModBookshelf("workshop_bookcase", 1.5F, Material.STONE));
        register(registry, new BlockMod("workshop_carpet", 0.1F, 3.0F, Material.CLOTH_DECORATION));
        register(registry, new BlockModLamp("workshop_lamp", 0.3F, 3.0F, 15));

        // Candy canes
        register(registry, new BlockMod("blue_candy_cane", Block.Properties.of(Material.STONE).strength(1.0F, 1.0F).requiresCorrectToolForDrops()));
        register(registry, new BlockMod("green_candy_cane", Block.Properties.of(Material.STONE).strength(1.0F, 1.0F).requiresCorrectToolForDrops()));
        register(registry, new BlockMod("pink_candy_cane", Block.Properties.of(Material.STONE).strength(1.0F, 1.0F).requiresCorrectToolForDrops()));
        register(registry, new BlockMod("red_candy_cane", Block.Properties.of(Material.STONE).strength(1.0F, 1.0F).requiresCorrectToolForDrops()));
        register(registry, new BlockMod("yellow_candy_cane", Block.Properties.of(Material.STONE).strength(1.0F, 1.0F).requiresCorrectToolForDrops()));

        // Christmas lights
        register(registry, new BlockLights("blue_christmas_lights"));
        register(registry, new BlockLights("green_christmas_lights"));
        register(registry, new BlockLights("purple_christmas_lights"));
        register(registry, new BlockLights("red_christmas_lights"));
        register(registry, new BlockLights("yellow_christmas_lights"));

        // Chest
        register(registry, new BlockPresentBox("present_box"));

        // Crops
        register(registry, new BlockWinterberryBush("winterberry_bush"));

        // Other
        register(registry, new BlockModFire("iceika_fire"));

        // Twilight dimensions

        // Dirt
        register(registry, new BlockModDirt("eden_dirt", 0.5F, MaterialColor.COLOR_YELLOW));
        register(registry, new BlockModDirt("wildwood_dirt", 0.5F, MaterialColor.COLOR_BLUE));
        register(registry, new BlockModDirt("apalachia_dirt", 0.5F, MaterialColor.COLOR_PURPLE));
        register(registry, new BlockModDirt("skythern_dirt", 0.5F, MaterialColor.COLOR_GRAY));
        register(registry, new BlockModDirt("mortum_dirt", 0.5F, MaterialColor.COLOR_BLACK));

        // Grass
        register(registry, new BlockModGrass("eden_grass", () -> edenDirt, 0.6F, MaterialColor.COLOR_YELLOW));
        register(registry, new BlockModGrass("wildwood_grass", () -> wildwoodDirt, 0.6F, MaterialColor.COLOR_BLUE));
        register(registry, new BlockModGrass("apalachia_grass", () -> apalachiaDirt, 0.6F, MaterialColor.COLOR_PURPLE));
        register(registry, new BlockModGrass("skythern_grass", () -> skythernDirt, 0.6F, MaterialColor.COLOR_LIGHT_GRAY));
        register(registry, new BlockModGrass("mortum_grass", () -> mortumDirt, 0.6F, MaterialColor.COLOR_BLACK));

        // Stone
        register(registry, new BlockMod("twilight_stone", 6.0F, 3.0F));

        // Ore
        register(registry, new BlockMod("eden_ore", Block.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().harvestLevel(DIAMOND).harvestTool(ToolType.PICKAXE).strength(5.0F, 2000.0F).sound(SoundType.STONE)));
        register(registry, new BlockMod("wildwood_ore", Block.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().harvestLevel(EDEN).harvestTool(ToolType.PICKAXE).strength(6.0F, 2000.0F).sound(SoundType.STONE)));
        register(registry, new BlockMod("apalachia_ore", Block.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().harvestLevel(WILDWOOD).harvestTool(ToolType.PICKAXE).strength(7.0F, 2000.0F).sound(SoundType.STONE)));
        register(registry, new BlockMod("skythern_ore", Block.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().harvestLevel(APALACHIA).harvestTool(ToolType.PICKAXE).strength(8.0F, 2000.0F).sound(SoundType.STONE)));
        register(registry, new BlockMod("mortum_ore", Block.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().harvestLevel(SKYTHERN).harvestTool(ToolType.PICKAXE).strength(9.0F, 2000.0F).sound(SoundType.STONE)));

        // Sapling
        register(registry, new BlockModSapling("eden_sapling", () -> edenGrass, () -> edenDirt, new EdenTree()));
        register(registry, new BlockModSapling("wildwood_sapling", () -> wildwoodGrass, () -> wildwoodDirt, new WildwoodTree()));
        register(registry, new BlockModSapling("apalachia_sapling", () -> apalachiaGrass, () -> apalachiaDirt, new ApalachiaTree()));
        register(registry, new BlockModSapling("skythern_sapling", () -> skythernGrass, () -> skythernDirt, new SkythernTree()));
        register(registry, new BlockModSapling("mortum_sapling", () -> mortumGrass, () -> mortumDirt, new MortumTree()));

        // Logs
        register(registry, new BlockModLog("eden_log", MaterialColor.COLOR_YELLOW));
        register(registry, new BlockModLog("wildwood_log", MaterialColor.COLOR_BLUE));
        register(registry, new BlockModLog("apalachia_log", MaterialColor.COLOR_PURPLE));
        register(registry, new BlockModLog("skythern_log", MaterialColor.COLOR_GRAY));
        register(registry, new BlockModLog("mortum_log", MaterialColor.COLOR_RED));

        // Stripped Logs
        register(registry, new BlockModLog("stripped_eden_log", MaterialColor.COLOR_YELLOW));
        register(registry, new BlockModLog("stripped_wildwood_log", MaterialColor.COLOR_BLUE));
        register(registry, new BlockModLog("stripped_apalachia_log", MaterialColor.COLOR_PURPLE));
        register(registry, new BlockModLog("stripped_skythern_log", MaterialColor.COLOR_GRAY));
        register(registry, new BlockModLog("stripped_mortum_log", MaterialColor.COLOR_RED));

        // Leaves
        register(registry, new BlockModLeaves("eden_leaves", MaterialColor.COLOR_YELLOW, 0.5F));
        register(registry, new BlockModLeaves("wildwood_leaves", MaterialColor.COLOR_LIGHT_BLUE, 0.5F));
        register(registry, new BlockModLeaves("apalachia_leaves", MaterialColor.COLOR_PINK, 0.5F));
        register(registry, new BlockModLeaves("skythern_leaves", MaterialColor.TERRACOTTA_WHITE, 0.5F));
        register(registry, new BlockModLeaves("mortum_leaves", MaterialColor.COLOR_RED, 0.5F));

        // Planks
        Block edenPlanks = new BlockMod("eden_planks", 2.0F, 3.0F, Material.WOOD);
        Block wildwoodPlanks = new BlockMod("wildwood_planks", 2.0F, 3.0F, Material.WOOD);
        Block apalachiaPlanks = new BlockMod("apalachia_planks", 2.0F, 3.0F, Material.WOOD);
        Block skythernPlanks = new BlockMod("skythern_planks", 2.0F, 3.0F, Material.WOOD);
        Block mortumPlanks = new BlockMod("mortum_planks", 2.0F, 3.0F, Material.WOOD);

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
        register(registry, new BlockMod("eden_block", 9.0F));
        register(registry, new BlockMod("wildwood_block", 9.0F));
        register(registry, new BlockMod("apalachia_block", 9.0F));
        register(registry, new BlockMod("skythern_block", 9.0F));
        register(registry, new BlockMod("mortum_block", 9.0F));

        // Twilight dimension ground foliage
        // Eden
        register(registry, new BlockTwilightFlower("sun_blossom", () -> edenGrass, 0.9, 0.6, MaterialColor.COLOR_YELLOW));
        register(registry, new BlockTwilightFlower("sunbloom", () -> edenGrass, MaterialColor.COLOR_YELLOW));
        register(registry, new BlockTwilightGrass("eden_brush", () -> edenGrass, MaterialColor.COLOR_YELLOW));

        // Wildwood
        register(registry, new BlockTwilightFlower("moon_bud", () -> wildwoodGrass, 0.8, 0.7, MaterialColor.COLOR_BLUE));
        register(registry, new BlockTwilightFlower("moonlight_fern", () -> wildwoodGrass, 0.8, 0.8, MaterialColor.COLOR_BLUE));
        register(registry, new BlockModDoublePlant("wildwood_tallgrass", () -> wildwoodGrass, MaterialColor.COLOR_BLUE));

        // Apalachia
        register(registry, new BlockTwilightFlower("dusk_bloom", () -> apalachiaGrass, 0.5, 0.5, MaterialColor.COLOR_PURPLE));
        register(registry, new BlockModDoublePlant("dusk_flower", () -> apalachiaGrass, MaterialColor.COLOR_PURPLE));
        register(registry, new BlockTwilightGrass("apalachia_tallgrass", () -> apalachiaGrass, MaterialColor.COLOR_PURPLE));

        // Skythern
        register(registry, new BlockBrambles("dust_brambles", () -> skythernGrass, MaterialColor.COLOR_GRAY));
        register(registry, new BlockTwilightFlower("dust_lily", () -> skythernGrass, MaterialColor.COLOR_GRAY));
        register(registry, new BlockTwilightGrass("skythern_brush", () -> skythernGrass, MaterialColor.COLOR_GRAY));

        // Mortum
        register(registry, new BlockBrambles("demon_brambles", () -> mortumGrass, MaterialColor.COLOR_BLACK));
        register(registry, new BlockTwilightFlower("eye_plant", () -> mortumGrass, 0.5, 0.5, MaterialColor.COLOR_BLACK));
        register(registry, new BlockTwilightGrass("mortum_brush", () -> mortumGrass, MaterialColor.COLOR_BLACK));

        // Crops
        register(registry, new BlockMoonbulb());
        register(registry, new BlockPinkGlowbone());
        register(registry, new BlockPurpleGlowbone());
        register(registry, new BlockSkyPlant());

        // Vine
        register(registry, new BlockModVine("wildwood_vine"));

        // Other
        register(registry, new BlockModFire("blue_fire"));
        registerItemlessBlock(registry, new BlockModTorch("eden_torch", ParticleTypes.FLAME));
        registerItemlessBlock(registry, new BlockModWallTorch("eden_wall_torch", ParticleTypes.FLAME));
        register(registry, new BlockEdenChest("eden_chest"));
        register(registry, new BlockMod("truffle", 1.0F, 3.0F, Material.PLANT));

        // Arcana

        // Dirt
        register(registry, new BlockModDirt("arcanite_dirt", 0.5F, MaterialColor.COLOR_BLUE));

        // Grass
        register(registry, new BlockArcaniteGrass("arcanite_grass", 0.6F));

        // Ore
        register(registry, new BlockMod("raw_arcanium", Block.Properties.of(Material.DIRT, MaterialColor.LAPIS).requiresCorrectToolForDrops().strength(2.0F, 3.0F).sound(SoundType.STONE).harvestTool(ToolType.SHOVEL).harvestLevel(3)));

        // Storage block
        register(registry, new BlockMod("arcanium_block", 5.0F));

        // Structure blocks
        // Normal
        Block ancientBricks = new BlockModUnbreakable("ancient_bricks");
        register(registry, ancientBricks);
        register(registry, new BlockModStairs("ancient_brick_stairs", ancientBricks));
        register(registry, new BlockModUnbreakable("ancient_stone"));
        register(registry, new BlockModUnbreakable("ancient_tile"));
        register(registry, new BlockModLadder("arcanite_tubes"));
        register(registry, new BlockModLadder("arcanite_ladder"));
        register(registry, new BlockModPillar("arcanium_metal", Material.METAL, -1F, 6000000F, SoundType.METAL));
        register(registry, new BlockModUnbreakable("arcanium_power"));
        register(registry, new BlockModUnbreakable("dark_degraded_brick"));
        Block degradedBricks = new BlockModUnbreakable("degraded_bricks");
        register(registry, degradedBricks);
        register(registry, new BlockModStairs("degraded_brick_stairs", ancientBricks));
        register(registry, new BlockModBookshelf("dungeon_bookshelf", 1.5F, Material.STONE));
        register(registry, new BlockModUnbreakable("dungeon_lamp", true));
        register(registry, new BlockHeatTrap("heat_trap"));
        register(registry, new BlockModUnbreakable("light_degraded_brick"));
        register(registry, new BlockModUnbreakable("soul_sludge"));
        register(registry, new BlockModUnbreakable("soul_stone"));

        // Breakable
        Block ancientBricksBreakable = new BlockMod("ancient_bricks_breakable", 2.0F, 3.0F);
        register(registry, ancientBricksBreakable);
        register(registry, new BlockModStairs("ancient_brick_stairs_breakable", ancientBricksBreakable));
        register(registry, new BlockModSlab("ancient_brick_slab_breakable", ancientBricksBreakable, 2.0F));
        register(registry, new BlockModWall("ancient_brick_wall_breakable", ancientBricksBreakable, 2.0F));
        register(registry, new BlockMod("ancient_stone_breakable", 2.0F, 3.0F));
        register(registry, new BlockMod("ancient_tile_breakable", 2.0F, 3.0F));
        register(registry, new BlockModPillar("arcanium_metal_breakable", Material.METAL, 2.0F, 3.0F, SoundType.METAL));
        register(registry, new BlockMod("arcanium_power_breakable", 2.0F, 3.0F));
        Block degradedBricksBreakable = new BlockMod("degraded_bricks_breakable", 2.0F, 3.0F);
        register(registry, degradedBricksBreakable);
        register(registry, new BlockModStairs("degraded_brick_stairs_breakable", degradedBricksBreakable));
        register(registry, new BlockModSlab("degraded_brick_slab_breakable", degradedBricksBreakable, 2.0F));
        register(registry, new BlockModWall("degraded_brick_wall_breakable", degradedBricksBreakable, 2.0F));
        register(registry, new BlockMod("dungeon_lamp_breakable", Block.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().strength(1, 3.0F).sound(SoundType.STONE).lightLevel((p_235464_0_) -> {
            return 15;
        })));
        register(registry, new BlockMod("soul_sludge_breakable", 2.0F, 3.0F));
        register(registry, new BlockMod("soul_stone_breakable", 2.0F, 3.0F));

        // Door
        register(registry, new BlockArcanaDoor("ancient_brick_door", () -> ItemRegistry.ancientKey));
        register(registry, new BlockArcanaDoor("degraded_brick_door", () -> ItemRegistry.degradedKey));
        register(registry, new BlockArcanaDoor("soul_sludge_door", () -> ItemRegistry.sludgeKey));
        register(registry, new BlockArcanaDoor("soul_stone_door", () -> ItemRegistry.soulKey));

        // Utility
        register(registry, new BlockArcaniumExtractor("arcanium_extractor"));

        // Boss altars
        register(registry, new BlockModAltar("dramix_altar"));
        register(registry, new BlockModAltar("parasecta_altar"));

        // Stained glass
        register(registry, new BlockModGlass("stained_glass", 0.3F));
        register(registry, new BlockModGlass("stained_glass2", 0.3F));
        register(registry, new BlockModGlass("stained_glass3", 0.3F));
        register(registry, new BlockModGlass("stained_glass4", 0.3F));
        register(registry, new BlockModGlass("stained_glass5", 0.3F));
        register(registry, new BlockModGlass("stained_glass6", 0.3F));
        register(registry, new BlockModGlass("stained_glass7", 0.3F));
        register(registry, new BlockModGlass("stained_glass8", 0.3F));

        // Eucalyptus
        register(registry, new BlockModLog("eucalyptus_log", MaterialColor.COLOR_PINK));
        register(registry, new BlockModLog("stripped_eucalyptus_log", MaterialColor.COLOR_PINK));
        Block eucalyptusPlanks = new BlockMod("eucalyptus_planks", 2.0F, 3.0F, Material.WOOD);
        register(registry, eucalyptusPlanks);
        register(registry, new BlockModStairs("eucalyptus_stairs", eucalyptusPlanks));

        // Crops
        register(registry, new BlockModCrop("aquamarine_plant", 3, ItemRegistry.aquamarineSeeds));
        register(registry, new BlockModCrop("eucalyptus_plant", 3, ItemRegistry.eucalyptusRootSeeds));
        register(registry, new BlockFirestock());
        register(registry, new BlockModCrop("hitchak_plant", 3, ItemRegistry.hitchakSeeds));
        register(registry, new BlockModCrop("lamona_plant", 3, ItemRegistry.lamonaSeeds));
        register(registry, new BlockModCrop("marsine_plant", 2, ItemRegistry.marsineSeeds));
        register(registry, new BlockPinfly());
        register(registry, new BlockModCrop("veilo_plant", 3, ItemRegistry.veiloSeeds));

        // Furnace
        register(registry, new BlockGreenlightFurnace("greenlight_furnace"));
        register(registry, new BlockOceanfireFurnace("oceanfire_furnace"));
        register(registry, new BlockMoltenFurnace("molten_furnace"));
        register(registry, new BlockWhitefireFurnace("whitefire_furnace"));
        register(registry, new BlockMoonlightFurnace("moonlight_furnace"));
        register(registry, new BlockDemonFurnace("demon_furnace"));

        // Miscellaneous utility
        register(registry, new BlockAcceleron("acceleron"), false, true);
        registerItemlessBlock(registry, new BlockModTorch("arcanium_torch", ParticleTypes.FLAME));
        registerItemlessBlock(registry, new BlockModWallTorch("arcanium_wall_torch", ParticleTypes.FLAME));
        register(registry, new BlockElevantium("elevantium"), false, true);
        register(registry, new BlockModBridge("star_bridge", 1.5F));

        register(registry, new BlockSingleMobSpawnerSpawner("captain_merik_spawner", EntityRegistry.CAPTAIN_MERIK));
        register(registry, new BlockSingleMobSpawnerSpawner("datticon_spawner", EntityRegistry.DATTICON));
        register(registry, new BlockSingleMobSpawnerSpawner("kazari_spawner", EntityRegistry.KAZARI));
        register(registry, new BlockSingleMobSpawnerSpawner("leorna_spawner", EntityRegistry.LEORNA));
        register(registry, new BlockSingleMobSpawnerSpawner("lord_vatticus_spawner", EntityRegistry.LORD_VATTICUS));
        register(registry, new BlockSingleMobSpawnerSpawner("war_general_spawner", EntityRegistry.WAR_GENERAL));
        register(registry, new BlockSingleMobSpawnerSpawner("zelus_spawner", EntityRegistry.ZELUS));

        // Vethea

        // Terrain
        register(registry, new BlockModDirt("dream_dirt", 0.5F, MaterialColor.COLOR_LIGHT_GREEN), true);
        register(registry, new BlockDreamGrass("dream_grass", 0.6F), true);
        register(registry, new BlockMod("dream_stone", 1.5F), true);

        // Logs
        register(registry, new BlockModLog("dreamwood_log", MaterialColor.COLOR_LIGHT_BLUE), true);
        register(registry, new BlockModLog("firewood_log", MaterialColor.COLOR_RED), true);
        register(registry, new BlockModLog("hyrewood_log", MaterialColor.COLOR_BLUE), true);
        register(registry, new BlockModLog("mintwood_log", MaterialColor.COLOR_LIGHT_BLUE), true);

        // Stripped Logs
        register(registry, new BlockModLog("stripped_dreamwood_log", MaterialColor.COLOR_LIGHT_BLUE), true);
        register(registry, new BlockModLog("stripped_firewood_log", MaterialColor.COLOR_RED), true);
        register(registry, new BlockModLog("stripped_hyrewood_log", MaterialColor.COLOR_BLUE), true);
        register(registry, new BlockModLog("stripped_mintwood_log", MaterialColor.COLOR_LIGHT_BLUE), true);

        // Leaves
        register(registry, new BlockModLeaves("dreamwood_leaves", MaterialColor.COLOR_RED, 0.1F), true);
        register(registry, new BlockModLeaves("firewood_leaves", MaterialColor.COLOR_RED, 0.1F), true);
        register(registry, new BlockModLeaves("hyrewood_leaves", MaterialColor.COLOR_RED, 0.1F), true);
        register(registry, new BlockModLeaves("mintwood_leaves", MaterialColor.COLOR_RED, 0.1F), true);

        // Ground foliage
        register(registry, new BlockTwilightFlower("bulbatobe", () -> dreamGrass, MaterialColor.COLOR_GREEN), true);
        register(registry, new BlockTwilightFlower("cracklespike", () -> dreamGrass, MaterialColor.COLOR_GREEN), true);
        register(registry, new BlockTwilightFlower("dreamglow", () -> dreamGrass, MaterialColor.COLOR_GREEN), true);
        register(registry, new BlockTwilightFlower("fernite", () -> dreamGrass, MaterialColor.COLOR_GREEN), true);
        register(registry, new BlockTwilightFlower("green_dulah", () -> dreamGrass, MaterialColor.COLOR_GREEN), true);
        register(registry, new BlockTwilightFlower("green_gemtop", () -> dreamGrass, MaterialColor.COLOR_GREEN), true);
        register(registry, new BlockTwilightFlower("purple_gemtop", () -> dreamGrass, MaterialColor.COLOR_GREEN), true);
        register(registry, new BlockTwilightFlower("shimmer", () -> dreamGrass, MaterialColor.COLOR_GREEN), true);
        register(registry, new BlockTwilightFlower("shine_grass", () -> dreamGrass, MaterialColor.COLOR_GREEN), true);
        register(registry, new BlockTwilightFlower("yellow_dulah", () -> dreamGrass, MaterialColor.COLOR_GREEN), true);

        // Vines
        register(registry, new BlockModVine("weedwood_vine"), true);
        register(registry, new BlockModVine("blossomed_weedwood_vine"), true);

        // Building blocks
        register(registry, new BlockMod("dark_dream_bricks", 1.0F, 3.0F), true);
        register(registry, new BlockMod("light_dream_bricks", 1.0F, 3.0F), true);
        register(registry, new BlockMod("red_dream_bricks", 1.0F, 3.0F), true);
        register(registry, new BlockModGlass("smooth_glass", 0.3F), true);

        // Door
        register(registry, new BlockModDoor("barred_door", Material.HEAVY_METAL, 2.0f, 1.0F, ToolType.PICKAXE));

        // Lighting
        register(registry, new BlockLightCrystal("fire_crystal", 1.0F), true);
        register(registry, new BlockLightCrystal("firelight", 1.0F), true);

        // Structure
        // General
        register(registry, new BlockDreamLamp("dream_lamp"), true);
        register(registry, new BlockModUnbreakable("everstone"), true);
        register(registry, new BlockModUnbreakable("dark_everstone"), true);
        register(registry, new BlockModUnbreakable("white_everstone"), true);

        // Crypt
        register(registry, new BlockModUnbreakable("black_hungerstone"), true);
        register(registry, new BlockModUnbreakable("green_hungerstone"), true);
        register(registry, new BlockModUnbreakable("crypt_floor"), true);
        register(registry, new BlockMod("crypt_wall", 1.0F, 3.0F), true);
        register(registry, new BlockModGlass("metal_caging", 1.0F), true);

        // Village
        register(registry, new BlockModLamp("village_lamp", 1.0F, 3.0F, 15), true);

        // Hive
        register(registry, new BlockModLamp("cell_lamp", 1.0F, 3.0F, 15), true);
        register(registry, new BlockMod("hive_wall", Block.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().strength(1.0F, 3.0F).sound(SoundType.GLASS).lightLevel((p_235464_0_) -> {
            return 7;
        })), true);

        // Karos Madhouse
        register(registry, new BlockModUnbreakable("black_karos_bricks"), true);
        register(registry, new BlockModUnbreakable("blue_karos_bricks"), true);
        register(registry, new BlockHelioticBeam("heliotic_beam"), true);
        register(registry, new BlockKarosDispenser("karos_dispenser"), true);
        register(registry, new BlockKarosHeatTile("karos_heat_tile_green"), true);
        register(registry, new BlockKarosHeatTile("karos_heat_tile_red"), true);

        // Lunic Garden
        register(registry, new BlockMod("luna_bricks", 1.0F), true);
        register(registry, new BlockMod("luna_stone", 1.0F), true);

        // Raglok Chamber
        register(registry, new BlockModUnbreakable("chamber_wall"), true);
        register(registry, new BlockModUnbreakable("shifted_chamber_wall"), true);
        register(registry, new BlockModUnbreakable("stacked_chamber_wall"), true);

        // Wreck Hall
        register(registry, new BlockModUnbreakable("hall_wall"), true);

        // Utility
        register(registry, new BlockInfusionTable("infusion_table"), true);

        // Hive egg
        register(registry, new BlockHiveEgg("hive_egg"), true);

        // Boss altars
        register(registry, new BlockKarosAltar("karos_altar"), true);
        register(registry, new BlockLunicAltar("lunic_altar"), true);
        register(registry, new BlockQuadroticAltar("quadrotic_altar"), true);
        register(registry, new BlockRaglokAltar("raglok_altar"), true);
        register(registry, new BlockWreckAltar("wreck_altar"), true);

        // Mob spawners

        register(registry, new BlockModSpawner("biphron_spawner", EntityRegistry.BIPHRON), true);
        register(registry, new BlockModSpawner("dreamwrecker_spawner", EntityRegistry.DREAMWRECKER), true);
        register(registry, new BlockModSpawner("gorgosion_spawner", EntityRegistry.GORGOSION), true);
        register(registry, new BlockModSpawner("twins_spawner", EntityRegistry.TWINS), true);
        register(registry, new BlockModSpawner("vermenous_spawner", EntityRegistry.VERMENOUS), true);

        // Acid
        register(registry, new BlockAcid("acid_block", true), true);
        register(registry, new BlockAcid("bacterial_acid", false), true);
        register(registry, new BlockAcid("lunic_acid", true), true);

        // Nightmare bed
        registerItemlessBlock(registry, new BlockNightmareBed());

        // Portal blocks
        // Portal
        register(registry, new BlockModPortal("iceika_portal", Blocks.SNOW_BLOCK));
        register(registry, new BlockModPortal("eden_portal", BlockRegistry.divineRock));
        register(registry, new BlockModPortal("wildwood_portal", BlockRegistry.edenBlock));
        register(registry, new BlockModPortal("apalachia_portal", BlockRegistry.wildwoodBlock));
        register(registry, new BlockModPortal("skythern_portal", BlockRegistry.apalachiaBlock));
        register(registry, new BlockModPortal("mortum_portal", BlockRegistry.skythernBlock));
        register(registry, new BlockModPortal("vethea_portal", BlockRegistry.mortumBlock));

        // Arcana blocks
        register(registry, new BlockArcanaPortal("arcana_portal"));
        register(registry, new BlockArcanaPortalFrame("arcana_portal_frame", AbstractBlock.Properties.of(Material.STONE).strength(5.0F)));
        register(registry, new BlockArcanaPortalFrame("arcana_hard_portal_frame", AbstractBlock.Properties.of(Material.STONE).strength(5.0F).strength(-1, 6000000F)));

        //Slabs
        register(registry, new BlockModSlab("eden_slab", edenPlanks, 2.0F));
        register(registry, new BlockModSlab("wildwood_slab", wildwoodPlanks, 2.0F));
        register(registry, new BlockModSlab("apalachia_slab", apalachiaPlanks, 2.0F));
        register(registry, new BlockModSlab("skythern_slab", skythernPlanks, 2.0F));
        register(registry, new BlockModSlab("mortum_slab", mortumPlanks, 2.0F));
        register(registry, new BlockModSlab("divine_slab", divinePlanks, 2.0F));
        register(registry, new BlockModSlab("frozen_slab", frozenPlanks, 2.0F));
        register(registry, new BlockModSlab("eucalyptus_slab", eucalyptusPlanks, 2.0F));
        register(registry, new BlockModSlab("ancient_brick_slab", ancientBricks, -1F));
        register(registry, new BlockModSlab("degraded_brick_slab", degradedBricks, -1F));

        //Walls
        register(registry, new BlockModWall("ancient_brick_wall", ancientBricks, -1F));
        register(registry, new BlockModWall("degraded_brick_wall", degradedBricks, -1F));

        //Spawners
        register(registry, new BlockSingleMobSpawnerSpawner("hunger_spawner_ls", EntityRegistry.THE_HUNGER));
        register(registry, new BlockSingleMobSpawnerSpawner("hunger_spawner_sg", EntityRegistry.THE_HUNGER));

        //Sructure Air
        registerItemlessBlock(registry, new BlockModStructureAir());
    }

    private static void register(RegistryEvent.Register<Block> event, Block block) {
        event.getRegistry().register(block);

        if(block != BlockRegistry.arcanaHardPortalFrame) {
            blocks.add(block);
        }
    }

    private static void register(RegistryEvent.Register<Block> event, Block block, boolean vethean) {
        event.getRegistry().register(block);
        vethea.add(block);
    }

    private static void register(RegistryEvent.Register<Block> event, Block block, boolean vethean, boolean util) {
        event.getRegistry().register(block);
        utilities.add(block);
    }

    @SubscribeEvent
    public static void registerBlockItems(final RegistryEvent.Register<Item> registry) {
        Item.Properties properties = new Item.Properties().tab(DivineRPG.tabs.blocks);
        for (Block block : blocks) {

            Item itemBlock = new ItemModItemBlock(block, properties).setRegistryName(block.getRegistryName());
            if (!itemBlock.equals(Item.byBlock(Blocks.AIR))) {
                ItemRegistry.itemMap.put(itemBlock.getRegistryName().getPath(), itemBlock);
            }

            if (block instanceof BlockStatue) {
                Item statue = new ItemModItemBlock(block, new Item.Properties().tab(DivineRPG.tabs.blocks).setISTER(() -> new RenderItemStatue())).setRegistryName(block.getRegistryName());
                registry.getRegistry().register(statue);
            }else if (block instanceof BlockDemonFurnace) {
                Item demonFurnace = new ItemModItemBlock(block, new Item.Properties().tab(DivineRPG.tabs.blocks).setISTER(() -> new RenderDemonFurnaceItem())).setRegistryName(block.getRegistryName());
                registry.getRegistry().register(demonFurnace);
            }else if (block instanceof BlockArcaniumExtractor) {
                Item arcanium = new ItemModItemBlock(block, new Item.Properties().tab(DivineRPG.tabs.blocks).setISTER(() -> new RenderArcaniumExtractorItem())).setRegistryName(block.getRegistryName());
                registry.getRegistry().register(arcanium);
            }else if (block instanceof BlockEdenChest) {
                Item edenChest = new ItemModItemBlock(block, new Item.Properties().tab(DivineRPG.tabs.blocks).setISTER(() -> new RenderEdenChestItem())).setRegistryName(block.getRegistryName());
                registry.getRegistry().register(edenChest);
            }else if (block instanceof BlockBoneChest) {
                Item chest = new ItemModItemBlock(block, new Item.Properties().tab(DivineRPG.tabs.blocks).setISTER(() -> new RenderBoneChestItem())).setRegistryName(block.getRegistryName());
                registry.getRegistry().register(chest);
            }else if (block instanceof BlockModAltar) {
                if(block == dramixAltar) {
                    Item altar = new ItemModItemBlock(block, new Item.Properties().tab(DivineRPG.tabs.blocks).setISTER(() -> new RenderDramixAltarItem())).setRegistryName(block.getRegistryName());
                    registry.getRegistry().register(altar);
                }
                if(block == parasectaAltar) {
                    Item altar = new ItemModItemBlock(block, new Item.Properties().tab(DivineRPG.tabs.blocks).setISTER(() -> new RenderParasectaAltarItem())).setRegistryName(block.getRegistryName());
                    registry.getRegistry().register(altar);}
            }else if (block instanceof BlockFrostedChest) {
                Item chest = new ItemModItemBlock(block, new Item.Properties().tab(DivineRPG.tabs.blocks).setISTER(() -> new RenderFrostedChestItem())).setRegistryName(block.getRegistryName());
                registry.getRegistry().register(chest);
            }else if (block instanceof BlockPresentBox) {
                Item chest = new ItemModItemBlock(block, new Item.Properties().tab(DivineRPG.tabs.blocks).setISTER(() -> new RenderPresentBoxItem())).setRegistryName(block.getRegistryName());
                registry.getRegistry().register(chest);
            } else {
                registry.getRegistry().register(itemBlock);
            }
        }
    }

    @SubscribeEvent
    public static void registerVetheaBlockItems(final RegistryEvent.Register<Item> registry) {
        Item.Properties properties = new Item.Properties().tab(DivineRPG.tabs.vethea);
        for (Block block : vethea) {

            Item itemBlock = new ItemModItemBlock(block, properties).setRegistryName(block.getRegistryName());
            if (!itemBlock.equals(Item.byBlock(Blocks.AIR))) {
                ItemRegistry.itemMap.put(itemBlock.getRegistryName().getPath(), itemBlock);
            }
            registry.getRegistry().register(itemBlock);
        }
    }

    @SubscribeEvent
    public static void registerUtilBlockItems(final RegistryEvent.Register<Item> registry) {
        Item.Properties properties = new Item.Properties().tab(DivineRPG.tabs.utilities);
        for (Block block : utilities) {

            Item itemBlock = new BlockItem(block, properties).setRegistryName(block.getRegistryName());
            if (!itemBlock.equals(Item.byBlock(Blocks.AIR))) {
                ItemRegistry.itemMap.put(itemBlock.getRegistryName().getPath(), itemBlock);
            }
            registry.getRegistry().register(itemBlock);
        }
    }

    private static void registerItemlessBlock(RegistryEvent.Register<Block> registry, Block block) {
        registry.getRegistry().register(block);
    }

    private static void registerFluidBlock(RegistryEvent.Register<Block> registry, FlowingFluidBlock block, String name) {
        block.setRegistryName(name);
        registry.getRegistry().register(block);
    }

}
