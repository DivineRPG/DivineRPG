package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.mortum.EntityAngryGlinthop;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelAngryGlinthop extends EntityModel<EntityAngryGlinthop> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("angry_glinthop");
	public final ModelPart Spine, Body, Skull, RightWhisker, LeftWhisker, RightEar, LeftEar, Tail, BackRightLeg, BackLeftLeg, FrontRightLeg, FrontLeftLeg;
	public ModelAngryGlinthop(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		Spine = root.getChild("Spine");
		Body = Spine.getChild("Body");
		Skull = Body.getChild("Skull");
		RightWhisker = Skull.getChild("RightWhisker");
		LeftWhisker = Skull.getChild("LeftWhisker");
		RightEar = Skull.getChild("RightEar");
		LeftEar = Skull.getChild("LeftEar");
		Tail = Body.getChild("Tail");
		BackRightLeg = root.getChild("BackRightLeg");
		BackLeftLeg = root.getChild("BackLeftLeg");
		FrontRightLeg = root.getChild("FrontRightLeg");
		FrontLeftLeg = root.getChild("FrontLeftLeg");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		PartDefinition Spine = partdefinition.addOrReplaceChild("Spine", CubeListBuilder.create(), PartPose.offset(0, 24, 0));
		PartDefinition Body = Spine.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(46, 28).addBox(-11, -29, -5, 22, 21, 0, cubeDef)
		.texOffs(0, 0).addBox(-5, -23, -8, 10, 11, 17, cubeDef)
		.texOffs(0, 28).addBox(-7, -25, -12, 14, 15, 9, cubeDef), PartPose.ZERO);
		PartDefinition Skull = Body.addOrReplaceChild("Skull", CubeListBuilder.create().texOffs(0, 33).addBox(-1, -2, -9, 2, 2, 2, cubeDef)
		.texOffs(38, 49).addBox(-5, -8, -8, 10, 12, 8, cubeDef), PartPose.offset(0, -18, -11.99F));
		Skull.addOrReplaceChild("RightWhisker", CubeListBuilder.create().texOffs(54, 18).addBox(-8.5F, -4.5F, 0, 9, 9, 0, cubeDef), PartPose.offset(-5.5F, -.5F, -7));
		Skull.addOrReplaceChild("LeftWhisker", CubeListBuilder.create().texOffs(71, 0).addBox(-.5F, -4.5F, 0, 9, 9, 0, cubeDef), PartPose.offset(5.5F, -.5F, -7));
		Skull.addOrReplaceChild("RightEar", CubeListBuilder.create().texOffs(24, 52).addBox(-2.5F, -5.5F, -.5F, 4, 5, 2, cubeDef)
		.texOffs(0, 28).addBox(-3.5F, -7.5F, 1.5F, 4, 5, 0, cubeDef), PartPose.offset(-2.5F, -7.5F, -1.51F));
		Skull.addOrReplaceChild("LeftEar", CubeListBuilder.create().texOffs(37, 28).addBox(-.5F, -7.5F, 1.5F, 4, 5, 0, cubeDef)
		.texOffs(66, 49).addBox(-1.5F, -5.5F, -.5F, 4, 5, 2, cubeDef), PartPose.offset(2.5F, -7.5F, -1.51F));
		Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(68, 63).addBox(-3, -9.75F, .5F, 6, 10, 6, cubeDef)
		.texOffs(0, 40).addBox(0, -12.75F, -1.5F, 0, 15, 12, cubeDef), PartPose.offset(0, -19.25F, 8.49F));
		partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(41, 69).addBox(-3, 5, 0, 4, 9, 4, cubeDef)
		.texOffs(54, 0).addBox(-3, -4, -5, 4, 9, 9, cubeDef), PartPose.offset(-3, 10, 6));
		partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(0, 74).addBox(-1, 5, 0, 4, 9, 4, cubeDef)
		.texOffs(15, 60).addBox(-1, -4, -5, 4, 9, 9, cubeDef), PartPose.offset(3, 10, 6));
		partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-2, 0, -2, 4, 10, 4, cubeDef), PartPose.offset(-4.9F, 13.99F, -8.7F));
		partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(37, 0).addBox(-2, 0, -2, 4, 10, 4, cubeDef), PartPose.offset(4.9F, 13.99F, -8.7F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	@Override public void setupAnim(EntityAngryGlinthop entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		Skull.yRot = netHeadYaw * Mth.DEG_TO_RAD;
		Skull.xRot = headPitch * Mth.DEG_TO_RAD;
		float f = Mth.TWO_PI + Mth.cos(ageInTicks * .05F + limbSwing * .1F) * .05F + limbSwingAmount * .3F;
		LeftWhisker.yRot = RightEar.zRot = -f;
		RightWhisker.yRot = LeftEar.zRot = f;
		float f1 = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
		float f2 = Mth.cos(limbSwing * .6662F + Mth.PI) * 1.4F * limbSwingAmount;
		Body.zRot = f1 * .05F;
		BackRightLeg.xRot = FrontLeftLeg.xRot = f1;
		BackLeftLeg.xRot = FrontRightLeg.xRot = f2;
		Tail.yRot = f1 * .2F;
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Spine.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}