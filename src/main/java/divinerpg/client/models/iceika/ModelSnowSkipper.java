package divinerpg.client.models.iceika;

import static divinerpg.util.ClientUtils.createLocation;

import com.mojang.blaze3d.vertex.*;

import divinerpg.entities.iceika.EntitySnowSkipper;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

public class ModelSnowSkipper extends EntityModel<EntitySnowSkipper> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("snow_skipper");
	final ModelPart head, body;
	public ModelSnowSkipper(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		head = root.getChild("Head");
		body = root.getChild("Body");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(12, 9).addBox(-1.0F, -1.5F, -4.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, -2.0F));

		Head.addOrReplaceChild("LeftWhisker", CubeListBuilder.create().texOffs(0, 4).addBox(0.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.0F, -4.0F, 0.0F, -0.6981F, -0.2182F));

		Head.addOrReplaceChild("RightWhisker", CubeListBuilder.create().texOffs(0, 3).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.0F, -4.0F, 0.0F, 0.6981F, 0.2182F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(13, 0).addBox(0.0F, -3.0F, 3.3F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, -3.0F));

		Body.addOrReplaceChild("leftsail_r1", CubeListBuilder.create().texOffs(8, 6).addBox(0.0F, -3.5F, -0.5F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -0.5F, 0.8F, 0.0F, 0.0F, 0.3054F));

		Body.addOrReplaceChild("rightsail_r1", CubeListBuilder.create().texOffs(8, 6).addBox(0.0F, -3.5F, -0.5F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -0.5F, 0.8F, 0.0F, 0.0F, -0.3054F));

		Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 9).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 5.0F));

		Body.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(13, 0).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 3.0F, 0.5F));

		Body.addOrReplaceChild("MiddleRightLeg", CubeListBuilder.create().texOffs(0, 9).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 3.0F, 2.5F));

		Body.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 3.0F, 4.5F));

		Body.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(0, 17).addBox(0.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 3.0F, 0.5F));

		Body.addOrReplaceChild("MiddleLeftLeg", CubeListBuilder.create().texOffs(11, 16).addBox(0.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 3.0F, 2.5F));

		Body.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(15, 16).addBox(0.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 3.0F, 4.5F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}
	@Override
	public void setupAnim(EntitySnowSkipper entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}