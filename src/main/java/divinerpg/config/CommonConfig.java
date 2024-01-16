package divinerpg.config;

import com.google.common.collect.ImmutableList;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.List;

public class CommonConfig {
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;
    public static ModConfigSpec.ConfigValue<Integer> maxArcana, allureMaxMobs, kitraKills;
    public static ModConfigSpec.ConfigValue<List<String>> kitraProtected;
    public static ModConfigSpec.ConfigValue<Boolean> saferVetheanInventory;

    static {
        BUILDER.push("Common configs for DivineRPG");
        maxArcana = BUILDER.comment("Maximum stored arcana").defineInRange("maxArcana", 200, 200, 10000);
        allureMaxMobs = BUILDER.comment("Maximum amount of loaded mobs before the frosted allure stops working").defineInRange("allureMaxMobs", 300, 150, 1000);
        kitraKills = BUILDER.comment("The amount of protected mob kills before the Kitra is spawned").defineInRange("kitraKills", 100, 1, 10000);
        kitraProtected = BUILDER.comment("Entities that count towards Kitra spawning").define("kitraProtected", ImmutableList.of("minecraft:salmon", "minecraft:cod", "minecraft:pufferfish", "minecraft:squid", "minecraft:tadpole", "minecraft:turtle", "divinerpg:shark", "divinerpg:aequorea", "divinerpg:whale", "divinerpg:liopleurodon", "minecraft:glow_squid", "divinerpg:robbin"));
        saferVetheanInventory = BUILDER.comment("Safer handling of the Vethean inventory").define("saferVetheanInventory", false);
        BUILDER.pop();
        SPEC = BUILDER.build();
    }

}
