package net.divinerpg.entities.vanilla;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityPumpkinSpider extends EntityDivineRPGMob {

    public EntityPumpkinSpider(World par1World) {
        super(par1World);
        this.setSize(1.25F, 1F);
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte) 0));
        this.dataWatcher.addObject(17, 0);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.pumpkinSpiderHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.pumpkinSpiderDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.pumpkinSpiderSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.pumpkinSpiderFollowRange);
    }

    @Override
    protected String getLivingSound() {
        return null;
    }

    @Override
    protected String getHurtSound() {
        return "mob.spider.say";
    }

    @Override
    protected String getDeathSound() {
        return "mob.spider.death";
    }

    @Override
    public void addVelocity(double x, double y, double z) {
        if(this.getProvoked())super.addVelocity(x, y, z);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if(!getProvoked()) {
            this.renderYawOffset=0;
            if(this.worldObj.getClosestVulnerablePlayerToEntity(this, 6) != null) this.setProvoked();
        } else {
            if(!this.worldObj.isRemote) {
                this.setBesideClimbableBlock(this.isCollidedHorizontally);
            }
        }
    }

    public boolean needsSpecialAI() {
        return true;
    }

    public boolean getProvoked() {
        return this.dataWatcher.getWatchableObjectInt(17)==1;
    }

    public void setProvoked() {
        this.dataWatcher.updateObject(17, 1);
        addBasicAI();
        addAttackingAI();
    }

    @Override
    protected void dropFewItems(boolean hit, int looting) {
        this.dropItem(VanillaItemsOther.terranShards, this.rand.nextInt(3 + looting));
        this.dropItem(Item.getItemFromBlock(Blocks.pumpkin), 1);
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.worldObj.getBlock((int)this.posX, MathHelper.floor_double(this.boundingBox.minY)-1, (int)this.posZ) == Blocks.grass && super.getCanSpawnHere();
    }

    @Override
    public String mobName() {
        return "Pumpkin Spider";
    }

    public void setBesideClimbableBlock(boolean var1) {
        byte var2 = this.dataWatcher.getWatchableObjectByte(16);

        if(var1) {
            var2 = (byte)(var2 | 1);
        } else {
            var2 &= -2;
        }
        this.dataWatcher.updateObject(16, Byte.valueOf(var2));
    }

    public boolean isBesideClimbableBlock() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }

    @Override
    public boolean isOnLadder() {
        return this.getProvoked() && this.isBesideClimbableBlock();
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setBoolean("Provoked", this.getProvoked());
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        if(tag.getBoolean("Provoked"))setProvoked();
    }
}