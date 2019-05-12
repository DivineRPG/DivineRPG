package naturix.divinerpg.objects.entities.entity.projectiles;

import naturix.divinerpg.enums.BulletType;
import net.minecraft.entity.EntityLivingBase;
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
        if (!this.world.isRemote && this.ticksExisted > 20) {
            this.setDead();
        }
    }
}