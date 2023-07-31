package divinerpg.entities.projectile;

import divinerpg.registries.ParticleRegistry;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.api.distmarker.*;

public class EntitySparkler extends DivineThrowable {


    public EntitySparkler(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntitySparkler(EntityType<? extends ThrowableProjectile> type, double x, double y, double z, Level world) {
        super(type, x, y, z, world);
    }

    public EntitySparkler(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world) {
        super(type, entity, world);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        if(tickCount != 1 || tickCount != 0) {
            if (result.getEntity() != null) {
                result.getEntity().hurt(damageSources().thrown(this, this.getOwner()), 20);
            }
            if (!this.level().isClientSide()) {
                this.kill();
            }
        }

    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void tick() {
        super.tick();
        for (int var3 = 0; var3 < 8; ++var3) {
            level().addParticle(ParticleRegistry.SPARKLER.get(), this.xo, this.yo, this.zo,
                    0.25 * this.random.nextGaussian(), 0.25 * this.random.nextGaussian(), 0.25 * this.random.nextGaussian());
        }
    }
}