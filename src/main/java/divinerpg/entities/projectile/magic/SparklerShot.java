package divinerpg.entities.projectile.magic;

import divinerpg.entities.projectile.DivineThrowableProjectile;
import divinerpg.registries.DamageRegistry;
import divinerpg.registries.ParticleRegistry;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class SparklerShot extends DivineThrowableProjectile {
    public SparklerShot(EntityType<? extends ThrowableProjectile> entityType, Level level) {
        super(entityType, level);
        baseDamage = 4.3F;
    }
    @Override
    public DamageSource getDamageSource(EntityHitResult result) {
        return damageSources().source(DamageRegistry.ARCANA.getKey(), this);
    }
    @Override
    public void tick() {
        super.tick();
        for(int var3 = 0; var3 < 8; ++var3) level().addParticle(ParticleRegistry.SPARKLER.get(), xo, yo, zo, .25 * random.nextGaussian(), .25 * random.nextGaussian(), .25 * random.nextGaussian());
    }
}