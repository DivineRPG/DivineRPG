package divinerpg.objects.entities.entity.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityCoriShot extends EntityThrowable {
    private float damage;

    public EntityCoriShot(World worldIn) {
        super(worldIn);
    }

    public EntityCoriShot(World worldIn, EntityLivingBase entity, float damage) {
        super(worldIn, entity);
        this.damage = damage;
    }

    @Override
    public void onImpact(RayTraceResult result) {
        if (result.entityHit != null) {
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), damage);
        }
        if (!this.world.isRemote) {
            this.setDead();
        }
    }
}