package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.network.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraftforge.fml.network.*;

public class DivineThrowable extends ThrowableEntity {
    public DivineThrowable(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public DivineThrowable(EntityType<? extends ThrowableEntity> type, double x, double y, double z, World world) {
        super(type, x, y, z, world);
    }

    public DivineThrowable(EntityType<? extends ThrowableEntity> type, LivingEntity entity, World world) {
        super(type, entity, world);
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void onHit(RayTraceResult result) {
        super.onHit(result);
        this.kill();
    }

    @Override
    protected void onHitEntity(EntityRayTraceResult result) {
        super.onHitEntity(result);
        this.kill();
    }

    @Override
    protected void onHitBlock(BlockRayTraceResult result) {
        super.onHitBlock(result);
        this.kill();
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
