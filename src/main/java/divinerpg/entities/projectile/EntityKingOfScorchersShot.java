package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntityKingOfScorchersShot extends DivineThrowable {


    public EntityKingOfScorchersShot(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public EntityKingOfScorchersShot(EntityType<? extends ThrowableEntity> type, double x, double y, double z, World world) {
        super(type, x, y, z, world);
    }

    public EntityKingOfScorchersShot(EntityType<? extends ThrowableEntity> type, LivingEntity entity, World world) {
        super(type, entity, world);
    }

    @Override
    public void tick() {
        super.tick();
        if (!level.isClientSide) {
            if (this.tickCount > 200)
                this.kill();
        }
    }

    @Override
    protected void onHit(RayTraceResult result) {
        if (!level.isClientSide) {
            if (result.hitInfo != null && result.hitInfo instanceof Entity) {
                Entity entity = (Entity) result.hitInfo;
                entity.hurt(DamageSource.thrown(this, this.getOwner()), 14);
                entity.setSecondsOnFire(8);
            }
            this.kill();
        }
    }
}