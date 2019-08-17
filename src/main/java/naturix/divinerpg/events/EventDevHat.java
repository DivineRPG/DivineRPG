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
	public void playerRender(RenderPlayerEvent.Post evt) {
//	if(Utils.isDeveloperName(evt.getEntityPlayer().getDisplayName())) {
	GL11.glPushMatrix();
	float height = evt.getEntity().height;
	GL11.glTranslatef(-0.5f, height, -0.5f);
	Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("divinerpg:textures/model/devhats/hat_red.png"));
	GL11.glPopMatrix();
	}
}
