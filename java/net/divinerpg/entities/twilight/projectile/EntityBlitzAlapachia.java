package net.divinerpg.entities.twilight.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class EntityBlitzAlapachia extends EntityThrowable
{
    public EntityBlitzAlapachia(World var1)
    {
        super(var1);
    }

    public EntityBlitzAlapachia(World var1, EntityLivingBase var2)
    {
        super(var1, var2);
    }

    public EntityBlitzAlapachia(World var1, double var2, double var4, double var6)
    {
        super(var1, var2, var4, var6);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void onUpdate()
    {
        super.onUpdate();
        float var10 = 0.25F;

        for (int var3 = 0; var3 < 8; ++var3)
        {
            this.worldObj.spawnParticle("portal", this.posX - this.motionX * var10 + this.rand.nextDouble() * 0.6D - 0.3D, this.posY - this.motionY * var10 - 0.5D, this.posZ - this.motionZ * var10 + this.rand.nextDouble() * 0.6D - 0.3D, this.motionX, this.motionY, this.motionZ);
        }
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    @Override
    protected void onImpact(MovingObjectPosition var1)
    {
        if (var1.entityHit != null)
        {
            byte var2 = 19;

            if (var1.entityHit instanceof EntityBlaze)
            {
                var2 = 19;
            }

            var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), var2);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
}
