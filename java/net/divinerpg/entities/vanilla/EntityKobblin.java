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

public class EntityKobblin extends EntityDivineRPGMob {

    public EntityKobblin(World par1World) {
        super(par1World);
        this.setSize(0.75F, 1F);
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(18, 0);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.kobblinHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.kobblinDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.kobblinSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.kobblinFollowRange);
    }

    @Override
    protected String getLivingSound() {
        return null;
    }

    @Override
    protected void func_145780_a(int x, int y, int z, Block b) {}

    @Override
    protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.kobblin);
    }

    @Override
    protected String getDeathSound() {
        return Sounds.getSoundName(Sounds.kobblin);
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
            if(this.worldObj.getClosestVulnerablePlayerToEntity(this, 4) != null) {
                this.setProvoked();
                this.motionY=0.6;
            }
        }
    }

    public boolean needsSpecialAI() {
        return true;
    }

    public boolean getProvoked() {
        return this.dataWatcher.getWatchableObjectInt(18)==1;
    }

    public void setProvoked() {
        this.dataWatcher.updateObject(18, 1);
        addBasicAI();
        addAttackingAI();
    }

    @Override
    protected Item getDropItem() {
        return VanillaItemsOther.terranShards;
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.worldObj.getBlock((int)this.posX, MathHelper.floor_double(this.boundingBox.minY)-1, (int)this.posZ) == Blocks.grass && this.worldObj.getBlock((int)this.posX, MathHelper.floor_double(this.boundingBox.minY)-2, (int)this.posZ) != Blocks.air && super.getCanSpawnHere();
    }

    @Override
    public String mobName() {
        return "Kobblin";
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