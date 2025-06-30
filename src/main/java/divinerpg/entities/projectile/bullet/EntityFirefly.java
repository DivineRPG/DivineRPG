package divinerpg.entities.projectile.bullet;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class EntityFirefly extends EntityHeatSeekingProjectile {

    public EntityFirefly(EntityType<? extends ThrowableProjectile> type, Level world) {super(type, world);}
    @Override protected void onHitEntity(EntityHitResult result) {
        if(tickCount > 1) {
            if(result.getEntity() instanceof LivingEntity entity) entity.hurt(damageSources().indirectMagic(this, getOwner()), 8);
            if(!level().isClientSide()) discard();
        }
    }
}