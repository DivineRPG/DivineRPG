package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.network.*;
import net.minecraft.world.*;
import net.minecraftforge.fml.network.*;

public class DivineSnowball extends SnowballEntity {
    public DivineSnowball(EntityType<? extends SnowballEntity> type, World world) {
        super(type, world);
    }

    public DivineSnowball(World world, LivingEntity entity) {
        super(world, entity);
    }

    public DivineSnowball(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
