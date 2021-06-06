package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;

public class EntityKingOfScorchersMeteor extends DivineThrowable {


    public EntityKingOfScorchersMeteor(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public EntityKingOfScorchersMeteor(EntityType<? extends ThrowableEntity> type, double x, double y, double z, World world) {
        super(type, x, y, z, world);
    }

    public EntityKingOfScorchersMeteor(EntityType<? extends ThrowableEntity> type, LivingEntity entity, World world) {
        super(type, entity, world);
    }

    @Override
    protected float getGravity() {
        return 0;
    }

    @Override
    public void tick() {
        super.tick();
        if (!level.isClientSide) {
            if (this.tickCount > 200)
                this.kill();
            List<Entity> l = this.level.getEntitiesOfClass(PlayerEntity.class, this.getBoundingBox());
            if (l.size() > 0) {
                this.level.explode(this, xo, yo, zo, 3.0F, false, Explosion.Mode.BREAK);
                this.kill();
            }
        }
    }

    @Override
    protected void onHit(RayTraceResult result) {
        if (!level.isClientSide) {
            if (result.hitInfo != null && result.hitInfo instanceof Entity) {
                this.level.explode((Entity) result.hitInfo, xo, yo, zo, 3.0F, false, Explosion.Mode.BREAK);
                this.kill();
            } else {
                setDeltaMovement(0, 0 ,0);
            }
        }
    }
}