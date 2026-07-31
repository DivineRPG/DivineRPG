package divinerpg.entities.projectile.bullet;

import divinerpg.entities.projectile.magic.DivineParticleProjectile;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

import java.util.function.Supplier;

public class PhysicalParticleProjectile extends DivineParticleProjectile {
    public PhysicalParticleProjectile(EntityType<? extends ThrowableProjectile> entityType, Level level, float damage, Supplier<SimpleParticleType> particle) {
        super(entityType, level, damage, particle);
    }
    @Override public DamageSource getDamageSource(EntityHitResult result) {
        return damageSources().mobProjectile(this, getOwner() instanceof LivingEntity l ? l : null);
    }
}