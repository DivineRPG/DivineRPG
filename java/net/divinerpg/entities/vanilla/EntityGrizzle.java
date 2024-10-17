package net.divinerpg.entities.vanilla;

import net.divinerpg.entities.base.EntityDivineRPGTameable;
import net.divinerpg.entities.base.EntityStats;
import net.divinerpg.libs.Sounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityGrizzle extends EntityDivineRPGTameable {
    

    public EntityGrizzle(World par1World, EntityPlayer p, int color) { //0==white, 1==brown
        this(par1World);
        setTamed(true);
        func_152115_b(p.getUniqueID().toString());
        this.dataWatcher.updateObject(19, color);
    }
    
    public EntityGrizzle(World par1World) {
        super(par1World);
        this.setSize(0.8f, 1.2f);
    }
    
    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(19, 0);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.grizzleHealth);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.grizzleSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.grizzleFollowRange);
    }

    @Override
    public boolean interact(EntityPlayer player) {
        ItemStack stack = player.inventory.getCurrentItem();

        if (this.isTamed()) {
            if (stack != null) {
                if (stack.getItem() instanceof ItemFood) {
                    ItemFood var3 = (ItemFood)stack.getItem();

                    if (var3.isWolfsFavoriteMeat() && this.getHealth() < EntityStats.grizzleHealth) {
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
        return e.attackEntityFrom(DamageSource.causeMobDamage(this), (float)EntityStats.grizzleDamage);
    }

    @Override
    public String mobName() {
        return "Grizzle";
    }
    
    @Override
    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.grizzle);
    }

    @Override
    protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.grizzleHurt);
    }

    @Override
    protected String getDeathSound() {
        return Sounds.getSoundName(Sounds.grizzleHurt);
    }

    @Override
    public EntityAgeable createChild(EntityAgeable var1) {
        return null;
    }
    
    public int getColor() {
        return this.dataWatcher.getWatchableObjectInt(19);
    }
    
    public void setColor(int color) {
        this.dataWatcher.updateObject(19, color);
    }
    
    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setInteger("Color", this.getColor());
    }
    
    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        this.setColor(tag.getInteger("Color"));
    }
}