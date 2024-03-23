package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.base.EntityCadillion;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelCadillion extends EntityModel<EntityCadillion> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("cadillion");
	public final ModelPart Body, Head, RightEar, LeftEar, FrontRightLeg, FrontLeftLeg, BackRightLeg, BackLeftLeg;
	public ModelCadillion(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		Body = root.getChild("Body");
		Head = Body.getChild("Head");
		RightEar = Head.getChild("RightEar");
		LeftEar = Head.getChild("LeftEar");
		FrontRightLeg = root.getChild("FrontRightLeg");
		FrontLeftLeg = root.getChild("FrontLeftLeg");
		BackRightLeg = root.getChild("BackRightLeg");
		BackLeftLeg = root.getChild("BackLeftLeg");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 31).addBox(-4, -4.5F, -8.75F, 8, 8, 17, cubeDef)
		.texOffs(0, 0).addBox(-5.5F, -5.5F, -9.25F, 11, 12, 19, cubeDef), PartPose.offset(0, 9.5F, .75F));
		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(33, 33).addBox(-4, -5.8F, -5.7F, 8, 8, 6, cubeDef)
		.texOffs(54, 12).addBox(-3, -2.8F, -8.7F, 6, 4, 3, cubeDef), PartPose.offset(0, -3.7F, -9.04F));
		Head.addOrReplaceChild("Horn_r1", CubeListBuilder.create().texOffs(14, 56).addBox(-1, -7.5F, -1, 2, 7, 2, cubeDef), PartPose.offsetAndRotation(0, -3.7528F, -4.4743F, .3927F, 0, 0));
		Head.addOrReplaceChild("RightEar", CubeListBuilder.create().texOffs(55, 31).addBox(-5.5F, -6.47F, 1, 6, 7, 0, cubeDef)
		.texOffs(38, 56).addBox(-5.5F, -6.47F, .99F, 6, 7, 0, cubeDef), PartPose.offsetAndRotation(-2.5F, -2.8F, -1.7F, 0, 0, -.1309F));
		Head.addOrReplaceChild("LeftEar", CubeListBuilder.create().texOffs(1, 56).addBox(-.5F, -7, 1, 6, 7, 0, cubeDef)
		.texOffs(22, 56).addBox(-.5F, -7, .99F, 6, 7, 0, cubeDef), PartPose.offsetAndRotation(2.5F, -2.8F, -1.7F, 0, 0, .1309F));
		Head.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(0, 15).addBox(-3, -.5F, -1.5F, 6, 1, 3, cubeDef), PartPose.offset(0, 1.7F, -7.2F));
		partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(50, 50).addBox(-2, 0, -2, 4, 11, 4, cubeDef), PartPose.offset(-3, 12.99F, -6.01F));
		partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(41, 0).addBox(-2, 0, -2, 4, 11, 4, cubeDef), PartPose.offset(3, 12.99F, -6.01F));
		partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-2, 0, -2, 4, 11, 4, cubeDef), PartPose.offset(-3, 12.99F, 8));
		partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(0, 31).addBox(-2, 0, -2, 4, 11, 4, cubeDef), PartPose.offset(3, 12.99F, 8));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	@Override public void setupAnim(EntityCadillion entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		Head.yRot = netHeadYaw * Mth.DEG_TO_RAD;
        Head.xRot = headPitch * Mth.DEG_TO_RAD;
		float f = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
		float f1 = Mth.cos(limbSwing * .6662F + Mth.PI) * 1.4F * limbSwingAmount;
		float f2 = Mth.PI / 16 + Mth.cos(ageInTicks * .06F + limbSwing * .05F) * .08F + limbSwingAmount * .2F;
		Body.zRot = f * .05F;
		RightEar.yRot = -f2;
		LeftEar.yRot = f2;
		BackRightLeg.xRot = FrontLeftLeg.xRot = f;
		BackLeftLeg.xRot = FrontRightLeg.xRot = f1;
    }
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}