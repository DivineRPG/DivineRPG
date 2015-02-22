package net.divinerpg.entities.arcana;

import java.awt.Color;

import net.divinerpg.DivineRPG;
import net.divinerpg.client.render.EntityResourceLocation;
import net.divinerpg.entities.twilight.EntityParticleBullet;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityGeneralsStaff extends EntityParticleBullet {

	public EntityGeneralsStaff(World world, EntityLivingBase entity) {
		super(world, entity, 18, EntityResourceLocation.generalsStaff.toString(), new Color(31, 93, 210));
	}

	@Override
    protected void onImpact(MovingObjectPosition position) {
		super.onImpact(position);
		if(!this.worldObj.isRemote) {
		for(double theta = 0; theta < Math.PI*2; theta += Math.PI/2) {
			EntityParticleBullet e = new EntityParticleBullet(this.worldObj, this.posX, this.posY, this.posZ, 18, this.getTextureName(), new Color(56, 152, 186));
			e.setThrowableHeading(Math.cos(theta), 0.1, Math.sin(theta), 1.6f, 12);
			this.worldObj.spawnEntityInWorld(e);
		}
		EntityParticleBullet e = new EntityParticleBullet(this.worldObj, this.posX, this.posY, this.posZ, 18, this.getTextureName(), new Color(56, 152, 186));
		e.setThrowableHeading(0, 1, 0, 1.6f, 12);
		this.worldObj.spawnEntityInWorld(e);
		EntityParticleBullet e1 = new EntityParticleBullet(this.worldObj, this.posX, this.posY, this.posZ, 18, this.getTextureName(), new Color(56, 152, 186));
		e1.setThrowableHeading(0, -1, 0, 1.6f, 12);
		this.worldObj.spawnEntityInWorld(e1);
		
		for(double h = -2.9; h<2.9; h += 0.2) {
			for(double r = 0; r < 2.9-Math.abs(h); r += 0.2) {
				for(double theta = 0; theta < Math.PI*2; theta += Math.PI/24) {
					DivineRPG.proxy.spawnParticle(this.worldObj, this.posX+Math.cos(theta)*r, this.posY+h-1, this.posZ+Math.sin(theta)*r, new Color(31, 93, 210), true);
				}
			}
		}
	}
	}

}