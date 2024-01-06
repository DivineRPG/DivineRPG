package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.RangedAttackMob;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelAridWarrior<T extends Mob & RangedAttackMob> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("arid_warrior");
	public final ModelPart Torso, Cape, rightLeg, leftLeg, rightArm, leftArm, Head;

	public ModelAridWarrior(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Torso = root.getChild("Torso");
		this.Cape = this.Torso.getChild("Cape");
		this.rightLeg = root.getChild("rightLeg");
		this.leftLeg = root.getChild("leftLeg");
		this.rightArm = root.getChild("rightArm");
		this.leftArm = root.getChild("leftArm");
		this.Head = root.getChild("Head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 16).addBox(-5.0F, -10.0F, -3.0F, 10.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		Head.addOrReplaceChild("rightear_r1", CubeListBuilder.create().texOffs(29, 46).addBox(0.0F, -5.0F, 0.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -7.0F, -1.0F, 0.0F, -0.2182F, 0.0F));

		Head.addOrReplaceChild("leftear_r1", CubeListBuilder.create().texOffs(41, 46).addBox(0.0872F, -5.0F, -0.0019F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -7.0F, -1.0F, 0.0F, 0.2182F, 0.0F));

		Torso.addOrReplaceChild("Cape", CubeListBuilder.create().texOffs(31, 31).addBox(-5.0F, 0.0F, 0.0F, 10.0F, 20.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, 3.0F));

		partdefinition.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(17, 46).addBox(-3.0F, -1.0F, -1.5F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -1.0F, 0.5F));

		partdefinition.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(8, 32).addBox(0.0F, -1.0F, -1.5F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -1.0F, 0.5F));

		Torso.addOrReplaceChild("Hip", CubeListBuilder.create().texOffs(27, 11).addBox(-5.0F, 0.0F, -2.0F, 10.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightLeg = partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(48, 0).addBox(-2.5F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 12.0F, 0.0F));

		rightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(32, 20).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 5.0F, 1.0F));

		PartDefinition leftLeg = partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(48, 20).addBox(-1.5F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 12.0F, 0.0F));

		leftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(32, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 5.0F, 1.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.yRot = netHeadYaw / (180F / (float)Math.PI);
		this.Head.xRot = headPitch / (180F / (float)Math.PI);
		this.rightArm.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 2.0F * limbSwingAmount * 0.5F);
		this.leftArm.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F);
		this.rightArm.yRot = 0.0F;
		this.leftArm.yRot = 0.0F;
		this.rightArm.zRot = 0.0F;
		this.leftArm.zRot = 0.0F;
		AnimationUtils.bobModelPart(this.rightArm, ageInTicks, 1.0F);
		AnimationUtils.bobModelPart(this.leftArm, ageInTicks, -1.0F);
		this.rightLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
		this.leftLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
		float capeMov = (float) Math.sqrt(Math.atan(200F * limbSwing)) * limbSwingAmount;
		this.Cape.xRot = capeMov + (float)Math.PI / 18.0F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}