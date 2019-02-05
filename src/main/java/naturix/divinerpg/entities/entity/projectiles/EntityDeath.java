package naturix.divinerpg.entities.entity.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityDeath extends EntityThrowable {

	public EntityDeath(World var1) {
		super(var1);
	}

	public EntityDeath(World var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	public EntityDeath(World var1, EntityLivingBase var2) {
		super(var1, var2);
	}

	@Override
	protected void onImpact(RayTraceResult var1) {
		if (var1.entityHit != null) {
			var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 14.0F);
			if (var1.entityHit instanceof EntityLivingBase) {
				((EntityLivingBase) var1.entityHit)
				        .addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("poison"), 45, 3));
			}
		}

		if (!this.world.isRemote) {
			this.setDead();
		}
	}
}