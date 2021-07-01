package divinerpg.entities.projectile;

import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.*;

public class EntitySparkler extends DivineThrowable {


    public EntitySparkler(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public EntitySparkler(EntityType<? extends ThrowableEntity> type, double x, double y, double z, World world) {
        super(type, x, y, z, world);
    }

    public EntitySparkler(EntityType<? extends ThrowableEntity> type, LivingEntity entity, World world) {
        super(type, entity, world);
    }

    @Override
    protected void onHitEntity(EntityRayTraceResult result) {
        if (result.getEntity() != null) {
            result.getEntity().hurt(DamageSource.thrown(this, this.getOwner()), 20);
        }
        if (!this.level.isClientSide) {
            this.kill();
        }

    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void tick() {
        super.tick();
        for (int var3 = 0; var3 < 8; ++var3) {
            level.addParticle(ParticleRegistry.SPARKLER.get(), this.xo, this.yo, this.zo,
                    0.25 * this.random.nextGaussian(), 0.25 * this.random.nextGaussian(), 0.25 * this.random.nextGaussian());
        }
    }
}