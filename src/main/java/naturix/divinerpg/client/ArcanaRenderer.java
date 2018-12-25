package naturix.divinerpg.client;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;

public class ArcanaRenderer {
	
	Minecraft mc = Minecraft.getMinecraft();
	
	public static float value;
	public static boolean regen;
	
	@SubscribeEvent
	public void onRender(RenderTickEvent event){
		onTickRender();
	}

	private void onTickRender() {
		Config cfg = new Config();
		if(mc.currentScreen == null) {
			GuiIngame gig = mc.ingameGUI;
			ScaledResolution scaledresolution = new ScaledResolution(mc);
			int i = scaledresolution.getScaledWidth();
			int k = scaledresolution.getScaledHeight();
			this.mc.getTextureManager().bindTexture(new ResourceLocation(DivineRPG.modId, "textures/gui/bar_arcana.png"));
			int y = k - cfg.arcanaY;
			int x = i - cfg.arcanaX;
			gig.drawTexturedModalRect(x, y, 0, 0, 100, 9);
			gig.drawTexturedModalRect(x, y, 0, 9, (int)(12.5 * (value / 25)), 18);  
		}
	}

}
