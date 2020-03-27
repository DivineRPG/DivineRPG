package divinerpg.api.armor.registry;

import net.minecraftforge.fml.common.eventhandler.Event;

/**
 * Represents single 'power' of Power Set
 *
 * @param <T> - any event type
 */
public interface IForgeEvent<T extends Event> {

    /**
     * Describing here what will happend on that event
     *
     * @param event
     */
    void handle(T event);

    /**
     * Actual type of generic parameter
     *
     * @return
     */
    Class<T> getParameterClass();
}
