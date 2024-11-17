package net.divinerpg.entities.arcana;

import net.divinerpg.entities.base.EntityDivineRPGTameable;
import net.divinerpg.utils.events.ArcanaHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntitySeimer extends EntityDivineRPGTameable {
	

    public EntitySeimer(World par1World, EntityPlayer p) {
        this(par1World);
        setTamed(true);
        func_152115_b(p.getUniqueID().toString());
    }
    
    public EntitySeimer(World par1World) {
        super(par1World);
        this.setSize(1.2f, 1);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.seimerHealth);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.seimerSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.seimerFollowRange);
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
            this.func_152115_b(par1EntityPlayer.getUniqueID().toString());
        }

        return super.interact(par1EntityPlayer);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.getOwner() != null && this.getOwner() instanceof EntityPlayer) {
            ArcanaHelper.getProperties((EntityPlayer)this.getOwner()).regen(1);
        }
    }
    
    @Override
    public boolean attackEntityAsMob(Entity e) {
    	return e.attackEntityFrom(DamageSource.causeMobDamage(this), 6);
    }

	@Override
	public String mobName() {
		return "Seimer";
	}

	@Override
	public EntityAgeable createChild(EntityAgeable var1) {
		return null;
	}
}