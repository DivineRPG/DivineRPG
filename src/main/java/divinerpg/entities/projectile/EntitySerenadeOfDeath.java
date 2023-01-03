package divinerpg.entities.projectile;


import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

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
                entity.hurt(DamageSource.thrown(this, this.getOwner()), 14.0F);
                if (var1.getEntity() instanceof LivingEntity) {
                    ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.POISON, 45, 3));
                }
            }

            if (!this.level.isClientSide) {
                this.kill();
            }
        }
    }
}