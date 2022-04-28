package divinerpg.entities.projectile;

import divinerpg.enums.BulletType;
import divinerpg.registries.ParticleRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class EntityColoredBullet extends EntityShooterBullet {
    public EntityColoredBullet(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public EntityColoredBullet(EntityType<? extends ThrowableEntity> type, LivingEntity entity, World world, BulletType bulletType) {
        super(type, entity, world, bulletType);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void tick() {
        super.tick();
        for (int var3 = 0; var3 < 2; ++var3) {
            Vector3d vector3d = this.getDeltaMovement();
            double d2 = this.getX() + vector3d.x + (this.random.nextDouble() - this.random.nextDouble()) / 4;
            double d0 = this.getY() + vector3d.y + (this.random.nextDouble() - this.random.nextDouble()) / 4;
            double d1 = this.getZ() + vector3d.z + (this.random.nextDouble() - this.random.nextDouble()) / 4;

            this.level.addParticle(ParticleRegistry.EDEN_PORTAL.get(), d2 - vector3d.x * 0.25D, d0 - vector3d.y * 0.25D, d1 - vector3d.z * 0.25D, vector3d.x, vector3d.y, vector3d.z);

        }
    }

}