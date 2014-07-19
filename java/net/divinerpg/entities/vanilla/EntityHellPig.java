package net.divinerpg.entities.vanilla;

import net.divinerpg.api.entity.EntityDivineRPGTameable;
import net.divinerpg.api.entity.EntityStats;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityHellPig extends EntityDivineRPGTameable {

	@SuppressWarnings("For some reason, this is falling through the ground")
	public EntityHellPig(World w) {
		super(w);
	}
	
	@Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(EntityStats.hellPigSpeed);
        if(this.isTamed()) this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(EntityStats.hellPigHealth);
        else this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(EntityStats.hellPigTamedHealth);
    }

	@Override
	public String mobName() {
		return "Hell Pig";
	}

	@Override
	public EntityAgeable createChild(EntityAgeable var1) {
		return null;
	}
	
	@Override
	public boolean getCanSpawnHere() {
		return worldObj.getBlock((int)posX, (int)posY - 1, (int)posZ) == Blocks.soul_sand && super.getCanSpawnHere();
	}
	
	@Override
    public void setAttackTarget(EntityLivingBase par1EntityLivingBase) {
        super.setAttackTarget(par1EntityLivingBase);
        if(par1EntityLivingBase == null)
            this.setAngry(false);
        
        else if(!this.isTamed())
            this.setAngry(true);
        
    }
	
	@Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(18, new Float(this.getHealth()));
    }
	
	@Override
    protected void updateAITick() {
        this.dataWatcher.updateObject(18, Float.valueOf(this.getHealth()));
    }
	
	@Override
    protected void func_145780_a(int x, int y, int z, Block b) {
        this.playSound("mob.wolf.step", 0.15F, 1.0F);
    }
	
	@Override
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setBoolean("Angry", this.isAngry());
    }

	@Override
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setAngry(par1NBTTagCompound.getBoolean("Angry"));
    }
	
	@Override
    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        if(this.isEntityInvulnerable()) return false;
        else {
            Entity entity = par1DamageSource.getEntity();
            this.aiSit.setSitting(false);
            if(entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow))            
                par2 = (par2 + 1.0F) / 2.0F;
            return super.attackEntityFrom(par1DamageSource, par2);
        }
    }
    
    @Override
    public boolean attackEntityAsMob(Entity par1Entity) {
        int i = this.isTamed() ? 10 : 5;
        return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)i);
    }

    @Override
    public void setTamed(boolean par1) {
        super.setTamed(par1);
         if(par1) this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(EntityStats.hellPigTamedHealth);
         else this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(EntityStats.hellPigHealth);
    }
    
    @Override
    public boolean interact(EntityPlayer par1EntityPlayer) {
        ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();

        if(this.isTamed()) {
            if(itemstack != null) {
                if(itemstack.getItem() instanceof ItemFood) {
                    ItemFood itemfood = (ItemFood)itemstack.getItem();
                    if(itemfood.isWolfsFavoriteMeat() && this.dataWatcher.getWatchableObjectFloat(18) < 20.0F) {
                        if(!par1EntityPlayer.capabilities.isCreativeMode)
                        	--itemstack.stackSize;            
                        this.heal((float)itemfood.func_150905_g(itemstack));
                        if(itemstack.stackSize <= 0)
                            par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                        return true;
                    }
                }
            }

            if (par1EntityPlayer.getCommandSenderName().equalsIgnoreCase(this.func_152113_b()) && !this.worldObj.isRemote && !this.isBreedingItem(itemstack)) {
                this.aiSit.setSitting(!this.isSitting());
                this.isJumping = false;
                this.setPathToEntity((PathEntity)null);
                this.setTarget((Entity)null);
                this.setAttackTarget((EntityLivingBase)null);
            }
        }
        
        else if (itemstack != null && itemstack.getItem() == Items.blaze_powder && !this.isAngry()) {
            if(!par1EntityPlayer.capabilities.isCreativeMode)    
                --itemstack.stackSize;
            
            if(itemstack.stackSize <= 0) 
                par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
           
            if(!this.worldObj.isRemote) {
                if(this.rand.nextInt(3) == 0) {
                    this.setTamed(true);
                    this.setPathToEntity((PathEntity)null);
                    this.setAttackTarget((EntityLivingBase)null);
                    this.aiSit.setSitting(true);
                    this.setHealth(20.0F);
                    this.func_152115_b(par1EntityPlayer.getCommandSenderName());
                    this.playTameEffect(true);
                    this.worldObj.setEntityState(this, (byte)7);
                } else {
                    this.playTameEffect(false);
                    this.worldObj.setEntityState(this, (byte)6);
                }
            }
            return true;
        }
        return super.interact(par1EntityPlayer);
    }

    public boolean isAngry() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 2) != 0;
    }
    
	private void setAngry(boolean b) {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);
        if(b) this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 2)));
        else this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & -3)));
	}
	
	@Override
    protected boolean canDespawn() {
        return !this.isTamed() && this.ticksExisted > 2400;
    }

	@Override
    public boolean func_142018_a(EntityLivingBase par1EntityLivingBase, EntityLivingBase par2EntityLivingBase) {
        if (!(par1EntityLivingBase instanceof EntityCreeper) && !(par1EntityLivingBase instanceof EntityGhast)) {
            if (par1EntityLivingBase instanceof EntityHellPig) {
            	EntityHellPig pig = (EntityHellPig)par1EntityLivingBase;
                if(pig.isTamed() && pig.getOwner() == par2EntityLivingBase) return false;
            }
            return par1EntityLivingBase instanceof EntityPlayer && par2EntityLivingBase instanceof EntityPlayer && !((EntityPlayer)par2EntityLivingBase).canAttackPlayer((EntityPlayer)par1EntityLivingBase) ? false : !(par1EntityLivingBase instanceof EntityHorse) || !((EntityHorse)par1EntityLivingBase).isTame();
        }
        else return false;
    }
}