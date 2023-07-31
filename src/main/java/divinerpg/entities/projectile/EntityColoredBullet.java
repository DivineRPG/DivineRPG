package divinerpg.entities.projectile;

import divinerpg.client.particle.options.ParticleColouredType;
import divinerpg.enums.BulletType;
import divinerpg.registries.ParticleRegistry;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class EntityColoredBullet extends EntityShooterBullet {

    public EntityColoredBullet(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntityColoredBullet(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world, BulletType bulletType) {
        super(type, entity, world, bulletType);
    }

    @Override
    public void tick() {
        super.tick();
        if (level().isClientSide()) {
            for (int i = 0; i < 2; ++i) {
                Vec3 vector3d = this.getDeltaMovement();
                double d2 = this.getX() + vector3d.x + (this.random.nextDouble() - this.random.nextDouble()) / 4;
                double d0 = this.getY() + vector3d.y + (this.random.nextDouble() - this.random.nextDouble()) / 4;
                double d1 = this.getZ() + vector3d.z + (this.random.nextDouble() - this.random.nextDouble()) / 4;

                if (getBulletType() != null) {
                    this.level().addParticle(new ParticleColouredType.ParticleColour(ParticleRegistry.COLORED.get(), getBulletType().getRed(), getBulletType().getGreen(), getBulletType().getBlue()), d2 - vector3d.x * 0.25D, d0 - vector3d.y * 0.25D, d1 - vector3d.z * 0.25D, vector3d.x, vector3d.y, vector3d.z);
                }
            }
    }
    }

}