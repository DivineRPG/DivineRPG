package net.divinerpg.entities.twilight.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;


public class EntitySlicerWildWoods extends EntityThrowable
{
    public EntitySlicerWildWoods(World var1)
    {
        super(var1);
    }

    public EntitySlicerWildWoods(World var1, EntityLivingBase var2)
    {
        super(var1, var2);
    }

    public EntitySlicerWildWoods(World var1, double var2, double var4, double var6)
    {
        super(var1, var2, var4, var6);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    @Override
    protected void onImpact(MovingObjectPosition var1)
    {
        if (var1.entityHit != null)
        {
            byte var2 = 18;

            if (var1.entityHit instanceof EntityBlaze)
            {
                var2 = 18;
            }

            var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), var2);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
}
