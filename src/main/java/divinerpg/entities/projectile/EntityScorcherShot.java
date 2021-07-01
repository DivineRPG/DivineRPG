package divinerpg.entities.projectile;

import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

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

    @Override
    protected void onHitEntity(EntityRayTraceResult result) {
        if (!this.level.isClientSide) {
            if (result.getEntity() != null && result.getEntity() instanceof Entity) {
                Entity entity = result.getEntity();
                if (!entity.fireImmune()) {
                    boolean flag = entity.hurt(DamageSource.fireball(this, this.shootingEntity), 4.0F);

                    if (flag && this.random.nextInt(3) == 0) {
                        entity.setSecondsOnFire(5);
                    }
                }
            }
        }

        kill();
    }

    @Override
    protected void onHit(RayTraceResult result) {
        if (!this.level.isClientSide) {
            if (result.getType() == RayTraceResult.Type.BLOCK) {
                BlockPos blockpos = new BlockPos(result.getLocation().x, result.getLocation().y, result.getLocation().z);

                if (this.level.isEmptyBlock(blockpos)) {
                    this.level.setBlock(blockpos, Blocks.FIRE.defaultBlockState(), 0);
                }
            }
        }
        kill();
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
