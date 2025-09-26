package divinerpg.client.models.boss;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.boss.EntitySunstorm;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelSunstorm extends HumanoidModel<EntitySunstorm> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("sunstorm");
	public final ModelPart rightSoul, middleSoul, leftSoul, hip;
	public ModelSunstorm(ModelPart root) {
		super(root);
		rightSoul = body.getChild("right_soul");
		middleSoul = body.getChild("middle_soul");
		leftSoul = body.getChild("left_soul");
		hip = root.getChild("hip");
	}
	public static LayerDefinition createBodyLayer() {
		CubeDeformation cubeDef = CubeDeformation.NONE;
		MeshDefinition meshdefinition = HumanoidModel.createMesh(cubeDef, 0);
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(34, 106).addBox(-6, -8, -4, 12, 15, 3, cubeDef), PartPose.offset(0, -21, -5));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-12, -23, -6, 24, 22, 18, cubeDef), PartPose.offset(0, -8, 0));
		body.addOrReplaceChild("middle_soul", CubeListBuilder.create().texOffs(61, 40).addBox(-3, -8, -1, 6, 9, 2, cubeDef), PartPose.offsetAndRotation(0, -28, -8, -Mth.PI / 7.2F, 0, 0));
		body.addOrReplaceChild("right_soul", CubeListBuilder.create().texOffs(45, 40).addBox(-3, -8, -1, 6, 9, 2, cubeDef), PartPose.offsetAndRotation(-10, -24, -8, -Mth.PI / 9, 0, -Mth.PI / 6));
		body.addOrReplaceChild("left_soul", CubeListBuilder.create().texOffs(0, 0).addBox(-3, -8, -1, 6, 9, 2, cubeDef), PartPose.offsetAndRotation(10, -24, -8, -Mth.PI / 9, 0, Mth.PI / 6));
		PartDefinition rightArm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(104, 103).addBox(-9, 1, -4, 8, 10, 8, cubeDef)
		.texOffs(30, 86).addBox(-12, -7, -6, 12, 8, 12, cubeDef), PartPose.offset(-12, -23, 2));
		rightArm.addOrReplaceChild("right_cannon", CubeListBuilder.create().texOffs(0, 64).addBox(-5, 0, -4, 10, 22, 11, cubeDef), PartPose.offset(-5, 10, -1));
		PartDefinition leftArm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(84, 0).addBox(0, -7, -6, 12, 8, 12, cubeDef)
		.texOffs(89, 57).addBox(1, 1, -4, 8, 10, 8, cubeDef), PartPose.offset(12, -23, 2));
		leftArm.addOrReplaceChild("left_cannon", CubeListBuilder.create().texOffs(47, 53).addBox(-5, 0, -4, 10, 22, 11, cubeDef), PartPose.offset(5, 10, -1));
		partdefinition.addOrReplaceChild("hip", CubeListBuilder.create().texOffs(0, 40).addBox(-8, -2, -4, 16, 11, 13, cubeDef), PartPose.offset(0, -9, 0));
		PartDefinition rightLeg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 98).addBox(-6, 0, -3, 9, 12, 8, cubeDef), PartPose.offset(-5, -4, 1));
		rightLeg.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(79, 76).addBox(-5, 0, -4, 11, 17, 10, cubeDef), PartPose.offset(-2, 11, 0));
		PartDefinition leftLeg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(70, 103).addBox(-3, 0, -3, 9, 12, 8, cubeDef), PartPose.offset(5, -4, 1));
		leftLeg.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(78, 30).addBox(-6, 0, -4, 11, 17, 10, cubeDef), PartPose.offset(2, 11, 0));
		return LayerDefinition.create(meshdefinition, 256, 128);
	}
	@Override public void prepareMobModel(EntitySunstorm entity, float limbSwing, float limbSwingAmount, float ageInTicks) {
		super.prepareMobModel(entity, limbSwing, limbSwingAmount, ageInTicks);
		rightSoul.visible = entity.getHealth() > 2 * entity.getMaxHealth() / 3;
		leftSoul.visible = entity.getHealth() > entity.getMaxHealth() / 2;
		middleSoul.visible = entity.getHealth() > entity.getMaxHealth() / 3;
	}
	@Override public void setupAnim(EntitySunstorm entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		head.xRot = head.yRot = 0;
		head.y = hat.y = -21;
		body.y = -8;
		rightArm.x = -12;
		leftArm.x = -rightArm.x;
		rightArm.y = leftArm.y = -23;
		rightArm.z = leftArm.z = 2;
		rightLeg.y = leftLeg.y = -4;
		rightLeg.z = leftLeg.z = 1;
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		hip.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}