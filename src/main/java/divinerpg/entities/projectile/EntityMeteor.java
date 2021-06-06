package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntityMeteor extends DivineThrowable {
    public EntityMeteor(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
        setDeltaMovement(level.random.nextGaussian() * 0.05, -0.5, level.random.nextGaussian() * 0.05);
    }

    public EntityMeteor(EntityType<? extends ThrowableEntity> type, double x, double y, double z, World world) {
        super(type, x, y, z, world);
        setDeltaMovement(level.random.nextGaussian() * 0.05, -0.5, level.random.nextGaussian() * 0.05);
    }

    public EntityMeteor(EntityType<? extends ThrowableEntity> type, LivingEntity entity, World world) {
        super(type, entity, world);
        setDeltaMovement(level.random.nextGaussian() * 0.05, -0.5, level.random.nextGaussian() * 0.05);
    }

    @Override
    protected float getGravity() {
        return 0.07F;
    }

    @Override
    protected void onHit(RayTraceResult result) {
        if(result.hitInfo != null && result.hitInfo instanceof Entity) {
            Entity entity = (Entity) result.hitInfo;
            entity.hurt(DamageSource.thrown(this, this.getOwner()), 12);
        }

        level.explode(this, this.xo, this.yo, this.zo, 4.5F, false, Explosion.Mode.BREAK);

        if(!this.level.isClientSide) {
            this.kill();
        }
    }
}