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
    protected void onHit(RayTraceResult result) {
        if (!this.level.isClientSide) {
            if (result.hitInfo != null && result.hitInfo instanceof Entity) {
                Entity entity = (Entity) result.hitInfo;
                entity.hurt(DamageSource.fireball(this, this.shootingEntity), 6);
            }
            this.level.explode((Entity) null, this.xo, this.yo, this.zo, 1.0F, true, Explosion.Mode.BREAK);
            this.kill();
        }
    }
}