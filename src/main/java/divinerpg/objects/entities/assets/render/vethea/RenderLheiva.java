package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelLheiva;
import divinerpg.objects.entities.entity.vethea.EntityLheiva;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderLheiva extends RenderLiving<EntityLheiva> {


	ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/lheiva.png");

	public RenderLheiva(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelLheiva(), 1F);

	}


	@Nullable
	@Override
	protected ResourceLocation getEntityTexture(EntityLheiva entity) {
		return texture;
	}

}