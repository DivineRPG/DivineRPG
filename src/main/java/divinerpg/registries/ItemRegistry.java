package divinerpg.registries;

import divinerpg.*;
import divinerpg.enums.*;
import divinerpg.items.arcana.*;
import divinerpg.items.base.*;
import divinerpg.items.iceika.*;
import divinerpg.items.twilight.*;
import divinerpg.items.vanilla.*;
import divinerpg.items.vethea.*;
import divinerpg.util.*;
import net.minecraft.block.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;
import net.minecraftforge.event.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.registries.*;

import java.util.*;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(DivineRPG.MODID)
public class ItemRegistry {
    public static HashMap<String, Item> itemMap = new HashMap<>();

    // Teleportation crystal
    @ObjectHolder("teleportation_crystal")
    public static final Item teleportationCrystal = null;
    @ObjectHolder("teleportation_star")
    public static final Item teleportationStar = null;

    //TORCHES
    @ObjectHolder("aqua_torch")
    public static final Item aquaTorch = null;
    @ObjectHolder("arcanium_torch")
    public static final Item arcaniumTorch = null;
    @ObjectHolder("eden_torch")
    public static final Item edenTorch = null;
    @ObjectHolder("skeleton_torch")
    public static final Item skeletonTorch = null;

    // Vanilla misc items

    // Shards
    @ObjectHolder("corrupted_shards")
    public static final Item corruptedShards = null;
    @ObjectHolder("divine_shards")
    public static final Item divineShards = null;
    @ObjectHolder("ender_shards")
    public static final Item enderShards = null;
    @ObjectHolder("ice_shards")
    public static final Item iceShards = null;
    @ObjectHolder("jungle_shards")
    public static final Item jungleShards = null;
    @ObjectHolder("molten_shards")
    public static final Item moltenShards = null;
    @ObjectHolder("terran_shards")
    public static final Item terranShards = null;

    // Stones
    @ObjectHolder("corrupted_stone")
    public static final Item corruptedStone = null;
    @ObjectHolder("divine_stone")
    public static final Item divineStone = null;
    @ObjectHolder("ender_stone")
    public static final Item enderStone = null;
    @ObjectHolder("ice_stone")
    public static final Item iceStone = null;
    @ObjectHolder("jungle_stone")
    public static final Item jungleStone = null;
    @ObjectHolder("molten_stone")
    public static final Item moltenStone = null;
    @ObjectHolder("shadow_stone")
    public static final Item shadowStone = null;
    @ObjectHolder("terran_stone")
    public static final Item terranStone = null;

    // Ingots
    @ObjectHolder("arlemite_ingot")
    public static final Item arlemiteIngot = null;
    @ObjectHolder("hellstone_ingot")
    public static final Item hellstoneIngot = null;
    @ObjectHolder("torridite_ingot")
    public static final Item torriditeIngot = null;
    @ObjectHolder("realmite_ingot")
    public static final Item realmiteIngot = null;
    @ObjectHolder("rupee_ingot")
    public static final Item rupeeIngot = null;
    @ObjectHolder("shadow_bar")
    public static final Item shadowBar = null;

    //Nuggets
    @ObjectHolder("arlemite_nugget")
    public static final Item arlemiteNugget = null;
    @ObjectHolder("realmite_nugget")
    public static final Item realmiteNugget = null;
    @ObjectHolder("rupee_nugget")
    public static final Item rupeeNugget = null;
    @ObjectHolder("torridite_nugget")
    public static final Item torriditeNugget = null;

    // Boss Spawners
    @ObjectHolder("call_of_the_watcher")
    public static final Item callOfTheWatcher = null;
    @ObjectHolder("horde_horn")
    public static final Item hordeHorn = null;
    @ObjectHolder("infernal_flame")
    public static final Item infernalFlame = null;
    @ObjectHolder("mysterious_clock")
    public static final Item mysteriousClock = null;
    @ObjectHolder("watching_eye")
    public static final Item watchingEye = null;

    // Diamond chunks
    @ObjectHolder("blue_diamond_chunk")
    public static final Item blueDiamondChunk = null;
    @ObjectHolder("gray_diamond_chunk")
    public static final Item grayDiamondChunk = null;
    @ObjectHolder("green_diamond_chunk")
    public static final Item greenDiamondChunk = null;
    @ObjectHolder("red_diamond_chunk")
    public static final Item redDiamondChunk = null;
    @ObjectHolder("yellow_diamond_chunk")
    public static final Item yellowDiamondChunk = null;

    // Pet spawn eggs
    @ObjectHolder("brown_grizzle_egg")
    public static final Item brownGrizzleEgg = null;
    @ObjectHolder("ehu_egg")
    public static final Item ehuEgg = null;
    @ObjectHolder("husk_egg")
    public static final Item huskEgg = null;
    @ObjectHolder("smelter_egg")
    public static final Item smelterEgg = null;
    @ObjectHolder("snapper_egg")
    public static final Item snapperEgg = null;
    @ObjectHolder("stone_golem_egg")
    public static final Item stoneGolemEgg = null;
    @ObjectHolder("white_grizzle_egg")
    public static final Item whiteGrizzleEgg = null;

    // Miscellaneous resources
    @ObjectHolder("aqua_ball")
    public static final Item aquaBall = null;
    @ObjectHolder("aquatic_blaze_rod")
    public static final Item aquaticBlazeRod = null;
    @ObjectHolder("aquatic_ingot")
    public static final Item aquaticIngot = null;
    @ObjectHolder("aquatic_pellets")
    public static final Item aquaticPellets = null;
    @ObjectHolder("bedrock_chunk")
    public static final Item bedrockChunk = null;
    @ObjectHolder("bloodgem")
    public static final Item bloodgem = null;
    @ObjectHolder("bluefire_stone")
    public static final Item bluefireStone = null;
    @ObjectHolder("corrupted_bullet")
    public static final Item corruptedBullet = null;
    @ObjectHolder("crab_claw")
    public static final Item crabClaw = null;
    @ObjectHolder("cyclops_eye")
    public static final Item cyclopsEye = null;
    @ObjectHolder("cyclops_eye_shards")
    public static final Item cyclopsEyeShards = null;
    @ObjectHolder("fury_fire")
    public static final Item furyFire = null;
    @ObjectHolder("healing_stone")
    public static final Item healingStone = null;
    @ObjectHolder("kraken_scale")
    public static final Item krakenScale = null;
    @ObjectHolder("kraken_skin")
    public static final Item krakenSkin = null;
    @ObjectHolder("legendary_ender_eye")
    public static final Item legendaryEnderEye = null;
    @ObjectHolder("liopleurodon_skull")
    public static final Item liopleurodonSkull = null;
    @ObjectHolder("liopleurodon_teeth")
    public static final Item liopleurodonTeeth = null;
    @ObjectHolder("torridite_chunk")
    public static final Item torriditeChunk = null;
    @ObjectHolder("pure_aquatic_pellets")
    public static final Item pureAquaticPellets = null;
    @ObjectHolder("purple_blaze")
    public static final Item purpleBlaze = null;
    @ObjectHolder("shadow_coins")
    public static final Item shadowCoins = null;
    @ObjectHolder("shark_fin")
    public static final Item sharkFin = null;
    @ObjectHolder("whale_fin")
    public static final Item whaleFin = null;

    // Iceika

    // Iceika misc
    @ObjectHolder("snowflake")
    public static final Item snowflake = null;

    // Iceika portal item
    @ObjectHolder("snow_globe")
    public static final Item snowGlobe = null;

    /*************************/

    // Foods
    @ObjectHolder("advanced_mushroom_stew")
    public static final Item advancedMushroomStew = null;
    @ObjectHolder("bacon")
    public static final Item bacon = null;
    @ObjectHolder("boiled_egg")
    public static final Item boiledEgg = null;
    @ObjectHolder("cheese")
    public static final Item cheese = null;
    @ObjectHolder("chicken_dinner")
    public static final Item chickenDinner = null;
    @ObjectHolder("chocolate_log")
    public static final Item chocolateLog = null;
    @ObjectHolder("donut")
    public static final Item donut = null;
    @ObjectHolder("egg_nog")
    public static final Item eggNog = null;
    @ObjectHolder("empowered_meat")
    public static final Item empoweredMeat = null;
    @ObjectHolder("enriched_magic_meat")
    public static final Item enrichedMagicMeat = null;
    @ObjectHolder("forbidden_fruit")
    public static final Item forbiddenFruit = null;
    @ObjectHolder("fruit_cake")
    public static final Item fruitCake = null;
    @ObjectHolder("hot_pumpkin_pie")
    public static final Item hotPumpkinPie = null;
    @ObjectHolder("magic_meat")
    public static final Item magicMeat = null;
    @ObjectHolder("moonbulb")
    public static final Item moonbulb = null;
    @ObjectHolder("peppermints")
    public static final Item peppermints = null;
    @ObjectHolder("pink_glowbone")
    public static final Item pinkGlowbone = null;
    @ObjectHolder("purple_glowbone")
    public static final Item purpleGlowbone = null;
    @ObjectHolder("raw_empowered_meat")
    public static final Item rawEmpoweredMeat = null;
    @ObjectHolder("sky_flower")
    public static final Item skyFlower = null;
    @ObjectHolder("snow_cones")
    public static final Item snowCones = null;
    @ObjectHolder("tomato")
    public static final Item tomato = null;
    @ObjectHolder("white_mushroom")
    public static final Item whiteMushroom = null;
    @ObjectHolder("winterberry")
    public static final Item winterberry = null;

    // Twilight Dimensions

    // Twilight souls
    @ObjectHolder("eden_soul")
    public static final Item edenSoul = null;
    @ObjectHolder("wildwood_soul")
    public static final Item wildwoodSoul = null;
    @ObjectHolder("apalachia_soul")
    public static final Item apalachiaSoul = null;
    @ObjectHolder("skythern_soul")
    public static final Item skythernSoul = null;
    @ObjectHolder("mortum_soul")
    public static final Item mortumSoul = null;

    @ObjectHolder("eden_heart")
    public static final Item edenHeart = null;
    @ObjectHolder("wildwood_heart")
    public static final Item wildwoodHeart = null;
    @ObjectHolder("apalachia_heart")
    public static final Item apalachiaHeart = null;
    @ObjectHolder("skythern_heart")
    public static final Item skythernHeart = null;
    @ObjectHolder("mortum_heart")
    public static final Item mortumHeart = null;

    // Twilight fragments
    @ObjectHolder("eden_fragments")
    public static final Item edenFragments = null;
    @ObjectHolder("wildwood_fragments")
    public static final Item wildwoodFragments = null;
    @ObjectHolder("apalachia_fragments")
    public static final Item apalachiaFragments = null;
    @ObjectHolder("skythern_fragments")
    public static final Item skythernFragments = null;
    @ObjectHolder("mortum_fragments")
    public static final Item mortumFragments = null;

    // Twilight gems
    @ObjectHolder("eden_gem")
    public static final Item edenGem = null;
    @ObjectHolder("wildwood_gem")
    public static final Item wildwoodGem = null;
    @ObjectHolder("apalachia_gem")
    public static final Item apalachiaGem = null;
    @ObjectHolder("skythern_gem")
    public static final Item skythernGem = null;
    @ObjectHolder("mortum_gem")
    public static final Item mortumGem = null;

    // Twilight chunks
    @ObjectHolder("eden_chunk")
    public static final Item edenChunk = null;
    @ObjectHolder("wildwood_chunk")
    public static final Item wildwoodChunk = null;
    @ObjectHolder("apalachia_chunk")
    public static final Item apalachiaChunk = null;
    @ObjectHolder("skythern_chunk")
    public static final Item skythernChunk = null;
    @ObjectHolder("mortum_chunk")
    public static final Item mortumChunk = null;

    // Twilight dust
    @ObjectHolder("eden_dust")
    public static final Item edenDust = null;
    @ObjectHolder("wildwood_dust")
    public static final Item wildwoodDust = null;
    @ObjectHolder("apalachia_dust")
    public static final Item apalachiaDust = null;
    @ObjectHolder("skythern_dust")
    public static final Item skythernDust = null;
    @ObjectHolder("mortum_dust")
    public static final Item mortumDust = null;


    // Twilight boss spawners
    @ObjectHolder("densos_crystal")
    public static final Item densosCrystal = null;
    @ObjectHolder("karot_crystal")
    public static final Item karotCrystal = null;
    @ObjectHolder("reyvor_crystal")
    public static final Item reyvorCrystal = null;
    @ObjectHolder("soul_fiend_crystal")
    public static final Item soulFiendCrystal = null;
    @ObjectHolder("twilight_demon_crystal")
    public static final Item twilightDemonCrystal = null;
    @ObjectHolder("vamacheron_crystal")
    public static final Item vamacheronCrystal = null;

    // Twilight portal item
    @ObjectHolder("twilight_clock")
    public static final Item twilightClock = null;

    // Twilight arrows
    @ObjectHolder("eden_arrow")
    public static final Item edenArrow = null;
    @ObjectHolder("fury_arrow")
    public static final Item furyArrow = null;
    @ObjectHolder("wildwood_arrow")
    public static final Item wildwoodArrow = null;

    // Twilight miscellaneous
    @ObjectHolder("base_spawn_crystal")
    public static final Item baseSpawnCrystal = null;
    @ObjectHolder("eden_sparkles")
    public static final Item edenSparkles = null;

    // Arcana
    // Arcana utility
    @ObjectHolder("arcanium_attractor")
    public static final Item arcaniumAttractor = null;
    @ObjectHolder("arcanium_reflector")
    public static final Item arcaniumReflector = null;
    @ObjectHolder("divine_accumulator")
    public static final Item divineAccumulator = null;
    @ObjectHolder("ghostbane")
    public static final Item ghostbane = null;
    @ObjectHolder("orb_of_light")
    public static final Item orbOfLight = null;
    @ObjectHolder("staff_of_enrichment")
    public static final Item staffOfEnrichment = null;

    // Arcana boss spawner
    @ObjectHolder("wizards_book")
    public static final Item wizardsBook = null;

    // Arcana pet spawners
    @ObjectHolder("fyracryx_egg")
    public static final Item fyracryxEgg = null;
    @ObjectHolder("golem_of_rejuvenation_egg")
    public static final Item golemOfRejuvenationEgg = null;
    @ObjectHolder("paratiku_egg")
    public static final Item paratikuEgg = null;
    @ObjectHolder("seimer_egg")
    public static final Item seimerEgg = null;

    // Arcana non-food crops

    // Arcana keys
    @ObjectHolder("ancient_key")
    public static final Item ancientKey = null;
    @ObjectHolder("degraded_key")
    public static final Item degradedKey = null;
    @ObjectHolder("sludge_key")
    public static final Item sludgeKey = null;
    @ObjectHolder("soul_key")
    public static final Item soulKey = null;

    // Arcana potions
    @ObjectHolder("strong_arcana_potion")
    public static final Item strongArcanaPotion = null;
    @ObjectHolder("weak_arcana_potion")
    public static final Item weakArcanaPotion = null;

    // Arcana crops
    @ObjectHolder("aquamarine")
    public static final Item aquamarine = null;
    @ObjectHolder("firestock")
    public static final Item firestock = null;
    @ObjectHolder("hitchak")
    public static final Item hitchak = null;
    @ObjectHolder("lamona")
    public static final Item lamona = null;
    @ObjectHolder("marsine")
    public static final Item marsine = null;
    @ObjectHolder("pinfly")
    public static final Item pinfly = null;
    @ObjectHolder("veilo")
    public static final Item veilo = null;

    // Arcana miscellaneous
    @ObjectHolder("arcanium")
    public static final Item arcanium = null;
    @ObjectHolder("collector")
    public static final Item collector = null;
    @ObjectHolder("collector_fragments")
    public static final Item collectorFragments = null;
    @ObjectHolder("dungeon_tokens")
    public static final Item dungeonTokens = null;

