package divinerpg.events.armor;

import divinerpg.api.java.divinerpg.api.DivineAPI;
import divinerpg.api.java.divinerpg.api.events.IsEquippedEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * Controls armor status of players
 */
@Mod.EventBusSubscriber()
public class FullArmorEventHandler {

    private static final HashMap<Side, HashMap<UUID, ArmorObserver>> playerMap = new HashMap<>();

    /**
     * Returns actual player map based on dist
     *
     * @return
     */
    public static final HashMap<UUID, ArmorObserver> getPlayerMap() {
        return playerMap.computeIfAbsent(FMLCommonHandler.instance().getEffectiveSide(), key -> new HashMap<>());
    }


    /**
     * Removing leaving player from map
     */
    @SubscribeEvent
    public static void onPlayerLeave(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent e) {
        // removing players
        EntityPlayer player = e.player;

        if (player != null)
            getPlayerMap().remove(player.getUniqueID());
    }

    /**
     * Addind player to map
     */
    @SubscribeEvent
    public static void onPLayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        EntityPlayer player = event.player;
        if (player != null) {
            putNewPLayer(player);
        }
    }

    /**
     * Detecting player's armor status changed
     */
    @SubscribeEvent
    public static void detectArmorChanges(TickEvent.PlayerTickEvent e) {
        UUID id = e.player.getUniqueID();

        if (!getPlayerMap().containsKey(id)) {
            // PlayerLoggedInEvent server only as I understood, so it's possible situation
            putNewPLayer(e.player);
        }

        // optimization.
        // Tick routine performs on clients and server receives only actual changes
        if (e.player.world.isRemote)
            getPlayerMap().get(id).Update(e.player);
    }

    /**
     * Detects if player wears that armor
     */
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void detectIsEquipped(IsEquippedEvent event) {
        if (event.isEquipped())
            return;

        if (event.getArmorSet().getArmorSetDescriber().isEquipped(event.getEntityPlayer())) {
            event.confirmEquipment();
        }
    }


    /**
     * Adding new player to list
     */
    private static void putNewPLayer(EntityPlayer playerEntity) {
        getPlayerMap().put(playerEntity.getUniqueID(), new ArmorObserver(playerEntity, new ArrayList<>(DivineAPI.getPowerRegistry().getValuesCollection())));
    }
}
