package divinerpg.entities.projectile;

import divinerpg.registries.ParticleRegistry;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;

public class EntityEnderTripletsFireball extends DivineFireball {
    Entity shootingEntity;
    public EntityEnderTripletsFireball(EntityType<? extends LargeFireball> type, Level world) {
        super(type, world);
    }

    public EntityEnderTripletsFireball(Level world, LivingEntity entity, double i, double j, double k) {
        super(world, entity, i, j, k);
        this.shootingEntity=entity;
    }


    @Override
    protected void onHitEntity(EntityHitResult result) {
        if(tickCount != 1 || tickCount != 0) {
            if (!this.level().isClientSide) {
                if (result.getEntity() != null) {
                    Entity entity = result.getEntity();
                    if (this.shootingEntity != null) {
                        entity.hurt(entity.damageSources().fireball(this, this.shootingEntity), 8);
                    }
                }
                this.level().explode(null, this.xo, this.yo, this.zo, 2F, false, Level.ExplosionInteraction.TNT);
                this.kill();
            }
        }
    }

    @Override
    protected void onHit(HitResult result) {
        if(tickCount != 1 || tickCount != 0) {
            this.level().explode(null, this.xo, this.yo, this.zo, 2F, false, Level.ExplosionInteraction.TNT);
            this.kill();
        }
    }

    @Override
    public void tick() {
        super.tick();
        if(level().isClientSide) {
            level().addParticle(ParticleRegistry.ENDER_TRIPLET.get(),
                    this.xo + (this.random.nextDouble() - this.random.nextDouble()) / 6,
                    this.yo + 0.5D + (this.random.nextDouble() - this.random.nextDouble()) / 6,
                    this.zo + (this.random.nextDouble() - this.random.nextDouble()) / 6, 0.0D, 0.0D, 0.0D);
        }

        if (this.tickCount > 150)
            this.kill();
    }
}
