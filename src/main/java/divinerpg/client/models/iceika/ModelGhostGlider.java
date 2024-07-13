package divinerpg.client.models.iceika;

import static divinerpg.util.ClientUtils.createLocation;

import com.mojang.blaze3d.vertex.*;

import divinerpg.entities.base.EntityDivineWaterMob;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

public class ModelGhostGlider extends EntityModel<EntityDivineWaterMob> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("ghost_glider");
	final ModelPart body, rightWing, leftWing;
	public ModelGhostGlider(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		body = root.getChild("Body");
		rightWing = root.getChild("RightWing");
		leftWing = root.getChild("LeftWing");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -9.0F, -3.0F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition MiddleTendril = Body.addOrReplaceChild("MiddleTendril", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		MiddleTendril.addOrReplaceChild("MiddleTendril_r1", CubeListBuilder.create().texOffs(0, 22).addBox(-0.5F, -1.0F, -1.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -2.5F, -0.0436F, 0.0F, 0.0F));

		PartDefinition LeftTendril = Body.addOrReplaceChild("LeftTendril", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		LeftTendril.addOrReplaceChild("LeftTendril_r1", CubeListBuilder.create().texOffs(0, 22).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -3.0F, -3.5F, -0.0436F, 0.0F, -0.1309F));

		PartDefinition RightTendril = Body.addOrReplaceChild("RightTendril", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		RightTendril.addOrReplaceChild("RightTendril_r1", CubeListBuilder.create().texOffs(0, 22).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -3.0F, -3.5F, -0.0436F, 0.0F, 0.1309F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offset(0.0F, -8.0F, 1.5F));

		Tail.addOrReplaceChild("BackTailSegment", CubeListBuilder.create().texOffs(39, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 4.5F));

		Tail.addOrReplaceChild("MiddleTailSegment", CubeListBuilder.create().texOffs(31, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.5F));

		Tail.addOrReplaceChild("FrontTailSegment", CubeListBuilder.create().texOffs(21, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.5F));

		partdefinition.addOrReplaceChild("RightWing", CubeListBuilder.create().texOffs(15, 6).addBox(-4.5F, -0.5F, -1.5F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 14.5F, 0.5F));

		partdefinition.addOrReplaceChild("LeftWing", CubeListBuilder.create().texOffs(15, 14).addBox(-0.5F, -0.5F, -1.5F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 14.5F, 0.5F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	@Override
	public void setupAnim(EntityDivineWaterMob entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		rightWing.zRot = (float) Math.sin(10D * ageInTicks / (180D / Math.PI)) * .3F;
		leftWing.zRot = -rightWing.zRot;
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}