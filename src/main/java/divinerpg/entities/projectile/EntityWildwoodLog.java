package divinerpg.entities.projectile;

import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntityWildwoodLog extends DivineThrowable {

	public EntityWildwoodLog(EntityType<? extends ThrowableEntity> type, World world) {
		super(type, world);
	}

	public EntityWildwoodLog(EntityType<? extends ThrowableEntity> type, LivingEntity entity, World world) {
		super(type, entity, world);
	}

	@Override
	protected void onHit(RayTraceResult result) {
		if (result.hitInfo != null) {
			((LivingEntity)result.hitInfo).hurt(DamageSource.thrown(this, this.getOwner()), 8.0F);
	    }
	    if (!this.level.isClientSide) {
			level.addFreshEntity(new ItemEntity(level, this.xo, this.yo, this.zo, new ItemStack(getBlock())));
	        this.kill();
	    }
	}
	
	public static Block getBlock() {
		return BlockRegistry.wildwoodLog;
	}
}