package net.divinerpg.entities.vanilla;

import net.divinerpg.entities.base.EntityDivineRPGTameable;
import net.divinerpg.entities.base.EntityStats;
import net.divinerpg.entities.base.IAttackTimer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityStoneGolem extends EntityDivineRPGTameable implements IAttackTimer {
    public EntityStoneGolem(World w, EntityPlayer p) {
        this(w);
        setTamed(true);
        func_152115_b(p.getUniqueID().toString());
    }

    public EntityStoneGolem(World var1) {
        super(var1);
        setSize(1.3f, 2.5F);
    }
    
    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(19, 0);
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.stoneGolemHealth);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.stoneGolemSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.stoneGolemFollowRange);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1);
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if(getAttackTimer() > 0) this.dataWatcher.updateObject(19, getAttackTimer()-1);
    }
    
    @Override
    public int getAttackTimer() {
        return this.dataWatcher.getWatchableObjectInt(19);
    }
    
    @Override
    public boolean interact(EntityPlayer player) {
        ItemStack stack = player.inventory.getCurrentItem();

        if (this.isTamed()) {
            if (stack != null) {
                if (stack.getItem() instanceof ItemFood) {
                    ItemFood var3 = (ItemFood)stack.getItem();

                    if (var3 == Item.getItemFromBlock(Blocks.stone) || var3 == Item.getItemFromBlock(Blocks.cobblestone) && this.dataWatcher.getWatchableObjectInt(18) < 20) {
                        if (!player.capabilities.isCreativeMode) {
                            --stack.stackSize;
                        }

                        this.heal(var3.func_150905_g(stack));

                        if (stack.stackSize <= 0) {
                            player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
                        }

                        return true;
                    }
                }
            }
        } else {
            this.setTamed(true);
            this.func_152115_b(player.getUniqueID().toString());
        }

        return super.interact(player);
    }

    @Override
    public boolean getCanSpawnHere() {
        int var1 = MathHelper.floor_double(this.posX);
        int var2 = MathHelper.floor_double(this.boundingBox.minY);
        int var3 = MathHelper.floor_double(this.posZ);
        return this.getBlockPathWeight(var1, var2, var3) >= 0.0F && this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
    }
    
    @Override
    public boolean attackEntityAsMob(Entity e) {
    	boolean attack = e.attackEntityFrom(DamageSource.causeMobDamage(this), (float)EntityStats.stoneGolemDamage);
    	if(attack) {
    	    e.addVelocity(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F), 0.1D, MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F));
    	    this.dataWatcher.updateObject(19, 10);
    	}
        return attack;
    }

	@Override
	public String mobName() {
		return "Stone Golem";
	}
	
	@Override
	public EntityAgeable createChild(EntityAgeable var1) {
		return null;
	}
}