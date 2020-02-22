package divinerpg.api.java.divinerpg.api.armorNew.interfaces;

import net.minecraft.entity.player.EntityPlayer;

public interface IEquipped {
    /**
     * Calls when player take off or take up armor
     *
     * @param player
     * @param isEquipped
     */
    void onEquppedChanged(EntityPlayer player, boolean isEquipped);
}
