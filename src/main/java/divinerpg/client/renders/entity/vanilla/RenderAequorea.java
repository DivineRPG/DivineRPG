package divinerpg.client.renders.entity.vanilla;


import divinerpg.*;
import divinerpg.client.models.vanilla.*;
import divinerpg.client.renders.base.RenderDivineMob;
import divinerpg.entities.vanilla.overworld.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import net.minecraft.resources.ResourceLocation;

public class RenderAequorea extends RenderDivineMob<EntityAequorea> {
	public static final ResourceLocation
		TEXTURE1 = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/aequorea_green.png"),
		TEXTURE2 = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/aequorea_pink.png"),
		TEXTURE3 = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/aequorea_purple.png"),
		TEXTURE4 = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/aequorea_red.png"),
		TEXTURE5 = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/aequorea_yellow.png");
	public RenderAequorea(Context context) {
		super(context, "aequorea_blue", new ModelAequorea(context), 0.4F);
	}
	@Override
	public ResourceLocation getTextureLocation(EntityAequorea type) {
		return switch(type.getColor()) {
		case 0 -> TEXTURE1;
		case 1 -> TEXTURE2;
		case 2 -> TEXTURE3;
		case 3 -> TEXTURE4;
		case 4 -> TEXTURE5;
		default -> TEXTURE;
		};
	}
}