package net.divinerpg.utils.events;

import java.net.SocketException;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class EventStaffLogin {
	
	private boolean canShow = true;
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onStaffJoin(EntityJoinWorldEvent event) {
		if (canShow) {
			try {
				if(UpdateChecker.isOnline())
					Util.sendMessageToAll("A DivineRPG devolper has entered!");
			} catch (SocketException e) {
				e.printStackTrace();
			}
			canShow = false;
		}
	}
	

}
