package divinerpg.compat;

import divinerpg.compat.jei.JERCompat;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;

import static divinerpg.DivineRPG.LOGGER;

@EventBusSubscriber
public class ModCompat {

    @SubscribeEvent
    public static void initCommon(FMLCommonSetupEvent e) {
        if(ModList.get().isLoaded("aoa3")) LOGGER.info("The Divine Ascension");
        if(ModList.get().isLoaded("aztech")) LOGGER.info("Together we thrive!");
        if(ModList.get().isLoaded("journey")) LOGGER.info("Journey into the Divine");
    }

    @SubscribeEvent
    public static void onServerAboutToStart(ServerAboutToStartEvent e) {
        if (ModList.get().isLoaded("jeresources")) {
            JERCompat.init();
        }
    }
}