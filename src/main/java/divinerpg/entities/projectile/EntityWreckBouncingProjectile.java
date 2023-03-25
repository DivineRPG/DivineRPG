package divinerpg.entities.projectile;

import divinerpg.util.*;

import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class EntityWreckBouncingProjectile extends DivineThrowable
{
    public int damage;
    public LivingEntity thrower;
    protected int bounces;

    public EntityWreckBouncingProjectile(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntityWreckBouncingProjectile(EntityType<? extends ThrowableProjectile> type, double x, double y, double z, Level world) {
        super(type, x, y, z, world);
        this.setDeltaMovement(this.getDeltaMovement().x * 0.01D, this.getDeltaMovement().y * 0.01D, this.getDeltaMovement().z * 0.01D);
    }

    public EntityWreckBouncingProjectile(EntityType<? extends ThrowableProjectile> type, Level world, LivingEntity entity, int damage) {
        super(type, entity, world);
        this.damage = damage;
        this.thrower = entity;
    }

    @Override
    protected void onHitEntity(EntityHitResult par1) {
        if (tickCount != 1 || tickCount != 0) {
            if (par1.getEntity() != null && par1.getEntity() != this.thrower) {
                par1.getEntity().hurt(DamageSources.source(level, DamageSources.SPIKE), this.damage);

                if (!this.level.isClientSide) {
                    this.kill();
                }
                return;
            }
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        if(tickCount != 1 || tickCount != 0) {
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
}