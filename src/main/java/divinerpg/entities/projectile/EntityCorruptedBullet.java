package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.*;
import net.minecraft.world.*;

import java.util.*;

public class EntityCorruptedBullet extends DivineThrowable {
    public static float damage = 10.0F;
    private List<Entity> toExcludeList = new ArrayList<>();

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
    protected void onHit(RayTraceResult result) {
        if (result.hitInfo != null && result.hitInfo instanceof Entity) {
            Entity entity = (Entity) result.hitInfo;
            if (!this.toExcludeList.contains(result.hitInfo))
                entity.hurt(DamageSource.thrown(this, this.getOwner()), damage);
            List<Entity> surrounding = this.level.getEntities(this,
                    this.getBoundingBox().expandTowards(1, 1, 1));
            for (Entity e : surrounding) {
                if (e instanceof EntityCorruptedBullet)
                    ((EntityCorruptedBullet) e).toExcludeList.add(entity);
            }
        }

        if (!this.level.isClientSide) {
            this.kill();
        }
    }
}