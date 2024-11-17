package net.divinerpg.entities.arcana;

import net.divinerpg.entities.arcana.projectile.EntityFyracryxFireball;
import net.divinerpg.entities.base.EntityDivineRPGTameable;
import net.divinerpg.libs.Sounds;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityFyracryx extends EntityDivineRPGTameable implements IRangedAttackMob {
	
    public EntityFyracryx(World par1World, EntityPlayer par2EntityPlayer) {
        this(par1World);
        this.setTamed(true);
        this.isImmuneToFire=true;
        this.func_152115_b(par2EntityPlayer.getUniqueID().toString()); //setOwner
    }

    public EntityFyracryx(World par1World) {
        super(par1World);
        this.setSize(2F, 2F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.fyracryxHealth);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.fyracryxSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.fyracryxFollowRange);
    }

    @Override
    public String mobName() {
        return "Fyracryx";
    }

    @Override
    protected String getLivingSound() {
        return Sounds.deathcryx.getPrefixedName();
    }
 
    @Override
    protected String getHurtSound() {
        return Sounds.deathcryxHurt.getPrefixedName();
    }
 
    @Override
    protected String getDeathSound() {
        return Sounds.deathcryx.getPrefixedName();
    }

    @Override
    public boolean interact(EntityPlayer par1EntityPlayer) {
        ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();

        if (this.isTamed()) {
            if (var2 != null) {
                if (var2.getItem() instanceof ItemFood) {
                    ItemFood var3 = (ItemFood)var2.getItem();

                    if (var3.isWolfsFavoriteMeat() && this.dataWatcher.getWatchableObjectInt(18) < 20) {
                        if (!par1EntityPlayer.capabilities.isCreativeMode) {
                            --var2.stackSize;
                        }

                        this.heal(var3.func_150905_g(var2));

                        if (var2.stackSize <= 0) {
                            par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                        }
                        return true;
                    }
                }
            }
        } else {
            this.setTamed(true);
            this.func_152115_b(par1EntityPlayer.getDisplayName());
        }
        return super.interact(par1EntityPlayer);
    }

    @Override
    public EntityAgeable createChild(EntityAgeable var1) {
        return null;
    }
    
    @Override
    public void onUpdate() {
    	super.onUpdate();
    	if(this.getAttackTarget() != null && !this.worldObj.isRemote && this.ticksExisted%20==0)this.attackEntityWithRangedAttack(this.getAttackTarget(), 0);
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase e, float f) {
    	double tx = e.posX - this.posX;
        double ty = e.boundingBox.minY - this.posY;
        double tz = e.posZ - this.posZ;
        float var9 = MathHelper.sqrt_float(this.getDistanceToEntity(this)) * 0.5F;
        this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)this.posX, (int)this.posY, (int)this.posZ, 0);

        EntityFyracryxFireball var11 = new EntityFyracryxFireball(this.worldObj, this, tx + this.rand.nextGaussian() * var9, ty, tz + this.rand.nextGaussian() * var9);
        var11.posY = this.posY + this.height / 2.0F + 0.5D;
        this.worldObj.spawnEntityInWorld(var11);
    }
}