package divinerpg.utils.log;

import divinerpg.DivineRPG;
import divinerpg.api.Reference;
import divinerpg.config.GeneralConfig;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PreInitLog {

    @SideOnly(Side.CLIENT)
	public static void init() {
		if(GeneralConfig.generalOptions.debugMode == true) {
	        DivineRPG.logger.info(Reference.MODID + " is now loading");}
	    if(Loader.isModLoaded("p455w0rdslib")) {
	    	DivineRPG.logger.info("O.o its TheRealP455w0rd's mods");
	    }
	}
}
