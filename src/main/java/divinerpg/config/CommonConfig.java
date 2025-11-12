package divinerpg.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class CommonConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    private static final ModConfigSpec.DoubleValue MAX_ARCANA = BUILDER.comment("Player's maximum arcana capacity.").defineInRange("maxArcana", 200D, 0D, Float.MAX_VALUE);
    private static final ModConfigSpec.IntValue ALLURE_MAX_MOBS = BUILDER.comment("Maximum amount of loaded mobs before the Frosted Allure stops working.").defineInRange("allureMaxMobs", 300, 0, Integer.MAX_VALUE);
    private static final ModConfigSpec.BooleanValue SAFER_VETHEA_INVENTORY = BUILDER.comment("Safer handling of the Vethean inventory; adds a requirement to clear the inventory before entering Vethea.").define("saferVetheanInventory", false);
    public static final ModConfigSpec SPEC = BUILDER.build();
    public static class Values {
        public static final float ARCANA_MAX = (float)MAX_ARCANA.getAsDouble();
        public static final int ALLURE_MAX = ALLURE_MAX_MOBS.get();
        public static final boolean SAFER_VETHEA = SAFER_VETHEA_INVENTORY.get();
    }
}