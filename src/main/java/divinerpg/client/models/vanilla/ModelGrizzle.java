package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.base.EntityDivineTameable;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelGrizzle<T extends EntityDivineTameable> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("grizzle");
	private final ModelPart leg1, leg2, leg4, leg3, body, head;
	public ModelGrizzle(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		body = root.getChild("body");
		head = root.getChild("head");
		leg1 = root.getChild("leg1");
		leg2 = root.getChild("leg2");
		leg3 = root.getChild("leg3");
		leg4 = root.getChild("leg4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-6F, -12F, -9F, 16F, 13F, 13F, CubeDeformation.NONE)
				.texOffs(0, 26).addBox(-5F, -23F, -8F, 14F, 11F, 11F, CubeDeformation.NONE), PartPose.offsetAndRotation(-2F, 9F, 12F, 1.5708F, 0F, 0F));

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 48).addBox(-5F, -3F, -3F, 10F, 8F, 8F, CubeDeformation.NONE)
				.texOffs(50, 37).addBox(-3F, 1F, -7F, 6F, 4F, 4F, CubeDeformation.NONE)
				.texOffs(51, 45).addBox(3F, -5F, 0F, 3F, 4F, 1F, CubeDeformation.NONE)
				.texOffs(51, 45).mirror().addBox(-6F, -5F, 0F, 3F, 4F, 1F, CubeDeformation.NONE).mirror(false), PartPose.offset(0F, 10F, -16F));

		partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(50, 26).addBox(-3F, 2F, -2.5F, 5F, 6F, 5F, CubeDeformation.NONE), PartPose.offset(-4.5F, 16F, 10F));

		partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(50, 26).mirror().addBox(-2F, 2F, -2.5F, 5F, 6F, 5F, CubeDeformation.NONE).mirror(false), PartPose.offset(4.5F, 16F, 10F));

		partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(36, 48).addBox(-3F, 1F, -2.5F, 5F, 7F, 5F, CubeDeformation.NONE), PartPose.offset(-3.5F, 16F, -8F));

		partdefinition.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(36, 48).mirror().addBox(-2F, 1F, -2.5F, 5F, 7F, 5F, CubeDeformation.NONE).mirror(false), PartPose.offset(3.5F, 16F, -8F));
		
		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	@Override public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		head.xRot = headPitch * Mth.DEG_TO_RAD;
		head.yRot = netHeadYaw * Mth.DEG_TO_RAD;
		leg1.xRot = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
		leg4.xRot = leg1.xRot;
        leg2.xRot = leg3.xRot = -leg1.xRot;
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}