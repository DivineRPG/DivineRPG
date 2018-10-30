package naturix.divinerpg;

import org.apache.logging.log4j.Level;

import naturix.divinerpg.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;

public class Config {

    private static final String CATEGORY_GENERAL = "general";
	public static int edenDimensionId = 2;
	public static int wildWoodDimensionId = 3;
	public static int apalachiaDimensionId = 4;
	public static int skythernDimensionId = 5;
	public static int mortumDimensionId = 6;
	public static int mobSpawnMultiplier = 5;
	public static boolean isBeaconBase = true;
	public static boolean UpdateChecker = true;
	public static boolean canShowOverlay = true;
	public static boolean debug = false;
	
	

    private static final String CATEGORY_ORE = "Ore Gen";
    private static final String CATEGORY_DIMENSION = "Dimension";
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

    private static void initGeneralConfig(Configuration cfg) {
    	cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
    	cfg.addCustomCategoryComment(CATEGORY_DIMENSION, "Dimension related configuration");
        edenDimensionId = cfg.getInt("edenId", CATEGORY_DIMENSION, 2, 2, 4096, "Eden dimension ID");
        wildWoodDimensionId = cfg.getInt("wildWoodId", CATEGORY_DIMENSION, 3, 2, 4096, "Wild Wood dimension ID");
        apalachiaDimensionId = cfg.getInt("apalachiaId", CATEGORY_DIMENSION, 4, 2, 4096, "Apalachia dimension ID");
        skythernDimensionId = cfg.getInt("skythernId", CATEGORY_DIMENSION, 5, 2, 4096, "Skythern dimension ID");
        mortumDimensionId = cfg.getInt("mortumId", CATEGORY_DIMENSION, 6, 2, 4096, "Mortum dimension ID");
        isBeaconBase = cfg.getBoolean("beaconBase", CATEGORY_GENERAL, isBeaconBase, "Set to false to make DivineRPG blocks non-beacon bases");
        UpdateChecker = cfg.getBoolean("UpdateChecker", CATEGORY_GENERAL, UpdateChecker, "Set to false to disable the update checker");
        canShowOverlay = cfg.getBoolean("canShowOverlay", CATEGORY_GENERAL, canShowOverlay, "Set to false to disable the overlay");
        debug = cfg.getBoolean("debug mode", CATEGORY_GENERAL, debug, "Set to true to enable");
        mobSpawnMultiplier = cfg.getInt("Mob Spawn Multiplier", CATEGORY_GENERAL, 5, 1, 32, "If you are experiencing lag i would recommend lowering this number");
        cfg.addCustomCategoryComment(CATEGORY_ORE, "World gen variables");
        realmiteMin  = cfg.getInt("realmiteMin", CATEGORY_ORE, 1, 1, 255, "Choose a number between 1 and 255 to choose the min ore height");
        realmiteMax  = cfg.getInt("realmiteMax", CATEGORY_ORE, 48, 1, 255, "Choose a number between 1 and 255 to choose the max ore height");
        realmiteVein  = cfg.getInt("realmiteTries", CATEGORY_ORE, 4, 1, 255, "Choose a number between 1 and 255 to tweak the vein size");
        realmiteTries  = cfg.getInt("realmiteTries", CATEGORY_ORE, 3, 1, 255, "Choose a number between 1 and 255 to choose the amount of times the ore tries to spawn");
        rupeeMin  = cfg.getInt("rupeeMin", CATEGORY_ORE, 1, 1, 255, "Choose a number between 1 and 255 to choose the min ore height");
        rupeeMax  = cfg.getInt("rupeeMax", CATEGORY_ORE, 16, 1, 255, "Choose a number between 1 and 255 to choose the max ore height");
        rupeeVein  = cfg.getInt("rupeeTries", CATEGORY_ORE, 3, 1, 255, "Choose a number between 1 and 255 to tweak the vein size");
        rupeeTries  = cfg.getInt("rupeeTries", CATEGORY_ORE, 2, 1, 255, "Choose a number between 1 and 255 to choose the amount of times the ore tries to spawn");
        arlemiteMin  = cfg.getInt("arlemiteMin", CATEGORY_ORE, 1, 1, 255, "Choose a number between 1 and 255 to choose the min ore height");
        arlemiteMax  = cfg.getInt("arlemiteMax", CATEGORY_ORE, 16, 1, 255, "Choose a number between 1 and 255 to choose the max ore height");
        arlemiteVein  = cfg.getInt("arlemiteTries", CATEGORY_ORE, 3, 1, 255, "Choose a number between 1 and 255 to tweak the vein size");
        arlemiteTries  = cfg.getInt("arlemiteTries", CATEGORY_ORE, 2, 1, 255, "Choose a number between 1 and 255 to choose the amount of times the ore tries to spawn");
        
    
    
    }
}
