package divinerpg.api.java.divinerpg.api.armorset;

import net.minecraft.entity.player.EntityPlayer;

@FunctionalInterface
public interface IEquipped {
    /**
     * Called when need to toggle armor power ability
     *
     * @param player         - Player
     * @param isFullEquipped - is player full armored
     */
    void onStatusChanged(EntityPlayer player, boolean isFullEquipped);
}

