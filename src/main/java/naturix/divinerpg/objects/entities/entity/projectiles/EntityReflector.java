package naturix.divinerpg.objects.entities.entity.projectiles;

import naturix.divinerpg.objects.entities.assets.render.projectile.RenderFirefly;
import naturix.divinerpg.objects.entities.assets.render.projectile.RenderReflector;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityReflector extends EntityThrowable {
    
    int age;

    public EntityReflector(World w) {
        super(w);
    }
    
    public EntityReflector(World w, EntityLivingBase e) {
        super(w, e);
        this.motionX*=3;
        this.motionY*=3;
        this.motionZ*=3;
    }

    @Override
    protected void onImpact(RayTraceResult pos) {
        if(pos.entityHit != null && this.getThrower() != null) {
            double xDist = (pos.entityHit.posX-this.getThrower().posX)/5, yDist = (pos.entityHit.posY-this.getThrower().posY)/5, zDist = (pos.entityHit.posZ-this.getThrower().posZ)/5;
            pos.entityHit.addVelocity(xDist, yDist, zDist);
        }
        this.setDead();
    }
    
    @Override
    public float getGravityVelocity() {
        return 0;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        age++;
        if(age>18)this.setDead();//I'm an Adult!
    }
    @SideOnly(Side.CLIENT)
	public static void renderMe() {
    RenderingRegistry.registerEntityRenderingHandler(EntityReflector.class, manager -> new RenderReflector(manager));
	}
}