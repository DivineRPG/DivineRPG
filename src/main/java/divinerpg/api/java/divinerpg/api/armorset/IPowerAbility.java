package divinerpg.api.armorset;

import net.minecraftforge.fml.common.eventhandler.Event;

@FunctionalInterface
public interface IPowerAbility<T extends Event> {
    /**
     * Called on event when player is full equipped.
     *
     * @param event - Forge event
     */
    void handle(T event);
}
