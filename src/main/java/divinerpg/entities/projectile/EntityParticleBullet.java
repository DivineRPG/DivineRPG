package divinerpg.entities.projectile;

import divinerpg.enums.BulletType;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.*;

public class EntityParticleBullet extends EntityShooterBullet {
    public EntityParticleBullet(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public EntityParticleBullet(EntityType<? extends ThrowableEntity> type, World world, LivingEntity entity, BulletType bulletType) {
        super(type, entity, world, bulletType);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void tick() {
        super.tick();
        for (int var3 = 0; var3 < 8; ++var3) {
            double x = this.xo + (this.random.nextDouble() - this.random.nextDouble()) / 4;
            double y = this.yo + (this.random.nextDouble() - this.random.nextDouble()) / 4;
            double z = this.zo + (this.random.nextDouble() - this.random.nextDouble()) / 4;
            level.addParticle(this.getBulletType().getParticle(), x, y, z, 0, 0, 0);
        }
    }
}