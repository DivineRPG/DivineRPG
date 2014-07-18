package net.divinerpg.entities.vethea;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityVhraak extends EntityDivineRPGMob {
	
    private static final double spawnLayer = 4;
    private int waitTick, lifeTick, spawnTick;

    public EntityVhraak(World var1) {
        super(var1);
        addAttackingAI();
        this.lifeTick = -1;
    }
    
    public EntityVhraak(World var1, int life) {
        this(var1);
        this.lifeTick = life;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.varaakHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.varaakDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.varaakSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.varaakFollowRange);
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 64.0D * spawnLayer  && this.posY > 64.0D * (spawnLayer - 1) && super.getCanSpawnHere();
    }

    @Override
    protected void updateAITasks() {
        if (this.getAttackTarget() != null && this.getDistanceToEntity(this.getAttackTarget()) < 0.5) {
            this.waitTick = 30;
            this.hasAttacked = false;
        }
        else if (this.waitTick == 0) {
            if (this.spawnTick == 0 && this.lifeTick == -1) {
                EntityVhraak var2 = new EntityVhraak(this.worldObj, 30);
                var2.setLocationAndAngles(this.posX + 1, this.posY, this.posZ + 1, this.rotationYaw, this.rotationPitch);
                this.worldObj.spawnEntityInWorld(var2);

                var2 = new EntityVhraak(this.worldObj, 30);
                var2.setLocationAndAngles(this.posX - 1, this.posY, this.posZ + 1, this.rotationYaw, this.rotationPitch);
                this.worldObj.spawnEntityInWorld(var2);

                var2 = new EntityVhraak(this.worldObj, 30);
                var2.setLocationAndAngles(this.posX + 1, this.posY, this.posZ - 1, this.rotationYaw, this.rotationPitch);
                this.worldObj.spawnEntityInWorld(var2);

                var2 = new EntityVhraak(this.worldObj, 30);
                var2.setLocationAndAngles(this.posX - 1, this.posY, this.posZ - 1, this.rotationYaw, this.rotationPitch);
                this.worldObj.spawnEntityInWorld(var2);
                this.spawnTick = 50;
            }
            else if (this.spawnTick > 0) {
                this.spawnTick--;
            }
            super.updateAITasks();
        } else {
            --this.waitTick;
        }
    }
 
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.lifeTick > 0) 
            this.lifeTick--;
        else if (this.lifeTick == 0 && !this.worldObj.isRemote) 
            this.setDead();
    }

    @Override
    protected String getLivingSound() {
        return Sounds.varaak.getPrefixedName();
    }

    @Override
    protected String getHurtSound() {
        return Sounds.varaakHurt.getPrefixedName();
    }

    @Override
    protected String getDeathSound() {
        return getHurtSound();
    }

    @Override
    protected void dropFewItems(boolean par1, int par2) {
        this.dropItem(VetheaItems.shinyPearls, 1);
    }

	@Override
	public String mobName() {
		return "Vhraak";
	}
}