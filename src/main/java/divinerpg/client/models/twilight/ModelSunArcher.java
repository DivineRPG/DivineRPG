package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.eden.EntitySunArcher;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.BowItem;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelSunArcher extends HumanoidModel<EntitySunArcher> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("sun_archer");
	public final ModelPart cloak;
	public ModelSunArcher(ModelPart part) {
		super(part);
		cloak = body.getChild("cloak");
	}
	public static LayerDefinition createBodyLayer() {
		CubeDeformation cubeDef = CubeDeformation.NONE;
		MeshDefinition meshdefinition = HumanoidModel.createMesh(cubeDef, 0);
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartPose zPose = PartPose.ZERO;
		PartDefinition hat = partdefinition.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(50, 35).addBox(-4, -4, -3.9F, 8, 7, 1, cubeDef)
		.texOffs(28, 13).addBox(-3, 3, -3.9F, 6, 2, 1, cubeDef)
		.texOffs(26, 62).addBox(-2, 5, -3.9F, 4, 6, 0, cubeDef)
		.texOffs(18, 17).addBox(-3.5F, -1, -3.5F, 7, 3, 7, cubeDef), zPose);
		hat.addOrReplaceChild("lower_left_ray", CubeListBuilder.create().texOffs(46, 24).addBox(-.42F, -1, 0, 6, 3, 0, cubeDef), PartPose.offsetAndRotation(3, -1, -3.05F, 0, -Mth.PI / 9, 0));
		hat.addOrReplaceChild("upper_left_ray", CubeListBuilder.create().texOffs(58, 24).addBox(-.42F, -3, 0, 6, 3, 0, cubeDef), PartPose.offsetAndRotation(3, -1, -2.05F, .3368F, -.5198F, -.614F));
		hat.addOrReplaceChild("middle_ray", CubeListBuilder.create().texOffs(34, 62).addBox(-1, -6, 0, 3, 6, 0, cubeDef), PartPose.offsetAndRotation(-.5F, -3, -2.9F, -.5236F, 0, 0));
		hat.addOrReplaceChild("upper_right_ray", CubeListBuilder.create().texOffs(0, 60).addBox(-5.58F, -3, 0, 6, 3, 0, cubeDef), PartPose.offsetAndRotation(-3, -1, -2.05F, .3368F, .5198F, .614F));
		hat.addOrReplaceChild("lower_right_ray", CubeListBuilder.create().texOffs(52, 59).addBox(-5.58F, -1, 0, 6, 3, 0, cubeDef), PartPose.offsetAndRotation(-3, -1, -3.05F, 0, Mth.PI / 9, 0));
		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(18, 27).addBox(-3, -5.99F, -3, 6, 6, 6, cubeDef), zPose);
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5, 0, -3, 10, 13, 4, cubeDef), PartPose.offset(0, 0, 1));
		body.addOrReplaceChild("right_cloak_pad", CubeListBuilder.create().texOffs(42, 27).addBox(-6, -2, -2, 6, 3, 5, cubeDef), PartPose.offsetAndRotation(-3.58F, 1.38F, -1.5F, 0, 0, .2182F));
		body.addOrReplaceChild("left_cloak_pad", CubeListBuilder.create().texOffs(46, 0).addBox(0, -2, -2, 6, 3, 5, cubeDef), PartPose.offsetAndRotation(3.58F, 1.38F, -1.5F, 0, 0, -.2182F));
		partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(28, 0).addBox(-2.5F, 0, -2, 5, 9, 4, cubeDef)
		.texOffs(0, 52).addBox(-2.5F, 9, -1, 4, 5, 3, cubeDef), PartPose.offset(-2.5F, 0, 0));
		partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 39).addBox(-2.5F, 0, -2, 5, 9, 4, cubeDef)
		.texOffs(26, 54).addBox(-1.5F, 9, -1, 4, 5, 3, cubeDef), PartPose.offset(2.5F, 0, 0));
		partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(50, 43).addBox(-4, -1.5F, -2, 4, 4, 4, cubeDef)
		.texOffs(14, 54).addBox(-3.5F, 2.5F, -1.5F, 3, 7, 3, cubeDef)
		.texOffs(18, 39).addBox(-4, 9, -2, 4, 11, 4, cubeDef)
		.texOffs(46, 16).addBox(-4.5F, 7.5F, -2.5F, 5, 3, 5, cubeDef), zPose);
		partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(50, 51).addBox(0, -1.5F, -2, 4, 4, 4, cubeDef)
		.texOffs(40, 59).addBox(.5F, 2.5F, -1.5F, 3, 7, 3, cubeDef)
		.texOffs(46, 8).addBox(-.5F, 7.5F, -2.5F, 5, 3, 5, cubeDef)
		.texOffs(34, 39).addBox(0, 9, -2, 4, 11, 4, cubeDef), zPose);
		PartDefinition cloak = body.addOrReplaceChild("cloak", CubeListBuilder.create(), PartPose.offset(0, 0, 1));
		cloak.addOrReplaceChild("cloak_rot", CubeListBuilder.create().texOffs(0, 17).addBox(-4, 0, 0, 8, 21, 1, cubeDef), PartPose.rotation(.0436F, 0, 0));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	@Override public void prepareMobModel(EntitySunArcher entity, float limbSwing, float limbSwingAmount, float ageInTicks) {
		rightArmPose = leftArmPose = HumanoidModel.ArmPose.EMPTY;
		if(entity.getMainHandItem().getItem() instanceof BowItem && entity.isAggressive()) {
			if(entity.getMainArm() == HumanoidArm.RIGHT) rightArmPose = HumanoidModel.ArmPose.BOW_AND_ARROW;
			else leftArmPose = HumanoidModel.ArmPose.BOW_AND_ARROW;
		} super.prepareMobModel(entity, limbSwing, limbSwingAmount, ageInTicks);
		hat.visible = entity.getHealth() > entity.getMaxHealth() / 2;
	}
	@Override public void setupAnim(EntitySunArcher entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		cloak.xRot = Mth.sqrt((float)Math.atan(200 * limbSwing)) * limbSwingAmount;
		hat.y = -6;
		head.y = body.y = -3;
		rightArm.y = leftArm.y = -1.5F;
		rightLeg.y = leftLeg.y = 10;
	}
	@Override public void translateToHand(HumanoidArm arm, PoseStack stack) {
		float f = arm == HumanoidArm.RIGHT ? -1 : 1;
		ModelPart modelpart = getArm(arm);
		modelpart.x += f;
		modelpart.translateAndRotate(stack);
		modelpart.x -= f;
		stack.translate(0, .5F, 0);
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		hat.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}