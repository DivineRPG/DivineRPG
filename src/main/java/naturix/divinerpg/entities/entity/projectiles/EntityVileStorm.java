package naturix.divinerpg.entities.entity.projectiles;

import naturix.divinerpg.registry.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityVileStorm extends EntityThrowable {
	@SideOnly(Side.CLIENT)
	public static void renderMe() {
		// Vilestorm
		RenderingRegistry.registerEntityRenderingHandler(EntityVileStorm.class,
		        manager -> new RenderSnowball<>(manager, ModItems.vileStorm, Minecraft.getMinecraft().getRenderItem()));
	}

	public EntityVileStorm(World var1) {
		super(var1);
	}

	public EntityVileStorm(World var1, EntityLivingBase var3) {
		super(var1, var3);
	}

	@Override
	protected void onImpact(RayTraceResult var1) {
		if (var1.entityHit != null) {
			byte var2 = 4;

			if (var1.entityHit instanceof EntityLiving) {
				var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), var2);
				((EntityLivingBase) var1.entityHit)
				        .addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("poison"), 45, 3));
			}
		}

		if (!this.world.isRemote) {
			this.setDead();
		}
	}
}
