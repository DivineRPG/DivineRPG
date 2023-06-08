package divinerpg.entities.projectile;


import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class EntityMandragoraProjectile extends EntityHeatSeekingProjectile {
    private LivingEntity thrower;

    public EntityMandragoraProjectile(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
        this.setPlayersOnly();
    }

    public EntityMandragoraProjectile(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world) {
        super(type, entity, world);
        this.setPlayersOnly();
    }


    @Override
    protected void onHitEntity(EntityHitResult pos) {
        if(tickCount != 1 || tickCount != 0) {
            if (pos.getEntity() != null && pos.getEntity() != this.thrower) {
                Entity entity = pos.getEntity();
                entity.hurt(damageSources().thrown(this, this.thrower), 4.0F);
            }

            if (!this.level().isClientSide) {
                this.kill();
            }
        }
    }
}
