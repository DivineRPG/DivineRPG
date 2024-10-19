package divinerpg.config;

import divinerpg.DivineRPG;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

public class ClientConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.IntValue ARCANA_X = BUILDER.comment("arcana x").defineInRange("arcanaX", 111, 1, 255), ARCANA_Y = BUILDER.comment("arcana y").defineInRange("arcanaY", 18, 1, 255);
    private static final ModConfigSpec.BooleanValue WELCOME_MSG = BUILDER.comment("Show welcome message").define("welcomeMessage", true), HIDE_ARCANA = BUILDER.comment("Hide Arcana bar unless depleted").define("hideArcanaBar", true);

    public static final ModConfigSpec SPEC = BUILDER.build();

    public static int ARCANAX, ARCANAY;
    public static boolean WELCOME_MESSAGE, HIDE_ARCANA_BAR;

    private static boolean validateItemName(final Object obj)
    {
        return obj instanceof String itemName && BuiltInRegistries.ITEM.containsKey(ResourceLocation.parse(itemName));
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        ARCANAX = ARCANA_X.get();
        ARCANAY = ARCANA_Y.get();
        WELCOME_MESSAGE = WELCOME_MSG.get();
        HIDE_ARCANA_BAR = HIDE_ARCANA.get();

    }
}