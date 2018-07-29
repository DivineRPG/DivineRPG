package naturix.divinerpg.utils;

import org.apache.logging.log4j.Level;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;

public class Config {

    private static final String CATEGORY_GENERAL = "general";
	public static int dimensionId = 0;
	public static boolean isBeaconBase = true;
	public static boolean UpdateChecker = true;
	public static boolean canShowOverlay = true;
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
        dimensionId = cfg.getInt("edenId", CATEGORY_GENERAL, 2, 2, 4096, "Eden dimension ID");
        isBeaconBase = cfg.getBoolean("beaconBase", CATEGORY_GENERAL, isBeaconBase, "Set to false to make DivineRPG blocks non-beacon bases");
        UpdateChecker = cfg.getBoolean("UpdateChecker", CATEGORY_GENERAL, UpdateChecker, "Set to false to disable the update checker");
        canShowOverlay = cfg.getBoolean("canShowOverlay", CATEGORY_GENERAL, canShowOverlay, "Set to false to disable the overlay");
        
    }

}
