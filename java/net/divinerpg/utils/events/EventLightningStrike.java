package net.divinerpg.utils.events;

import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventLightningStrike {
	
	@SubscribeEvent
	public void onLightningStrike(EntityStruckByLightningEvent e) {
		e.entity.attackEntityFrom(DamageSource.onFire, 16F);
	}
	
}
