package net.divinerpg.entities.vethea;

import java.util.List;

import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityLorga extends VetheaMob {
	
    private int spawnTick;
    public boolean canSpawnMinions;
    
    public EntityLorga(World w) {
    	this(w, true);
    }

    public EntityLorga(World var1, boolean canSpawnMinions) {
        super(var1);
        addAttackingAI();
        this.canSpawnMinions = canSpawnMinions;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.lorgaHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.lorgaDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.lorgaSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.lorgaFollowRange);
    }
 
    @Override
    public int getSpawnLayer() {
    	return 1;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        List<EntityLorga> nearby = this.worldObj.getEntitiesWithinAABB(EntityLorga.class, this.boundingBox.expand(10, 10, 10));
        if (this.spawnTick == 0 && this.canSpawnMinions && !this.worldObj.isRemote && nearby.size() < 12) {
            this.spawnTick = 260;
            EntityLorga var2 = new EntityLorga(this.worldObj, false);
            var2.setLocationAndAngles(this.posX + 1, this.posY, this.posZ + 1, this.rotationYaw, this.rotationPitch);
            this.worldObj.spawnEntityInWorld(var2);
        }
        else if (this.spawnTick > 0) {
            this.spawnTick--;
        }
    }
    
    @Override
    public void writeToNBT(NBTTagCompound tag) {
    	super.writeToNBT(tag);
    	tag.setBoolean("CanSpawnMinions", this.canSpawnMinions);
    }
    
    @Override
    public void readFromNBT(NBTTagCompound tag) {
    	super.readFromNBT(tag);
    	this.canSpawnMinions = tag.getBoolean("CanSpawnMinions");
    }

    @Override
    protected String getLivingSound() {
        return Sounds.lorga.getPrefixedName();
    }

    @Override
    protected String getHurtSound() {
        return Sounds.lorgaHurt.getPrefixedName();
    }

    @Override
    protected String getDeathSound() {
        return getHurtSound();
    }
    
    @Override
    protected void dropFewItems(boolean par1, int par2) {
        this.dropItem(VetheaItems.dirtyPearls, 1);
    }

	@Override
	public String mobName() {
		return "Lorga";
	}
}