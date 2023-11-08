package divinerpg.registries;

import divinerpg.DivineRPG;
import com.google.common.collect.Sets;
import net.minecraft.resources.ResourceLocation;

import java.util.*;

public class LootTableRegistry {

    private static final Set<ResourceLocation> LOOT_TABLES = Sets.newHashSet();
    private static final Set<ResourceLocation> READ_ONLY_LOOT_TABLES = Collections.unmodifiableSet(LOOT_TABLES);

    public static final ResourceLocation BANQUET_HALL_LOOT = registerTable("chests/arcana/banquet_hall_loot");
    public static final ResourceLocation UTILITY_HALLWAY_LOOT = registerTable("chests/arcana/utility_hallway_loot");

    public static final ResourceLocation ICEIKA_CHEST_DUNGEON = registerTable("chests/iceika/iceika_chest_dungeon");
    public static final ResourceLocation ICEIKA_CHEST_HUT = registerTable("chests/iceika/iceika_chest_hut");

    public static final ResourceLocation CRYPT_LOOT = registerTable("chests/vethea/crypt_loot");
    public static final ResourceLocation TEMPLE_LOOT_BOTTOM = registerTable("chests/vethea/temple_loot_bottom");
    public static final ResourceLocation TEMPLE_LOOT_MIDDLE = registerTable("chests/vethea/temple_loot_middle");
    public static final ResourceLocation TEMPLE_LOOT_TOP = registerTable("chests/vethea/temple_loot_top");
    public static final ResourceLocation QUADROTIC_POST_LOOT = registerTable("chests/vethea/quadrotic_post_loot");
    public static final ResourceLocation KAROS_MADHOUSE_LOOT = registerTable("chests/vethea/karos_madhouse_loot");
    public static final ResourceLocation RAGLOK_CHAMBER_LOOT = registerTable("chests/vethea/raglok_chamber_loot");
    public static final ResourceLocation WRECK_HALL_LOOT = registerTable("chests/vethea/wreck_hall_loot");

    public static final ResourceLocation ENTITIES_ARID_WARRIOR = registerTable("entities/arid_warrior");
    public static final ResourceLocation ENTITIES_CAVECLOPS = registerTable("entities/caveclops");
    public static final ResourceLocation ENTITIES_CAVE_CRAWLER = registerTable("entities/cave_crawler");
    public static final ResourceLocation ENTITIES_CRAB = registerTable("entities/crab");
    public static final ResourceLocation ENTITIES_CYCLOPS = registerTable("entities/cyclops");
    public static final ResourceLocation ENTITIES_DESERT_CRAWLER = registerTable("entities/desert_crawler");
    public static final ResourceLocation ENTITIES_ENTHRALLED_DRAMCRYX = registerTable("entities/enthralled_dramcryx");
    public static final ResourceLocation ENTITIES_FROST = registerTable("entities/frost");
    public static final ResourceLocation ENTITIES_GLACON = registerTable("entities/glacon");
    public static final ResourceLocation ENTITIES_JUNGLE_BAT = registerTable("entities/jungle_bat");
    public static final ResourceLocation ENTITIES_JUNGLE_DRAMCRYX = registerTable("entities/jungle_dramcryx");
    public static final ResourceLocation ENTITIES_JUNGLE_SPIDER = registerTable("entities/jungle_spider");
    public static final ResourceLocation ENTITIES_KING_CRAB = registerTable("entities/king_crab");
    public static final ResourceLocation ENTITIES_KOBBLIN = registerTable("entities/kobblin");
    public static final ResourceLocation ENTITIES_LIOPLEURODON = registerTable("entities/liopleurodon");
    public static final ResourceLocation ENTITIES_MINER = registerTable("entities/miner");
    public static final ResourceLocation ENTITIES_PUMPKIN_SPIDER = registerTable("entities/pumpkin_spider");
    public static final ResourceLocation ENTITIES_RAINBOUR = registerTable("entities/rainbour");
    public static final ResourceLocation ENTITIES_ROTATICK = registerTable("entities/rotatick");
    public static final ResourceLocation ENTITIES_SAGUARO_WORM = registerTable("entities/saguaro_worm");
    public static final ResourceLocation ENTITIES_SHARK = registerTable("entities/shark");
    public static final ResourceLocation ENTITIES_THE_EYE = registerTable("entities/the_eye");
    public static final ResourceLocation ENTITIES_THE_GRUE = registerTable("entities/the_grue");
    public static final ResourceLocation ENTITIES_WHALE = registerTable("entities/whale");

