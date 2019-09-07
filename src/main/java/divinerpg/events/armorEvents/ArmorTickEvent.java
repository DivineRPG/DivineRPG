package divinerpg.events.armorEvents;

import divinerpg.api.FullArmorHandler;
import divinerpg.utils.FullSetArmorHelper;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import static divinerpg.registry.ModArmorEvents.ALL_HANDLERS;

public class ArmorTickEvent {
    /**
     * Trying to loop through all handlers and handle abilities
     *
     * @param event
     * @param <T>
     */
    private <T extends Event> void handle(T event) {
        ALL_HANDLERS.forEach((handler, equipped) -> {
            if (equipped)
                handler.handle(event);
        });
    }

    ///////////////////////////////////////
    // Events below
    //////////////////////////////////////


    /**
     * Managing with full eqipped status here
     */
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent evt) {
        FullSetArmorHelper helper = new FullSetArmorHelper(evt.player);

        ALL_HANDLERS.replaceAll((handler, wasEquipped) -> {
            boolean isEquipped = helper.isEquipped(handler);

            FullArmorHandler.IEquipped equippedCallback = handler.getEquipped();
            if (isEquipped != wasEquipped && equippedCallback != null) {
                equippedCallback.onStatusChanged(evt.player, isEquipped);
            }

            return isEquipped;
        });

        // handle other events too
        handle(evt);
    }

    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent evt) {
        handle(evt);
    }

    @SubscribeEvent
    public void onAttacked(LivingAttackEvent e) {
        handle(e);
    }

    @SubscribeEvent
    public void onBlockDropped(BlockEvent.HarvestDropsEvent event) {
        handle(event);
    }

    @SubscribeEvent
    public void onJump(LivingEvent.LivingJumpEvent event) {
        handle(event);
    }
}
