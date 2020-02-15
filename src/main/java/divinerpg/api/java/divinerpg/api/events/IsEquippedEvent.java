package divinerpg.api.java.divinerpg.api.events;

import divinerpg.api.java.divinerpg.api.armor14.IPoweredArmorSet;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;

/**
 * Calls when need to detect is player full armored
 */
public class IsEquippedEvent extends PlayerEvent {

    private final IPoweredArmorSet armorSet;
    private boolean isEquipped = false;

    public IsEquippedEvent(EntityPlayer player, IPoweredArmorSet armorSet) {
        super(player);
        this.armorSet = armorSet;
    }

    /**
     * Get current armor set description
     */
    public IPoweredArmorSet getArmorSet() {
        return armorSet;
    }

    /**
     * Is current set equipped on player
     */
    public boolean isEquipped() {
        return isEquipped;
    }

    /**
     * Call method when player is equipped in current Armor set
     */
    public void confirmEquipment() {
        isEquipped = true;
    }
}
