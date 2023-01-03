package divinerpg.entities.projectile;

import divinerpg.enums.*;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class EntityTwilightMageShot extends EntityColoredBullet {


    public EntityTwilightMageShot(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntityTwilightMageShot(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world, BulletType bulletType) {
        super(type, entity, world, bulletType);
    }

    @Override
    public float getGravity() {
        return 0;
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level.isClientSide && this.tickCount > 50) {
            this.kill();
        }
    }
    
    @Override
    public void onHitEntity(EntityHitResult result) {
        if(tickCount != 1 || tickCount != 0) {
            if (result.getEntity() != null) {
                result.getEntity().hurt(DamageSource.thrown(this, this.getOwner()),
                        this.getBulletType().getDamage());
            }
            if (!this.level.isClientSide) {
                this.kill();
            }
        }
    }
}