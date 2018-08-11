package naturix.divinerpg.utils.log;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import net.minecraftforge.fml.common.Loader;

public class PreInitLog {
	public static void init() {
		
		
		
		if(Config.debug == true) {
	        DivineRPG.logger.info(DivineRPG.name + " is now loading");}
	    if(Loader.isModLoaded("p455w0rdslib")) {
	    	DivineRPG.logger.info("O.o its TheRealP455w0rd's mods");
	        }
	}
}
