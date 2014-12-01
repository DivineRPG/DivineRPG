package net.divinerpg.utils.events;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelChest;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class DevHatEvent {
	
	@SubscribeEvent
	public void playerRender(RenderPlayerEvent.Pre evt) {
		if(isDeveloperName(evt.entityPlayer.getCommandSenderName())) {
			GL11.glPushMatrix();
			GL11.glRotatef(-evt.entityPlayer.rotationYaw, 0, 1, 0);
			GL11.glRotatef((evt.renderer.modelBipedMain.bipedHead.rotateAngleX)*57.2957795f*Math.signum((evt.entityPlayer.rotationYaw%360)), 1, 0, 0);
			GL11.glTranslatef(-0.45f, 0.4f, -0.45f);
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("divinerpg:textures/model/devhat.png"));
			new ModelHat().renderAll();
			GL11.glPopMatrix();
		}
	}

	public static boolean isDeveloperName(String name) {
		return name == "Doomturd" || name == "XolovA" || name == "geekclb" || name == "sheenrox82"; //TODO: add more people.
	}
}
