package divinerpg.entities.projectile;

import divinerpg.enums.*;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.*;

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
            double x = this.getX() + (this.random.nextDouble() - this.random.nextDouble()) / 4;
            double y = this.getY() + (this.random.nextDouble() - this.random.nextDouble()) / 4;
            double z = this.getZ() + (this.random.nextDouble() - this.random.nextDouble()) / 4;
//            DivineRPG.proxy.spawnColoredParticle(this.level, x, y, z, this.getBulletType().getColor(), true, false);
        }
    }

}