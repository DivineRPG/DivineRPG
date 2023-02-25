package divinerpg.events;

import divinerpg.util.datagen.GenerateBlockLoot;
import net.minecraftforge.data.event.GatherDataEvent;

public class GenData {
    public GenData() {}

    public static void gatherData(GatherDataEvent evt) {
        if (evt.includeServer()) {
            evt.getGenerator().addProvider(false, new GenerateBlockLoot(evt.getGenerator()));
        }
    }
}