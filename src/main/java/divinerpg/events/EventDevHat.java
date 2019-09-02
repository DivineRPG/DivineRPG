package divinerpg.events;

import divinerpg.Reference;
import divinerpg.objects.entities.assets.model.ModelHat;
import divinerpg.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.lwjgl.opengl.GL11;

@Mod.EventBusSubscriber(modid = Reference.MODID, value = Side.CLIENT)
	public class EventDevHat {
		
	private ModelHat hat = new ModelHat();
	
	@SubscribeEvent
	public void playerRender(RenderPlayerEvent.Post evt) {
		EntityPlayer player = evt.getEntityPlayer();

		if (Utils.isDeveloperName(player.getDisplayNameString())) {
			GL11.glPushMatrix();
			// rotating hat
			GL11.glRotated(-player.rotationYaw, 0,1,0);

			// removing empty space if sneaking. If there are smth like
			// smart moving - we are have problems here
			float height = player.height;
			if (player.isSneaking()){
				height -= 0.3;
			}
			GL11.glTranslatef(-0.5f, height, -0.5f);
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("divinerpg:textures/model/devhats/hat_red.png"));
			hat.renderAll();
			GL11.glPopMatrix();
		}
	}
}
