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
	
	private static ModelHat hat = new ModelHat();
	
	@SubscribeEvent
	public void playerRender(RenderPlayerEvent.Pre evt) {
		if(isDeveloperName(evt.entityPlayer.getCommandSenderName())) {
			GL11.glPushMatrix();
			GL11.glRotatef(-evt.entityPlayer.rotationYawHead, 0, 1, 0);
			GL11.glTranslatef(0f, -0.1f, 0f);
			GL11.glRotatef(evt.entityPlayer.rotationPitch, 1, 0, 0);
			GL11.glTranslatef(-0.5f, 0.1f, -0.5f);
			GL11.glTranslatef(0f, 0.2f, 0f);
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("divinerpg:textures/model/devhat.png"));
			hat.renderAll();
			GL11.glPopMatrix();
		}
	}

	public static boolean isDeveloperName(String name) {
		return name.equals("Doomturd") || name.equals("XolovA") || name.equals("geekclb") || name.equals("sheenrox82") || name.equals("The_SlayerMC") || name.equals("insanity414all") || name.equals("deathman12e3") || name.equals("Fire_Sight") || name.equals("iTzaKiLLsHoT");
	}
}