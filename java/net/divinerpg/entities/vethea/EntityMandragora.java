package net.divinerpg.entities.vethea;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.entities.vethea.projectile.EntityMandragoraProjectile;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityMandragora extends EntityDivineRPGMob implements IRangedAttackMob {
	
    private static final double spawnLayer = 2;

    public EntityMandragora(World var1) {
        super(var1);
        addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.mandragoraHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.mandragoraDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.mandragoraSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.mandragoraFollowRange);
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 64.0D * spawnLayer  && this.posY > 64.0D * (spawnLayer - 1) && super.getCanSpawnHere();
    }

    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    protected String getLivingSound() {
        return Sounds.mandragora.getPrefixedName();
    }

    @Override
    protected String getHurtSound() {
        return Sounds.mandragora.getPrefixedName();
    }

    @Override
    protected String getDeathSound() {
        return getHurtSound();
    }

  
    @Override
    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        if (par1DamageSource.isExplosion())
            return false;
        return super.attackEntityFrom(par1DamageSource, par2);
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase par1, float par2) {
        EntityMandragoraProjectile var1 = new EntityMandragoraProjectile(this.worldObj, this);
        this.playSound(Sounds.mandragora.getPrefixedName(), 1.0F, 2.0F);
        var1.setVelocity(0, var1.motionY, 0);
        this.worldObj.spawnEntityInWorld(var1);
    }

    @Override
    protected void dropFewItems(boolean par1, int par2) {
        this.dropItem(VetheaItems.cleanPearls, 1);
    }

	@Override
	public String mobName() {
		return "Mandragora";
	}
}