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
import org.lwjgl.opengl.GL11;

@Mod.EventBusSubscriber(modid = Reference.MODID, value = Side.CLIENT)
	public class EventDevHat {
		
	private static ModelHat hat = new ModelHat();
	
    //Added by Dash/Oshi41
	@SubscribeEvent
	public void playerRender(RenderPlayerEvent.Specials.Pre evt) {		public void playerRender(RenderPlayerEvent.Post evt) {
		if(Utils.isDeveloperName(evt.getEntityPlayer().getDisplayName())) {	//		if(Utils.isDeveloperName(evt.getEntityPlayer().getDisplayName())) {
			GL11.glPushMatrix();				GL11.glPushMatrix();
			evt.getRenderer().getMainModel().bipedHead.postRender(0.0625f);				float height = evt.getEntity().height;
			GL11.glRotatef(180, 0, 0, 1);				GL11.glTranslatef(-0.5f, height, -0.5f);
			GL11.glTranslatef(-0.5f, 0.5f, -0.5f);				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("divinerpg:textures/model/devhats/hat_red.png"));
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("divinerpg:textures/model/devhat.png"));	
			hat.renderAll();				hat.renderAll();
			GL11.glPopMatrix();				GL11.glPopMatrix();
		}	//		}
	}		}
}
