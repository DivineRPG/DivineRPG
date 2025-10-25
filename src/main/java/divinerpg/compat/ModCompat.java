package divinerpg.compat;

import divinerpg.compat.projecte.ProjectECompat;
import divinerpg.compat.jei.JERCompat;
import net.neoforged.fml.ModList;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

import static divinerpg.DivineRPG.LOGGER;

public class ModCompat {
    public static void initCommon(FMLCommonSetupEvent e) {
        if(ModList.get().isLoaded("jeresources")) JERCompat.init();
        if(ModList.get().isLoaded("aoa3")) LOGGER.info("The Divine Ascension");
        if(ModList.get().isLoaded("aztech")) LOGGER.info("Together we thrive!");
        if(ModList.get().isLoaded("journey")) LOGGER.info("Journey into the Divine");
        if(ModList.get().isLoaded("projecte")) ProjectECompat.init();
    }
}