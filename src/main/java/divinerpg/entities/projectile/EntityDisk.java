package divinerpg.entities.projectile;

import divinerpg.enums.BulletType;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class EntityDisk extends EntityShooterBullet {
    public int counter = 30;
    public EntityDisk(EntityType<? extends ThrowableProjectile> type, Level world) {super(type, world);}
    public EntityDisk(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world, BulletType bulletType) {
        super(type, entity, world, bulletType);
        this.bulletType = bulletType;
    }
    //TODO: to fix disk flying and getting it back in inventory
    @Override public void tick() {
        super.tick();
        lerpMotion(getDeltaMovement().x / .99, getDeltaMovement().y / .99, getDeltaMovement().z / .99);
        if(counter == 0 && thrower != null) {
            lerpMotion(getDeltaMovement().x * -1, getDeltaMovement().y * -1, getDeltaMovement().z * -1);
            bounces++;
            counter = 30;
        } else if(counter > 0) counter--;
        if(bounces >= 12 && !level().isClientSide) discard();
    }
    @Override public void onHitEntity(EntityHitResult result) {
        if(thrower != null) {
            if(result.getEntity() != thrower) {
                result.getEntity().hurt(result.getEntity().level().damageSources().thrown(this, thrower), getBulletType().getDamage());
            } else if(result.getEntity() == thrower && thrower instanceof Player && bounces > 0) {
//                if(!((Player)thrower).isCreative()) ((Player)thrower).inventory.add(new ItemStack(item));
                if(!level().isClientSide()) discard();
            } if(bounces == 0) {
                counter = 0;
                bounces++;
            }
        } else if(!level().isClientSide()) discard();
    }
    @Override public float getGravity() {return 0;}
}