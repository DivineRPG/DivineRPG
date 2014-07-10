package net.divinerpg.api.entity;

import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public abstract class EntityDivineRPGBoss extends EntityDivineRPGMob implements IDivineRPGBoss {

	public EntityDivineRPGBoss(World par1World) {
		super(par1World);
	}

	@Override
	public boolean canDespawn() {
		return false;	
	}

	public void onDeath(DamageSource d) {
		super.onDeath(d);
		if(!worldObj.isRemote && ConfigurationHelper.canShowDeathChat){
			if(d.getSourceOfDamage() != null && d.getSourceOfDamage() instanceof EntityPlayer){
				Util.sendMessageToAll("The " + mobName() + " has fallen.");
			}
		}
	}
}