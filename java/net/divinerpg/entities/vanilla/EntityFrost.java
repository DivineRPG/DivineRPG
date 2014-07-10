package net.divinerpg.entities.vanilla;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.IceikaItems;
import net.divinerpg.utils.items.ItemsFood;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityFrost extends EntityDivineRPGMob {
	
    private float heightOffset = 0.5F;
    private int heightOffsetUpdateTime;
    private int anger;

    public EntityFrost(World var1) {
        super(var1);
        this.experienceValue = 20;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.frostHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.frostDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.frostSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.frostFollowRange);
    }

	@Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }

    @Override
    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.frost);
    }

    @Override
    protected String getHurtSound() {
        return "mob.blaze.hit";
    }

    @Override
    protected String getDeathSound() {
        return "mob.blaze.death";
    }

    @Override
    public void onLivingUpdate() {
        if(!this.worldObj.isRemote) {
            if(this.isWet()) {
                this.attackEntityFrom(DamageSource.drown, 1);
            }

            --this.heightOffsetUpdateTime;

            if(this.heightOffsetUpdateTime <= 0) {
                this.heightOffsetUpdateTime = 100;
                this.heightOffset = 0.5F + (float)this.rand.nextGaussian() * 3.0F;
            }

            if(this.getEntityToAttack() != null && this.getEntityToAttack().posY + (double)this.getEntityToAttack().getEyeHeight() > this.posY + (double)this.getEyeHeight() + (double)this.heightOffset) {
                this.motionY += (0.30000001192092896D - this.motionY) * 0.30000001192092896D;
            }
        }

        if(!this.onGround && this.motionY < 0.0D) {
            this.motionY *= 0.6D;
        }
        super.onLivingUpdate();
    }

    @Override
    protected void attackEntity(Entity par1Entity, float par2) {
        if(this.attackTime <= 0 && par2 < 2.0F && par1Entity.boundingBox.maxY > this.boundingBox.minY && par1Entity.boundingBox.minY < this.boundingBox.maxY) {
            this.attackTime = 20;
            this.attackEntityAsMob(par1Entity);
        }
        else if(par2 < 30.0F) {
            double var3 = par1Entity.posX - this.posX;
            double var5 = par1Entity.boundingBox.minY + (double)(par1Entity.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
            double var7 = par1Entity.posZ - this.posZ;

            if(this.attackTime == 0) {
                ++this.anger;

                if(this.anger == 1) {
                    this.attackTime = 60;
                }
                else if(this.anger <= 4) {
                    this.attackTime = 6;
                } else {
                    this.attackTime = 100;
                    this.anger = 0;
                    this.idk(false);
                }

                if(this.anger > 1) {
                    float var9 = MathHelper.sqrt_float(par2) * 0.5F;
                    this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)this.posX, (int)this.posY, (int)this.posZ, 0);

                    for(int var10 = 0; var10 < 1; ++var10) {
                        EntitySmallFireball var11 = new EntitySmallFireball(this.worldObj, this, var3 + this.rand.nextGaussian() * (double)var9, var5, var7 + this.rand.nextGaussian() * (double)var9);
                        var11.posY = this.posY + (double)(this.height / 2.0F) + 1.5D;
                        this.worldObj.spawnEntityInWorld(var11);
                    }
                }
            }

            this.rotationYaw = (float)(Math.atan2(var7, var3) * 180.0D / Math.PI) - 90.0F;
            this.hasAttacked = true;
        }
    }

    @Override
    protected void fall(float par1) {}


    @Override
    public boolean isBurning()  {
        return (dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }

    @Override
    protected void dropFewItems(boolean var1, int var2) {
        int var3 = this.rand.nextInt(2 + var2);
        int var4;

        for(var4 = 0; var4 < var3; ++var4) {
            this.dropItem(ItemsFood.tomato, 2);
        }

        for(var4 = 0; var4 < var3; ++var4) {
            this.dropItem(IceikaItems.iceShards, 5);
        }

        for(var4 = 0; var4 < var3; ++var4) {
            this.dropItem(IceikaItems.iceStone, 1);
        }
    }

    public void idk(boolean par1) {
        byte var2 = this.dataWatcher.getWatchableObjectByte(16);

        if(par1) {
            var2 = (byte)(var2 | 1);
        } else {
            var2 &= -2;
        }
        this.dataWatcher.updateObject(16, Byte.valueOf(var2));
    }

	@Override
	public String mobName() {
		return "Frost";
	}
}