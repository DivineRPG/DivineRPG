package divinerpg.registry;

import divinerpg.DivineRPG;
import divinerpg.enums.ArmorInfo;
import divinerpg.enums.EnumArmor;
import divinerpg.objects.entities.entity.arcana.EntityFyracryx;
import divinerpg.objects.entities.entity.arcana.EntityGolemOfRejuvenation;
import divinerpg.objects.entities.entity.arcana.EntityParatiku;
import divinerpg.objects.entities.entity.arcana.EntitySeimer;
import divinerpg.objects.entities.entity.twilight.*;
import divinerpg.objects.entities.entity.vanilla.*;
import divinerpg.objects.items.arcana.*;
import divinerpg.objects.items.base.*;
import divinerpg.objects.items.iceika.ItemEggNog;
import divinerpg.objects.items.iceika.ItemSnowGlobe;
import divinerpg.objects.items.twilight.ItemBossSpawner;
import divinerpg.objects.items.twilight.ItemForbiddenFruit;
import divinerpg.objects.items.twilight.ItemSkyFlower;
import divinerpg.objects.items.twilight.ItemTwilightClock;
import divinerpg.objects.items.vanilla.ItemHealingStone;
import divinerpg.objects.items.vanilla.ItemHordeHorn;
import divinerpg.objects.items.vanilla.ItemTeleportationCrystal;
import divinerpg.objects.items.vanilla.ItemTeleportationStar;
import divinerpg.objects.items.vethea.ItemNightmareBed;
import divinerpg.objects.items.vethea.ItemVethean;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.DimensionType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.HashMap;
import java.util.Objects;
import java.util.function.Supplier;

import static divinerpg.utils.LocalizeUtils.getArmorAbility;

/**
 * Registers most items for the mod, except for tools and weapons which go in ModTools and ModWeapons respectively.
 * This class registers its items prior to those due to its event priority being higher.
 */
@Mod.EventBusSubscriber
@ObjectHolder("divinerpg")
public class ModItems {
    public static HashMap<String, Item> itemMap = new HashMap<String, Item>();

    // Teleportation crystal
    @ObjectHolder("teleportation_crystal")
    public static final Item teleportationCrystal = null;
    @ObjectHolder("teleportation_star")
    public static final Item teleportationStar = null;

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
    @ObjectHolder("netherite_ingot")
    public static final Item netheriteIngot = null;
    @ObjectHolder("realmite_ingot")
    public static final Item realmiteIngot = null;
    @ObjectHolder("rupee_ingot")
    public static final Item rupeeIngot = null;
    @ObjectHolder("shadow_bar")
    public static final Item shadowBar = null;

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
    @ObjectHolder("netherite_chunk")
    public static final Item netheriteChunk = null;
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
    @ObjectHolder("eternal_archer_crystal")
    public static final Item eternalArcherCrystal = null;
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
    @ObjectHolder("frozen_charge")
    public static final Item frozenCharge = null;

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

    //Doors
    @ObjectHolder("steel_door")
    public static final Item steelDoor = null;
    @ObjectHolder("ancient_brick_door")
    public static final Item ancientBrickDoor = null;
    @ObjectHolder("degraded_brick_door")
    public static final Item degradedBrickDoor = null;
    @ObjectHolder("soul_sludge_door")
    public static final Item soulSludgeDoor = null;
    @ObjectHolder("soul_stone_door")
    public static final Item soulStoneDoor = null;

    // Arcana miscellaneous
    @ObjectHolder("arcanium")
    public static final Item arcanium = null;
    @ObjectHolder("charged_collector")
    public static final Item chargedCollector = null;
    @ObjectHolder("collector")
    public static final Item collector = null;
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

    // Vethea door
    @ObjectHolder("barred_door")
    public static final Item barredDoor = null;

    // Vethea miscellaneous
    @ObjectHolder("acid")
    public static final Item acid = null;
    @ObjectHolder("band_of_heiva_hunting")
    public static final Item bandOfHeivaHunting = null;
    @ObjectHolder("miners_amulet")
    public static final Item minersAmulet = null;
    @ObjectHolder("rock_chunks")
    public static final Item rockChunks = null;

