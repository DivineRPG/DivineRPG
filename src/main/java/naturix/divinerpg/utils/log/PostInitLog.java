package naturix.divinerpg.utils.log;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.items.ItemBase;

public class PostInitLog {
	public static void init() {
		if(Config.debug == true) {
	        DivineRPG.logger.info(DivineRPG.name + " has just finished loading");
	        
	        	    }
	}
}
