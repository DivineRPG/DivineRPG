package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.iceika.EntityRobbin;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelRobbin extends EntityModel<EntityRobbin> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("robbin");
	public final ModelPart body, tail, head, leftWing, rightWing, leftLeg, rightLeg;
	public ModelRobbin(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		head = root.getChild("head");
		body = root.getChild("body");
		tail = root.getChild("tail");
		leftWing = root.getChild("left_wing");
		rightWing = root.getChild("right_wing");
		leftLeg = root.getChild("left_leg");
		rightLeg = root.getChild("right_leg");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2, -4, -4, 4, 4, 4, cubeDef), PartPose.offsetAndRotation(0, 22, 1, -.2618F, 0, 0));
		partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 17).addBox(-1, -2, 0, 2, 2, 3, cubeDef), PartPose.offset(0, 18.3F, 1.6F));
		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 8).addBox(-2, 5.5F, .5F, 1, 1, 2, cubeDef)
		.texOffs(11, 14).addBox(-1.5F, 6.5F, -1.5F, 3, 3, 3, cubeDef)
		.texOffs(8, 11).addBox(-1, 8, -2.5F, 2, 1, 2, cubeDef)
		.texOffs(0, 11).addBox(1, 5.5F, .5F, 1, 1, 2, cubeDef), PartPose.offset(0, 8.5F, -2.5F));
		partdefinition.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(0, 24).addBox(-1, 0, 0, 1, 3, 5, cubeDef), PartPose.offset(-2, 18, -2));
		partdefinition.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(20, 24).addBox(0, 0, 0, 1, 3, 5, cubeDef), PartPose.offset(2, 18, -2));
		partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(18, 0).addBox(-2, 0, -2, 2, 3, 2, cubeDef), PartPose.offset(0, 21, 0));
		partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(8, 20).addBox(0, 0, -2, 2, 3, 2, cubeDef), PartPose.offset(0, 21, 0));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}
	@Override public void setupAnim(EntityRobbin entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		head.xRot = headPitch * Mth.DEG_TO_RAD / 2;
		head.yRot = netHeadYaw * Mth.DEG_TO_RAD;
		float f = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
		tail.xRot = f * .35F + .2618F;
		if(!entity.onGround()) {
			float f1 = Mth.cos(ageInTicks * 80 * Mth.DEG_TO_RAD) / 1.5F - Mth.PI / 6;
			rightWing.yRot = f1;
			leftWing.yRot = -f1;
			rightLeg.xRot = leftLeg.xRot = tail.yRot = 0;
		} else {
			tail.yRot = f * .4F;
			rightWing.yRot = leftWing.yRot = 0;
			rightLeg.xRot = f;
			leftLeg.xRot = Mth.cos(limbSwing * .6662F + Mth.PI) * 1.4F * limbSwingAmount;
		}
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}