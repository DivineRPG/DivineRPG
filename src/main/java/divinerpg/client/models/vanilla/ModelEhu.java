package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.base.EntityDivineTameable;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelEhu extends EntityModel<EntityDivineTameable> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("ehu");
	public final ModelPart body, head, BackRightLeg, BackLeftLeg, FrontRightLeg, FrontLeftLeg;
	public ModelEhu(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		body = root.getChild("body");
		head = body.getChild("head");
		BackRightLeg = root.getChild("BackRightLeg");
		BackLeftLeg = root.getChild("BackLeftLeg");
		FrontRightLeg = root.getChild("FrontRightLeg");
		FrontLeftLeg = root.getChild("FrontLeftLeg");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 46).addBox(-5, -4, -6.01F, 10, 8, 0, cubeDef)
		.texOffs(0, 25).addBox(0, -7, -6, 0, 3, 9, cubeDef)
		.texOffs(0, 0).addBox(-5, -4, -6, 10, 8, 10, cubeDef), PartPose.ZERO);
		body.addOrReplaceChild("lowerbody", CubeListBuilder.create().texOffs(0, 18).addBox(-5.5F, -5.5F, 0, 11, 9, 7, cubeDef), PartPose.offset(0, 1, 0));
		body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(30, 0).addBox(-4, -3, -3, 8, 6, 4, cubeDef)
		.texOffs(0, 0).addBox(-1, -1, -3.5F, 2, 2, 1, cubeDef), PartPose.offset(0, 0, -5.99F));
		partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(31, 29).addBox(-2, 0, -2, 4, 7, 5, cubeDef), PartPose.offset(-4, 0, 3));
		partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(13, 34).addBox(-2, 0, -2, 4, 7, 5, cubeDef), PartPose.offset(4, 0, 3));
		partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(36, 14).addBox(-2.5F, 0, -2, 4, 6, 4, cubeDef), PartPose.offset(-3, 0, -3));
		partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(31, 41).addBox(-1.5F, 0, -2, 4, 6, 4, cubeDef), PartPose.offset(3, 0, -3));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	@Override public void setupAnim(EntityDivineTameable entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		head.xRot = headPitch * Mth.DEG_TO_RAD / 2;
		head.yRot = netHeadYaw * Mth.DEG_TO_RAD / 2;
		float f = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
		float f1 = Mth.cos(limbSwing * .6662F + Mth.PI) * 1.4F * limbSwingAmount;
		if(entity.isInSittingPose()) {
			body.y = 19.5F;
			body.zRot = 0;
			FrontLeftLeg.y = FrontRightLeg.y = 22.5F;
			BackLeftLeg.y = BackRightLeg.y = 21.99F;
			FrontLeftLeg.xRot = FrontRightLeg.xRot = BackLeftLeg.xRot = BackRightLeg.xRot = 0;
			BackRightLeg.zRot = FrontRightLeg.zRot = Mth.HALF_PI;
			BackLeftLeg.zRot = FrontLeftLeg.zRot = -Mth.HALF_PI;
		} else {
			body.y = 16;
			body.zRot = f * .05F;
			FrontLeftLeg.y = FrontRightLeg.y = BackLeftLeg.y = BackRightLeg.y = 18;
			BackRightLeg.zRot = BackLeftLeg.zRot = FrontRightLeg.zRot = FrontLeftLeg.zRot = 0;
			FrontRightLeg.xRot = BackLeftLeg.xRot = f1;
			FrontLeftLeg.xRot = BackRightLeg.xRot = f;
		}
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}