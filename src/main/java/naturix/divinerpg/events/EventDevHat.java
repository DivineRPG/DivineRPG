package naturix.divinerpg.events;

import naturix.divinerpg.objects.entities.assets.model.ModelHat;
import naturix.divinerpg.utils.Reference;
import naturix.divinerpg.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@Mod.EventBusSubscriber(modid = Reference.MODID, value = Side.CLIENT)
	public class EventDevHat {
		
	private static ModelHat hat = new ModelHat();
	
	@SubscribeEvent
	public void playerRender(RenderPlayerEvent.Specials.Pre evt) {
		if(Utils.isDeveloperName(evt.getEntityPlayer().getDisplayName())) {
			GL11.glPushMatrix();
			evt.getRenderer().getMainModel().bipedHead.postRender(0.0625f);
			GL11.glRotatef(180, 0, 0, 1);
			GL11.glTranslatef(-0.5f, 0.5f, -0.5f);
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("divinerpg:textures/model/devhat.png"));
			hat.renderAll();
			GL11.glPopMatrix();
		}
	}
}
