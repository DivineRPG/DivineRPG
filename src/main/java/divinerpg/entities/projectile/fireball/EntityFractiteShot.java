package divinerpg.entities.projectile.fireball;

import divinerpg.entities.projectile.DivineFireball;
import divinerpg.registries.ParticleRegistry;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.*;

import static divinerpg.registries.EntityRegistry.FRACTITE_SHOT;

public class EntityFractiteShot extends DivineFireball {
    public EntityFractiteShot(EntityType<? extends DivineFireball> type, Level world) {
        super(type, world);
        explosionPower = 1;
    }
    public EntityFractiteShot(Level world, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(FRACTITE_SHOT.get(), world, shooter, accelX, accelY, accelZ, (byte)1);
    }
    @Override public boolean hurt(DamageSource source, float amount) {return false;}
    @Override public boolean canBeCollidedWith() {return false;}
    @Override public boolean isOnFire() {return false;}
    @OnlyIn(Dist.CLIENT)
    @Override public void tick() {
        super.tick();
        for(int i = 0; i < 5; i++) {
            level().addParticle(ParticleRegistry.FROST.get(), xo, yo, zo, 0, 1, 0);
            if(tickCount > 40) discard();
        }
    }
}