    public static final ResourceLocation ENTITIES_HELL_PIG = registerTable("entities/hell_pig");
    public static final ResourceLocation ENTITIES_HELL_SPIDER = registerTable("entities/hell_spider");
    public static final ResourceLocation ENTITIES_SCORCHER = registerTable("entities/scorcher");
    public static final ResourceLocation ENTITIES_WILDFIRE = registerTable("entities/wildfire");

    public static final ResourceLocation ENTITIES_ENDER_SPIDER = registerTable("entities/ender_spider");
    public static final ResourceLocation ENTITIES_ENDER_TRIPLETS = registerTable("entities/ender_triplets");
    public static final ResourceLocation ENTITIES_ENDER_WATCHER = registerTable("entities/ender_watcher");

    public static final ResourceLocation ENTITIES_GLINTHOP = registerTable("entities/glinthop");
    public static final ResourceLocation ENTITIES_EDEN_CADILLION = registerTable("entities_cadillion");
    public static final ResourceLocation ENTITIES_EDEN_TOMO = registerTable("entities_tomo");
    public static final ResourceLocation ENTITIES_GREENFEET = registerTable("entities/greenfeet");
    public static final ResourceLocation ENTITIES_MADIVEL = registerTable("entities/madivel");
    public static final ResourceLocation ENTITIES_SUN_ARCHER = registerTable("entities/sun_archer");
    public static final ResourceLocation ENTITIES_WEAK_CORI = registerTable("entities/weak_cori");

    public static final ResourceLocation ENTITIES_BEHEMOTH = registerTable("entities/behemoth");
    public static final ResourceLocation ENTITIES_EPIPHITE = registerTable("entities/epiphite");
    public static final ResourceLocation ENTITIES_MAGE = registerTable("entities/mage");
    public static final ResourceLocation ENTITIES_MOON_WOLF = registerTable("entities/moon_wolf");
    public static final ResourceLocation ENTITIES_TERMID = registerTable("entities/termid");
    public static final ResourceLocation ENTITIES_VEREK = registerTable("entities/verek");
    public static final ResourceLocation ENTITIES_WILDWOOD_CADILLION = registerTable("entities/wildwood_cadillion");
    public static final ResourceLocation ENTITIES_WILDWOOD_GOLEM = registerTable("entities/wildwood_golem");
    public static final ResourceLocation ENTITIES_WILDWOOD_TOMO = registerTable("entities/wildwood_tomo");

    public static final ResourceLocation ENTITIES_APALACHIA_CADILLION = registerTable("entities/apalachia_cadillion");
    public static final ResourceLocation ENTITIES_APALACHIA_GOLEM = registerTable("entities/apalachia_golem");
    public static final ResourceLocation ENTITIES_APALACHIA_TOMO = registerTable("entities/apalachia_tomo");
    public static final ResourceLocation ENTITIES_ENCHANTED_ARCHER = registerTable("entities/enchanted_archer");
    public static final ResourceLocation ENTITIES_ENCHANTED_WARRIOR = registerTable("entities/enchanted_warrior");
    public static final ResourceLocation ENTITIES_SPELLBINDER = registerTable("entities/spellbinder");

    public static final ResourceLocation ENTITIES_ADVANCED_CORI = registerTable("entities/advanced_cori");
    public static final ResourceLocation ENTITIES_MEGALITH = registerTable("entities/megalith");
    public static final ResourceLocation ENTITIES_SAMEK = registerTable("entities/samek");
    public static final ResourceLocation ENTITIES_SKYTHERN_ARCHER = registerTable("entities/skythern_archer");
    public static final ResourceLocation ENTITIES_SKYTHERN_FIEND = registerTable("entities/skythern_fiend");
    public static final ResourceLocation ENTITIES_SKYTHERN_GOLEM = registerTable("entities/skythern_golem");

    public static final ResourceLocation ENTITIES_ANGRY_GLINTHOP = registerTable("entities/angry_glinthop");
    public static final ResourceLocation ENTITIES_BASILISK = registerTable("entities/basilisk");
    public static final ResourceLocation ENTITIES_DEMON_OF_DARKNESS = registerTable("entities/demon_of_darkness");
    public static final ResourceLocation ENTITIES_MORTUM_CADILLION = registerTable("entities/mortum_cadillion");
    public static final ResourceLocation ENTITIES_MYSTIC = registerTable("entities/mystic");
    public static final ResourceLocation ENTITIES_SORCERER = registerTable("entities/sorcerer");
    public static final ResourceLocation ENTITIES_SOUL_SPIDER = registerTable("entities/soul_spider");
    public static final ResourceLocation ENTITIES_SOUL_STEALER = registerTable("entities/soul_stealer");
    public static final ResourceLocation ENTITIES_TWILIGHT_ARCHER = registerTable("entities/twilight_archer");

