package divinerpg.api.java.divinerpg.api.armorNew.interfaces;

import divinerpg.DivineRPG;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@FunctionalInterface
public interface IAbilityHandler<T extends Event> {
    /**
     * Called on event when player is full equipped.
     *
     * @param event - Forge event
     */
    @SubscribeEvent
    void handleAbility(T event);

    /**
     * Helping method to execute any event
     *
     * @param e
     */
    default void handle(Event e) {
        DivineRPG.logger.info("i'm here");
        T event = (T) e;

        if (event != null) {
            handleAbility(event);
        }
    }
}
