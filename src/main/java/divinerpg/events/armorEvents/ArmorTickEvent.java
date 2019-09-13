package divinerpg.events.armorEvents;

import divinerpg.DivineRPG;
import divinerpg.api.events.ArmorChangedEvent;
import divinerpg.api.events.IsEquppedEvent;
import divinerpg.networking.message.EquipmentChangeMessage;
import divinerpg.utils.FullSetArmorHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static divinerpg.registry.ModArmorEvents.ARMOR_HANDLERS;

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
    private <T extends Event> void handle(EntityPlayer player, T event) {
        if (event.isCanceled())
            return;

        ARMOR_HANDLERS.handle(player, event);
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
        EntityPlayer player = e.getEntityPlayer();

        ARMOR_HANDLERS.getPlayerHandler(player).updateEquippedStatus(handler -> {
                    // post isEquipped handler here
                    IsEquppedEvent event = new IsEquppedEvent(player, handler);
                    MinecraftForge.EVENT_BUS.post(event);
                    return event.isEquipped();
                },
                (handler, isEquipped) -> {
                    // callback on server
                    handler.onStatusChanged(player, isEquipped);

                    // Send message to client that equipment changed
                    if (e.getEntityPlayer() instanceof EntityPlayerMP) {
                        DivineRPG.network.sendTo(new EquipmentChangeMessage(handler, isEquipped), ((EntityPlayerMP) e.getEntityPlayer()));
                    }
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

    /**
     * Start ovserve new player
     *
     * @param event
     */
    @SubscribeEvent
    public void onPlayerLeave(PlayerEvent.PlayerLoggedOutEvent event) {
        ARMOR_HANDLERS.removePlayer(event.player);
    }

    /**
     * Remove player from observing
     *
     * @param event
     */
    @SubscribeEvent
    public void onPlayerJoined(PlayerEvent.PlayerLoggedInEvent event) {
        ARMOR_HANDLERS.addPlayer(event.player);
    }

    private EntityPlayer getPlayer(LivingEvent e, DamageSource source) {
        if (source.getTrueSource() instanceof EntityPlayer)
            return (EntityPlayer) source.getTrueSource();

        if (e.getEntityLiving() instanceof EntityPlayer)
            return (EntityPlayer) e.getEntityLiving();

        return null;
    }

    ///////////////////////////////////////
    // Events below
    //////////////////////////////////////
    @SubscribeEvent
    public void onPlayerTick(PlayerTickEvent evt) {
        if (evt.phase == TickEvent.Phase.START) {
            handle(evt.player, evt);
        }
    }

    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent evt) {
        handle(getPlayer(evt, evt.getSource()), evt);
    }

    @SubscribeEvent
    public void onAttacked(LivingAttackEvent e) {
        handle(getPlayer(e, e.getSource()), e);
    }

    @SubscribeEvent
    public void onBlockDropped(BlockEvent.HarvestDropsEvent event) {
        handle(event.getHarvester(), event);
    }

    @SubscribeEvent
    public void onJump(LivingEvent.LivingJumpEvent event) {
        if (event.getEntityLiving() instanceof EntityPlayer)
            handle((EntityPlayer) event.getEntityLiving(), event);

    }
}
