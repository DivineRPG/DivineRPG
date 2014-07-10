package net.divinerpg.utils.events;

import net.divinerpg.client.render.gui.GUIOverlay;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class EventOverlay {

	private final GUIOverlay gui = new GUIOverlay();

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void renderOverlay(RenderGameOverlayEvent event){
		if(event.isCancelable() || event.type != ElementType.EXPERIENCE) return;
		if(ConfigurationHelper.canShowIngameVersion)
			gui.drawOverlay();
	}
}