    //Seeds
    @ObjectHolder("aquamarine_seeds")
    public static final Item aquamarineSeeds = null;
    @ObjectHolder("eucalyptus_root_seeds")
    public static final Item eucalyptusRootSeeds = null;
    @ObjectHolder("firestock_seeds")
    public static final Item firestockSeeds = null;
    @ObjectHolder("hitchak_seeds")
    public static final Item hitchakSeeds = null;
    @ObjectHolder("lamona_seeds")
    public static final Item lamonaSeeds = null;
    @ObjectHolder("marsine_seeds")
    public static final Item marsineSeeds = null;
    @ObjectHolder("moonbulb_seeds")
    public static final Item moonbulbSeeds = null;
    @ObjectHolder("pinfly_seeds")
    public static final Item pinflySeeds = null;
    @ObjectHolder("pink_glowbone_seeds")
    public static final Item pinkGlowboneSeeds = null;
    @ObjectHolder("purple_glowbone_seeds")
    public static final Item purpleGlowboneSeeds = null;
    @ObjectHolder("sky_plant_seeds")
    public static final Item skyPlantSeeds = null;
    @ObjectHolder("tomato_seeds")
    public static final Item tomatoSeeds = null;
    @ObjectHolder("veilo_seeds")
    public static final Item veiloSeeds = null;
    @ObjectHolder("white_mushroom_seeds")
    public static final Item whiteMushroomSeeds = null;

    // Vethea
    // Vethea pearls
    @ObjectHolder("dirty_pearls")
    public static final Item dirtyPearls = null;
    @ObjectHolder("clean_pearls")
    public static final Item cleanPearls = null;
    @ObjectHolder("polished_pearls")
    public static final Item polishedPearls = null;
    @ObjectHolder("shiny_pearls")
    public static final Item shinyPearls = null;

    // Vethea lumps
    @ObjectHolder("teaker_lump")
    public static final Item teakerLump = null;
    @ObjectHolder("amthirmis_lump")
    public static final Item amthirmisLump = null;
    @ObjectHolder("darven_lump")
    public static final Item darvenLump = null;
    @ObjectHolder("cermile_lump")
    public static final Item cermileLump = null;
    @ObjectHolder("pardimal_lump")
    public static final Item pardimalLump = null;
    @ObjectHolder("quadrotic_lump")
    public static final Item quadroticLump = null;
    @ObjectHolder("karos_lump")
    public static final Item karosLump = null;
    @ObjectHolder("heliosis_lump")
    public static final Item heliosisLump = null;
    @ObjectHolder("arksiane_lump")
    public static final Item arksianeLump = null;


    // Vethea templates
    @ObjectHolder("backsword_template")
    public static final Item backswordTemplate = null;
    @ObjectHolder("bow_template")
    public static final Item bowTemplate = null;
    @ObjectHolder("cannon_template")
    public static final Item cannonTemplate = null;
    @ObjectHolder("claw_template")
    public static final Item clawTemplate = null;
    @ObjectHolder("disk_template")
    public static final Item diskTemplate = null;
    @ObjectHolder("hammer_template")
    public static final Item hammerTemplate = null;
    @ObjectHolder("staff_template")
    public static final Item staffTemplate = null;

    @ObjectHolder("degraded_template")
    public static final Item degradedTemplate = null;
    @ObjectHolder("finished_template")
    public static final Item finishedTemplate = null;
    @ObjectHolder("glistening_template")
    public static final Item glisteningTemplate = null;
    @ObjectHolder("demonized_template")
    public static final Item demonizedTemplate = null;
    @ObjectHolder("tormented_template")
    public static final Item tormentedTemplate = null;

    // Vethea food
    @ObjectHolder("dream_carrot")
    public static final Item dreamCarrot = null;
    @ObjectHolder("dream_melon")
    public static final Item dreamMelon = null;
    @ObjectHolder("dream_pie")
    public static final Item dreamPie = null;
    @ObjectHolder("dream_cake")
    public static final Item dreamCake = null;
    @ObjectHolder("dream_sweets")
    public static final Item dreamSweets = null;
    @ObjectHolder("dream_sours")
    public static final Item dreamSours = null;
    @ObjectHolder("honeysuckle")
    public static final Item honeysuckle = null;
    @ObjectHolder("honeychunk")
    public static final Item honeychunk = null;

    // Vethea boss spawners
    @ObjectHolder("dream_flint")
    public static final Item dreamFlint = null;
    @ObjectHolder("moon_clock")
    public static final Item moonClock = null;

    // Vethea arrows
    @ObjectHolder("teaker_arrow")
    public static final Item teakerArrow = null;
    @ObjectHolder("darven_arrow")
    public static final Item darvenArrow = null;
    @ObjectHolder("pardimal_arrow")
    public static final Item pardimalArrow = null;
    @ObjectHolder("karos_arrow")
    public static final Item karosArrow = null;
    @ObjectHolder("ever_arrow")
    public static final Item everArrow = null;

    // Vethea portal item
    @ObjectHolder("nightmare_bed")
    public static final Item nightmareBed = null;

    // Vethea miscellaneous
    @ObjectHolder("acid")
    public static final Item acid = null;
    @ObjectHolder("band_of_heiva_hunting")
    public static final Item bandOfHeivaHunting = null;
    @ObjectHolder("miners_amulet")
    public static final Item minersAmulet = null;
    @ObjectHolder("rock_chunks")
    public static final Item rockChunks = null;

    // shields
    @ObjectHolder("arlemite_shield")
    public static final Item arlemite_shield = null;
    @ObjectHolder("realmite_shield")
    public static final Item realmite_shield = null;
    @ObjectHolder("rupee_shield")
    public static final Item rupee_shield = null;
    @ObjectHolder("halite_shield")
    public static final Item halite_shield = null;

    @ObjectHolder("eden_shield")
    public static final Item eden_shield = null;
    @ObjectHolder("wildwood_shield")
    public static final Item wildwood_shield = null;
    @ObjectHolder("apalachia_shield")
    public static final Item apalachia_shield = null;
    @ObjectHolder("skythern_shield")
    public static final Item skythern_shield = null;
    @ObjectHolder("mortum_shield")
    public static final Item mortum_shield = null;

    // Armor

    // Vanilla dimension armor
    @ObjectHolder("angelic_helmet")
    public static final Item angelicHelmet = null;
    @ObjectHolder("angelic_chestplate")
    public static final Item angelicChestplate = null;
    @ObjectHolder("angelic_leggings")
    public static final Item angelicLeggings = null;
    @ObjectHolder("angelic_boots")
    public static final Item angelicBoots = null;

    @ObjectHolder("aquastrive_helmet")
    public static final Item aquastriveHelmet = null;
    @ObjectHolder("aquastrive_chestplate")
    public static final Item aquastriveChestplate = null;
    @ObjectHolder("aquastrive_leggings")
    public static final Item aquastriveLeggings = null;
    @ObjectHolder("aquastrive_boots")
    public static final Item aquastriveBoots = null;

    @ObjectHolder("arlemite_helmet")
    public static final Item arlemiteHelmet = null;
    @ObjectHolder("arlemite_chestplate")
    public static final Item arlemiteChestplate = null;
    @ObjectHolder("arlemite_leggings")
    public static final Item arlemiteLeggings = null;
    @ObjectHolder("arlemite_boots")
    public static final Item arlemiteBoots = null;

    @ObjectHolder("bedrock_helmet")
    public static final Item bedrockHelmet = null;
    @ObjectHolder("bedrock_chestplate")
    public static final Item bedrockChestplate = null;
    @ObjectHolder("bedrock_leggings")
    public static final Item bedrockLeggings = null;
    @ObjectHolder("bedrock_boots")
    public static final Item bedrockBoots = null;

    @ObjectHolder("corrupted_helmet")
    public static final Item corruptedHelmet = null;
    @ObjectHolder("corrupted_chestplate")
    public static final Item corruptedChestplate = null;
    @ObjectHolder("corrupted_leggings")
    public static final Item corruptedLeggings = null;
    @ObjectHolder("corrupted_boots")
    public static final Item corruptedBoots = null;

    @ObjectHolder("divine_helmet")
    public static final Item divineHelmet = null;
    @ObjectHolder("divine_chestplate")
    public static final Item divineChestplate = null;
    @ObjectHolder("divine_leggings")
    public static final Item divineLeggings = null;
    @ObjectHolder("divine_boots")
    public static final Item divineBoots = null;

    @ObjectHolder("elite_realmite_helmet")
    public static final Item eliteRealmiteHelmet = null;
    @ObjectHolder("elite_realmite_chestplate")
    public static final Item eliteRealmiteChestplate = null;
    @ObjectHolder("elite_realmite_leggings")
    public static final Item eliteRealmiteLeggings = null;
    @ObjectHolder("elite_realmite_boots")
    public static final Item eliteRealmiteBoots = null;

    @ObjectHolder("ender_helmet")
    public static final Item enderHelmet = null;
    @ObjectHolder("ender_chestplate")
    public static final Item enderChestplate = null;
    @ObjectHolder("ender_leggings")
    public static final Item enderLeggings = null;
    @ObjectHolder("ender_boots")
    public static final Item enderBoots = null;


    @ObjectHolder("blue_ender_helmet")
    public static final Item blueEnderHelmet = null;
    @ObjectHolder("blue_ender_chestplate")
    public static final Item blueEnderChestplate = null;
    @ObjectHolder("blue_ender_leggings")
    public static final Item blueEnderLeggings = null;
    @ObjectHolder("blue_ender_boots")
    public static final Item blueEnderBoots = null;

    @ObjectHolder("gray_ender_helmet")
    public static final Item grayEnderHelmet = null;
    @ObjectHolder("gray_ender_chestplate")
    public static final Item grayEnderChestplate = null;
    @ObjectHolder("gray_ender_leggings")
    public static final Item grayEnderLeggings = null;
    @ObjectHolder("gray_ender_boots")
    public static final Item grayEnderBoots = null;

    @ObjectHolder("green_ender_helmet")
    public static final Item greenEnderHelmet = null;
    @ObjectHolder("green_ender_chestplate")
    public static final Item greenEnderChestplate = null;
    @ObjectHolder("green_ender_leggings")
    public static final Item greenEnderLeggings = null;
    @ObjectHolder("green_ender_boots")
    public static final Item greenEnderBoots = null;

    @ObjectHolder("red_ender_helmet")
    public static final Item redEnderHelmet = null;
    @ObjectHolder("red_ender_chestplate")
    public static final Item redEnderChestplate = null;
    @ObjectHolder("red_ender_leggings")
    public static final Item redEnderLeggings = null;
    @ObjectHolder("red_ender_boots")
    public static final Item redEnderBoots = null;

    @ObjectHolder("yellow_ender_helmet")
    public static final Item yellowEnderHelmet = null;
    @ObjectHolder("yellow_ender_chestplate")
    public static final Item yellowEnderChestplate = null;
    @ObjectHolder("yellow_ender_leggings")
    public static final Item yellowEnderLeggings = null;
    @ObjectHolder("yellow_ender_boots")
    public static final Item yellowEnderBoots = null;

    @ObjectHolder("frozen_helmet")
    public static final Item frozenHelmet = null;
    @ObjectHolder("frozen_chestplate")
    public static final Item frozenChestplate = null;
    @ObjectHolder("frozen_leggings")
    public static final Item frozenLeggings = null;
    @ObjectHolder("frozen_boots")
    public static final Item frozenBoots = null;

    @ObjectHolder("inferno_helmet")
    public static final Item infernoHelmet = null;
    @ObjectHolder("inferno_chestplate")
    public static final Item infernoChestplate = null;
    @ObjectHolder("inferno_leggings")
    public static final Item infernoLeggings = null;
    @ObjectHolder("inferno_boots")
    public static final Item infernoBoots = null;

    @ObjectHolder("jack_o_man_helmet")
    public static final Item jackOManHelmet = null;
    @ObjectHolder("jack_o_man_chestplate")
    public static final Item jackOManChestplate = null;
    @ObjectHolder("jack_o_man_leggings")
    public static final Item jackOManLeggings = null;
    @ObjectHolder("jack_o_man_boots")
    public static final Item jackOManBoots = null;

    @ObjectHolder("jungle_helmet")
    public static final Item jungleHelmet = null;
    @ObjectHolder("jungle_chestplate")
    public static final Item jungleChestplate = null;
    @ObjectHolder("jungle_leggings")
    public static final Item jungleLeggings = null;
    @ObjectHolder("jungle_boots")
    public static final Item jungleBoots = null;

    @ObjectHolder("kraken_helmet")
    public static final Item krakenHelmet = null;
    @ObjectHolder("kraken_chestplate")
    public static final Item krakenChestplate = null;
    @ObjectHolder("kraken_leggings")
    public static final Item krakenLeggings = null;
    @ObjectHolder("kraken_boots")
    public static final Item krakenBoots = null;

    @ObjectHolder("torridite_helmet")
    public static final Item torriditeHelmet = null;
    @ObjectHolder("torridite_chestplate")
    public static final Item torriditeChestplate = null;
    @ObjectHolder("torridite_leggings")
    public static final Item torriditeLeggings = null;
    @ObjectHolder("torridite_boots")
    public static final Item torriditeBoots = null;

    @ObjectHolder("realmite_helmet")
    public static final Item realmiteHelmet = null;
    @ObjectHolder("realmite_chestplate")
    public static final Item realmiteChestplate = null;
    @ObjectHolder("realmite_leggings")
    public static final Item realmiteLeggings = null;
    @ObjectHolder("realmite_boots")
    public static final Item realmiteBoots = null;

    @ObjectHolder("rupee_helmet")
    public static final Item rupeeHelmet = null;
    @ObjectHolder("rupee_chestplate")
    public static final Item rupeeChestplate = null;
    @ObjectHolder("rupee_leggings")
    public static final Item rupeeLeggings = null;
    @ObjectHolder("rupee_boots")
    public static final Item rupeeBoots = null;

    @ObjectHolder("blue_rupee_helmet")
    public static final Item blueRupeeHelmet = null;
    @ObjectHolder("blue_rupee_chestplate")
    public static final Item blueRupeeChestplate = null;
    @ObjectHolder("blue_rupee_leggings")
    public static final Item blueRupeeLeggings = null;
    @ObjectHolder("blue_rupee_boots")
    public static final Item blueRupeeBoots = null;

    @ObjectHolder("green_rupee_helmet")
    public static final Item greenRupeeHelmet = null;
    @ObjectHolder("green_rupee_chestplate")
    public static final Item greenRupeeChestplate = null;
    @ObjectHolder("green_rupee_leggings")
    public static final Item greenRupeeLeggings = null;
    @ObjectHolder("green_rupee_boots")
    public static final Item greenRupeeBoots = null;

    @ObjectHolder("gray_rupee_helmet")
    public static final Item grayRupeeHelmet = null;
    @ObjectHolder("gray_rupee_chestplate")
    public static final Item grayRupeeChestplate = null;
    @ObjectHolder("gray_rupee_leggings")
    public static final Item grayRupeeLeggings = null;
    @ObjectHolder("gray_rupee_boots")
    public static final Item grayRupeeBoots = null;

    @ObjectHolder("red_rupee_helmet")
    public static final Item redRupeeHelmet = null;
    @ObjectHolder("red_rupee_chestplate")
    public static final Item redRupeeChestplate = null;
    @ObjectHolder("red_rupee_leggings")
    public static final Item redRupeeLeggings = null;
    @ObjectHolder("red_rupee_boots")
    public static final Item redRupeeBoots = null;

    @ObjectHolder("yellow_rupee_helmet")
    public static final Item yellowRupeeHelmet = null;
    @ObjectHolder("yellow_rupee_chestplate")
    public static final Item yellowRupeeChestplate = null;
    @ObjectHolder("yellow_rupee_leggings")
    public static final Item yellowRupeeLeggings = null;
    @ObjectHolder("yellow_rupee_boots")
    public static final Item yellowRupeeBoots = null;

    @ObjectHolder("shadow_helmet")
    public static final Item shadowHelmet = null;
    @ObjectHolder("shadow_chestplate")
    public static final Item shadowChestplate = null;
    @ObjectHolder("shadow_leggings")
    public static final Item shadowLeggings = null;
    @ObjectHolder("shadow_boots")
    public static final Item shadowBoots = null;

