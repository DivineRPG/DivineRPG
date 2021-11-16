package divinerpg.entities.projectile;

import divinerpg.entities.vanilla.overworld.*;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntitySaguaroWormShot extends DivineThrowable {

    public EntitySaguaroWormShot(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public EntitySaguaroWormShot(EntityType<? extends ThrowableEntity> type, double x, double y, double z, World world) {
        super(type, x, y, z, world);
    }

    public EntitySaguaroWormShot(EntityType<? extends ThrowableEntity> type, LivingEntity entity, World world) {
        super(type, entity, world);
    }

    @Override
    protected void onHitEntity(EntityRayTraceResult result) {
        if (result.hitInfo != null && !(result.hitInfo instanceof EntitySaguaroWorm)) {
            result.getEntity().hurt(DamageSource.thrown(this, this.getOwner()), 4.0F);
        } else if (result.hitInfo == null) {
            if (!this.level.isClientSide)
                this.kill();
        }
    }

    @Override
    public float getGravity() {
        return 0;
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level.isClientSide && this.tickCount > 30)
            this.kill();
    }
}