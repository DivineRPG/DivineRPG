package net.divinerpg.helper.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.divinerpg.helper.Util;
import net.divinerpg.helper.config.ConfigurationHelper;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class EventStaffLogin {
	
	private boolean canShow = true;
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onStaffJoin(EntityJoinWorldEvent e) {
		if (canShow) {
			Util.sendMessageToAll("A DivineRPG devolper has entered!");
			canShow = false;
		}
	}
	

}
