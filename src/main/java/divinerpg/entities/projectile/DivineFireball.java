package divinerpg.entities.projectile;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.level.Level;

public class DivineFireball extends LargeFireball {
    public LivingEntity shootingEntity;
    public DivineFireball(EntityType<? extends LargeFireball> type, Level world) {
        super(type, world);
    }

//    public DivineFireball(Level world, double x, double y, double z, double accelX, double accelY, double accelZ) {
//        super(world, x, y, z, accelX, accelY, accelZ);
//    }

    public DivineFireball(Level world, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(world, shooter, accelX, accelY, accelZ, 0);
    this.shootingEntity=shooter;
    }
//    @Override
//    public Packet<?> getAddEntityPacket() {
//        return NetworkHooks.getEntitySpawningPacket(this);
//    }


    @Override
    public void tick() {
        super.tick();

        if (this.tickCount > 200)
            this.kill();
    }
}
