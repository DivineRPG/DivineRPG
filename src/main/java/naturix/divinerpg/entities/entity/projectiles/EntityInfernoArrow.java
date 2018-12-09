package naturix.divinerpg.entities.entity.projectiles;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityInfernoArrow extends EntityArrow{

	public EntityInfernoArrow(World worldIn) {
		super(worldIn);
	}

	@Override
	protected ItemStack getArrowStack() {
		return ModItems.arrowInferno.getDefaultInstance();
	}

	@Override
	protected void arrowHit(EntityLivingBase living)
    {
		living.setFire(rand.nextInt(20));
    }
	
	@Override
	public void shoot(Entity shooter, float pitch, float yaw, float p_184547_4_, float velocity, float inaccuracy)
    {
        float f = -MathHelper.sin(yaw * 0.017453292F) * MathHelper.cos(pitch * 0.017453292F);
        float f1 = -MathHelper.sin(pitch * 0.017453292F);
        float f2 = MathHelper.cos(yaw * 0.017453292F) * MathHelper.cos(pitch * 0.017453292F);
        this.shoot((double)f, (double)f1, (double)f2, velocity, inaccuracy);
        this.motionX += shooter.motionX;
        this.motionZ += shooter.motionZ;
        
        if (!shooter.onGround)
        {
            this.motionY += shooter.motionY;
        }
    DivineRPG.logger.info(shooter.getName() + " just shot an arrow with the pitch "+pitch+" and the yaw of "+yaw+" and it traveled at a velocity of "+velocity+" and had an inaccuracy value of "+inaccuracy);
    
    }
}
