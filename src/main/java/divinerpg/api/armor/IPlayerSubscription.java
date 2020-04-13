package divinerpg.api.armor;

import net.minecraft.entity.EntityLivingBase;

/**
 * Represents object linked to player.
 * Optionally can subscribe to Forge events
 */
public interface IPlayerSubscription {

    /**
     * Returns associated player
     *
     * @return
     */
    EntityLivingBase getPlayer();

    /**
     * Subscribe on Forge events
     */
    void subscribe();

    /**
     * Unsubscribe from Forge events
     */
    void unsubscribe();

    /**
     * Is current class is receiving Forge events
     *
     * @return
     */
    boolean isListening();
}
