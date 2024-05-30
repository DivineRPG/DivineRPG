package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.eden.EntityMadivel;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelMadivel extends EntityModel<EntityMadivel> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("madivel");
	public final ModelPart body, edenSpirit, leftSun, rightSun, rightLeg, leftLeg, rightArm, leftArm;
	public ModelMadivel(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		body = root.getChild("body");
		edenSpirit = root.getChild("eden_spirit");
		leftSun = edenSpirit.getChild("left_sun");
		rightSun = edenSpirit.getChild("right_sun");
		rightLeg = body.getChild("right_leg");
		leftLeg = body.getChild("left_leg");
		rightArm = body.getChild("right_arm");
		leftArm = body.getChild("left_arm");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-9, -20, -8, 18, 19, 18, cubeDef)
		.texOffs(54, 0).addBox(-5.5F, -1, -5, 11, 5, 12, cubeDef)
		.texOffs(0, 37).addBox(-9, -27, -6, 18, 7, 14, cubeDef)
		.texOffs(72, 17).addBox(-5, -26, -4, 10, 10, 9, cubeDef), PartPose.offset(0, 2, 0));
		body.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(137, 0).addBox(-5, 1, -3, 4, 21, 7, cubeDef), PartPose.offset(-4, 0, 0));
		body.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(88, 36).addBox(1, 1, -3, 4, 21, 7, cubeDef), PartPose.offset(4, 0, 0));
		body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(100, 97).addBox(0, -2, -4, 8, 8, 8, cubeDef)
		.texOffs(26, 88).addBox(1, 6, -3, 6, 20, 6, cubeDef), PartPose.offset(9, -16, 2));
		body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(100, 0).addBox(-8, -2, -4, 8, 8, 8, cubeDef)
		.texOffs(84, 79).addBox(-7, 6, -3, 6, 20, 6, cubeDef), PartPose.offset(-9, -16, 2));
		PartDefinition edenSpirit = partdefinition.addOrReplaceChild("eden_spirit", CubeListBuilder.create().texOffs(54, 0).addBox(-1.5F, -5, -2.25F, 3, 5, 2, cubeDef)
		.texOffs(0, 37).addBox(-1.5F, -8, -.25F, 3, 5, 3, cubeDef), PartPose.offset(0, -28, 2.25F));
		edenSpirit.addOrReplaceChild("eden_spirit_head", CubeListBuilder.create().texOffs(0, 103).addBox(-2.5F, -5.25F, -4, 5, 5, 4, cubeDef)
		.texOffs(24, 58).addBox(-4, -7.25F, -2, 8, 8, 0, cubeDef), PartPose.offset(0, -7.75F, .75F));
		edenSpirit.addOrReplaceChild("left_sun", CubeListBuilder.create().texOffs(0, 0).addBox(7.5F, -4.5F, .25F, 9, 9, 0, cubeDef)
		.texOffs(101, 16).addBox(9.5F, -2.5F, -2.75F, 5, 5, 5, cubeDef), PartPose.offset(0, -4.5F, 0));
		edenSpirit.addOrReplaceChild("right_sun", CubeListBuilder.create().texOffs(0, 9).addBox(-17.5F, -4.5F, .25F, 9, 9, 0, cubeDef)
		.texOffs(0, 93).addBox(-15.5F, -2.5F, -2.75F, 5, 5, 5, cubeDef), PartPose.offset(0, -4.5F, 0));
		return LayerDefinition.create(meshdefinition, 256, 256);
	}
	@Override public void setupAnim(EntityMadivel entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		edenSpirit.yRot = netHeadYaw * Mth.DEG_TO_RAD;
		edenSpirit.xRot = headPitch * Mth.DEG_TO_RAD;
		float orbitRadius = 2; //Adjust the orbit radius as needed
		float orbitSpeed = .1F; //Adjust the orbit speed as needed
		//Orbit calculation for Sun1
		float sun1OrbitAngle = ageInTicks * orbitSpeed;
		float sun1OffsetX = Mth.cos(sun1OrbitAngle) * orbitRadius;
		float sun1OffsetZ = Mth.sin(sun1OrbitAngle) * orbitRadius;
		leftSun.x = edenSpirit.x + sun1OffsetX + .5F;
		leftSun.z = edenSpirit.z + sun1OffsetZ - 4;
		//Orbit calculation for rightSun
		float rightSunOrbitAngle = ageInTicks * orbitSpeed * .8F; //Adjust the orbit angle and speed as desired
		float rightSunOffsetX = Mth.cos(rightSunOrbitAngle) * orbitRadius;
		float rightSunOffsetZ = Mth.sin(rightSunOrbitAngle) * orbitRadius;
		rightSun.x = edenSpirit.x + rightSunOffsetX + .5F;
		rightSun.z = edenSpirit.z + rightSunOffsetZ - 4;
		rightArm.yRot = leftArm.yRot = rightArm.zRot = leftArm.zRot = 0;
		AnimationUtils.bobModelPart(rightArm, ageInTicks, 1);
		AnimationUtils.bobModelPart(leftArm, ageInTicks, -1);
		float f = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
		float f1 = Mth.cos(limbSwing * .6662F + Mth.PI) * 1.4F * limbSwingAmount;
		body.zRot = f * .05F;
		rightLeg.xRot = f;
		leftLeg.xRot = f1;
	}
	@Override public void prepareMobModel(EntityMadivel entity, float limbSwing, float limbSwingAmount, float ageInTicks) {
		super.prepareMobModel(entity, limbSwing, limbSwingAmount, ageInTicks);
		float healthFraction = entity.getHealth() / entity.getMaxHealth();
		if(healthFraction < 1F / 3F) {
			leftSun.visible = false;
			rightSun.visible = false;
		} else if(healthFraction < 2F / 3F) {
			leftSun.visible = false;
			rightSun.visible = true;
		} else {
			leftSun.visible = true;
			rightSun.visible = true;
		} int i = entity.getAttackAnimationTick();
		if(i > 0) rightArm.xRot = leftArm.xRot = -1.5F + 1.5F * Mth.triangleWave(i - ageInTicks, 10);
		else {
			rightArm.xRot = Mth.cos(limbSwing * .6662F + Mth.PI) * limbSwingAmount;
			leftArm.xRot = Mth.cos(limbSwing * .6662F) * limbSwingAmount;
		}
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		edenSpirit.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}