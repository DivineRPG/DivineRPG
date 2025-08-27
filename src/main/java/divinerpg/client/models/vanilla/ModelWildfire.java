package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.nether.EntityWildfire;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.BowItem;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelWildfire extends HumanoidModel<EntityWildfire> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("wildfire");
	public final ModelPart rightAntenna, leftAntenna, hip, thorax;
	public ModelWildfire(ModelPart part) {
		super(part);
		rightAntenna = head.getChild("right_antenna");
		leftAntenna = head.getChild("left_antenna");
		hip = body.getChild("hip");
		thorax = hip.getChild("thorax");
	}
	public static LayerDefinition createBodyLayer() {
		CubeDeformation cubeDef = CubeDeformation.NONE;
		MeshDefinition meshdefinition = HumanoidModel.createMesh(cubeDef, 0);
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartPose zPose = PartPose.ZERO;
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 25).addBox(-3, -4, -4, 6, 7, 6, cubeDef), PartPose.offset(0, 0, -1));
		PartDefinition rightAntenna = head.addOrReplaceChild("right_antenna", CubeListBuilder.create(), PartPose.offset(-2.5F, -3.99F, 1.5F));
		rightAntenna.addOrReplaceChild("right_antenna_rot", CubeListBuilder.create().texOffs(20, 43).addBox(-.5F, -4, -.5F, 1, 4, 1, cubeDef)
		.texOffs(36, 21).addBox(-.5F, -4, -2.5F, 1, 1, 2, cubeDef), PartPose.rotation(0, Mth.PI / 12, 0));
		PartDefinition leftAntenna = head.addOrReplaceChild("left_antenna", CubeListBuilder.create(), PartPose.offset(2.5F, -3.99F, 1.5F));
		leftAntenna.addOrReplaceChild("left_antenna_rot", CubeListBuilder.create().texOffs(20, 38).addBox(-.5F, -4, -.5F, 1, 4, 1, cubeDef)
		.texOffs(30, 21).addBox(-.5F, -4, -2.5F, 1, 1, 2, cubeDef), PartPose.rotation(0, -Mth.PI / 12, 0));
		head.addOrReplaceChild("right_mandible", CubeListBuilder.create().texOffs(46, 0).addBox(-.5F, -2.75F, -2, 2, 4, 3, cubeDef), PartPose.offset(-3, 2, -2.5F));
		head.addOrReplaceChild("left_mandible", CubeListBuilder.create().texOffs(36, 0).addBox(-1.5F, -2.75F, -2, 2, 4, 3, cubeDef), PartPose.offset(3, 2, -2.5F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 13).addBox(-5, -7, -3, 10, 7, 5, cubeDef), zPose);
		PartDefinition rightArm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), zPose);
		PartDefinition rightArmRot = rightArm.addOrReplaceChild("right_arm_rot", CubeListBuilder.create().texOffs(10, 38).addBox(-2, -3, -1.5F, 2, 14, 3, cubeDef), PartPose.rotation(0, 0, .1309F));
		rightArmRot.addOrReplaceChild("right_claw", CubeListBuilder.create().texOffs(36, 7).addBox(0, 0, -1.5F, 3, 2, 3, cubeDef), PartPose.offset(-2, 11, 0));
		PartDefinition leftArm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), zPose);
		PartDefinition leftArmRot = leftArm.addOrReplaceChild("left_arm_rot", CubeListBuilder.create().texOffs(0, 38).addBox(0, -3, -1.5F, 2, 14, 3, cubeDef), PartPose.rotation(0, 0, -.1309F));
		leftArmRot.addOrReplaceChild("left_claw", CubeListBuilder.create().texOffs(48, 7).addBox(-3, 0, -1.5F, 3, 2, 3, cubeDef), PartPose.offset(2, 11, 0));
		PartDefinition hip = body.addOrReplaceChild("hip", CubeListBuilder.create().texOffs(24, 25).addBox(-4, 0, -2, 8, 7, 4, cubeDef), zPose);
		PartDefinition thorax = hip.addOrReplaceChild("thorax", CubeListBuilder.create(), PartPose.offset(0, 5, 1));
		thorax.addOrReplaceChild("thorax_rot", CubeListBuilder.create().texOffs(30, 13).addBox(-4, -2, 8, 8, 4, 4, cubeDef)
		.texOffs(0, 0).addBox(-5, -3, 0, 10, 5, 8, cubeDef), PartPose.rotation(-.6109F, 0, 0));
		partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(24, 36).addBox(-2, 0, -1, 3, 12, 3, cubeDef), PartPose.offset(-2, 0, 0));
		partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(36, 36).addBox(-1, 0, -1, 3, 12, 3, cubeDef), PartPose.offset(2, 0, 0));
		return LayerDefinition.create(meshdefinition, 60, 55);
	}
	@Override public void prepareMobModel(EntityWildfire entity, float limbSwing, float limbSwingAmount, float ageInTicks) {
		rightArmPose = leftArmPose = HumanoidModel.ArmPose.EMPTY;
		if(entity.getMainHandItem().getItem() instanceof BowItem && entity.isAggressive()) {
			if(entity.getMainArm() == HumanoidArm.RIGHT) rightArmPose = HumanoidModel.ArmPose.BOW_AND_ARROW;
			else leftArmPose = HumanoidModel.ArmPose.BOW_AND_ARROW;
		} super.prepareMobModel(entity, limbSwing, limbSwingAmount, ageInTicks);
	}
	@Override public void setupAnim(EntityWildfire entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		rightAntenna.yRot = -Mth.cos(ageInTicks * .05F + limbSwing * .5F) * (.08F + limbSwingAmount * .1F);
		leftAntenna.yRot = -rightAntenna.yRot;
		thorax.yRot = Mth.cos(limbSwing * .6662F) * limbSwingAmount * .4F;
		head.y = hat.y = -2;
		body.y = 5;
		rightArm.y = leftArm.y = 0;
		rightArm.z = leftArm.z = -.5F;
		rightLeg.z = leftLeg.z = -1;
	}
	@Override public void translateToHand(HumanoidArm arm, PoseStack stack) {
		float f = arm == HumanoidArm.RIGHT ? -1 : 1;
		ModelPart modelpart = getArm(arm);
		modelpart.x += f;
		modelpart.translateAndRotate(stack);
		modelpart.x -= f;
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}