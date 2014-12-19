package net.divinerpg.client.render.gui;

import java.io.IOException;
import java.net.SocketException;

import org.lwjgl.opengl.GL11;

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
	private String text = "";
	private String text2 = "";
	private boolean seen = false;
	private ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);

	public void drawOverlay() {
		if(!seen) {
			try {
				text = Reference.MOD_NAME + " " + Util.GREEN + Reference.MOD_VERSION;
				if(!UpdateChecker.isOnline()) {
					text2 = Util.DARK_PURPLE + "Offline";
				}
				else if(UpdateChecker.isUpdateAvailable()) {
					text2 = Util.BLUE + "DivineRPG: " + Util.DARK_RED + "Update Availble (" + UpdateChecker.getCurrentVersion() + ")";
				}
				else {
					text2 = "";
				}
			}
			catch (SocketException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			seen = true;
		}
		
		GL11.glDisable(GL11.GL_BLEND);
		
		if(Minecraft.getMinecraft().gameSettings.showDebugInfo) {
			Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(EnumChatFormatting.BLUE + text, 2, res.getScaledHeight()-117, 4210752);
		} else if(!Minecraft.getMinecraft().gameSettings.showDebugInfo) {
			Minecraft.getMinecraft().fontRenderer.drawString(text2, 2, 2, 4210752);
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
