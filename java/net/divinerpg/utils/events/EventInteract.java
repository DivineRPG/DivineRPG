package net.divinerpg.utils.events;

import net.divinerpg.libs.Sounds;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventInteract {
	
	@SubscribeEvent
	public void interact(EntityInteractEvent evt) {
		if (!evt.entityPlayer.worldObj.isRemote && ArcanaHelper.getProperties(evt.entityPlayer).useBar(20)) {
			evt.entityPlayer.worldObj.playSoundAtEntity(evt.entityPlayer, Sounds.reflector.getPrefixedName(), 1.0F, 1.0F);
			evt.target.addVelocity(evt.target.posX-evt.entityPlayer.posX, evt.target.posY-evt.entityPlayer.posY, evt.target.posZ-evt.entityPlayer.posZ);
    	}
	}

}
