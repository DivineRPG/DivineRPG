package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntityMandragoraProjectile extends EntityHeatSeekingProjectile {
    private LivingEntity thrower;

    public EntityMandragoraProjectile(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
        this.setPlayersOnly();
    }

    public EntityMandragoraProjectile(EntityType<? extends ThrowableEntity> type, LivingEntity entity, World world) {
        super(type, entity, world);
        this.setPlayersOnly();
    }


    @Override
    protected void onHitEntity(EntityRayTraceResult pos) {
        if (pos.getEntity() != null && pos.getEntity() != this.thrower) {
            Entity entity = pos.getEntity();
            entity.hurt(DamageSource.thrown(this, this.thrower), 4.0F);
        }

        if (!this.level.isClientSide) {
            this.kill();
        }
    }
}
