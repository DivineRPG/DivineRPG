package naturix.divinerpg.objects.entities.assets.render.projectile;

import naturix.divinerpg.objects.entities.entity.iceika.EntitySnowShuriken;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderSnowShuriken extends RenderProjectile<EntitySnowShuriken> {
	private ResourceLocation TEXTURE = new ResourceLocation("divinerpg:textures/items/shuriken_snow.png");

	public RenderSnowShuriken(RenderManager manager, float scaleIn) {
		super(manager, scaleIn);
		this.bindTexture(TEXTURE);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntitySnowShuriken entity) {
		return TEXTURE;
	}
}