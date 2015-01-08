package net.divinerpg.utils.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.ServerTickEvent;
import cpw.mods.fml.relauncher.Side;

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
