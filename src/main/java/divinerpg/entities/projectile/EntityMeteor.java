package divinerpg.entities.projectile;


import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;

public class EntityMeteor extends DivineThrowable {
    public EntityMeteor(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
        setDeltaMovement(level.random.nextGaussian() * 0.05, -0.5, level.random.nextGaussian() * 0.05);
    }

    public EntityMeteor(EntityType<? extends ThrowableProjectile> type, double x, double y, double z, Level world) {
        super(type, x, y, z, world);
        setDeltaMovement(level.random.nextGaussian() * 0.05, -0.5, level.random.nextGaussian() * 0.05);
    }

    public EntityMeteor(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world) {
        super(type, entity, world);
        setDeltaMovement(level.random.nextGaussian() * 0.05, -0.5, level.random.nextGaussian() * 0.05);
    }

    @Override
    protected float getGravity() {
        return 0.07F;
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        if(tickCount != 1 || tickCount != 0) {
            if (result.getEntity() != null) {
                Entity entity = result.getEntity();
                entity.hurt(damageSources().thrown(this, this.getOwner()), 12);
            }

            level.explode(this, this.xo, this.yo, this.zo, 4.5F, false, Level.ExplosionInteraction.TNT);

            if (!this.level.isClientSide) {
                this.kill();
            }
        }
    }
    @Override
    protected void onHit(HitResult result) {
        if(tickCount != 1 || tickCount != 0) {
            if (!this.level.isClientSide) {
                this.level.explode(this, this.xo, this.yo, this.zo, 2, false, Level.ExplosionInteraction.TNT);
                this.kill();
            }
        }
    }
}