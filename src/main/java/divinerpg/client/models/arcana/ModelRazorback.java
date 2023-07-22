package divinerpg.client.models.arcana;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.arcana.EntityRazorback;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelRazorback extends EntityModel<EntityRazorback> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("razorback");
	private final ModelPart spine, Body, rightFrontLeg, rightRearLeg, leftFrontLeg, leftRearLeg;

	public ModelRazorback(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.spine = root.getChild("spine");
		this.Body = root.getChild("Body");
		this.rightFrontLeg = root.getChild("FrontRightLeg");
		this.rightRearLeg = root.getChild("BackRightLeg");
		this.leftFrontLeg = root.getChild("FrontLeftLeg");
		this.leftRearLeg = root.getChild("BackLeftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition spine = partdefinition.addOrReplaceChild("spine", CubeListBuilder.create(), PartPose.offset(0.0F, 21.0F, 1.0F));

		PartDefinition skull = spine.addOrReplaceChild("skull", CubeListBuilder.create().texOffs(13, 23).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(24, 13).addBox(-3.0F, -4.0F, -3.0F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -4.0F));

		PartDefinition Tail = spine.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(26, 6).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(26, 0).addBox(-4.0F, -0.01F, 0.0F, 8.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 4.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -5.0F, -3.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(24, 18).addBox(-4.0F, -7.0F, 1.0F, 8.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 13).addBox(-4.0F, -7.0F, -3.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(8, 26).addBox(0.0F, -11.0F, 0.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 30).addBox(2.0F, -8.0F, -2.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 30).addBox(-3.0F, -8.0F, 2.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 30).addBox(2.0F, -9.0F, 2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 30).addBox(-3.0F, -9.0F, -2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 15).addBox(0.0F, -8.0F, -4.0F, 0.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(28, 15).addBox(0.01F, -8.0F, -4.0F, 0.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.0F, 0.0F));

		PartDefinition FrontRightLeg = partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(0, 13).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 21.0F, -1.0F));

		PartDefinition FrontLeftLeg = partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(29, 29).addBox(0.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 21.0F, -1.0F));

		PartDefinition BackRightLeg = partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 21.0F, 4.0F));

		PartDefinition BackLeftLeg = partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(0, 26).addBox(8.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 21.0F, 4.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(EntityRazorback entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.rightFrontLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
		this.leftFrontLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
		this.rightRearLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
		this.leftRearLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		spine.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightFrontLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightRearLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftFrontLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftRearLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}