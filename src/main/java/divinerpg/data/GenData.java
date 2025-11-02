package divinerpg.data;

import net.minecraft.data.DataProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import static divinerpg.DivineRPG.MODID;

@SuppressWarnings("removal")
@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
public class GenData {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent evt) {
        evt.getGenerator().addProvider(evt.includeServer(), (DataProvider.Factory<WorldGenerator>) output -> new WorldGenerator(output, evt.getLookupProvider()));
    }
}