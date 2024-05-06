package divinerpg.entities.projectile;

import divinerpg.enums.BulletType;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;

public class EntityParticleBullet extends EntityShooterBullet {
    public EntityParticleBullet(EntityType<? extends ThrowableProjectile> type, Level world) {super(type, world);}
    public EntityParticleBullet(EntityType<? extends ThrowableProjectile> type, Level world, LivingEntity entity, BulletType bulletType) {
        super(type, entity, world, bulletType);
        this.bulletType = bulletType;
    }
    @Override public void tick() {
        super.tick();
        for(int var3 = 0; var3 < 8; ++var3) {
            double x = xo + (random.nextDouble() - random.nextDouble()) / 4;
            double y = yo + (random.nextDouble() - random.nextDouble()) / 4;
            double z = zo + (random.nextDouble() - random.nextDouble()) / 4;
            if(level().isClientSide() && getBulletType().getParticle() != null) level().addParticle(getBulletType().getParticle(), x, y, z, 0, 0, 0);
        }
    }
}