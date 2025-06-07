package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.base.EntityDivineTameable;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelHellPig extends EntityModel<EntityDivineTameable> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("hell_pig");
	public final ModelPart Body, Head, LeftEar, RightEar, BackRightLeg, BackLeftLeg, FrontRightLeg, FrontLeftLeg;
	public ModelHellPig(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		Body = root.getChild("Body");
		Head = Body.getChild("Head");
		LeftEar = Head.getChild("LeftEar");
		RightEar = Head.getChild("RightEar");
		BackRightLeg = root.getChild("BackRightLeg");
		BackLeftLeg = root.getChild("BackLeftLeg");
		FrontRightLeg = root.getChild("FrontRightLeg");
		FrontLeftLeg = root.getChild("FrontLeftLeg");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 50).addBox(-8, -3, 1.99F, 10, 8, 0, cubeDef) //Collar
		.texOffs(0, 0).addBox(-8, -3, 2, 10, 9, 14, cubeDef), PartPose.offset(3, 9, -9));
		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 23).addBox(-4, -5, -6, 8, 8, 6, cubeDef)
		.texOffs(12, 37).addBox(-2.5F, -1, -6.99F, 5, 3, 1, cubeDef) //Snout
		.texOffs(-1, 52).addBox(0, -10, -7, 0, 5, 7, cubeDef), PartPose.offset(-3, .5F, 2.01F)); //Crest
		Head.addOrReplaceChild("RightEar", CubeListBuilder.create().texOffs(0, 0).addBox(-1, 0, -2, 1, 7, 4, cubeDef), PartPose.offset(-4, -3, -3));
		Head.addOrReplaceChild("LeftEar", CubeListBuilder.create().texOffs(40, 32).addBox(0, 0, -2, 1, 7, 4, cubeDef), PartPose.offset(4, -3, -3));
		partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(28, 23).addBox(-2, 0, -2, 4, 9, 4, cubeDef), PartPose.offset(-2.99F, 14.99F, 4.99F));
		partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(34, 0).addBox(-2, 0, -2, 4, 9, 4, cubeDef), PartPose.offset(2.99F, 14.99F, 4.99F));
		partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(0, 37).addBox(-2, 0, -2, 4, 9, 4, cubeDef), PartPose.offset(-2.99F, 14.99F, -4.99F));
		partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(24, 36).addBox(-2, 0, -2, 4, 9, 4, cubeDef), PartPose.offset(2.99F, 14.99F, -4.99F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	@Override public void setupAnim(EntityDivineTameable entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		//TODO: to add sitting animation
		Head.xRot = headPitch * Mth.DEG_TO_RAD;
		Head.yRot = netHeadYaw * Mth.DEG_TO_RAD;
		float f1 = ageInTicks * .1F + limbSwing * .5F;
		float f2 = .08F + limbSwingAmount * .4F;
		RightEar.zRot = Mth.PI / 12 + Mth.cos(f1) * f2;
		LeftEar.zRot = -Mth.PI / 12 - Mth.cos(f1 * 1.2F) * f2;
		float f3 = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
		float f4 = Mth.cos(limbSwing * .6662F + Mth.PI) * 1.4F * limbSwingAmount;
		Body.zRot = f3 * .04F;
		BackRightLeg.xRot = FrontLeftLeg.xRot = f3;
		BackLeftLeg.xRot = FrontRightLeg.xRot = f4;
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		BackRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		BackLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		FrontRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		FrontLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}