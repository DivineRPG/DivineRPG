package naturix.divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.twilight.model.ModelDensos;
import naturix.divinerpg.objects.entities.entity.twilight.EntityReyvor;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderReyvor extends RenderLiving<EntityReyvor> {

	public static class Factory implements IRenderFactory<EntityReyvor> {

		@Override
		public Render<? super EntityReyvor> createRenderFor(RenderManager manager) {
			return new RenderReyvor(manager, new ModelDensos(), 0.5F);
		}
	}

	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/reyvor.png");

	public RenderReyvor(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
		super(rendermanagerIn, new ModelDensos(), 1F);

	}

	@Nullable
	@Override
	protected ResourceLocation getEntityTexture(EntityReyvor entity) {
		return texture;
	}

}