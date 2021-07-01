package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntityAttractor extends DivineThrowable {
	
	int age;

	public EntityAttractor(EntityType<? extends ThrowableEntity> type, World world) {
		super(type, world);
	}

	public EntityAttractor(EntityType<? extends ThrowableEntity> type, LivingEntity e, World w) {
		super(type, e, w);
		setDeltaMovement(getDeltaMovement().x * 3, getDeltaMovement().y * 3, getDeltaMovement().z * 3);
	}

	@Override
	protected void onHitEntity(EntityRayTraceResult pos) {
		if(pos.getEntity() != null && this.getOwner() != null) {
				Entity entity = pos.getEntity();
				double xDist = (this.getOwner().getX() - entity.getX()) / 5, yDist = (this.getOwner().getY() - entity.getY()) / 5, zDist = (this.getOwner().getZ() - entity.getZ()) / 5;
				entity.setDeltaMovement(xDist, yDist, zDist);
		}
		this.kill();
	}

	@Override
	protected float getGravity() {
		return 0;
	}
	
	@Override
	public void tick() {
		super.tick();
		age++;
		if(age>18)this.kill();//I'm an Adult!
	}

}