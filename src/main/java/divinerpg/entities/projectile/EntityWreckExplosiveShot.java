package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntityWreckExplosiveShot extends DivineThrowable {


    public EntityWreckExplosiveShot(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public EntityWreckExplosiveShot(EntityType<? extends ThrowableEntity> type, double x, double y, double z, World world) {
        super(type, x, y, z, world);
    }

    public EntityWreckExplosiveShot(EntityType<? extends ThrowableEntity> type, LivingEntity entity, World world) {
        super(type, entity, world);
    }

    @Override
    protected void onHit(RayTraceResult par1MovingObjectPosition) {
        if (!this.level.isClientSide) {
            this.kill();
            this.level.explode(this, this.xo, this.yo, this.zo, 3, false, Explosion.Mode.BREAK);
        }
    }

    @Override
    protected float getGravity()
    {
        return 0.0007F;
    }
}