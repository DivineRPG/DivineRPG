package divinerpg.utils.log;

import divinerpg.DivineRPG;
import divinerpg.api.Reference;
import divinerpg.config.Config;
import divinerpg.config.MainConfig;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class InitLog {
    

    @SideOnly(Side.CLIENT)
	public static void init() {
		if(MainConfig.debugMode == true) {
        	DivineRPG.logger.info(Reference.MODID + " is almost loaded");
        }
	}
}
