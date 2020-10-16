package divinerpg.objects.entities.entity.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntitySnowflakeShuriken extends EntityThrowable {

    public EntitySnowflakeShuriken(World worldIn) {
        super(worldIn);
    }

    public EntitySnowflakeShuriken(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    public EntitySnowflakeShuriken(World worldIn, EntityLivingBase throwerIn) {
        super(worldIn, throwerIn);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (result.entityHit != null) {
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 7.0F);
        }
        if (!this.world.isRemote) {
            this.setDead();
        }
    }
}