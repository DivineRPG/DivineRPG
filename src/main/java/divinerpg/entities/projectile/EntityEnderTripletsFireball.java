package divinerpg.entities.projectile;

import divinerpg.registries.EntityRegistry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;

public class EntityEnderTripletsFireball extends DivineFireball {
    Entity shootingEntity;
    public EntityEnderTripletsFireball(EntityType<? extends DivineFireball> type, Level world) {
        super(type, world);
    }
    public EntityEnderTripletsFireball(Level world, LivingEntity entity, double i, double j, double k) {
        super(EntityRegistry.ENDER_TRIPLETS_FIREBALL.get(), world, entity, i, j, k, (byte)1);
        this.shootingEntity=entity;
    }
    @Override
    public void tick() {
        super.tick();
        if(level().isClientSide()) level().addParticle(ParticleTypes.PORTAL,
                    xo + (random.nextDouble() - random.nextDouble()) / 6,
                    yo + .5 + (random.nextDouble() - random.nextDouble()) / 6,
                    zo + (random.nextDouble() - random.nextDouble()) / 6, 0D, 0D, 0D);
        if(tickCount > 150) kill();
    }
}
