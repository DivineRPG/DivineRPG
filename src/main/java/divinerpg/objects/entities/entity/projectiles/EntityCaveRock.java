package divinerpg.objects.entities.entity.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityCaveRock extends EntityThrowable {

    public EntityCaveRock(World var1) {
        super(var1);
    }

    public EntityCaveRock(World var1, EntityLivingBase var2) {
        super(var1, var2);
    }

    public EntityCaveRock(World var1, double var2, double var4, double var6) {
        super(var1, var2, var4, var6);
    }

    @Override
    public void onImpact(RayTraceResult result) {
        if (result.entityHit != null) {
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 6.0F);
        }
        if (!this.world.isRemote) {
            this.setDead();
        }
    }
}