package divinerpg.registries;

import divinerpg.events.*;
import divinerpg.events.enchant.RiveHandler;

import static divinerpg.DivineRPG.LOGGER;
import static net.neoforged.neoforge.common.NeoForge.EVENT_BUS;

public class EventRegistry {
    public static void init(){
        LOGGER.info("[DivineRPG] Registered events");
        EVENT_BUS.register(new ArmorAbilitiesEvent());
        EVENT_BUS.register(new GlacialWallTotemEvent());
        EVENT_BUS.register(new RiveHandler());
        EVENT_BUS.register(new SnowballDamage());
        EVENT_BUS.register(new VetheaInventorySwapEvent());
    }
}