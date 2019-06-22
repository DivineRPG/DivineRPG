package naturix.divinerpg.objects.entities.entity.projectiles;

import naturix.divinerpg.objects.entities.assets.render.projectile.RenderSparkler;
import naturix.divinerpg.objects.entities.assets.render.projectiles.RenderStaff;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGeneralsStaff extends EntityParticleBullet {

	public EntityGeneralsStaff(World world, EntityLivingBase entity) {
		super(world);
		//FIXME - Probably alot wrong here
//		this.setMoreParticles();
	}
	public EntityGeneralsStaff(World world) {
		super(world);
		//FIXME - Probably alot wrong here
//		this.setMoreParticles();
	}

	@Override
	public void onImpact(RayTraceResult position) {
		super.onImpact(position);
		if(!this.world.isRemote) {
		for(double theta = 0; theta < Math.PI*2; theta += Math.PI/2) {
//			EntityParticleBullet e = new EntityParticleBullet(this.world, this.posX, this.posY, this.posZ, 18, this.getTextureName(), new Color(56, 152, 186));
//			e.setThrowableHeading(Math.cos(theta), 0.4, Math.sin(theta), 0.7f, 0);
//			this.world.spawnEntity(e);
		}
//		EntityParticleBullet e = new EntityParticleBullet(this.world, this.posX, this.posY, this.posZ, 18, this.getTextureName(), new Color(56, 152, 186));
//		e.setThrowableHeading(0, 1, 0, 0.7f, 0);
//		this.world.spawnEntity(e);
	}
	}
	@SideOnly(Side.CLIENT)
    public static void renderMe() {
    	RenderingRegistry.registerEntityRenderingHandler(EntityGeneralsStaff.class, manager -> new RenderStaff(manager));
    }
}