package naturix.divinerpg.entities.entity;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
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
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public abstract class EntityDivineRPGTameable extends EntityTameable {
    
	public EntityDivineRPGTameable(World w) {
		super(w);
		addBasicAI();
		setTamed(false);
	}

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return super.getAmbientSound();
    }

    @Nullable
    @Override
	protected SoundEvent getHurtSound(DamageSource source) {
        return super.getHurtSound(source);
	}
    
    @Nullable
    @Override
	protected SoundEvent getDeathSound() {
        return super.getDeathSound();
    }
	
	protected void addBasicAI(){
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
		this.tasks.addTask(4, new EntityAIAttackMelee(this, 1, true));
        this.tasks.addTask(5, new EntityAIOwnerWithoutTeleport(this, 1.0D, 10.0F, 2.0F));
	    this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
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
	public boolean getCanSpawnHere() {
		return (this.world.getDifficulty() != EnumDifficulty.PEACEFUL);
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