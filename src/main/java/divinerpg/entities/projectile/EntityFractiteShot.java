package divinerpg.entities.projectile;

import divinerpg.registries.ParticleRegistry;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.*;
import net.minecraftforge.api.distmarker.*;

public class EntityFractiteShot extends DivineFireball {
    public EntityFractiteShot(EntityType<? extends LargeFireball> type, Level world) {
        super(type, world);
    }

    public EntityFractiteShot(Level world, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(world, shooter, accelX, accelY, accelZ);
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        return false;
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    public boolean isOnFire() {
        return false;
    }

    /**
     * Called when this EntityFireball hits a block or entity.
     */
    @Override
    protected void onHitEntity(EntityHitResult result) {
        if(tickCount != 1 || tickCount != 0) {
            if (result.getEntity() != null && shootingEntity != null) {
                Entity entity = result.getEntity();
                entity.hurt(damageSources().fireball(this, this.shootingEntity), 12.0F);
            }

            this.level.explode(null, this.xo, this.yo, this.zo, 3.0F, false, Level.ExplosionInteraction.TNT);
            this.kill();
        }
    }

    @Override
    protected void onHit(HitResult p_70227_1_) {
        if(tickCount != 1 || tickCount != 0) {
            this.level.explode(null, this.xo, this.yo, this.zo, 3.0F, false, Level.ExplosionInteraction.TNT);
            this.kill();
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void tick() {
        super.tick();
        for (int i = 0; i < 5; i++) {
            level.addParticle(ParticleRegistry.FROST.get(), xo, yo, zo, 0, 1, 0);
            if ((tickCount > 40)) {
                kill();
            }
        }
    }
}
