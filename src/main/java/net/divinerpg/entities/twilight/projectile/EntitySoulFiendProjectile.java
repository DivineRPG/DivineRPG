package net.divinerpg.entities.twilight.projectile;

import java.awt.Color;

import net.divinerpg.entities.fx.EntityColoredFX;
import net.divinerpg.entities.twilight.EntitySoulSpider;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntitySoulFiendProjectile extends EntityThrowable {

	public EntitySoulFiendProjectile(World w) {
		super(w);
	}
	
	public EntitySoulFiendProjectile(World w, EntityLivingBase shooter) {
		super(w, shooter);
	}

	@Override
	protected void onImpact(MovingObjectPosition pos) {
		if(pos.entityHit==null) {
			for(int i = 0; i<3; i++) {
				EntitySoulSpider e = new EntitySoulSpider(this.worldObj);
				e.setLocationAndAngles(this.posX, this.posY, this.posZ, 0, 0);
				if(!this.worldObj.isRemote) this.worldObj.spawnEntityInWorld(e);
			}
			this.setDead();
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void onUpdate() {
		super.onUpdate();
		for (int var3 = 0; var3 < 8; ++var3) {
    		EntityColoredFX e = new EntityColoredFX(this.worldObj, this.posX+(rand.nextDouble()-rand.nextDouble())/4, this.posY+(rand.nextDouble()-rand.nextDouble())/4, this.posZ+(rand.nextDouble()-rand.nextDouble())/4, 0, 0, 0, new Color(0, 0, 0));
    		e.bigger = true;
    		FMLClientHandler.instance().getClient().effectRenderer.addEffect(e);
    		
    		EntityColoredFX e2 = new EntityColoredFX(this.worldObj, this.posX+(rand.nextDouble()-rand.nextDouble())/4, this.posY+(rand.nextDouble()-rand.nextDouble())/4, this.posZ+(rand.nextDouble()-rand.nextDouble())/4, 0, 0, 0, new Color(255, 0, 0));
    		e2.bigger = true;
    		e2.shortLived=true;
    		FMLClientHandler.instance().getClient().effectRenderer.addEffect(e2);
    	}
	}

}
