package divinerpg.entities.projectile;

import divinerpg.client.particle.options.ParticleColouredType;
import divinerpg.enums.BulletType;
import divinerpg.registries.ParticleRegistry;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class EntityColoredBullet extends EntityShooterBullet {
    public EntityColoredBullet(EntityType<? extends ThrowableProjectile> type, Level world) {super(type, world);}
    public EntityColoredBullet(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world, BulletType bulletType) {super(type, entity, world, bulletType);}
    @Override public void tick() {
        super.tick();
        if(level().isClientSide()) {
            for(int i = 0; i < 2; ++i) {
                Vec3 vector3d = getDeltaMovement();
                double d2 = getX() + vector3d.x + (random.nextDouble() - random.nextDouble()) / 4;
                double d0 = getY() + vector3d.y + (random.nextDouble() - random.nextDouble()) / 4;
                double d1 = getZ() + vector3d.z + (random.nextDouble() - random.nextDouble()) / 4;
                if(getBulletType() != null) level().addParticle(new ParticleColouredType.ParticleColour(ParticleRegistry.COLORED.get(), getBulletType().getRed(), getBulletType().getGreen(), getBulletType().getBlue()), d2 - vector3d.x * .25, d0 - vector3d.y * .25, d1 - vector3d.z * .25, vector3d.x, vector3d.y, vector3d.z);
            }
        }
    }
}