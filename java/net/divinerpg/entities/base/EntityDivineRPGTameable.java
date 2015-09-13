package net.divinerpg.entities.base;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBeg;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public abstract class EntityDivineRPGTameable extends EntityTameable {
    
	public EntityDivineRPGTameable(World w) {
		super(w);
		addBasicAI();
		setTamed(false);
	}
	
	public double getHP(){return getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue();}
	public double getMoveSpeed(){return getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue();}
	public double getAttackDamage(){return getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();}
	public double getFollowRange(){return getEntityAttribute(SharedMonsterAttributes.followRange).getAttributeValue();}
	public double getKnockbackResistance(){return getEntityAttribute(SharedMonsterAttributes.knockbackResistance).getAttributeValue();}
	public abstract String mobName();

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
	
	protected void addBasicAI(){
		this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0D, true));
        this.tasks.addTask(5, new EntityAIOwnerWithoutTeleport(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
	}
	
	@Override
	public EntityLivingBase getAttackTarget() {
		return this.isTamed() || this.isAngry() ? super.getAttackTarget() : null;
	}
	
	@Override
	protected boolean isAIEnabled() {
		return true;
	}
	
	@Override
	public boolean getCanSpawnHere() {
		return (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) && this.worldObj.checkNoEntityCollision(this.boundingBox) && (this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty()) && (!this.worldObj.isAnyLiquid(this.boundingBox));
	}
	
	@Override
	public boolean attackEntityAsMob(Entity e) {
		boolean attack = super.attackEntityAsMob(e);
		if(attack && e instanceof EntityLiving) {
			((EntityLiving)e).setRevengeTarget(this);
		}
		return attack;
	}
	
	
	public boolean isAngry() {return false;}
}