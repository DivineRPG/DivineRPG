package net.divinerpg.client;

import net.divinerpg.libs.Reference;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.events.ArcanaHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;

public class ArcanaRenderer {
	
	Minecraft mc = Minecraft.getMinecraft();
	
	public static float value;
	public static boolean regen;
	
	@SubscribeEvent
	public void onRender(RenderTickEvent event){
		onTickRender();
	}

	private void onTickRender() {
		ConfigurationHelper cfg = new ConfigurationHelper();
		if(mc.currentScreen == null) {
			GuiIngame gig = mc.ingameGUI;
			ScaledResolution scaledresolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
			int i = scaledresolution.getScaledWidth();
			int k = scaledresolution.getScaledHeight();
			this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/arcanaBar.png"));
			int y = k - cfg.arcanaY;
			int x = i - cfg.arcanaX;
			gig.drawTexturedModalRect(x, y, 0, 0, 100, 9);
			gig.drawTexturedModalRect(x, y, 0, 9, (int)(12.5 * (value / 25)), 18);  
		}
	}

}
