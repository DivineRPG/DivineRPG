package divinerpg.objects.entities.entity.projectiles;

import java.awt.Color;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityStar extends EntityThrowable {
	
    private Color colour;
    
    public EntityStar(World par1World) {
        super(par1World);
        this.motionX = this.rand.nextGaussian() * 0.05;
        this.motionZ = this.rand.nextGaussian() * 0.05;
        this.motionY = -0.5;
        colour = new Color(this.rand.nextInt(255), this.rand.nextInt(255), this.rand.nextInt(255));
    }

    public EntityStar(World par1World, EntityLiving par2EntityLiving) {
        super(par1World, par2EntityLiving);
        this.motionX = this.rand.nextGaussian() * 0.05;
        this.motionZ = this.rand.nextGaussian() * 0.05;
        this.motionY = -0.5;
        colour = new Color(this.rand.nextInt(255), this.rand.nextInt(255), this.rand.nextInt(255));
    }

    public EntityStar(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.motionX = this.rand.nextGaussian() * 0.05;
        this.motionZ = this.rand.nextGaussian() * 0.05;
        this.motionY = -0.5;
        colour = new Color(this.rand.nextInt(255), this.rand.nextInt(255), this.rand.nextInt(255));
    }

    public Color getColour() {
        return this.colour;
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if(result.entityHit != null) {
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 20);
        }

        if(!this.world.isRemote) {
            this.setDead();
        }
    }
}