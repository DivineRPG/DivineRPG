package divinerpg.entities.projectile;


import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class EntityKingOfScorchersShot extends DivineThrowable {


    public EntityKingOfScorchersShot(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntityKingOfScorchersShot(EntityType<? extends ThrowableProjectile> type, double x, double y, double z, Level world) {
        super(type, x, y, z, world);
    }

    public EntityKingOfScorchersShot(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world) {
        super(type, entity, world);
    }

    @Override
    public void tick() {
        super.tick();
        if (!level.isClientSide) {
            if (this.tickCount > 200)
                this.kill();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        if(tickCount != 1 || tickCount != 0) {
            if (!level.isClientSide) {
                if (result.getEntity() != null) {
                    Entity entity = result.getEntity();
                    entity.hurt(DamageSource.thrown(this, this.getOwner()), 14);
                    entity.setSecondsOnFire(8);
                }
                this.kill();
            }
        }
    }
}