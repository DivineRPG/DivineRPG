package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelKazrotic;
import divinerpg.objects.entities.entity.vethea.EntityKazrotic;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderKazrotic extends RenderLiving<EntityKazrotic> {


	ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/kazrotic.png");

	public RenderKazrotic(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelKazrotic(), 1F);

	}


	@Nullable
	@Override
	protected ResourceLocation getEntityTexture(EntityKazrotic entity) {
		return texture;
	}

	}