package divinerpg.objects.entities.entity.projectiles;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityAttractor extends EntityThrowable {
	
	int age;

	public EntityAttractor(World w) {
		super(w);
	}
	
	public EntityAttractor(World w, EntityPlayer e) {
		super(w, e);
		this.motionX*=3;
		this.motionY*=3;
		this.motionZ*=3;
	}

	@Override
	protected void onImpact(RayTraceResult pos) {
		if(pos.entityHit != null && this.getThrower() != null) {
			double xDist = (this.getThrower().posX - pos.entityHit.posX)/5, yDist = (this.getThrower().posY-pos.entityHit.posY)/5, zDist = (this.getThrower().posZ - pos.entityHit.posZ)/5;
			pos.entityHit.addVelocity(xDist, yDist, zDist);
		}
		this.setDead();
	}
	
	@Override
	public float getGravityVelocity() {
		return 0;
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		age++;
		if(age>18)this.setDead();//I'm an Adult!
	}
}