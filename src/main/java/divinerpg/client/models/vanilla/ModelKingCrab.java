package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntityKingCrab;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelKingCrab extends EntityModel<EntityKingCrab> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("king_crab");
	private final ModelPart Body, LeftClaw, RightClaw, FrontRightLeg, BackRightLeg, MiddleRightLeg, MiddleLeftLeg, FrontLeftLeg, BackLeftLeg;

	public ModelKingCrab(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Body = root.getChild("Body");
		this.LeftClaw = root.getChild("LeftClaw");
		this.RightClaw = root.getChild("RightClaw");
		
		FrontRightLeg = Body.getChild("FrontRightLeg");
		BackRightLeg = Body.getChild("BackRightLeg");
		MiddleRightLeg = Body.getChild("MiddleRightLeg");
		MiddleLeftLeg = Body.getChild("MiddleLeftLeg");
		FrontLeftLeg = Body.getChild("FrontLeftLeg");
		BackLeftLeg = Body.getChild("BackLeftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 64).addBox(-8.0F, -7.0F, -9.6667F, 16.0F, 2.0F, 20.0F, new CubeDeformation(0.0F))
		.texOffs(0, 36).addBox(-11.0F, -7.0F, -12.6667F, 22.0F, 2.0F, 26.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-11.0F, -5.0F, -12.6667F, 22.0F, 10.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 4.6667F));

		PartDefinition FrontRightLeg = Body.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create(), PartPose.offset(-12.0F, 1.0F, -4.6667F));

		FrontRightLeg.addOrReplaceChild("FrontRightLeg_r1", CubeListBuilder.create().texOffs(16, 86).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition FrontLeftLeg = Body.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create(), PartPose.offset(12.0F, 1.0F, -4.6667F));

		FrontLeftLeg.addOrReplaceChild("FrontLeftLeg_r1", CubeListBuilder.create().texOffs(0, 86).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition MiddleRightLeg = Body.addOrReplaceChild("MiddleRightLeg", CubeListBuilder.create(), PartPose.offset(-12.0F, 1.0F, 2.3333F));

		MiddleRightLeg.addOrReplaceChild("MiddleRightLeg_r1", CubeListBuilder.create().texOffs(16, 86).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition MiddleLeftLeg = Body.addOrReplaceChild("MiddleLeftLeg", CubeListBuilder.create(), PartPose.offset(12.0F, 1.0F, 2.3333F));

		MiddleLeftLeg.addOrReplaceChild("MiddleLeftLeg_r1", CubeListBuilder.create().texOffs(0, 86).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition BackLeftLeg = Body.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create(), PartPose.offset(12.0F, 1.0F, 9.3333F));

		BackLeftLeg.addOrReplaceChild("BackLeftLeg_r1", CubeListBuilder.create().texOffs(0, 86).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition BackRightLeg = Body.addOrReplaceChild("BackRightLeg", CubeListBuilder.create(), PartPose.offset(-12.0F, 1.0F, 9.3333F));

		BackRightLeg.addOrReplaceChild("BackRightLeg_r1", CubeListBuilder.create().texOffs(16, 86).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		partdefinition.addOrReplaceChild("LeftClaw", CubeListBuilder.create().texOffs(77, 64).addBox(0.0F, -3.25F, -10.0F, 6.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(70, 36).addBox(0.0F, -2.25F, -10.0F, 6.0F, 10.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, 8.25F, -6.0F));

		partdefinition.addOrReplaceChild("RightClaw", CubeListBuilder.create().texOffs(52, 64).addBox(-6.0F, -3.75F, -11.5F, 6.0F, 1.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(70, 0).addBox(-6.0F, -2.75F, -11.5F, 6.0F, 12.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, 7.75F, -5.5F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(EntityKingCrab entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.FrontRightLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
		this.BackRightLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.E) * 1.4F * limbSwingAmount);

		this.MiddleRightLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.E) * 1.4F * limbSwingAmount);
		this.MiddleLeftLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);

		this.FrontLeftLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.E) * 1.4F * limbSwingAmount);
		this.BackLeftLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		LeftClaw.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		RightClaw.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}