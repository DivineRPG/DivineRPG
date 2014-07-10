package net.divinerpg.utils.events;

import net.divinerpg.api.entity.EntityDivineRPGBoss;
import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.api.entity.EntityDivineRPGTameable;
import net.divinerpg.api.entity.EntityDivineRPGVillager;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventDeath {

	@SubscribeEvent
	public void onMobDeath(LivingDeathEvent e){
		if(ConfigurationHelper.canShowVanillaDeathChat){
			if(e.source.getSourceOfDamage() != null){	
				if(e.source.getSourceOfDamage() instanceof EntityPlayer){
					EntityPlayer p = (EntityPlayer)e.source.getSourceOfDamage();
					if(e.entity instanceof EntityLiving && !(e.entity instanceof EntityDivineRPGMob) && !(e.entity instanceof EntityDivineRPGVillager) && !(e.entity instanceof EntityDivineRPGTameable)) {
						Util.sendMessageToAll(p.getDisplayName() + " has slain an " + getEntityName(e.entityLiving));
					}
				}
			}
		}
	}

	private String getEntityName(EntityLivingBase entity) {
		return EntityList.getEntityString(entity);
	}
}