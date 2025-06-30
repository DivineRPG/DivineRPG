package divinerpg.entities.projectile.bullet;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;

import static net.minecraft.world.level.Level.ExplosionInteraction.TNT;

public class EntityMerikMissile extends EntityHeatSeekingProjectile {
    float damage = 1;
    public EntityMerikMissile(EntityType<? extends ThrowableProjectile> type, Level world) {super(type, world);}
    public EntityMerikMissile(EntityType<? extends ThrowableProjectile> type, Level world, LivingEntity entity, float damage) {
        super(type, entity, world);
        this.damage = damage;
    }
    @Override protected void onHitEntity(EntityHitResult pos) {
        if(tickCount > 1) {
            if(pos.getEntity() != null) {
                Entity entity = pos.getEntity();
                entity.hurt(damageSources().thrown(this, getOwner()), damage);
            }
            if(!level().isClientSide()) {
                level().explode(this, xo, yo, zo, 2, false, TNT);
                discard();
            }
        }
    }
    @Override protected void onHit(HitResult result) {
        if(tickCount > 1) {
            if(!level().isClientSide) {
                level().explode(this, xo, yo, zo, 2, false, TNT);
                discard();
            }
        }
    }
}