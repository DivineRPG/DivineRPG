package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.*;
import net.minecraft.world.*;

public class EntityCorruptedBullet extends DivineThrowable {
    public static float damage = 10.0F;

    public EntityCorruptedBullet(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public EntityCorruptedBullet(EntityType<? extends ThrowableEntity> type, double x, double y, double z, World world) {
        super(type, x, y, z, world);
    }

    public EntityCorruptedBullet(EntityType<? extends ThrowableEntity> type, LivingEntity entity, World world) {
        super(type, entity, world);
        Vector3d vector = entity.getLookAngle().scale(1.5);
        this.moveTo(getX() + vector.x, getY() + vector.y, getZ() + vector.z);
    }

    @Override
    protected void onHitEntity(EntityRayTraceResult result) {
        if (result.getEntity() != null) {
            Entity entity = result.getEntity();
                entity.hurt(DamageSource.thrown(this, this.getOwner()), damage);
        }

        if (!this.level.isClientSide) {
            this.kill();
        }
    }
}