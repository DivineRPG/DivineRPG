package divinerpg.entities.projectile;

import divinerpg.util.*;

import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class EntityBouncingProjectile extends DivineThrowable {
    public int damage;
    public LivingEntity thrower;
    protected int bounces;

    public EntityBouncingProjectile(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntityBouncingProjectile(EntityType<? extends ThrowableProjectile> type, double x, double y, double z, Level world) {
        super(type, x, y, z, world);
        setDeltaMovement(xo * 0.01D, yo * 0.01D, zo * 0.01D);
    }

    public EntityBouncingProjectile(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world, int damage) {
        super(type, entity, world);
        this.damage = damage;
        this.thrower = entity;

        Vec3 vector = entity.getLookAngle().scale(1.5);
        this.moveTo(getX() + vector.x, getY() + vector.y, getZ() + vector.z);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        if(tickCount != 1 || tickCount != 0) {
            if (result.getEntity() != null && result.getEntity() != this.thrower && result.getEntity() instanceof LivingEntity) {
                LivingEntity entity = (LivingEntity) result.getEntity();
                entity.hurt(DamageSources.source(level(), DamageSources.ARCANA), this.damage);
                if (!this.level().isClientSide) {
                    this.kill();
                }
                return;
            }

            this.bounces++;

            if (this.bounces == 7) {
                this.kill();
            }
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        if (tickCount != 1 || tickCount != 0) {
            super.onHitBlock(result);
            if (result.getDirection() == Direction.DOWN || result.getDirection() == Direction.UP) {
                setDeltaMovement(getDeltaMovement().x, getDeltaMovement().y * -1, getDeltaMovement().z);
            } else if (result.getDirection() == Direction.EAST || result.getDirection() == Direction.WEST) {
                setDeltaMovement(getDeltaMovement().x, getDeltaMovement().y, getDeltaMovement().z * -1);
            } else if (result.getDirection() == Direction.NORTH || result.getDirection() == Direction.SOUTH) {
                setDeltaMovement(getDeltaMovement().x * -1, getDeltaMovement().y, getDeltaMovement().z);
            }
            this.bounces++;

            if (this.bounces == 7) {
                this.kill();
            }
        }
    }

}