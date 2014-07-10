package net.divinerpg.entities.vanilla;

import java.util.List;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.api.entity.EntityPeacefullUntillAttacked;
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

public class EntityShark extends EntityPeacefullUntillAttacked {
	
    public EntityShark(World var1) {
        super(var1);
        this.setSize(0.95F, 0.95F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.sharkHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.sharkDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.sharkSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.sharkFollowRange);
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
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
    	super.onEntityUpdate();
    	if(this.isInWater()) this.setAir(300);
    	else this.setAir(0);
    }

    @Override
    protected void fall(float var1) {}

    @Override
    public boolean getCanSpawnHere() {
        int var1 = MathHelper.floor_double(this.posX);
        int var2 = MathHelper.floor_double(this.boundingBox.minY);
        int var3 = MathHelper.floor_double(this.posZ);
        return this.worldObj.handleMaterialAcceleration(this.boundingBox.expand(0.0D, -0.6000000238418579D, 0.0D), Material.water, this);
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