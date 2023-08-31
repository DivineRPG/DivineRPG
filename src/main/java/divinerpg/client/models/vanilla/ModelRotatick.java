package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntityRotatick;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelRotatick extends EntityModel<EntityRotatick> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("rotatick");
	private final ModelPart Head, Body, BackLeftLeg, BackRightLeg, MiddleLeftLeg, MiddleRightLeg, FrontLeftLeg, FrontRightLeg;

	public ModelRotatick(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		ModelPart body = root.getChild("Body");
		this.Head = root.getChild("Head");
		this.Body = body;
		this.BackLeftLeg = body.getChild("BackLeftLeg");
		this.BackRightLeg = body.getChild("BackRightLeg");
		this.MiddleLeftLeg = body.getChild("MiddleLeftLeg");
		this.MiddleRightLeg = body.getChild("MiddleRightLeg");
		this.FrontLeftLeg = body.getChild("FrontLeftLeg");
		this.FrontRightLeg = body.getChild("FrontRightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(38, 38).addBox(-5.0F, -2.0F, -6.0F, 10.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 36).addBox(-6.0F, -5.0F, -7.0F, 12.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(38, 25).addBox(-3.0F, -1.0F, -7.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, -5.0F));

		Head.addOrReplaceChild("RightMandible", CubeListBuilder.create().texOffs(42, 7).addBox(-0.5F, -1.5F, -3.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.5F, 2.5F, -5.0F));

		Head.addOrReplaceChild("LeftMandible", CubeListBuilder.create().texOffs(42, 0).addBox(-1.0F, -1.0F, -3.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 2.0F, -5.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -4.0F, -7.0F, 14.0F, 4.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(0, 18).addBox(-6.0F, 0.0F, -7.0F, 12.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 2.0F));

		Body.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(0, 25).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(5.5F, 4.0F, 4.5F));

		Body.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(0, 18).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.5F, 4.0F, 4.5F));

		Body.addOrReplaceChild("MiddleLeftLeg", CubeListBuilder.create().texOffs(31, 36).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(5.5F, 4.0F, 0.5F));

		Body.addOrReplaceChild("MiddleRightLeg", CubeListBuilder.create().texOffs(0, 7).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.5F, 4.0F, 0.5F));

		Body.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(38, 18).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(5.5F, 4.0F, -3.5F));

		Body.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.5F, 4.0F, -3.5F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(EntityRotatick entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);

		this.BackLeftLeg.xRot = (float) Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.MiddleLeftLeg.xRot = (float) Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.FrontLeftLeg.xRot = (float) Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount;
		this.BackRightLeg.xRot = (float) Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount;
		this.MiddleRightLeg.xRot = (float) Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount;
		this.FrontRightLeg.xRot = (float) Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

		this.BackRightLeg.yRot = 0.3F;
		this.MiddleRightLeg.yRot = 0.2F;
		this.FrontRightLeg.yRot = 0.1F;
		this.BackLeftLeg.yRot = -0.3F;
		this.MiddleLeftLeg.yRot = -0.2F;
		this.FrontLeftLeg.yRot = -0.1F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, buffer, packedLight, packedOverlay);
		Body.render(poseStack, buffer, packedLight, packedOverlay);
	}
}