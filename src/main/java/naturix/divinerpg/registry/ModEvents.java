package naturix.divinerpg.registry;

import naturix.divinerpg.events.EventArmorSet;
import net.minecraftforge.common.MinecraftForge;

public class ModEvents {
	public static void postForgeEvent(Object o) {
        MinecraftForge.EVENT_BUS.register(o);
    }
	public static void preInit() {
        //postForgeEvent(new EventArmorSet());
	}
}
