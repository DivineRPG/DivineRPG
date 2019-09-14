package divinerpg.config;

import divinerpg.DivineRPG;
import divinerpg.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

import java.util.Arrays;

public class Config {

    public static final OreInfo realmite = new OreInfo("realmite", 3, 4, 1, 48);
    public static final OreInfo rupee = new OreInfo("rupee", 2, 2, 1, 16);
    public static final OreInfo arlemite = new OreInfo("arlemite", 2, 2, 1, 16);
    public static final OreInfo nether = new OreInfo("netherOres", 5, 4, 1, 256);
    public static final OreInfo twilight = new OreInfo("twilightOres", 5, 4, 15, 100);
    private static final String CATEGORY_GENERAL = "general";
    private static final String CATEGORY_GUI = "GUI";
    private static final String CATEGORY_WORLD_GEN = "World Gen";
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
    public static int iceikaDimensionId = 7;
    public static int arcanaDimensionId = 426;

    private static void initGeneralConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
        cfg.addCustomCategoryComment(CATEGORY_DIMENSION, "Dimension related configuration");
        edenDimensionId = cfg.getInt("edenId", CATEGORY_DIMENSION, 420, 2, 4096, "Eden dimension ID");
        wildWoodDimensionId = cfg.getInt("wildWoodId", CATEGORY_DIMENSION, 421, 2, 4096, "Wild Wood dimension ID");
        apalachiaDimensionId = cfg.getInt("apalachiaId", CATEGORY_DIMENSION, 422, 2, 4096, "Apalachia dimension ID");
        skythernDimensionId = cfg.getInt("skythernId", CATEGORY_DIMENSION, 423, 2, 4096, "Skythern dimension ID");
        mortumDimensionId = cfg.getInt("mortumId", CATEGORY_DIMENSION, 424, 2, 4096, "Mortum dimension ID");
        iceikaDimensionId = cfg.getInt("iceikaId", CATEGORY_DIMENSION, 7, 2, 4096, "Iceika dimension ID");
        arcanaDimensionId = cfg.getInt("arcanaId", CATEGORY_DIMENSION, 426, 2, 4096, "Arcana dimension ID");
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
    }

    public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            initGeneralConfig(cfg);
        } catch (Exception e1) {
            DivineRPG.logger.log(Level.ERROR, "Problem loading config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }
}
