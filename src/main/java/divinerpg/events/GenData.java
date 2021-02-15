package divinerpg.events;

import divinerpg.DivineRPG;
import divinerpg.util.datagen.GenerateBlockLoot;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GenData {
    public GenData() {}

    @SubscribeEvent
    public static void gatherData(GatherDataEvent evt) {
        if (evt.includeServer()) {
            evt.getGenerator().addProvider(new GenerateBlockLoot(evt.getGenerator()));
        }
    }
}