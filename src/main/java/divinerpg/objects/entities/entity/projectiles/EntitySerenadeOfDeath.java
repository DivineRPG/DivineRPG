package divinerpg.objects.entities.entity.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntitySerenadeOfDeath extends EntityThrowable {

    public EntitySerenadeOfDeath(World var1) {
        super(var1);
    }

    public EntitySerenadeOfDeath(World var1, double var2, double var4, double var6) {
        super(var1, var2, var4, var6);
    }

    public EntitySerenadeOfDeath(World var1, EntityLivingBase var2) {
        super(var1, var2);

        Vec3d vector = var2.getLookVec().scale(1.5);
        this.setPosition(posX + vector.x, posY + vector.y, posZ + vector.z);
    }

    @Override
    protected void onImpact(RayTraceResult var1) {
        if (var1.entityHit != null) {
            var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 14.0F);
            if (var1.entityHit instanceof EntityLivingBase) {
                ((EntityLivingBase) var1.entityHit).addPotionEffect(new PotionEffect(MobEffects.POISON, 45, 3));
            }
        }

        if (!this.world.isRemote) {
            this.setDead();
        }
    }
}