    @ObjectHolder("skeleman_helmet")
    public static final Item skelemanHelmet = null;
    @ObjectHolder("skeleman_chestplate")
    public static final Item skelemanChestplate = null;
    @ObjectHolder("skeleman_leggings")
    public static final Item skelemanLeggings = null;
    @ObjectHolder("skeleman_boots")
    public static final Item skelemanBoots = null;

    @ObjectHolder("terran_helmet")
    public static final Item terranHelmet = null;
    @ObjectHolder("terran_chestplate")
    public static final Item terranChestplate = null;
    @ObjectHolder("terran_leggings")
    public static final Item terranLeggings = null;
    @ObjectHolder("terran_boots")
    public static final Item terranBoots = null;

    @ObjectHolder("wither_reaper_helmet")
    public static final Item witherReaperHelmet = null;
    @ObjectHolder("wither_reaper_chestplate")
    public static final Item witherReaperChestplate = null;
    @ObjectHolder("wither_reaper_leggings")
    public static final Item witherReaperLeggings = null;
    @ObjectHolder("wither_reaper_boots")
    public static final Item witherReaperBoots = null;

    // Iceika dimension armor
    @ObjectHolder("santa_helmet")
    public static final Item santaHelmet = null;
    @ObjectHolder("santa_chestplate")
    public static final Item santaChestplate = null;
    @ObjectHolder("santa_leggings")
    public static final Item santaLeggings = null;
    @ObjectHolder("santa_boots")
    public static final Item santaBoots = null;

    // Twilight armor
    @ObjectHolder("eden_helmet")
    public static final Item edenHelmet = null;
    @ObjectHolder("eden_chestplate")
    public static final Item edenChestplate = null;
    @ObjectHolder("eden_leggings")
    public static final Item edenLeggings = null;
    @ObjectHolder("eden_boots")
    public static final Item edenBoots = null;

    @ObjectHolder("wildwood_helmet")
    public static final Item wildwoodHelmet = null;
    @ObjectHolder("wildwood_chestplate")
    public static final Item wildwoodChestplate = null;
    @ObjectHolder("wildwood_leggings")
    public static final Item wildwoodLeggings = null;
    @ObjectHolder("wildwood_boots")
    public static final Item wildwoodBoots = null;

    @ObjectHolder("apalachia_helmet")
    public static final Item apalachiaHelmet = null;
    @ObjectHolder("apalachia_chestplate")
    public static final Item apalachiaChestplate = null;
    @ObjectHolder("apalachia_leggings")
    public static final Item apalachiaLeggings = null;
    @ObjectHolder("apalachia_boots")
    public static final Item apalachiaBoots = null;

    @ObjectHolder("skythern_helmet")
    public static final Item skythernHelmet = null;
    @ObjectHolder("skythern_chestplate")
    public static final Item skythernChestplate = null;
    @ObjectHolder("skythern_leggings")
    public static final Item skythernLeggings = null;
    @ObjectHolder("skythern_boots")
    public static final Item skythernBoots = null;

    @ObjectHolder("mortum_helmet")
    public static final Item mortumHelmet = null;
    @ObjectHolder("mortum_chestplate")
    public static final Item mortumChestplate = null;
    @ObjectHolder("mortum_leggings")
    public static final Item mortumLeggings = null;
    @ObjectHolder("mortum_boots")
    public static final Item mortumBoots = null;

    @ObjectHolder("halite_helmet")
    public static final Item haliteHelmet = null;
    @ObjectHolder("halite_chestplate")
    public static final Item haliteChestplate = null;
    @ObjectHolder("halite_leggings")
    public static final Item haliteLeggings = null;
    @ObjectHolder("halite_boots")
    public static final Item haliteBoots = null;

    @ObjectHolder("awakened_halite_helmet")
    public static final Item awakened_haliteHelmet = null;
    @ObjectHolder("awakened_halite_chestplate")
    public static final Item awakened_haliteChestplate = null;
    @ObjectHolder("awakened_halite_leggings")
    public static final Item awakened_haliteLeggings = null;
    @ObjectHolder("awakened_halite_boots")
    public static final Item awakened_haliteBoots = null;

    // Arcana armor sets
    @ObjectHolder("korma_helmet")
    public static final Item kormaHelmet = null;
    @ObjectHolder("korma_chestplate")
    public static final Item kormaChestplate = null;
    @ObjectHolder("korma_leggings")
    public static final Item kormaLeggings = null;
    @ObjectHolder("korma_boots")
    public static final Item kormaBoots = null;

    @ObjectHolder("vemos_helmet")
    public static final Item vemosHelmet = null;
    @ObjectHolder("vemos_chestplate")
    public static final Item vemosChestplate = null;
    @ObjectHolder("vemos_leggings")
    public static final Item vemosLeggings = null;
    @ObjectHolder("vemos_boots")
    public static final Item vemosBoots = null;

    // Vethea armor sets
    @ObjectHolder("degraded_helmet")
    public static final Item degradedHelmet = null;
    @ObjectHolder("degraded_hood")
    public static final Item degradedHood = null;
    @ObjectHolder("degraded_mask")
    public static final Item degradedMask = null;
    @ObjectHolder("degraded_chestplate")
    public static final Item degradedChestplate = null;
    @ObjectHolder("degraded_leggings")
    public static final Item degradedLeggings = null;
    @ObjectHolder("degraded_boots")
    public static final Item degradedBoots = null;

    @ObjectHolder("finished_helmet")
    public static final Item finishedHelmet = null;
    @ObjectHolder("finished_hood")
    public static final Item finishedHood = null;
    @ObjectHolder("finished_mask")
    public static final Item finishedMask = null;
    @ObjectHolder("finished_chestplate")
    public static final Item finishedChestplate = null;
    @ObjectHolder("finished_leggings")
    public static final Item finishedLeggings = null;
    @ObjectHolder("finished_boots")
    public static final Item finishedBoots = null;

    @ObjectHolder("glistening_helmet")
    public static final Item glisteningHelmet = null;
    @ObjectHolder("glistening_hood")
    public static final Item glisteningHood = null;
    @ObjectHolder("glistening_mask")
    public static final Item glisteningMask = null;
    @ObjectHolder("glistening_chestplate")
    public static final Item glisteningChestplate = null;
    @ObjectHolder("glistening_leggings")
    public static final Item glisteningLeggings = null;
    @ObjectHolder("glistening_boots")
    public static final Item glisteningBoots = null;

    @ObjectHolder("demonized_helmet")
    public static final Item demonizedHelmet = null;
    @ObjectHolder("demonized_hood")
    public static final Item demonizedHood = null;
    @ObjectHolder("demonized_mask")
    public static final Item demonizedMask = null;
    @ObjectHolder("demonized_chestplate")
    public static final Item demonizedChestplate = null;
    @ObjectHolder("demonized_leggings")
    public static final Item demonizedLeggings = null;
    @ObjectHolder("demonized_boots")
    public static final Item demonizedBoots = null;

    @ObjectHolder("tormented_helmet")
    public static final Item tormentedHelmet = null;
    @ObjectHolder("tormented_hood")
    public static final Item tormentedHood = null;
    @ObjectHolder("tormented_mask")
    public static final Item tormentedMask = null;
    @ObjectHolder("tormented_chestplate")
    public static final Item tormentedChestplate = null;
    @ObjectHolder("tormented_leggings")
    public static final Item tormentedLeggings = null;
    @ObjectHolder("tormented_boots")
    public static final Item tormentedBoots = null;

    // Tools
    @ObjectHolder("arlemite_shovel")
    public static final Item arlemiteShovel = null;
    @ObjectHolder("arlemite_pickaxe")
    public static final Item arlemitePickaxe = null;
    @ObjectHolder("arlemite_axe")
    public static final Item arlemiteAxe = null;
    @ObjectHolder("arlemite_hoe")
    public static final Item arlemiteHoe = null;
    @ObjectHolder("arlemite_shickaxe")
    public static final Item arlemiteShickaxe = null;

    @ObjectHolder("bedrock_shovel")
    public static final Item bedrockShovel = null;
    @ObjectHolder("bedrock_pickaxe")
    public static final Item bedrockPickaxe = null;
    @ObjectHolder("bedrock_axe")
    public static final Item bedrockAxe = null;

    @ObjectHolder("corrupted_shovel")
    public static final Item corruptedShovel = null;
    @ObjectHolder("corrupted_pickaxe")
    public static final Item corruptedPickaxe = null;
    @ObjectHolder("corrupted_axe")
    public static final Item corruptedAxe = null;

    @ObjectHolder("divine_shovel")
    public static final Item divineShovel = null;
    @ObjectHolder("divine_pickaxe")
    public static final Item divinePickaxe = null;
    @ObjectHolder("divine_axe")
    public static final Item divineAxe = null;
    @ObjectHolder("divine_shickaxe")
    public static final Item divineShickaxe = null;

    @ObjectHolder("realmite_shovel")
    public static final Item realmiteShovel = null;
    @ObjectHolder("realmite_pickaxe")
    public static final Item realmitePickaxe = null;
    @ObjectHolder("realmite_axe")
    public static final Item realmiteAxe = null;
    @ObjectHolder("realmite_hoe")
    public static final Item realmiteHoe = null;

    @ObjectHolder("rupee_shovel")
    public static final Item rupeeShovel = null;
    @ObjectHolder("rupee_pickaxe")
    public static final Item rupeePickaxe = null;
    @ObjectHolder("rupee_axe")
    public static final Item rupeeAxe = null;
    @ObjectHolder("rupee_hoe")
    public static final Item rupeeHoe = null;
    @ObjectHolder("rupee_shickaxe")
    public static final Item rupeeShickaxe = null;

    // Twilight tools

    @ObjectHolder("eden_shickaxe")
    public static final Item edenShickaxe = null;
    @ObjectHolder("wildwood_shickaxe")
    public static final Item wildwoodShickaxe = null;
    @ObjectHolder("apalachia_shickaxe")
    public static final Item apalachiaShickaxe = null;
    @ObjectHolder("skythern_shickaxe")
    public static final Item skythernShickaxe = null;
    @ObjectHolder("mortum_shickaxe")
    public static final Item mortumShickaxe = null;
    @ObjectHolder("halite_shickaxe")
    public static final Item haliteShickaxe = null;

    @ObjectHolder("eden_shovel")
    public static final Item edenShovel = null;
    @ObjectHolder("eden_pickaxe")
    public static final Item edenPickaxe = null;
    @ObjectHolder("eden_axe")
    public static final Item edenAxe = null;

    @ObjectHolder("wildwood_shovel")
    public static final Item wildwoodShovel = null;
    @ObjectHolder("wildwood_pickaxe")
    public static final Item wildwoodPickaxe = null;
    @ObjectHolder("wildwood_axe")
    public static final Item wildwoodAxe = null;

    @ObjectHolder("apalachia_shovel")
    public static final Item apalachiaShovel = null;
    @ObjectHolder("apalachia_pickaxe")
    public static final Item apalachiaPickaxe = null;
    @ObjectHolder("apalachia_axe")
    public static final Item apalachiaAxe = null;

    @ObjectHolder("skythern_shovel")
    public static final Item skythernShovel = null;
    @ObjectHolder("skythern_pickaxe")
    public static final Item skythernPickaxe = null;
    @ObjectHolder("skythern_axe")
    public static final Item skythernAxe = null;

    @ObjectHolder("mortum_shovel")
    public static final Item mortumShovel = null;
    @ObjectHolder("mortum_pickaxe")
    public static final Item mortumPickaxe = null;
    @ObjectHolder("mortum_axe")
    public static final Item mortumAxe = null;

    // Vethea tools
    @ObjectHolder("dream_shovel")
    public static final Item dreamShovel = null;
    @ObjectHolder("dream_pickaxe")
    public static final Item dreamPickaxe = null;
    @ObjectHolder("dream_axe")
    public static final Item dreamAxe = null;

    // Weapons
    @ObjectHolder("aquatic_maul")
    public static final Item aquaticMaul = null;
    @ObjectHolder("aquatic_dagger")
    public static final Item aquaticDagger = null;
    @ObjectHolder("aquatic_trident")
    public static final Item aquaticTrident = null;
    @ObjectHolder("aquaton")
    public static final Item aquaton = null;
    @ObjectHolder("aquatooth_maul")
    public static final Item aquatoothMaul = null;
    @ObjectHolder("aquatooth_sword")
    public static final Item aquatoothSword = null;
    @ObjectHolder("arlemite_stabber")
    public static final Item arlemiteStabber = null;
    @ObjectHolder("bedrock_maul")
    public static final Item bedrockMaul = null;
    @ObjectHolder("bedrock_sword")
    public static final Item bedrockSword = null;
    @ObjectHolder("black_ender_sword")
    public static final Item blackEnderSword = null;
    @ObjectHolder("bloodgem_sword")
    public static final Item bloodgem_sword = null;
    @ObjectHolder("blue_divine_sword")
    public static final Item blueDivineSword = null;
    @ObjectHolder("blue_ender_sword")
    public static final Item blueEnderSword = null;
    @ObjectHolder("bluefire_sword")
    public static final Item bluefireSword = null;
    @ObjectHolder("corrupted_maul")
    public static final Item corruptedMaul = null;
    @ObjectHolder("crabclaw_maul")
    public static final Item crabclawMaul = null;
    @ObjectHolder("cyclopsian_sword")
    public static final Item cyclopsianSword = null;
    @ObjectHolder("death_bringer")
    public static final Item deathBringer = null;
    @ObjectHolder("divine_sword")
    public static final Item divineSword = null;
    @ObjectHolder("dual_claw")
    public static final Item dualClaw = null;
    @ObjectHolder("ender_sword")
    public static final Item enderSword = null;
    @ObjectHolder("flaming_fury")
    public static final Item flamingFury = null;
    @ObjectHolder("frost_sword")
    public static final Item frostSword = null;
    @ObjectHolder("fury_maul")
    public static final Item furyMaul = null;
    @ObjectHolder("gray_divine_sword")
    public static final Item grayDivineSword = null;
    @ObjectHolder("green_divine_sword")
    public static final Item greenDivineSword = null;
    @ObjectHolder("green_ender_sword")
    public static final Item greenEnderSword = null;
    @ObjectHolder("inferno_sword")
    public static final Item infernoSword = null;
    @ObjectHolder("jungle_knife")
    public static final Item jungleKnife = null;
    @ObjectHolder("jungle_rapier")
    public static final Item jungleRapier = null;
    @ObjectHolder("molten_sword")
    public static final Item moltenSword = null;
    @ObjectHolder("ocean_knife")
    public static final Item oceanKnife = null;
    @ObjectHolder("poison_saber")
    public static final Item poisonSaber = null;
    @ObjectHolder("realmite_sword")
    public static final Item realmiteSword = null;
    @ObjectHolder("red_divine_sword")
    public static final Item redDivineSword = null;
    @ObjectHolder("red_ender_sword")
    public static final Item redEnderSword = null;
    @ObjectHolder("rupee_rapier")
    public static final Item rupeeRapier = null;
    @ObjectHolder("sandslash")
    public static final Item sandslash = null;
    @ObjectHolder("scorching_sword")
    public static final Item scorchingSword = null;
    @ObjectHolder("shark_sword")
    public static final Item sharkSword = null;
    @ObjectHolder("slime_sword")
    public static final Item slimeSword = null;
    @ObjectHolder("terran_dagger")
    public static final Item terranDagger = null;
    @ObjectHolder("terran_knife")
    public static final Item terranKnife = null;
    @ObjectHolder("terran_maul")
    public static final Item terranMaul = null;
    @ObjectHolder("yellow_divine_sword")
    public static final Item yellowDivineSword = null;
    @ObjectHolder("yellow_ender_sword")
    public static final Item yellowEnderSword = null;

    @ObjectHolder("bluefire_bow")
    public static final Item bluefireBow = null;
    @ObjectHolder("ender_bow")
    public static final Item enderBow = null;
    @ObjectHolder("hunter_bow")
    public static final Item hunterBow = null;
    @ObjectHolder("inferno_bow")
    public static final Item infernoBow = null;
    @ObjectHolder("shadow_bow")
    public static final Item shadowBow = null;

