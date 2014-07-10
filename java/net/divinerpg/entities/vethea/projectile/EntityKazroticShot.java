package net.divinerpg.entities.vethea.projectile;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityKazroticShot extends EntityThrowable {
	
    public EntityKazroticShot(World par1World) {
        super(par1World);
    }

    public EntityKazroticShot(World par1World, EntityLiving par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }

    public EntityKazroticShot(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    @Override
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
        if(!this.worldObj.isRemote) {
            this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 9, false);
            this.setDead();
        }
    }

    protected float getGravityVelocity() {
        return 0.0007F;
    }
}