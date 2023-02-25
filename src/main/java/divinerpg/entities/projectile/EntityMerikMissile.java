package divinerpg.entities.projectile;


import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class EntityMerikMissile extends EntityHeatSeekingProjectile {
    float damage = 8.0F;

    public EntityMerikMissile(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntityMerikMissile(EntityType<? extends ThrowableProjectile> type, Level world, LivingEntity entity, float damage) {
        super(type, entity, world);
        this.damage = damage;
    }

    @Override
    protected void onHitEntity(EntityHitResult pos) {
        if(tickCount != 1 || tickCount != 0) {
            if (pos.getEntity() != null) {
                Entity entity = pos.getEntity();
                entity.hurt(DamageSource.thrown(this, this.getOwner()), this.damage);
            }
            if (!this.level.isClientSide) {
                this.level.explode(this, this.xo, this.yo, this.zo, 2, false, Explosion.BlockInteraction.BREAK);
                this.kill();
            }
        }
    }

    @Override
    protected void onHit(HitResult result) {
        if(tickCount != 1 || tickCount != 0) {
            if (!this.level.isClientSide) {
                this.level.explode(this, this.xo, this.yo, this.zo, 2, false, Explosion.BlockInteraction.BREAK);
                this.kill();
            }
        }
    }
}