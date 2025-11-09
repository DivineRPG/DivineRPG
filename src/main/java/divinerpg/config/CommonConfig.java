package divinerpg.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class CommonConfig {
    static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    static final ModConfigSpec.DoubleValue MAX_ARCANA = BUILDER.comment("Maximum stored arcana").defineInRange("maxArcana", 200D, 0D, Float.MAX_VALUE);
    static final ModConfigSpec.IntValue ALLURE_MAX_MOBS = BUILDER.comment("Maximum amount of loaded mobs before the Frosted Allure stops working").defineInRange("allureMaxMobs", 300, 0, Integer.MAX_VALUE);
    static final ModConfigSpec.BooleanValue ENABLE_TOOL_TOOLTIPIFICATION = BUILDER.comment("Efficiency and Harvest Level tooltips for tools").define("enableToolTooltipification", true);
    static final ModConfigSpec.BooleanValue SAFER_VETHEA_INVENTORY = BUILDER.comment("Safer handling of the Vethean inventory").define("saferVetheanInventory", false);
    public static final ModConfigSpec SPEC = BUILDER.build();
    public static class Values {
        public static final float ARCANA_MAX = (float)MAX_ARCANA.getAsDouble();
        public static final int ALLURE_MAX = ALLURE_MAX_MOBS.get();
        public static final boolean
                TOOL_TOOLTIPIFICATION = ENABLE_TOOL_TOOLTIPIFICATION.get(),
                SAFER_VETHEA = SAFER_VETHEA_INVENTORY.get();
    }
}