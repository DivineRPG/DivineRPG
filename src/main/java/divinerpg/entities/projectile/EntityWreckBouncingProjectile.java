package divinerpg.entities.projectile;

import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntityWreckBouncingProjectile extends DivineThrowable
{
    public int damage;
    public LivingEntity thrower;
    protected int bounces;

    public EntityWreckBouncingProjectile(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public EntityWreckBouncingProjectile(EntityType<? extends ThrowableEntity> type, double x, double y, double z, World world) {
        super(type, x, y, z, world);
        this.setDeltaMovement(this.getDeltaMovement().x * 0.01D, this.getDeltaMovement().y * 0.01D, this.getDeltaMovement().z * 0.01D);
    }

    public EntityWreckBouncingProjectile(EntityType<? extends ThrowableEntity> type, World world, LivingEntity entity, int damage) {
        super(type, entity, world);
        this.damage = damage;
        this.thrower = entity;
    }

    @Override
    protected void onHit(RayTraceResult par1) {
        if (par1.hitInfo != null && par1.hitInfo != this.thrower) {
            ((LivingEntity)par1.hitInfo).hurt(DamageSources.arcanaSource, this.damage);

            if (!this.level.isClientSide) {
                this.kill();
            }
            return;
        }
    }

    @Override
    protected void onHitBlock(BlockRayTraceResult result) {
        super.onHitBlock(result);
        if (result.getDirection() == Direction.DOWN || result.getDirection() == Direction.UP) {
            setDeltaMovement(getDeltaMovement().x, getDeltaMovement().y * -1.0D, getDeltaMovement().z);
        } else if (result.getDirection() == Direction.EAST || result.getDirection() == Direction.WEST) {
            setDeltaMovement(getDeltaMovement().x, getDeltaMovement().y, getDeltaMovement().z * -1.0D);
        } else if (result.getDirection() == Direction.NORTH || result.getDirection() == Direction.SOUTH) {
            setDeltaMovement(getDeltaMovement().x * -1.0D, getDeltaMovement().y, getDeltaMovement().z);
        }
        this.bounces++;

        if (this.bounces == 7) {
            this.kill();
        }
    }
}