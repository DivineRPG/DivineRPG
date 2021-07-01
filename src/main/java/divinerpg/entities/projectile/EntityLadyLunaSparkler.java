package divinerpg.entities.projectile;

import divinerpg.enums.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntityLadyLunaSparkler extends EntityParticleBullet {
    public EntityLadyLunaSparkler(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public EntityLadyLunaSparkler(EntityType<? extends ThrowableEntity> type, World world, LivingEntity entity) {
        super(type, world, entity, BulletType.LUNA_SPARKLER);
        setDeltaMovement(0, 0, 0);
    }


    @Override
    public float getGravity() {
        return 0;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getOwner() != null && this.getOwner() instanceof LivingEntity && ((LivingEntity) this.getOwner()).getLastHurtByMob() != null) {
            double tx = ((LivingEntity) this.getOwner()).getLastHurtByMob().xo - this.getOwner().xo;
            double ty = ((LivingEntity) this.getOwner()).getLastHurtByMob().getBoundingBox().minY - this.getOwner().yo;
            double tz = ((LivingEntity) this.getOwner()).getLastHurtByMob().zo - this.getOwner().zo;
            if (!this.level.isClientSide && this.tickCount > 30) this.shoot(tx, ty, tz, 0.5f, 0);
        }
        if (!this.level.isClientSide && this.tickCount > 80) this.kill();
    }

    @Override
    public void onHitEntity(EntityRayTraceResult pos) {
        if (pos.getEntity() != null)
        {
            Entity entity = pos.getEntity();
            entity.hurt(DamageSources.arcanaSource, 12.0F);
        }
    }
}