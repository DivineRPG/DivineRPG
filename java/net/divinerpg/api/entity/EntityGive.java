package net.divinerpg.api.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract class EntityGive extends EntityDivineRPGMob {
	
    private Item giveItem;
    private int amount;

    public EntityGive(World par1) {
        super(par1);
    }

    public EntityGive(World par1, Item par3, int par4) {
        this(par1);
        this.giveItem = par3;
        this.amount = par4;
    }

    @Override
    public boolean isAIEnabled() {
        return true;
    }

    @Override
    public boolean interact(EntityPlayer var1) {
        if(this.isEntityAlive()) {
            if(!this.worldObj.isRemote) {
                var1.inventory.addItemStackToInventory(new ItemStack(this.giveItem, this.amount));
                Interact(var1);
                this.setDead();
            }
            return true;
        } else {
            return super.interact(var1);
        }
    }
    
    public abstract void Interact(EntityPlayer var1);

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(EntityStats.modVillagerSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(EntityStats.modVillagerHealth);
    }
}