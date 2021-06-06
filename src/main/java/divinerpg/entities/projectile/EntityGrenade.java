package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntityGrenade extends DivineSnowball {

	public EntityGrenade(EntityType<? extends SnowballEntity> type, World world) {
		super(type, world);
	}

	public EntityGrenade(World world, LivingEntity entity) {
		super(world, entity);
	}

	@Override
	protected void onHit(RayTraceResult result) {
		if (!this.level.isClientSide) {
			this.level.explode(this, this.xo, this.yo, this.zo, 3.0F, false, Explosion.Mode.BREAK);
			this.kill();
		}
	}
}

