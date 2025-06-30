package divinerpg.entities.projectile.bullet;

import divinerpg.entities.projectile.DivineThrowableProjectile;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

import java.util.Random;

public class MusicalBullet extends DivineThrowableProjectile {
    public int color = new Random().nextInt(25);
    public MusicalBullet(EntityType<? extends ThrowableProjectile> entityType, Level level, float damage) {
        super(entityType, level);
        baseDamage = damage;
    }
    @Override public void tick() {
        super.tick();
        if(color >= 24) color = 0;
        else color++;
        level().addParticle(ParticleTypes.NOTE, xo, yo, zo, (double)color / 24, 0, 0);
    }
    @Override public DamageSource getDamageSource(EntityHitResult result) {return damageSources().indirectMagic(this, getOwner());}
}