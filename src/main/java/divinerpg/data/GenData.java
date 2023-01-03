package divinerpg.data;

import divinerpg.DivineRPG;
import net.minecraft.data.DataProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GenData {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent evt) {
        evt.getGenerator().addProvider(evt.includeServer(), (DataProvider.Factory<WorldGenerator>) output -> new WorldGenerator(output, evt.getLookupProvider()));
    }
}