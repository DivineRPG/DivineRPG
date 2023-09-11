package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.mortum.EntitySoulStealer;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelSoulStealer extends EntityModel<EntitySoulStealer> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("soul_stealer");
	private final ModelPart Head, RightEar, LeftEar, Body, RightArm, LeftArm, RightLeg, LeftLeg;

	public ModelSoulStealer(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Head = root.getChild("Head");
		this.RightEar = this.Head.getChild("RightEar");
		this.LeftEar = this.Head.getChild("LeftEar");
		this.Body = root.getChild("Body");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 29).addBox(-7.0F, -6.0F, -4.0F, 14.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition LeftEar = Head.addOrReplaceChild("LeftEar", CubeListBuilder.create(), PartPose.offset(6.0F, -4.0F, 1.0F));

		LeftEar.addOrReplaceChild("leftear_r1", CubeListBuilder.create().texOffs(60, 29).addBox(0.0F, -10.0F, 0.0F, 10.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.rotation(-0.1309F, -0.5672F, 0.0F));

		PartDefinition RightEar = Head.addOrReplaceChild("RightEar", CubeListBuilder.create(), PartPose.offset(-6.0F, -4.0F, 1.0F));

		RightEar.addOrReplaceChild("rightear_r1", CubeListBuilder.create().texOffs(68, 41).addBox(-10.0F, -10.0F, 0.0F, 10.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.rotation(-0.1309F, 0.5672F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-11.0F, -18.0F, -4.0F, 22.0F, 18.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, 0.0F));

		partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(66, 0).addBox(-5.0F, -1.0F, -3.0F, 5.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, -3.0F, 0.0F));

		partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 61).addBox(0.0F, -1.0F, -3.0F, 5.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, -3.0F, 0.0F));

		partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(36, 35).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 14.0F, 0.0F));

		partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 43).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, 14.0F, 0.0F));

		Body.addOrReplaceChild("RightRibs", CubeListBuilder.create().texOffs(60, 53).addBox(0.0F, -9.0F, -3.0F, 11.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, -9.0F, -4.0F));

		Body.addOrReplaceChild("LeftRibs", CubeListBuilder.create().texOffs(32, 53).addBox(-11.0F, -9.0F, -3.0F, 11.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, -9.0F, -4.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(EntitySoulStealer entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.yRot = netHeadYaw / (180F / (float)Math.PI);
		this.Head.xRot = headPitch / (180F / (float)Math.PI);
		this.LeftEar.yRot = ((float)Math.PI / 16F) + Mth.cos(ageInTicks * 0.1F + limbSwing * 0.5F) * 0.08F + limbSwingAmount * 0.2F;;
		this.RightEar.yRot = (-(float)Math.PI / 16F) - Mth.cos(ageInTicks * 0.1F + limbSwing * 0.6F) * 0.08F + limbSwingAmount * 0.2F;;

		this.RightArm.yRot = 0.0F;
		this.LeftArm.yRot = 0.0F;
		this.RightArm.zRot = 0.0F;
		this.LeftArm.zRot = 0.0F;
		AnimationUtils.bobModelPart(this.RightArm, ageInTicks, 1.0F);
		AnimationUtils.bobModelPart(this.LeftArm, ageInTicks, -1.0F);
		this.RightLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
		this.LeftLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
	}

	public void prepareMobModel(EntitySoulStealer entity, float limbSwing, float limbSwingAmount, float ageInTicks) {
		super.prepareMobModel(entity, limbSwing, limbSwingAmount, ageInTicks);
		int i = entity.getAttackAnimationTick();
		if (i > 0) {
			this.RightArm.xRot = -1.0F + 1.5F * Mth.triangleWave((float)i - ageInTicks, 10.0F);
			this.LeftArm.xRot = -1.0F + 1.5F * Mth.triangleWave((float)i - ageInTicks, 10.0F);
		} else {
			this.RightArm.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 2.0F * limbSwingAmount * 0.5F);
			this.LeftArm.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F);
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}