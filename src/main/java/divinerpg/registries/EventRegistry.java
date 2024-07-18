package divinerpg.registries;

import divinerpg.DivineRPG;
import divinerpg.events.*;
import divinerpg.events.enchant.RiveHandler;
import net.neoforged.neoforge.common.NeoForge;

public class EventRegistry {
    public static void init(){
        DivineRPG.LOGGER.info("[DivineRPG] Registered events");
        NeoForge.EVENT_BUS.register(new ArmorAbilitiesEvent());
        NeoForge.EVENT_BUS.register(new RiveHandler());
        NeoForge.EVENT_BUS.register(new VetheaInventorySwapEvent());
        NeoForge.EVENT_BUS.register(new GlacialWallTotemEvent());
    }
}
