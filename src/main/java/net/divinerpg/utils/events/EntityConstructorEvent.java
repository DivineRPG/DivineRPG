package net.divinerpg.utils.events;

import net.divinerpg.utils.FlyingHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EntityConstructorEvent {
	
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing evt) {
		if(evt.entity instanceof EntityPlayer && ArcanaHelper.getProperties((EntityPlayer)evt.entity) == null){
			ArcanaHelper.addProperties((EntityPlayer)evt.entity);
		}
		
		if(evt.entity instanceof EntityPlayer && FlyingHelper.getProperties((EntityPlayer)evt.entity) == null){
		    FlyingHelper.addProperties((EntityPlayer)evt.entity);
		}
		
		if(evt.entity instanceof EntityPlayer && ArcanaPortalCoords.getProperties((EntityPlayer)evt.entity) == null){
			ArcanaPortalCoords.addProperties((EntityPlayer)evt.entity);
		}
	}

}
