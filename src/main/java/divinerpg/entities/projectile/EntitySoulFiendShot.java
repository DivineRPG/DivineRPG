package divinerpg.entities.projectile;

import divinerpg.client.particle.options.ParticleColouredType;
import divinerpg.enums.BulletType;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.neoforged.api.distmarker.*;

public class EntitySoulFiendShot extends EntityShooterBullet {
    public EntitySoulFiendShot(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntitySoulFiendShot(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world) {
        super(type, entity, world, BulletType.SOUL_FIEND_SHOT);
    }


    @Override
    public void onHit(HitResult result) {
        if(tickCount != 1 || tickCount != 0) {
        if (!this.level().isClientSide()) {
            if (result.getLocation() != null) {
                for (int i = 0; i < 3; i++) {
                    EntityRegistry.SOUL_SPIDER.get().spawn((ServerLevel) level(), ItemStack.EMPTY, null, new BlockPos((int) result.getLocation().x, (int) result.getLocation().y, (int) result.getLocation().z), MobSpawnType.MOB_SUMMONED, true, false);
                }
                this.kill();
            }
        }
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void tick() {
        super.tick();
        if (level().isClientSide()) {
        for (int cnt = 0; cnt < 8; ++cnt) {
                level().addParticle(new ParticleColouredType.ParticleColour(ParticleRegistry.COLORED.get(), 0, 0, 0), this.xo + (random.nextDouble() - random.nextDouble()) / 4, this.yo + (random.nextDouble() - random.nextDouble()) / 4, this.zo + (random.nextDouble() - random.nextDouble()) / 4, 0.2D, 0.2D, 0.2D);
                level().addParticle(new ParticleColouredType.ParticleColour(ParticleRegistry.COLORED.get(), 255, 0, 0), this.xo + (random.nextDouble() - random.nextDouble()) / 4, this.yo + (random.nextDouble() - random.nextDouble()) / 4, this.zo + (random.nextDouble() - random.nextDouble()) / 4, 0.2D, 0.2D, 0.2D);
            }
        }
        if (!this.level().isClientSide() && this.tickCount > 20) {
            this.kill();
        }
    }
}
