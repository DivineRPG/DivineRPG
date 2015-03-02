package net.divinerpg.entities.vanilla.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityWatcherShot extends EntityThrowable {

	public EntityWatcherShot(World w) {
		super(w);
	}
	
    public EntityWatcherShot(World var1, EntityLivingBase var2) {
        super(var1, var2);
    }

    @Override
    protected void onImpact(MovingObjectPosition var1) {
    	if(!this.worldObj.isRemote)this.worldObj.createExplosion(null, this.posX, this.posY, this.posZ, 5.0F, true);
        if (var1.entityHit != null) var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 4.0F);

        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }
}