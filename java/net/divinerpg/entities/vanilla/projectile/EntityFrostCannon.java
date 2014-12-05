package net.divinerpg.entities.vanilla.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityFrostCannon extends EntityThrowable {
	
    public EntityFrostCannon(World par1World) {
        super(par1World);
    }

    public EntityFrostCannon(World par1World, EntityLivingBase par2EntityLivingBase) {
        super(par1World, par2EntityLivingBase);
    }

    public EntityFrostCannon(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.entityHit != null) {
            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 8);
        }


        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }
}