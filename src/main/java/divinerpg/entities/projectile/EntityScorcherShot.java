package divinerpg.entities.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityScorcherShot extends DivineFireball {
    public EntityScorcherShot(EntityType<? extends FireballEntity> type, World world) {
        super(type, world);
    }

    public EntityScorcherShot(World world, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(world, shooter, accelX, accelY, accelZ);
        this.moveTo(shooter.xo, shooter.yo, shooter.zo, shooter.xRot, shooter.yRot);
        this.setPos(shooter.xo, shooter.yo, shooter.zo);
        double d = (double) MathHelper.sqrt(accelX * accelX + accelY * accelY + accelZ * accelZ);
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

    protected void onHitEntity(EntityRayTraceResult result) {
        super.onHitEntity(result);
        if (!this.level.isClientSide) {
            Entity entity = result.getEntity();
            if (!entity.fireImmune()) {
                Entity entity1 = this.getOwner();
                int i = entity.getRemainingFireTicks();
                entity.setSecondsOnFire(5);
                boolean flag = entity.hurt(DamageSource.fireball(this, entity1), 5.0F);
                if (!flag) {
                    entity.setRemainingFireTicks(i);
                } else if (entity1 instanceof LivingEntity) {
                    this.doEnchantDamageEffects((LivingEntity)entity1, entity);
                }
            }

        }
    }

    protected void onHit(RayTraceResult result) {
        super.onHit(result);
        if (!this.level.isClientSide) {
            this.remove();
        }

    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level.isClientSide) {
            this.xo += (this.random.nextDouble() - this.random.nextDouble()) / 3;
            this.yo += (this.random.nextDouble() - this.random.nextDouble()) / 3;
            this.zo += (this.random.nextDouble() - this.random.nextDouble()) / 3;
        }

        if(level.isClientSide){
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
