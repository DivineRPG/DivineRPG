package naturix.divinerpg.objects.entities.entity.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityShuriken extends EntityThrowable {

    public EntityShuriken(World worldIn) {
        super(worldIn);
    }

    public EntityShuriken(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    public EntityShuriken(World worldIn, EntityLivingBase throwerIn) {
        super(worldIn, throwerIn);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (result.entityHit != null) {
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 4.0F);
        }
        if (!this.world.isRemote) {
            this.setDead();
        }
    }
}