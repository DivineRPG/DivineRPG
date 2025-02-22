package divinerpg.registries;

import divinerpg.DivineRPG;
import com.google.common.collect.Sets;
import net.minecraft.resources.ResourceLocation;
import java.util.*;

public class LootTableRegistry {
    private static final Set<ResourceLocation>
            LOOT_TABLES = Sets.newHashSet(),
            READ_ONLY_LOOT_TABLES = Collections.unmodifiableSet(LOOT_TABLES);
    public static final ResourceLocation
        //Chests
        //Overworld
            AMETHYST_GEODE = registerTable("chests/overworld/amethyst"),
            ANCIENT_TOMB = registerTable("chests/overworld/ancient_tomb"),
            LIVESTOCK_MERCHANT_HUT = registerTable("chests/overworld/livestock_chest"),
        //Iceika
            ICEIKA_DUNGEON = registerTable("chests/iceika/iceika_chest_dungeon"),
            ICEIKA_HUT = registerTable("chests/iceika/iceika_chest_hut"),
            GROGLIN_VILLAGE = registerTable("chests/iceika/groglin_chest"),
            GRUZZORLUG_VILLAGE = registerTable("chests/iceika/gruzzorlug_chest"),
        //Arcana
            BANQUET_HALL = registerTable("chests/arcana/banquet_hall_loot"),
            UTILITY_HALLWAY = registerTable("chests/arcana/utility_hallway_loot"),
        //Twilight
            EDEN_HUT = registerTable("chests/twilight/eden/hut_chest"),
            SKYTHERN_HUT = registerTable("chests/twilight/skythern/chest"),
            WILDWOOD_HUT = registerTable("chests/twilight/wildwood/chest"),
        //Vethea
            CRYPT = registerTable("chests/vethea/crypt_loot"),
            KAROS_MADHOUSE = registerTable("chests/vethea/karos_madhouse_loot"),
            QUADROTIC_POST = registerTable("chests/vethea/quadrotic_post_loot"),
            RAGLOK_CHAMBER = registerTable("chests/vethea/raglok_chamber_loot"),
            TEMPLE_BOTTOM = registerTable("chests/vethea/temple_loot_bottom"),
            TEMPLE_MIDDLE = registerTable("chests/vethea/temple_loot_middle"),
            TEMPLE_TOP = registerTable("chests/vethea/temple_loot_top"),
            WRECK_HALL = registerTable("chests/vethea/wreck_hall_loot"),
        //Entities TODO: to add missing entries or remove entirely if never used
        //Overworld
            ARID_WARRIOR = registerTable("entities/arid_warrior"),
            CAVECLOPS = registerTable("entities/caveclops"),
            CAVE_CRAWLER = registerTable("entities/cave_crawler"),
            CRAB = registerTable("entities/crab"),
            CYCLOPS = registerTable("entities/cyclops"),
            DESERT_CRAWLER = registerTable("entities/desert_crawler"),
            ENTHRALLED_DRAMCRYX = registerTable("entities/enthralled_dramcryx"),
            FROST = registerTable("entities/frost"),
            GLACON = registerTable("entities/glacon"),
            JUNGLE_BAT = registerTable("entities/jungle_bat"),
            JUNGLE_DRAMCRYX = registerTable("entities/jungle_dramcryx"),
            JUNGLE_SPIDER = registerTable("entities/jungle_spider"),
            KING_CRAB = registerTable("entities/king_crab"),
            KOBBLIN = registerTable("entities/kobblin"),
            LIOPLEURODON = registerTable("entities/liopleurodon"),
            MINER = registerTable("entities/miner"),
            PUMPKIN_SPIDER = registerTable("entities/pumpkin_spider"),
            RAINBOUR = registerTable("entities/rainbour"),
            ROTATICK = registerTable("entities/rotatick"),
            SAGUARO_WORM = registerTable("entities/saguaro_worm"),
            SHARK = registerTable("entities/shark"),
            THE_EYE = registerTable("entities/the_eye"),
            THE_GRUE = registerTable("entities/the_grue"),
            WHALE = registerTable("entities/whale"),
        //Nether
            HELL_PIG = registerTable("entities/hell_pig"),
            HELL_SPIDER = registerTable("entities/hell_spider"),
            SCORCHER = registerTable("entities/scorcher"),
            WILDFIRE = registerTable("entities/wildfire"),
        //End
            ENDER_SPIDER = registerTable("entities/ender_spider"),
            ENDER_TRIPLETS = registerTable("entities/ender_triplets"),
            ENDER_WATCHER = registerTable("entities/ender_watcher"),
        //Iceika
            ALICANTO = registerTable("entities/alicanto"),
            FRACTITE = registerTable("entities/fractite"),
            FROZEN_FLESH = registerTable("entities/frozen_flesh"),
            GLACIDE = registerTable("entities/glacide"),
            HASTREUS = registerTable("entities/hastreus"),
            PALE_ARCHER = registerTable("entities/pale_archer"),
            ROLLUM = registerTable("entities/rollum"),
        //Arcana traders
            CAPTAIN_MERIK = registerTable("entities/captain_merik"),
            DATTICON = registerTable("entities/datticon"),
            KAZARI = registerTable("entities/kazari"),
            LEORNA = registerTable("entities/leorna"),
            LORD_VATTICUS = registerTable("entities/lord_vatticus"),
            WAR_GENERAL = registerTable("entities/war_general"),
            ZELUS = registerTable("entities/zelus"),
        //Arcana pets
            FYRACRYX = registerTable("entities/ryracryx"),
            GOLEM_OF_REJUVENATION = registerTable("entities/golem_of_rejuvenation"),
            PARATIKU = registerTable("entities/paratiku"),
            SEIMER = registerTable("entities/seimer"),
            WRAITH = registerTable("entities/wraith"),
        //Other Arcana mobs
            DEATHCRYX = registerTable("entities/deathcryx"),
            DEATH_HOUND = registerTable("entities/death_hound"),
            DUNGEON_CONSTRUCTOR = registerTable("entities/dungeon_constructor"),
            DUNGEON_DEMON = registerTable("entities/dungeon_demon"),
            DUNGEON_PRISONER = registerTable("entities/dungeon_prisoner"),
            LIVING_STATUE = registerTable("entities/living_statue"),
            RAZORBACK = registerTable("entities/razorback"),
            ROAMER = registerTable("entities/roamer"),
        //Eden
            GLINTHOP = registerTable("entities/glinthop"),
            EDEN_CADILLION = registerTable("entities/cadillion"),
            EDEN_TOMO = registerTable("entities/tomo"),
            GREENFEET = registerTable("entities/greenfeet"),
            MADIVEL = registerTable("entities/madivel"),
            SUN_ARCHER = registerTable("entities/sun_archer"),
            WEAK_CORI = registerTable("entities/weak_cori"),
        //Wildwood
            BEHEMOTH = registerTable("entities/behemoth"),
            EPIPHITE = registerTable("entities/epiphite"),
            MAGE = registerTable("entities/mage"),
            MOON_WOLF = registerTable("entities/moon_wolf"),
            TERMID = registerTable("entities/termid"),
            VEREK = registerTable("entities/verek"),
            WILDWOOD_CADILLION = registerTable("entities/wildwood_cadillion"),
            WILDWOOD_GOLEM = registerTable("entities/wildwood_golem"),
            WILDWOOD_TOMO = registerTable("entities/wildwood_tomo"),
        //Apalachia
            APALACHIA_CADILLION = registerTable("entities/apalachia_cadillion"),
            APALACHIA_GOLEM = registerTable("entities/apalachia_golem"),
            APALACHIA_TOMO = registerTable("entities/apalachia_tomo"),
            ENCHANTED_ARCHER = registerTable("entities/enchanted_archer"),
            ENCHANTED_WARRIOR = registerTable("entities/enchanted_warrior"),
            SPELLBINDER = registerTable("entities/spellbinder"),
        //Skythern
            ADVANCED_CORI = registerTable("entities/advanced_cori"),
            MEGALITH = registerTable("entities/megalith"),
            SAMEK = registerTable("entities/samek"),
            SKYTHERN_ARCHER = registerTable("entities/skythern_archer"),
            SKYTHERN_FIEND = registerTable("entities/skythern_fiend"),
            SKYTHERN_GOLEM = registerTable("entities/skythern_golem"),
        //Mortum
            ANGRY_GLINTHOP = registerTable("entities/angry_glinthop"),
            BASILISK = registerTable("entities/basilisk"),
            DEMON_OF_DARKNESS = registerTable("entities/demon_of_darkness"),
            MORTUM_CADILLION = registerTable("entities/mortum_cadillion"),
            MYSTIC = registerTable("entities/mystic"),
            SORCERER = registerTable("entities/sorcerer"),
            SOUL_SPIDER = registerTable("entities/soul_spider"),
            SOUL_STEALER = registerTable("entities/soul_stealer"),
            TWILIGHT_ARCHER = registerTable("entities/twilight_archer"),
        //Vethea
            ACID_HAG = registerTable("entities/acid_hag"),
            BIPHRON = registerTable("entities/biphron"),
            BOHEMITE = registerTable("entities/bohemite"),
            CYMESOID = registerTable("entities/cymesoid"),
            DISSIMENT = registerTable("entities/dissiment"),
            DREAMWRECKER = registerTable("entities/dreamwrecker"),
            DUO = registerTable("entities/duo"),
            ENT = registerTable("entities/ent"),
            FAKE_VHRAAK = registerTable("entities/fake_vhraak"),
            GALROID = registerTable("entities/galroid"),
            GORGOSION = registerTable("entities/gorgosion"),
            HELIO = registerTable("entities/helio"),
            HIVE_SOLDIER = registerTable("entities/hive_soldier"),
            HOVER_STINGER = registerTable("entities/hover_stinger"),
            KAZROTIC = registerTable("entities/kazrotic"),
            LHEIVA = registerTable("entities/lheiva"),
            LORGA = registerTable("entities/lorga"),
            LORGAFLIGHT = registerTable("entities/lorgaflight"),
            MANDRAGORA = registerTable("entities/mandragora"),
            SHADAHIER = registerTable("entities/shadahier"),
            TOCAXIN = registerTable("entities/tocaxin"),
            TWINS = registerTable("entities/twins"),
            VERMENOUS = registerTable("entities/vermenous"),
            VHRAAK = registerTable("entities/vhraak"),
            ZONE = registerTable("entities/zone"),
            ZORAGON = registerTable("entities/zoragon"),
        //Bosses
            ANCIENT_ENTITY = registerTable("entities/ancient_entity"),
            AYERACO_BLUE = registerTable("entities/ayeraco"),
            DENSOS = registerTable("entities/densos"),
            DRAMIX = registerTable("entities/dramix"),
            ETERNAL_ARCHER = registerTable("entities/eternal_archer"),
            EXPERIENCED_CORI = registerTable("entities/experienced_cori"),
            HIVE_QUEEN = registerTable("entities/hive_queen"),
            KAROS = registerTable("entities/karos"),
            KAROT = registerTable("entities/karot"),
            KING_OF_SCORCHERS = registerTable("entities/king_of_scorchers"),
            LADY_LUNA = registerTable("entities/lady_luna"),
            PARASECTA = registerTable("entities/parasecta"),
            QUADRO = registerTable("entities/quadro"),
            RAGLOK = registerTable("entities/raglok"),
            REYVOR = registerTable("entities/reyvor"),
            SOUL_FIEND = registerTable("entities/soul_fiend"),
            SUNSTORM = registerTable("entities/sunstorm"),
            TERMASECT = registerTable("entities/termasect"),
            THE_WATCHER = registerTable("entities/the_watcher"),
            TWILIGHT_DEMON = registerTable("entities/twilight_demon"),
            VAMACHERON = registerTable("entities/vamacheron"),
            WRECK = registerTable("entities/wreck");
    private static ResourceLocation registerTable(String id) {return register(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, id));}
    private static ResourceLocation register(ResourceLocation id) {
        if(LOOT_TABLES.add(id)) return id;
        else throw new IllegalArgumentException(id + " is already a registered built-in loot table");
    }
    public static Set<ResourceLocation> all() {return READ_ONLY_LOOT_TABLES;}
}