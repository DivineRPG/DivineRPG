package net.divinerpg.utils.config;

import java.io.File;
import java.util.HashMap;

import net.minecraftforge.common.config.Configuration;

public class ConfigurationHelper {

    public static Configuration             cfg;
    private static HashMap<String, Integer> configMap = new HashMap<String, Integer>();

    public static void init(File dir) {
        cfg = new Configuration(new File(dir, "DivineRPG.cfg"));

        cfg.load();
        dimensionInit();
        dataWatcherInit();
        miscInit();
        cfg.save();
    }

    public static boolean keepLoadingEden, keepLoadingWildwood, keepLoadingApalachia, keepLoadingSkythern, keepLoadingMortum, keepLoadingVethea, keepLoadingArcana, keepLoadingIceika;
    public static boolean canShowDeathChat, canShowOverlay, canShowVanillaDeathChat;

    public static int     eden, wildwood, apalachia, skythern, mortum, vethea, arcana, iceika;
    public static int     edenBiome, wildwoodBiome, apalachiaBiome, skythernBiome, mortumBiome, vetheaBiome, arcanaBiome, iceikaBiome;
    public static int     arcanaX, arcanaY;
    public static int	  barValue, barRegen;

    public static void dimensionInit() {
        edenBiome = cfg.get("Dimension", "Eden biome ID", 100).getInt();
        wildwoodBiome = cfg.get("Dimension", "Wildwood biome ID", 101).getInt();
        apalachiaBiome = cfg.get("Dimension", "Apalachia biome ID", 102).getInt();
        skythernBiome = cfg.get("Dimension", "Skythern biome ID", 103).getInt();
        mortumBiome = cfg.get("Dimension", "Mortum biome ID", 104).getInt();
        vetheaBiome = cfg.get("Dimension", "Vethea biome ID", 105).getInt();
        arcanaBiome = cfg.get("Dimension", "Arcana biome ID", 106).getInt();
        iceikaBiome = cfg.get("Dimension", "Iceika biome ID", 107).getInt();

        eden = cfg.get("Dimension", "Eden dimension ID", 50).getInt();
        wildwood = cfg.get("Dimension", "Wildwood dimension ID", 51).getInt();
        apalachia = cfg.get("Dimension", "Apalachia dimension ID", 52).getInt();
        skythern = cfg.get("Dimension", "Skythern dimension ID", 53).getInt();
        mortum = cfg.get("Dimension", "Mortum dimension ID", 54).getInt();
        vethea = cfg.get("Dimension", "Vethea dimension ID", 55).getInt();
        arcana = cfg.get("Dimension", "Arcana dimension ID", 56).getInt();
        iceika = cfg.get("Dimension", "Iceika dimension ID", 57).getInt();

        keepLoadingEden = cfg.get("Dimension", "Keep loading Eden", true).getBoolean(true);
        keepLoadingWildwood = cfg.get("Dimension", "Keep loading Wildwood", true).getBoolean(true);
        keepLoadingApalachia = cfg.get("Dimension", "Keep loading Apalachia", true).getBoolean(true);
        keepLoadingSkythern = cfg.get("Dimension", "Keep loading Skythern", true).getBoolean(true);
        keepLoadingMortum = cfg.get("Dimension", "Keep loading Mortum", true).getBoolean(true);
        keepLoadingVethea = cfg.get("Dimension", "Keep loading Vethea", true).getBoolean(true);
        keepLoadingArcana = cfg.get("Dimension", "Keep loading Arcana", true).getBoolean(true);
        keepLoadingIceika = cfg.get("Dimension", "Keep loading Iceika", true).getBoolean(true);
    }
    
    public static void dataWatcherInit() {
    	barValue = cfg.get("Data Watcher", "Arcana Bar Value ID", 25).getInt();
    	barRegen = cfg.get("Data Watcher", "Arcana Bar Regeneration ID", 26).getInt();
    }

    public static void miscInit() {
        canShowDeathChat = cfg.get("GUI", "Can show death messages for DivineRPG mobs", false).getBoolean(true);
        canShowOverlay = cfg.get("GUI", "Can show overlay in top left corner or debug screen", true).getBoolean(true);
        canShowVanillaDeathChat = cfg.get("GUI", "Can show death chat for vanilla mobs", false).getBoolean(true);
        arcanaX = 111;
        arcanaY = 18;
    }

    public static int getConfig(String name) {
        return configMap.get(name);
    }
}
