package net.divinerpg.entities.twilight.projectile;

import java.awt.Color;

import net.divinerpg.client.render.EntityResourceLocation;
import net.divinerpg.entities.twilight.EntityParticleBullet;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityTwilightDemonShot extends EntityParticleBullet {
	
	public EntityTwilightDemonShot(World world) {
		super(world);
		setMoreParticles();
	}

	public EntityTwilightDemonShot(World world, EntityLivingBase e) {
		super(world, e, 16, EntityResourceLocation.twilightDemonShot.toString(), new Color(0, 0, 0));
		setMoreParticles();
		if(this.rand.nextInt(50)==0)this.setColor(new Color(255, 0, 0));
	}

	@Override
	public float getGravityVelocity() {
		return 0;
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		if(!this.worldObj.isRemote && this.ticksExisted>20)this.setDead();
	}
	
	@Override
	public void onImpact(MovingObjectPosition pos) {
		super.onImpact(pos);
		if(pos.entityHit != null && pos.entityHit instanceof EntityPlayer) ((EntityPlayer)pos.entityHit).addPotionEffect(new PotionEffect(Potion.confusion.id, 200, 0, true));
	}
}
