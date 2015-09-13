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
        this.dataWatcher.addObject(17, 0);
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
    protected void playStepSound(int x, int y, int z, Block b) {}

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
    public void setDead() {
        super.setDead();
        if(!getProvoked()) this.worldObj.setBlock((int)Math.round(this.posX)-1, MathHelper.floor_double(this.posY), (int)Math.round(this.posZ)-1, Blocks.grass);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if(!getProvoked()) {
            this.renderYawOffset=0;
            if(this.worldObj.getClosestVulnerablePlayerToEntity(this, 4) != null) this.setProvoked();
        }
        if(!this.worldObj.isRemote && !getGrounded()) {
            if(this.worldObj.getBlock((int) Math.round(this.posX)-1, MathHelper.floor_double(this.posY) - 1, (int) Math.round(this.posZ)-1) == Blocks.grass) {
                this.worldObj.setBlock((int) Math.round(this.posX)-1, MathHelper.floor_double(this.posY) - 1, (int) Math.round(this.posZ)-1, Blocks.air);
                this.setGrounded();
            }
        }
    }

    public boolean needsSpecialAI() {
        return true;
    }

    public boolean getGrounded() {
        return this.dataWatcher.getWatchableObjectInt(17)==1;
    }

    public boolean getProvoked() {
        return this.dataWatcher.getWatchableObjectInt(18)==1;
    }

    public void setGrounded() {
        this.dataWatcher.updateObject(17, 1);
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
        return this.worldObj.getBlock((int)this.posX, MathHelper.floor_double(this.boundingBox.minY)-1, (int)this.posZ) == Blocks.grass && super.getCanSpawnHere();
    }

    @Override
    public String mobName() {
        return "Kobblin";
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setBoolean("InGround", this.getGrounded());
        tag.setBoolean("Provoked", this.getProvoked());
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        if(tag.getBoolean("InGround"))setGrounded();
        if(tag.getBoolean("Provoked"))setProvoked();
    }
}