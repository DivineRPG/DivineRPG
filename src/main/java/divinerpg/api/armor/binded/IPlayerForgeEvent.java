package divinerpg.api.armor.binded;

import divinerpg.api.armor.IPlayerSubscription;
import divinerpg.api.armor.registry.IForgeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/**
 * Represents event handling by concrete player.
 *
 * @param <T> - any event type
 */
public interface IPlayerForgeEvent<T extends Event> extends IForgeEvent<T>, IPlayerSubscription {

    /**
     * Actually check wherever player is a part of the event.
     * The only way to check is player assotiated with event
     *
     * @param event - forge event
     * @return
     */
    default boolean canHandle(T event) {
        if (event == null)
            return false;

        EntityPlayer player = getPlayer();
        if (player == null)
            return false;

        // Most common on top
        if (event instanceof TickEvent.PlayerTickEvent
                && ((TickEvent.PlayerTickEvent) event).player == player) {
            return true;
        }

        if (event instanceof EntityEvent
                && ((EntityEvent) event).getEntity() == player) {
            return true;
        }

        if (event instanceof LivingHurtEvent
                && ((LivingHurtEvent) event).getSource().getTrueSource() == player) {
            return true;
        }

        if (event instanceof BlockEvent.BreakEvent
                && ((BlockEvent.BreakEvent) event).getPlayer() == player) {
            return true;
        }

        if (event instanceof BlockEvent.PlaceEvent
                && ((BlockEvent.PlaceEvent) event).getPlayer() == player) {
            return true;
        }

        return event instanceof BlockEvent.HarvestDropsEvent
                && ((BlockEvent.HarvestDropsEvent) event).getHarvester() == player;
    }

    /**
     * Subscribe on current event
     */
    @Override
    default void subscribe() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    /**
     * Unregister from event subscribing
     */
    @Override
    default void unsubscribe() {
        MinecraftForge.EVENT_BUS.unregister(this);
    }
}
