package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntityRaglokBomb extends DivineThrowable {


    public EntityRaglokBomb(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    @Override
    protected void onHit(RayTraceResult var1) {
        if(!this.level.isClientSide){
            level.explode(this, xo, yo, zo, 2.5F, false, Explosion.Mode.BREAK);
        }
        this.kill();
    }

    @Override
    protected float getGravity()
    {
        return 0.006F;
    }
}
