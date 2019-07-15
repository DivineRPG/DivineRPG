package naturix.divinerpg.objects.entities.entity.projectiles;

import naturix.divinerpg.objects.entities.assets.render.projectile.RenderFyracryxFireball;
import naturix.divinerpg.objects.entities.assets.render.projectile.RenderGrenade;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityFyracryxFireball extends EntitySmallFireball {

	public EntityFyracryxFireball(World par1World) {
		super(par1World);
	}

	public EntityFyracryxFireball(World par1World, EntityLiving par2EntityLiving, double par3, double par5, double par7) {
		super(par1World, par2EntityLiving, par3, par5, par7);
	}

	@SideOnly(Side.CLIENT)
	public EntityFyracryxFireball(World par1World, double par2, double par4, double par6, double par8, double par10, double par12) {
		super(par1World, par2, par4, par6, par8, par10, par12);
	}

	@Override
	protected void onImpact(RayTraceResult par1MovingObjectPosition) {
		if (!this.world.isRemote) {
			if (par1MovingObjectPosition.entityHit != null) 
				par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 6);
			this.world.newExplosion((Entity)null, this.posX, this.posY, this.posZ, 1.0F, true, false);
			this.setDead();
		}
	}
	
	
	@SideOnly(Side.CLIENT)
    public static void renderMe() {
        RenderingRegistry.registerEntityRenderingHandler(EntityFyracryxFireball.class, manager -> new RenderFyracryxFireball(manager));
    }
}