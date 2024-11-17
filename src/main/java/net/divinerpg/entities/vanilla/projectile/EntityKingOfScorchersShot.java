package net.divinerpg.entities.vanilla.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityKingOfScorchersShot extends EntityThrowable {

	public EntityKingOfScorchersShot(World par1World) {
		super(par1World);
	}
	
	public EntityKingOfScorchersShot(World par1World, EntityLivingBase e) {
		super(par1World, e);
	}
	
	public EntityKingOfScorchersShot(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }
	
	@Override
	public float getGravityVelocity() {
		return 0;
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		if(!worldObj.isRemote) {
			if(this.ticksExisted>200)this.setDead();
		}
	}

	@Override
	protected void onImpact(MovingObjectPosition pos) {
		if(!worldObj.isRemote) {
			if(pos.entityHit != null) {
				pos.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 14);
				pos.entityHit.setFire(8);
			}
			this.setDead();
		}
	}
}