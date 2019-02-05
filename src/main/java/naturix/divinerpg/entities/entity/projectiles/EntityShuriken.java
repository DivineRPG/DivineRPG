package naturix.divinerpg.entities.entity.projectiles;

import naturix.divinerpg.registry.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityShuriken extends EntityThrowable {
	@SideOnly(Side.CLIENT)
	public static void renderMe() {
		// Vilestorm
		RenderingRegistry.registerEntityRenderingHandler(EntityShuriken.class,
		        manager -> new RenderSnowball<>(manager, ModItems.shuriken, Minecraft.getMinecraft().getRenderItem()));
	}

	public EntityShuriken(World var1) {
		super(var1);
	}

	public EntityShuriken(World var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	public EntityShuriken(World var1, EntityLivingBase var3) {
		super(var1, var3);
	}

	@Override
	protected void onImpact(RayTraceResult var1) {
		if (var1.entityHit != null) {
			byte var2 = 4;

			if (var1.entityHit instanceof EntityBlaze) {
				var2 = 4;
			}

			if (var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), var2)) {
			}
		}

		if (!this.world.isRemote) {
			this.setDead();
		}
	}
}