    @ObjectHolder("scythe")
    public static final Item scythe = null;

    @ObjectHolder("shuriken")
    public static final Item shuriken = null;
    @ObjectHolder("vile_storm")
    public static final Item vileStorm = null;

    @ObjectHolder("bowhead_anchor")
    public static final Item bowheadAnchor = null;
    @ObjectHolder("bowhead_cannon")
    public static final Item bowheadCannon = null;
    @ObjectHolder("corrupted_cannon")
    public static final Item corruptedCannon = null;
    @ObjectHolder("crab_anchor")
    public static final Item crabAnchor = null;
    @ObjectHolder("crabclaw_cannon")
    public static final Item crabclawCannon = null;
    @ObjectHolder("cyclopsian_staff")
    public static final Item cyclopsianStaff = null;
    @ObjectHolder("frost_cannon")
    public static final Item frostCannon = null;
    @ObjectHolder("ghast_cannon")
    public static final Item ghastCannon = null;
    @ObjectHolder("golden_fury")
    public static final Item goldenFury = null;
    @ObjectHolder("liopleurodon_anchor")
    public static final Item liopleurodonAnchor = null;
    @ObjectHolder("maelstrom")
    public static final Item maelstrom = null;
    @ObjectHolder("shark_anchor")
    public static final Item sharkAnchor = null;

    @ObjectHolder("sound_of_music")
    public static final Item soundOfMusic = null;

    @ObjectHolder("serenade_of_death")
    public static final Item serenadeOfDeath = null;
    @ObjectHolder("serenade_of_health")
    public static final Item serenadeOfHealth = null;
    @ObjectHolder("serenade_of_infusion")
    public static final Item serenadeOfInfusion = null;
    @ObjectHolder("serenade_striker")
    public static final Item serenadeStriker = null;

    @ObjectHolder("massivence")
    public static final Item massivence = null;
    @ObjectHolder("palavence")
    public static final Item palavence = null;


    // Iceika dimension weapons - melee
    @ObjectHolder("enderice")
    public static final Item enderice = null;
    @ObjectHolder("frostking_sword")
    public static final Item frostkingSword = null;
    @ObjectHolder("frozen_maul")
    public static final Item frozenMaul = null;
    @ObjectHolder("glacier_sword")
    public static final Item glacierSword = null;
    @ObjectHolder("icicle_bane")
    public static final Item icicleBane = null;
    @ObjectHolder("icine_sword")
    public static final Item icineSword = null;
    @ObjectHolder("snowslash")
    public static final Item snowslash = null;
    @ObjectHolder("frossivence")
    public static final Item frossivence = null;

    // Iceika dimension weapons - ranged
    @ObjectHolder("icicle_bow")
    public static final Item icicleBow = null;
    @ObjectHolder("snowstorm_bow")
    public static final Item snowstormBow = null;

    @ObjectHolder("snowflake_shuriken")
    public static final Item snowflakeShuriken = null;

    @ObjectHolder("fractite_cannon")
    public static final Item fractiteCannon = null;
    @ObjectHolder("frostclaw_cannon")
    public static final Item frostclawCannon = null;

    @ObjectHolder("sound_of_carols")
    public static final Item soundOfCarols = null;

    @ObjectHolder("serenade_of_ice")
    public static final Item serenadeOfIce = null;

    // Twilight swords
    @ObjectHolder("eden_blade")
    public static final Item edenBlade = null;
    @ObjectHolder("wildwood_blade")
    public static final Item wildwoodBlade = null;
    @ObjectHolder("apalachia_blade")
    public static final Item apalachiaBlade = null;
    @ObjectHolder("skythern_blade")
    public static final Item skythernBlade = null;
    @ObjectHolder("mortum_blade")
    public static final Item mortumBlade = null;
    @ObjectHolder("halite_blade")
    public static final Item haliteBlade = null;

    // Twilight bows
    @ObjectHolder("eden_bow")
    public static final Item edenBow = null;
    @ObjectHolder("wildwood_bow")
    public static final Item wildwoodBow = null;
    @ObjectHolder("apalachia_bow")
    public static final Item apalachiaBow = null;
    @ObjectHolder("skythern_bow")
    public static final Item skythernBow = null;
    @ObjectHolder("mortum_bow")
    public static final Item mortumBow = null;
    @ObjectHolder("halite_bow")
    public static final Item haliteBow = null;
    @ObjectHolder("twilight_bow")
    public static final Item twilightBow = null;

    // Twilight slicers
    @ObjectHolder("eden_slicer")
    public static final Item edenSlicer = null;
    @ObjectHolder("wildwood_slicer")
    public static final Item wildwoodSlicer = null;
    @ObjectHolder("apalachia_slicer")
    public static final Item apalachiaSlicer = null;
    @ObjectHolder("skythern_slicer")
    public static final Item skythernSlicer = null;
    @ObjectHolder("mortum_slicer")
    public static final Item mortumSlicer = null;
    @ObjectHolder("halite_slicer")
    public static final Item haliteSlicer = null;

    // Twilight blitzes
    @ObjectHolder("eden_blitz")
    public static final Item edenBlitz = null;
    @ObjectHolder("wildwood_blitz")
    public static final Item wildwoodBlitz = null;
    @ObjectHolder("apalachia_blitz")
    public static final Item apalachiaBlitz = null;
    @ObjectHolder("skythern_blitz")
    public static final Item skythernBlitz = null;
    @ObjectHolder("mortum_blitz")
    public static final Item mortumBlitz = null;
    @ObjectHolder("halite_blitz")
    public static final Item haliteBlitz = null;

    // Twilight phasers
    @ObjectHolder("eden_phaser")
    public static final Item edenPhaser = null;
    @ObjectHolder("wildwood_phaser")
    public static final Item wildwoodPhaser = null;
    @ObjectHolder("apalachia_phaser")
    public static final Item apalachiaPhaser = null;
    @ObjectHolder("skythern_phaser")
    public static final Item skythernPhaser = null;
    @ObjectHolder("mortum_phaser")
    public static final Item mortumPhaser = null;
    @ObjectHolder("halite_phaser")
    public static final Item halitePhaser = null;

    // Arcana melee
    @ObjectHolder("arcanite_blade")
    public static final Item arcaniteBlade = null;
    @ObjectHolder("arcanium_saber")
    public static final Item arcaniumSaber = null;
    @ObjectHolder("ender_scepter")
    public static final Item enderScepter = null;
    @ObjectHolder("livicia_sword")
    public static final Item liviciaSword = null;
    @ObjectHolder("shadow_saber")
    public static final Item shadowSaber = null;
    @ObjectHolder("storm_sword")
    public static final Item stormSword = null;

    // Arcana ranged
    @ObjectHolder("arcanite_blaster")
    public static final Item arcaniteBlaster = null;
    @ObjectHolder("captains_sparkler")
    public static final Item captainsSparkler = null;
    @ObjectHolder("firefly")
    public static final Item firefly = null;
    @ObjectHolder("generals_staff")
    public static final Item generalsStaff = null;
    @ObjectHolder("la_vekor")
    public static final Item laVekor = null;
    @ObjectHolder("meriks_missile")
    public static final Item meriksMissile = null;
    @ObjectHolder("meteor_mash")
    public static final Item meteorMash = null;
    @ObjectHolder("staff_of_starlight")
    public static final Item staffOfStarlight = null;
    @ObjectHolder("starlight")
    public static final Item starlight = null;

    // Arcana throwable
    @ObjectHolder("grenade")
    public static final Item grenade = null;

    // Vethea weapons
    // Backsword
    @ObjectHolder("teaker_backsword")
    public static final Item teakerBacksword = null;
    @ObjectHolder("amthirmis_backsword")
    public static final Item amthirmisBacksword = null;
    @ObjectHolder("darven_backsword")
    public static final Item darvenBacksword = null;
    @ObjectHolder("cermile_backsword")
    public static final Item cermileBacksword = null;
    @ObjectHolder("pardimal_backsword")
    public static final Item pardimalBacksword = null;
    @ObjectHolder("quadrotic_backsword")
    public static final Item quadroticBacksword = null;
    @ObjectHolder("karos_backsword")
    public static final Item karosBacksword = null;
    @ObjectHolder("heliosis_backsword")
    public static final Item heliosisBacksword = null;
    @ObjectHolder("arksiane_backsword")
    public static final Item arksianeBacksword = null;

    // Bow
    @ObjectHolder("teaker_bow")
    public static final Item teakerBow = null;
    @ObjectHolder("amthirmis_bow")
    public static final Item amthirmisBow = null;
    @ObjectHolder("darven_bow")
    public static final Item darvenBow = null;
    @ObjectHolder("cermile_bow")
    public static final Item cermileBow = null;
    @ObjectHolder("pardimal_bow")
    public static final Item pardimalBow = null;
    @ObjectHolder("quadrotic_bow")
    public static final Item quadroticBow = null;
    @ObjectHolder("karos_bow")
    public static final Item karosBow = null;
    @ObjectHolder("heliosis_bow")
    public static final Item heliosisBow = null;
    @ObjectHolder("arksiane_bow")
    public static final Item arksianeBow = null;
    @ObjectHolder("everfright")
    public static final Item everfright = null;

    // Cannon
    @ObjectHolder("teaker_cannon")
    public static final Item teakerCannon = null;
    @ObjectHolder("amthirmis_cannon")
    public static final Item amthirmisCannon = null;
    @ObjectHolder("darven_cannon")
    public static final Item darvenCannon = null;
    @ObjectHolder("cermile_cannon")
    public static final Item cermileCannon = null;
    @ObjectHolder("pardimal_cannon")
    public static final Item pardimalCannon = null;
    @ObjectHolder("quadrotic_cannon")
    public static final Item quadroticCannon = null;
    @ObjectHolder("karos_cannon")
    public static final Item karosCannon = null;
    @ObjectHolder("heliosis_cannon")
    public static final Item heliosisCannon = null;
    @ObjectHolder("arksiane_cannon")
    public static final Item arksianeCannon = null;
    @ObjectHolder("eversight")
    public static final Item eversight = null;

    // Claw
    @ObjectHolder("teaker_claw")
    public static final Item teakerClaw = null;
    @ObjectHolder("amthirmis_claw")
    public static final Item amthirmisClaw = null;
    @ObjectHolder("darven_claw")
    public static final Item darvenClaw = null;
    @ObjectHolder("cermile_claw")
    public static final Item cermileClaw = null;
    @ObjectHolder("pardimal_claw")
    public static final Item pardimalClaw = null;
    @ObjectHolder("quadrotic_claw")
    public static final Item quadroticClaw = null;
    @ObjectHolder("karos_claw")
    public static final Item karosClaw = null;
    @ObjectHolder("heliosis_claw")
    public static final Item heliosisClaw = null;
    @ObjectHolder("arksiane_claw")
    public static final Item arksianeClaw = null;
    @ObjectHolder("everbright")
    public static final Item everbright = null;

    // Disk
    @ObjectHolder("teaker_disk")
    public static final Item teakerDisk = null;
    @ObjectHolder("amthirmis_disk")
    public static final Item amthirmisDisk = null;
    @ObjectHolder("darven_disk")
    public static final Item darvenDisk = null;
    @ObjectHolder("cermile_disk")
    public static final Item cermileDisk = null;
    @ObjectHolder("pardimal_disk")
    public static final Item pardimalDisk = null;
    @ObjectHolder("quadrotic_disk")
    public static final Item quadroticDisk = null;
    @ObjectHolder("karos_disk")
    public static final Item karosDisk = null;
    @ObjectHolder("heliosis_disk")
    public static final Item heliosisDisk = null;
    @ObjectHolder("arksiane_disk")
    public static final Item arksianeDisk = null;

    // Hammer
    @ObjectHolder("teaker_hammer")
    public static final Item teakerHammer = null;
    @ObjectHolder("amthirmis_hammer")
    public static final Item amthirmisHammer = null;
    @ObjectHolder("darven_hammer")
    public static final Item darvenHammer = null;
    @ObjectHolder("cermile_hammer")
    public static final Item cermileHammer = null;
    @ObjectHolder("pardimal_hammer")
    public static final Item pardimalHammer = null;
    @ObjectHolder("quadrotic_hammer")
    public static final Item quadroticHammer = null;
    @ObjectHolder("karos_hammer")
    public static final Item karosHammer = null;
    @ObjectHolder("heliosis_hammer")
    public static final Item heliosisHammer = null;
    @ObjectHolder("arksiane_hammer")
    public static final Item arksianeHammer = null;
    @ObjectHolder("everlight")
    public static final Item everlight = null;
    @ObjectHolder("karos_rockmaul")
    public static final Item karosRockmaul = null;

    // Staff
    @ObjectHolder("teaker_staff")
    public static final Item teakerStaff = null;
    @ObjectHolder("amthirmis_staff")
    public static final Item amthirmisStaff = null;
    @ObjectHolder("darven_staff")
    public static final Item darvenStaff = null;
    @ObjectHolder("cermile_staff")
    public static final Item cermileStaff = null;
    @ObjectHolder("pardimal_staff")
    public static final Item pardimalStaff = null;
    @ObjectHolder("quadrotic_staff")
    public static final Item quadroticStaff = null;
    @ObjectHolder("karos_staff")
    public static final Item karosStaff = null;
    @ObjectHolder("heliosis_staff")
    public static final Item heliosisStaff = null;
    @ObjectHolder("arksiane_staff")
    public static final Item arksianeStaff = null;
    @ObjectHolder("evernight")
    public static final Item evernight = null;


    @ObjectHolder("smoldering_tar_bucket")
    public static final Item smolderingTarBucket = null;




    // Armor information
    // Vanilla dimensions
    private static ArmorInfo angelicInfo = new ArmorInfo(getArmorAbility("no_fall"), getArmorAbility("fly"));
    private static ArmorInfo aquastriveInfo = new ArmorInfo(getArmorAbility("underwater"), getArmorAbility("swim"));
    private static ArmorInfo arlemiteInfo = new ArmorInfo(getArmorAbility("ranged_protection", 85));
    private static ArmorInfo bedrockInfo = new ArmorInfo(getArmorAbility("fire_protection"), getArmorAbility("explosion_protection"));
    private static ArmorInfo corruptedInfo = new ArmorInfo(getArmorAbility("ranged_damage", 50));
    private static ArmorInfo divineInfo = new ArmorInfo(getArmorAbility("melee_damage", 6),
            getArmorAbility("jump_height", 2),
            getArmorAbility("no_fall"));
    private static ArmorInfo eliteRealmiteInfo = new ArmorInfo(getArmorAbility("no_fall"));
    private static ArmorInfo enderInfo = new ArmorInfo(getArmorAbility("explosion_protection"));
    private static ArmorInfo frozenInfo = new ArmorInfo(getArmorAbility("freeze", 6));
    private static ArmorInfo infernoInfo = new ArmorInfo(getArmorAbility("fire_protection"));
    private static ArmorInfo jackomanInfo = new ArmorInfo(getArmorAbility("scythe_damage", 3));
    private static ArmorInfo jungleInfo = new ArmorInfo(getArmorAbility("poison_protection"));
    private static ArmorInfo krakenInfo = new ArmorInfo(getArmorAbility("underwater"));
    private static ArmorInfo torriditeInfo = new ArmorInfo(getArmorAbility("fire_protection"));
    private static ArmorInfo rupeeInfo = new ArmorInfo(getArmorAbility("melee_protection", 85));
    private static ArmorInfo shadowInfo = new ArmorInfo(getArmorAbility("speed", 3), getArmorAbility("step_assist"));
    private static ArmorInfo skelemanInfo = new ArmorInfo(getArmorAbility("hunger"));
    private static ArmorInfo terranInfo = new ArmorInfo(getArmorAbility("haste"));
    private static ArmorInfo witherReaperInfo = new ArmorInfo(getArmorAbility("wither_protection"));
    private static ArmorInfo kingInfo = new ArmorInfo(new StringTextComponent("Absorbs super-power from other sets"));

