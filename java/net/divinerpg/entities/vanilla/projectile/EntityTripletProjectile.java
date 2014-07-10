package net.divinerpg.entities.vanilla.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityTripletProjectile extends EntityFireball {
	
	public EntityTripletProjectile(World par1World) {
		super(par1World);
		this.isImmuneToFire = true;
	}

	@SideOnly(Side.CLIENT)
	public EntityTripletProjectile(World par1World, double par2, double par4, double par6, double par8, double par10, double par12) {
		super(par1World, par2, par4, par6, par8, par10, par12);
	}

	public EntityTripletProjectile(World par1World, EntityLiving par2EntityLiving, double par3, double par5, double par7) {
		super(par1World, par2EntityLiving, par3, par5, par7);
	}

	@Override
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
		if (!this.worldObj.isRemote) {
			if (par1MovingObjectPosition.entityHit != null) {
				par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 20);
			}

			float var10 = 0.25F;
			this.worldObj.spawnParticle("portal", this.posX - this.motionX * (double)var10 + this.rand.nextDouble() * 0.6D - 0.3D, this.posY - this.motionY * (double)var10 - 0.5D, this.posZ - this.motionZ * (double)var10 + this.rand.nextDouble() * 0.6D - 0.3D, this.motionX, this.motionY, this.motionZ);
			this.worldObj.createExplosion((Entity)null, this.posX, this.posY, this.posZ, 3.0F, false);
			this.setDead();
		}
	}
	@SideOnly(Side.CLIENT)
	@Override
	public void onUpdate() {
		super.onUpdate();
		float var10 = 0.25F;
		EntityTripletFX var20 = new EntityTripletFX(worldObj, this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D);
		FMLClientHandler.instance().getClient().effectRenderer.addEffect(var20);
		for(int i = 0; i < 4; i++)
			this.worldObj.spawnParticle("portal", this.posX - this.motionX * (double)var10 + this.rand.nextDouble() * 0.6D - 0.3D, this.posY - this.motionY * (double)var10 - 0.5D, this.posZ - this.motionZ * (double)var10 + this.rand.nextDouble() * 0.6D - 0.3D, this.motionX, this.motionY, this.motionZ);
	}
}