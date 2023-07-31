package divinerpg.client.models.vanilla;


import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntityGlacon;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelGlacon extends EntityModel<EntityGlacon> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("glacon");
	private final ModelPart Spine, Head, RightFrontLeg, RightMiddleLeg, RightRearLeg, LeftFrontLeg, LeftMiddleLeg, LeftRearLeg;

	public ModelGlacon(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Spine = root.getChild("Spine");
		this.Head = root.getChild("Head");
		this.RightFrontLeg = root.getChild("RightLegFront");
		this.RightMiddleLeg = root.getChild("RightLegMiddle");
		this.RightRearLeg = root.getChild("RightLegBack");
		this.LeftFrontLeg = root.getChild("LeftLegFront");
		this.LeftMiddleLeg = root.getChild("LeftLegMiddle");
		this.LeftRearLeg = root.getChild("LeftLegBack");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Spine = partdefinition.addOrReplaceChild("Spine", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, -1.0F));

		Spine.addOrReplaceChild("Hip", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -3.5F, -3.0F, 8.0F, 7.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.5F, -3.0F));

		partdefinition.addOrReplaceChild("RightLegBack", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 12.0F, 9.0F));

		partdefinition.addOrReplaceChild("LeftLegBack", CubeListBuilder.create().texOffs(16, 56).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 12.0F, 9.0F));

		partdefinition.addOrReplaceChild("LeftLegMiddle", CubeListBuilder.create().texOffs(0, 56).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 12.0F, 3.0F));

		partdefinition.addOrReplaceChild("RightLegMiddle", CubeListBuilder.create().texOffs(32, 59).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 12.0F, 3.0F));

		PartDefinition Body = Spine.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 29).addBox(-6.0F, -8.0F, -8.0F, 12.0F, 9.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 73).addBox(-2.0F, 1.0F, -8.0F, 4.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		Body.addOrReplaceChild("LeftSmallSail", CubeListBuilder.create().texOffs(76, 15).addBox(0.0F, -8.0F, -1.0F, 0.0F, 8.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(100, 15).addBox(0.01F, -8.0F, -1.0F, 0.0F, 8.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -8.0F, -3.0F));

		Body.addOrReplaceChild("RightSmallSail", CubeListBuilder.create().texOffs(38, 0).addBox(0.0F, -8.0F, -1.0F, 0.0F, 8.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(68, 0).addBox(-0.01F, -8.0F, -1.0F, 0.0F, 8.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -8.0F, -3.0F));

		Body.addOrReplaceChild("RightSail", CubeListBuilder.create().texOffs(0, 78).addBox(0.0F, -9.0F, -2.0F, 0.0F, 10.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(30, 78).addBox(0.01F, -9.0F, -2.0F, 0.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -9.0F, -6.0F));

		Body.addOrReplaceChild("LeftSail", CubeListBuilder.create().texOffs(0, 68).addBox(0.0F, -9.0F, -2.0F, 0.0F, 10.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(30, 68).addBox(-0.01F, -9.0F, -2.0F, 0.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -9.0F, -6.0F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(47, 47).addBox(-3.0F, -3.5F, -8.5F, 6.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.5F, -12.5F));

		Head.addOrReplaceChild("RightWhisker", CubeListBuilder.create().texOffs(0, 16).addBox(-4.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(38, 0).addBox(-4.5F, -2.5F, -0.01F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 2.0F, -7.5F));

		Head.addOrReplaceChild("LeftWhisker", CubeListBuilder.create().texOffs(10, 16).addBox(-0.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(48, 0).addBox(-0.5F, -2.5F, -0.01F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 2.0F, -7.5F));

		partdefinition.addOrReplaceChild("LeftLegFront", CubeListBuilder.create().texOffs(48, 63).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 12.5F, -5.0F));

		partdefinition.addOrReplaceChild("RightLegFront", CubeListBuilder.create().texOffs(60, 22).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 12.5F, -5.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(EntityGlacon entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.xRot = headPitch * ((float)Math.PI / 180F);
		this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);

		this.RightFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.RightRearLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.RightMiddleLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + 0.000001) * 1.4F * limbSwingAmount);

		this.LeftFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.LeftMiddleLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + 3.141594F) * 1.4F * limbSwingAmount);
		this.LeftRearLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Spine.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightFrontLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightMiddleLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightRearLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftFrontLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftMiddleLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftRearLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}