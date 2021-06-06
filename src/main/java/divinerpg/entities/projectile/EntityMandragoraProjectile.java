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
    protected void onHit(RayTraceResult pos) {
        if (pos.hitInfo != null && pos.hitInfo != this.thrower && pos.hitInfo instanceof Entity) {
            Entity entity = (Entity) pos.hitInfo;
            entity.hurt(DamageSource.thrown(this, this.thrower), 4.0F);
        }

        if (!this.level.isClientSide) {
            this.kill();
        }
    }
}
