package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;

import divinerpg.entities.apalachia.EntityEnchantedWarrior;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelEnchantedWarrior extends EntityModel<EntityEnchantedWarrior> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("enchanted_warrior");
	public final ModelPart body, rightLeg, leftLeg, rightArm, leftArm, skull;
	public ModelEnchantedWarrior(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		body = root.getChild("body");
		rightLeg = root.getChild("rightLeg");
		leftLeg = root.getChild("leftLeg");
		rightArm = root.getChild("rightArm");
		leftArm = root.getChild("leftArm");
		skull = root.getChild("skull");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 0.0F));
		partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(16, 46).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 10.0F, 0.0F));
		partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(40, 28).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 10.0F, 0.0F));
		partdefinition.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(0, 34).addBox(0.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -2.0F, 0.0F));
		partdefinition.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(24, 28).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -2.0F, 0.0F));
		partdefinition.addOrReplaceChild("skull", CubeListBuilder.create().texOffs(24, 16).addBox(-7.0F, -13.0F, 2.0F, 14.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(24, 0).addBox(-7.0F, -7.0F, -1.0F, 14.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	@Override public void setupAnim(EntityEnchantedWarrior entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		skull.yRot = netHeadYaw / (180F / (float)Math.PI);
		skull.xRot = headPitch / (180F / (float)Math.PI);
		rightArm.xRot = (float) (Math.cos(limbSwing * .6662F + Math.PI) * 2F * limbSwingAmount * .5F);
		leftArm.xRot = (float) (Math.cos(limbSwing * .6662F) * 2F * limbSwingAmount * .5F);
		rightArm.yRot = leftArm.yRot = rightArm.zRot = leftArm.zRot = 0F;
		AnimationUtils.bobModelPart(rightArm, ageInTicks, 1F);
		AnimationUtils.bobModelPart(leftArm, ageInTicks, -1F);
		rightLeg.xRot = (float) (Math.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount);
		leftLeg.xRot = (float) (Math.cos(limbSwing * .6662F + Math.PI) * 1.4F * limbSwingAmount);
		setupAttackAnimation(entity, ageInTicks);
	}
	protected ModelPart getArm(HumanoidArm humanoidarm) {
		return rightArm;
	}
	private HumanoidArm getAttackArm(EntityEnchantedWarrior warrior) {
		return warrior.getMainArm();
	}
	protected void setupAttackAnimation(EntityEnchantedWarrior entity, float g) {
		if(!(attackTime <= 0F)) {
			HumanoidArm humanoidarm = getAttackArm(entity);
			ModelPart modelpart = getArm(humanoidarm);
			float f = attackTime;
			body.yRot = Mth.sin(Mth.sqrt(f) * ((float)Math.PI * 2F)) * .2F;
			rightArm.yRot += body.yRot;
			f = 1F - attackTime;
			f *= f;
			f *= f;
			f = 1F - f;
			float f1 = Mth.sin(f * (float)Math.PI);
			float f2 = Mth.sin(attackTime * (float)Math.PI) * -(skull.xRot - .7F) * .75F;
			modelpart.xRot -= f1 * 1.2F + f2;
			modelpart.yRot += body.yRot * 2F;
			modelpart.zRot += Mth.sin(attackTime * (float)Math.PI) * -.4F;
		}
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		skull.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}