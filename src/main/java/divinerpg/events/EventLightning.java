package divinerpg.events;

import divinerpg.api.Reference;
import divinerpg.objects.entities.entity.twilight.EntityEpiphite;
import divinerpg.registry.ModWeapons;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class EventLightning {
	
	@SubscribeEvent
	public void struckByLightning(EntityStruckByLightningEvent evt) {
		Entity entity = evt.getEntity();
		if(entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entity;
			if(player.getHeldItem(EnumHand.MAIN_HAND) != null && player.getHeldItem(EnumHand.MAIN_HAND).getItem() == ModWeapons.stormSword) {
				evt.setCanceled(true);
			}
		} else if(entity instanceof EntityEpiphite) {
			evt.setCanceled(true);
		}
	}

}