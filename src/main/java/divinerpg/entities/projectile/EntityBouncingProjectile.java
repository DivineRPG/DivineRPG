package divinerpg.entities.projectile;

import divinerpg.enums.BulletType;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;

public class EntityBouncingProjectile extends EntityShooterBullet {
    public EntityBouncingProjectile(EntityType<? extends ThrowableProjectile> type, Level world) {super(type, world);}
    public EntityBouncingProjectile(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world, BulletType bulletType) {
        super(type, entity, world, bulletType);
        this.bulletType = bulletType;
    }
    @Override public void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        if(result.getEntity() instanceof LivingEntity entity && entity != thrower) {
            entity.hurt(damageSources().indirectMagic(this, thrower), getBulletType().getDamage());
            discard();
        }
    }
    @Override public void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        if(result.getDirection() == Direction.DOWN || result.getDirection() == Direction.UP) {
            setDeltaMovement(getDeltaMovement().x, getDeltaMovement().y * -1, getDeltaMovement().z);
        } else if(result.getDirection() == Direction.EAST || result.getDirection() == Direction.WEST) {
            setDeltaMovement(getDeltaMovement().x * -1, getDeltaMovement().y, getDeltaMovement().z);
        } else if(result.getDirection() == Direction.NORTH || result.getDirection() == Direction.SOUTH) {
            setDeltaMovement(getDeltaMovement().x, getDeltaMovement().y, getDeltaMovement().z * -1);
        } bounces++;
        if(bounces == 7) discard();
    }
}