package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.*;

public class EntityZoragonBomb extends DivineThrowable {

    public EntityZoragonBomb(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public EntityZoragonBomb(EntityType<? extends ThrowableEntity> type, double x, double y, double z, World world) {
        super(type, x, y, z, world);
    }

    public EntityZoragonBomb(EntityType<? extends ThrowableEntity> type, LivingEntity entity, World world) {
        super(type, entity, world);
    }

    @Override
    protected void onHit(RayTraceResult rayTraceResult) {
        if (!this.level.isClientSide) {
            this.level.explode(this, this.xo, this.yo, this.zo, 3, false, Explosion.Mode.BREAK);
            this.kill();
        }
    }
}
