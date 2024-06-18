package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.iceika.EntityFrozenFlesh;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelFrozenFlesh extends EntityModel<EntityFrozenFlesh> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("frozen_flesh");
	public final ModelPart head, torso, base;
	public ModelFrozenFlesh(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		head = root.getChild("head");
		torso = root.getChild("torso");
		base = root.getChild("base");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 20).addBox(-4.5F, -8, -4.5F, 9, 8, 9, cubeDef), PartPose.offset(0, 2.02F, .5F));
		PartDefinition torso = partdefinition.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(29, 30).addBox(-4, -9, -3, 8, 11, 7, cubeDef), PartPose.offset(0, 11.01F, 0));
		torso.addOrReplaceChild("right_shoulder", CubeListBuilder.create().texOffs(0, 37).addBox(-1, -3, -2, 1, 5, 5, cubeDef), PartPose.offsetAndRotation(-4, -6, 0, 0, 0, -.5236F));
		torso.addOrReplaceChild("left_shoulder", CubeListBuilder.create().texOffs(12, 37).addBox(0, -3, -2, 1, 5, 5, cubeDef), PartPose.offsetAndRotation(4, -6, 0, 0, 0, .5236F));
		torso.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(27, 24).addBox(-8, -1.5F, -1, 8, 2, 2, cubeDef), PartPose.offsetAndRotation(-3, -6, 0, 0, 0, -.4363F));
		torso.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(27, 20).addBox(0, -1.5F, -1, 8, 2, 2, cubeDef), PartPose.offsetAndRotation(3, -6, 0, 0, 0, .4363F));
		partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 0).addBox(-5, 0, -4.5F, 10, 11, 9, cubeDef), PartPose.offset(0, 13, .5F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	@Override public void setupAnim(EntityFrozenFlesh entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		head.yRot = netHeadYaw * Mth.DEG_TO_RAD;
		head.xRot = headPitch * Mth.DEG_TO_RAD;
		float f = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
		torso.yRot = f * .15F;
		base.yRot = -f * .15F;
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}