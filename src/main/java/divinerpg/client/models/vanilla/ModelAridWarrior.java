package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntityAridWarrior;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.BowItem;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelAridWarrior extends HumanoidModel<EntityAridWarrior> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("arid_warrior");
	public final ModelPart rightEar = head.getChild("right_ear"),
			leftEar = head.getChild("left_ear"),
			cloak = body.getChild("cloak");
	public ModelAridWarrior(ModelPart part) {super(part);}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0);
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4, -8, -4, 8, 8, 8, cubeDef), PartPose.ZERO);
		head.addOrReplaceChild("right_ear", CubeListBuilder.create().texOffs(29, 46).addBox(0, -5, 0, 0, 6, 6, cubeDef), PartPose.offset(-4, -7, -1));
		head.addOrReplaceChild("left_ear", CubeListBuilder.create().texOffs(41, 46).addBox(0, -5, 0, 0, 6, 6, cubeDef), PartPose.offset(4, -7, -1));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(-5, -10, -3, 10, 10, 6, cubeDef), PartPose.ZERO);
		body.addOrReplaceChild("hip", CubeListBuilder.create().texOffs(27, 11).addBox(-5, 0, -2, 10, 4, 5, cubeDef), PartPose.ZERO);
		body.addOrReplaceChild("cloak", CubeListBuilder.create().texOffs(31, 31).addBox(-5, 0, 0, 10, 20, 1, cubeDef), PartPose.offset(0, -10, 3));
		partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(12, 32).addBox(-2, -1, -1.5F, 3, 14, 3, cubeDef), PartPose.offset(0, 0, .5F));
		partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 32).addBox(-1, -1, -1.5F, 3, 14, 3, cubeDef), PartPose.offset(0, 0, .5F));
		PartDefinition rightLeg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(48, 0).addBox(-2.5F, 0, -2, 4, 5, 4, cubeDef), PartPose.offset(-2, 0, 0));
		rightLeg.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(32, 20).addBox(-2, 0, -2, 4, 7, 4, cubeDef), PartPose.offset(-1, 4.99F, 1));
		PartDefinition leftLeg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(48, 20).addBox(-1.5F, 0, -2, 4, 5, 4, cubeDef), PartPose.offset(2, 0, 0));
		leftLeg.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(32, 0).addBox(-2, 0, -2, 4, 7, 4, cubeDef), PartPose.offset(1, 4.99F, 1));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	@Override public void prepareMobModel(EntityAridWarrior entity, float limbSwing, float limbSwingAmount, float ageInTicks) {
		rightArmPose = leftArmPose = HumanoidModel.ArmPose.EMPTY;
		if(entity.getMainHandItem().getItem() instanceof BowItem && entity.isAggressive()) {
			if(entity.getMainArm() == HumanoidArm.RIGHT) rightArmPose = HumanoidModel.ArmPose.BOW_AND_ARROW;
			else leftArmPose = HumanoidModel.ArmPose.BOW_AND_ARROW;
		} super.prepareMobModel(entity, limbSwing, limbSwingAmount, ageInTicks);
	}
	@Override public void setupAnim(EntityAridWarrior entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		float f = Mth.PI / 16 + Mth.cos(ageInTicks * .05F + limbSwing * .5F) * .08F + limbSwingAmount * .1F + .2182F;
		rightEar.yRot = -f;
		leftEar.yRot = f;
		float cloakMov = Mth.sqrt((float)Math.atan(200 * limbSwing)) * limbSwingAmount;
		cloak.xRot = cloakMov + Mth.PI / 18;
		rightArm.y = leftArm.y = -1;
		rightArm.x = -6;
		leftArm.x = 6;
		rightLeg.y = leftLeg.y = 12;
		head.y = hat.y = -1.99F;
		body.y = 8;
	}
	@Override public void translateToHand(HumanoidArm arm, PoseStack stack) {
		float f = arm == HumanoidArm.RIGHT ? 1 : -1;
		ModelPart modelpart = getArm(arm);
		modelpart.x += f;
		modelpart.translateAndRotate(stack);
		modelpart.x -= f;
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}