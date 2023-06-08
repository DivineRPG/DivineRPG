package divinerpg.entities.projectile;

import divinerpg.entities.vanilla.overworld.EntitySaguaroWorm;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class EntitySaguaroWormShot extends DivineThrowable {

    public EntitySaguaroWormShot(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntitySaguaroWormShot(EntityType<? extends ThrowableProjectile> type, double x, double y, double z, Level world) {
        super(type, x, y, z, world);
    }

    public EntitySaguaroWormShot(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world) {
        super(type, entity, world);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        if(tickCount != 1 || tickCount != 0) {
            if (result.getEntity() != null && !(result.getEntity() instanceof EntitySaguaroWorm)) {
                result.getEntity().hurt(result.getEntity().level().damageSources().thrown(this, this.getOwner()), 4.0F);
            } else if (result.getEntity() == null) {
                if (!this.level().isClientSide)
                    this.kill();
            }
        }
    }

    @Override
    public float getGravity() {
        return 0;
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide && this.tickCount > 30)
            this.kill();
    }
}