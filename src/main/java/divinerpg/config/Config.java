package divinerpg.config;

import divinerpg.DivineRPG;
import divinerpg.api.Reference;
import divinerpg.proxy.CommonProxy;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import org.apache.logging.log4j.Level;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Config {
    public static final Map<ResourceLocation, MobStatInfo> mobStats = new HashMap<>();
    public static final OreInfo realmite = new OreInfo("realmite", 5, 8, 1, 48);
    public static final OreInfo rupee = new OreInfo("rupee", 5, 4, 1, 16);
    public static final OreInfo arlemite = new OreInfo("arlemite", 5, 4, 1, 16);
    public static final OreInfo nether = new OreInfo("netherOres", 10, 4, 1, 256);
    public static final OreInfo twilight = new OreInfo("twilightOres", 10, 4, 15, 100);
    private static final String CATEGORY_GENERAL = "general";
    private static final String CATEGORY_GUI = "GUI";
    private static final String CATEGORY_WORLD_GEN = "World Gen";
    private static final String CategoryKing = "King armor";
    public static int mobSpawnMultiplier = 5;
    public static boolean isBeaconBase = true;
    public static boolean UpdateChecker = true;
    public static boolean canShowOverlay = true;
    public static boolean debug = false;
    public static int arcanaX, arcanaY;
    public static boolean generateHuts = true;
    public static boolean generateTrees = true;
    public static boolean generateTar = true;

    private static final String CATEGORY_DIMENSION = "Dimension";
    public static int edenDimensionId = 420;
    public static int wildWoodDimensionId = 421;
    public static int apalachiaDimensionId = 422;
    public static int skythernDimensionId = 423;
    public static int mortumDimensionId = 424;
    public static int iceikaDimensionId = 425;
    public static int arcanaDimensionId = 426;
    public static int vetheaDimensionId = 427;

    public static int kingCreationPercentage = 50;
    public static int maxAbsorbedCount = 0;

    private static void initGeneralConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
        cfg.addCustomCategoryComment(CATEGORY_DIMENSION, "Dimension related configuration");
        edenDimensionId = cfg.getInt("edenId", CATEGORY_DIMENSION, 420, 2, 4096, "Eden dimension ID");
        wildWoodDimensionId = cfg.getInt("wildWoodId", CATEGORY_DIMENSION, 421, 2, 4096, "Wild Wood dimension ID");
        apalachiaDimensionId = cfg.getInt("apalachiaId", CATEGORY_DIMENSION, 422, 2, 4096, "Apalachia dimension ID");
        skythernDimensionId = cfg.getInt("skythernId", CATEGORY_DIMENSION, 423, 2, 4096, "Skythern dimension ID");
        mortumDimensionId = cfg.getInt("mortumId", CATEGORY_DIMENSION, 424, 2, 4096, "Mortum dimension ID");
        iceikaDimensionId = cfg.getInt("iceikaId", CATEGORY_DIMENSION, 425, 2, 4096, "Iceika dimension ID");
        arcanaDimensionId = cfg.getInt("arcanaId", CATEGORY_DIMENSION, 426, 2, 4096, "Arcana dimension ID");
        vetheaDimensionId = cfg.getInt("vetheaId", CATEGORY_DIMENSION, 427, 2, 4096, "Vethea dimension ID");
        isBeaconBase = cfg.getBoolean("beaconBase", CATEGORY_GENERAL, isBeaconBase,
                "Set to false to make DivineRPG blocks non-beacon objects");
        UpdateChecker = cfg.getBoolean("UpdateChecker", CATEGORY_GENERAL, UpdateChecker,
                "Set to false to disable the update checker");
        canShowOverlay = cfg.getBoolean("canShowOverlay", CATEGORY_GENERAL, canShowOverlay,
                "Set to false to disable the overlay");
        debug = cfg.getBoolean("debug mode", CATEGORY_GENERAL, debug,
                "Dont enable this unless instructed by a developer");
        mobSpawnMultiplier = cfg.getInt("Mob Spawn Multiplier", CATEGORY_GENERAL, 5, 1, 32,
                "If you are experiencing lag i would recommend lowering this number");
        cfg.addCustomCategoryComment(CATEGORY_WORLD_GEN, "World gen variables");
        Arrays.asList(arlemite, rupee, realmite, nether, twilight).forEach(oreInfo -> oreInfo.init(cfg, CATEGORY_WORLD_GEN));

        generateHuts = cfg.getBoolean("generateHuts", CATEGORY_WORLD_GEN, generateHuts, "Generate livestock merchant huts in the overworld?");
        generateTrees = cfg.getBoolean("generateTrees", CATEGORY_WORLD_GEN, generateTrees, "Generate divine trees in the overworld?");
        generateTar = cfg.getBoolean("generateTar", CATEGORY_WORLD_GEN, generateTar, "Generate tar lakes in the overworld?");
        cfg.addCustomCategoryComment(CATEGORY_GUI, "GUI Config options");
        arcanaX = cfg.getInt("arcanaX", CATEGORY_GUI, 111, 1, 255, "Arcana gui width");
        arcanaY = cfg.getInt("arcanaY", CATEGORY_GUI, 18, 1, 255, "Arcana gui height");

        cfg.addCustomCategoryComment(CategoryKing, "King armor settings");
        kingCreationPercentage = cfg.getInt("kingArmorCreatePercantage", CategoryKing, 50, 10, 70,
                "Peracantage of all existing super-powers set neede to create king armor");
        maxAbsorbedCount = cfg.getInt("kingArmorMaxAbsorb", CategoryKing, 0, 0, 100,
                "How much items king armor can accept. Set 0 to remove restriction");
    }

    private static void initMobStats(Configuration cfg) {
        Map<ResourceLocation, MobStatInfo> defaultModStates = new LinkedHashMap<ResourceLocation, MobStatInfo>() {{
            put(new ResourceLocation(Reference.MODID, "moon_wolf"), new MobStatInfo(200.0, 1.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "saguaro_worm"), new MobStatInfo(80.0, 4.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "dissiment"), new MobStatInfo(70.0, 0.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "skythern_golem"), new MobStatInfo(300.0, 18.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "densos"), new MobStatInfo(1000.0, 28.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "wreck"), new MobStatInfo(1024.0, 30.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "glacide"), new MobStatInfo(80.0, 12.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "vhraak"), new MobStatInfo(100.0, 30.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "duo"), new MobStatInfo(20.0, 7.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "raglok"), new MobStatInfo(5000.0, 30.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "death_hound"), new MobStatInfo(120.0, 10.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "sorcerer"), new MobStatInfo(150.0, 12.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "fractite"), new MobStatInfo(50.0, 0.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "advanced_cori"), new MobStatInfo(35.0, 100.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "glacon"), new MobStatInfo(60.0, 7.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "wildwood_cadillion"), new MobStatInfo(85.0, 12.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "reyvor"), new MobStatInfo(1000.0, 20.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "mystic"), new MobStatInfo(120.0, 10.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "apalachia_cadillion"), new MobStatInfo(90.0, 12.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "ayeraco_green"), new MobStatInfo(600.0, 5.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "temple_guardian"), new MobStatInfo(20.0, 2.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "enchanted_warrior"), new MobStatInfo(200.0, 14.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "workshop_tinkerer"), new MobStatInfo(20.0, 0.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "wildwood_golem"), new MobStatInfo(200.0, 16.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "greenfeet"), new MobStatInfo(200.0, 14.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "weak_cori"), new MobStatInfo(35.0, 30.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "epiphite"), new MobStatInfo(100.0, 14.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "ent"), new MobStatInfo(50.0, 20.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "husk"), new MobStatInfo(80.0, 8.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "war_general"), new MobStatInfo(20.0, 0.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "datticon"), new MobStatInfo(20.0, 0.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "skythern_archer"), new MobStatInfo(120.0, 14.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "the_eye"), new MobStatInfo(40.0, 10.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "gorgosion"), new MobStatInfo(60.0, 2.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "golem_of_rejuvenation"), new MobStatInfo(30.0, 0.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "experienced_cori"), new MobStatInfo(1150.0, 16.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "crypt_keeper"), new MobStatInfo(20.0, 2.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "twilight_archer"), new MobStatInfo(140.0, 16.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "liopleurodon"), new MobStatInfo(150.0, 13.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "zelus"), new MobStatInfo(20.0, 0.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "miner"), new MobStatInfo(40.0, 5.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "soul_spider"), new MobStatInfo(35.0, 12.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "zoragon"), new MobStatInfo(70.0, 0.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "parasecta"), new MobStatInfo(1000.0, 16.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "eternal_archer"), new MobStatInfo(1550.0, 2.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "soul_fiend"), new MobStatInfo(1100.0, 24.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "biphron"), new MobStatInfo(40.0, 14.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "fake_vhraak"), new MobStatInfo(100.0, 30.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "ender_triplets"), new MobStatInfo(10.0, 0.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "wildwood_tomo"), new MobStatInfo(110.0, 10.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "basilisk"), new MobStatInfo(500.0, 6.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "cymesoid"), new MobStatInfo(25.0, 8.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "kazrotic"), new MobStatInfo(65.0, 2.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "the_hunger"), new MobStatInfo(20.0, 0.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "enthralled_dramcryx"), new MobStatInfo(80.0, 7.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "ayeraco_red"), new MobStatInfo(600.0, 5.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "workshop_merchant"), new MobStatInfo(20.0, 0.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "razorback"), new MobStatInfo(35.0, 7.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "captain_merik"), new MobStatInfo(20.0, 0.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "lorga"), new MobStatInfo(15.0, 4.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "snapper"), new MobStatInfo(150.0, 4.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "mortum_cadillion"), new MobStatInfo(130.0, 20.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "king_crab"), new MobStatInfo(100.0, 9.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "ender_watcher"), new MobStatInfo(40.0, 7.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "rotatick"), new MobStatInfo(40.0, 6.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "frosty"), new MobStatInfo(150.0, 20.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "alicanto"), new MobStatInfo(75.0, 10.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "desert_crawler"), new MobStatInfo(40.0, 6.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "scorcher"), new MobStatInfo(75.0, 5.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "shadahier"), new MobStatInfo(10.0, 6.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "ayeraco_blue"), new MobStatInfo(600.0, 5.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "ender_spider"), new MobStatInfo(40.0, 7.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "frost"), new MobStatInfo(50.0, 6.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "dungeon_prisoner"), new MobStatInfo(85.0, 17.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "rollum"), new MobStatInfo(180.0, 5.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "ancient_entity"), new MobStatInfo(800.0, 12.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "jungle_bat"), new MobStatInfo(20.0, 5.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "arid_warrior"), new MobStatInfo(40.0, 8.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "jungle_spider"), new MobStatInfo(45.0, 7.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "fyracryx"), new MobStatInfo(60.0, 0.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "kobblin"), new MobStatInfo(35.0, 7.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "eden_tomo"), new MobStatInfo(100.0, 8.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "mage"), new MobStatInfo(90.0, 5.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "ancient_king"), new MobStatInfo(3200.0, 80.0, 21.0));
            put(new ResourceLocation(Reference.MODID, "ayeraco_yellow"), new MobStatInfo(600.0, 5.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "helio"), new MobStatInfo(140.0, 40.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "hive_queen"), new MobStatInfo(1500.0, 20.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "demon_of_darkness"), new MobStatInfo(200.0, 17.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "dungeon_demon"), new MobStatInfo(85.0, 17.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "stone_golem"), new MobStatInfo(100.0, 5.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "spellbinder"), new MobStatInfo(95.0, 7.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "king_of_scorchers"), new MobStatInfo(1100.0, 22.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "cave_crawler"), new MobStatInfo(30.0, 4.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "hastreus"), new MobStatInfo(80.0, 12.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "galroid"), new MobStatInfo(100.0, 25.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "twilight_demon"), new MobStatInfo(1600.0, 30.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "crab"), new MobStatInfo(45.0, 6.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "sunstorm"), new MobStatInfo(1000.0, 12.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "lheiva"), new MobStatInfo(85.0, 19.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "tocaxin"), new MobStatInfo(65.0, 10.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "apalachia_tomo"), new MobStatInfo(115.0, 10.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "pumpkin_spider"), new MobStatInfo(50.0, 7.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "mandragora"), new MobStatInfo(35.0, 4.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "vermenous"), new MobStatInfo(100.0, 13.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "karos"), new MobStatInfo(4000.0, 20.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "karot"), new MobStatInfo(1250.0, 32.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "wraith"), new MobStatInfo(100.0, 9.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "lorga_flight"), new MobStatInfo(40.0, 2.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "paratiku"), new MobStatInfo(100.0, 0.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "lord_vatticus"), new MobStatInfo(20.0, 0.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "hell_spider"), new MobStatInfo(50.0, 9.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "white_grizzle"), new MobStatInfo(100.0, 9.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "shark"), new MobStatInfo(80.0, 8.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "deathcryx"), new MobStatInfo(6.0, 6.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "leorna"), new MobStatInfo(20.0, 0.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "roamer"), new MobStatInfo(110.0, 20.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "whale"), new MobStatInfo(80.0, 8.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "eden_cadillion"), new MobStatInfo(75.0, 10.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "zone"), new MobStatInfo(120.0, 0.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "living_statue"), new MobStatInfo(60.0, 2.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "dramix"), new MobStatInfo(1400.0, 30.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "the_watcher"), new MobStatInfo(950.0, 2.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "cyclops"), new MobStatInfo(35.0, 5.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "rainbour"), new MobStatInfo(100.0, 18.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "ayeraco_purple"), new MobStatInfo(600.0, 5.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "smelter"), new MobStatInfo(120.0, 7.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "termid"), new MobStatInfo(40.0, 4.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "dreamwrecker"), new MobStatInfo(60.0, 8.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "bohemite"), new MobStatInfo(60.0, 13.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "livestock_merchant"), new MobStatInfo(20.0, 0.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "behemoth"), new MobStatInfo(180.0, 9.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "lady_luna"), new MobStatInfo(8000.0, 20.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "verek"), new MobStatInfo(50.0, 12.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "quadro"), new MobStatInfo(4000.0, 8.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "jungle_dramcryx"), new MobStatInfo(40.0, 7.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "angry_bunny"), new MobStatInfo(60.0, 12.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "hover_stinger"), new MobStatInfo(40.0, 8.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "soul_stealer"), new MobStatInfo(140.0, 20.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "mysterious_man_layer_1"), new MobStatInfo(20.0, 2.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "enchanted_archer"), new MobStatInfo(100.0, 12.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "mysterious_man_layer_3"), new MobStatInfo(20.0, 2.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "hive_soldier"), new MobStatInfo(20.0, 6.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "mysterious_man_layer_2"), new MobStatInfo(20.0, 2.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "acid_hag"), new MobStatInfo(25.0, 5.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "frost_archer"), new MobStatInfo(40.0, 2.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "sun_archer"), new MobStatInfo(60.0, 9.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "brown_grizzle"), new MobStatInfo(100.0, 0.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "hell_pig"), new MobStatInfo(25.0, 5.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "samek"), new MobStatInfo(160.0, 20.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "herbomancer"), new MobStatInfo(40.0, 5.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "vamacheron"), new MobStatInfo(1350.0, 34.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "the_grue"), new MobStatInfo(30.0, 10.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "wildfire"), new MobStatInfo(50.0, 8.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "skythern_fiend"), new MobStatInfo(80.0, 20.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "ehu"), new MobStatInfo(60.0, 6.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "jack_o_man"), new MobStatInfo(20.0, 0.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "apalachia_golem"), new MobStatInfo(250.0, 16.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "herbomancer_minion"), new MobStatInfo(10.0, 5.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "seimer"), new MobStatInfo(150.0, 6.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "bunny"), new MobStatInfo(10.0, 1.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "termasect"), new MobStatInfo(1050.0, 14.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "caveclops"), new MobStatInfo(60.0, 6.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "madivel"), new MobStatInfo(150.0, 18.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "megalith"), new MobStatInfo(350.0, 20.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "dungeon_constructor"), new MobStatInfo(100.0, 19.0, 0.0));
            put(new ResourceLocation(Reference.MODID, "twins"), new MobStatInfo(10.0, 2.0, 0.0));

        }};

        defaultModStates.forEach((location, mobStatInfo) -> {
            mobStatInfo.initConfig(cfg, location);
            mobStats.put(location, mobStatInfo);
        });
    }

    public static void readConfig() {
        readConfig(CommonProxy.config, Config::initGeneralConfig);
        readConfig(CommonProxy.mobStatsConfig, Config::initMobStats);
    }

    private static void readConfig(Configuration cfg, Consumer<Configuration> initDefault) {
        try {
            cfg.load();
            initDefault.accept(cfg);
        } catch (Exception e1) {
            DivineRPG.logger.log(Level.ERROR, "Problem loading config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    /**
     * Initialize entity attributes from config
     *
     * @param e - entity instance
     * @return
     */
    public static void initEntityAttributes(EntityLivingBase e) {
        if (e == null)
            return;

        ResourceLocation id = EntityList.getKey(e);
        if (id == null)
            return;

        MobStatInfo info = mobStats.get(id);
        if (info == null)
            return;

        info.initEntity(e);
    }

}
