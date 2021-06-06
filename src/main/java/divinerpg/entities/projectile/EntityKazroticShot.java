package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntityKazroticShot extends DivineThrowable {

    public EntityKazroticShot(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public EntityKazroticShot(EntityType<? extends ThrowableEntity> type, double x, double y, double z, World world) {
        super(type, x, y, z, world);
    }

    public EntityKazroticShot(EntityType<? extends ThrowableEntity> type, LivingEntity entity, World world) {
        super(type, entity, world);
    }

    @Override
    protected void onHit(RayTraceResult result) {
        if(!this.level.isClientSide) {
            this.level.explode(this, this.xo, this.yo, this.zo, 3, false, Explosion.Mode.BREAK);
            this.kill();
        }
    }

    protected float getGravityVelocity() {
        return 0.0007F;
    }
}