package divinerpg.entities.projectile;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class EntityAttractor extends DivineThrowable {
	
	int age;

	public EntityAttractor(EntityType<? extends ThrowableProjectile> type, Level world) {
		super(type, world);
	}

	public EntityAttractor(EntityType<? extends ThrowableProjectile> type, LivingEntity e, Level w) {
		super(type, e, w);
		setDeltaMovement(getDeltaMovement().x * 3, getDeltaMovement().y * 3, getDeltaMovement().z * 3);
	}

	@Override
	protected void onHitEntity(EntityHitResult pos) {
		if(tickCount != 1 || tickCount != 0) {
			if (pos.getEntity() != null && this.getOwner() != null) {
				Entity entity = pos.getEntity();
				double xDist = (this.getOwner().getX() - entity.getX()) / 5, yDist = (this.getOwner().getY() - entity.getY()) / 5, zDist = (this.getOwner().getZ() - entity.getZ()) / 5;
				entity.setDeltaMovement(xDist, yDist, zDist);
			}
			this.kill();
		}
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