package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.network.*;
import net.minecraft.world.*;
import net.minecraftforge.fml.network.*;

public class DivineFireball extends FireballEntity {
    public LivingEntity shootingEntity;
    public DivineFireball(EntityType<? extends FireballEntity> type, World world) {
        super(type, world);
    }

    public DivineFireball(World world, double x, double y, double z, double accelX, double accelY, double accelZ) {
        super(world, x, y, z, accelX, accelY, accelZ);
    }

    public DivineFireball(World world, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(world, shooter, accelX, accelY, accelZ);
    this.shootingEntity=shooter;
    }
    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}
