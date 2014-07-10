package net.divinerpg.entities.twilight.projectile;

import net.divinerpg.entities.twilight.effects.EntityWildWoodPortalFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityBlitzWildWood extends EntityThrowable
{
    public EntityBlitzWildWood(World var1)
    {
        super(var1);
    }

    public EntityBlitzWildWood(World var1, EntityLivingBase var2)
    {
        super(var1, var2);
    }

    public EntityBlitzWildWood(World var1, double var2, double var4, double var6)
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
            EntityWildWoodPortalFX var20 = new EntityWildWoodPortalFX(this.worldObj, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
            FMLClientHandler.instance().getClient().effectRenderer.addEffect(var20);
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
            byte var2 = 22;

            if (var1.entityHit instanceof EntityBlaze)
            {
                var2 = 22;
            }

            var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), var2);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
}
