package net.divinerpg.utils.events;

import net.divinerpg.libs.Reference;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;

public class ArcanaTickHandler {
	
	@SubscribeEvent
	public void onTick(PlayerTickEvent event){
		if(event.phase == Phase.START){
			onTickStart(event.player);
		} else {
			onTickEnd(event.player);
		}
	}

	private void onTickEnd(EntityPlayer player) {
		ArcanaHelper.getProperties(player).updateAllBars();
	}

	private void onTickStart(EntityPlayer player) { }

	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event){ 
		ArcanaHelper.getProperties(event.player).setBarValue(0);
	}

	@SubscribeEvent
	public void onPlayerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event){ 
		ArcanaHelper.getProperties(event.player).setBarValue(0);
	}

	@SubscribeEvent
	public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event){ 
		ArcanaHelper.getProperties(event.player).setBarValue(200);
	}

	@SubscribeEvent
	public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event){
		ArcanaHelper.getProperties(event.player).setBarValue(200);
	}
}