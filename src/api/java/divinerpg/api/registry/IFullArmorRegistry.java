package divinerpg.api.registry;

import divinerpg.api.armorset.FullArmorHandler;

/**
 * Help us to register full armor handlers
 */
public interface IFullArmorRegistry {
    /**
     * Registers a new Full armor event handler.
     * Throw if already registered
     *
     * @param handler - armor handler
     */
    void addHandler(FullArmorHandler handler);

    /**
     * Unregister Full armor handler.
     * Throw if handler was not registered
     *
     * @param handler - armor handler
     */
    void removeHandler(FullArmorHandler handler);

}
