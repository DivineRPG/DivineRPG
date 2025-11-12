package divinerpg.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ClientConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    private static final ModConfigSpec.BooleanValue HIDE_ARCANA = BUILDER.comment("Hide arcana bar unless depleted.").define("hideArcanaBar", true);
    private static final ModConfigSpec.IntValue
            //TODO: in-game configuration, instead of blindly inputting numbers until it works the way you want it to
            ARCANA_BAR_X_POS = BUILDER.comment("Horizontal position of the arcana bar.").defineInRange("arcanaBarXPos", 111, 0, Integer.MAX_VALUE),
            ARCANA_BAR_Y_POS = BUILDER.comment("Vertical position of the arcana bar.").defineInRange("arcanaBarYPos", 18, 0, Integer.MAX_VALUE);
    private static final ModConfigSpec.BooleanValue
            WELCOME_MSG = BUILDER.comment("Show welcome message.").define("welcomeMessage", true),
            ENABLE_TOOL_TOOLTIPIFICATION = BUILDER.comment("Efficiency and Harvest Level tooltips for tools.").define("enableToolTooltipification", true);
    public static final ModConfigSpec SPEC = BUILDER.build();
    public static class Values {
        public static final int
                ARCANA_BAR_POS_X = ARCANA_BAR_X_POS.get(),
                ARCANA_BAR_POS_Y = ARCANA_BAR_Y_POS.get();
        public static final boolean
                WELCOME_MESSAGE = WELCOME_MSG.get(),
                HIDE_ARCANA_BAR = HIDE_ARCANA.get(),
                TOOL_TOOLTIPIFICATION = ENABLE_TOOL_TOOLTIPIFICATION.get();
    }
}