package net.divinerpg.entities.arcana;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.api.entity.EntityDivineRPGTameable;
import net.divinerpg.client.ArcanaHelper;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntitySeimer extends EntityDivineRPGTameable {
	
    private int regenTimer;

    public EntitySeimer(World par1World, EntityPlayer p) {
        this(par1World);
        setTamed(true);
        func_152115_b(p.getDisplayName());
    }
    
    public EntitySeimer(World par1World) {
        super(par1World);
        this.setSize(1.0F, 1.0F);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        //this.tasks.addTask(2, this.aiSit);
        //this.tasks.addTask(4, new EntityAIFollowOwner(this, this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue(), 4.0F, 2.0F));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.regenTimer = 0;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.seimerHealth);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.seimerSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.seimerFollowRange);
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
    public void onUpdate() {
        super.onUpdate();

        if (this.getOwner() != null) {
            if (this.regenTimer >= 2) {
                ArcanaHelper.regen(1);
                this.regenTimer = 0;
            } else {
                ++this.regenTimer;
            }
        }
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