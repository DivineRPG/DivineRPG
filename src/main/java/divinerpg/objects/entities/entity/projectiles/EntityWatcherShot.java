package divinerpg.objects.entities.entity.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityWatcherShot extends EntityThrowable {

    public EntityWatcherShot(World var1) {
        super(var1);
    }

    public EntityWatcherShot(World var1, EntityLivingBase var2) {
        super(var1, var2);
    }

    public EntityWatcherShot(World var1, double var2, double var4, double var6) {
        super(var1, var2, var4, var6);
    }

    @Override
    public void onImpact(RayTraceResult result) {
        if (!this.world.isRemote) {
            boolean flag = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this);
            this.world.createExplosion(null, this.posX, this.posY, this.posZ, 5.0F, flag);
        }

        if (result.entityHit != null) {
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 4.0F);
        }

        if (!this.world.isRemote) {
            this.setDead();
        }
    }
}