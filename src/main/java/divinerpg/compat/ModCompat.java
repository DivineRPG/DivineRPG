package divinerpg.compat;

import net.minecraftforge.fml.*;
import net.minecraftforge.fml.event.lifecycle.*;

public class ModCompat {
    public static void initCommon(FMLCommonSetupEvent e){
        if(ModList.get().isLoaded("jeresources")){
            JERCompat.init(e);
        }
        if(ModList.get().isLoaded("projecte")){
            ProjectECompat.init();
        }
    }
}
