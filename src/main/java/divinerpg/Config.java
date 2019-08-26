package divinerpg;

import org.apache.logging.log4j.Level;

import divinerpg.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;

public class Config {

	private static final String CATEGORY_GENERAL = "general";
	public static int mobSpawnMultiplier = 5;
	public static boolean isBeaconBase = true;
	public static boolean UpdateChecker = true;
	public static boolean canShowOverlay = true;
	public static boolean debug = false;
	public static boolean genJSON = false;

	private static final String CATEGORY_GUI = "GUI";
	public static int arcanaX, arcanaY;

	private static final String CATEGORY_WORLD_GEN = "World Gen";
	public static int realmiteMin = 1;
	public static int realmiteMax = 48;
	public static int realmiteVein = 4;
	public static int realmiteTries = 3;
	public static int rupeeMin = 1;
	public static int rupeeMax = 16;
	public static int rupeeVein = 4;
	public static int rupeeTries = 2;
	public static int arlemiteMin = 1;
	public static int arlemiteMax = 16;
	public static int arlemiteVein = 4;
	public static int arlemiteTries = 2;
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
		realmiteMin = cfg.getInt("realmiteMin", CATEGORY_WORLD_GEN, 1, 1, 255,
		        "Choose a number between 1 and 255 to choose the min ore height");
		realmiteMax = cfg.getInt("realmiteMax", CATEGORY_WORLD_GEN, 48, 1, 255,
		        "Choose a number between 1 and 255 to choose the max ore height");
		realmiteVein = cfg.getInt("realmiteTries", CATEGORY_WORLD_GEN, 4, 1, 255,
		        "Choose a number between 1 and 255 to tweak the vein size");
		realmiteTries = cfg.getInt("realmiteTries", CATEGORY_WORLD_GEN, 3, 1, 255,
		        "Choose a number between 1 and 255 to choose the amount of times the ore tries to spawn");
		rupeeMin = cfg.getInt("rupeeMin", CATEGORY_WORLD_GEN, 1, 1, 255,
		        "Choose a number between 1 and 255 to choose the min ore height");
		rupeeMax = cfg.getInt("rupeeMax", CATEGORY_WORLD_GEN, 16, 1, 255,
		        "Choose a number between 1 and 255 to choose the max ore height");
		rupeeVein = cfg.getInt("rupeeTries", CATEGORY_WORLD_GEN, 3, 1, 255,
		        "Choose a number between 1 and 255 to tweak the vein size");
		rupeeTries = cfg.getInt("rupeeTries", CATEGORY_WORLD_GEN, 2, 1, 255,
		        "Choose a number between 1 and 255 to choose the amount of times the ore tries to spawn");
		arlemiteMin = cfg.getInt("arlemiteMin", CATEGORY_WORLD_GEN, 1, 1, 255,
		        "Choose a number between 1 and 255 to choose the min ore height");
		arlemiteMax = cfg.getInt("arlemiteMax", CATEGORY_WORLD_GEN, 16, 1, 255,
		        "Choose a number between 1 and 255 to choose the max ore height");
		arlemiteVein = cfg.getInt("arlemiteTries", CATEGORY_WORLD_GEN, 3, 1, 255,
		        "Choose a number between 1 and 255 to tweak the vein size");
		arlemiteTries = cfg.getInt("arlemiteTries", CATEGORY_WORLD_GEN, 2, 1, 255,
		        "Choose a number between 1 and 255 to choose the amount of times the ore tries to spawn");
        generateHuts = cfg.getBoolean("generateHuts", CATEGORY_WORLD_GEN, generateHuts, "Generate livestock merchant huts in the overworld?");
        generateTrees = cfg.getBoolean("generateTrees", CATEGORY_WORLD_GEN, generateTrees, "Generate divine trees in the overworld?");
        generateTar = cfg.getBoolean("generateTar", CATEGORY_WORLD_GEN, generateTar, "Generate tar lakes in the overworld?");
		cfg.addCustomCategoryComment(CATEGORY_GUI, "GUI Config options");
		arcanaX = cfg.getInt("arcanaX", CATEGORY_GUI, 111, 1, 255, "Arcana gui width");
		arcanaY = cfg.getInt("arcanaY", CATEGORY_GUI, 18, 1, 255, "Arcana gui height");

		genJSON = cfg.getBoolean("Generate JSON", CATEGORY_GENERAL, genJSON,
		        "Enable the generation of JSON files (blockstates, models and recipes)");
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
