package net.divinerpg.client.render.gui;

import java.io.IOException;
import java.net.SocketException;

import net.divinerpg.libs.Reference;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.events.EventArmorFullSet;
import net.divinerpg.utils.events.UpdateChecker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

public class GUIOverlay {

	public void drawOverlay() {
		String text;
		
		if(ConfigurationHelper.canShowIngameVersion){
			try {
				if(!UpdateChecker.isOnline()) {
					text = Reference.MOD_NAME + ": " + Util.DARK_PURPLE + Reference.MOD_VERSION;
					Minecraft.getMinecraft().fontRenderer.drawString(EnumChatFormatting.DARK_BLUE + text, 2, 2, 4210752);
					Minecraft.getMinecraft().fontRenderer.drawString(EnumChatFormatting.DARK_PURPLE + "Offline", 2, 12, 4210752);
				}
				else if(UpdateChecker.isUpdateAvailable()) {
					text = Reference.MOD_NAME + ": " + Util.DARK_RED + Reference.MOD_VERSION;
					Minecraft.getMinecraft().fontRenderer.drawString(EnumChatFormatting.DARK_BLUE + text, 2, 2, 4210752);
					Minecraft.getMinecraft().fontRenderer.drawString(EnumChatFormatting.DARK_RED + "Update Availble", 2, 12, 4210752);
				}
				else {
					text = Reference.MOD_NAME + ": " + Util.GREEN + Reference.MOD_VERSION;
					Minecraft.getMinecraft().fontRenderer.drawString(EnumChatFormatting.DARK_BLUE + text, 2, 2, 4210752);
				}
			} catch (SocketException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void drawArmor() {
		ResourceLocation r = null;
		switch(EventArmorFullSet.size) {
		case 1:
			System.out.println("LOL");
			r = set("half");
			Minecraft mc = Minecraft.getMinecraft();
			ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
			int x = sr.getScaledWidth() - 225;
			int y = sr.getScaledHeight() - 50;
			mc.getTextureManager().bindTexture(r);
			Util.drawTexturedModalRect(x, y, 5, 5, 9, 9);
			break;
		}
	}

	public ResourceLocation set(String size){
		return new ResourceLocation(Reference.PREFIX + "textures/gui/arcanaBar.png");
	}
}
