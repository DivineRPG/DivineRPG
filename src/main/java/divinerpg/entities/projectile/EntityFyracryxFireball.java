package divinerpg.entities.projectile;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;

public class EntityFyracryxFireball extends DivineFireball {
    public EntityFyracryxFireball(EntityType<? extends LargeFireball> type, Level world) {
        super(type, world);
    }

    public EntityFyracryxFireball(Level world, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(world, shooter, accelX, accelY, accelZ);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        if(tickCount != 1 || tickCount != 0) {
            if (!this.level().isClientSide) {
                if (result.getEntity() != null) {
                    Entity entity = result.getEntity();
                    entity.hurt(damageSources().fireball(this, this.shootingEntity), 6);
                }
                this.level().explode((Entity) null, this.xo, this.yo, this.zo, 1.0F, true, Level.ExplosionInteraction.TNT);
                this.kill();
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (this.tickCount > 50)
            this.kill();
    }

    @Override
    protected void onHit(HitResult p_70227_1_) {
        if (tickCount > 1) {
            this.level().explode((Entity) null, this.xo, this.yo, this.zo, 1.0F, true, Level.ExplosionInteraction.TNT);
            this.kill();
        }
    }
}