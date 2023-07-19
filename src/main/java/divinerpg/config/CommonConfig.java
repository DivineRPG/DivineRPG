package divinerpg.config;

import com.google.common.collect.ImmutableList;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class CommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;
    public static ForgeConfigSpec.ConfigValue<Integer> maxArcana, allureMaxMobs, ghostWhaleKills;
    public static ForgeConfigSpec.ConfigValue<List<String>> ghostWhaleProtected;

    static {
        BUILDER.push("Common configs for DivineRPG");
        maxArcana = BUILDER.comment("Maximum stored arcana").defineInRange("maxArcana", 200, 200, 10000);
        allureMaxMobs = BUILDER.comment("Maximum amount of loaded mobs before the frosted allure stops working").defineInRange("allureMaxMobs", 300, 150, 1000);
        ghostWhaleKills = BUILDER.comment("The amount of protected mob kills before the Ghost Whale is spawned").defineInRange("ghostWhaleKills", 100, 1, 10000);
        ghostWhaleProtected = BUILDER.comment("Entities that count towards ghost whale spawning").define("ghostWhaleProtected", ImmutableList.of("minecraft:salmon", "minecraft:cod", "minecraft:pufferfish", "minecraft:squid", "minecraft:tadpole", "minecraft:turtle", "divinerpg:shark", "divinerpg:aequorea", "divinerpg:whale", "divinerpg:liopleurodon", "minecraft:glow_squid", "divinerpg:robbin"));
        BUILDER.pop();
        SPEC = BUILDER.build();
    }

}
