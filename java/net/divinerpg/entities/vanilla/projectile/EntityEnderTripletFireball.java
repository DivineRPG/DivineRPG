package net.divinerpg.entities.vanilla.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityEnderTripletFireball extends EntityFireball{

	public EntityEnderTripletFireball(World world, EntityLivingBase entity, double i, double j, double k) {
		super(world, entity, i, j, k);
	}
	
	public EntityEnderTripletFireball(World world) {
		super(world);
	}

	@Override
	protected void onImpact(MovingObjectPosition mop) {
		if(!this.worldObj.isRemote) {
			if(mop.entityHit != null && mop.entityHit instanceof EntityLivingBase) mop.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 10);
			this.worldObj.createExplosion(null, this.posX, this.posY, this.posZ, 3F, false);
			this.setDead();
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void onUpdate() {
		super.onUpdate();
		EntityTripletFX fx = new EntityTripletFX(this.worldObj, this.posX + (this.rand.nextDouble() - this.rand.nextDouble()) / 6, this.posY + 0.5D + (this.rand.nextDouble() - this.rand.nextDouble()) / 6, this.posZ + (this.rand.nextDouble() - this.rand.nextDouble()) / 6, 0.0D, 0.0D, 0.0D);
		FMLClientHandler.instance().getClient().effectRenderer.addEffect(fx);
	}
}