    public static final ResourceLocation ENTITIES_ALICANTO = registerTable("entities/alicanto");
    public static final ResourceLocation ENTITIES_FRACTITE = registerTable("entities/fractite");
    public static final ResourceLocation ENTITIES_PALE_ARCHER = registerTable("entities/pale_archer");
    public static final ResourceLocation ENTITIES_FROZEN_FLESH = registerTable("entities/frozen_flesh");
    public static final ResourceLocation ENTITIES_GLACIDE = registerTable("entities/glacide");
    public static final ResourceLocation ENTITIES_HASTREUS = registerTable("entities/hastreus");
    public static final ResourceLocation ENTITIES_ROLLUM = registerTable("entities/rollum");

    public static final ResourceLocation ENTITIES_DEATHCRYX = registerTable("entities/deathcryx");
    public static final ResourceLocation ENTITIES_DEATH_HOUND = registerTable("entities/death_hound");
    public static final ResourceLocation ENTITIES_DUNGEON_CONSTRUCTOR = registerTable("entities/dungeon_constructor");
    public static final ResourceLocation ENTITIES_DUNGEON_DEMON = registerTable("entities/dungeon_demon");
    public static final ResourceLocation ENTITIES_DUNGEON_PRISONER = registerTable("entities/dungeon_prisoner");
    public static final ResourceLocation ENTITIES_LIVING_STATUE = registerTable("entities/living_statue");
    public static final ResourceLocation ENTITIES_RAZORBACK = registerTable("entities/razorback");
    public static final ResourceLocation ENTITIES_ROAMER = registerTable("entities/roamer");

    public static final ResourceLocation ENTITIES_ACID_HAG = registerTable("entities/acid_hag");
    public static final ResourceLocation ENTITIES_BIPHRON = registerTable("entities/biphron");
    public static final ResourceLocation ENTITIES_BOHEMITE = registerTable("entities/bohemite");
    public static final ResourceLocation ENTITIES_CYMESOID = registerTable("entities/cymesoid");
    public static final ResourceLocation ENTITIES_DISSIMENT = registerTable("entities/dissiment");
    public static final ResourceLocation ENTITIES_DREAMWRECKER = registerTable("entities/dreamwrecker");
    public static final ResourceLocation ENTITIES_DUO = registerTable("entities/duo");
    public static final ResourceLocation ENTITIES_ENT = registerTable("entities/ent");
    public static final ResourceLocation ENTITIES_FAKE_VHRAAK = registerTable("entities/fake_vhraak");
    public static final ResourceLocation ENTITIES_GALROID = registerTable("entities/galroid");
    public static final ResourceLocation ENTITIES_GORGOSION = registerTable("entities/gorgosion");
    public static final ResourceLocation ENTITIES_HELIO = registerTable("entities/helio");
    public static final ResourceLocation ENTITIES_HIVE_SOLDIER = registerTable("entities/hive_soldier");
    public static final ResourceLocation ENTITIES_HOVER_STINGER = registerTable("entities/hover_stinger");
    public static final ResourceLocation ENTITIES_KAZROTIC = registerTable("entities/kazrotic");
    public static final ResourceLocation ENTITIES_LHEIVA = registerTable("entities/lheiva");
    public static final ResourceLocation ENTITIES_LORGA = registerTable("entities/lorga");
    public static final ResourceLocation ENTITIES_LORGAFLIGHT = registerTable("entities/lorgaflight");
    public static final ResourceLocation ENTITIES_MANDRAGORA = registerTable("entities/mandragora");
    public static final ResourceLocation ENTITIES_SHADAHIER = registerTable("entities/shadahier");
    public static final ResourceLocation ENTITIES_TOCAXIN = registerTable("entities/tocaxin");
    public static final ResourceLocation ENTITIES_TWINS = registerTable("entities/twins");
    public static final ResourceLocation ENTITIES_VERMENOUS = registerTable("entities/vermenous");
    public static final ResourceLocation ENTITIES_VHRAAK = registerTable("entities/vhraak");
    public static final ResourceLocation ENTITIES_ZONE = registerTable("entities/zone");
    public static final ResourceLocation ENTITIES_ZORAGON = registerTable("entities/zoragon");

