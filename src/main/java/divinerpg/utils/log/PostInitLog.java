package divinerpg.utils.log;

import divinerpg.Config;
import divinerpg.DivineRPG;
import divinerpg.Reference;
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
