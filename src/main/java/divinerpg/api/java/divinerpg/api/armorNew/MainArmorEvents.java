package divinerpg.api.java.divinerpg.api.armorNew;


import divinerpg.DivineRPG;
import divinerpg.api.java.divinerpg.api.DivineAPI;
import divinerpg.api.java.divinerpg.api.armorNew.interfaces.IArmorSet;
import divinerpg.api.java.divinerpg.api.armorNew.interfaces.IPoweredArmor;
import divinerpg.api.java.divinerpg.api.armorNew.interfaces.IPoweredArmorManage;
import divinerpg.networking.message.PlayerLoggedEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Main monitoring class
 */
@Mod.EventBusSubscriber()
public class MainArmorEvents {
    //
    // We need to store map for each side for singleplayer
    // Because we are running both side on one physical machine
    //

    private static final Map<Side, Map<EntityPlayer, PlayerArmorObserver>> playerMap = new HashMap<>();

    private static final Map<Side, Map<ResourceLocation, IPoweredArmorManage>> armorManagerMap = new HashMap<>();

    /**
     * Gets Armor set manager from registry name of PowerArmor
     *
     * @param location
     * @return
     */
    public static IPoweredArmorManage findArmorSetManager(ResourceLocation location) {
        return armorManagerMap.computeIfAbsent(FMLCommonHandler.instance().getEffectiveSide(), MainArmorEvents::createPowerMap).get(location);
    }

    /**
     * Gets armor status player info
     *
     * @param player
     * @return
     */
    public static PlayerArmorObserver findPlayerArmorObserver(EntityPlayer player) {
        Map<EntityPlayer, PlayerArmorObserver> map = getPlayersMap();
        return map.computeIfAbsent(player, PlayerArmorObserver::new);
    }

    /**
     * Creating map of armor managers
     *
     * @param side
     * @return
     */
    private static Map<ResourceLocation, IPoweredArmorManage> createPowerMap(Side side) {
        return DivineAPI.getPowerSetRegistry().getValuesCollection().stream().collect(Collectors.toMap(
                IForgeRegistryEntry::getRegistryName,
                PoweredArmorManager::new
        ));
    }

    private static Map<EntityPlayer, PlayerArmorObserver> getPlayersMap() {
        return playerMap.computeIfAbsent(FMLCommonHandler.instance().getEffectiveSide(), x -> new HashMap<>());
    }


    /**
     * When new player is logged, create its own player observer
     *
     * @param event
     */
    @SubscribeEvent
    public static void onLogin(PlayerEvent.PlayerLoggedInEvent event) {
        Map<EntityPlayer, PlayerArmorObserver> map = getPlayersMap();

        // todo remove duplicates
        map.put(event.player, new PlayerArmorObserver(event.player));

        if (event.player instanceof EntityPlayerMP) {
            DivineRPG.network.sendTo(new PlayerLoggedEvent(true), (EntityPlayerMP) event.player);
        }
    }

    /**
     * Removing leaving player from map
     */
    @SubscribeEvent
    public static void onPlayerLeave(PlayerEvent.PlayerLoggedOutEvent e) {
        // todo Maube will delete it
        // will not work. I believe it is because client was already disconnected
//        if (e.player instanceof EntityPlayerMP) {
//            DivineRPG.network.sendTo(new PlayerLoggedEvent(false), (EntityPlayerMP) e.player);
//        }

        getPlayersMap().remove(e.player);
    }

    @SubscribeEvent
    public static void checkEquipment(IsEquppedEvent event) {
        for (IPoweredArmor armor : DivineAPI.getPowerSetRegistry()) {
            if (armor != null) {
                // returns description of armor
                IArmorSet description = armor.getArmorDescription();

                boolean isOn = Arrays.stream(EntityEquipmentSlot.values())
                        .allMatch(x -> {
                            // getting possible items of armor set
                            List<Item> items = description.getPossibleItems(x);
                            // checks if list is empty or armor description contains
                            // equipped item
                            return items.isEmpty() || items.contains(event.getItemInSlot(x));
                        });

                if (isOn) {
                    event.add(armor.getRegistryName());
                }
            }
        }
    }
}
