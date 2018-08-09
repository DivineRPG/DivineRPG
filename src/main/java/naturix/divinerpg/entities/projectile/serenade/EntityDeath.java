package naturix.divinerpg.entities.projectile.serenade;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityDeath extends EntityThrowable {

	public EntityDeath(World var1) {
        super(var1);
    }

    public EntityDeath(World var1, EntityLivingBase var2) {
        super(var1, var2);
    }

    public EntityDeath(World var1, double var2, double var4, double var6) {
        super(var1, var2, var4, var6);
    }

	@Override
	protected void onImpact(RayTraceResult result) {
		if (result.entityHit != null) {
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 14.0F);
            if(result.entityHit instanceof EntityLivingBase)((EntityLivingBase)result.entityHit).addPotionEffect(new PotionEffect(MobEffects.POISON, 45, 3));
        }

        if (!this.world.isRemote) {
            this.setDead();
        }
	}
}
