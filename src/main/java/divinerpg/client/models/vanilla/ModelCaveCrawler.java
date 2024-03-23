package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntityCrawler;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelCaveCrawler extends EntityModel<EntityCrawler> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("cave_crawler");
	public final ModelPart spine, rightArm, leftArm;
	public ModelCaveCrawler(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		spine = root.getChild("spine");
		rightArm = spine.getChild("rightfullarm");
		leftArm = spine.getChild("leftfullarm");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		PartDefinition spine = partdefinition.addOrReplaceChild("spine", CubeListBuilder.create().texOffs(0, 16).addBox(-4, -12, -2, 8, 12, 4, cubeDef), PartPose.offsetAndRotation(0, 24, 6,.829F, 0, 0));
		spine.addOrReplaceChild("trail_r1", CubeListBuilder.create().texOffs(20, 54).addBox(-3.5F, -1, -2, 9, 6, 4, cubeDef), PartPose.offsetAndRotation(-1, 0,.5F,.2618F, 0, 0));
		spine.addOrReplaceChild("skull", CubeListBuilder.create().texOffs(0, 0).addBox(-4, -8, -5, 8, 8, 8, cubeDef)
		.texOffs(32, 3).addBox(-3.99F, -12, -2, 0, 4, 5, cubeDef)
		.texOffs(32, 7).addBox(-4, -12, -2, 0, 4, 5, cubeDef)
		.texOffs(37, 3).addBox(3.99F, -12, -2, 0, 4, 5, cubeDef)
		.texOffs(37, 7).addBox(4, -12, -2, 0, 4, 5, cubeDef), PartPose.offsetAndRotation(0, -12, 1, -.829F, 0, 0));
		spine.addOrReplaceChild("jug", CubeListBuilder.create().texOffs(0, 40).addBox(-3, -9, 0, 6, 7, 6, cubeDef)
		.texOffs(24, 47).addBox(-2, -10, 1, 4, 1, 4, cubeDef)
		.texOffs(24, 40).addBox(-3, -11, 0, 6, 1, 6, cubeDef), PartPose.offset(0, 0, 2));
		spine.addOrReplaceChild("rightfullarm", CubeListBuilder.create().texOffs(24, 0).addBox(-4, -2, -2, 4, 4, 4, cubeDef)
		.texOffs(24, 16).addBox(-4, -2, -6, 4, 8, 4, cubeDef), PartPose.offset(-3.99F, -10, 0));
		spine.addOrReplaceChild("leftfullarm", CubeListBuilder.create().texOffs(20, 28).addBox(0, -2, -6, 4, 8, 4, cubeDef)
		.texOffs(0, 32).addBox(0, -2, -2, 4, 4, 4, cubeDef), PartPose.offset(3.99F, -10, 0));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	@Override public void setupAnim(EntityCrawler entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = Mth.cos(limbSwing *.6662F) * 1.4F * limbSwingAmount;
		float f1 = Mth.cos(limbSwing *.6662F + Mth.PI) * 1.4F * limbSwingAmount;
		spine.zRot = f * .05F;
		rightArm.xRot = f1 - .6327F;
		leftArm.xRot = f - .6327F;
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {spine.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);}
}