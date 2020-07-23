package divinerpg.objects.entities.entity.projectiles;

import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityRaglokBomb extends EntityThrowable {

    public EntityRaglokBomb(World par1World) {
        super(par1World);
    }

    @Override
    protected void onImpact(RayTraceResult var1) {
        if(!this.world.isRemote){
            world.createExplosion(this, this.posX, posY, posZ, 2.5F, false);
        }
        this.setDead();
    }

    @Override
    protected float getGravityVelocity()
    {
        return 0.006F;
    }
}
