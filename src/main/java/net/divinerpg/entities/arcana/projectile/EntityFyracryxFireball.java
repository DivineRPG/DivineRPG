package net.divinerpg.entities.arcana.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityFyracryxFireball extends EntitySmallFireball {

	public EntityFyracryxFireball(World par1World) {
		super(par1World);
	}

	public EntityFyracryxFireball(World par1World, EntityLiving par2EntityLiving, double par3, double par5, double par7) {
		super(par1World, par2EntityLiving, par3, par5, par7);
	}

	@SideOnly(Side.CLIENT)
	public EntityFyracryxFireball(World par1World, double par2, double par4, double par6, double par8, double par10, double par12) {
		super(par1World, par2, par4, par6, par8, par10, par12);
	}

	@Override
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
		if (!this.worldObj.isRemote) {
			if (par1MovingObjectPosition.entityHit != null) 
				par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 6);
			this.worldObj.newExplosion((Entity)null, this.posX, this.posY, this.posZ, 1.0F, true, false);
			this.setDead();
		}
	}
}