    public static final ResourceLocation ENTITIES_ANCIENT_ENTITY = registerTable("entities/ancient_entity");
    public static final ResourceLocation ENTITIES_AYERACO_BLUE = registerTable("entities/ayeraco");
    public static final ResourceLocation ENTITIES_DENSOS = registerTable("entities/densos");
    public static final ResourceLocation ENTITIES_DRAMIX = registerTable("entities/dramix");
    public static final ResourceLocation ENTITIES_ETERNAL_ARCHER = registerTable("entities/eternal_archer");
    public static final ResourceLocation ENTITIES_EXPERIENCED_CORI = registerTable("entities/experienced_cori");
    public static final ResourceLocation ENTITIES_HIVE_QUEEN = registerTable("entities/hive_queen");
    public static final ResourceLocation ENTITIES_KAROS = registerTable("entities/karos");
    public static final ResourceLocation ENTITIES_KAROT = registerTable("entities/karot");
    public static final ResourceLocation ENTITIES_KING_OF_SCORCHERS = registerTable("entities/king_of_scorchers");
    public static final ResourceLocation ENTITIES_LADY_LUNA = registerTable("entities/lady_luna");
    public static final ResourceLocation ENTITIES_PARASECTA = registerTable("entities/parasecta");
    public static final ResourceLocation ENTITIES_QUADRO = registerTable("entities/quadro");
    public static final ResourceLocation ENTITIES_RAGLOK = registerTable("entities/raglok");
    public static final ResourceLocation ENTITIES_REYVOR = registerTable("entities/reyvor");
    public static final ResourceLocation ENTITIES_SOUL_FIEND = registerTable("entities/soul_fiend");
    public static final ResourceLocation ENTITIES_SUNSTORM = registerTable("entities/sunstorm");
    public static final ResourceLocation ENTITIES_TERMASECT = registerTable("entities/termasect");
    public static final ResourceLocation ENTITIES_THE_WATCHER = registerTable("entities/the_watcher");
    public static final ResourceLocation ENTITIES_TWILIGHT_DEMON = registerTable("entities/twilight_demon");
    public static final ResourceLocation ENTITIES_VAMACHERON = registerTable("entities/vamacheron");
    public static final ResourceLocation ENTITIES_WRECK = registerTable("entities/wreck");

    //arcana
    public static final ResourceLocation CAPTAIN_MERIK = registerTable("entities/captain_merik");
    public static final ResourceLocation DATTICON = registerTable("entities/datticon");
    public static final ResourceLocation DEATHCRYX = registerTable("entities/deathcryx");
    public static final ResourceLocation DEATH_HOUND = registerTable("entities/death_hound");
    public static final ResourceLocation DUNGEON_CONSTRUCTOR = registerTable("entities/dungeon_constructor");
    public static final ResourceLocation DUNGEON_DEMON = registerTable("entities/dungeon_demon");
    public static final ResourceLocation DUNGEON_PRISONER = registerTable("entities/dungeon_prisoner");
    public static final ResourceLocation FYRACRYX = registerTable("entities/ryracryx");
    public static final ResourceLocation GOLEM_OF_REJUVENATION = registerTable("entities/golem_of_rejuvenation");
    public static final ResourceLocation KAZARI = registerTable("entities/kazari");
    public static final ResourceLocation LEORNA = registerTable("entities/leorna");
    public static final ResourceLocation LIVING_STATUE = registerTable("entities/living_statue");
    public static final ResourceLocation LORD_VATTICUS = registerTable("entities/lord_vatticus");
    public static final ResourceLocation PARATIKU = registerTable("entities/paratiku");
    public static final ResourceLocation RAZORBACK = registerTable("entities/razorback");
    public static final ResourceLocation ROAMER = registerTable("entities/roamer");
    public static final ResourceLocation SEIMER = registerTable("entities/seimer");
    public static final ResourceLocation WAR_GENERAL = registerTable("entities/war_general");
    public static final ResourceLocation WRAITH = registerTable("entities/wraith");
    public static final ResourceLocation ZELUS = registerTable("entities/zelus");

    private static ResourceLocation registerTable(String id) {
        return register(new ResourceLocation(DivineRPG.MODID, id));
    }

    private static ResourceLocation register(ResourceLocation id) {
        if (LOOT_TABLES.add(id)) {
            return id;
        } else {
            throw new IllegalArgumentException(id + " is already a registered built-in loot table");
        }
    }

    public static Set<ResourceLocation> all() {
        return READ_ONLY_LOOT_TABLES;
    }
}