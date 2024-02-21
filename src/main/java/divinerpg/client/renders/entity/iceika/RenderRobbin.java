package divinerpg.client.renders.entity.iceika;

import divinerpg.DivineRPG;
import divinerpg.client.models.iceika.ModelRobbin;
import divinerpg.client.renders.layer.RobbinLayer;
import divinerpg.entities.iceika.EntityRobbin;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RenderRobbin extends MobRenderer<EntityRobbin, ModelRobbin> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/robbin.png");
	public RenderRobbin(Context context) {
		super(context, new ModelRobbin(context), .2F);
		addLayer(new RobbinLayer(this));
	}
	@Override public ResourceLocation getTextureLocation(EntityRobbin robbin) {
		return TEXTURE;
	}
}