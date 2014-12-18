package net.divinerpg.utils.events;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import net.divinerpg.libs.Reference;
import net.divinerpg.utils.Util;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EventClientLogin {

	public boolean hasSeen = false;

	@SubscribeEvent
	public void onPlayerLogin(EntityJoinWorldEvent e) {
		if (e.entity instanceof EntityPlayer) {
			EntityPlayer p = (EntityPlayer)e.entity;
			if (!p.worldObj.isRemote) {
				if(!hasSeen) {
					try {
						if(!UpdateChecker.isOnline()){
							if(Util.isDeveloperName(p.getCommandSenderName())) {
								p.addChatMessage(Util.getChatComponent("Welcome DivineRPG developer!"));
							} else {
								p.addChatMessage(Util.addChatMessage(EnumChatFormatting.AQUA, "Thank you " + p.getDisplayName() + ", for downloading and playing" + Util.GREEN + " DivineRPG!"));
							}
							p.addChatMessage(Util.addChatMessage(EnumChatFormatting.LIGHT_PURPLE, "Unable to check for latest version, you may want to check your internet connection!"));
						}
						if(UpdateChecker.isUpdateAvailable() && UpdateChecker.isOnline()) {
							if(Util.isDeveloperName(p.getCommandSenderName())) {
								Util.sendMessageToAll("A DivineRPG developer has entered!");
							}
							BufferedReader versionFile = new BufferedReader(new InputStreamReader(new URL("https://raw.github.com/DivineRPG/DivineRPG/master/Version.txt").openStream()));
							String curVersion = versionFile.readLine();
							p.addChatMessage(Util.addChatMessage(EnumChatFormatting.AQUA, "Thank you " + p.getDisplayName() + ", for downloading and playing" + Util.GREEN + " DivineRPG!"));
							p.addChatMessage(Util.addChatMessage(EnumChatFormatting.RED, "A DivineRPG update is avaliable."));
							p.addChatMessage(Util.addChatMessage(EnumChatFormatting.RED, "[New Version: " + curVersion + "]")); 
						}
						if((!UpdateChecker.isUpdateAvailable()) && UpdateChecker.isOnline()) {
							if(Util.isDeveloperName(p.getCommandSenderName())) {
								Util.sendMessageToAll("A DivineRPG developer has entered!");
							}
							p.addChatMessage(Util.addChatMessage(EnumChatFormatting.AQUA, "Thank you "  + p.getDisplayName() + ", for downloading and playing" + Util.GREEN + " DivineRPG!"));
						}
					} catch (MalformedURLException e1) {
						e1.printStackTrace();

					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				hasSeen = true;
			}
		}
	} 
}