package net.divinerpg.entities.vethea;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityLorga extends EntityDivineRPGMob {
	
    private static final double spawnLayer = 1;
    private int lifeTick;
    private int spawnTick;
    public boolean canSpawnMinions;

    public EntityLorga(World var1, boolean canSpawnMinions) {
        super(var1);
        addAttackingAI();
        this.canSpawnMinions = canSpawnMinions;
        this.lifeTick = -1;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.lorgaHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.lorgaDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.lorgaSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.lorgaFollowRange);
    }
 
    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 64.0D * spawnLayer  && this.posY > 64.0D * (spawnLayer - 1) && super.getCanSpawnHere();
    }

    public EntityLorga(World var1, int life, boolean canSpawnMinions) {
        this(var1, canSpawnMinions);
        this.lifeTick = life;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.lifeTick == -1 && this.spawnTick == 0 && this.canSpawnMinions) {
            this.spawnTick = 120;
            EntityLorga var2 = new EntityLorga(this.worldObj, 10, false);
            var2.setLocationAndAngles(this.posX + 1, this.posY, this.posZ + 1, this.rotationYaw, this.rotationPitch);
            this.worldObj.spawnEntityInWorld(var2);
        }
        else if (this.spawnTick > 0) {
            this.spawnTick--;
        }
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