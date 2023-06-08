package divinerpg.entities.projectile;

import divinerpg.enums.BulletType;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;

public class EntityParticleBullet extends EntityShooterBullet {
    BulletType bulletType;
    public EntityParticleBullet(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntityParticleBullet(EntityType<? extends ThrowableProjectile> type, Level world, LivingEntity entity, BulletType bulletType) {
        super(type, entity, world, bulletType);
        this.bulletType = getBulletType();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void tick() {
        super.tick();
        for (int var3 = 0; var3 < 8; ++var3) {
            double x = this.xo + (this.random.nextDouble() - this.random.nextDouble()) / 4;
            double y = this.yo + (this.random.nextDouble() - this.random.nextDouble()) / 4;
            double z = this.zo + (this.random.nextDouble() - this.random.nextDouble()) / 4;
            if (level().isClientSide && getBulletType().getParticle() != null) {
                level().addParticle(getBulletType().getParticle(), x, y, z, 0, 0, 0);
            }
        }
    }
}