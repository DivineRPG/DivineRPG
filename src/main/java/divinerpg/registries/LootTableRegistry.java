package divinerpg.registries;

import com.google.common.collect.Sets;
import net.minecraft.resources.ResourceLocation;

import java.util.Set;

import static divinerpg.DivineRPG.MODID;
import static java.util.Collections.unmodifiableSet;

public class LootTableRegistry {
    private static final Set<ResourceLocation>
            LOOT_TABLES = Sets.newHashSet(),
            READ_ONLY_LOOT_TABLES = unmodifiableSet(LOOT_TABLES);
    public static final ResourceLocation
        //Chests
        //Overworld
            AMETHYST_GEODE = registerTable("chests/overworld/amethyst_geode"),
            ANCIENT_TOMB = registerTable("chests/overworld/ancient_tomb"),
            LIVESTOCK_MERCHANT_HUT = registerTable("chests/overworld/livestock_merchant_hut"),
        //Iceika
            ICEIKA_DUNGEON = registerTable("chests/iceika/dungeon"),
            ICEIKA_HUT = registerTable("chests/iceika/hut"),
            GROGLIN_VILLAGE = registerTable("chests/iceika/groglin_village"),
            GRUZZORLUG_VILLAGE = registerTable("chests/iceika/gruzzorlug_village"),
        //Arcana
            BANQUET_HALL = registerTable("chests/arcana/banquet_hall"),
            UTILITY_HALLWAY = registerTable("chests/arcana/utility_hallway"),
        //Twilight
            EDEN_HUT = registerTable("chests/twilight/eden/hut"),
            SKYTHERN_HUT = registerTable("chests/twilight/skythern/hut"),
            WILDWOOD_HUT = registerTable("chests/twilight/wildwood/hut"),
        //Vethea
            CRYPT = registerTable("chests/vethea/crypt"),
            KAROS_MADHOUSE = registerTable("chests/vethea/karos_madhouse"),
            QUADROTIC_POST = registerTable("chests/vethea/quadrotic_post"),
            RAGLOK_CHAMBER = registerTable("chests/vethea/raglok_chamber"),
            TEMPLE_BOTTOM = registerTable("chests/vethea/temple_bottom"),
            TEMPLE_MIDDLE = registerTable("chests/vethea/temple_middle"),
            TEMPLE_TOP = registerTable("chests/vethea/temple_top"),
            WRECK_HALL = registerTable("chests/vethea/wreck_hall"),
        //Entities
        //Bosses
            ANCIENT_ENTITY = registerTable("entities/ancient_entity"),
            THE_WATCHER = registerTable("entities/the_watcher"),
            KING_OF_SCORCHERS = registerTable("entities/king_of_scorchers"),
            KITRA = registerTable("entities/kitra"),
            AYERACO = registerTable("entities/ayeraco"),
            DRAMIX = registerTable("entities/dramix"),
            PARASECTA = registerTable("entities/parasecta"),
            SUNSTORM = registerTable("entities/sunstorm"),
            TERMASECT = registerTable("entities/termasect"),
            ETERNAL_ARCHER = registerTable("entities/eternal_archer"),
            EXPERIENCED_CORI = registerTable("entities/experienced_cori"),
            VAMACHERON = registerTable("entities/vamacheron"),
            KAROT = registerTable("entities/karot"),
            TWILIGHT_DEMON = registerTable("entities/twilight_demon"),
            DENSOS = registerTable("entities/densos"),
            REYVOR = registerTable("entities/reyvor"),
            SOUL_FIEND = registerTable("entities/soul_fiend"),
            HIVE_QUEEN = registerTable("entities/hive_queen"),
            KAROS = registerTable("entities/karos"),
            LADY_LUNA = registerTable("entities/lady_luna"),
            QUADRO = registerTable("entities/quadro"),
            RAGLOK = registerTable("entities/raglok"),
            WRECK = registerTable("entities/wreck"),
        //Overworld
        //Livestock
            SNAPPER = registerTable("entities/snapper"),
            EHU = registerTable("entities/ehu"),
            HUSK = registerTable("entities/husk"),
            BROWN_GRIZZLE = registerTable("entities/brown_grizzle"),
            WHITE_GRIZZLE = registerTable("entities/white_grizzle"),
            STONE_GOLEM = registerTable("entities/stone_golem"),
            SMELTER = registerTable("entities/smelter"),
        //Forest & Plains
            LIVESTOCK_MERCHANT = registerTable("entities/livestock_merchant"),
            JACK_O_MAN = registerTable("entities/jack_o_man"),
            CYCLOPS = registerTable("entities/cyclops"),
            KOBBLIN = registerTable("entities/kobblin"),
            PUMPKIN_SPIDER = registerTable("entities/pumpkin_spider"),
        //Jungle
            JUNGLE_BAT = registerTable("entities/jungle_bat"),
            JUNGLE_SPIDER = registerTable("entities/jungle_spider"),
            JUNGLE_DRAMCRYX = registerTable("entities/jungle_dramcryx"),
        //Desert
            SAGUARO_WORM = registerTable("entities/saguaro_worm"),
            DESERT_CRAWLER = registerTable("entities/desert_crawler"),
            ARID_WARRIOR = registerTable("entities/arid_warrior"),
        //Snowy
            GLACON = registerTable("entities/glacon"),
            FROST = registerTable("entities/frost"),
        //Beach
            CRAB = registerTable("entities/crab"),
            KING_CRAB = registerTable("entities/king_crab"),
        //Water
            AEQUOREA = registerTable("entities/aequorea"),
            SHARK = registerTable("entities/shark"),
            WHALE = registerTable("entities/whale"),
            LIOPLEURODON = registerTable("entities/liopleurodon"),
        //Cave
            DIAMOND_DAVE = registerTable("entities/diamond_dave"),
            RAINBOUR = registerTable("entities/rainbour"),
            MINER = registerTable("entities/miner"),
            ROTATICK = registerTable("entities/rotatick"),
            CAVE_CRAWLER = registerTable("entities/cave_crawler"),
            CAVECLOPS = registerTable("entities/caveclops"),
            THE_EYE = registerTable("entities/the_eye"),
            ENTHRALLED_DRAMCRYX = registerTable("entities/enthralled_dramcryx"),
            THE_GRUE = registerTable("entities/the_grue"),
        //Nether
            HELL_PIG = registerTable("entities/hell_pig"),
            HELL_SPIDER = registerTable("entities/hell_spider"),
            WILDFIRE = registerTable("entities/wildfire"),
            SCORCHER = registerTable("entities/scorcher"),
        //End
            ENDER_SCROUNGE = registerTable("entities/ender_scrounge"),
            ENDER_SPIDER = registerTable("entities/ender_spider"),
            ENDER_WATCHER = registerTable("entities/ender_watcher"),
            ENDER_TRIPLETS = registerTable("entities/ender_triplets"),
        //Iceika
            CAULDRON_FISH = registerTable("entities/cauldron_fish"),
            PINK_GHOST_GLIDER = registerTable("entities/pink_ghost_glider"),
            BLUBBERTUSK = registerTable("entities/blubbertusk"),
            ROBBIN = registerTable("entities/robbin"),
            SNOW_SKIPPER = registerTable("entities/snow_skipper"),
            WOLPERTINGER = registerTable("entities/wolpertinger"),
            DOLOSSAL = registerTable("entities/dolossal"),
            MAMOTH = registerTable("entities/mamoth"),
            WORKSHOP_MERCHANT = registerTable("entities/workshop_merchant"),
            WORKSHOP_TINKERER = registerTable("entities/workshop_tinkerer"),
            ROLLUM = registerTable("entities/rollum"),
            PALE_ARCHER = registerTable("entities/pale_archer"),
            FROZEN_FLESH = registerTable("entities/frozen_flesh"),
            ALICANTO = registerTable("entities/alicanto"),
            SENG = registerTable("entities/seng"),
            SABEAR = registerTable("entities/sabear"),
            HASTREUS = registerTable("entities/hastreus"),
            GLACIDE = registerTable("entities/glacide"),
            FRACTITE = registerTable("entities/fractite"),
        //Groglins
            GROGLIN_MERCHANT = registerTable("entities/groglin_merchant"),
            GROGLIN_SHARLATAN = registerTable("entities/groglin_sharlatan"),
            GROGLIN_HUNTER = registerTable("entities/groglin_hunter"),
            GROGLIN_RANGER = registerTable("entities/groglin_ranger"),
            GROGLIN_WARRIOR = registerTable("entities/groglin_warrior"),
            GROGLIN_CHIEFTAIN = registerTable("entities/groglin_chieftain"),
        //Gruzzorlugs
            GRUZZORLUG_MINER = registerTable("entities/gruzzorlug_miner"),
            GRUZZORLUG_CANNONEER = registerTable("entities/gruzzorlug_cannoneer"),
            GRUZZORLUG_COMMANDER = registerTable("entities/gruzzorlug_commander"),
            GRUZZORLUG_SWORDSMAN = registerTable("entities/gruzzorlug_swordsman"),
            GRUZZORLUG_KNIGHT = registerTable("entities/gruzzorlug_knight"),
            GRUZZORLUG_GENERAL = registerTable("entities/gruzzorlug_general"),
        //Arcana traders
            CAPTAIN_MERIK = registerTable("entities/captain_merik"),
            DATTICON = registerTable("entities/datticon"),
            KAZARI = registerTable("entities/kazari"),
            LEORNA = registerTable("entities/leorna"),
            LORD_VATTICUS = registerTable("entities/lord_vatticus"),
            WAR_GENERAL = registerTable("entities/war_general"),
            ZELUS = registerTable("entities/zelus"),
        //Arcana pets
            FYRACRYX = registerTable("entities/fyracryx"),
            GOLEM_OF_REJUVENATION = registerTable("entities/golem_of_rejuvenation"),
            PARATIKU = registerTable("entities/paratiku"),
            SEIMER = registerTable("entities/seimer"),
            WRAITH = registerTable("entities/wraith"),
        //Arcana mobs
            SKYRE = registerTable("entities/skyre"),
            RAZORBACK = registerTable("entities/razorback"),
            DEATH_HOUND = registerTable("entities/death_hound"),
            DUNGEON_CONSTRUCTOR = registerTable("entities/dungeon_constructor"),
            DUNGEON_PRISONER = registerTable("entities/dungeon_prisoner"),
            DUNGEON_DEMON = registerTable("entities/dungeon_demon"),
            ROAMER = registerTable("entities/roamer"),
            DEATHCRYX = registerTable("entities/deathcryx"),
            LIVING_STATUE = registerTable("entities/living_statue"),
        //Eden
            GEM_FIN = registerTable("entities/gem_fin"),
            GLINTHOP = registerTable("entities/glinthop"),
            EDEN_TOMO = registerTable("entities/tomo"),
            EDEN_CADILLION = registerTable("entities/cadillion"),
            GREENFEET = registerTable("entities/greenfeet"),
            MADIVEL = registerTable("entities/madivel"),
            SUN_ARCHER = registerTable("entities/sun_archer"),
            WEAK_CORI = registerTable("entities/weak_cori"),
        //Wildwood
            MOON_WOLF = registerTable("entities/moon_wolf"),
            WILDWOOD_TOMO = registerTable("entities/wildwood_tomo"),
            WILDWOOD_CADILLION = registerTable("entities/wildwood_cadillion"),
            EPIPHITE = registerTable("entities/epiphite"),
            BEHEMOTH = registerTable("entities/behemoth"),
            TERMID = registerTable("entities/termid"),
            VEREK = registerTable("entities/verek"),
            WILDWOOD_GOLEM = registerTable("entities/wildwood_golem"),
            MAGE = registerTable("entities/mage"),
        //Apalachia
            APALACHIA_TOMO = registerTable("entities/apalachia_tomo"),
            APALACHIA_CADILLION = registerTable("entities/apalachia_cadillion"),
            ENCHANTED_WARRIOR = registerTable("entities/enchanted_warrior"),
            APALACHIA_GOLEM = registerTable("entities/apalachia_golem"),
            ENCHANTED_ARCHER = registerTable("entities/enchanted_archer"),
            SPELLBINDER = registerTable("entities/spellbinder"),
        //Skythern
            SAMEK = registerTable("entities/samek"),
            SKYTHERN_FIEND = registerTable("entities/skythern_fiend"),
            SKYTHERN_GOLEM = registerTable("entities/skythern_golem"),
            MEGALITH = registerTable("entities/megalith"),
            SKYTHERN_ARCHER = registerTable("entities/skythern_archer"),
            MYSTIC = registerTable("entities/mystic"),
            ADVANCED_CORI = registerTable("entities/advanced_cori"),
        //Mortum
            ANGRY_GLINTHOP = registerTable("entities/angry_glinthop"),
            MORTUM_CADILLION = registerTable("entities/mortum_cadillion"),
            SOUL_SPIDER = registerTable("entities/soul_spider"),
            BASILISK = registerTable("entities/basilisk"),
            DEMON_OF_DARKNESS = registerTable("entities/demon_of_darkness"),
            SOUL_STEALER = registerTable("entities/soul_stealer"),
            TWILIGHT_ARCHER = registerTable("entities/twilight_archer"),
            SORCERER = registerTable("entities/sorcerer"),
        //Vethea
        //Layer 1
            THE_HUNGER = registerTable("entities/the_hunger"),
            CRYPT_KEEPER = registerTable("entities/crypt_keeper"),
            MYSTERIOUS_MAN_LAYER_1 = registerTable("entities/mysterious_man_layer_1"),
            ACID_HAG = registerTable("entities/acid_hag"),
            CYMESOID = registerTable("entities/cymesoid"),
            DREAMWRECKER = registerTable("entities/dreamwrecker"),
            DUO = registerTable("entities/duo"),
            ENT = registerTable("entities/ent"),
            LORGA = registerTable("entities/lorga"),
            SHADAHIER = registerTable("entities/shadahier"),
        //Hive
            HIVE_SOLDIER = registerTable("entities/hive_soldier"),
            HOVER_STINGER = registerTable("entities/hover_stinger"),
        //Layer 2
            TEMPLE_GUARDIAN = registerTable("entities/temple_guardian"),
            MYSTERIOUS_MAN_LAYER_2 = registerTable("entities/mysterious_man_layer_2"),
            BIPHRON = registerTable("entities/biphron"),
            GORGOSION = registerTable("entities/gorgosion"),
            INSECT_FOURTEEN = registerTable("entities/insect_fourteen"),
            MANDRAGORA = registerTable("entities/mandragora"),
            TWINS = registerTable("entities/twins"),
            VERMENOUS = registerTable("entities/vermenous"),
        //Layer 3
            MYSTERIOUS_MAN_LAYER_3 = registerTable("entities/mysterious_man_layer_3"),
            BOHEMITE = registerTable("entities/bohemite"),
            GALROID = registerTable("entities/galroid"),
            KAZROTIC = registerTable("entities/kazrotic"),
            LHEIVA = registerTable("entities/lheiva"),
            LORGA_FLIGHT = registerTable("entities/lorga_flight"),
            TOCAXIN = registerTable("entities/tocaxin"),
        //Layer 4
            DISSIMENT = registerTable("entities/dissiment"),
            HELIO = registerTable("entities/helio"),
            VHRAAK = registerTable("entities/vhraak"),
            FAKE_VHRAAK = registerTable("entities/fake_vhraak"),
            ZONE = registerTable("entities/zone"),
            ZORAGON = registerTable("entities/zoragon");
    private static ResourceLocation registerTable(String id) {return register(ResourceLocation.fromNamespaceAndPath(MODID, id));}
    private static ResourceLocation register(ResourceLocation id) {
        if(LOOT_TABLES.add(id)) return id;
        else throw new IllegalArgumentException(id + " is already a registered built-in loot table");
    }
    public static Set<ResourceLocation> all() {return READ_ONLY_LOOT_TABLES;}
}