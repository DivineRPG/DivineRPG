package divinerpg.client.renders.entity.vanilla;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import divinerpg.client.models.vanilla.ModelAequorea;
import divinerpg.entities.vanilla.overworld.EntityAequorea;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.*;

import javax.annotation.Nullable;

import static divinerpg.DivineRPG.MODID;

@OnlyIn(Dist.CLIENT)
public class RenderAequorea extends MobRenderer<EntityAequorea, ModelAequorea> {
	public static final ResourceLocation
		RED = ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/aequorea/aequorea_red.png"),
		YELLOW = ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/aequorea/aequorea_yellow.png"),
		GREEN = ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/aequorea/aequorea_green.png"),
		BLUE = ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/aequorea/aequorea_blue.png"),
		PURPLE = ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/aequorea/aequorea_purple.png"),
		PINK = ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/aequorea/aequorea_pink.png");
	public RenderAequorea(EntityRendererProvider.Context context) {super(context, new ModelAequorea(context), .3F);}
	@Nullable
	@Override protected RenderType getRenderType(EntityAequorea entity, boolean bodyVisible, boolean translucent, boolean glowing) {
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
	@Override protected void setupRotations(EntityAequorea entity, PoseStack poseStack, float bob, float yBodyRot, float partialTick, float scale) {
		float f = Mth.lerp(partialTick, entity.xBodyRotO, entity.xBodyRot);
		float f1 = Mth.lerp(partialTick, entity.zBodyRotO, entity.zBodyRot);
		poseStack.translate(0, .25F, 0);
		poseStack.mulPose(Axis.YP.rotationDegrees(180 - yBodyRot));
		poseStack.mulPose(Axis.XP.rotationDegrees(f));
		poseStack.mulPose(Axis.YP.rotationDegrees(f1));
		poseStack.translate(0, -.6F, 0);
	}
	@Override public ResourceLocation getTextureLocation(EntityAequorea type) {
		return switch(type.getColor()) {
			case 0 -> YELLOW;
			case 1 -> GREEN;
			case 2 -> BLUE;
			case 3 -> PURPLE;
			case 4 -> PINK;
			default -> RED;
		};
	}
}