package divinerpg.events.armorEvents;

import divinerpg.DivineRPG;
import divinerpg.api.events.ArmorChangedEvent;
import divinerpg.api.events.IsEquppedEvent;
import divinerpg.networking.message.EquipmentChangeMessage;
import divinerpg.utils.FullSetArmorHelper;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static divinerpg.registry.ModArmorEvents.HANDLERS_MAP;

public class ArmorTickEvent {
    /**
     * Store all player information here. I've never seen more than couple of
     * hundreds players on modded server, so I hope it won't be memory leaking
     */
    private final HashMap<UUID, List<Item>> playerMap = new HashMap<>();

    /**
     * Trying to loop through all handlers and handle abilities
     *
     * @param event
     * @param <T>
     */
    private <T extends Event> void handle(T event) {
        if (event.isCanceled())
            return;

        HANDLERS_MAP.forEach((handler, equipped) -> {
            if (equipped)
                handler.handle(event);
        });
    }

    /**
     * Managing equipment status here, only on server
     *
     * @param evt
     */
    @SubscribeEvent
    public void detectPlayerArmorSet(PlayerTickEvent evt) {
        if (evt.side != Side.SERVER) return;

        // Getting player's ID and current armor set
        UUID id = evt.player.getUniqueID();
        List<Item> armorSet = evt.player.inventory.armorInventory.stream().map(ItemStack::getItem).collect(Collectors.toList());
        // detecting if armorset was changed
        if (!armorSet.equals(playerMap.get(id))) {
            // remember new armorset
            playerMap.merge(id, armorSet, (items, items2) -> armorSet);
            // posting armor changed event
            MinecraftForge.EVENT_BUS.post(new ArmorChangedEvent(evt.player));
        }
    }

    /**
     * Originally calls only on server. Need to notify client
     *
     * @param e - player with changed equipment
     */
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onEquipmentChanged(ArmorChangedEvent e) {
        // checking all handlers if we are equipped
        HANDLERS_MAP.replaceAll((handler, wasEquipped) -> {
            // post isEquipped handler here
            IsEquppedEvent event = new IsEquppedEvent(e.getEntityPlayer(), handler);
            MinecraftForge.EVENT_BUS.post(event);

            // is changes detected
            if (event.isEquipped() != wasEquipped) {
                // callback on server
                handler.onStatusChanged(e.getEntityPlayer(), event.isEquipped());

                // Send message to client that equipment changed
                if (e.getEntityPlayer() instanceof EntityPlayerMP) {
                    DivineRPG.network.sendTo(new EquipmentChangeMessage(handler, event.isEquipped()), ((EntityPlayerMP) e.getEntityPlayer()));
                }
            }

            return event.isEquipped();
        });
    }

    /**
     * is checking wherever armor is full
     *
     * @param event
     */
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onCheckEquipment(IsEquppedEvent event) {
        FullSetArmorHelper helper = new FullSetArmorHelper(event.getEntityPlayer());
        if (helper.isEquipped(event.getHandler())) {
            event.confirmEquipment();
        }
    }

    ///////////////////////////////////////
    // Events below
    //////////////////////////////////////

    @SubscribeEvent
    public void onPlayerTick(PlayerTickEvent evt) {
        if (evt.phase == TickEvent.Phase.START) {
            handle(evt);
        }
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
