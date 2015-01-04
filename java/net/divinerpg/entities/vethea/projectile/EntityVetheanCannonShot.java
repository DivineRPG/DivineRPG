package net.divinerpg.entities.vethea.projectile;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;


public class EntityVetheanCannonShot extends EntityThrowable {
	
    public int damage;
    public EntityVetheanCannonShot(World par1) {
        super(par1);
    }

    public EntityVetheanCannonShot(World par1, EntityLivingBase par2, int par3) {
        super(par1, par2);
        this.damage = par3;
        if(par2 instanceof EntityDivineRPGMob) this.setThrowableHeading(((EntityDivineRPGMob)par2).getEntityToAttack().posX, ((EntityDivineRPGMob)par2).getEntityToAttack().posY, ((EntityDivineRPGMob)par2).getEntityToAttack().posZ, this.func_70182_d(), 1.0F);
    }

    public EntityVetheanCannonShot(World par1, double par2, double par4, double par6) {
        super(par1, par2, par4, par6);
    }

    @Override
    protected void onImpact(MovingObjectPosition par1) {
        if (par1.entityHit != null) {
            par1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), this.damage);
        }

        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }
}