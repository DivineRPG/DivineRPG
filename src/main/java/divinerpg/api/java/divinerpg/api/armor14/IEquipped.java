package divinerpg.api.java.divinerpg.api.armor14;

import net.minecraft.entity.player.EntityPlayer;

@FunctionalInterface
public interface IEquipped {

    /**
     * Called when need to toggle powered armor ability
     *
     * @param player     - Player
     * @param isEquipped - is player full armored
     */
    void onEquppedChanged(EntityPlayer player, boolean isEquipped);
}
