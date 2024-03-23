package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntityAridWarrior;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelAridWarrior extends EntityModel<EntityAridWarrior> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("arid_warrior");
	public final ModelPart Torso, Cape, Head, RightEar, LeftEar, rightLeg, leftLeg, rightArm, leftArm;
	public ModelAridWarrior(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		Torso = root.getChild("Torso");
		Cape = Torso.getChild("Cape");
		Head = root.getChild("Head");
		RightEar = Head.getChild("RightEar");
		LeftEar = Head.getChild("LeftEar");
		rightLeg = root.getChild("rightLeg");
		leftLeg = root.getChild("leftLeg");
		rightArm = root.getChild("rightArm");
		leftArm = root.getChild("leftArm");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 16).addBox(-5, -10, -3, 10, 10, 6, cubeDef), PartPose.offset(0, 8, 0));
		Torso.addOrReplaceChild("Cape", CubeListBuilder.create().texOffs(31, 31).addBox(-5, 0, 0, 10, 20, 1, cubeDef), PartPose.offset(0, -10, 3));
		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4, -8, -4, 8, 8, 8, cubeDef), PartPose.offset(0, -1.99F, 0));
		Head.addOrReplaceChild("RightEar", CubeListBuilder.create().texOffs(29, 46).addBox(0, -5, 0, 0, 6, 6, cubeDef), PartPose.offset(-4, -7, -1));
		Head.addOrReplaceChild("LeftEar", CubeListBuilder.create().texOffs(41, 46).addBox(0, -5, 0, 0, 6, 6, cubeDef), PartPose.offset(4, -7, -1));
		partdefinition.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(17, 46).addBox(-3, -1, -1.5F, 3, 14, 3, cubeDef), PartPose.offset(-5, -1, .5F));
		partdefinition.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(8, 32).addBox(0, -1, -1.5F, 3, 14, 3, cubeDef), PartPose.offset(5, -1, .5F));
		Torso.addOrReplaceChild("Hip", CubeListBuilder.create().texOffs(27, 11).addBox(-5, 0, -2, 10, 4, 5, cubeDef), PartPose.ZERO);
		PartDefinition rightLeg = partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(48, 0).addBox(-2.5F, 0, -2, 4, 5, 4, cubeDef), PartPose.offset(-2, 12, 0));
		rightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(32, 20).addBox(-2, 0, -2, 4, 7, 4, cubeDef), PartPose.offset(-1, 4.99F, 1));
		PartDefinition leftLeg = partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(48, 20).addBox(-1.5F, 0, -2, 4, 5, 4, cubeDef), PartPose.offset(2, 12, 0));
		leftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(32, 0).addBox(-2, 0, -2, 4, 7, 4, cubeDef), PartPose.offset(1, 4.99F, 1));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	@Override public void setupAnim(EntityAridWarrior entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		Head.yRot = netHeadYaw * Mth.DEG_TO_RAD;
		Head.xRot = headPitch * Mth.DEG_TO_RAD;
		float f = Mth.PI / 16 + Mth.cos(ageInTicks * .05F + limbSwing * .5F) * .08F + limbSwingAmount * .1F + .2182F;
		RightEar.yRot = -f;
		LeftEar.yRot = f;
		float f1 = Mth.cos(limbSwing * .6662F) * limbSwingAmount;
		float f2 = Mth.cos(limbSwing * .6662F + Mth.PI) * limbSwingAmount;
		rightLeg.xRot = f1 * 1.4F;
		leftLeg.xRot = f2 * 1.4F;
		rightArm.xRot = f2;
		leftArm.xRot = f1;
		rightArm.yRot = leftArm.yRot = rightArm.zRot = leftArm.zRot = 0;
		AnimationUtils.bobModelPart(rightArm, ageInTicks, 1);
		AnimationUtils.bobModelPart(leftArm, ageInTicks, -1);
		float capeMov = Mth.sqrt((float)Math.atan(200 * limbSwing)) * limbSwingAmount;
		Cape.xRot = capeMov + Mth.PI / 18;
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}