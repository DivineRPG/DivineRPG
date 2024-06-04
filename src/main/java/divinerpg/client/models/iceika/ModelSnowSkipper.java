package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.iceika.EntitySnowSkipper;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelSnowSkipper extends EntityModel<EntitySnowSkipper> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("snow_skipper");
	public final ModelPart head, rightWhisker, leftWhisker, body, rightSail, leftSail, tail, rightFrontLeg, rightMiddleLeg, rightHindLeg, leftFrontLeg, leftMiddleLeg, leftHindLeg;;
	public ModelSnowSkipper(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		head = root.getChild("head");
		rightWhisker = head.getChild("right_whisker");
		leftWhisker = head.getChild("left_whisker");
		body = root.getChild("body");
		rightSail = body.getChild("right_sail");
		leftSail = body.getChild("left_sail");
		tail = body.getChild("tail");
		rightFrontLeg = body.getChild("right_front_leg");
		rightMiddleLeg = body.getChild("right_middle_leg");
		rightHindLeg = body.getChild("right_hind_leg");
		leftFrontLeg = body.getChild("left_front_leg");
		leftMiddleLeg = body.getChild("left_middle_leg");
		leftHindLeg = body.getChild("left_hind_leg");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		PartDefinition Head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(12, 9).addBox(-1, -1.5F, -4, 2, 3, 4, cubeDef), PartPose.offset(0, 19, -2));
		Head.addOrReplaceChild("left_whisker", CubeListBuilder.create().texOffs(0, 4).addBox(0, -1, 0, 2, 1, 0, cubeDef), PartPose.offsetAndRotation(1, -1, -4, 0, 0, -.2182F));
		Head.addOrReplaceChild("right_whisker", CubeListBuilder.create().texOffs(0, 3).addBox(-2, -1, 0, 2, 1, 0, cubeDef), PartPose.offsetAndRotation(-1, -1, -4, 0, 0, .2182F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2, -1, 0, 4, 4, 5, cubeDef)
		.texOffs(13, 0).addBox(0, -3, 3.3F, 0, 2, 3, cubeDef), PartPose.offset(0, 19, -3));
		body.addOrReplaceChild("left_sail", CubeListBuilder.create().texOffs(8, 6).addBox(0, -3.5F, -.5F, 0, 3, 3, cubeDef), PartPose.offsetAndRotation(1.5F, -.5F, .8F, 0, 0, .3054F));
		body.addOrReplaceChild("right_sail", CubeListBuilder.create().texOffs(8, 6).addBox(0, -3.5F, -.5F, 0, 3, 3, cubeDef), PartPose.offsetAndRotation(-1.5F, -.5F, .8F, 0, 0, -.3054F));
		body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 9).addBox(-1, -2, 0, 2, 4, 4, cubeDef), PartPose.offset(0, 1, 5));
		body.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(13, 0).addBox(-1, 0, -.5F, 1, 2, 1, cubeDef), PartPose.offset(-1, 3, .5F));
		body.addOrReplaceChild("right_middle_leg", CubeListBuilder.create().texOffs(0, 9).addBox(-1, 0, -.5F, 1, 2, 1, cubeDef), PartPose.offset(-1, 3, 2.5F));
		body.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-1, 0, -.5F, 1, 2, 1, cubeDef), PartPose.offset(-1, 3, 4.5F));
		body.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(0, 17).addBox(0, 0, -.5F, 1, 2, 1, cubeDef), PartPose.offset(1, 3, .5F));
		body.addOrReplaceChild("left_middle_leg", CubeListBuilder.create().texOffs(11, 16).addBox(0, 0, -.5F, 1, 2, 1, cubeDef), PartPose.offset(1, 3, 2.5F));
		body.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(15, 16).addBox(0, 0, -.5F, 1, 2, 1, cubeDef), PartPose.offset(1, 3, 4.5F));
		return LayerDefinition.create(meshdefinition, 24, 24);
	}
	@Override public void setupAnim(EntitySnowSkipper entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		head.xRot = headPitch * Mth.DEG_TO_RAD / 2;
		head.yRot = netHeadYaw * Mth.DEG_TO_RAD / 2;
		float f = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
		float f1 = Mth.cos(limbSwing * .6662F + Mth.PI) * 1.4F * limbSwingAmount;
		float f2 = Mth.PI / 16 + Mth.cos(ageInTicks * .05F + limbSwing * .2F) * .08F + limbSwingAmount * .2F;
		rightWhisker.yRot = f2 + .6981F;
		leftWhisker.yRot = -f2 - .6981F;
		body.zRot = f * .02F;
		rightSail.yRot = -f2;
		leftSail.yRot = f2;
		tail.yRot = f * .2F;
		rightFrontLeg.xRot = leftMiddleLeg.xRot = leftHindLeg.xRot = f1;
		leftFrontLeg.xRot = rightMiddleLeg.xRot = rightHindLeg.xRot = f;
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}