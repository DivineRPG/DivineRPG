package divinerpg.objects.entities.entity.projectiles;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntitySerenadeOfIce extends EntityThrowable {
    int age;

    public EntitySerenadeOfIce(World var1) {
        super(var1);
    }

    public EntitySerenadeOfIce(World var1, double var2, double var4, double var6) {
        super(var1, var2, var4, var6);
    }

    public EntitySerenadeOfIce(World var1, EntityPlayer var2) {
        super(var1, var2);
        this.motionX *= 3;
        this.motionY *= 3;
        this.motionZ *= 3;
    }

    @Override
    public float getGravityVelocity() {
        return 0;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        age++;
        if (!this.world.isRemote && age > 35)
            this.setDead();
    }

    @Override
    protected void onImpact(RayTraceResult var1) {
        if (var1.entityHit != null) {
            List<EntityLivingBase> entities = this.world.getEntitiesWithinAABB(EntityLivingBase.class,
                    var1.entityHit.getEntityBoundingBox().expand(3, 3, 3));
            for (EntityLivingBase e : entities) {
                if (e != this.getThrower())
                    e.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 3));
            }
        }

        if (!this.world.isRemote) {
            this.setDead();
        }
    }
}