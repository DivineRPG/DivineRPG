package divinerpg.config;

import com.electronwill.nightconfig.core.file.*;
import com.electronwill.nightconfig.core.io.*;
import net.minecraftforge.common.*;
import net.minecraftforge.fml.common.*;

import java.nio.file.*;

@Mod.EventBusSubscriber
public class Config {
    public static final String CATEGORY_GENERAL = "general";
    public static final String CATEGORY_WORLD = "world gen";

    private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

    public static ForgeConfigSpec COMMON_CONFIG;

    public static ForgeConfigSpec.BooleanValue welcomeMessage;
    public static ForgeConfigSpec.IntValue arlemiteVeinSize, arlemiteMaxHeight, arlemiteTries, realmiteVeinSize, realmiteMaxHeight, realmiteTries, rupeeVeinSize, rupeeMaxHeight, rupeeTries, netherVein, netherTries;

    static {

        COMMON_BUILDER.comment("General settings").push(CATEGORY_GENERAL);
        COMMON_BUILDER.comment("World Gen settings").push(CATEGORY_WORLD);
        COMMON_BUILDER.pop();

        setupConfig();

        COMMON_CONFIG = COMMON_BUILDER.build();
    }

    private static void setupConfig() {
        COMMON_BUILDER.comment("General Settings").push(CATEGORY_GENERAL);
        welcomeMessage = COMMON_BUILDER.comment("Enable welcome messages").define("welcomeMessage", true);

        COMMON_BUILDER.comment("World Gen Settings").push(CATEGORY_WORLD);
        arlemiteVeinSize = COMMON_BUILDER.comment("Arlemite ore vein size").defineInRange("arlemiteVein", 5, 1, 256);
        arlemiteMaxHeight = COMMON_BUILDER.comment("Arlemite ore maximum spawn height").defineInRange("arlemiteMax", 16, 1, 256);
        arlemiteTries = COMMON_BUILDER.comment("Arlemite ore popularity").defineInRange("arlemiteTries", 4, 1, 32);
        realmiteVeinSize = COMMON_BUILDER.comment("Realmite ore vein size").defineInRange("realmiteVein", 5, 1, 256);
        realmiteMaxHeight = COMMON_BUILDER.comment("Realmite ore maximum spawn height").defineInRange("realmiteMax", 48, 1, 256);
        realmiteTries = COMMON_BUILDER.comment("Realmite ore popularity").defineInRange("realmiteTries", 8, 1, 32);
        rupeeVeinSize = COMMON_BUILDER.comment("Rupee ore vein size").defineInRange("rupeeVein", 5, 1, 256);
        rupeeMaxHeight = COMMON_BUILDER.comment("Rupee ore maximum spawn height").defineInRange("rupeeMax", 16, 1, 256);
        rupeeTries = COMMON_BUILDER.comment("Rupee ore popularity").defineInRange("rupeeTries", 4, 1, 32);
        netherVein = COMMON_BUILDER.comment("Nether ore vein size").defineInRange("netherVein", 10, 1, 32);
        netherTries = COMMON_BUILDER.comment("Nether ore popularity").defineInRange("netherTries", 8, 1, 32);
        COMMON_BUILDER.pop();
    }

    public static void loadConfig(ForgeConfigSpec spec, Path path) {

        final CommentedFileConfig configData = CommentedFileConfig.builder(path)
                .sync()
                .autosave()
                .writingMode(WritingMode.REPLACE)
                .build();

        configData.load();
        spec.setConfig(configData);
    }
}
