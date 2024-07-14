package divinerpg.data;

import divinerpg.DivineRPG;
import net.minecraft.data.DataProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = DivineRPG.MODID, bus = EventBusSubscriber.Bus.MOD)
public class GenData {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent evt) {
        evt.getGenerator().addProvider(evt.includeServer(), (DataProvider.Factory<WorldGenerator>) output -> new WorldGenerator(output, evt.getLookupProvider()));
    }
}