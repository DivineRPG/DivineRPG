package divinerpg.registries;

import divinerpg.events.*;
import divinerpg.events.enchant.*;
import net.minecraftforge.common.*;

public class EventRegistry {
    public static void init(){
        MinecraftForge.EVENT_BUS.register(new ProtectPetsEvent());
        MinecraftForge.EVENT_BUS.register(new ArmorAbilitiesEvent());
        MinecraftForge.EVENT_BUS.register(new EventClientLogin());
        MinecraftForge.EVENT_BUS.register(new MissingMappingEvent());
        MinecraftForge.EVENT_BUS.register(new AttatchCapabilityEvent());
        MinecraftForge.EVENT_BUS.register(new ArcanaRenderer());
        MinecraftForge.EVENT_BUS.register(new RiveHandler());
    }
}
