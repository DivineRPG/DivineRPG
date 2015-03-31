package net.divinerpg.utils.events;

import net.divinerpg.client.ArcanaRenderer;
import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;

public class ClientTicker {
	
	public static int tick;
	
	@SubscribeEvent
	public void tickClient(ClientTickEvent evt) {
		if(evt.phase == Phase.END) {
			tick++;
			if(ArcanaRenderer.regen && ArcanaRenderer.value < 200 && Minecraft.getMinecraft().currentScreen == null) ArcanaRenderer.value++;
		}
	}

}
