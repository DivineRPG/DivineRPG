package divinerpg.entities.projectile;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.api.distmarker.*;

import java.util.Random;

public class EntitySoundOfWhales extends DivineThrowable {
    Random r = new Random();
    int color = r.nextInt(25);

    public EntitySoundOfWhales(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntitySoundOfWhales(EntityType<? extends ThrowableProjectile> type, double x, double y, double z, Level world) {
        super(type, x, y, z, world);
    }

    public EntitySoundOfWhales(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world) {
        super(type, entity, world);
    }


    @OnlyIn(Dist.CLIENT)
    @Override
    public void tick() {
        super.tick();
        if (color >= 24) {
            color = 0;
        } else {
            color++;
        }
        level.addParticle(ParticleTypes.UNDERWATER, this.xo, this.yo, this.zo, (double) color / 24.0D, 0.0D,
                0.0D);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        if (tickCount != 1 || tickCount != 0) {
            if (result.getEntity() != null) {
                result.getEntity().hurt(damageSources().thrown(this, this.getOwner()), 20.0F);
            }

            if (!this.level.isClientSide) {
                this.kill();
            }
        }
    }
}