package divinerpg.objects.entities.entity.projectiles;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityKazroticShot extends EntityThrowable {

    public EntityKazroticShot(World par1World) {
        super(par1World);
    }

    public EntityKazroticShot(World par1World, EntityLiving par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }

    public EntityKazroticShot(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if(!this.world.isRemote) {
            this.world.createExplosion(this, this.posX, this.posY, this.posZ, 3, false);
            this.setDead();
        }
    }

    protected float getGravityVelocity() {
        return 0.0007F;
    }
}