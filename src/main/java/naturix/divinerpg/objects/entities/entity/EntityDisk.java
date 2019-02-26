package naturix.divinerpg.objects.entities.entity;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.client.RenderSpecialProjectile;
import naturix.divinerpg.objects.entities.entity.projectiles.EntitySparkler;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityDisk extends EntityThrowable {

	public EntityDisk(World var1) {
		super(var1);
		renderMe();
	}

	public EntityDisk(World var1, EntityLivingBase var3) {
		super(var1, var3);
		renderMe();
	}

	@Override
	protected void onImpact(RayTraceResult var1) {
	}

	@SideOnly(Side.CLIENT)
	public void renderMe() {
		RenderingRegistry.registerEntityRenderingHandler(EntitySparkler.class, new RenderSpecialProjectile(new ResourceLocation(Reference.MODID + "textures/items/disk_amthrimis.png")));
	}
}