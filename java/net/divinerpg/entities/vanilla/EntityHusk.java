package net.divinerpg.entities.vanilla;

import net.divinerpg.entities.base.EntityDivineRPGTameable;
import net.divinerpg.entities.base.EntityStats;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.TwilightItemsCrops;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityHusk extends EntityDivineRPGTameable {
	

    public EntityHusk(World par1World, EntityPlayer p) {
        this(par1World);
        setTamed(true);
        func_152115_b(p.getUniqueID().toString());
    }
    
    public EntityHusk(World par1World) {
        super(par1World);
        this.setSize(0.8f, 1.4f);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.huskHealth);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.huskSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.huskFollowRange);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1);
    }

    @Override
    public boolean interact(EntityPlayer player) {
        ItemStack stack = player.inventory.getCurrentItem();

        if (this.isTamed()) {
            if (stack != null) {
                if (stack.getItem() instanceof ItemFood) {
                    ItemFood var3 = (ItemFood)stack.getItem();

                    if (var3 == Items.carrot || var3 == Items.apple || var3 == TwilightItemsCrops.moonbulb && this.getHealth() < EntityStats.huskHealth) {
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
    public boolean attackEntityAsMob(Entity e) {
    	return e.attackEntityFrom(DamageSource.causeMobDamage(this), 8);
    }
    
    @Override
    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.growl);
    }

    @Override
    protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.growlHurt);
    }

    @Override
    protected String getDeathSound() {
        return Sounds.getSoundName(Sounds.growlHurt);
    }

	@Override
	public String mobName() {
		return "Husk";
	}

	@Override
	public EntityAgeable createChild(EntityAgeable var1) {
		return null;
	}
}