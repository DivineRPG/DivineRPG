package divinerpg.config;


import divinerpg.DivineRPG;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = DivineRPG.MODID, bus = EventBusSubscriber.Bus.MOD)
public class CommonConfig
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.DoubleValue MAX_ARCANA = BUILDER.comment("Maximum stored arcana").defineInRange("maxArcana", 200D, 0D, Float.MAX_VALUE);
    private static final ModConfigSpec.IntValue ALLURE_MAX_MOBS = BUILDER.comment("Maximum amount of loaded mobs before the frosted allure stops working").defineInRange("allureMaxMobs", 300, 0, Integer.MAX_VALUE);
    private static final ModConfigSpec.BooleanValue SAFER_VETHEA_INVENTORY = BUILDER.comment("Safer handling of the Vethean inventory").define("saferVetheanInventory", false);

    public static final ModConfigSpec SPEC = BUILDER.build();

    public static float ARCANA_MAX;
    public static int ALLURE_MAX;
    public static boolean SAFER_VETHEA;

//    private static boolean validateItemName(final Object obj)
//    {
//        return obj instanceof String itemName && BuiltInRegistries.ITEM.containsKey(ResourceLocation.parse(itemName));
//    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        double d = MAX_ARCANA.get();
    	ARCANA_MAX = (float) d;
        ALLURE_MAX = ALLURE_MAX_MOBS.get();
        SAFER_VETHEA = SAFER_VETHEA_INVENTORY.get();

    }

}
