package divinerpg.entities.projectile;


import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;

public class DivineThrowable extends ThrowableProjectile {
    public DivineThrowable(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public DivineThrowable(EntityType<? extends ThrowableProjectile> type, double x, double y, double z, Level world) {
        super(type, x, y, z, world);
    }

    public DivineThrowable(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world) {
        super(type, entity, world);
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        this.kill();
    }

    @Override
    public void tick() {
        super.tick();

        if (this.tickCount > 200)
            this.kill();
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        this.kill();
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        this.kill();
    }

    @Override
    protected void defineSynchedData() {

    }

//    @Override
//    public Packet<?> getAddEntityPacket() {
//        return NetworkHooks.getEntitySpawningPacket(this);
//    }
}
