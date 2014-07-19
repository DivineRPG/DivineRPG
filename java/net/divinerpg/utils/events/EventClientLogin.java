package net.divinerpg.utils.events;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import net.divinerpg.client.ArcanaHelper;
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

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onPlayerLogin(EntityJoinWorldEvent e) {

		if (e.entity instanceof EntityPlayer) {
			EntityPlayer p = (EntityPlayer) e.entity;
			if (p.worldObj.isRemote) {
				if(!hasSeen) {
					try {
						if(!UpdateChecker.isOnline()){
							if(p.getDisplayName().equals("sheenrox82") || p.getDisplayName().equals("XolovA") || p.getDisplayName().equalsIgnoreCase("Instanity414all")) {
								p.addChatMessage(Util.addChatMessage(EnumChatFormatting.DARK_PURPLE, "Wait, your actually playing DivineRPG?!"));
								p.addChatMessage(Util.addChatMessage(EnumChatFormatting.LIGHT_PURPLE, "Turn your internets on noob."));
							}
							else if(p.getDisplayName().equals("deathman12e3") || p.getDisplayName().equals("The_SlayerMC") || p.getDisplayName().equals("Mazetar")
									|| p.getDisplayName().equals("itzakillshot") || p.getDisplayName().equals("geekclb")) {
								p.addChatMessage(Util.addChatMessage("Welcome DivineRPG developer!"));
								p.addChatMessage(Util.addChatMessage(EnumChatFormatting.LIGHT_PURPLE, "Your internet crashed from how awesome you are."));
							} else {
								p.addChatMessage(Util.addChatMessage(EnumChatFormatting.AQUA, "Thank you " + p.getDisplayName() + ", for downloading and playing" + Util.GREEN + " DivineRPG!"));
								p.addChatMessage(Util.addChatMessage(EnumChatFormatting.AQUA, "[Version: " + Reference.MOD_VERSION + "]"));
								p.addChatMessage(Util.addChatMessage(EnumChatFormatting.LIGHT_PURPLE, "Unable to check for latest version, you may want to check your internet connection!"));
							}
						}
						if(UpdateChecker.isUpdateAvailable() && UpdateChecker.isOnline()) {
							if(p.getDisplayName().equals("sheenrox82") || p.getDisplayName().equals("XolovA") || p.getDisplayName().equals("Instanity414all")) {
								p.addChatMessage(Util.addChatMessage(EnumChatFormatting.DARK_PURPLE, "Wait, your actually playing DivineRPG?!"));
								p.addChatMessage(Util.addChatMessage(EnumChatFormatting.YELLOW, "By the way your using a outdated version."));
							}
							else if(p.getDisplayName().equals("deathman12e3") || p.getDisplayName().equals("The_SlayerMC") || p.getDisplayName().equals("Mazetar")
									|| p.getDisplayName().equals("itzakillshot") || p.getDisplayName().equals("geekclb")) {
								Util.sendMessageToAll("A DivineRPG devolper has entered!");
								p.addChatMessage(Util.addChatMessage(EnumChatFormatting.YELLOW, "Wow, you don't even have the newest version of your own mod."));
							} else {
								BufferedReader versionFile = new BufferedReader(new InputStreamReader(new URL("https://raw.github.com/TheSlayerMC/DivineRPG/master/Version.txt").openStream()));
								String curVersion = versionFile.readLine();
								p.addChatMessage(Util.addChatMessage(EnumChatFormatting.AQUA, "Thank you " + p.getDisplayName() + ", for downloading and playing" + Util.GREEN + " DivineRPG!"));
								p.addChatMessage(Util.addChatMessage(EnumChatFormatting.RED, "[Version: " + Reference.MOD_VERSION + "]"));
								p.addChatMessage(Util.addChatMessage(EnumChatFormatting.YELLOW, "A DivineRPG update is avaliable."));
								p.addChatMessage(Util.addChatMessage(EnumChatFormatting.YELLOW, "[New Version: " + curVersion + "]")); 
							}
						}
						if((!UpdateChecker.isUpdateAvailable()) && UpdateChecker.isOnline()) {
							if(p.getDisplayName().contains("sheenrox82") || p.getDisplayName().equals("XolovA") || p.getDisplayName().equals("Instanity414all")) {
								p.addChatMessage(Util.addChatMessage(EnumChatFormatting.DARK_PURPLE, "Wait, your actually playing DivineRPG?!"));
							}
							else if(p.getDisplayName().equals("deathman12e3") || p.getDisplayName().equals("The_SlayerMC") || p.getDisplayName().equals("Mazetar")
									|| p.getDisplayName().equals("itzakillshot") || p.getDisplayName().equals("geekclb")) {
								Util.sendMessageToAll("A DivineRPG devolper has entered!");
							} else {
								p.addChatMessage(Util.addChatMessage(EnumChatFormatting.AQUA, "Thank you "  + p.getDisplayName() + ", for downloading and playing" + Util.GREEN + " DivineRPG!"));
								p.addChatMessage(Util.addChatMessage(EnumChatFormatting.AQUA, "[Version: " + Reference.MOD_VERSION + "]"));
								p.addChatMessage(Util.addChatMessage(EnumChatFormatting.GREEN, "DivineRPG is up to date."));
							}
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