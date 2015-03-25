package net.divinerpg.utils.events;

import java.io.IOException;

import net.divinerpg.utils.MessageLocalizer;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class EventClientLogin {
	
	@SubscribeEvent
	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent evt) {
			EntityPlayer p = evt.player;
			if (!p.worldObj.isRemote) {
				try {
					if(!UpdateChecker.isOnline() && !ConfigurationHelper.canShowOverlay){
						if(Util.isDeveloperName(p.getCommandSenderName())) {
							p.addChatMessage(Util.getChatComponent(MessageLocalizer.developer()));
						} else {
							p.addChatMessage(Util.addChatMessage(EnumChatFormatting.AQUA, MessageLocalizer.standard(p.getDisplayName())));
						}
						p.addChatMessage(Util.addChatMessage(EnumChatFormatting.LIGHT_PURPLE, MessageLocalizer.internet()));
					}
					else if(UpdateChecker.isUpdateAvailable() && !ConfigurationHelper.canShowOverlay) {
						p.addChatMessage(Util.addChatMessage(EnumChatFormatting.AQUA, MessageLocalizer.standard(p.getDisplayName())));
						p.addChatMessage(Util.addChatMessage(EnumChatFormatting.RED, MessageLocalizer.update()));
						p.addChatMessage(Util.addChatMessage(EnumChatFormatting.RED, MessageLocalizer.version(UpdateChecker.getCurrentVersion()))); 
					}
					else {
						p.addChatMessage(Util.addChatMessage(EnumChatFormatting.AQUA, MessageLocalizer.standard(p.getDisplayName())));
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		} 
}