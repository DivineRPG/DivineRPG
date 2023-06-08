package divinerpg.entities.projectile;


import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.HitResult;

import java.util.List;

public class EntityKingOfScorchersMeteor extends DivineThrowable {


    public EntityKingOfScorchersMeteor(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntityKingOfScorchersMeteor(EntityType<? extends ThrowableProjectile> type, double x, double y, double z, Level world) {
        super(type, x, y, z, world);
    }

    public EntityKingOfScorchersMeteor(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world) {
        super(type, entity, world);
    }

    @Override
    protected float getGravity() {
        return 0;
    }

    @Override
    public void tick() {
        super.tick();
        if (!level().isClientSide) {
            if (this.tickCount > 200)
                this.kill();
            List<Entity> l = this.level().getEntitiesOfClass(Entity.class, this.getBoundingBox());
            if (l.size() > 0) {
                this.level().explode(this, xo, yo, zo, 3.0F, false, Level.ExplosionInteraction.TNT);
                this.kill();
            }
        }
    }

    @Override
    protected void onHit(HitResult result) {
        if(tickCount != 1 || tickCount != 0) {
            if (!level().isClientSide) {
                if (result.getType() != null && result.getType() == HitResult.Type.ENTITY) {
                    this.level().explode(level().getEntity(5), xo, yo, zo, 3.0F, false, Level.ExplosionInteraction.TNT);
                    this.kill();
                } else {
                    setDeltaMovement(0, 0, 0);
                }
            }
        }
    }
}