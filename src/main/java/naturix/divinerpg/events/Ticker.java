package naturix.divinerpg.events;

import naturix.divinerpg.DivineRPG;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.ServerTickEvent;

public class Ticker {
	
	public static int tick;
	
	@SubscribeEvent
	public void tickServer(ServerTickEvent evt) {
		if(evt.phase == Phase.END) {
			tick++;
			if(tick>100000) tick = 0;
		}
		
		

	}

}