package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelCaveCrawler extends EntityModel<EntityCrawler> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("cave_crawler");
	private final ModelPart spine, leftArm, rightArm;
	public ModelCaveCrawler(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.spine = root.getChild("spine");
		this.leftArm = root.getChild("leftfullarm");
		this.rightArm = root.getChild("rightfullarm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition spine = partdefinition.addOrReplaceChild("spine", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 6.0F, 0.829F, 0.0F, 0.0F));

		spine.addOrReplaceChild("trail_r1", CubeListBuilder.create().texOffs(20, 54).addBox(-3.5F, -1.0F, -2.0F, 9.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.5F, 0.2618F, 0.0F, 0.0F));

		spine.addOrReplaceChild("skull", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(32, 3).addBox(-3.99F, -12.0F, -2.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(32, 7).addBox(-4.0F, -12.0F, -2.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(37, 3).addBox(3.99F, -12.0F, -2.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(37, 7).addBox(4.0F, -12.0F, -2.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, 1.0F, -0.829F, 0.0F, 0.0F));

		spine.addOrReplaceChild("jug", CubeListBuilder.create().texOffs(0, 40).addBox(-3.0F, -9.0F, 0.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(24, 47).addBox(-2.0F, -10.0F, 1.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(24, 40).addBox(-3.0F, -11.0F, 0.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.0F));

		partdefinition.addOrReplaceChild("leftfullarm", CubeListBuilder.create().texOffs(20, 28).addBox(0.0F, -2.0F, -6.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 32).addBox(0.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 17.0F, -1.0F, 0.0F, 0.0F, 0F));

		partdefinition.addOrReplaceChild("rightfullarm", CubeListBuilder.create().texOffs(24, 0).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(24, 16).addBox(-4.0F, -2.0F, -6.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 17.0F, -1.0F, 0.0F, 0.0F, 0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(EntityCrawler entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leftArm.xRot = 0.1963F + (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
		this.rightArm.xRot = 0.1963F + (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		spine.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}