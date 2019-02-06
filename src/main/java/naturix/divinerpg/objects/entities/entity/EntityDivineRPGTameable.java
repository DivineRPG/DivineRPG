package naturix.divinerpg.objects.entities.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public abstract class EntityDivineRPGTameable extends EntityTameable {
	public EntityDivineRPGTameable(World world) {
		super(world);
		setTamed(false);
	}
	
	@Override
	protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAISwimming(this));
        //this.tasks.addTask(2, this.aiSit);
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
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27D);
    }

    @Override
	public EntityLivingBase getAttackTarget() {
		return this.isTamed() || this.isAngry() ? super.getAttackTarget() : null;
	}
	
	@Override
	public boolean attackEntityAsMob(Entity e) {
		boolean attack = super.attackEntityAsMob(e);
		if(attack && e instanceof EntityLiving) {
			((EntityLiving)e).setRevengeTarget(this);
		}
		return attack;
	}
	
	public boolean isAngry() {
		return false;
	}

	@Override
	public boolean getCanSpawnHere() {
		return (this.world.getDifficulty() != EnumDifficulty.PEACEFUL);
	}
}