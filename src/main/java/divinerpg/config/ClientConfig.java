package divinerpg.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ClientConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;
    public static ForgeConfigSpec.ConfigValue<Boolean> welcomeMessage, hideArcanaBar;
    public static ForgeConfigSpec.ConfigValue<Integer> arcanaX, arcanaY;
    static {
        BUILDER.push("Client configs for DivineRPG");
        welcomeMessage = BUILDER.comment("Show welcome message").define("welcomeMessage", true);
        hideArcanaBar = BUILDER.comment("Hide Arcana bar unless depleted").define("hideArcanaBar", true);
        arcanaX = BUILDER.comment("arcana x").defineInRange("arcanaX", 111, 1, 255);
        arcanaY = BUILDER.comment("arcana y").defineInRange("arcanaY", 18, 1, 255);
        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}