package naturix.divinerpg.utils.log;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.utils.Reference;

public class InitLog {
	public static void init() {
		if(Config.debug == true) {
        	DivineRPG.logger.info(Reference.MODID + " is almost loaded");
        }
	}
}
