package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntityFyracryxFireball extends DivineFireball {
    public EntityFyracryxFireball(EntityType<? extends FireballEntity> type, World world) {
        super(type, world);
    }

    public EntityFyracryxFireball(World world, double x, double y, double z, double accelX, double accelY, double accelZ) {
        super(world, x, y, z, accelX, accelY, accelZ);
    }

    public EntityFyracryxFireball(World world, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(world, shooter, accelX, accelY, accelZ);
    }

    @Override
    protected void onHitEntity(EntityRayTraceResult result) {
        if (!this.level.isClientSide) {
            if (result.getEntity() != null) {
                Entity entity = result.getEntity();
                entity.hurt(DamageSource.fireball(this, this.shootingEntity), 6);
            }
            this.level.explode((Entity) null, this.xo, this.yo, this.zo, 1.0F, true, Explosion.Mode.BREAK);
            this.kill();
        }
    }

    @Override
    protected void onHit(RayTraceResult p_70227_1_) {
        this.level.explode((Entity) null, this.xo, this.yo, this.zo, 1.0F, true, Explosion.Mode.BREAK);
        this.kill();
    }
}