package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.apalachia.EntityEnchantedWarrior;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelEnchantedWarrior extends EntityModel<EntityEnchantedWarrior> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("enchanted_warrior");
	public final ModelPart body, skull, rightLeg, leftLeg, rightArm, leftArm;
	public ModelEnchantedWarrior(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		body = root.getChild("body");
		skull = root.getChild("skull");
		rightLeg = root.getChild("rightLeg");
		leftLeg = root.getChild("leftLeg");
		rightArm = root.getChild("rightArm");
		leftArm = root.getChild("leftArm");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(-4, -7, -2, 8, 14, 4, new CubeDeformation(0)), PartPose.offset(0, 3, 0));
		partdefinition.addOrReplaceChild("skull", CubeListBuilder.create().texOffs(24, 16).addBox(-7, -13, 2, 14, 12, 0, new CubeDeformation(0))
		.texOffs(24, 0).addBox(-7, -7, -1, 14, 2, 2, new CubeDeformation(0))
		.texOffs(0, 0).addBox(-4, -8, -4, 8, 8, 8, new CubeDeformation(0)), PartPose.offset(0, -4, 0));
		partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(16, 46).addBox(-2, 0, -2, 4, 14, 4, new CubeDeformation(0)), PartPose.offset(-2, 10, 0));
		partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(40, 28).addBox(-2, 0, -2, 4, 14, 4, new CubeDeformation(0)), PartPose.offset(2, 10, 0));
		partdefinition.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(24, 28).addBox(-4, -2, -2, 4, 14, 4, new CubeDeformation(0)), PartPose.offset(-4, -2, 0));
		partdefinition.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(0, 34).addBox(0, -2, -2, 4, 14, 4, new CubeDeformation(0)), PartPose.offset(4, -2, 0));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	@Override public void setupAnim(EntityEnchantedWarrior entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		skull.yRot = netHeadYaw * Mth.DEG_TO_RAD;
		skull.xRot = headPitch * Mth.DEG_TO_RAD;
		float f = Mth.cos(limbSwing * .6662F) * limbSwingAmount;
		float f1 = Mth.cos(limbSwing * .6662F + Mth.PI) * limbSwingAmount;
		rightLeg.xRot = f * 1.4F;
		leftLeg.xRot = f1 * 1.4F;
		rightArm.xRot = f1;
		leftArm.xRot = f;
		rightArm.yRot = leftArm.yRot = rightArm.zRot = leftArm.zRot = 0;
		AnimationUtils.bobModelPart(rightArm, ageInTicks, 1);
		AnimationUtils.bobModelPart(leftArm, ageInTicks, -1);
		setupAttackAnimation(entity, ageInTicks);
	}
	protected ModelPart getArm(HumanoidArm humanoidarm) {return rightArm;}
	private HumanoidArm getAttackArm(EntityEnchantedWarrior warrior) {return warrior.getMainArm();}
	protected void setupAttackAnimation(EntityEnchantedWarrior entity, float g) {
		if(!(attackTime <= 0)) {
			HumanoidArm humanoidarm = getAttackArm(entity);
			ModelPart modelpart = getArm(humanoidarm);
			float f = attackTime;
			body.yRot = Mth.sin(Mth.sqrt(f) * Mth.TWO_PI) * .2F;
			rightArm.yRot += body.yRot;
			f = 1 - attackTime;
			f *= f;
			f *= f;
			f = 1 - f;
			float f1 = Mth.sin(f * Mth.PI);
			float f2 = Mth.sin(attackTime * Mth.PI) * -(skull.xRot - .7F) * .75F;
			modelpart.xRot -= f1 * 1.2F + f2;
			modelpart.yRot += body.yRot * 2;
			modelpart.zRot += Mth.sin(attackTime * Mth.PI) * -.4F;
		}
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		skull.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}