    //Slabs
    @ObjectHolder("eden_slab")
    public static final Item edenSlab = null;
    @ObjectHolder("wildwood_slab")
    public static final Item wildwoodSlab = null;
    @ObjectHolder("apalachia_slab")
    public static final Item apalachiaSlab = null;
    @ObjectHolder("skythern_slab")
    public static final Item skythernSlab = null;
    @ObjectHolder("mortum_slab")
    public static final Item mortumSlab = null;
    @ObjectHolder("divine_slab")
    public static final Item divineSlab = null;
    @ObjectHolder("frozen_slab")
    public static final Item frozenSlab = null;
    @ObjectHolder("eucalyptus_slab")
    public static final Item eucalyptusSlab = null;

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
    
    @SubscribeEvent(priority=EventPriority.HIGH)
    public static void registerItems(RegistryEvent.Register<Item> event) {
        DivineRPG.logger.info("Registering DivineRPG items");

        IForgeRegistry<Item> registry = event.getRegistry();

        // Teleportation crystal
        register(registry, new ItemTeleportationCrystal("teleportation_crystal"));
        register(registry, new ItemTeleportationStar("teleportation_star"));

        // Vanilla misc items

        // Shards
        register(registry, new ItemMod("corrupted_shards"));
        register(registry, new ItemMod("divine_shards"));
        register(registry, new ItemMod("ender_shards"));
        register(registry, new ItemMod("ice_shards"));
        register(registry, new ItemMod("jungle_shards"));
        register(registry, new ItemMod("molten_shards"));
        register(registry, new ItemMod("terran_shards"));

        // Stones
        register(registry, new ItemMod("corrupted_stone"));
        register(registry, new ItemMod("divine_stone"));
        register(registry, new ItemMod("ender_stone"));
        register(registry, new ItemMod("ice_stone"));
        register(registry, new ItemMod("jungle_stone"));
        register(registry, new ItemMod("molten_stone"));
        register(registry, new ItemMod("shadow_stone"));
        register(registry, new ItemMod("terran_stone"));

        // Ingots
        register(registry, new ItemMod("arlemite_ingot"));
        register(registry, new ItemMod("hellstone_ingot"));
        register(registry, new ItemMod("netherite_ingot"));
        register(registry, new ItemMod("realmite_ingot"));
        register(registry, new ItemMod("rupee_ingot"));
        register(registry, new ItemMod("shadow_bar"));

        // Boss spawners
        register(registry, new ItemBossSpawner("call_of_the_watcher", "message.watcher", x -> Objects.equals(x, DimensionType.NETHER), EntityTheWatcher::new));
        register(registry, new ItemHordeHorn("horde_horn"));
        register(registry, new ItemBossSpawner("infernal_flame", "message.king_of_scorchers", x -> Objects.equals(x, DimensionType.NETHER), EntityKingOfScorchers::new));
        register(registry, new ItemBossSpawner("mysterious_clock", "message.ancient_entity", x -> Objects.equals(x, DimensionType.OVERWORLD), EntityAncientEntity::new));
        register(registry, new ItemMod("watching_eye"));

        // Ayeraco fragments
//        register(registry, new ItemMod("ayeraco_fragment_blue"));
//        register(registry, new ItemMod("ayeraco_fragment_green"));
//        register(registry, new ItemMod("ayeraco_fragment_purple"));
//        register(registry, new ItemMod("ayeraco_fragment_red"));
//        register(registry, new ItemMod("ayeraco_fragment_yellow"));

        // Diamond chunks
        register(registry, new ItemMod("blue_diamond_chunk"));
        register(registry, new ItemMod("gray_diamond_chunk"));
        register(registry, new ItemMod("red_diamond_chunk"));
        register(registry, new ItemMod("yellow_diamond_chunk"));
        register(registry, new ItemMod("green_diamond_chunk"));

        // Pet spawn eggs
        register(registry, new ItemSpawnEgg("brown_grizzle_egg", EntityBrownGrizzle::new));
        register(registry, new ItemSpawnEgg("ehu_egg", EntityEhu::new));
        register(registry, new ItemSpawnEgg("husk_egg", EntityHusk::new));
        register(registry, new ItemSpawnEgg("smelter_egg", EntitySmelter::new));
        register(registry, new ItemSpawnEgg("snapper_egg", EntitySnapper::new));
        register(registry, new ItemSpawnEgg("stone_golem_egg", EntityStoneGolem::new));
        register(registry, new ItemSpawnEgg("white_grizzle_egg", EntityWhiteGrizzle::new));

        // Miscellaneous resources
        register(registry, new ItemMod("aqua_ball"));
        register(registry, new ItemMod("aquatic_blaze_rod"));
        register(registry, new ItemMod("aquatic_ingot"));
        register(registry, new ItemMod("aquatic_pellets"));
        register(registry, new ItemMod("bedrock_chunk"));
        register(registry, new ItemMod("bloodgem"));
        register(registry, new ItemMod("bluefire_stone"));
        register(registry, new ItemMod("corrupted_bullet"));
        register(registry, new ItemMod("crab_claw"));
        register(registry, new ItemMod("cyclops_eye"));
        register(registry, new ItemMod("cyclops_eye_shards"));
        register(registry, new ItemMod("fury_fire"));
        register(registry, new ItemHealingStone("healing_stone", 20));
        register(registry, new ItemMod("kraken_scale"));
        register(registry, new ItemMod("kraken_skin"));
        register(registry, new ItemMod("legendary_ender_eye"));
        register(registry, new ItemMod("liopleurodon_skull"));
        register(registry, new ItemMod("liopleurodon_teeth"));
        register(registry, new ItemMod("netherite_chunk"));
        register(registry, new ItemMod("pure_aquatic_pellets"));
        register(registry, new ItemMod("purple_blaze"));
        register(registry, new ItemMod("shadow_coins"));
        register(registry, new ItemMod("shark_fin"));
        register(registry, new ItemMod("whale_fin"));

        // Iceika

        // Iceika misc
        register(registry, new ItemMod("snowflake"));

        // Iceika portal item
        register(registry, new ItemSnowGlobe("snow_globe"));

        /*************************/

        // Foods
        register(registry, new ItemModFood(10, 0.5F, "advanced_mushroom_stew"));
        register(registry, new ItemModFood(2, 2.0F, true, "bacon"));
        register(registry, new ItemModFood(4, 0.5F, "boiled_egg"));
        register(registry, new ItemModFood(2, 0.2F, "cheese"));
        register(registry, new ItemModFood(20, 0.5F, "chicken_dinner"));
        register(registry, new ItemModFood(4, 1.0F, "chocolate_log"));
        register(registry, new ItemModFood(16, 0.3F, "donut"));
        register(registry, new ItemEggNog("egg_nog"));
        register(registry, new ItemModFood(5, 1.0F, true, "raw_empowered_meat"));
        register(registry, new ItemModFood(10, 1.0F, true, "empowered_meat"));
        register(registry, new ItemFastFood(7, 1.0F, true, "enriched_magic_meat"));
        register(registry, new ItemForbiddenFruit());
        register(registry, new ItemModFood(16, 0.2F, "fruit_cake"));
        register(registry, new ItemModFood(10, 0.4F, false, "hot_pumpkin_pie"));
        register(registry, new ItemFastFood(5, 1.0F, true, "magic_meat"));
        register(registry, new ItemFastFood(1, 2.0F, false, "moonbulb"));
        register(registry, new ItemModFood(1, 0.3F, "peppermints"));
        register(registry, new ItemFastFood(3, 2.0F, false, "pink_glowbone"));
        register(registry, new ItemFastFood(3, 2.0F, false, "purple_glowbone"));
        register(registry, new ItemSkyFlower("sky_flower"));
        register(registry, new ItemModFood(2, 0.3F, "snow_cones"));
        register(registry, new ItemModFood(4, 0.3F, "tomato"));
        register(registry, new ItemModFood(1, 0.1F, "white_mushroom"));
        register(registry, new ItemModFood(4, 1.0F, "winterberry"));

        // Twilight Dimensions

        // Twilight souls
        register(registry, new ItemMod("eden_soul"));
        register(registry, new ItemMod("wildwood_soul"));
        register(registry, new ItemMod("apalachia_soul"));
        register(registry, new ItemMod("skythern_soul"));
        register(registry, new ItemMod("mortum_soul"));

        // Twilight boss souls
        register(registry, new ItemMod("eden_heart", true));
        register(registry, new ItemMod("wildwood_heart", true));
        register(registry, new ItemMod("apalachia_heart", true));
        register(registry, new ItemMod("skythern_heart", true));
        register(registry, new ItemMod("mortum_heart", true));

        // Twilight fragments
        register(registry, new ItemMod("eden_fragments"));
        register(registry, new ItemMod("wildwood_fragments"));
        register(registry, new ItemMod("apalachia_fragments"));
        register(registry, new ItemMod("skythern_fragments"));
        register(registry, new ItemMod("mortum_fragments"));

        // Twilight gems
        register(registry, new ItemMod("eden_gem"));
        register(registry, new ItemMod("wildwood_gem"));
        register(registry, new ItemMod("apalachia_gem"));
        register(registry, new ItemMod("skythern_gem"));
        register(registry, new ItemMod("mortum_gem"));

        // Twilight chunks
        register(registry, new ItemMod("eden_chunk"));
        register(registry, new ItemMod("wildwood_chunk"));
        register(registry, new ItemMod("apalachia_chunk"));
        register(registry, new ItemMod("skythern_chunk"));
        register(registry, new ItemMod("mortum_chunk"));

        // Twilight dust
        register(registry, new ItemMod("eden_dust"));
        register(registry, new ItemMod("wildwood_dust"));
        register(registry, new ItemMod("apalachia_dust"));
        register(registry, new ItemMod("skythern_dust"));
        register(registry, new ItemMod("mortum_dust"));

        // Twilight boss spawners
        register(registry, new ItemBossSpawner("eternal_archer_crystal", "tooltip.mortum_only", x -> Objects.equals(x, ModDimensions.mortumDimension), EntityEternalArcher::new));
        register(registry, new ItemBossSpawner("karot_crystal", "tooltip.mortum_only", x -> Objects.equals(x, ModDimensions.mortumDimension), EntityKarot::new));
        register(registry, new ItemBossSpawner("reyvor_crystal", "tooltip.mortum_only", x -> Objects.equals(x, ModDimensions.mortumDimension), EntityReyvor::new, EntityDensos::new));
        register(registry, new ItemBossSpawner("densos_crystal", "tooltip.mortum_only", x -> Objects.equals(x, ModDimensions.mortumDimension), EntityReyvor::new, EntityDensos::new));
        register(registry, new ItemBossSpawner("soul_fiend_crystal", "tooltip.mortum_only", x -> Objects.equals(x, ModDimensions.mortumDimension), EntitySoulFiend::new));
        register(registry, new ItemBossSpawner("twilight_demon_crystal", "tooltip.mortum_only", x -> Objects.equals(x, ModDimensions.mortumDimension), EntityTwilightDemon::new));
        register(registry, new ItemBossSpawner("vamacheron_crystal", "tooltip.mortum_only", x -> Objects.equals(x, ModDimensions.mortumDimension), EntityVamacheron::new));

        // Twilight portal item
        register(registry, new ItemTwilightClock("twilight_clock"));

        // Twilight arrows
        register(registry, new ItemMod("eden_arrow").setCreativeTab(DivineRPGTabs.ranged));
        register(registry, new ItemMod("fury_arrow").setCreativeTab(DivineRPGTabs.ranged));
        register(registry, new ItemMod("wildwood_arrow").setCreativeTab(DivineRPGTabs.ranged));

        // Twilight miscellaneous
        register(registry, new ItemMod("base_spawn_crystal"));
        register(registry, new ItemMod("eden_sparkles"));

        // Arcana
        // Arcana utility
        register(registry, new ItemAttractor());
        register(registry, new ItemReflector());
        register(registry, new ItemDivineAccumulator());
        register(registry, new ItemGhostbane());
        register(registry, new ItemOrbOfLight());
        register(registry, new ItemStaffEnrichment("staff_of_enrichment"));
        register(registry, new ItemArcanaCharge());

        // Arcana boss spawners
        register(registry, new ItemWizardsBook("wizards_book"));

        // Arcana pet spawners
        register(registry, new ItemSpawnEgg("fyracryx_egg", EntityFyracryx::new));
        register(registry, new ItemSpawnEgg("paratiku_egg", EntityParatiku::new));
        register(registry, new ItemSpawnEgg("seimer_egg", EntitySeimer::new));
        register(registry, new ItemSpawnEgg("golem_of_rejuvenation_egg", EntityGolemOfRejuvenation::new));

        // Arcana crops
        register(registry, new ItemAquamarine("aquamarine"));
        register(registry, new ItemMod("firestock"));
        register(registry, new ItemLamona());
        register(registry, new ItemMod("marsine"));
        register(registry, new ItemModFood(2, 0.3F, "pinfly").setPotionEffect(new PotionEffect(MobEffects.SPEED, 10, 2), 1.0F));
        register(registry, new ItemMod("veilo"));
        register(registry, new ItemModFood(2, 3, "hitchak"));

        // Arcana keys
        register(registry, new ItemKey("ancient_key"));
        register(registry, new ItemKey("degraded_key"));
        register(registry, new ItemKey("soul_key"));
        register(registry, new ItemKey("sludge_key"));

        // Doors
        register(registry, new ItemModDoor(ModBlocks.ancientBrickDoor, "ancient_brick_door"));
        register(registry, new ItemModDoor(ModBlocks.degradedBrickDoor, "degraded_brick_door"));
        register(registry, new ItemModDoor(ModBlocks.soulSludgeDoor, "soul_sludge_door"));
        register(registry, new ItemModDoor(ModBlocks.soulStoneDoor, "soul_stone_door"));
        register(registry, new ItemModDoor(ModBlocks.steelDoor, "steel_door"));

        // Arcana potions
        register(registry, new ItemArcanaPotion("weak_arcana_potion", 100));
        register(registry, new ItemArcanaPotion("strong_arcana_potion", 200));

        // Arcana miscellaneous
        register(registry, new ItemMod("arcanium"));
        register(registry, new ItemChargedCollector("charged_collector"));
        register(registry, new ItemMod("collector"));
        register(registry, new ItemMod("dungeon_tokens"));

        // Seeds
        register(registry, new ItemArcanaSeeds("aquamarine_seeds", () -> ModBlocks.aquamarinePlant));
        register(registry, new ItemArcanaSeeds("eucalyptus_root_seeds", () -> ModBlocks.eucalyptusPlant));
        register(registry, new ItemArcanaSeeds("firestock_seeds", () -> ModBlocks.firestockPlant));
        register(registry, new ItemArcanaSeeds("hitchak_seeds", () -> ModBlocks.hitchakPlant));
        register(registry, new ItemArcanaSeeds("lamona_seeds", () -> ModBlocks.lamonaPlant));
        register(registry, new ItemArcanaSeeds("marsine_seeds", () -> ModBlocks.marsinePlant));
        register(registry, new ItemModSeeds("moonbulb_seeds", () -> ModBlocks.moonbulbPlant, () -> Blocks.FARMLAND));
        register(registry, new ItemArcanaSeeds("pinfly_seeds", () -> ModBlocks.pinflyPlant));
        register(registry, new ItemModSeeds("pink_glowbone_seeds", () -> ModBlocks.pinkGlowbonePlant, () -> Blocks.GRASS));
        register(registry, new ItemModSeeds("purple_glowbone_seeds", () -> ModBlocks.purpleGlowbonePlant, () -> Blocks.GRASS));
        register(registry, new ItemModSeeds("sky_plant_seeds", () -> ModBlocks.skyPlant, () -> Blocks.GRASS));
        register(registry, new ItemModSeeds("tomato_seeds", () -> ModBlocks.tomatoPlant, () -> Blocks.FARMLAND));
        register(registry, new ItemArcanaSeeds("veilo_seeds", () -> ModBlocks.veiloPlant));
        register(registry, new ItemModSeeds("white_mushroom_seeds", () -> ModBlocks.whiteMushroomPlant, () -> Blocks.FARMLAND));

        // Vethea
        // Vethea pearls
        register(registry, new ItemVethean("dirty_pearls"));
        register(registry, new ItemVethean("clean_pearls"));
        register(registry, new ItemVethean("polished_pearls"));
        register(registry, new ItemVethean("shiny_pearls"));

        // Vethea lumps
        register(registry, new ItemVethean("teaker_lump"));
        register(registry, new ItemVethean("amthirmis_lump"));
        register(registry, new ItemVethean("darven_lump"));
        register(registry, new ItemVethean("cermile_lump"));
        register(registry, new ItemVethean("pardimal_lump"));
        register(registry, new ItemVethean("quadrotic_lump"));
        register(registry, new ItemVethean("karos_lump"));
        register(registry, new ItemVethean("heliosis_lump"));
        register(registry, new ItemVethean("arksiane_lump"));

        // Vethea templates
        register(registry, new ItemVethean("backsword_template"));
        register(registry, new ItemVethean("bow_template"));
        register(registry, new ItemVethean("cannon_template"));
        register(registry, new ItemVethean("claw_template"));
        register(registry, new ItemVethean("disk_template"));
        register(registry, new ItemVethean("hammer_template"));
        register(registry, new ItemVethean("staff_template"));

        register(registry, new ItemVethean("degraded_template"));
        register(registry, new ItemVethean("finished_template"));
        register(registry, new ItemVethean("glistening_template"));
        register(registry, new ItemVethean("demonized_template"));
        register(registry, new ItemVethean("tormented_template"));

        // Vethea food
        register(registry, new ItemModFood(3, 0.4F, "dream_carrot").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new ItemModFood(6, 0.8F, "dream_melon").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new ItemModFood(4, 0.8F, "dream_pie").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new ItemModFood(8, 0.8F, "dream_cake").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new ItemHealingFood(0, 0F, 2, "dream_sweets").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new ItemHealingFood(0, 0F, 8, "dream_sours").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new ItemModFood(1, 0.2F, "honeysuckle").setCreativeTab(DivineRPGTabs.vethea));
        register(registry, new ItemModFood(1, 0.2F, "honeychunk").setCreativeTab(DivineRPGTabs.vethea));

        // Vethea boss spawners
        register(registry, new ItemVethean("dream_flint"));
        register(registry, new ItemVethean("moon_clock"));

        // Vethea arrows
        register(registry, new ItemVethean("teaker_arrow"));
        register(registry, new ItemVethean("darven_arrow"));
        register(registry, new ItemVethean("pardimal_arrow"));
        register(registry, new ItemVethean("karos_arrow"));
        register(registry, new ItemVethean("ever_arrow"));

        // Vethea portal item
        register(registry, new ItemNightmareBed());

        // Vethea door
        register(registry, new ItemModDoor(ModBlocks.barredDoor, "barred_door"));

        // Vethea miscellaneous
        register(registry, new ItemVethean("acid"));
        register(registry, new ItemVethean("band_of_heiva_hunting"));
        register(registry, new ItemVethean("miners_amulet"));
        register(registry, new ItemVethean("rock_chunks"));

        //Slabs
        register(registry, new ItemModSlab("eden_slab", ModBlocks.edenSlab, ModBlocks.edenSlab, ModBlocks.edenDoubleSlab));
        register(registry, new ItemModSlab("wildwood_slab", ModBlocks.wildwoodSlab, ModBlocks.wildwoodSlab, ModBlocks.wildwoodDoubleSlab));
        register(registry, new ItemModSlab("apalachia_slab", ModBlocks.apalachiaSlab, ModBlocks.apalachiaSlab, ModBlocks.apalachiaDoubleSlab));
        register(registry, new ItemModSlab("skythern_slab", ModBlocks.skythernSlab, ModBlocks.skythernSlab, ModBlocks.skythernDoubleSlab));
        register(registry, new ItemModSlab("mortum_slab", ModBlocks.mortumSlab, ModBlocks.mortumSlab, ModBlocks.mortumDoubleSlab));
        register(registry, new ItemModSlab("divine_slab", ModBlocks.divineSlab, ModBlocks.divineSlab, ModBlocks.divineDoubleSlab));
        register(registry, new ItemModSlab("frozen_slab", ModBlocks.frozenSlab, ModBlocks.frozenSlab, ModBlocks.frozenDoubleSlab));
        register(registry, new ItemModSlab("eucalyptus_slab", ModBlocks.eucalyptusSlab, ModBlocks.eucalyptusSlab, ModBlocks.eucalyptusDoubleSlab));

        register(registry, new ItemModSlab("eden_double_slab", ModBlocks.edenSlab, ModBlocks.edenSlab, ModBlocks.edenDoubleSlab));
        register(registry, new ItemModSlab("wildwood_double_slab", ModBlocks.wildwoodSlab, ModBlocks.wildwoodSlab, ModBlocks.wildwoodDoubleSlab));
        register(registry, new ItemModSlab("apalachia_double_slab", ModBlocks.apalachiaSlab, ModBlocks.apalachiaSlab, ModBlocks.apalachiaDoubleSlab));
        register(registry, new ItemModSlab("skythern_double_slab", ModBlocks.skythernSlab, ModBlocks.skythernSlab, ModBlocks.skythernDoubleSlab));
        register(registry, new ItemModSlab("mortum_double_slab", ModBlocks.mortumSlab, ModBlocks.mortumSlab, ModBlocks.mortumDoubleSlab));
        register(registry, new ItemModSlab("divine_double_slab", ModBlocks.divineSlab, ModBlocks.divineSlab, ModBlocks.divineDoubleSlab));
        register(registry, new ItemModSlab("frozen_double_slab", ModBlocks.frozenSlab, ModBlocks.frozenSlab, ModBlocks.frozenDoubleSlab));
        register(registry, new ItemModSlab("eucalyptus_double_slab", ModBlocks.eucalyptusSlab, ModBlocks.eucalyptusSlab, ModBlocks.eucalyptusDoubleSlab));

        // Shields
        register(registry, new DivineShield("arlemite_shield", DivineRPGTabs.armor, () -> arlemiteIngot, 1200));
        register(registry, new DivineShield("realmite_shield", DivineRPGTabs.armor, () -> realmiteIngot, 1200));
        register(registry, new DivineShield("rupee_shield", DivineRPGTabs.armor, () -> rupeeIngot, 1200));
        register(registry, new DivineShield("halite_shield", DivineRPGTabs.armor, () -> Item.getItemFromBlock(Blocks.AIR), 0));
        register(registry, new DivineShield("eden_shield", DivineRPGTabs.armor, () -> edenChunk, 1200));
        register(registry, new DivineShield("wildwood_shield", DivineRPGTabs.armor, () -> wildwoodChunk, 2400));
        register(registry, new DivineShield("apalachia_shield", DivineRPGTabs.armor, () -> apalachiaChunk, 4800));
        register(registry, new DivineShield("skythern_shield", DivineRPGTabs.armor, () -> skythernChunk, 9600));
        register(registry, new DivineShield("mortum_shield", DivineRPGTabs.armor, () -> mortumChunk, 19200));

    }

    private static void register(IForgeRegistry<Item> registry, Item item) {
        registry.register(item);
        itemMap.put(item.getRegistryName().getResourcePath(), item);
    }

    public static Item getItemFromMap(String itemName) {
        Item item = itemMap.get(itemName);
        if(item == null) {
            DivineRPG.logger.error("Attempted to get item " + itemName + " from DivineRPG, but there was no such item.");
        }
        return item;
    }
}