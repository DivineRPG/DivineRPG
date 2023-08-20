package divinerpg.entities.projectile;


import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;

public class EntitySerenadeOfDeath extends DivineThrowable {


    public EntitySerenadeOfDeath(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntitySerenadeOfDeath(EntityType<? extends ThrowableProjectile> type, double x, double y, double z, Level world) {
        super(type, x, y, z, world);
    }

    public EntitySerenadeOfDeath(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world) {
        super(type, entity, world);
        Vec3 vector = entity.getLookAngle().scale(1.5);
        this.setPos(xo + vector.x, yo + vector.y, zo + vector.z);
    }

    @Override
    protected void onHitEntity(EntityHitResult var1) {
        if (tickCount != 1 || tickCount != 0) {
            if (var1.getEntity() != null) {
                Entity entity = var1.getEntity();
                if(!(entity instanceof EnderMan)) {
                    entity.hurt(damageSources().thrown(this, this.getOwner()), 14.0F);
                    if (var1.getEntity() instanceof LivingEntity) {
                        ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.POISON, 45, 3));
                    }
                }
            }

            if (!this.level().isClientSide()) {
                this.kill();
            }
        }
    }
}