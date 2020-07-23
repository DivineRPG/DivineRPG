package divinerpg.objects.entities.entity.projectiles;

import divinerpg.enums.BulletType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityTwilightMageShot extends EntityColoredBullet {

    public EntityTwilightMageShot(World world) {
        super(world);
    }

    public EntityTwilightMageShot(World world, EntityLivingBase entity, BulletType bulletType) {
        super(world, entity, bulletType);
    }

    @Override
    public float getGravityVelocity() {
        return 0;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.world.isRemote && this.ticksExisted > 50) {
            this.setDead();
        }
    }
    
    @Override
    public void onImpact(RayTraceResult result) {
        if (result.entityHit != null) {
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()),
                    this.getBulletType().getDamage());
        }
        if (!this.world.isRemote) {
            this.setDead();
        }
    }
}