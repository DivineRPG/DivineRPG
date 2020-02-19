package divinerpg.api.java.divinerpg.api.armorNew;


import divinerpg.api.java.divinerpg.api.DivineAPI;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber()
public class ArmorMapEvents {
    private static final Map<Side, HashMap<EntityPlayer, ArmorObserver>> playerMap = new HashMap<>();

    public static Map<EntityPlayer, ArmorObserver> getCurrentMap() {
        return playerMap.computeIfAbsent(FMLCommonHandler.instance().getEffectiveSide(), key -> new HashMap<>());
    }

    @SubscribeEvent
    public static void onLogin(PlayerEvent.PlayerLoggedInEvent event) {
        Map<EntityPlayer, ArmorObserver> map = getCurrentMap();
        map.computeIfAbsent(event.player, player -> new ArmorObserver(player, DivineAPI.getPowerSetRegistry().getValuesCollection()));
    }

    /**
     * Removing leaving player from map
     */
    @SubscribeEvent
    public static void onPlayerLeave(PlayerEvent.PlayerLoggedOutEvent e) {
        getCurrentMap().remove(e.player);
    }
}
