package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.iceika.EntityGlacide;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelGlacide extends EntityModel<EntityGlacide> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("glacide");
	public final ModelPart Spine, RightSail, LeftSail, Head, FrontLeftLeg, FrontLeftLowerLeg, BackLeftLeg, BackLeftLowerLeg, FrontRightLeg, FrontRightLowerLeg, BackRightLeg, BackRightLowerLeg;
	public ModelGlacide(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		Spine = root.getChild("Spine");
		RightSail = Spine.getChild("RightSail");
		LeftSail = Spine.getChild("LeftSail");
		Head = Spine.getChild("Head");
		FrontLeftLeg = root.getChild("FrontLeftLeg");
		FrontLeftLowerLeg = FrontLeftLeg.getChild("FrontLeftLowerLeg");
		BackLeftLeg = root.getChild("BackLeftLeg");
		BackLeftLowerLeg = BackLeftLeg.getChild("BackLeftLowerLeg");
		FrontRightLeg = root.getChild("FrontRightLeg");
		FrontRightLowerLeg = FrontRightLeg.getChild("FrontRightLowerLeg");
		BackRightLeg = root.getChild("BackRightLeg");
		BackRightLowerLeg = BackRightLeg.getChild("BackRightLowerLeg");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		PartDefinition Spine = partdefinition.addOrReplaceChild("Spine", CubeListBuilder.create().texOffs(46, 35).addBox(-6, -6, -15, 12, 13, 10, cubeDef)
		.texOffs(48, 0).addBox(-6, -2, -5, 12, 11, 9, cubeDef)
		.texOffs(0, 0).addBox(-6, -6, 4, 12, 11, 24, cubeDef)
		.texOffs(90, 0).addBox(-8, 4, -4, 3, 9, 6, cubeDef)
		.texOffs(93, 61).addBox(5, 4, -3, 3, 9, 5, cubeDef), PartPose.offset(0, -1, 0));
		Spine.addOrReplaceChild("RightSail", CubeListBuilder.create().texOffs(0, 30).addBox(0, -18, -2, 0, 18, 23, cubeDef), PartPose.offset(-5, -6, -7));
		Spine.addOrReplaceChild("LeftSail", CubeListBuilder.create().texOffs(0, 12).addBox(0, -18, -2, 0, 18, 23, cubeDef), PartPose.offset(5, -6, -7));
		PartDefinition FrontLeftLeg = partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(90, 40).addBox(0, -5, -3, 3, 16, 5, cubeDef), PartPose.offset(5, 3, -11));
		FrontLeftLeg.addOrReplaceChild("FrontLeftLowerLeg", CubeListBuilder.create().texOffs(66, 79).addBox(-1, 0, -5, 5, 15, 5, cubeDef), PartPose.offset(0, 5.99F, -.99F));
		PartDefinition BackLeftLeg = partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(71, 58).addBox(0, -4, -3, 5, 15, 6, cubeDef), PartPose.offset(3, 3, 9));
		BackLeftLeg.addOrReplaceChild("BackLeftLowerLeg", CubeListBuilder.create().texOffs(46, 79).addBox(2, 0, 0, 4, 16, 6, cubeDef), PartPose.offset(.01F, 4.99F, .99F));
		PartDefinition FrontRightLeg = partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(86, 79).addBox(-3, -5, -3, 3, 16, 5, cubeDef), PartPose.offset(-5, 3, -11));
		FrontRightLeg.addOrReplaceChild("FrontRightLowerLeg", CubeListBuilder.create().texOffs(80, 20).addBox(-4, 0, -5, 5, 15, 5, cubeDef), PartPose.offset(0, 5.99F, -.99F));
		PartDefinition BackRightLeg = partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-5, -4, -3, 5, 15, 6, cubeDef), PartPose.offset(-3, 3, 9));
		BackRightLeg.addOrReplaceChild("BackRightLowerLeg", CubeListBuilder.create().texOffs(26, 79).addBox(-6, 0, 0, 4, 16, 6, cubeDef), PartPose.offset(.01F, 4.99F, .99F));
		Spine.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 71).addBox(-4, -19, -5, 8, 23, 5, cubeDef), PartPose.offset(0, 4, -14));
		Spine.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-5, -4, -12, 2, 3, 0, cubeDef)
		.texOffs(0, 107).addBox(3, -4, -12, 2, 3, 0, cubeDef)
		.texOffs(33, 58).addBox(-3, -4, -12, 6, 8, 13, cubeDef)
		.texOffs(106, 110).addBox(3, -11, -2, 0, 7, 11, cubeDef)
		.texOffs(106, 110).addBox(-3, -11, -2, 0, 7, 11, cubeDef), PartPose.offset(0, -15, -18));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	@Override public void setupAnim(EntityGlacide entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		Head.yRot = netHeadYaw * Mth.DEG_TO_RAD;
		Head.xRot = headPitch * Mth.DEG_TO_RAD;
		float f = Mth.cos(limbSwing * .6F) * .9F * limbSwingAmount;
		float f1 = Mth.cos(limbSwing * .6F + Mth.PI) * .9F * limbSwingAmount;
		float f2 = Mth.PI / 16 + Mth.cos(ageInTicks * .05F + limbSwing * .2F) * .08F + limbSwingAmount * .2F;
		Spine.zRot = f * .02F;
		RightSail.yRot = -f2;
		LeftSail.yRot = f2;
		FrontRightLeg.xRot = BackLeftLeg.xRot = f1;
		BackRightLeg.xRot = FrontLeftLeg.xRot = f;
		float lowLegMov = Mth.abs(Mth.cos(limbSwing * .5F)) * .7F * limbSwingAmount;
		float lowLegMov1 = Mth.abs(Mth.cos(limbSwing * .5F + Mth.PI)) * .7F * limbSwingAmount;
		FrontRightLowerLeg.xRot = BackLeftLowerLeg.xRot = lowLegMov;
		BackRightLowerLeg.xRot = FrontLeftLowerLeg.xRot = lowLegMov1;
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Spine.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}