package net.divinerpg.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    private static final ModConfigSpec.DoubleValue MAX_ARCANA = BUILDER.comment("Player's maximum arcana capacity.").defineInRange("maxArcana", 200D, 0D, Float.MAX_VALUE);
    private static final ModConfigSpec.IntValue ARCANA_BAR_X_POS = BUILDER.comment("Horizontal position of the arcana bar.").defineInRange("arcanaBarXPos", 111, 0, Integer.MAX_VALUE), ARCANA_BAR_Y_POS = BUILDER.comment("Vertical position of the arcana bar.").defineInRange("arcanaBarYPos", 18, 0, Integer.MAX_VALUE), ALLURE_MAX_MOBS = BUILDER.comment("Maximum amount of loaded mobs before the Frosted Allure stops working.").defineInRange("allureMaxMobs", 300, 0, Integer.MAX_VALUE);
    private static final ModConfigSpec.BooleanValue ENABLE_TOOL_TOOLTIPIFICATION = BUILDER.comment("Efficiency and Harvest Level tooltips for tools.").define("enableToolTooltipification", true), WELCOME_MSG = BUILDER.comment("Show welcome message.").define("welcomeMessage", true), HIDE_ARCANA = BUILDER.comment("Hide arcana bar unless depleted.").define("hideArcanaBar", true), SAFER_VETHEA_INVENTORY = BUILDER.comment("Safer handling of the Vethean inventory; adds a requirement to clear the inventory before entering Vethea.").define("saferVetheanInventory", false);

    public static final ModConfigSpec SPEC = BUILDER.build();

    public static class Values {
        public static final float ARCANA_MAX = (float)MAX_ARCANA.getAsDouble();
        public static final int ALLURE_MAX = ALLURE_MAX_MOBS.get(), ARCANA_BAR_POS_X = ARCANA_BAR_X_POS.get(), ARCANA_BAR_POS_Y = ARCANA_BAR_Y_POS.get();
        public static final boolean WELCOME_MESSAGE = WELCOME_MSG.get(), HIDE_ARCANA_BAR = HIDE_ARCANA.get(), TOOL_TOOLTIPIFICATION = ENABLE_TOOL_TOOLTIPIFICATION.get(), SAFER_VETHEA = SAFER_VETHEA_INVENTORY.get();
    }

}
