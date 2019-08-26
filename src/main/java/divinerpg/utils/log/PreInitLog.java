package divinerpg.utils.log;

import divinerpg.Config;
import divinerpg.DivineRPG;
import divinerpg.Reference;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PreInitLog {

    @SideOnly(Side.CLIENT)
	public static void init() {
		DivineRPG.logger.info("RadioactiveStud, Eternaldoom1, BossLetsPlays, Xolova, sheenrox82, The_SlayerMC, insanity414all, deathman12e3, Fire_Sight, LiteWolf101, krwminer and NicosaurusRex99 are the DivineRPG dev team!");
		
		if(Config.debug == true) {
	        DivineRPG.logger.info(Reference.MODID + " is now loading");}
	    if(Loader.isModLoaded("p455w0rdslib")) {
	    	DivineRPG.logger.info("O.o its TheRealP455w0rd's mods");
	        }
	}
}
