package naturix.divinerpg.utils.log;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;

public class InitLog {
	public static void init() {
		if(Config.debug == true) {
        	DivineRPG.logger.info(DivineRPG.name + " is almost loaded");
        }
	}
}
