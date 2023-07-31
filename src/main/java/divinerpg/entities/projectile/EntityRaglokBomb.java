package divinerpg.entities.projectile;


import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class EntityRaglokBomb extends DivineThrowable {


    public EntityRaglokBomb(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    @Override
    protected void onHit(HitResult var1) {
        if(tickCount != 1 || tickCount != 0) {
            if (!this.level().isClientSide()) {
                level().explode(this, xo, yo, zo, 2.5F, false, Level.ExplosionInteraction.TNT);
            }
            this.kill();
        }
    }

    @Override
    protected float getGravity()
    {
        return 0.006F;
    }
}
