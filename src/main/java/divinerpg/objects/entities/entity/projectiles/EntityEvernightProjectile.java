package divinerpg.objects.entities.entity.projectiles;

import divinerpg.objects.entities.assets.render.projectile.RenderBouncingProjectile;
import divinerpg.objects.entities.assets.render.projectile.RenderEvernightProjectile;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityEvernightProjectile extends EntityThrowable
{
    public int damage;
    public EntityLivingBase thrower;
    protected int bounces;
    
    public EntityEvernightProjectile(World par1) {
        super(par1);
    }

    public EntityEvernightProjectile(World par1, EntityLivingBase par2, int par3) {
        super(par1, par2);
        this.damage = par3;
        this.thrower = par2;
    }

    public EntityEvernightProjectile(World par1, double par2, double par4, double par6) {
        super(par1, par2, par4, par6);
        this.setVelocity(this.motionX * 0.01D, this.motionY * 0.01D, this.motionZ * 0.01D);
    }

    @Override
    protected void onImpact(RayTraceResult par1)
    {
        if (par1.entityHit != null && par1.entityHit != this.thrower)
        {
            par1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.thrower), this.damage);

            if (!this.world.isRemote)
            {
                this.setDead();
            }
            return;
        }

        if (par1.sideHit == EnumFacing.DOWN || par1.sideHit == EnumFacing.UP)
        {
            this.motionY *= -1.0D;
        }      
        else if (par1.sideHit == EnumFacing.EAST || par1.sideHit == EnumFacing.WEST)
        {
            this.motionZ *= -1.0D;
        }      
        else if (par1.sideHit == EnumFacing.NORTH || par1.sideHit == EnumFacing.SOUTH)
        {
            this.motionX *= -1.0D;
        }
        this.bounces++;

        if (this.bounces == 7)
        {
            this.setDead();
        }
    }
    @SideOnly(Side.CLIENT)
	public static void renderMe() {
        RenderingRegistry.registerEntityRenderingHandler(EntityEvernightProjectile.class, manager -> new RenderEvernightProjectile(manager));
    	}
}