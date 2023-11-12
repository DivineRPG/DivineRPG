package divinerpg.client.models.iceika;

import static divinerpg.util.ClientUtils.createLocation;

import com.mojang.blaze3d.vertex.*;

import divinerpg.entities.iceika.EntityMamoth;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.util.Mth;

public class ModelMamoth extends EntityModel<EntityMamoth> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("mamoth");
	final ModelPart head, body, frontLeftLeg, frontRightLeg, backLeftLeg, backRightLeg, rightEar, leftEar;
	public ModelMamoth(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		head = root.getChild("Head");
		rightEar = head.getChild("RightEar");
		leftEar = head.getChild("LeftEar");
		body = root.getChild("Body");
		frontRightLeg = body.getChild("FrontRightLeg");
		frontLeftLeg = body.getChild("FrontLeftLeg");
		ModelPart hip = body.getChild("Hip");
		backRightLeg = hip.getChild("BackRightLeg");
		backLeftLeg = hip.getChild("BackLeftLeg");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 58).addBox(-4.0F, -3.0F, -10.0F, 8.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, -14.0F));

		PartDefinition LeftEar = Head.addOrReplaceChild("LeftEar", CubeListBuilder.create(), PartPose.offset(3.0F, -2.0F, -4.0F));

		LeftEar.addOrReplaceChild("BottomLeftEar", CubeListBuilder.create().texOffs(82, 69).addBox(-0.5F, 0.0F, 0.0F, 13.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -1.0F, 0.0F, -0.0349F, -0.1222F, 0.2618F));

		LeftEar.addOrReplaceChild("TopLeftEar", CubeListBuilder.create().texOffs(72, 43).addBox(0.0F, -12.5F, 0.0F, 16.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -1.0F, -0.0438F, -0.1745F, 0.0038F));

		PartDefinition RightEar = Head.addOrReplaceChild("RightEar", CubeListBuilder.create(), PartPose.offset(-3.0F, -2.0F, -4.0F));

		RightEar.addOrReplaceChild("BottomRightEar", CubeListBuilder.create().texOffs(80, 19).addBox(-11.5F, 0.0F, 0.0F, 13.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -1.0F, 0.0F, -0.0349F, 0.1222F, -0.2618F));

		RightEar.addOrReplaceChild("TopRightEar", CubeListBuilder.create().texOffs(81, 56).addBox(-16.0F, -12.5F, 0.0F, 16.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -1.0F, 0.0F, 0.1745F, 0.0F));

		Head.addOrReplaceChild("Trunk", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -9.0F));

		Head.addOrReplaceChild("LeftMandible", CubeListBuilder.create().texOffs(91, 79).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 3.0F, -9.0F, -0.2618F, 0.0F, -0.3927F));

		Head.addOrReplaceChild("RightMandible", CubeListBuilder.create().texOffs(89, 29).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 3.0F, -9.0F, -0.2618F, 0.0F, 0.3927F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, -12.0F));

		Body.addOrReplaceChild("chest_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -10.0F, -8.5F, 16.0F, 14.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 6.5F, 0.3491F, 0.0F, 0.0F));

		Body.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(45, 49).addBox(-5.0F, -1.0F, -5.0F, 9.0F, 14.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.3054F));

		Body.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(53, 20).addBox(-4.0F, 0.0F, -5.0F, 9.0F, 14.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 3.0F, 3.0F, 0.0F, 0.0F, -0.3054F));

		PartDefinition Hip = Body.addOrReplaceChild("Hip", CubeListBuilder.create().texOffs(0, 29).addBox(-6.0F, -6.0F, -1.5F, 12.0F, 14.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 9.5F, 0.0F, 0.0F, 0.0F));

		Hip.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(27, 72).addBox(-5.0F, 0.0F, -4.5F, 7.0F, 14.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 7.0F, 6.0F, 0.0F, 0.0F, 0.3927F));

		Hip.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(59, 72).addBox(-2.0F, 0.0F, -4.5F, 7.0F, 14.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 7.0F, 6.0F, 0.0F, 0.0F, -0.3927F));

		Hip.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(62, 0).addBox(-3.5F, -7.0F, 0.0F, 7.0F, 10.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(0, 78).addBox(-2.5F, -6.0F, 6.0F, 5.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 12.5F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	@Override
	public void setupAnim(EntityMamoth entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if(entity.onGround() || entity.isInWater() || !entity.isBaby()) {
			head.yRot = netHeadYaw * ((float)Math.PI / 180F);
			head.xRot = headPitch * ((float)Math.PI / 180F);
			frontLeftLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.3F * limbSwingAmount;
			backLeftLeg.xRot = -Mth.cos(limbSwing * 0.6662F) * 1.3F * limbSwingAmount;
			frontRightLeg.xRot = -Mth.cos(limbSwing * 0.6662F) * 1.3F * limbSwingAmount;
			backRightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.3F * limbSwingAmount;
			body.zRot = Mth.sin(limbSwing * .3331F) * .2F * limbSwingAmount;
			rightEar.xRot = leftEar.xRot = body.xRot = 0F;
			leftEar.zRot = rightEar.zRot = 0F;
		} else {
			body.xRot = (float)Math.PI / -2F;
			rightEar.xRot = leftEar.xRot = frontLeftLeg.xRot = backLeftLeg.xRot = frontRightLeg.xRot = backRightLeg.xRot = -body.xRot;
			head.yRot = head.xRot = 0F;
			rightEar.zRot = Mth.sin(ageInTicks) * .5F;
			leftEar.zRot = -rightEar.zRot;
		}
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}