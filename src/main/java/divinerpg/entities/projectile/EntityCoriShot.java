package divinerpg.entities.projectile;


import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class EntityCoriShot extends DivineThrowable {
    private float damage;

    public EntityCoriShot(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntityCoriShot(EntityType<? extends ThrowableProjectile> type, Level world, LivingEntity entity, float damage) {
        super(type, entity, world);
        this.damage = damage;
    }

    @Override
    public void onHitEntity(EntityHitResult result) {
        if (tickCount != 1 || tickCount != 0) {
            if (result.getEntity() != null) {
                Entity entity = result.getEntity();
                entity.hurt(DamageSource.thrown(this, this.getOwner()), damage);
            }
            if (!this.level.isClientSide) {
                this.kill();
            }
        }
    }
}