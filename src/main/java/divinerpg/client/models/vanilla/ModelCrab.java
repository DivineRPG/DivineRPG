package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntityCrab;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelCrab extends EntityModel<EntityCrab> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("crab");
	private final ModelPart Body;
	private final ModelPart BackLeftLeg;
	private final ModelPart BackRightLeg;
	private final ModelPart MiddleLeftLeg;
	private final ModelPart MiddleRightLeg;
	private final ModelPart FrontLeftLeg;
	private final ModelPart FrontRightLeg;
	private final ModelPart RightClaw;
	private final ModelPart LeftClaw;

	public ModelCrab(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Body = root.getChild("Body");
		this.BackLeftLeg = root.getChild("BackLeftLeg");
		this.BackRightLeg = root.getChild("BackRightLeg");
		this.MiddleLeftLeg = root.getChild("MiddleLeftLeg");
		this.MiddleRightLeg = root.getChild("MiddleRightLeg");
		this.FrontLeftLeg = root.getChild("FrontLeftLeg");
		this.FrontRightLeg = root.getChild("FrontRightLeg");
		this.RightClaw = root.getChild("RightClaw");
		this.LeftClaw = root.getChild("LeftClaw");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -3.0F, -6.0F, 12.0F, 6.0F, 12.0F, CubeDeformation.NONE), PartPose.offset(0.0F, 18.0F, 2.0F));

		partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE), PartPose.offset(6.0F, 20.0F, 7.0F));

		partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(16, 31).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE), PartPose.offset(-6.0F, 20.0F, 7.0F));

		partdefinition.addOrReplaceChild("MiddleLeftLeg", CubeListBuilder.create().texOffs(0, 6).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE), PartPose.offset(7.0F, 22.0F, 4.0F));

		partdefinition.addOrReplaceChild("MiddleRightLeg", CubeListBuilder.create().texOffs(8, 29).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE), PartPose.offset(-6.0F, 20.0F, 4.0F));

		partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(14, 18).addBox(0.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE), PartPose.offset(6.0F, 20.0F, 1.0F));

		partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(0, 29).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, CubeDeformation.NONE), PartPose.offset(-6.0F, 20.0F, 1.0F));

		partdefinition.addOrReplaceChild("RightClaw", CubeListBuilder.create().texOffs(0, 18).addBox(-2.0F, -2.5F, -6.0F, 4.0F, 5.0F, 6.0F, CubeDeformation.NONE), PartPose.offset(-8.0F, 19.5F, -2.0F));

		partdefinition.addOrReplaceChild("LeftClaw", CubeListBuilder.create().texOffs(20, 20).addBox(-2.0F, -2.5F, -6.0F, 4.0F, 5.0F, 6.0F, CubeDeformation.NONE), PartPose.offset(8.0F, 19.5F, -2.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(EntityCrab entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.FrontRightLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
		this.BackRightLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);

		this.MiddleRightLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.E) * 1.4F * limbSwingAmount);
		this.MiddleLeftLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.E) * 1.4F * limbSwingAmount);

		this.FrontLeftLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
		this.BackLeftLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		MiddleLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		MiddleRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightClaw.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftClaw.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}