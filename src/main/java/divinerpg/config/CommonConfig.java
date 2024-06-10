package divinerpg.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;
    public static ForgeConfigSpec.ConfigValue<Integer> maxArcana, allureMaxMobs;
    public static ForgeConfigSpec.ConfigValue<Boolean> saferVetheanInventory;

    static {
        BUILDER.push("Common configs for DivineRPG");
        maxArcana = BUILDER.comment("Maximum stored arcana").defineInRange("maxArcana", 200, 200, 10000);
        allureMaxMobs = BUILDER.comment("Maximum amount of loaded mobs before the frosted allure stops working").defineInRange("allureMaxMobs", 300, 150, 1000);
        saferVetheanInventory = BUILDER.comment("Safer handling of the Vethean inventory").define("saferVetheanInventory", false);
        BUILDER.pop();
        SPEC = BUILDER.build();
    }

}
