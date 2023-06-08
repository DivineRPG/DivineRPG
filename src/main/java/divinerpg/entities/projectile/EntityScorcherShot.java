package divinerpg.entities.projectile;

import net.minecraft.util.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class EntityScorcherShot extends DivineFireball {
    public EntityScorcherShot(EntityType<? extends LargeFireball> type, Level world) {
        super(type, world);
    }

    public EntityScorcherShot(Level world, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(world, shooter, accelX, accelY, accelZ);
        this.moveTo(shooter.xo, shooter.yo, shooter.zo, shooter.xRot, shooter.yRot);
        this.setPos(shooter.xo, shooter.yo, shooter.zo);
        double d = Mth.sqrt((float) (accelX * accelX + accelY * accelY + accelZ * accelZ));
        setDeltaMovement(accelX / d * 0.1D, accelY / d * 0.1D, accelZ / d * 0.1D);
        this.shootingEntity = shooter;
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
    protected void onHitEntity(EntityHitResult result) {
        if(tickCount != 1 || tickCount != 0) {
        super.onHitEntity(result);
        if (!this.level().isClientSide) {
            Entity entity = result.getEntity();
            if (!entity.fireImmune()) {
                Entity entity1 = this.getOwner();
                int i = entity.getRemainingFireTicks();
                entity.setSecondsOnFire(5);
                boolean flag = entity.hurt(damageSources().fireball(this, entity1), 5.0F);
                if (!flag) {
                    entity.setRemainingFireTicks(i);
                } else if (entity1 instanceof LivingEntity) {
                    this.doEnchantDamageEffects((LivingEntity) entity1, entity);
                }
            }
        }
        }
    }

    @Override
    protected void onHit(HitResult result) {
        if(tickCount != 1 || tickCount != 0) {
            super.onHit(result);
            if (!this.level().isClientSide) {
                this.kill();
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide) {
            this.xo += (this.random.nextDouble() - this.random.nextDouble()) / 3;
            this.yo += (this.random.nextDouble() - this.random.nextDouble()) / 3;
            this.zo += (this.random.nextDouble() - this.random.nextDouble()) / 3;
        }

        if(level().isClientSide){
            /*
             * for (int i = 0; i < 3; i++) { ParticleEntityPortal particle = new
             * ParticleEntityPortal(this.world, this.posX + (this.rand.nextDouble() -
             * this.rand.nextDouble()) / 5, this.posY + 0.5D + (this.rand.nextDouble() -
             * this.rand.nextDouble()) / 5, this.posZ + (this.rand.nextDouble() -
             * this.rand.nextDouble()) / 5, 0.0D, 0.0D, 0.0D);
             * FMLClientHandler.instance().getClient().effectRenderer.addEffect(particle); }
             */
        }
    }
}
