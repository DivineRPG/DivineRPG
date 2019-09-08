package divinerpg.events.armorEvents;

import divinerpg.api.ActionArbiter;
import divinerpg.utils.FullSetArmorHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;

import static divinerpg.registry.ModArmorEvents.ALL_HANDLERS;

public class ArmorTickEvent {
    protected final ActionArbiter arbiter = new ActionArbiter();

    /**
     * Trying to loop through all handlers and handle abilities
     *
     * @param event
     * @param <T>
     */
    private <T extends Event> void handle(T event) {
        if (event.isCanceled())
            return;

        arbiter.Do(() -> {
            ALL_HANDLERS.forEach((handler, equipped) -> {
                if (equipped)
                    handler.handle(event);
            });
        });
    }

    ///////////////////////////////////////
    // Events below
    //////////////////////////////////////


    /**
     * Managing with full eqipped status here
     */
    @SubscribeEvent
    public void onPlayerTick(PlayerTickEvent evt) {
        if (evt.isCanceled()
                || evt.phase != TickEvent.Phase.START
                || evt.side != Side.SERVER) {
            return;
        }

        EntityPlayer player = evt.player;
        FullSetArmorHelper helper = new FullSetArmorHelper(player);

        arbiter.Do(() -> {
            ALL_HANDLERS.replaceAll((handler, wasEquipped) -> {
                boolean isEquipped = helper.isEquipped(handler);

                if (isEquipped != wasEquipped)
                    handler.onStatusChanged(player, isEquipped);

                return isEquipped;
            });
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
