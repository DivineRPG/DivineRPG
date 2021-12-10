package divinerpg.registries;

import divinerpg.*;
import divinerpg.events.*;
import divinerpg.events.enchant.*;
import net.minecraftforge.common.*;

public class EventRegistry {
    public static void init(){
        DivineRPG.LOGGER.info("[DivineRPG] Registered events");
        MinecraftForge.EVENT_BUS.register(new ProtectPetsEvent());
        MinecraftForge.EVENT_BUS.register(new ArmorAbilitiesEvent());
        MinecraftForge.EVENT_BUS.register(new EventClientLogin());
        MinecraftForge.EVENT_BUS.register(new MissingMappingEvent());
        MinecraftForge.EVENT_BUS.register(new AttatchCapabilityEvent());
        MinecraftForge.EVENT_BUS.register(new ChangeProfessionEvent());
        MinecraftForge.EVENT_BUS.register(new RiveHandler());
        MinecraftForge.EVENT_BUS.register(new VetheaInventorySwapEvent());
    }
}
