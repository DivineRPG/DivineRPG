package divinerpg.objects.entities.entity.projectiles;

import divinerpg.objects.entities.assets.render.projectiles.RenderMeteor;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityMeteor extends EntityThrowable {
    
public EntityMeteor(World par1World) {
    super(par1World);
    this.motionX = this.rand.nextGaussian() * 0.05;
    this.motionZ = this.rand.nextGaussian() * 0.05;
    this.motionY = -0.5;
}

public EntityMeteor(World par1World, EntityLiving par2EntityLiving) {
    super(par1World, par2EntityLiving);
    this.motionX = this.rand.nextGaussian() * 0.05;
    this.motionZ = this.rand.nextGaussian() * 0.05;
    this.motionY = -0.5;
}

public EntityMeteor(World par1World, double par2, double par4, double par6) {
    super(par1World, par2, par4, par6);
    this.motionX = this.rand.nextGaussian() * 0.05;
    this.motionZ = this.rand.nextGaussian() * 0.05;
    this.motionY = -0.5;
}


@Override
protected float getGravityVelocity() {
    return 0.07F;
}

@Override
protected void onImpact(RayTraceResult result) {
	if(result.entityHit != null) {
		result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 12);
    }
    
    this.world.createExplosion(this, this.posX, this.posY, this.posZ, 4.5F, false);

    if(!this.world.isRemote) {
        this.setDead();
    }
}
	@SideOnly(Side.CLIENT)
	public static void renderMe() {
    RenderingRegistry.registerEntityRenderingHandler(EntityMeteor.class, manager -> new RenderMeteor(manager));
	}
}