package divinerpg.entities.projectile;


import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class EntityKazroticShot extends DivineThrowable {

    public EntityKazroticShot(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntityKazroticShot(EntityType<? extends ThrowableProjectile> type, double x, double y, double z, Level world) {
        super(type, x, y, z, world);
    }

    public EntityKazroticShot(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world) {
        super(type, entity, world);
    }

	@Override
    protected void onHit(HitResult result) {
        if (tickCount != 1 || tickCount != 0) {
            if (!this.level.isClientSide) {
                this.level.explode(this, this.xo, this.yo, this.zo, 3, false, Level.ExplosionInteraction.NONE);
                this.kill();
            }
        }
    }

    @Override
    protected float getGravity() {
        return 0.0007F;
    }
}