package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;

import divinerpg.entities.iceika.EntityRollum;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelRollum extends EntityModel<EntityRollum> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("rollum");
	private final ModelPart Head, Torso, RightArm, LeftArm, RightLeg, LeftLeg;

	public ModelRollum(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Head = root.getChild("Head");
		this.Torso = root.getChild("Torso");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create(), PartPose.offset(0.0F, 7F, 0.0F));

		Torso.addOrReplaceChild("Torso_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -14.0F, -2.8033F, 16.0F, 14.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0F, -0.1972F, 0.48F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(38, 35).addBox(-5.0F, -4.0F, -9.0F, 10.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.3696F, -4.6972F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(47, 17).addBox(0.0F, -4.0F, -5.0F, 7.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(7.9F, -2.6696F, -0.6972F));

		LeftArm.addOrReplaceChild("LeftLowerArm", CubeListBuilder.create().texOffs(28, 50).addBox(-4.0F, -1.0F, -4.0F, 5.0F, 13.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 4.0F, -1.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(56, 0).addBox(-7.0F, -4.0F, -7.0F, 7.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.9F, -2.6696F, 1.3028F));

		RightArm.addOrReplaceChild("RightLowerArm", CubeListBuilder.create().texOffs(0, 43).addBox(-1.0F, -1.0F, -4.0F, 5.0F, 13.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 4.0F, -3.0F));

		Torso.addOrReplaceChild("Hip", CubeListBuilder.create().texOffs(0, 26).addBox(-7.0F, 0.0F, -5.0F, 14.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 2.0F));

		partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(56, 50).addBox(-2.0F, 0.0F, -4.0F, 6.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 14.0F, 1.0F));

		partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 65).addBox(-4.0F, 0.0F, -4.0F, 6.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 14.0F, 1.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(EntityRollum entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.yRot = netHeadYaw / (180F / (float)Math.PI);
		this.Head.xRot = headPitch / (180F / (float)Math.PI);
		this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.RightArm.yRot = 0.0F;
		this.LeftArm.yRot = 0.0F;
		this.RightArm.zRot = 0.0F;
		this.LeftArm.zRot = 0.0F;
		AnimationUtils.bobModelPart(this.RightArm, ageInTicks, 1.0F);
		AnimationUtils.bobModelPart(this.LeftArm, ageInTicks, -1.0F);
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.setupAttackAnimation(entity, ageInTicks);
	}

	protected ModelPart getArm(HumanoidArm humanoidarm) {
		return this.RightArm;
	}

	private HumanoidArm getAttackArm(EntityRollum p_102857_) {
		return p_102857_.getMainArm();
	}

	protected void setupAttackAnimation(EntityRollum p_102858_, float p_102859_) {
		if (!(this.attackTime <= 0.0F)) {
			HumanoidArm humanoidarm = this.getAttackArm(p_102858_);
			ModelPart modelpart = this.getArm(humanoidarm);
			float f = this.attackTime;
			this.Torso.yRot = Mth.sin(Mth.sqrt(f) * ((float)Math.PI * 2F)) * 0.2F;

			this.RightArm.yRot += this.Torso.yRot;
			f = 1.0F - this.attackTime;
			f *= f;
			f *= f;
			f = 1.0F - f;
			float f1 = Mth.sin(f * (float)Math.PI);
			float f2 = Mth.sin(this.attackTime * (float)Math.PI) * -(this.Head.xRot - 0.7F) * 0.75F;
			modelpart.xRot -= f1 * 1.2F + f2;
			modelpart.yRot += this.Torso.yRot * 2.0F;
			modelpart.zRot += Mth.sin(this.attackTime * (float)Math.PI) * -0.4F;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}
