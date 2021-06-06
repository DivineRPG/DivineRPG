package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.network.*;
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
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
