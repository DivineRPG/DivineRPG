package divinerpg;

import com.electronwill.nightconfig.core.file.*;
import com.electronwill.nightconfig.core.io.*;
import net.minecraftforge.common.*;
import net.minecraftforge.fml.common.*;

import java.nio.file.*;

@Mod.EventBusSubscriber
public class Config {
    public static final String CATEGORY_GENERAL = "general";

    private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

    public static ForgeConfigSpec COMMON_CONFIG;

    public static ForgeConfigSpec.BooleanValue welcomeMessage;

    static {

        COMMON_BUILDER.comment("General settings").push(CATEGORY_GENERAL);
        COMMON_BUILDER.pop();

        setupConfig();

        COMMON_CONFIG = COMMON_BUILDER.build();
    }

    private static void setupConfig() {
        COMMON_BUILDER.comment("General Settings").push(CATEGORY_GENERAL);
        welcomeMessage = COMMON_BUILDER.comment("Enable welcome messages").define("welcomeMessage", true);

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
