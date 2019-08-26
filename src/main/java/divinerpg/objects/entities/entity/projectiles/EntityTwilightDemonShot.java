package divinerpg.objects.entities.entity.projectiles;

import divinerpg.enums.BulletType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityTwilightDemonShot extends EntityColoredBullet {

    public EntityTwilightDemonShot(World world) {
        super(world);
    }

    public EntityTwilightDemonShot(World world, EntityLivingBase entity, BulletType bulletType) {
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

    @Override
    public void onImpact(RayTraceResult result) {
        super.onImpact(result);
        if (result.entityHit != null && result.entityHit instanceof EntityPlayer) {
            ((EntityPlayer) result.entityHit).addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 200, 0));
        }
    }
}