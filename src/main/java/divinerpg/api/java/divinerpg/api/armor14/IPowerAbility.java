package divinerpg.api.java.divinerpg.api.armor14;


import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@FunctionalInterface
public interface IPowerAbility<T extends Event> {
    /**
     * Called on event when player is full equipped.
     *
     * @param event - Forge event
     */
    @SubscribeEvent
    void handleAbility(Event event);
}
