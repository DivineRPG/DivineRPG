package divinerpg.compat;

import divinerpg.*;
import divinerpg.compat.jei.JERCompat;
//import divinerpg.compat.projecte.ProjectECompat;
import net.minecraftforge.fml.*;
import net.minecraftforge.fml.event.lifecycle.*;

public class ModCompat {
    public static void initCommon(FMLCommonSetupEvent e){
        if(ModList.get().isLoaded("jeresources")){
            JERCompat.init();
        }
        if(ModList.get().isLoaded("projecte")){
//            ProjectECompat.init();
        }
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
