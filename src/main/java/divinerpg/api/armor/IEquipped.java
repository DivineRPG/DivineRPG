package divinerpg.api.armor;

import net.minecraft.entity.player.EntityPlayer;

@FunctionalInterface
public interface IEquipped {
    /**
     * @param player
     * @param isOn
     */
    void onEquppedChanged(EntityPlayer player, boolean isOn);
}
