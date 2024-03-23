package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.iceika.EntityHastreus;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelHastreus extends EntityModel<EntityHastreus> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("hastreus");
	private final ModelPart Body, Tail, Head, Jaw, FrontRightLeg, BackRightLeg, FrontLeftLeg, BackLeftLeg;
	public ModelHastreus(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		Body = root.getChild("Body");
		Tail = Body.getChild("Tail");
		Head = Body.getChild("Head");
		Jaw = Head.getChild("Jaw");
		FrontRightLeg = root.getChild("FrontRightLeg");
		BackRightLeg = root.getChild("BackRightLeg");
		FrontLeftLeg = root.getChild("FrontLeftLeg");
		BackLeftLeg = root.getChild("BackLeftLeg");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0, 10, -10));
		PartDefinition BackRightSpine = Body.addOrReplaceChild("BackRightSpine", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.5F, -9, 6, -.5236F, 0, 0));
		BackRightSpine.addOrReplaceChild("backrightspine_r1", CubeListBuilder.create().texOffs(48, 84).addBox(-2.5F, -10, -1, 5, 10, 2, cubeDef), PartPose.offsetAndRotation(0, -1, 0, -.2618F, 0, -.2618F));
		PartDefinition BackLeftSpine = Body.addOrReplaceChild("BackLeftSpine", CubeListBuilder.create(), PartPose.offsetAndRotation(7.5F, -9, 6, -.5236F, 0, 0));
		BackLeftSpine.addOrReplaceChild("backleftspine_r1", CubeListBuilder.create().texOffs(86, 24).addBox(-2.5F, -10, -1, 5, 10, 2, cubeDef), PartPose.offsetAndRotation(0, -1, 0, -.2618F, 0, .2618F));
		PartDefinition MiddleRightSpine = Body.addOrReplaceChild("MiddleRightSpine", CubeListBuilder.create(), PartPose.offsetAndRotation(-3, -10, 4, -.48F, 0, 0));
		MiddleRightSpine.addOrReplaceChild("middlerightspine_r1", CubeListBuilder.create().texOffs(65, 83).addBox(-2, -12, -4.5F, 5, 12, 3, cubeDef), PartPose.offsetAndRotation(-.5F, 0, 2.5F, -.1309F, 0, -.1745F));
		PartDefinition MiddleLeftSpine = Body.addOrReplaceChild("MiddleLeftSpine", CubeListBuilder.create(), PartPose.offsetAndRotation(3, -10, 4, -.48F, 0, 0));
		MiddleLeftSpine.addOrReplaceChild("middleleftspine_r1", CubeListBuilder.create().texOffs(81, 83).addBox(-3, -12, -4.5F, 5, 12, 3, cubeDef), PartPose.offsetAndRotation(.5F, 0, 2.5F, -.1309F, 0, .1745F));
		PartDefinition CenterSpine = Body.addOrReplaceChild("CenterSpine", CubeListBuilder.create(), PartPose.offsetAndRotation(0, -10, -1, -.3927F, 0, 0));
		CenterSpine.addOrReplaceChild("centerspine_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2, -17, -1.5F, 5, 17, 3, cubeDef), PartPose.offsetAndRotation(-.5F, 0, .5F, -.1309F, 0, 0));
		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offset(0, -7, 24));
		Tail.addOrReplaceChild("tailtip_r1", CubeListBuilder.create().texOffs(72, 37).addBox(-2, -8.5F, -3.5F, 4, 7, 9, cubeDef), PartPose.offsetAndRotation(0, 1.5F, 9.5F, .2182F, 0, 0));
		Tail.addOrReplaceChild("basetail_r1", CubeListBuilder.create().texOffs(0, 55).addBox(-4, -7.5F, -1, 8, 11, 10, cubeDef), PartPose.offsetAndRotation(0, 2.5F, -1, .2182F, 0, 0));
		Body.addOrReplaceChild("torso_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-13.5F, -12, -1, 18, 12, 25, cubeDef), PartPose.offsetAndRotation(4.5F, 2, .5F, .1309F, 0, 0));
		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(38, 37).addBox(-2, -2, -12, 4, 6, 2, cubeDef)
		.texOffs(0, 37).addBox(-7, -4, -10, 14, 8, 10, cubeDef), PartPose.offset(0, -4, 1));
		Head.addOrReplaceChild("headspike_r1", CubeListBuilder.create().texOffs(32, 84).addBox(-2, -7, -1.5F, 4, 8, 4, cubeDef), PartPose.offsetAndRotation(0, -3, -9, -.3491F, 0, 0));
		Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(38, 45).addBox(-6, 0, -7, 12, 4, 10, cubeDef), PartPose.offset(0, 4, -3));
		partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(68, 59).addBox(-8.5F, -2, -3.5F, 8, 16, 8, cubeDef), PartPose.offset(-5.5F, 10, -5.5F));
		partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(36, 59).addBox(-6.5F, -3, -3.5F, 8, 17, 8, cubeDef), PartPose.offset(-4.5F, 10, 9.5F));
		partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(0, 76).addBox(.5F, -2, -3.5F, 8, 16, 8, cubeDef), PartPose.offset(5.5F, 10, -5.5F));
		partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(61, 0).addBox(-1.5F, -2, -3.5F, 8, 16, 8, cubeDef), PartPose.offset(4.5F, 10, 9.5F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	@Override public void prepareMobModel(EntityHastreus entity, float p_103622_, float p_103623_, float p_103624_) {
		super.prepareMobModel(entity, p_103622_, p_103623_, p_103624_);
		int l = entity.getAttackTick();
		if(l > 0) {
			if(l > 5) {
				Jaw.xRot = Mth.sin((-4 + l - p_103624_) / 4) * Mth.PI * .4F;
			} else {
				Jaw.xRot = .1571F * Mth.sin(Mth.PI * (l - p_103624_) / 10);
			}
		} else Jaw.xRot = 0;
	}
	@Override public void setupAnim(EntityHastreus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		Head.yRot = netHeadYaw * Mth.DEG_TO_RAD;
		Head.xRot = headPitch * Mth.DEG_TO_RAD;
		float f = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
		float f1 = Mth.cos(limbSwing * .6662F + Mth.PI) * 1.4F * limbSwingAmount;
		Tail.yRot = f / 2;
		Body.zRot = f * .05F;
		FrontRightLeg.xRot = BackLeftLeg.xRot = f1;
		BackRightLeg.xRot = FrontLeftLeg.xRot = f;
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}