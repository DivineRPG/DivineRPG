package divinerpg.entities.projectile;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class EntityStar extends DivineThrowable {
	

    public EntityStar(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
        setDeltaMovement(this.level.random.nextGaussian() * 0.05, -0.5, this.level.random.nextGaussian() * 0.05);
//        colour = new Color(level.random.nextInt(255), level.random.nextInt(255), level.random.nextInt(255));
    }

    public EntityStar(EntityType<? extends ThrowableProjectile> type, double x, double y, double z, Level world) {
        super(type, x, y, z, world);
        setDeltaMovement(this.level.random.nextGaussian() * 0.05, -0.5, this.level.random.nextGaussian() * 0.05);
//        colour = new Color(level.random.nextInt(255), level.random.nextInt(255), level.random.nextInt(255));
    }

    public EntityStar(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world) {
        super(type, entity, world);
        setDeltaMovement(this.level.random.nextGaussian() * 0.05, -0.5, this.level.random.nextGaussian() * 0.05);
//        colour = new Color(level.random.nextInt(255), level.random.nextInt(255), level.random.nextInt(255));
    }



    @Override
    protected void onHitEntity(EntityHitResult result) {
        if(tickCount != 1 || tickCount != 0) {
            if (result.getEntity() != null) {
                result.getEntity().hurt(DamageSource.thrown(this, this.getOwner()), 20);
            }

            if (!this.level.isClientSide) {
                this.kill();
            }
        }
    }
}