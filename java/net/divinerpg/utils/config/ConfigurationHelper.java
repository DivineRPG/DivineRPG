package net.divinerpg.utils.config;

import java.io.File;
import java.util.HashMap;

import net.minecraftforge.common.config.Configuration;

public class ConfigurationHelper {

    public static Configuration             cfg;
    private static HashMap<String, Integer> configMap = new HashMap<String, Integer>();

    public static void init() {
        cfg = new Configuration(new File("./DivineRPG/DivineRPG.cfg"));

        cfg.load();
        dimensionInit();
        miscInit();
        cfg.save();
    }

    public static boolean keepLoadingEden, keepLoadingWildwood, keepLoadingApalachia, keepLoadingSkythern, keepLoadingMortum, keepLoadingVethea, keepLoadingArcana, keepLoadingIceika;
    public static boolean canShowDeathChat, canShowVanillaDeathChat, canShowIngameVersion, showItemsBetter, canShowWelcomeChat;

    public static int     eden, wildwood, apalachia, skythern, mortum, vethea, arcana, iceika;
    public static int     edenBiome, wildwoodBiome, apalachiaBiome, skythernBiome, mortumBiome, vetheaBiome, arcanaBiome, iceikaBiome;
    public static int     arcanaX, arcanaY;

    public static void dimensionInit() {
        edenBiome = cfg.get("Dimension", "Eden biome ID", 40).getInt();
        wildwoodBiome = cfg.get("Dimension", "The Wildwood biome ID", 41).getInt();
        apalachiaBiome = cfg.get("Dimension", "Apalachia biome ID", 42).getInt();
        skythernBiome = cfg.get("Dimension", "Skythern biome ID", 43).getInt();
        mortumBiome = cfg.get("Dimension", "Mortum biome ID", 44).getInt();
        vetheaBiome = cfg.get("Dimension", "Vethea biome ID", 45).getInt();
        arcanaBiome = cfg.get("Dimension", "Arcana biome ID", 46).getInt();
        iceikaBiome = cfg.get("Dimension", "Iceika biome ID", 47).getInt();

        eden = cfg.get("Dimension", "Eden ID", 10).getInt();
        wildwood = cfg.get("Dimension", "The Wildwood ID", 11).getInt();
        apalachia = cfg.get("Dimension", "Apalcha ID", 12).getInt();
        skythern = cfg.get("Dimension", "Skythern ID", 13).getInt();
        mortum = cfg.get("Dimension", "Mortum ID", 14).getInt();
        vethea = cfg.get("Dimension", "Vethea ID", 15).getInt();
        arcana = cfg.get("Dimension", "Arcana ID", 16).getInt();
        iceika = cfg.get("Dimension", "Iceika ID", 17).getInt();

        keepLoadingEden = cfg.get("Dimension", "Keep loading Eden", true).getBoolean(true);
        keepLoadingWildwood = cfg.get("Dimension", "Keep loading The Wildwood", true).getBoolean(true);
        keepLoadingApalachia = cfg.get("Dimension", "Keep loading Apalachia", true).getBoolean(true);
        keepLoadingSkythern = cfg.get("Dimension", "Keep loading Skythern", true).getBoolean(true);
        keepLoadingMortum = cfg.get("Dimension", "Keep loading Mortum", true).getBoolean(true);
        keepLoadingVethea = cfg.get("Dimension", "Keep loading Vethea", true).getBoolean(true);
        keepLoadingArcana = cfg.get("Dimension", "Keep loading Arcana", true).getBoolean(true);
        keepLoadingIceika = cfg.get("Dimension", "Keep loading Iceika", true).getBoolean(true);
    }

    public static void miscInit() {
        canShowDeathChat = cfg.get("GUI", "Can show death chat for DivineRPG mobs", true).getBoolean(true);
        canShowVanillaDeathChat = cfg.get("GUI", "Can show death chat for vanilla mobs", false).getBoolean(true);
        canShowIngameVersion = cfg.get("GUI", "Can show in-game version text in top left corner", true).getBoolean(true);
        showItemsBetter = cfg.get("Items", "Can show held items to look better in full 3D when held", false).getBoolean(false);
        canShowWelcomeChat = cfg.get("GUI", "Can show welcome chat upon login", true).getBoolean(true);
        arcanaX = 111;
        arcanaY = 18;
    }

    public static int getConfig(String name) {
        return configMap.get(name);
    }
}
