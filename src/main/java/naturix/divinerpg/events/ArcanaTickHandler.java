package naturix.divinerpg.events;

import naturix.divinerpg.capabilities.ArcanaProvider;
import naturix.divinerpg.capabilities.IArcana;
import naturix.divinerpg.utils.Utils;
import naturix.divinerpg.utils.log.Logging;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class ArcanaTickHandler {
	IArcana arcana;
	@SubscribeEvent
	public void onTick(PlayerTickEvent event){
		arcana = event.player.getCapability(ArcanaProvider.ARCANA_CAP, null);
		if(event.phase == Phase.START){
			onTickStart(event.player);
		} else {
			onTickEnd(event.player);
		}
	}

	private void onTickEnd(EntityPlayer player) {
		arcana = player.getCapability(ArcanaProvider.ARCANA_CAP, null);
		arcana.updateAllBars();
	}

	private void onTickStart(EntityPlayer player) {
		arcana = player.getCapability(ArcanaProvider.ARCANA_CAP, null);
	}

	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event){ 
		arcana = event.player.getCapability(ArcanaProvider.ARCANA_CAP, null);
		arcana.set(0);
		
		Utils.DEV_LIST.add("RadioactiveStud");
		Utils.DEV_LIST.add("Eternaldoom1");
		Utils.DEV_LIST.add("BossLetsPlays");
		Utils.DEV_LIST.add("Xolova");
		Utils.DEV_LIST.add("sheenrox82");
		Utils.DEV_LIST.add("The_SlayerMC");
		Utils.DEV_LIST.add("insanity414all");
		Utils.DEV_LIST.add("deathman12e3");
		Utils.DEV_LIST.add("Fire_Sight");
		Utils.DEV_LIST.add("krwminer");
		Utils.DEV_LIST.add("NicosaurusRex99");
		Utils.DEV_LIST.add("LiteWolf101");
		
		
	}

	@SubscribeEvent
	public void onPlayerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event){ 
		arcana = event.player.getCapability(ArcanaProvider.ARCANA_CAP, null);
		arcana.set(0);
	}

	@SubscribeEvent
	public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event){ 
		arcana = event.player.getCapability(ArcanaProvider.ARCANA_CAP, null);
		arcana.set(200);
	}
	
	@SubscribeEvent
	public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event){
		arcana = event.player.getCapability(ArcanaProvider.ARCANA_CAP, null);
		arcana.set(200);
		
		event.player.addExperienceLevel(0);
	}
}