    // Iceika
    private static ArmorInfo santaInfo = new ArmorInfo(new TranslationTextComponent("tooltip.armor_info.massive_buff"),
            getArmorAbility("speed", 2),
            getArmorAbility("melee_damage", 6),
            getArmorAbility("hunger"),
            getArmorAbility("melee_protection", 80))
            .withDimension(new TranslationTextComponent("tooltip.armor_info.iceika"), x -> Objects.equals(x, KeyRegistry.ICEIKA_WORLD));

    // Twilight
    private static ArmorInfo edenInfo = new ArmorInfo(getArmorAbility("ore_drops", 3));
    private static ArmorInfo wildInfo = new ArmorInfo(getArmorAbility("underwater_health_regen"));
    private static ArmorInfo apInfo = new ArmorInfo(getArmorAbility("block_protection"));
    private static ArmorInfo skyInfo = new ArmorInfo(getArmorAbility("jump_height", 5), getArmorAbility("no_fall"));
    private static ArmorInfo mortInfo = new ArmorInfo(getArmorAbility("night_vision"));
    private static ArmorInfo halInfo = new ArmorInfo(getArmorAbility("melee_damage", 16));
    private static ArmorInfo awakened_halInfo = new ArmorInfo(getArmorAbility("melee_damage", 20),
            getArmorAbility("ranged_damage", 50));

    // Arcana
    private static ArmorInfo kormInfo = new ArmorInfo(getArmorAbility("arcana_regen"));
    private static ArmorInfo vemInfo = new ArmorInfo(getArmorAbility("health_regen"));

    // Vethea
    private static ArmorInfo basicHelmInfo = new ArmorInfo(getArmorAbility("melee_protection", 15));
    private static ArmorInfo basicMaskInfo = new ArmorInfo(getArmorAbility("ranged_protection", 15));
    private static ArmorInfo basicHoodInfo = new ArmorInfo(getArmorAbility("arcana_protection", 15));

    private static ArmorInfo glisteningHelmInfo = new ArmorInfo(getArmorAbility("melee_protection", 15), getArmorAbility("melee_damage", 3));
    private static ArmorInfo glisteningMaskInfo = new ArmorInfo(getArmorAbility("ranged_protection", 15), getArmorAbility("speed", 1.4));
    private static ArmorInfo glisteningHoodInfo = new ArmorInfo(getArmorAbility("arcana_protection", 15), getArmorAbility("jump_height", 2), getArmorAbility("no_fall"));

    private static ArmorInfo demonizedHelmInfo = new ArmorInfo(getArmorAbility("melee_protection", 15), getArmorAbility("melee_damage", 6));
    private static ArmorInfo demonizedMaskInfo = new ArmorInfo(getArmorAbility("ranged_protection", 15), getArmorAbility("speed", 1.8));
    private static ArmorInfo demonizedHoodInfo = new ArmorInfo(getArmorAbility("arcana_protection", 15), getArmorAbility("jump_height", 3), getArmorAbility("no_fall"));

