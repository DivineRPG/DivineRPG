package divinerpg.registries;

import divinerpg.DivineRPG;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID)
public class EntitySpawn {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void biomeLoading(BiomeLoadingEvent event) {
        EntityRegistry.spawnStuff(event);
    }
}