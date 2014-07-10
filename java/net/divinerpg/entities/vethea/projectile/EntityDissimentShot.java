package net.divinerpg.entities.vethea.projectile;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityDissimentShot extends EntityThrowable {
	
    public EntityDissimentShot(World var1) {
        super(var1);
    }

    public EntityDissimentShot(World var1, EntityLiving var2) {
        super(var1, var2);
    }

    public EntityDissimentShot(World var1, double var2, double var4, double var6) {
        super(var1, var2, var4, var6);
    }

    @Override
    protected void onImpact(MovingObjectPosition var1) {
        if(var1.entityHit != null) {
            byte var2 = 9;
            var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), var2);
        }

        if(!this.worldObj.isRemote) {
            this.setDead();
        }
    }
}