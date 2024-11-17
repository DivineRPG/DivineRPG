package net.divinerpg.utils.events;

import net.divinerpg.utils.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class DevHatEvent {
	
	private static ModelHat hat = new ModelHat();
	
	@SubscribeEvent
	public void playerRender(RenderPlayerEvent.Specials.Pre evt) {
		if(Util.isDeveloperName(evt.entityPlayer.getCommandSenderName())) {
			GL11.glPushMatrix();
			evt.renderer.modelBipedMain.bipedHead.postRender(0.0625f);
			GL11.glRotatef(180, 0, 0, 1);
			GL11.glTranslatef(-0.5f, 0.5f, -0.5f);
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("divinerpg:textures/model/devhat.png"));
			hat.renderAll();
			GL11.glPopMatrix();
		}
	}
}