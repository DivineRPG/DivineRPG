package net.divinerpg.entities.vanilla;

import java.util.List;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.entities.base.EntityPeacefulUntilAttacked;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityShark extends EntityPeacefulUntilAttacked {
	
    public EntityShark(World var1) {
        super(var1);
        this.setSize(0.75F, 0.75F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.sharkHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.sharkDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.sharkSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.sharkFollowRange);
    }

    
    @Override
	public int getMaxSpawnedInChunk() {
		return 1;
	}

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }
    
    @Override
	protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }
    
    @Override
    protected String getLivingSound() {
    	return Sounds.shark.getPrefixedName();
    }
    
    @Override
    protected String getHurtSound() {
    	return Sounds.sharkHurt.getPrefixedName();
    }
    
    @Override
    protected String getDeathSound() {
    	return getHurtSound();
    }

    @Override
    protected void dropFewItems(boolean var1, int var2) {
        int var3 = this.rand.nextInt(3 + var2) + 1;
        for(int var4 = 0; var4 < var3; ++var4) {
            this.entityDropItem(new ItemStack(VanillaItemsOther.sharkFin), 0.0F);
        }
    }

    @Override
	public void onEntityUpdate() {
		int i = this.getAir();
        super.onEntityUpdate();

        if (this.isEntityAlive() && !this.isInWater()) {
        	if (!this.worldObj.isRemote) {
                this.motionX = 0.0D;
                this.motionY -= 0.08D;
                this.motionY *= 0.9800000190734863D;
                this.motionZ = 0.0D;
            }
            --i;
            this.setAir(i);

            if (this.getAir() == -20) {
                this.setAir(0);
                this.attackEntityFrom(DamageSource.drown, 2.0F);
            }
        }
        else {
            this.setAir(300);
        }	
	}
    
    @Override
    protected void fall(float var1) {}

    @Override
    public boolean isInWater() {
        return this.worldObj.getBlock((int)this.posX, MathHelper.floor_double(this.posY), (int)this.posZ).getMaterial() == Material.water;
    }
    
    @Override
    public boolean getCanSpawnHere() {
        return this.isInWater();
    }
    
	@Override
    public void onDeath(DamageSource d) {
		super.onDeath(d);
		if(!this.worldObj.isRemote) {
            Entity var3 = d.getEntity();
            if(var3 instanceof EntityPlayer) {
            	((EntityPlayer)var3).addStat(DivineRPGAchievements.feedingOnTheFish, 1);
            }
        }
	}

	@Override
	public String mobName() {
		return "Shark";
	}
}