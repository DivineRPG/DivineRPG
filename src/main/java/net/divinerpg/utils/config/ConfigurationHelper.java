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
        miscInit();
        cfg.save();
    }

    public static boolean keepLoadingEden, keepLoadingWildwood, keepLoadingApalachia, keepLoadingSkythern, keepLoadingMortum, keepLoadingVethea, keepLoadingArcana, keepLoadingIceika;
    public static boolean canShowOverlay;

    public static int     eden, wildwood, apalachia, skythern, mortum, vethea, arcana, iceika;
    public static int     edenBiome, wildwoodBiome, apalachiaBiome, skythernBiome, mortumBiome, vetheaBiome, arcanaBiome, iceikaBiome;
    public static int     arcanaX, arcanaY;

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

        keepLoadingEden = cfg.get("Dimension", "Keep loading Eden", false).getBoolean(true);
        keepLoadingWildwood = cfg.get("Dimension", "Keep loading The Wildwood", false).getBoolean(true);
        keepLoadingApalachia = cfg.get("Dimension", "Keep loading Apalachia", false).getBoolean(true);
        keepLoadingSkythern = cfg.get("Dimension", "Keep loading Skythern", false).getBoolean(true);
        keepLoadingMortum = cfg.get("Dimension", "Keep loading Mortum", false).getBoolean(true);
        keepLoadingVethea = cfg.get("Dimension", "Keep loading Vethea", false).getBoolean(true);
        keepLoadingArcana = cfg.get("Dimension", "Keep loading Arcana", false).getBoolean(true);
        keepLoadingIceika = cfg.get("Dimension", "Keep loading Iceika", false).getBoolean(true);
    }

    public static void miscInit() {
        canShowOverlay = cfg.get("GUI", "Can show overlay in top left corner or debug screen", true).getBoolean(true);
        arcanaX = cfg.get("GUI", "Arcana Bar X", 111).getInt();
        arcanaY = cfg.get("GUI", "Arcana Bar Y", 18).getInt();
    }

    public static int getConfig(String name) {
        return configMap.get(name);
    }
}
