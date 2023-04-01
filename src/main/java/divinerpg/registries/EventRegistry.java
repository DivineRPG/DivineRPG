package divinerpg.registries;

import divinerpg.DivineRPG;
import divinerpg.events.*;
import divinerpg.events.enchant.RiveHandler;
import net.minecraftforge.common.MinecraftForge;

public class EventRegistry {
    public static void init(){
        DivineRPG.LOGGER.info("[DivineRPG] Registered events");
        MinecraftForge.EVENT_BUS.register(new ArmorAbilitiesEvent());
        MinecraftForge.EVENT_BUS.register(new RiveHandler());
        MinecraftForge.EVENT_BUS.register(new VetheaInventorySwapEvent());
    }
}
