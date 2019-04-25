package naturix.divinerpg.utils.log;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.utils.Reference;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PostInitLog {

    @SideOnly(Side.CLIENT)
	public static void init() {
		if(Config.debug == true) {
	        DivineRPG.logger.info(Reference.MODID + " has just finished loading");
		}
	}
}
