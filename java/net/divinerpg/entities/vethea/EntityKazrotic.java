package net.divinerpg.entities.vethea;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.entities.vethea.projectile.EntityKazroticShot;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityKazrotic extends EntityDivineRPGMob implements IRangedAttackMob {
	
    private static final double spawnLayer = 3;

    public EntityKazrotic(World par1World) {
        super(par1World);
        addAttackingAI();
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 64.0D * spawnLayer  && this.posY > 64.0D * (spawnLayer - 1) && super.getCanSpawnHere();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.kazroticHealth);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.kazroticSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.kazroticFollowRange);
    }
    
    @Override
    protected String getLivingSound() {
        return Sounds.kazrotic.getPrefixedName();
    }

    @Override

    protected String getHurtSound() {
        return Sounds.kazroticHurt.getPrefixedName();
    }

    @Override
    protected String getDeathSound() {
        return getHurtSound();
    }
    
    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase par1, float par2) {
        EntityKazroticShot var1 = new EntityKazroticShot(this.worldObj, this);
        var1.setThrowableHeading(var1.motionX, var1.motionY, var1.motionZ, 0.3F, 0.3F);
        this.playSound("random.bow", 1.0F, 1.0F);
        this.worldObj.spawnEntityInWorld(var1);
    }

    @Override
    public boolean attackEntityFrom(DamageSource par1, float par2) {
        if (par1.isExplosion())
            return false;
        return super.attackEntityFrom(par1, par2);
    }

    @Override
    protected void dropFewItems(boolean par1, int par2) {
        this.dropItem(VetheaItems.polishedPearls, 1);
    }

	@Override
	public String mobName() {
		return "Kazrotic";
	}
}