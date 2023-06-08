package divinerpg.entities.projectile;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class EntityGrenade extends ThrowableProjectile {

	public EntityGrenade(EntityType<? extends ThrowableProjectile> type, Level world) {
		super(type, world);
	}

	@Override
	protected void onHit(HitResult result) {
		if(tickCount != 1 || tickCount != 0) {
			super.onHit(result);
			if (!this.level().isClientSide) {
				this.level().explode(this, this.xo, this.yo, this.zo, 3.0F, false, Level.ExplosionInteraction.TNT);
				this.level().broadcastEntityEvent(this, (byte) 3);
				this.kill();
			}
		}
	}

	@Override
	protected void defineSynchedData() {

	}
}

