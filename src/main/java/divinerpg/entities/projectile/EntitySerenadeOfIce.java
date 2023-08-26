package divinerpg.entities.projectile;


import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

import java.util.List;

public class EntitySerenadeOfIce extends DivineThrowable {
    int age;

    public EntitySerenadeOfIce(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntitySerenadeOfIce(EntityType<? extends ThrowableProjectile> type, double x, double y, double z, Level world) {
        super(type, x, y, z, world);
    }

    public EntitySerenadeOfIce(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world) {
        super(type, entity, world);
        setDeltaMovement(getDeltaMovement().x*3, getDeltaMovement().y*3, getDeltaMovement().z*3);
    }


    @Override
    public float getGravity() {
        return 0;
    }

    @Override
    public void tick() {
        super.tick();
        age++;
        if (!this.level().isClientSide() && age > 35)
            this.kill();
    }

    @Override
    protected void onHitEntity(EntityHitResult var1) {
        if(tickCount != 1 || tickCount != 0) {
            if (var1.getEntity() != null) {
                List<LivingEntity> entities = this.level().getEntitiesOfClass(LivingEntity.class,
                        var1.getEntity().getBoundingBox().expandTowards(3, 3, 3));
                for (LivingEntity e : entities) {
                    if (e != this.getOwner())
                        e.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 3));
                }
            }

            if (!this.level().isClientSide()) {
                this.kill();
            }
        }
    }
}