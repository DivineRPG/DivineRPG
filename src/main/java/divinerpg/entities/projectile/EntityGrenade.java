package divinerpg.entities.projectile;

import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntityGrenade extends DivineSnowball {

	public EntityGrenade(EntityType<? extends DivineSnowball> type, World world) {
		super(type, world);
	}

	@Override
	protected Item getDefaultItem() {
		return ItemRegistry.grenade;
	}

	@Override
	protected void onHit(RayTraceResult result) {
		super.onHit(result);
		if (!this.level.isClientSide) {
			this.level.explode(this, this.xo, this.yo, this.zo, 3.0F, false, Explosion.Mode.BREAK);
			this.level.broadcastEntityEvent(this, (byte)3);
			this.remove();
		}
	}
}

