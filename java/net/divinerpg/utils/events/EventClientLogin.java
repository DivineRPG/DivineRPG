package net.divinerpg.utils.events;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import net.divinerpg.libs.Reference;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EventClientLogin {
	
	boolean seen = false;

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onPlayerLogin(EntityJoinWorldEvent e) {
		if (e.entity instanceof EntityPlayer) {
			EntityPlayer p = (EntityPlayer)e.entity;
			if (!p.worldObj.isRemote && !seen) {
				try {
					if(!UpdateChecker.isOnline() && !ConfigurationHelper.canShowOverlay){
						if(Util.isDeveloperName(p.getCommandSenderName())) {
							p.addChatMessage(Util.getChatComponent(Util.AQUA + "Welcome DivineRPG developer!"));
						} else {
							p.addChatMessage(Util.addChatMessage(EnumChatFormatting.AQUA, "Thank you " + p.getDisplayName() + ", for downloading and playing" + Util.GREEN + " DivineRPG!"));
						}
						p.addChatMessage(Util.addChatMessage(EnumChatFormatting.LIGHT_PURPLE, "Unable to check for latest version, you may want to check your internet connection!"));
					}
					else if(UpdateChecker.isUpdateAvailable() && !ConfigurationHelper.canShowOverlay) {
						p.addChatMessage(Util.addChatMessage(EnumChatFormatting.AQUA, "Thank you " + p.getDisplayName() + ", for downloading and playing" + Util.GREEN + " DivineRPG!"));
						p.addChatMessage(Util.addChatMessage(EnumChatFormatting.RED, "A DivineRPG update is avaliable."));
						p.addChatMessage(Util.addChatMessage(EnumChatFormatting.RED, "[New Version: " + UpdateChecker.getCurrentVersion() + "]")); 
					}
					else {
						p.addChatMessage(Util.addChatMessage(EnumChatFormatting.AQUA, "Thank you "  + p.getDisplayName() + ", for downloading and playing" + Util.GREEN + " DivineRPG!"));
					}
					seen = true;
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	} 
}