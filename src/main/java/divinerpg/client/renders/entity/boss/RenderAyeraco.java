package divinerpg.client.renders.entity.boss;

import divinerpg.DivineRPG;
import divinerpg.client.models.boss.ModelAyeraco;
import divinerpg.client.renders.base.RenderDivineMob;
import divinerpg.entities.boss.EntityAyeraco;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class RenderAyeraco extends RenderDivineMob<EntityAyeraco> {
	public static final ResourceLocation
		TEXTURE0 = new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_blue.png"),
		TEXTURE1 = new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_green.png"),
		TEXTURE2 = new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_pink.png"),
		TEXTURE3 = new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_purple.png"),
		TEXTURE4 = new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_red.png"),
		TEXTURE5 = new ResourceLocation(DivineRPG.MODID, "textures/entity/ayeraco_yellow.png");
	public RenderAyeraco(Context context) {
		super(context, "ayeraco_white", new ModelAyeraco(context), 0.4F);
	}
	@Override
	public ResourceLocation getTextureLocation(EntityAyeraco type) {
		return switch(type.getVariant()) {
		case 0 -> TEXTURE0;
		case 1 -> TEXTURE1;
		case 2 -> TEXTURE2;
		case 3 -> TEXTURE3;
		case 4 -> TEXTURE4;
		case 5 -> TEXTURE5;
		default -> TEXTURE;
		};
	}
}