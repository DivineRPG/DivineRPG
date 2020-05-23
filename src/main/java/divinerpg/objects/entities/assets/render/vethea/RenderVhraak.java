package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelVhraak;
import divinerpg.objects.entities.entity.vethea.EntityVhraak;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderVhraak extends RenderLiving<EntityVhraak> {


	ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/vhraak.png");

	public RenderVhraak(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelVhraak(), 1F);

	}


	@Nullable
	@Override
	protected ResourceLocation getEntityTexture(EntityVhraak entity) {
		return texture;
	}

	}