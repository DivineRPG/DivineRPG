package divinerpg.entities.projectile.fireball;

import divinerpg.entities.projectile.DivineFireball;
import divinerpg.registries.EntityRegistry;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;

import static net.minecraft.core.particles.ParticleTypes.PORTAL;

public class EntityEnderTripletsFireball extends DivineFireball {
    Entity shootingEntity;
    public EntityEnderTripletsFireball(EntityType<? extends DivineFireball> type, Level world) {super(type, world);}
    public EntityEnderTripletsFireball(Level world, LivingEntity entity, double i, double j, double k) {
        super(EntityRegistry.ENDER_TRIPLETS_FIREBALL.get(), world, entity, i, j, k, (byte)1);
        shootingEntity = entity;
    }
    @Override public void tick() {
        super.tick();
        if(level().isClientSide) level().addParticle(PORTAL,
                xo + (random.nextDouble() - random.nextDouble()) / 6,
                yo + .5 + (random.nextDouble() - random.nextDouble()) / 6,
                zo + (random.nextDouble() - random.nextDouble()) / 6, 0, 0, 0);
        if(tickCount > 150) discard();
    }
}