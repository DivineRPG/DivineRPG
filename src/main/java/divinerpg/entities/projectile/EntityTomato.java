package divinerpg.entities.projectile;

import divinerpg.client.particle.options.ParticleColouredType;
import divinerpg.enums.BulletType;
import divinerpg.registries.ParticleRegistry;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;

public class EntityTomato extends DivineThrowable {
    public EntityTomato(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntityTomato(EntityType<? extends ThrowableProjectile> type, double x, double y, double z, Level world) {
        super(type, x, y, z, world);
    }

    public EntityTomato(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world) {
        super(type, entity, world);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        if(tickCount != 1 || tickCount != 0) {
            super.onHitEntity(result);
            result.getEntity().hurt(damageSources().thrown(this, getOwner()), 1.0F);
            if (level().isClientSide) {
                level().addParticle(new ParticleColouredType.ParticleColour(ParticleRegistry.COLORED.get(), BulletType.TOMATO.getRed(), BulletType.TOMATO.getGreen(), BulletType.TOMATO.getBlue()), this.getX(), this.getY(), this.getZ(), 0.2D, 0.2D, 0.2D);
            }
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        if (tickCount != 1 || tickCount != 0) {
            super.onHitBlock(result);
            if (level().isClientSide) {
                level().addParticle(new ParticleColouredType.ParticleColour(ParticleRegistry.COLORED.get(), BulletType.TOMATO.getRed(), BulletType.TOMATO.getGreen(), BulletType.TOMATO.getBlue()), this.getX(), this.getY(), this.getZ(), 0.2D, 0.2D, 0.2D);
            }
            this.kill();
        }
    }
}
