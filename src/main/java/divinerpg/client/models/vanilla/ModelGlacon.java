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
	public final ModelPart Spine, Body, RightSail, LeftSail, RightSmallSail, LeftSmallSail, Head, RightWhisker, LeftWhisker, RightFrontLeg, RightMiddleLeg, RightRearLeg, LeftFrontLeg, LeftMiddleLeg, LeftRearLeg;
	public ModelGlacon(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		Spine = root.getChild("Spine");
		Body = Spine.getChild("Body");
		RightSail = Body.getChild("RightSail");
		LeftSail = Body.getChild("LeftSail");
		RightSmallSail = Body.getChild("RightSmallSail");
		LeftSmallSail = Body.getChild("LeftSmallSail");
		Head = Body.getChild("Head");
		RightWhisker = Head.getChild("RightWhisker");
		LeftWhisker = Head.getChild("LeftWhisker");
		RightFrontLeg = root.getChild("RightLegFront");
		RightMiddleLeg = root.getChild("RightLegMiddle");
		RightRearLeg = root.getChild("RightLegBack");
		LeftFrontLeg = root.getChild("LeftLegFront");
		LeftMiddleLeg = root.getChild("LeftLegMiddle");
		LeftRearLeg = root.getChild("LeftLegBack");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		PartDefinition Spine = partdefinition.addOrReplaceChild("Spine", CubeListBuilder.create(), PartPose.offset(0, 12, -1));
		PartDefinition Body = Spine.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 29).addBox(-6, -8, -8, 12, 9, 8, cubeDef)
		.texOffs(0, 73).addBox(-2, 1, -8, 4, 7, 2, cubeDef), PartPose.offset(0, 0, -3));
		Body.addOrReplaceChild("RightSmallSail", CubeListBuilder.create().texOffs(38, 0).addBox(0, -8, -1, 0, 8, 14, cubeDef)
		.texOffs(68, 0).addBox(-.01F, -8, -1, 0, 8, 14, cubeDef), PartPose.offset(-2, -8, -3));
		Body.addOrReplaceChild("LeftSmallSail", CubeListBuilder.create().texOffs(76, 15).addBox(0, -8, -1, 0, 8, 14, cubeDef)
		.texOffs(100, 15).addBox(.01F, -8, -1, 0, 8, 14, cubeDef), PartPose.offset(2, -8, -3));
		Body.addOrReplaceChild("RightSail", CubeListBuilder.create().texOffs(0, 78).addBox(0, -9, -2, 0, 10, 14, cubeDef)
		.texOffs(30, 78).addBox(.01F, -9, -2, 0, 10, 14, cubeDef), PartPose.offset(-6, -9, -6));
		Body.addOrReplaceChild("LeftSail", CubeListBuilder.create().texOffs(0, 68).addBox(0, -9, -2, 0, 10, 14, cubeDef)
		.texOffs(30, 68).addBox(-.01F, -9, -2, 0, 10, 14, cubeDef), PartPose.offset(6, -9, -6));
		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(47, 47).addBox(-3, -3.5F, -8.5F, 6, 7, 9, cubeDef), PartPose.offset(0, -5.5F, -8.49F));
		Head.addOrReplaceChild("RightWhisker", CubeListBuilder.create().texOffs(0, 16).addBox(-4.5F, -2.5F, 0, 5, 5, 0, cubeDef)
		.texOffs(38, 0).addBox(-4.5F, -2.5F, -.01F, 5, 5, 0, cubeDef), PartPose.offset(-3.5F, 2, -7.5F));
		Head.addOrReplaceChild("LeftWhisker", CubeListBuilder.create().texOffs(10, 16).addBox(-.5F, -2.5F, 0, 5, 5, 0, cubeDef)
		.texOffs(48, 0).addBox(-.5F, -2.5F, -.01F, 5, 5, 0, cubeDef), PartPose.offset(3.5F, 2, -7.5F));
		Spine.addOrReplaceChild("Hip", CubeListBuilder.create().texOffs(0, 0).addBox(-4, -3.5F, -3, 8, 7, 22, cubeDef), PartPose.offset(0, -3.5F, -3));
		partdefinition.addOrReplaceChild("RightLegFront", CubeListBuilder.create().texOffs(60, 22).addBox(-2, -.5F, -2, 4, 11, 4, cubeDef), PartPose.offset(-5, 12.49F, -5));
		partdefinition.addOrReplaceChild("RightLegMiddle", CubeListBuilder.create().texOffs(32, 59).addBox(-2, 0, -2, 4, 12, 4, cubeDef), PartPose.offset(-4, 11.99F, 3));
		partdefinition.addOrReplaceChild("RightLegBack", CubeListBuilder.create().texOffs(0, 0).addBox(-2, 0, -2, 4, 12, 4, cubeDef), PartPose.offset(-4, 11.99F, 9));
		partdefinition.addOrReplaceChild("LeftLegFront", CubeListBuilder.create().texOffs(48, 63).addBox(-2, -.5F, -2, 4, 11, 4, cubeDef), PartPose.offset(5, 12.49F, -5));
		partdefinition.addOrReplaceChild("LeftLegMiddle", CubeListBuilder.create().texOffs(0, 56).addBox(-2, 0, -2, 4, 12, 4, cubeDef), PartPose.offset(4, 11.99F, 3));
		partdefinition.addOrReplaceChild("LeftLegBack", CubeListBuilder.create().texOffs(16, 56).addBox(-2, 0, -2, 4, 12, 4, cubeDef), PartPose.offset(4, 11.99F, 9));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	@Override public void setupAnim(EntityGlacon entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		Head.xRot = headPitch * Mth.DEG_TO_RAD;
		Head.yRot = netHeadYaw * Mth.DEG_TO_RAD;
		float f = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
		float f1 = Mth.cos(limbSwing * .6662F + Mth.PI) * 1.4F * limbSwingAmount;
		float f2 = Mth.PI / 16 + Mth.cos(ageInTicks * .05F + limbSwing * .2F) * .08F + limbSwingAmount * .2F;
		Spine.zRot = f * .02F;
		RightWhisker.yRot = LeftSail.yRot = LeftSmallSail.yRot = f2;
		LeftWhisker.yRot = RightSail.yRot = RightSmallSail.yRot = -f2;
		RightFrontLeg.xRot = LeftMiddleLeg.xRot = LeftRearLeg.xRot = f1;
		LeftFrontLeg.xRot = RightMiddleLeg.xRot = RightRearLeg.xRot = f;
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Spine.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightFrontLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightMiddleLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightRearLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftFrontLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftMiddleLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftRearLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}