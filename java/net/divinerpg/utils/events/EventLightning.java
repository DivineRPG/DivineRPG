package net.divinerpg.utils.events;

import net.divinerpg.entities.twilight.EntityEpiphite;
import net.divinerpg.utils.items.ArcanaItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventLightning {
	
	@SubscribeEvent
	public void struckByLightning(EntityStruckByLightningEvent evt) {
		if(evt.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)evt.entity;
			if(player.getHeldItem() != null && player.getHeldItem().getItem() == ArcanaItems.stormSword) {
				evt.setCanceled(true);
			}
		} else if(evt.entity instanceof EntityEpiphite) {
			evt.setCanceled(true);
		}
	}

}
