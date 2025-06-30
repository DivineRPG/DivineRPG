package divinerpg.entities.projectile.magic;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class DivineParticleProjectile extends DivineMagicProjectile {
    public Supplier<SimpleParticleType> particle;
    public DivineParticleProjectile(EntityType<? extends ThrowableProjectile> entityType, Level level, float damage, Supplier<SimpleParticleType> particle) {
        super(entityType, level, damage);
        this.particle = particle;
    }
    @Override public void tick() {
        super.tick();
        level().addParticle(particle.get(), getX(), getY(), getZ(), .25 * random.nextGaussian(), .25 * random.nextGaussian(), .25 * random.nextGaussian());
    }
}