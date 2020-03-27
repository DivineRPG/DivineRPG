package divinerpg.api.armor;

import net.minecraft.entity.player.EntityPlayer;

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
    EntityPlayer getPlayer();

    /**
     * Subscribe on Forge events
     */
    void subscribe();

    /**
     * Unsubscribe from Forge events
     */
    void unsubscribe();
}
