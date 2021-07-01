package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntityCoriShot extends DivineThrowable {
    private float damage;

    public EntityCoriShot(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public EntityCoriShot(EntityType<? extends ThrowableEntity> type, World world, LivingEntity entity, float damage) {
        super(type, entity, world);
        this.damage = damage;
    }

    @Override
    public void onHitEntity(EntityRayTraceResult result) {
        if (result.getEntity() != null) {
            Entity entity = result.getEntity();
            entity.hurt(DamageSource.thrown(this, this.getOwner()), damage);
        }
        if (!this.level.isClientSide) {
            this.kill();
        }
    }
}