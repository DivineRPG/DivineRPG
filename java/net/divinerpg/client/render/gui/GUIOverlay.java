package net.divinerpg.client.render.gui;

import net.divinerpg.api.entity.DivineBossStatus;
import net.divinerpg.api.entity.EntityStats;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.events.EventArmorFullSet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

public class GUIOverlay {

	public void drawOverlay() {
		String text = Reference.MOD_NAME + ": " + Reference.MOD_VERSION;
		if(ConfigurationHelper.canShowIngameVersion){
			//BROCK NO
			Minecraft.getMinecraft().fontRenderer.drawString(EnumChatFormatting.AQUA + text, 2, 2, 4210752);
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
