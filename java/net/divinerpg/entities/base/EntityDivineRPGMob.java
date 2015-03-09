package net.divinerpg.entities.base;

import net.divinerpg.entities.vethea.EntityTwins;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public abstract class EntityDivineRPGMob extends EntityMob{

	public EntityDivineRPGMob(World par1World) {
		super(par1World);
        addBasicAI();
	}

	public double getHP(){return getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue();}
	public double getMoveSpeed(){return getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue();}
	public double getAttackDamage(){return getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();}
	public double getFollowRange(){return getEntityAttribute(SharedMonsterAttributes.followRange).getAttributeValue();}
	public double getKnockbackResistance(){return getEntityAttribute(SharedMonsterAttributes.knockbackResistance).getAttributeValue();}
	public abstract String mobName();

	protected void addAttackingAI(){
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0F, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}
	
	protected void addBasicAI(){
		this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(8, new EntityAIWander(this, 1.0F));
        this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 8));
        this.tasks.addTask(6, new EntityAILookIdle(this));
	}
	
	@Override
    protected String getLivingSound() {
        return super.getLivingSound();
    }

    @Override
    protected String getHurtSound() {
        return super.getHurtSound();
    }

    @Override
    protected String getDeathSound() {
        return super.getDeathSound();
    }
	
	@Override
	protected boolean isAIEnabled() {
		return true;
	}

	public void onDeath(DamageSource d) {
		super.onDeath(d);	
		if(!worldObj.isRemote && ConfigurationHelper.canShowDeathChat){
			if(d.getEntity() != null && d.getEntity() instanceof EntityPlayer){
				EntityPlayer p = (EntityPlayer)d.getEntity();
				String name = mobName() != null ? mobName() : "null";
				if(!(d.getEntity() instanceof EntityDivineRPGBoss))
				Util.sendMessageToAll(p.getDisplayName() + " has slain a " + name);

				if(d.getEntity() instanceof EntityTwins){
					Util.sendMessageToAll(p.getDisplayName() + " has slain the " + name);
				}
			}
		}
	}
}