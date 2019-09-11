package divinerpg.api.events;

import divinerpg.api.armorset.FullArmorHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

/**
 * Calls when need to detect is player full armored
 */
@Cancelable
public class IsEquppedEvent extends PlayerEvent {
    private final FullArmorHandler handler;
    private boolean isEquipped;

    public IsEquppedEvent(EntityPlayer player, FullArmorHandler handler) {
        super(player);
        this.handler = handler;
    }

    /**
     * Gets current Armor handler
     *
     * @return
     */
    public FullArmorHandler getHandler() {
        return handler;
    }

    /**
     * Gets Armor set status
     *
     * @return
     */
    public boolean isEquipped() {
        return this.isEquipped;
    }

    /**
     * Call method when player is equipped in current Armor set
     */
    public void confirmEquipment() {
        isEquipped = true;
    }
}
