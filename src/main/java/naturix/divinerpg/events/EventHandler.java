package naturix.divinerpg.events;

import naturix.divinerpg.capabilities.ArcanaProvider;
import naturix.divinerpg.capabilities.IArcana;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class EventHandler
{
	@SubscribeEvent
	public void onTick(PlayerTickEvent event){
		if(event.phase == Phase.START && event.player.world.isRemote){
			onTickStart(event.player);
		} else {
			onTickEnd(event.player);
		}
	}

	private void onTickEnd(EntityPlayer player) {
		if(player.world.isRemote) {
			
		IArcana arcana = player.getCapability(ArcanaProvider.ARCANA_CAP, null);
        arcana.getArcana();
		}
	}

	private void onTickStart(EntityPlayer player) { }

	@SubscribeEvent
	public void onPlayerLoggedIn(EntityJoinWorldEvent event){ 
		if(event.getWorld().isRemote && event.getEntity() instanceof EntityPlayer) {
		IArcana arcana = event.getEntity().getCapability(ArcanaProvider.ARCANA_CAP, null);
        arcana.set(0);
		}
	}
	@SubscribeEvent
	public void onPlayerRespawn(PlayerEvent.Clone evt){ 
		IArcana arcana = evt.getEntityPlayer().getCapability(ArcanaProvider.ARCANA_CAP, null);
        arcana.set(200);
	}
	
	@SubscribeEvent
	public void onPlayerChangedDimension(EntityTravelToDimensionEvent event){
		IArcana arcana = event.getEntity().getCapability(ArcanaProvider.ARCANA_CAP, null);
        arcana.set(200);
	}
}