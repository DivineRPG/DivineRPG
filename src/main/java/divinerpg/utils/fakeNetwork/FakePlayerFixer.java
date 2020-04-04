package divinerpg.utils.fakeNetwork;

import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class FakePlayerFixer {

    /**
     * Fixing forge problem - connection of FakePlayer is null.
     * Causes crushes when trying to add potion effect to FakePlayer
     *
     * @param e - constructing entity
     */
    @SubscribeEvent
    public static void fixFakePlayerConnection(EntityEvent.EntityConstructing e) {
        if (e.getEntity() instanceof FakePlayer) {
            FakePlayer fake = (FakePlayer) e.getEntity();
            // avoid possible null reference
            fake.connection = new FakeNetHandlerPlayServer(fake);
        }
    }
}
