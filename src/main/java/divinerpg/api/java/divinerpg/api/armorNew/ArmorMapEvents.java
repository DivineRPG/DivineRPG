package divinerpg.api.java.divinerpg.api.armorNew;


import divinerpg.DivineRPG;
import divinerpg.api.java.divinerpg.api.DivineAPI;
import divinerpg.api.java.divinerpg.api.armorNew.interfaces.IArmorSet;
import divinerpg.api.java.divinerpg.api.armorNew.interfaces.IPoweredArmor;
import divinerpg.api.java.divinerpg.api.armorNew.interfaces.IPoweredArmorManage;
import divinerpg.networking.message.MessageArcanaBar;
import divinerpg.networking.message.PlayerLoggedEvent;
import it.unimi.dsi.fastutil.booleans.BooleanArrayList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Mod.EventBusSubscriber()
public class ArmorMapEvents {
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
        return armorManagerMap.computeIfAbsent(FMLCommonHandler.instance().getEffectiveSide(), ArmorMapEvents::createPowerMap).get(location);
    }

    /**
     * Gets armor status player info
     *
     * @param player
     * @return
     */
    public static PlayerArmorObserver findPlayerArmorObserver(EntityPlayer player) {
        return getPlayersMap().get(player);
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
        map.computeIfAbsent(event.player, PlayerArmorObserver::new);

        if (event.player instanceof EntityPlayerMP) {
            DivineRPG.network.sendTo(new PlayerLoggedEvent(true), (EntityPlayerMP) event.player);
        }
    }

    /**
     * Removing leaving player from map
     */
    @SubscribeEvent
    public static void onPlayerLeave(PlayerEvent.PlayerLoggedOutEvent e) {
        getPlayersMap().remove(e.player);

        if (e.player instanceof EntityPlayerMP) {
            DivineRPG.network.sendTo(new PlayerLoggedEvent(false), (EntityPlayerMP) e.player);
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void checkEquipment(IsEquppedEvent event) {
        List<ResourceLocation> wearing = DivineAPI.getPowerSetRegistry().getEntries().parallelStream()
                .filter(x -> {
                    IArmorSet armor = x.getValue().getArmorDescription();

                    return Arrays.stream(EntityEquipmentSlot.values())
                            .allMatch(s -> armor.getPossibleItems(s).contains(event.getItemInSlot(s)));
                }).map(Map.Entry::getKey).collect(Collectors.toList());

        for (ResourceLocation id : wearing) {
            event.add(id);
        }
    }
}
