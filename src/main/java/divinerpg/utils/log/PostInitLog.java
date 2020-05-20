package divinerpg.utils.log;

import divinerpg.DivineRPG;
import divinerpg.api.Reference;
import divinerpg.config.GeneralConfig;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PostInitLog {

    @SideOnly(Side.CLIENT)
	public static void init() {
		if(GeneralConfig.generalOptions.debugMode == true) {
	        DivineRPG.logger.info(Reference.MODID + " has just finished loading");
		}
	}
}
