package divinerpg.client.models.boss;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelSunstorm<T extends LivingEntity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("sunstorm");
	private final ModelPart UpperBody, LowerBody, LeftArm, RightArm, LeftLegThigh, RightLegThigh;

	public ModelSunstorm(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.UpperBody = root.getChild("UpperBody");
		this.LowerBody = root.getChild("LowerBody");
		this.LeftArm = root.getChild("LeftArm");
		this.RightArm = root.getChild("RightArm");
		this.LeftLegThigh = root.getChild("LeftLegThigh");
		this.RightLegThigh = root.getChild("RightLegThigh");
	}

	public ModelSunstorm(ModelPart root) {
		this.UpperBody = root.getChild("UpperBody");
		this.LowerBody = root.getChild("LowerBody");
		this.LeftArm = root.getChild("LeftArm");
		this.RightArm = root.getChild("RightArm");
		this.LeftLegThigh = root.getChild("LeftLegThigh");
		this.RightLegThigh = root.getChild("RightLegThigh");

	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition UpperBody = partdefinition.addOrReplaceChild("UpperBody", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -23.0F, -6.0F, 24.0F, 22.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(84, 0).addBox(0.0F, -7.0F, -6.0F, 12.0F, 8.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(89, 57).addBox(1.0F, 1.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(12.0F, -23.0F, 2.0F));

		LeftArm.addOrReplaceChild("LeftCannon", CubeListBuilder.create().texOffs(47, 53).addBox(-5.0F, 0.0F, -4.0F, 10.0F, 22.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 10.0F, -1.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(104, 103).addBox(-9.0F, 1.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(30, 86).addBox(-12.0F, -7.0F, -6.0F, 12.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.0F, -23.0F, 2.0F));

		RightArm.addOrReplaceChild("RightCannon", CubeListBuilder.create().texOffs(0, 64).addBox(-5.0F, 0.0F, -4.0F, 10.0F, 22.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 10.0F, -1.0F));

		UpperBody.addOrReplaceChild("MiddleSoul", CubeListBuilder.create().texOffs(61, 40).addBox(-3.0F, -8.0F, -1.0F, 6.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.0F, -8.0F, -0.4363F, 0.0F, 0.0F));

		UpperBody.addOrReplaceChild("RightSoul", CubeListBuilder.create().texOffs(45, 40).addBox(-3.0F, -8.0F, -1.0F, 6.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -24.0F, -8.0F, -0.3491F, 0.0F, -0.5236F));

		UpperBody.addOrReplaceChild("LeftSoul", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -8.0F, -1.0F, 6.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, -24.0F, -8.0F, -0.3491F, 0.0F, 0.5236F));

		UpperBody.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(34, 106).addBox(-6.0F, -8.0F, -4.0F, 12.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, -5.0F));

		partdefinition.addOrReplaceChild("LowerBody", CubeListBuilder.create().texOffs(0, 40).addBox(-8.0F, -2.0F, -4.0F, 16.0F, 11.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, 0.0F));

		PartDefinition RightLegThigh = partdefinition.addOrReplaceChild("RightLegThigh", CubeListBuilder.create().texOffs(0, 98).addBox(-6.0F, 0.0F, -3.0F, 9.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -4.0F, 1.0F));

		RightLegThigh.addOrReplaceChild("RightLegFoot", CubeListBuilder.create().texOffs(79, 76).addBox(-5.0F, 0.0F, -4.0F, 11.0F, 17.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 11.0F, 0.0F));

		PartDefinition LeftLegThigh = partdefinition.addOrReplaceChild("LeftLegThigh", CubeListBuilder.create().texOffs(70, 103).addBox(-3.0F, 0.0F, -3.0F, 9.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -4.0F, 1.0F));

		LeftLegThigh.addOrReplaceChild("LeftLegFoot", CubeListBuilder.create().texOffs(78, 30).addBox(-6.0F, 0.0F, -4.0F, 11.0F, 17.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 11.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.RightArm.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 2.0F * limbSwingAmount * 0.5F);
		this.LeftArm.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F);
		this.RightArm.yRot = 0.0F;
		this.LeftArm.yRot = 0.0F;
		this.RightArm.zRot = 0.0F;
		this.LeftArm.zRot = 0.0F;
		AnimationUtils.bobModelPart(this.RightArm, ageInTicks, 1.0F);
		AnimationUtils.bobModelPart(this.LeftArm, ageInTicks, -1.0F);
		this.RightLegThigh.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
		this.LeftLegThigh.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
		this.setupAttackAnimation(entity, ageInTicks);
	}

	protected ModelPart getArm(HumanoidArm humanoidarm) {
		return this.RightArm;
	}

	private HumanoidArm getAttackArm(T p_102857_) {
		return p_102857_.getMainArm();
	}

	protected void setupAttackAnimation(T p_102858_, float p_102859_) {
		if (!(this.attackTime <= 0.0F)) {
			HumanoidArm humanoidarm = this.getAttackArm(p_102858_);
			ModelPart modelpart = this.getArm(humanoidarm);
			float f = this.attackTime;
			this.UpperBody.yRot = Mth.sin(Mth.sqrt(f) * ((float)Math.PI * 2F)) * 0.2F;

			this.RightArm.yRot += this.UpperBody.yRot;
			f = 1.0F - this.attackTime;
			f *= f;
			f *= f;
			f = 1.0F - f;
			float f1 = Mth.sin(f * (float)Math.PI);
			float f2 = Mth.sin(this.attackTime * (float)Math.PI) * 0.525F;
			modelpart.xRot -= f1 * 1.2F + f2;
			modelpart.yRot += this.UpperBody.yRot * 2.0F;
			modelpart.zRot += Mth.sin(this.attackTime * (float)Math.PI) * -0.4F;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		UpperBody.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		LowerBody.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		LeftLegThigh.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		RightLegThigh.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}