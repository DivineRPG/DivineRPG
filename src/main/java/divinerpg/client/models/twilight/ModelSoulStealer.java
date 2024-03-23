package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.mortum.EntitySoulStealer;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelSoulStealer extends EntityModel<EntitySoulStealer> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("soul_stealer");
	public final ModelPart Body, Head, RightEar, LeftEar, RightArm, LeftArm, RightLeg, LeftLeg;
	public ModelSoulStealer(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		Body = root.getChild("Body");
		Head = Body.getChild("Head");
		RightEar = Head.getChild("RightEar");
		LeftEar = Head.getChild("LeftEar");
		RightArm = Body.getChild("RightArm");
		LeftArm = Body.getChild("LeftArm");
		RightLeg = root.getChild("RightLeg");
		LeftLeg = root.getChild("LeftLeg");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-11, -18, -4, 22, 18, 11, cubeDef), PartPose.offset(0, 14, 0));
		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 29).addBox(-7, -6, -4, 14, 6, 8, cubeDef), PartPose.offset(0, -18, 0));
		PartDefinition RightEar = Head.addOrReplaceChild("RightEar", CubeListBuilder.create(), PartPose.offset(-6, -4, 1));
		RightEar.addOrReplaceChild("rightear_r1", CubeListBuilder.create().texOffs(68, 41).addBox(-10, -10, 0, 10, 12, 0, cubeDef), PartPose.rotation(-.1309F, .5672F, 0));
		PartDefinition LeftEar = Head.addOrReplaceChild("LeftEar", CubeListBuilder.create(), PartPose.offset(6, -4, 1));
		LeftEar.addOrReplaceChild("leftear_r1", CubeListBuilder.create().texOffs(60, 29).addBox(0, -10, 0, 10, 12, 0, cubeDef), PartPose.rotation(-.1309F, -.5672F, 0));
		Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(66, 0).addBox(-5, -1, -3, 5, 16, 6, cubeDef), PartPose.offset(-11, -17, 0));
		Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 61).addBox(0, -1, -3, 5, 16, 6, cubeDef), PartPose.offset(11, -17, 0));
		partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 43).addBox(-4, 0, -4, 8, 10, 8, cubeDef), PartPose.offset(-7, 14, 0));
		partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(36, 35).addBox(-4, 0, -4, 8, 10, 8, cubeDef), PartPose.offset(7, 14, 0));
		Body.addOrReplaceChild("RightRibs", CubeListBuilder.create().texOffs(60, 53).addBox(0, -9, -3, 11, 18, 3, cubeDef), PartPose.offset(-11, -9, -4));
		Body.addOrReplaceChild("LeftRibs", CubeListBuilder.create().texOffs(32, 53).addBox(-11, -9, -3, 11, 18, 3, cubeDef), PartPose.offset(11, -9, -4));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	@Override public void setupAnim(EntitySoulStealer entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		Head.yRot = netHeadYaw * Mth.DEG_TO_RAD;
		Head.xRot = headPitch * Mth.DEG_TO_RAD;
		RightEar.yRot = -Mth.PI / 16 - Mth.cos(ageInTicks * .1F + limbSwing * .6F) * .08F + limbSwingAmount * .2F;
		LeftEar.yRot = Mth.PI / 16 + Mth.cos(ageInTicks * .1F + limbSwing * .5F) * .08F + limbSwingAmount * .2F;
		RightArm.yRot = LeftArm.yRot = RightArm.zRot = LeftArm.zRot = 0;
		AnimationUtils.bobModelPart(RightArm, ageInTicks, 1);
		AnimationUtils.bobModelPart(LeftArm, ageInTicks, -1);
		float f = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
		float f1 = Mth.cos(limbSwing * .6662F + Mth.PI) * 1.4F * limbSwingAmount;
		Body.zRot = f * .1F;
		RightLeg.xRot = f;
		LeftLeg.xRot = f1;
	}
	@Override public void prepareMobModel(EntitySoulStealer entity, float limbSwing, float limbSwingAmount, float ageInTicks) {
		super.prepareMobModel(entity, limbSwing, limbSwingAmount, ageInTicks);
		int i = entity.getAttackAnimationTick();
		if(i > 0) RightArm.xRot = LeftArm.xRot = -1 + 1.5F * Mth.triangleWave(i - ageInTicks, 10);
		else {
			RightArm.xRot = Mth.cos(limbSwing * .6662F + Mth.PI) * limbSwingAmount;
			LeftArm.xRot = Mth.cos(limbSwing * .6662F) * limbSwingAmount;
		}
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}