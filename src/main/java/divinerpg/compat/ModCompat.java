package divinerpg.compat;

import divinerpg.DivineRPG;
//import divinerpg.compat.jei.JERCompat;
//import divinerpg.compat.projecte.ProjectECompat;
import net.neoforged.fml.ModList;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

public class ModCompat {
    public static void initCommon(FMLCommonSetupEvent e){
//        if(ModList.get().isLoaded("jeresources")){
//            JERCompat.init();
//        }
//        if(ModList.get().isLoaded("projecte")){
//            ProjectECompat.init();
//        }
        if(ModList.get().isLoaded("aztech")){
            DivineRPG.LOGGER.info("Together we thrive!");
        }
        if(ModList.get().isLoaded("aoa3")){
            DivineRPG.LOGGER.info("The Divine Ascension");
        }
        if(ModList.get().isLoaded("journey")){
            DivineRPG.LOGGER.info("Journey into the Divine");
        }
    }
}