package divinerpg.entities.projectile;

import divinerpg.registries.SoundRegistry;
import divinerpg.util.DamageSources;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.*;

public class EntitySkyreBullet extends DivineThrowable {
    public EntitySkyreBullet(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
        setDeltaMovement(level().getRandom().nextGaussian() * 0.05, -0.5, level().getRandom().nextGaussian() * 0.05);
    }

    public EntitySkyreBullet(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world) {
        super(type, entity, world);
        setDeltaMovement(level().getRandom().nextGaussian() * 0.05, -0.5, level().getRandom().nextGaussian() * 0.05);
    }

    @Override
    protected float getGravity() {
        return 0.0F;
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        if (tickCount != 1 || tickCount != 0) {
            if (result.getEntity() != null) {
                Entity entity = result.getEntity();
                if (entity instanceof Player) {
                    entity.hurt(DamageSources.source(level(), DamageSources.SPIKE), ((Player) entity).getHealth() / 2);
                    level().playSound((Player) entity, entity.getX(), entity.getY(), entity.getZ(), SoundRegistry.SKYRE_SPARK.get(), SoundSource.HOSTILE, 0, 0);
                }
            }

            level().explode(this, this.xo, this.yo, this.zo, 4.5F, false, Level.ExplosionInteraction.MOB);

            if (!this.level().isClientSide()) {
                this.kill();
            }
        }
    }
    @Override
    protected void onHit(HitResult result) {
        if (tickCount != 1 || tickCount != 0) {
            if (!this.level().isClientSide()) {
                this.level().explode(this, this.xo, this.yo, this.zo, 2, false, Level.ExplosionInteraction.MOB);
                this.kill();
            }
        }
    }
}