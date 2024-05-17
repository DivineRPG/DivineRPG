package divinerpg.entities.projectile;

import divinerpg.enums.BulletType;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class EntityTwilightDemonShot extends EntityParticleBullet {


    public EntityTwilightDemonShot(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntityTwilightDemonShot(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world, BulletType bulletType) {
        super(type, world, entity, bulletType);
    }

    @Override
    public float getGravity() {
        return 0;
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide() && this.tickCount > 20) {
            this.kill();
        }
    }

    @Override
    public void onHitEntity(EntityHitResult result) {
        if (tickCount != 1 || tickCount != 0) {
            if (result.getEntity() != null && result.getEntity() instanceof Player) {
                ((Player) result.getEntity()).addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0));
                ((Player) result.getEntity()).hurt(damageSources().mobAttack((LivingEntity) this.getOwner()), 5);
            }
        }
    }
}