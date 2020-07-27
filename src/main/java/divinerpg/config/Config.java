package divinerpg.config;

import divinerpg.DivineRPG;
import divinerpg.proxy.CommonProxy;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Configuration options that have not yet been converted to the annotated config system. Includes world gen and mob stats
 */
public class Config {
    public static final Map<ResourceLocation, MobStatInfo> mobStats = new HashMap<>();
    public static final OreInfo realmite = new OreInfo("realmite", 5, 8, 1, 48);
    public static final OreInfo rupee = new OreInfo("rupee", 5, 4, 1, 16);
    public static final OreInfo arlemite = new OreInfo("arlemite", 5, 4, 1, 16);
    public static final OreInfo nether = new OreInfo("netherOres", 10, 4, 1, 256);
    public static final OreInfo twilight = new OreInfo("twilightOres", 10, 4, 15, 100);
    private static final String CATEGORY_GUI = "GUI";
    private static final String CATEGORY_WORLD_GEN = "World Gen";
    public static boolean generateHuts = true;
    public static boolean generateTrees = true;
    public static boolean generateTar = true;

    private static void initGeneralConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_WORLD_GEN, "World gen variables");
        Arrays.asList(arlemite, rupee, realmite, nether, twilight).forEach(oreInfo -> oreInfo.init(cfg, CATEGORY_WORLD_GEN));
        generateHuts = cfg.getBoolean("generateHuts", CATEGORY_WORLD_GEN, true, "Generate livestock merchant huts in the overworld");
        generateTrees = cfg.getBoolean("generateTrees", CATEGORY_WORLD_GEN, true, "Generate divine trees in the overworld");
        generateTar = cfg.getBoolean("generateTar", CATEGORY_WORLD_GEN, true, "Generate tar lakes in the overworld");
    }

    private static void initMobStats(Configuration cfg) {
        Map<ResourceLocation, MobStatInfo> defaultModStates = new LinkedHashMap<ResourceLocation, MobStatInfo>() {{
            put(new ResourceLocation(DivineRPG.MODID, "acid_hag"), new MobStatInfo(25.0, 5.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "advanced_cori"), new MobStatInfo(35.0, 60.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "alicanto"), new MobStatInfo(75.0, 10.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "ancient_entity"), new MobStatInfo(800.0, 12.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "angry_bunny"), new MobStatInfo(60.0, 12.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "apalachia_cadillion"), new MobStatInfo(90.0, 16.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "apalachia_golem"), new MobStatInfo(250.0, 19.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "apalachia_tomo"), new MobStatInfo(115.0, 14.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "arid_warrior"), new MobStatInfo(40.0, 8.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "ayeraco_blue"), new MobStatInfo(600.0, 5.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "ayeraco_green"), new MobStatInfo(600.0, 5.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "ayeraco_purple"), new MobStatInfo(600.0, 5.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "ayeraco_red"), new MobStatInfo(600.0, 5.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "ayeraco_yellow"), new MobStatInfo(600.0, 5.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "basilisk"), new MobStatInfo(500.0, 10.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "behemoth"), new MobStatInfo(180.0, 14.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "biphron"), new MobStatInfo(40.0, 14.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "bohemite"), new MobStatInfo(60.0, 13.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "brown_grizzle"), new MobStatInfo(100.0, 0.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "bunny"), new MobStatInfo(10.0, 1.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "captain_merik"), new MobStatInfo(20.0, 0.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "cave_crawler"), new MobStatInfo(30.0, 7.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "caveclops"), new MobStatInfo(60.0, 8.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "crab"), new MobStatInfo(45.0, 6.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "crypt_keeper"), new MobStatInfo(20.0, 2.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "cyclops"), new MobStatInfo(35.0, 8.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "cymesoid"), new MobStatInfo(25.0, 8.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "datticon"), new MobStatInfo(20.0, 0.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "death_hound"), new MobStatInfo(120.0, 10.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "deathcryx"), new MobStatInfo(6.0, 6.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "demon_of_darkness"), new MobStatInfo(200.0, 21.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "densos"), new MobStatInfo(1000.0, 28.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "desert_crawler"), new MobStatInfo(40.0, 8.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "dissiment"), new MobStatInfo(70.0, 0.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "dramix"), new MobStatInfo(1400.0, 30.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "dreamwrecker"), new MobStatInfo(60.0, 8.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "dungeon_constructor"), new MobStatInfo(100.0, 19.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "dungeon_demon"), new MobStatInfo(85.0, 17.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "dungeon_prisoner"), new MobStatInfo(85.0, 17.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "duo"), new MobStatInfo(20.0, 7.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "eden_cadillion"), new MobStatInfo(75.0, 12.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "eden_tomo"), new MobStatInfo(100.0, 10.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "ehu"), new MobStatInfo(60.0, 6.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "enchanted_archer"), new MobStatInfo(100.0, 12.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "enchanted_warrior"), new MobStatInfo(200.0, 20.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "ender_spider"), new MobStatInfo(40.0, 7.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "ender_triplets"), new MobStatInfo(10.0, 0.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "ender_watcher"), new MobStatInfo(40.0, 7.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "ent"), new MobStatInfo(50.0, 20.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "enthralled_dramcryx"), new MobStatInfo(80.0, 14.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "epiphite"), new MobStatInfo(100.0, 14.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "eternal_archer"), new MobStatInfo(1550.0, 2.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "experienced_cori"), new MobStatInfo(1150.0, 16.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "fake_vhraak"), new MobStatInfo(100.0, 30.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "fractite"), new MobStatInfo(50.0, 0.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "frost"), new MobStatInfo(50.0, 6.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "frost_archer"), new MobStatInfo(40.0, 2.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "frosty"), new MobStatInfo(150.0, 20.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "fyracryx"), new MobStatInfo(60.0, 0.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "galroid"), new MobStatInfo(100.0, 25.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "glacide"), new MobStatInfo(80.0, 12.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "glacon"), new MobStatInfo(60.0, 7.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "golem_of_rejuvenation"), new MobStatInfo(30.0, 0.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "gorgosion"), new MobStatInfo(60.0, 2.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "greenfeet"), new MobStatInfo(200.0, 16.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "hastreus"), new MobStatInfo(80.0, 12.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "helio"), new MobStatInfo(140.0, 40.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "hell_pig"), new MobStatInfo(25.0, 5.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "hell_spider"), new MobStatInfo(50.0, 9.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "herbomancer"), new MobStatInfo(40.0, 5.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "herbomancer_minion"), new MobStatInfo(10.0, 5.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "hive_queen"), new MobStatInfo(1500.0, 20.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "hive_soldier"), new MobStatInfo(20.0, 6.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "hover_stinger"), new MobStatInfo(40.0, 8.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "husk"), new MobStatInfo(80.0, 8.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "jack_o_man"), new MobStatInfo(20.0, 0.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "jungle_bat"), new MobStatInfo(20.0, 5.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "jungle_dramcryx"), new MobStatInfo(40.0, 9.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "jungle_spider"), new MobStatInfo(45.0, 7.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "karos"), new MobStatInfo(4000.0, 20.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "karot"), new MobStatInfo(1250.0, 32.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "kazrotic"), new MobStatInfo(65.0, 2.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "king_crab"), new MobStatInfo(100.0, 9.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "king_of_scorchers"), new MobStatInfo(1100.0, 22.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "kobblin"), new MobStatInfo(35.0, 7.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "lady_luna"), new MobStatInfo(8000.0, 20.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "leorna"), new MobStatInfo(20.0, 0.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "lheiva"), new MobStatInfo(85.0, 19.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "liopleurodon"), new MobStatInfo(150.0, 13.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "livestock_merchant"), new MobStatInfo(20.0, 0.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "living_statue"), new MobStatInfo(60.0, 2.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "lord_vatticus"), new MobStatInfo(20.0, 0.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "lorga"), new MobStatInfo(15.0, 4.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "lorga_flight"), new MobStatInfo(40.0, 2.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "madivel"), new MobStatInfo(150.0, 18.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "mage"), new MobStatInfo(90.0, 5.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "mandragora"), new MobStatInfo(35.0, 4.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "megalith"), new MobStatInfo(350.0, 20.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "miner"), new MobStatInfo(40.0, 7.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "mortum_cadillion"), new MobStatInfo(130.0, 20.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "mysterious_man_layer_1"), new MobStatInfo(20.0, 2.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "mysterious_man_layer_2"), new MobStatInfo(20.0, 2.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "mysterious_man_layer_3"), new MobStatInfo(20.0, 2.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "mystic"), new MobStatInfo(120.0, 10.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "parasecta"), new MobStatInfo(1000.0, 16.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "paratiku"), new MobStatInfo(100.0, 0.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "pumpkin_spider"), new MobStatInfo(50.0, 9.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "quadro"), new MobStatInfo(4000.0, 8.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "raglok"), new MobStatInfo(5000.0, 30.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "rainbour"), new MobStatInfo(100.0, 18.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "razorback"), new MobStatInfo(35.0, 7.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "reyvor"), new MobStatInfo(1000.0, 20.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "roamer"), new MobStatInfo(110.0, 20.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "rollum"), new MobStatInfo(180.0, 5.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "rotatick"), new MobStatInfo(40.0, 8.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "saguaro_worm"), new MobStatInfo(80.0, 6.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "samek"), new MobStatInfo(160.0, 20.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "scorcher"), new MobStatInfo(75.0, 5.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "seimer"), new MobStatInfo(150.0, 6.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "shadahier"), new MobStatInfo(10.0, 6.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "shark"), new MobStatInfo(80.0, 8.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "skythern_archer"), new MobStatInfo(120.0, 14.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "skythern_fiend"), new MobStatInfo(80.0, 22.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "skythern_golem"), new MobStatInfo(300.0, 20.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "smelter"), new MobStatInfo(120.0, 7.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "snapper"), new MobStatInfo(150.0, 4.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "sorcerer"), new MobStatInfo(150.0, 12.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "soul_fiend"), new MobStatInfo(1100.0, 24.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "soul_spider"), new MobStatInfo(35.0, 12.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "soul_stealer"), new MobStatInfo(140.0, 25.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "spellbinder"), new MobStatInfo(95.0, 7.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "stone_golem"), new MobStatInfo(100.0, 5.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "sun_archer"), new MobStatInfo(60.0, 10.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "sunstorm"), new MobStatInfo(1000.0, 12.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "temple_guardian"), new MobStatInfo(20.0, 2.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "termasect"), new MobStatInfo(1050.0, 14.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "termid"), new MobStatInfo(40.0, 4.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "the_eye"), new MobStatInfo(40.0, 12.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "the_grue"), new MobStatInfo(30.0, 13.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "the_hunger"), new MobStatInfo(20.0, 0.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "the_watcher"), new MobStatInfo(950.0, 2.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "tocaxin"), new MobStatInfo(65.0, 10.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "twilight_archer"), new MobStatInfo(140.0, 16.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "twilight_demon"), new MobStatInfo(1600.0, 30.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "twins"), new MobStatInfo(10.0, 2.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "vamacheron"), new MobStatInfo(1350.0, 34.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "verek"), new MobStatInfo(50.0, 18.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "vermenous"), new MobStatInfo(100.0, 13.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "vhraak"), new MobStatInfo(100.0, 30.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "war_general"), new MobStatInfo(20.0, 0.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "weak_cori"), new MobStatInfo(35.0, 30.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "whale"), new MobStatInfo(80.0, 8.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "white_grizzle"), new MobStatInfo(100.0, 9.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "wildfire"), new MobStatInfo(50.0, 8.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "wildwood_cadillion"), new MobStatInfo(85.0, 14.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "wildwood_golem"), new MobStatInfo(200.0, 18.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "wildwood_tomo"), new MobStatInfo(110.0, 12.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "workshop_merchant"), new MobStatInfo(20.0, 0.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "workshop_tinkerer"), new MobStatInfo(20.0, 0.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "wraith"), new MobStatInfo(100.0, 9.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "wreck"), new MobStatInfo(5000.0, 30.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "zelus"), new MobStatInfo(20.0, 0.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "zone"), new MobStatInfo(120.0, 0.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "zoragon"), new MobStatInfo(70.0, 0.0, 0.0));
            put(new ResourceLocation(DivineRPG.MODID, "moon_wolf"), new MobStatInfo(200.0, 1.0, 0.0));
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
