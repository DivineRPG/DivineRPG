package net.divinerpg.entities.arcana.projectile;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityReflector extends EntityThrowable {
	
    public EntityReflector(World var1) {
        super(var1);
    }

    public EntityReflector(World var1, EntityLiving var2) {
        super(var1, var2);
    }

    public EntityReflector(World var1, double var2, double var4, double var6) {
        super(var1, var2, var4, var6);
    }

    @Override
    protected void onImpact(MovingObjectPosition var1) {
        if (var1.entityHit != null) {
            var1.entityHit.addVelocity((double)(this.motionX * 3.0D), 0.1D, (double)(this.motionZ * 3.0D));
        }

        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }
}