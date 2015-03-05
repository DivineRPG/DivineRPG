package net.divinerpg.entities.vanilla.projectile;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityKingOfScorchersMeteor extends EntityThrowable {

	public EntityKingOfScorchersMeteor(World par1World) {
		super(par1World);
	}
	
	public EntityKingOfScorchersMeteor(World par1World, EntityLivingBase e) {
		super(par1World, e);
	}
	
	public EntityKingOfScorchersMeteor(World par1World, double par2, double par4, double par6) {
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
			List<Entity> l = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.boundingBox);
			if(l.size()>0) {
				this.worldObj.createExplosion(this, posX, posY, posZ, 3.0F, false);
				this.setDead();
			}
		}
	}

	@Override
	protected void onImpact(MovingObjectPosition pos) {
		if(!worldObj.isRemote) {
			if(pos.entityHit != null) {
				this.worldObj.createExplosion(pos.entityHit, posX, posY, posZ, 3.0F, false);
				this.setDead();
			} else {
				this.motionX=this.motionY=this.motionZ=0;
			}
		}
	}
}