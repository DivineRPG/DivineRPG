package divinerpg.entities.projectile;

import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.*;
import net.minecraft.world.*;

public class EntityBouncingProjectile extends DivineThrowable {
    public int damage;
    public LivingEntity thrower;
    protected int bounces;

    public EntityBouncingProjectile(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public EntityBouncingProjectile(EntityType<? extends ThrowableEntity> type, double x, double y, double z, World world) {
        super(type, x, y, z, world);
        setDeltaMovement(xo * 0.01D, yo * 0.01D, zo * 0.01D);
    }

    public EntityBouncingProjectile(EntityType<? extends ThrowableEntity> type, LivingEntity entity, World world, int damage) {
        super(type, entity, world);
        this.damage = damage;
        this.thrower = entity;

        Vector3d vector = entity.getLookAngle().scale(1.5);
        this.moveTo(getX() + vector.x, getY() + vector.y, getZ() + vector.z);
    }

    @Override
    protected void onHit(RayTraceResult result) {
        if (result.hitInfo != null && result.hitInfo != this.thrower) {
            if (result.hitInfo instanceof Entity) {
                Entity entity = (Entity) result.hitInfo;
                entity.hurt(DamageSources.arcanaSource, this.damage);
            }
            if (!this.level.isClientSide) {
                this.kill();
            }
            return;
        }

        this.bounces++;

        if (this.bounces == 7) {
            this.kill();
        }
    }

    @Override
    protected void onHitBlock(BlockRayTraceResult result) {
        super.onHitBlock(result);
        if (result.getDirection() == Direction.DOWN || result.getDirection() == Direction.UP) {
            setDeltaMovement(getDeltaMovement().x, getDeltaMovement().y * -1, getDeltaMovement().z);
        } else if (result.getDirection() == Direction.EAST || result.getDirection() == Direction.WEST) {
            setDeltaMovement(getDeltaMovement().x, getDeltaMovement().y, getDeltaMovement().z * -1);
        } else if (result.getDirection() == Direction.NORTH || result.getDirection() == Direction.SOUTH) {
            setDeltaMovement(getDeltaMovement().x * -1, getDeltaMovement().y, getDeltaMovement().z);
        }
    }

}