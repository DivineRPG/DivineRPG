package divinerpg.entities.projectile;

import divinerpg.enums.*;
import divinerpg.util.*;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class EntityLadyLunaSparkler extends EntityParticleBullet {
    public EntityLadyLunaSparkler(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntityLadyLunaSparkler(EntityType<? extends ThrowableProjectile> type, Level world, LivingEntity entity) {
        super(type, world, entity, BulletType.LUNA_SPARKLER);
        setDeltaMovement(0, 0, 0);
    }


    @Override public boolean isNoGravity() {return true;}

    @Override
    public void tick() {
        super.tick();
        if (this.getOwner() != null && this.getOwner() instanceof LivingEntity && ((LivingEntity) this.getOwner()).getLastHurtByMob() != null) {
            double tx = ((LivingEntity) this.getOwner()).getLastHurtByMob().xo - this.getOwner().xo;
            double ty = ((LivingEntity) this.getOwner()).getLastHurtByMob().getBoundingBox().minY - this.getOwner().yo;
            double tz = ((LivingEntity) this.getOwner()).getLastHurtByMob().zo - this.getOwner().zo;
            if (!this.level().isClientSide() && this.tickCount > 30) this.shoot(tx, ty, tz, 0.5f, 0);
        }
        if (!this.level().isClientSide() && this.tickCount > 80) this.kill();
    }

    @Override
    public void onHitEntity(EntityHitResult pos) {
        if (tickCount != 1 || tickCount != 0) {
            if (pos.getEntity() != null) {
                Entity entity = pos.getEntity();
                entity.hurt(DamageSources.source(level(), DamageSources.SPIKE), 12.0F);
            }
        }
    }
}