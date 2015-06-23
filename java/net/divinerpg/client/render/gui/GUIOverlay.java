package net.divinerpg.client.render.gui;

import java.io.IOException;
import java.net.SocketException;

import net.divinerpg.libs.Reference;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.events.EventArmorTick;
import net.divinerpg.utils.events.UpdateChecker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GUIOverlay {
	private String text = "";
	private String text2 = "";
	private boolean seen = false;
	private ScaledResolution res;

	public void drawOverlay() {
		res = new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
		if(!seen) {
			try {
				text = Reference.MOD_NAME + " " + Util.GREEN + Reference.MOD_VERSION;
				if(!UpdateChecker.isOnline()) {
					text2 = Util.DARK_PURPLE + "Offline";
				}
				else if(UpdateChecker.isUpdateAvailable()) {
					text2 = Util.DARK_BLUE + "DivineRPG: " + Util.DARK_RED + "Update Available (" + UpdateChecker.getCurrentVersion() + ")";
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
			Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(EnumChatFormatting.DARK_BLUE + text, 2, res.getScaledHeight()-10, 4210752);
		} else if(!Minecraft.getMinecraft().gameSettings.showDebugInfo) {
			Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(text2, 2, 2, 4210752);
		}
	}
	
	private static final ResourceLocation r = new ResourceLocation(Reference.PREFIX + "textures/gui/armorBar.png");;
	public void drawArmor() {
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		res = new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
		int x = (res.getScaledWidth() / 2) - 11;
		int y = res.getScaledHeight() - 49;
        
		switch(EventArmorTick.size) {
		case 1:
			Minecraft.getMinecraft().getTextureManager().bindTexture(r);
			Util.drawTexturedModalRect(x, y, 0, 0, 9, 9);
			break;
		case 2: //Not used. Here if we need it.
			Minecraft.getMinecraft().getTextureManager().bindTexture(r);
			Util.drawTexturedModalRect(x, y, 9, 0, 18, 9);
			break;
		}
	}
}
