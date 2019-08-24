package divinerpg.utils.log;

import divinerpg.Config;
import divinerpg.DivineRPG;
import divinerpg.Reference;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class InitLog {
    

    @SideOnly(Side.CLIENT)
	public static void init() {
		if(Config.debug == true) {
        	DivineRPG.logger.info(Reference.MODID + " is almost loaded");
        }
	}
}
