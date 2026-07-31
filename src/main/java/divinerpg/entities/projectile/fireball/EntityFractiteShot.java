package divinerpg.entities.projectile.fireball;

import divinerpg.entities.projectile.DivineFireball;
import divinerpg.registries.ParticleRegistry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

import static divinerpg.registries.EntityRegistry.FRACTITE_SHOT;

public class EntityFractiteShot extends DivineFireball {
    public EntityFractiteShot(EntityType<? extends DivineFireball> type, Level world) {
        super(type, world);
        explosionPower = 1;
    }
    public EntityFractiteShot(Level world, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(FRACTITE_SHOT.get(), world, shooter, accelX, accelY, accelZ, (byte)1);
    }

    @Override public boolean hurtServer(ServerLevel level, DamageSource source, float damage) {return false;}
    @Override public boolean canCollideWith(Entity entity) {return false;}
    @Override public boolean isOnFire() {return false;}
    @Override public void tick() {
        super.tick();
        if(level().isClientSide()) {
            for (int i = 0; i < 5; i++) {
                level().addParticle(ParticleRegistry.FROST.get(), xo, yo, zo, 0, 1, 0);
                if (tickCount > 40) discard();
            }
        }
    }
}