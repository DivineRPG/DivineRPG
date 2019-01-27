package naturix.divinerpg.entities.entity;

import javax.annotation.Nullable;

import naturix.divinerpg.registry.ModSounds;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIFollow;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public abstract class EntityDivineRPGMob extends EntityMob {

	public EntityDivineRPGMob(World par1World) {
		super(par1World);
	}

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27D);
    }

	@Override
	protected void initEntityAI() {
		if (!needsSpecialAI()) {
			addBasicAI();
		}
	}
	
    public boolean needsSpecialAI() {
		return false;
	}
    
	protected void addBasicAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
	    this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
	    this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
	    this.tasks.addTask(6, new EntityAILookIdle(this));
	}

	protected void addAttackingAI() {
		this.tasks.addTask(1, new EntityAIAttackMelee(this, 1, true));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
	}

	@Override
	public boolean getCanSpawnHere() {
		return (this.world.getDifficulty() != EnumDifficulty.PEACEFUL) && this.isValidLightLevel();
	}
}