    private static ArmorInfo tormentedHelmInfo = new ArmorInfo(getArmorAbility("melee_protection", 15), getArmorAbility("melee_damage", 9));
    private static ArmorInfo tormentedMaskInfo = new ArmorInfo(getArmorAbility("ranged_protection", 15), getArmorAbility("speed", 2.2));
    private static ArmorInfo tormentedHoodInfo = new ArmorInfo(getArmorAbility("arcana_protection", 15), getArmorAbility("jump_height", 4), getArmorAbility("no_fall"));



    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> e) {
        DivineRPG.LOGGER.info("[DivineRPG] Registered items");
        register(e, new ItemMod("apalachia_chunk"));
        register(e, new ItemMod("apalachia_dust"));
        register(e, new ItemMod("apalachia_fragments"));
        register(e, new ItemMod("apalachia_gem"));
        register(e, new ItemMod("apalachia_heart"));
        register(e, new ItemMod("apalachia_soul"));
        register(e, new ItemMod("aqua_ball"));
        register(e, new ItemMod("aquatic_blaze_rod"));
        register(e, new ItemMod("aquatic_ingot"));
        register(e, new ItemMod("aquatic_pellets"));
        register(e, new ItemMod("arcanium"));
        register(e, new ItemMod("arlemite_ingot"));
        register(e, new ItemMod("arlemite_nugget"));
        register(e, new ItemMod("base_spawn_crystal"));
        register(e, new ItemMod("bedrock_chunk"));
        register(e, new ItemMod("bloodgem"));
        register(e, new ItemMod("blue_diamond_chunk"));
        register(e, new ItemMod("bluefire_stone"));
        register(e, new ItemMod("collector_fragments"));
        register(e, new ItemMod("corrupted_bullet"));
        register(e, new ItemMod("corrupted_shards"));
        register(e, new ItemMod("corrupted_stone"));
        register(e, new ItemMod("crab_claw"));
        register(e, new ItemMod("cyclops_eye"));
        register(e, new ItemMod("cyclops_eye_shards"));
        register(e, new ItemMod("divine_shards"));
        register(e, new ItemMod("divine_stone"));
        register(e, new ItemMod("dungeon_tokens"));
        register(e, new ItemMod("eden_arrow", DivineRPG.tabs.ranged));
        register(e, new ItemMod("eden_chunk"));
        register(e, new ItemMod("eden_dust"));
        register(e, new ItemMod("eden_fragments"));
        register(e, new ItemMod("eden_gem"));
        register(e, new ItemMod("eden_heart"));
        register(e, new ItemMod("eden_soul"));
        register(e, new ItemMod("eden_sparkles"));
        register(e, new ItemMod("ender_shards"));
        register(e, new ItemMod("ender_stone"));
        register(e, new ItemMod("firestock"));
        register(e, new ItemMod("fury_arrow", DivineRPG.tabs.ranged));
        register(e, new ItemMod("fury_fire"));
        register(e, new ItemMod("gray_diamond_chunk"));
        register(e, new ItemMod("green_diamond_chunk"));
        register(e, new ItemMod("hellstone_ingot"));
        register(e, new ItemMod("ice_shards"));
        register(e, new ItemMod("ice_stone"));
        register(e, new ItemMod("jungle_shards"));
        register(e, new ItemMod("jungle_stone"));
        register(e, new ItemMod("kraken_scale"));
        register(e, new ItemMod("kraken_skin"));
        register(e, new ItemMod("lamona"));
        register(e, new ItemMod("legendary_ender_eye"));
        register(e, new ItemMod("liopleurodon_skull"));
        register(e, new ItemMod("liopleurodon_teeth"));
        register(e, new ItemMod("marsine"));
        register(e, new ItemMod("molten_shards"));
        register(e, new ItemMod("molten_stone"));
        register(e, new ItemMod("mortum_chunk"));
        register(e, new ItemMod("mortum_dust"));
        register(e, new ItemMod("mortum_fragments"));
        register(e, new ItemMod("mortum_gem"));
        register(e, new ItemMod("mortum_heart"));
        register(e, new ItemMod("mortum_soul"));
        register(e, new ItemMod("orb_of_light"));
        register(e, new ItemMod("pure_aquatic_pellets"));
        register(e, new ItemMod("purple_blaze"));
        register(e, new ItemMod("realmite_ingot"));
        register(e, new ItemMod("realmite_nugget"));
        register(e, new ItemMod("red_diamond_chunk"));
        register(e, new ItemMod("rupee_ingot"));
        register(e, new ItemMod("rupee_nugget"));
        register(e, new ItemMod("shadow_bar"));
        register(e, new ItemMod("shadow_coins"));
        register(e, new ItemMod("shadow_stone"));
        register(e, new ItemMod("shark_fin"));
        register(e, new ItemMod("skythern_chunk"));
        register(e, new ItemMod("skythern_dust"));
        register(e, new ItemMod("skythern_fragments"));
        register(e, new ItemMod("skythern_gem"));
        register(e, new ItemMod("skythern_heart"));
        register(e, new ItemMod("skythern_soul"));
        register(e, new ItemMod("snowflake"));
        register(e, new ItemMod("terran_shards"));
        register(e, new ItemMod("terran_stone"));
        register(e, new ItemMod("torridite_chunk"));
        register(e, new ItemMod("torridite_ingot"));
        register(e, new ItemMod("torridite_nugget"));
        register(e, new ItemMod("veilo"));
        register(e, new ItemMod("watching_eye"));
        register(e, new ItemMod("whale_fin"));
        register(e, new ItemMod("wildwood_arrow", DivineRPG.tabs.ranged));
        register(e, new ItemMod("wildwood_chunk"));
        register(e, new ItemMod("wildwood_dust"));
        register(e, new ItemMod("wildwood_fragments"));
        register(e, new ItemMod("wildwood_gem"));
        register(e, new ItemMod("wildwood_heart"));
        register(e, new ItemMod("wildwood_soul"));
        register(e, new ItemMod("yellow_diamond_chunk"));
        register(e, new ItemMod("ancient_key"));
        register(e, new ItemMod("degraded_key"));
        register(e, new ItemMod("sludge_key"));
        register(e, new ItemMod("soul_key"));
        register(e, new ItemAttractor());
        register(e, new ItemBossSpawner("call_of_the_watcher", "message.watcher", World.NETHER, EntityRegistry.THE_WATCHER));
        register(e, new ItemBossSpawner("densos_crystal", "tooltip.mortum_only", KeyRegistry.MORTUM_WORLD, EntityRegistry.REYVOR, EntityRegistry.DENSOS));
        register(e, new ItemBossSpawner("infernal_flame", "message.king_of_scorchers", World.NETHER, EntityRegistry.KING_OF_SCORCHERS));
        register(e, new ItemBossSpawner("karot_crystal", "tooltip.mortum_only", KeyRegistry.MORTUM_WORLD, EntityRegistry.KAROT));
        register(e, new ItemBossSpawner("mysterious_clock", "message.ancient_entity", World.OVERWORLD, EntityRegistry.ANCIENT_ENTITY));
        register(e, new ItemBossSpawner("reyvor_crystal", "tooltip.mortum_only", KeyRegistry.MORTUM_WORLD, EntityRegistry.REYVOR, EntityRegistry.DENSOS));
        register(e, new ItemBossSpawner("soul_fiend_crystal", "tooltip.mortum_only", KeyRegistry.MORTUM_WORLD, EntityRegistry.SOUL_FIEND));
        register(e, new ItemBossSpawner("twilight_demon_crystal", "tooltip.mortum_only", KeyRegistry.MORTUM_WORLD, EntityRegistry.TWILIGHT_DEMON));
        register(e, new ItemBossSpawner("vamacheron_crystal", "tooltip.mortum_only", KeyRegistry.MORTUM_WORLD, EntityRegistry.VAMACHERON));
        register(e, new ItemChargedCollector("collector"));
        register(e, new ItemHealingFood(FoodList.DREAM_SWEETS, "dream_sweets"));
        register(e, new ItemHealingFood(FoodList.DREAM_SOURS, "dream_sours"));
        register(e, new ItemHealingStone("healing_stone", 20));
        register(e, new ItemMinersAmulet("miners_amulet"));
        register(e, new ItemReflector());
        register(e, new ItemSkyFlower("sky_flower"));
        register(e, new ItemSnowGlobe());
        register(e, new ItemStaffEnrichment());
        register(e, new ItemWizardsBook());
        register(e, new ItemAnchor("bowhead_anchor", BulletType.BOWHEAD_ANCHOR_SHOT));
        register(e, new ItemAnchor("crab_anchor", BulletType.CRAB_ANCHOR_SHOT));
        register(e, new ItemAnchor("liopleurodon_anchor", BulletType.LIOPLEURODON_ANCHOR_SHOT));
        register(e, new ItemAnchor("shark_anchor", BulletType.SHARK_ANCHOR_SHOT));
        register(e, new ItemArcanaPoweredSword("arcanite_blade", DivineToolMaterials.ARCANITE_BLADE, 30, 6.0F));
        register(e, new ItemArcanaPoweredSword("arcanium_saber", DivineToolMaterials.ARCANIUM_SABER, 25, 5.0F));
        register(e, new ItemArcaniteBlaster());
        register(e, new ItemBurningSword(DivineToolMaterials.FLAMING_FURY, "flaming_fury", 15));
        register(e, new ItemBurningSword(DivineToolMaterials.INFERNO_SWORD, "inferno_sword", 12));
        register(e, new ItemBurningSword(DivineToolMaterials.MOLTEN_SWORD, "molten_sword", 5));
        register(e, new ItemCaptainsSparkler());
        register(e, new ItemCorruptedCannon());
        register(e, new ItemEnderScepter());
        register(e, new ItemEvernight(115, 80, "evernight"));
        register(e, new ItemFirefly());
        register(e, new ItemGeneralsStaff());
        register(e, new ItemGrenade());
        register(e, new ItemHealingSword("frossivence", DivineToolMaterials.FROSSIVENCE, 1F));
        register(e, new ItemHealingSword("massivence", DivineToolMaterials.PALAVENCE, 1F));
        register(e, new ItemHealingSword("palavence", DivineToolMaterials.PALAVENCE, 0.5F));
        register(e, new ItemLaVekor());
        register(e, new ItemMeriksMissile("meriks_missile"));
        register(e, new ItemMeteorMash());
        register(e, new ItemMusicShooter("sound_of_carols", SoundRegistry.SOUND_OF_CAROLS, EntityRegistry.SOUND_OF_CAROLS));
        register(e, new ItemMusicShooter("sound_of_music", SoundRegistry.SOUND_OF_MUSIC, EntityRegistry.SOUND_OF_MUSIC));
        register(e, new ItemPoisonousSword(DivineToolMaterials.JUNGLE_KNIFE, "jungle_knife", 2.5f));
        register(e, new ItemPoisonousSword(DivineToolMaterials.JUNGLE_RAPIER, "jungle_rapier", 4f));
        register(e, new ItemPoisonousSword(DivineToolMaterials.POISON_SABER, "poison_saber", 5));
        register(e, new ItemScythe());
        register(e, new ItemSerenadeOfDeath());
        register(e, new ItemSerenadeOfHealth());
        register(e, new ItemSerenadeOfIce());
        register(e, new ItemSerenadeOfInfusion());
        register(e, new ItemSerenadeStriker());
        register(e, new ItemShadowSaber("shadow_saber", DivineToolMaterials.SHADOW_SABER));
        register(e, new ItemSlowingSword(DivineToolMaterials.ENDERICE, "enderice"));
        register(e, new ItemSlowingSword(DivineToolMaterials.FROST_SWORD, "frost_sword"));
        register(e, new ItemSlowingSword(DivineToolMaterials.FROSTKING_SWORD, "frostking_sword"));
        register(e, new ItemSlowingSword(DivineToolMaterials.FROZEN_MAUL, "frozen_maul"));
        register(e, new ItemSlowingSword(DivineToolMaterials.GLACIER_SWORD, "glacier_sword"));
        register(e, new ItemSlowingSword(DivineToolMaterials.ICICLE_BANE, "icicle_bane"));
        register(e, new ItemSlowingSword(DivineToolMaterials.ICINE_SWORD, "icine_sword"));
        register(e, new ItemSlowingSword(DivineToolMaterials.SNOWSLASH, "snowslash"));
        register(e, new ItemStaff(3, 10, "teaker_staff"));
        register(e, new ItemStaff(5, 10, "amthirmis_staff"));
        register(e, new ItemStaff(8, 10, "darven_staff"));
        register(e, new ItemStaff(12, 10, "cermile_staff"));
        register(e, new ItemStaff(15, 10, "pardimal_staff"));
        register(e, new ItemStaff(19, 10, "quadrotic_staff"));
        register(e, new ItemStaff(21, 10, "karos_staff"));
        register(e, new ItemStaff(28, 10, "heliosis_staff"));
        register(e, new ItemStaff(36, 10, "arksiane_staff"));
        register(e, new ItemStaffStarlight("staff_of_starlight", 25, 8));
        register(e, new ItemStaffStarlight("starlight", 5, 1));
        register(e, new ItemStormSword("storm_sword", DivineToolMaterials.STORM_SWORD));
        register(e, new ItemModThrowable("apalachia_slicer", BulletType.APALACHIA_SLICER_SHOT));
        register(e, new ItemModThrowable("eden_slicer", BulletType.EDEN_SLICER_SHOT));
        register(e, new ItemModThrowable("halite_slicer", BulletType.HALITE_SLICER_SHOT));
        register(e, new ItemModThrowable("mortum_slicer", BulletType.MORTUM_SLICER_SHOT));
        register(e, new ItemThrowingStar("shuriken"));
        register(e, new ItemModThrowable("skythern_slicer", BulletType.SKYTHERN_SLICER_SHOT));
        register(e, new ItemThrowingStar("snowflake_shuriken"));
        register(e, new ItemModThrowable("wildwood_slicer", BulletType.WILDWOOD_SLICER_SHOT));
        register(e, new ItemTwilightBlitz("apalachia_blitz", BulletType.APALACHIA_BLITZ_SHOT, () -> ItemRegistry.apalachiaDust));
        register(e, new ItemTwilightBlitz("eden_blitz", BulletType.EDEN_BLITZ_SHOT, () -> ItemRegistry.edenDust));
        register(e, new ItemTwilightBlitz("halite_blitz", BulletType.HALITE_BLITZ_SHOT, () -> ItemRegistry.mortumDust));
        register(e, new ItemTwilightBlitz("mortum_blitz", BulletType.MORTUM_BLITZ_SHOT, () -> ItemRegistry.mortumDust));
        register(e, new ItemTwilightBlitz("skythern_blitz", BulletType.SKYTHERN_BLITZ_SHOT, () -> ItemRegistry.skythernDust));
        register(e, new ItemTwilightBlitz("wildwood_blitz", BulletType.WILDWOOD_BLITZ_SHOT, () -> ItemRegistry.wildwoodDust));
        register(e, new ItemVetheanBow("amthirmis_bow", ArrowType.AMTHIRMIS_ARROW, -1, () -> ItemRegistry.teakerArrow));
        register(e, new ItemVetheanBow("arksiane_bow", ArrowType.ARKSIANE_ARROW, -1, () -> ItemRegistry.karosArrow));
        register(e, new ItemVetheanBow("cermile_bow", ArrowType.CERMILE_ARROW, -1, () -> ItemRegistry.darvenArrow));
        register(e, new ItemVetheanBow("darven_bow", ArrowType.DARVEN_ARROW, -1, () -> ItemRegistry.darvenArrow));
        register(e, new ItemVetheanBow("everfright", ArrowType.EVERFRIGHT, -1, () -> ItemRegistry.everArrow));
        register(e, new ItemVetheanBow("heliosis_bow", ArrowType.HELIOSIS_ARROW, -1, () -> ItemRegistry.karosArrow));
        register(e, new ItemVetheanBow("karos_bow", ArrowType.KAROS_ARROW, -1, () -> ItemRegistry.karosArrow));
        register(e, new ItemVetheanBow("pardimal_bow", ArrowType.PARDIMAL_ARROW, -1, () -> ItemRegistry.pardimalArrow));
        register(e, new ItemVetheanBow("quadrotic_bow", ArrowType.QUADROTIC_ARROW, -1, () -> ItemRegistry.pardimalArrow));
        register(e, new ItemVetheanBow("teaker_bow", ArrowType.TEAKER_ARROW, -1, () -> ItemRegistry.teakerArrow));
        register(e, new ItemVetheanCannon("amthirmis_cannon", BulletType.AMTHIRMIS_CANNON_SHOT, () -> ItemRegistry.acid));
        register(e, new ItemVetheanCannon("arksiane_cannon", BulletType.ARKSIANE_CANNON_SHOT, () -> ItemRegistry.acid));
        register(e, new ItemVetheanCannon("cermile_cannon", BulletType.CERMILE_CANNON_SHOT, () -> ItemRegistry.acid));
        register(e, new ItemVetheanCannon("darven_cannon", BulletType.DARVEN_CANNON_SHOT, () -> ItemRegistry.acid));
        register(e, new ItemVetheanCannon("eversight", BulletType.EVERSIGHT_SHOT, () -> ItemRegistry.acid));
        register(e, new ItemVetheanCannon("heliosis_cannon", BulletType.HELIOSIS_CANNON_SHOT, () -> ItemRegistry.acid));
        register(e, new ItemVetheanCannon("karos_cannon", BulletType.KAROS_CANNON_SHOT, () -> ItemRegistry.acid));
        register(e, new ItemVetheanCannon("pardimal_cannon", BulletType.PARDIMAL_CANNON_SHOT, () -> ItemRegistry.acid));
        register(e, new ItemVetheanCannon("quadrotic_cannon", BulletType.QUADROTIC_CANNON_SHOT, () -> ItemRegistry.acid));
        register(e, new ItemVetheanCannon("teaker_cannon", BulletType.TEAKER_CANNON_SHOT, () -> ItemRegistry.acid));
        register(e, new ItemVetheanDisk("amthirmis_disk", DiskType.AMTHRIMIS_DISK));
        register(e, new ItemVetheanDisk("arksiane_disk", DiskType.ARKSIANE_DISK));
        register(e, new ItemVetheanDisk("cermile_disk", DiskType.CERMILE_DISK));
        register(e, new ItemVetheanDisk("darven_disk", DiskType.DARVEN_DISK));
        register(e, new ItemVetheanDisk("heliosis_disk", DiskType.HELIOSIS_DISK));
        register(e, new ItemVetheanDisk("karos_disk", DiskType.KAROS_DISK));
        register(e, new ItemVetheanDisk("pardimal_disk", DiskType.PARDIMAL_DISK));
        register(e, new ItemVetheanDisk("quadrotic_disk", DiskType.QUADROTIC_DISK));
        register(e, new ItemVetheanDisk("teaker_disk", DiskType.TEAKER_DISK));
        register(e, new ItemVetheanSword(DivineToolMaterials.AMTHIRMIS_BACKSWORD, "amthirmis_backsword"));
        register(e, new ItemVetheanSword(DivineToolMaterials.AMTHIRMIS_CLAW, "amthirmis_claw"));
        register(e, new ItemVetheanSword(DivineToolMaterials.AMTHIRMIS_HAMMER, "amthirmis_hammer"));
        register(e, new ItemVetheanSword(DivineToolMaterials.ARKSIANE_BACKSWORD, "arksiane_backsword"));
        register(e, new ItemVetheanSword(DivineToolMaterials.ARKSIANE_CLAW, "arksiane_claw"));
        register(e, new ItemVetheanSword(DivineToolMaterials.ARKSIANE_HAMMER, "arksiane_hammer"));
        register(e, new ItemVetheanSword(DivineToolMaterials.CERMILE_BACKSWORD, "cermile_backsword"));
        register(e, new ItemVetheanSword(DivineToolMaterials.CERMILE_CLAW, "cermile_claw"));
        register(e, new ItemVetheanSword(DivineToolMaterials.CERMILE_HAMMER, "cermile_hammer"));
        register(e, new ItemVetheanSword(DivineToolMaterials.DARVEN_BACKSWORD, "darven_backsword"));
        register(e, new ItemVetheanSword(DivineToolMaterials.DARVEN_CLAW, "darven_claw"));
        register(e, new ItemVetheanSword(DivineToolMaterials.DARVEN_HAMMER, "darven_hammer"));
        register(e, new ItemVetheanSword(DivineToolMaterials.EVERBRIGHT, "everbright"));
        register(e, new ItemVetheanSword(DivineToolMaterials.EVERLIGHT, "everlight"));
        register(e, new ItemVetheanSword(DivineToolMaterials.HELIOSIS_BACKSWORD, "heliosis_backsword"));
        register(e, new ItemVetheanSword(DivineToolMaterials.HELIOSIS_CLAW, "heliosis_claw"));
        register(e, new ItemVetheanSword(DivineToolMaterials.HELIOSIS_HAMMER, "heliosis_hammer"));
        register(e, new ItemVetheanSword(DivineToolMaterials.KAROS_BACKSWORD, "karos_backsword"));
        register(e, new ItemVetheanSword(DivineToolMaterials.KAROS_CLAW, "karos_claw"));
        register(e, new ItemVetheanSword(DivineToolMaterials.KAROS_HAMMER, "karos_hammer"));
        register(e, new ItemVetheanSword(DivineToolMaterials.KAROS_ROCKMAUL, "karos_rockmaul"));
        register(e, new ItemVetheanSword(DivineToolMaterials.PARDIMAL_BACKSWORD, "pardimal_backsword"));
        register(e, new ItemVetheanSword(DivineToolMaterials.PARDIMAL_CLAW, "pardimal_claw"));
        register(e, new ItemVetheanSword(DivineToolMaterials.PARDIMAL_HAMMER, "pardimal_hammer"));
        register(e, new ItemVetheanSword(DivineToolMaterials.QUADROTIC_BACKSWORD, "quadrotic_backsword"));
        register(e, new ItemVetheanSword(DivineToolMaterials.QUADROTIC_CLAW, "quadrotic_claw"));
        register(e, new ItemVetheanSword(DivineToolMaterials.QUADROTIC_HAMMER, "quadrotic_hammer"));
        register(e, new ItemVetheanSword(DivineToolMaterials.TEAKER_BACKSWORD, "teaker_backsword"));
        register(e, new ItemVetheanSword(DivineToolMaterials.TEAKER_CLAW, "teaker_claw"));
        register(e, new ItemVetheanSword(DivineToolMaterials.TEAKER_HAMMER, "teaker_hammer"));
        register(e, new ItemThrowingStar("vile_storm"));
        register(e, new ItemTeleportationCrystal());
        register(e, new ItemTeleportationStar());
        registerArmorSet(e, "angelic", MaterialRegistry.ANGELIC_ARMOR, angelicInfo);
        registerArmorSet(e, "apalachia", MaterialRegistry.APALACHIA_ARMOR, apInfo);
        registerArmorSet(e, "aquastrive", MaterialRegistry.AQUASTRIVE_ARMOR, aquastriveInfo);
        registerArmorSet(e, "arlemite", MaterialRegistry.ARLEMITE_ARMOR, arlemiteInfo);
        registerArmorSet(e, "awakened_halite", MaterialRegistry.AWAKENED_HALITE_ARMOR, awakened_halInfo);
        registerArmorSet(e, "bedrock", MaterialRegistry.BEDROCK_ARMOR, bedrockInfo);
        registerArmorSet(e, "blue_ender", MaterialRegistry.BLUE_ENDER_ARMOR, enderInfo);
        registerArmorSet(e, "blue_rupee", MaterialRegistry.BLUE_RUPEE_ARMOR, rupeeInfo);
        registerArmorSet(e, "corrupted", MaterialRegistry.CORRUPTED_ARMOR, corruptedInfo);
        registerArmorSet(e, "divine", MaterialRegistry.DIVINE_ARMOR, divineInfo);
        registerArmorSet(e, "eden", MaterialRegistry.EDEN_ARMOR, edenInfo);
        registerArmorSet(e, "elite_realmite", MaterialRegistry.ELITE_REALMITE_ARMOR, eliteRealmiteInfo);
        registerArmorSet(e, "ender", MaterialRegistry.ENDER_ARMOR, enderInfo);
        registerArmorSet(e, "frozen", MaterialRegistry.FROZEN_ARMOR, frozenInfo);
        registerArmorSet(e, "gray_ender", MaterialRegistry.GRAY_ENDER_ARMOR, enderInfo);
        registerArmorSet(e, "gray_rupee", MaterialRegistry.GRAY_RUPEE_ARMOR, rupeeInfo);
        registerArmorSet(e, "green_ender", MaterialRegistry.GREEN_ENDER_ARMOR, enderInfo);
        registerArmorSet(e, "green_rupee", MaterialRegistry.GREEN_RUPEE_ARMOR, rupeeInfo);
        registerArmorSet(e, "halite", MaterialRegistry.HALITE_ARMOR, halInfo);
        registerArmorSet(e, "inferno", MaterialRegistry.INFERNO_ARMOR, infernoInfo);
        registerArmorSet(e, "jack_o_man", MaterialRegistry.JACK_O_MAN_ARMOR, jackomanInfo);
        registerArmorSet(e, "jungle", MaterialRegistry.JUNGLE_ARMOR, jungleInfo);
        registerArmorSet(e, "korma", MaterialRegistry.KORMA_ARMOR, kormInfo);
        registerArmorSet(e, "kraken", MaterialRegistry.KRAKEN_ARMOR, krakenInfo);
        registerArmorSet(e, "mortum", MaterialRegistry.MORTUM_ARMOR, mortInfo);
        registerArmorSet(e, "realmite", MaterialRegistry.REALMITE_ARMOR);
        registerArmorSet(e, "red_ender", MaterialRegistry.RED_ENDER_ARMOR, enderInfo);
        registerArmorSet(e, "red_rupee", MaterialRegistry.RED_RUPEE_ARMOR, rupeeInfo);
        registerArmorSet(e, "rupee", MaterialRegistry.RUPEE_ARMOR, rupeeInfo);
        registerArmorSet(e, "santa", MaterialRegistry.SANTA_ARMOR, santaInfo);
        registerArmorSet(e, "shadow", MaterialRegistry.SHADOW_ARMOR, shadowInfo);
        registerArmorSet(e, "skeleman", MaterialRegistry.SKELEMAN_ARMOR, skelemanInfo);
        registerArmorSet(e, "skythern", MaterialRegistry.SKYTHERN_ARMOR, skyInfo);
        registerArmorSet(e, "terran", MaterialRegistry.TERRAN_ARMOR, terranInfo);
        registerArmorSet(e, "torridite", MaterialRegistry.TORRIDITE_ARMOR, torriditeInfo);
        registerArmorSet(e, "vemos", MaterialRegistry.VEMOS_ARMOR, vemInfo);
        registerArmorSet(e, "wildwood", MaterialRegistry.WILDWOOD_ARMOR, wildInfo);
        registerArmorSet(e, "wither_reaper", MaterialRegistry.WITHER_REAPER_ARMOR, witherReaperInfo);
        registerArmorSet(e, "yellow_ender", MaterialRegistry.YELLOW_ENDER_ARMOR, enderInfo);
        registerArmorSet(e, "yellow_rupee", MaterialRegistry.YELLOW_RUPEE_ARMOR, rupeeInfo);
        registerVetheanArmorSet(e, "degraded", MaterialRegistry.DEGRADED_ARMOR, MaterialRegistry.DEGRADED_ARMOR, MaterialRegistry.DEGRADED_ARMOR, basicHelmInfo, basicHoodInfo, basicMaskInfo, new ArmorInfo());
        registerVetheanArmorSet(e, "demonized", MaterialRegistry.DEMONIZED_ARMOR, MaterialRegistry.DEMONIZED_ARMOR, MaterialRegistry.DEMONIZED_ARMOR, demonizedHelmInfo, demonizedHoodInfo, demonizedMaskInfo, new ArmorInfo());
        registerVetheanArmorSet(e, "finished", MaterialRegistry.FINISHED_ARMOR, MaterialRegistry.FINISHED_ARMOR, MaterialRegistry.FINISHED_ARMOR);
        registerVetheanArmorSet(e, "glistening", MaterialRegistry.GLISTENING_ARMOR, MaterialRegistry.GLISTENING_ARMOR, MaterialRegistry.GLISTENING_ARMOR, glisteningHelmInfo, glisteningHoodInfo, glisteningMaskInfo, new ArmorInfo());
        registerVetheanArmorSet(e, "tormented", MaterialRegistry.TORMENTED_ARMOR, MaterialRegistry.TORMENTED_ARMOR, MaterialRegistry.TORMENTED_ARMOR, tormentedHelmInfo, tormentedHoodInfo, tormentedMaskInfo, new ArmorInfo());
        register(e, new DivineShield("apalachia_shield", DivineRPG.tabs.armor, apalachiaChunk, 4800));
        register(e, new DivineShield("arlemite_shield", DivineRPG.tabs.armor, arlemiteIngot, 1200));
        register(e, new DivineShield("eden_shield", DivineRPG.tabs.armor, edenChunk, 1200));
        register(e, new DivineShield("halite_shield", DivineRPG.tabs.armor, Item.byBlock(Blocks.AIR), 0));
        register(e, new DivineShield("mortum_shield", DivineRPG.tabs.armor, mortumChunk, 19200));
        register(e, new DivineShield("realmite_shield", DivineRPG.tabs.armor, realmiteIngot, 1200));
        register(e, new DivineShield("rupee_shield", DivineRPG.tabs.armor, rupeeIngot, 1200));
        register(e, new DivineShield("skythern_shield", DivineRPG.tabs.armor, skythernChunk, 9600));
        register(e, new DivineShield("wildwood_shield", DivineRPG.tabs.armor, wildwoodChunk, 2400));
        register(e, new ItemAquamarine("aquamarine"));
        register(e, new ItemArcanaPotion("strong_arcana_potion", 200));
        register(e, new ItemArcanaPotion("weak_arcana_potion", 100));
        register(e, new ItemDivineAccumulator());
        register(e, new ItemEggNog("egg_nog"));
        register(e, new ItemModFood("moonbulb", FoodList.MOONBULB, DivineRPG.tabs.food));
        register(e, new ItemModFood("pink_glowbone", FoodList.PINK_GLOWBONE, DivineRPG.tabs.food));
        register(e, new ItemModFood("purple_glowbone", FoodList.PURPLE_GLOWBONE, DivineRPG.tabs.food));
        register(e, new ItemModFood("magic_meat", FoodList.MAGIC_MEAT, DivineRPG.tabs.food));
        register(e, new ItemModFood("enriched_magic_meat", FoodList.ENRICHED_MAGIC_MEAT, DivineRPG.tabs.food));
        register(e, new ItemForbiddenFruit());
        register(e, new ItemGhostbane());
        register(e, new ItemHordeHorn("horde_horn"));
        register(e, new ItemModFood("white_mushroom", FoodList.WHITE_MUSHROOM, DivineRPG.tabs.food));
        register(e, new ItemModFood("honeychunk", FoodList.HONEYCHUNK, DivineRPG.tabs.vethea));
        register(e, new ItemModFood("honeysuckle", FoodList.HONEYSUCKLE, DivineRPG.tabs.vethea));
        register(e, new ItemModFood("peppermints", FoodList.PEPPERMINTS, DivineRPG.tabs.food));
        register(e, new ItemModFood("cheese", FoodList.CHEESE, DivineRPG.tabs.food));
        register(e, new ItemModFood("pinfly", FoodList.PINFLY, DivineRPG.tabs.food));
        register(e, new ItemModFood("snow_cones", FoodList.SNOW_CONES, DivineRPG.tabs.food));
        register(e, new ItemModFood("bacon", FoodList.BACON, DivineRPG.tabs.food));
        register(e, new ItemModFood("hitchak", FoodList.HITCHAK, DivineRPG.tabs.food));
        register(e, new ItemModFood("dream_carrot", FoodList.DREAM_CARROT, DivineRPG.tabs.vethea));
        register(e, new ItemModFood("tomato", FoodList.TOMATO, DivineRPG.tabs.food));
        register(e, new ItemModFood("boiled_egg", FoodList.BOILED_EGG, DivineRPG.tabs.food));
        register(e, new ItemModFood("dream_pie", FoodList.DREAM_PIE, DivineRPG.tabs.vethea));
        register(e, new ItemModFood("chocolate_log", FoodList.CHOCOLATE_LOG, DivineRPG.tabs.food));
        register(e, new ItemModFood("winterberry", FoodList.WINTERBERRY, DivineRPG.tabs.food));
        register(e, new ItemModFood("raw_empowered_meat", FoodList.RAW_EMPOWERED_MEAT, DivineRPG.tabs.food));
        register(e, new ItemModFood("dream_melon", FoodList.DREAM_MELON, DivineRPG.tabs.vethea));
        register(e, new ItemModFood("dream_cake", FoodList.DREAM_CAKE, DivineRPG.tabs.vethea));
        register(e, new ItemModFood("hot_pumpkin_pie", FoodList.HOT_PUMPKIN_PIE, DivineRPG.tabs.food));
        register(e, new ItemModFood("advanced_mushroom_stew", FoodList.ADVANCED_MUSHROOM_STEW, DivineRPG.tabs.food));
        register(e, new ItemModFood("empowered_meat", FoodList.EMPOWERED_MEAT, DivineRPG.tabs.food));
        register(e, new ItemModFood("fruit_cake", FoodList.FRUIT_CAKE, DivineRPG.tabs.food));
        register(e, new ItemModFood("donut", FoodList.DONUT, DivineRPG.tabs.food));
        register(e, new ItemModFood("chicken_dinner", FoodList.CHICKEN_DINNER, DivineRPG.tabs.food));
        register(e, new ItemModSeeds("aquamarine_seeds", () -> BlockRegistry.aquamarinePlant));
        register(e, new ItemModSeeds("eucalyptus_root_seeds", () -> BlockRegistry.eucalyptusPlant));
        register(e, new ItemModSeeds("firestock_seeds", () -> BlockRegistry.firestockPlant));
        register(e, new ItemModSeeds("hitchak_seeds", () -> BlockRegistry.hitchakPlant));
        register(e, new ItemModSeeds("lamona_seeds", () -> BlockRegistry.lamonaPlant));
        register(e, new ItemModSeeds("marsine_seeds", () -> BlockRegistry.marsinePlant));
        register(e, new ItemModSeeds("moonbulb_seeds", () -> BlockRegistry.moonbulbPlant, () -> Blocks.GRASS));
        register(e, new ItemModSeeds("pinfly_seeds", () -> BlockRegistry.pinflyPlant));
        register(e, new ItemModSeeds("pink_glowbone_seeds", () -> BlockRegistry.pinkGlowbonePlant, () -> Blocks.GRASS));
        register(e, new ItemModSeeds("purple_glowbone_seeds", () -> BlockRegistry.purpleGlowbonePlant, () -> Blocks.GRASS));
        register(e, new ItemModSeeds("sky_plant_seeds", () -> BlockRegistry.skyPlant, () -> Blocks.GRASS));
        register(e, new ItemModSeeds("tomato_seeds", () -> BlockRegistry.tomatoPlant));
        register(e, new ItemModSeeds("veilo_seeds", () -> BlockRegistry.veiloPlant));
        register(e, new ItemModSeeds("white_mushroom_seeds", () -> BlockRegistry.whiteMushroomPlant));
        register(e, new ItemSpawnEgg("brown_grizzle_egg", EntityRegistry.BROWN_GRIZZLE));
        register(e, new ItemSpawnEgg("ehu_egg", EntityRegistry.EHU));
        register(e, new ItemSpawnEgg("fyracryx_egg", EntityRegistry.FYRACRYX));
        register(e, new ItemSpawnEgg("golem_of_rejuvenation_egg", EntityRegistry.GOLEM_OF_REJUVENATION));
        register(e, new ItemSpawnEgg("husk_egg", EntityRegistry.HUSK));
        register(e, new ItemSpawnEgg("paratiku_egg", EntityRegistry.PARATIKU));
        register(e, new ItemSpawnEgg("seimer_egg", EntityRegistry.SEIMER));
        register(e, new ItemSpawnEgg("smelter_egg", EntityRegistry.SMELTER));
        register(e, new ItemSpawnEgg("snapper_egg", EntityRegistry.SNAPPER));
        register(e, new ItemSpawnEgg("stone_golem_egg", EntityRegistry.STONE_GOLEM));
        register(e, new ItemSpawnEgg("white_grizzle_egg", EntityRegistry.WHITE_GRIZZLE));
        register(e, new ItemTwilightClock("twilight_clock"));
        register(e, new ItemVethean("acid"));
        register(e, new ItemVethean("amthirmis_lump"));
        register(e, new ItemVethean("arksiane_lump"));
        register(e, new ItemVethean("backsword_template"));
        register(e, new ItemVethean("band_of_heiva_hunting"));
        register(e, new ItemVethean("bow_template"));
        register(e, new ItemVethean("cannon_template"));
        register(e, new ItemVethean("cermile_lump"));
        register(e, new ItemVethean("claw_template"));
        register(e, new ItemVethean("clean_pearls"));
        register(e, new ItemVethean("darven_arrow"));
        register(e, new ItemVethean("darven_lump"));
        register(e, new ItemVethean("degraded_template"));
        register(e, new ItemVethean("demonized_template"));
        register(e, new ItemVethean("dirty_pearls"));
        register(e, new ItemVethean("disk_template"));
        register(e, new ItemVethean("dream_flint"));
        register(e, new ItemVethean("ever_arrow"));
        register(e, new ItemVethean("finished_template"));
        register(e, new ItemVethean("glistening_template"));
        register(e, new ItemVethean("hammer_template"));
        register(e, new ItemVethean("heliosis_lump"));
        register(e, new ItemVethean("karos_arrow"));
        register(e, new ItemVethean("karos_lump"));
        register(e, new ItemVethean("moon_clock"));
        register(e, new ItemVethean("pardimal_arrow"));
        register(e, new ItemVethean("pardimal_lump"));
        register(e, new ItemVethean("polished_pearls"));
        register(e, new ItemVethean("quadrotic_lump"));
        register(e, new ItemVethean("rock_chunks"));
        register(e, new ItemVethean("shiny_pearls"));
        register(e, new ItemVethean("staff_template"));
        register(e, new ItemVethean("teaker_arrow"));
        register(e, new ItemVethean("teaker_lump"));
        register(e, new ItemVethean("tormented_template"));
        register(e, new ItemNightmareBed());
        register(e, new ItemModAxe(DivineToolMaterials.APALACHIA_AXE, "apalachia_axe", DivineRPG.tabs.tools));
        register(e, new ItemModAxe(DivineToolMaterials.ARLEMITE_AXE, "arlemite_axe", DivineRPG.tabs.tools));
        register(e, new ItemModAxe(DivineToolMaterials.BEDROCK_AXE, "bedrock_axe", DivineRPG.tabs.tools));
        register(e, new ItemModAxe(DivineToolMaterials.CORRUPTED_AXE, "corrupted_axe", DivineRPG.tabs.tools));
        register(e, new ItemModAxe(DivineToolMaterials.DIVINE_AXE, "divine_axe", DivineRPG.tabs.tools));
        register(e, new ItemModAxe(DivineToolMaterials.DREAM_AXE, "dream_axe", DivineRPG.tabs.vethea));
        register(e, new ItemModAxe(DivineToolMaterials.EDEN_AXE, "eden_axe", DivineRPG.tabs.tools));
        register(e, new ItemModAxe(DivineToolMaterials.MORTUM_AXE, "mortum_axe", DivineRPG.tabs.tools));
        register(e, new ItemModAxe(DivineToolMaterials.REALMITE_AXE, "realmite_axe", DivineRPG.tabs.tools));
        register(e, new ItemModAxe(DivineToolMaterials.RUPEE_AXE, "rupee_axe", DivineRPG.tabs.tools));
        register(e, new ItemModAxe(DivineToolMaterials.SKYTHERN_AXE, "skythern_axe", DivineRPG.tabs.tools));
        register(e, new ItemModAxe(DivineToolMaterials.WILDWOOD_AXE, "wildwood_axe", DivineRPG.tabs.tools));
        register(e, new ItemModBow("apalachia_bow", ArrowType.GREATER_WILDWOOD_ARROW, -1, () -> ItemRegistry.wildwoodArrow));
        register(e, new ItemModBow("bluefire_bow", ArrowType.BLUEFIRE_ARROW, -1));
        register(e, new ItemModBow("eden_bow", ArrowType.EDEN_ARROW, -1, () -> ItemRegistry.edenArrow));
        register(e, new ItemModBow("ender_bow", ArrowType.ENDER_ARROW, -1));
        register(e, new ItemModBow("halite_bow", ArrowType.FURY_ARROW, -1, 36000, () -> ItemRegistry.furyArrow));
        register(e, new ItemModBow("hunter_bow", ArrowType.HUNTER_ARROW, 2500, () -> Items.ARROW));
        register(e, new ItemModBow("icicle_bow", ArrowType.ICICLE_ARROW, 10000, 24000, () -> Items.ARROW));
        register(e, new ItemModBow("inferno_bow", ArrowType.INFERNO_ARROW, 10000));
        register(e, new ItemModBow("mortum_bow", ArrowType.FURY_ARROW, -1, () -> ItemRegistry.furyArrow));
        register(e, new ItemModBow("shadow_bow", ArrowType.SHADOW_ARROW, 10000, 36000, () -> Items.ARROW));
        register(e, new ItemModBow("skythern_bow", ArrowType.GREATER_WILDWOOD_ARROW, -1, 36000, () -> ItemRegistry.wildwoodArrow));
        register(e, new ItemModBow("snowstorm_bow", ArrowType.SNOWSTORM_ARROW, -1));
        register(e, new ItemModBow("twilight_bow", ArrowType.FURY_ARROW, -1, 14400, () -> ItemRegistry.furyArrow));
        register(e, new ItemModBow("wildwood_bow", ArrowType.LESSER_WILDWOOD_ARROW, -1, 36000, () -> ItemRegistry.wildwoodArrow));
        register(e, new ItemModHoe(DivineToolMaterials.ARLEMITE_PICKAXE, "arlemite_hoe"));
        register(e, new ItemModHoe(DivineToolMaterials.REALMITE_PICKAXE, "realmite_hoe"));
        register(e, new ItemModHoe(DivineToolMaterials.RUPEE_PICKAXE, "rupee_hoe"));
        register(e, new ItemModPickaxe(DivineToolMaterials.APALACHIA_PICKAXE, "apalachia_pickaxe", DivineRPG.tabs.tools));
        register(e, new ItemModPickaxe(DivineToolMaterials.ARLEMITE_PICKAXE, "arlemite_pickaxe", DivineRPG.tabs.tools));
        register(e, new ItemModPickaxe(DivineToolMaterials.BEDROCK_PICKAXE, "bedrock_pickaxe", DivineRPG.tabs.tools));
        register(e, new ItemModPickaxe(DivineToolMaterials.CORRUPTED_PICKAXE, "corrupted_pickaxe", DivineRPG.tabs.tools));
        register(e, new ItemModPickaxe(DivineToolMaterials.DIVINE_PICKAXE, "divine_pickaxe", DivineRPG.tabs.tools));
        register(e, new ItemModPickaxe(DivineToolMaterials.DREAM_PICKAXE, "dream_pickaxe", DivineRPG.tabs.vethea));
        register(e, new ItemModPickaxe(DivineToolMaterials.EDEN_PICKAXE, "eden_pickaxe", DivineRPG.tabs.tools));
        register(e, new ItemModPickaxe(DivineToolMaterials.MORTUM_PICKAXE, "mortum_pickaxe", DivineRPG.tabs.tools));
        register(e, new ItemModPickaxe(DivineToolMaterials.REALMITE_PICKAXE, "realmite_pickaxe", DivineRPG.tabs.tools));
        register(e, new ItemModPickaxe(DivineToolMaterials.RUPEE_PICKAXE, "rupee_pickaxe", DivineRPG.tabs.tools));
        register(e, new ItemModPickaxe(DivineToolMaterials.SKYTHERN_PICKAXE, "skythern_pickaxe", DivineRPG.tabs.tools));
        register(e, new ItemModPickaxe(DivineToolMaterials.WILDWOOD_PICKAXE, "wildwood_pickaxe", DivineRPG.tabs.tools));
        register(e, new ItemModShovel(DivineToolMaterials.APALACHIA_SHOVEL, "apalachia_shovel", DivineRPG.tabs.tools));
        register(e, new ItemModShovel(DivineToolMaterials.ARLEMITE_SHOVEL, "arlemite_shovel", DivineRPG.tabs.tools));
        register(e, new ItemModShovel(DivineToolMaterials.BEDROCK_SHOVEL, "bedrock_shovel", DivineRPG.tabs.tools));
        register(e, new ItemModShovel(DivineToolMaterials.CORRUPTED_SHOVEL, "corrupted_shovel", DivineRPG.tabs.tools));
        register(e, new ItemModShovel(DivineToolMaterials.DIVINE_SHOVEL, "divine_shovel", DivineRPG.tabs.tools));
        register(e, new ItemModShovel(DivineToolMaterials.DREAM_SHOVEL, "dream_shovel", DivineRPG.tabs.vethea));
        register(e, new ItemModShovel(DivineToolMaterials.EDEN_SHOVEL, "eden_shovel", DivineRPG.tabs.tools));
        register(e, new ItemModShovel(DivineToolMaterials.MORTUM_SHOVEL, "mortum_shovel", DivineRPG.tabs.tools));
        register(e, new ItemModShovel(DivineToolMaterials.REALMITE_SHOVEL, "realmite_shovel", DivineRPG.tabs.tools));
        register(e, new ItemModShovel(DivineToolMaterials.RUPEE_SHOVEL, "rupee_shovel", DivineRPG.tabs.tools));
        register(e, new ItemModShovel(DivineToolMaterials.SKYTHERN_SHOVEL, "skythern_shovel", DivineRPG.tabs.tools));
        register(e, new ItemModShovel(DivineToolMaterials.WILDWOOD_SHOVEL, "wildwood_shovel", DivineRPG.tabs.tools));
        register(e, new ItemModSword("apalachia_blade", DivineToolMaterials.APALACHIA_BLADE, DivineRPG.tabs.melee));
        register(e, new ItemModSword("aquatic_dagger", DivineToolMaterials.AQUA_DAGGER, DivineRPG.tabs.melee));
        register(e, new ItemModSword("aquatic_maul", DivineToolMaterials.AQUA_MAUL, DivineRPG.tabs.melee));
        register(e, new ItemModSword("aquatic_trident", DivineToolMaterials.AQUA_TRIDENT, DivineRPG.tabs.melee));
        register(e, new ItemModSword("aquaton", DivineToolMaterials.AQUATON, DivineRPG.tabs.melee));
        register(e, new ItemModSword("aquatooth_maul", DivineToolMaterials.AQUATOOTH_MAUL, DivineRPG.tabs.melee));
        register(e, new ItemModSword("aquatooth_sword", DivineToolMaterials.AQUATOOTH_SWORD, DivineRPG.tabs.melee));
        register(e, new ItemModSword("arlemite_stabber", DivineToolMaterials.ARLEMITE_STABBER, DivineRPG.tabs.melee));
        register(e, new ItemModSword("bedrock_maul", DivineToolMaterials.BEDROCK_MAUL, DivineRPG.tabs.melee));
        register(e, new ItemModSword("bedrock_sword", DivineToolMaterials.BEDROCK_SWORD, DivineRPG.tabs.melee));
        register(e, new ItemModSword("bloodgem_sword", DivineToolMaterials.BLOODGEM_SWORD, DivineRPG.tabs.melee));
        register(e, new ItemModSword("bluefire_sword", DivineToolMaterials.BLUEFIRE_SWORD, DivineRPG.tabs.melee));
        register(e, new ItemModSword("corrupted_maul", DivineToolMaterials.CORRUPTED_MAUL, DivineRPG.tabs.melee));
        register(e, new ItemModSword("crabclaw_maul", DivineToolMaterials.CRABCLAW_MAUL, DivineRPG.tabs.melee));
        register(e, new ItemModSword("cyclopsian_sword", DivineToolMaterials.CYCLOPSIAN_SWORD, DivineRPG.tabs.melee));
        register(e, new ItemModSword("death_bringer", DivineToolMaterials.DEATH_BRINGER, DivineRPG.tabs.melee));
        register(e, new ItemModSword("blue_divine_sword", DivineToolMaterials.DIVINE_SWORD, DivineRPG.tabs.melee));
        register(e, new ItemModSword("divine_sword", DivineToolMaterials.DIVINE_SWORD, DivineRPG.tabs.melee));
        register(e, new ItemModSword("gray_divine_sword", DivineToolMaterials.DIVINE_SWORD, DivineRPG.tabs.melee));
        register(e, new ItemModSword("green_divine_sword", DivineToolMaterials.DIVINE_SWORD, DivineRPG.tabs.melee));
        register(e, new ItemModSword("red_divine_sword", DivineToolMaterials.DIVINE_SWORD, DivineRPG.tabs.melee));
        register(e, new ItemModSword("yellow_divine_sword", DivineToolMaterials.DIVINE_SWORD, DivineRPG.tabs.melee));
        register(e, new ItemModSword("dual_claw", DivineToolMaterials.DUAL_CLAW, DivineRPG.tabs.melee));
        register(e, new ItemModSword("eden_blade", DivineToolMaterials.EDEN_BLADE, DivineRPG.tabs.melee));
        register(e, new ItemModSword("black_ender_sword", DivineToolMaterials.ENDER_SWORD, DivineRPG.tabs.melee));
        register(e, new ItemModSword("blue_ender_sword", DivineToolMaterials.ENDER_SWORD, DivineRPG.tabs.melee));
        register(e, new ItemModSword("ender_sword", DivineToolMaterials.ENDER_SWORD, DivineRPG.tabs.melee));
        register(e, new ItemModSword("green_ender_sword", DivineToolMaterials.ENDER_SWORD, DivineRPG.tabs.melee));
        register(e, new ItemModSword("red_ender_sword", DivineToolMaterials.ENDER_SWORD, DivineRPG.tabs.melee));
        register(e, new ItemModSword("yellow_ender_sword", DivineToolMaterials.ENDER_SWORD, DivineRPG.tabs.melee));
        register(e, new ItemModSword("fury_maul", DivineToolMaterials.FURY_MAUL, DivineRPG.tabs.melee));
        register(e, new ItemModSword("halite_blade", DivineToolMaterials.HALITE_BLADE, DivineRPG.tabs.melee));
        register(e, new ItemModSword("livicia_sword", DivineToolMaterials.LIVICIA_SWORD, DivineRPG.tabs.melee));
        register(e, new ItemModSword("mortum_blade", DivineToolMaterials.MORTUM_BLADE, DivineRPG.tabs.melee));
        register(e, new ItemModSword("ocean_knife", DivineToolMaterials.OCEAN_KNIFE, DivineRPG.tabs.melee));
        register(e, new ItemModSword("realmite_sword", DivineToolMaterials.REALMITE_SWORD, DivineRPG.tabs.melee));
        register(e, new ItemModSword("rupee_rapier", DivineToolMaterials.RUPEE_RAPIER, DivineRPG.tabs.melee));
        register(e, new ItemModSword("sandslash", DivineToolMaterials.SANDSLASH, DivineRPG.tabs.melee));
        register(e, new ItemModSword("scorching_sword", DivineToolMaterials.SCORCHING_SWORD, DivineRPG.tabs.melee));
        register(e, new ItemModSword("shark_sword", DivineToolMaterials.SHARK_SWORD, DivineRPG.tabs.melee));
        register(e, new ItemModSword("skythern_blade", DivineToolMaterials.SKYTHERN_BLADE, DivineRPG.tabs.melee));
        register(e, new ItemModSword("slime_sword", DivineToolMaterials.SLIME_SWORD, DivineRPG.tabs.melee));
        register(e, new ItemModSword("terran_dagger", DivineToolMaterials.TERRAN_DAGGER, DivineRPG.tabs.melee));
        register(e, new ItemModSword("terran_knife", DivineToolMaterials.TERRAN_KNIFE, DivineRPG.tabs.melee));
        register(e, new ItemModSword("terran_maul", DivineToolMaterials.TERRAN_MAUL, DivineRPG.tabs.melee));
        register(e, new ItemModSword("wildwood_blade", DivineToolMaterials.WILDWOOD_BLADE, DivineRPG.tabs.melee));
        register(e, new ItemShickaxe("apalachia_shickaxe", DivineToolMaterials.APALACHIA_SHICKAXE));
        register(e, new ItemShickaxe("arlemite_shickaxe", DivineToolMaterials.ARLEMITE_SHICKAXE));
        register(e, new ItemShickaxe("divine_shickaxe", DivineToolMaterials.DIVINE_SHICKAXE));
        register(e, new ItemShickaxe("eden_shickaxe", DivineToolMaterials.EDEN_SHICKAXE));
        register(e, new ItemShickaxe("halite_shickaxe", DivineToolMaterials.HALITE_SHICKAXE));
        register(e, new ItemShickaxe("mortum_shickaxe", DivineToolMaterials.MORTUM_SHICKAXE));
        register(e, new ItemShickaxe("rupee_shickaxe", DivineToolMaterials.RUPEE_SHICKAXE));
        register(e, new ItemShickaxe("skythern_shickaxe", DivineToolMaterials.SKYTHERN_SHICKAXE));
        register(e, new ItemShickaxe("wildwood_shickaxe", DivineToolMaterials.WILDWOOD_SHICKAXE));
        register(e, new ItemModRanged("apalachia_phaser", BulletType.APALACHIA_PHASER_SHOT, SoundRegistry.PHASER, 3000, 12));
        register(e, new ItemModRanged("bowhead_cannon", BulletType.BOWHEAD_CANNON_SHOT, SoundRegistry.GHAST_CANNON, () -> Item.byBlock(Blocks.CACTUS), 1000, 12));
        register(e, new ItemModRanged("crabclaw_cannon", BulletType.CRABCLAW_CANNON_SHOT, SoundRegistry.GHAST_CANNON, () -> Item.byBlock(Blocks.CACTUS), 1000, 12));
        register(e, new ItemModRanged("cyclopsian_staff", BulletType.CYCLOPSIAN_STAFF_SHOT, SoundRegistry.STAFF, 600, 0));
        register(e, new ItemModRanged("eden_phaser", BulletType.EDEN_PHASER_SHOT, SoundRegistry.PHASER, 3000, 12));
        register(e, new ItemModRanged("fractite_cannon", BulletType.FRACTITE_CANNON_SHOT, SoundRegistry.FRACTITE_CANNON, () -> ItemRegistry.iceShards, 10000, 0));
        register(e, new ItemModRanged("frost_cannon", BulletType.FROST_CANNON_SHOT, SoundRegistry.FROST_CANNON, () -> Items.SNOWBALL, 15000, 0));
        register(e, new ItemModRanged("frostclaw_cannon", BulletType.FROSTCLAW_CANNON_SHOT, SoundRegistry.FROSTCLAW_CANNON, () -> Item.byBlock(Blocks.CACTUS), 10000, 0));
        register(e, new ItemModRanged("ghast_cannon", BulletType.GHAST_CANNON_SHOT, SoundRegistry.GHAST_CANNON, 100, 20));
        register(e, new ItemModRanged("golden_fury", BulletType.GOLDEN_FURY_SHOT, SoundRegistry.BLITZ, () -> Items.GOLD_NUGGET, -1, 0));
        register(e, new ItemModRanged("halite_phaser", BulletType.HALITE_PHASER_SHOT, SoundRegistry.PHASER, 3000, 12));
        register(e, new ItemModRanged("maelstrom", BulletType.MAELSTROM_SHOT, SoundRegistry.GHAST_CANNON, 100, 0));
        register(e, new ItemModRanged("mortum_phaser", BulletType.MORTUM_PHASER_SHOT, SoundRegistry.PHASER, 3000, 12));
        register(e, new ItemModRanged("skythern_phaser", BulletType.SKYTHERN_PHASER_SHOT, SoundRegistry.PHASER, 3000, 12));
        register(e, new ItemModRanged("wildwood_phaser", BulletType.WILDWOOD_PHASER_SHOT, SoundRegistry.PHASER, 3000, 12));
        register(e, new WallOrFloorItem(BlockRegistry.aquaTorch, BlockRegistry.aquaWallTorch, (new Item.Properties()).tab(DivineRPG.tabs.blocks)).setRegistryName("aqua_torch"));
        register(e, new WallOrFloorItem(BlockRegistry.arcaniumTorch, BlockRegistry.arcaniumWallTorch, (new Item.Properties()).tab(DivineRPG.tabs.blocks)).setRegistryName("arcanium_torch"));
        register(e, new WallOrFloorItem(BlockRegistry.edenTorch, BlockRegistry.edenWallTorch, (new Item.Properties()).tab(DivineRPG.tabs.blocks)).setRegistryName("eden_torch"));
        register(e, new WallOrFloorItem(BlockRegistry.skeletonTorch, BlockRegistry.skeletonWallTorch, (new Item.Properties()).tab(DivineRPG.tabs.blocks)).setRegistryName("skeleton_torch"));
        register(e, new ItemModBucket("smoldering_tar_bucket", () -> FluidRegistry.TAR.get()));
    }

    private static void register(RegistryEvent.Register<Item> event, Item item) {
        event.getRegistry().register(item);
    }

    private static void registerArmorSet(RegistryEvent.Register<Item> registry, String prefix, IArmorMaterial material, ArmorInfo info) {
        register(registry, new ItemDivineArmor(prefix + "_helmet", material, EquipmentSlotType.HEAD, info));
        register(registry, new ItemDivineArmor(prefix + "_chestplate", material, EquipmentSlotType.CHEST, info));
        register(registry, new ItemDivineArmor(prefix + "_leggings", material, EquipmentSlotType.LEGS, info));
        register(registry, new ItemDivineArmor(prefix + "_boots", material, EquipmentSlotType.FEET, info));
    }

    private static void registerArmorSet(RegistryEvent.Register<Item> registry, String prefix, IArmorMaterial material) {
        register(registry, new ItemDivineArmor(prefix + "_helmet", material, EquipmentSlotType.HEAD));
        register(registry, new ItemDivineArmor(prefix + "_chestplate", material, EquipmentSlotType.CHEST));
        register(registry, new ItemDivineArmor(prefix + "_leggings", material, EquipmentSlotType.LEGS));
        register(registry, new ItemDivineArmor(prefix + "_boots", material, EquipmentSlotType.FEET));
    }

    private static void registerVetheanArmorSet(RegistryEvent.Register<Item> registry, String prefix, IArmorMaterial material, IArmorMaterial hoodMaterial, IArmorMaterial maskMaterial) {
        register(registry, new ItemDivineArmor(prefix + "_helmet", material, EquipmentSlotType.HEAD));
        register(registry, new ItemDivineArmor(prefix + "_hood", hoodMaterial, EquipmentSlotType.HEAD));
        register(registry, new ItemDivineArmor(prefix + "_mask", maskMaterial, EquipmentSlotType.HEAD));
        register(registry, new ItemDivineArmor(prefix + "_chestplate", material, EquipmentSlotType.CHEST));
        register(registry, new ItemDivineArmor(prefix + "_leggings", material, EquipmentSlotType.LEGS));
        register(registry, new ItemDivineArmor(prefix + "_boots", material, EquipmentSlotType.FEET));
    }

    private static void registerVetheanArmorSet(RegistryEvent.Register<Item> registry, String prefix, IArmorMaterial material, IArmorMaterial hoodMaterial, IArmorMaterial maskMaterial, ArmorInfo helmetInfo, ArmorInfo hoodInfo, ArmorInfo maskInfo, ArmorInfo info) {
        register(registry, new ItemDivineArmor(prefix + "_helmet", material, EquipmentSlotType.HEAD, helmetInfo));
        register(registry, new ItemDivineArmor(prefix + "_hood", hoodMaterial, EquipmentSlotType.HEAD, hoodInfo));
        register(registry, new ItemDivineArmor(prefix + "_mask", maskMaterial, EquipmentSlotType.HEAD, maskInfo));
        register(registry, new ItemDivineArmor(prefix + "_chestplate", material, EquipmentSlotType.CHEST, info));
        register(registry, new ItemDivineArmor(prefix + "_leggings", material, EquipmentSlotType.LEGS, info));
        register(registry, new ItemDivineArmor(prefix + "_boots", material, EquipmentSlotType.FEET, info));
    }

    public static TextComponent getArmorAbility(String keyPart, Object... params) {
        String id = String.format("tooltip.armor_info.%s", keyPart);

        return params == null || params.length < 1
                ? new TranslationTextComponent(id)
                : new TranslationTextComponent(id, params);
    }
}
