package divinerpg.entities.projectile;


import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;

public class EntityCorruptedBullet extends DivineThrowable {
    public static float damage = 10.0F;

    public EntityCorruptedBullet(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntityCorruptedBullet(EntityType<? extends ThrowableProjectile> type, double x, double y, double z, Level world) {
        super(type, x, y, z, world);
    }

    public EntityCorruptedBullet(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world) {
        super(type, entity, world);
        Vec3 vector = entity.getLookAngle().scale(1.5);
        this.moveTo(getX() + vector.x, getY() + vector.y, getZ() + vector.z);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        if(tickCount != 1 || tickCount != 0) {
            if (result.getEntity() != null) {
                Entity entity = result.getEntity();
                entity.hurt(entity.damageSources().thrown(this, this.getOwner()), damage);
            }

            if (!this.level.isClientSide) {
                this.kill();
            }
        }
    }
}