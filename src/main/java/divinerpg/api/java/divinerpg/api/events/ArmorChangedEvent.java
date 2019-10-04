package divinerpg.api.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;

/**
 * Called when armor set is changed
 */
public class ArmorChangedEvent extends PlayerEvent {
    public ArmorChangedEvent(EntityPlayer player) {
        super(player);
    }
}
