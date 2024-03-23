package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntityRotatick;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelRotatick extends EntityModel<EntityRotatick> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("rotatick");
	public final ModelPart Body, Head, FrontRightLeg, FrontLeftLeg, MiddleRightLeg, MiddleLeftLeg, BackRightLeg, BackLeftLeg;
	public ModelRotatick(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		Body = root.getChild("Body");
		Head = Body.getChild("Head");
		FrontRightLeg = Body.getChild("FrontRightLeg");
		FrontLeftLeg = Body.getChild("FrontLeftLeg");
		MiddleRightLeg = Body.getChild("MiddleRightLeg");
		MiddleLeftLeg = Body.getChild("MiddleLeftLeg");
		BackRightLeg = Body.getChild("BackRightLeg");
		BackLeftLeg = Body.getChild("BackLeftLeg");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-7, -4, -7, 14, 4, 14, cubeDef)
		.texOffs(0, 18).addBox(-6, 0, -7, 12, 4, 14, cubeDef), PartPose.offset(0, 16, 2));
		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(38, 38).addBox(-5, -2, -6, 10, 5, 6, cubeDef)
		.texOffs(0, 36).addBox(-6, -5, -7, 12, 4, 7, cubeDef)
		.texOffs(38, 25).addBox(-3, -1, -7, 6, 4, 1, cubeDef), PartPose.offset(0, 0, -6.99F));
		Head.addOrReplaceChild("RightMandible", CubeListBuilder.create().texOffs(42, 7).addBox(-.5F, -1.5F, -3, 1, 3, 4, cubeDef), PartPose.offset(-5.5F, 2.5F, -5));
		Head.addOrReplaceChild("LeftMandible", CubeListBuilder.create().texOffs(42, 0).addBox(-1, -1, -3, 1, 3, 4, cubeDef), PartPose.offset(6, 2, -5));
		Body.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0, -1.5F, 3, 4, 3, cubeDef), PartPose.offset(-5.5F, 3.99F, -3.5F));
		Body.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(38, 18).addBox(-1.5F, 0, -1.5F, 3, 4, 3, cubeDef), PartPose.offset(5.5F, 3.99F, -3.5F));
		Body.addOrReplaceChild("MiddleRightLeg", CubeListBuilder.create().texOffs(0, 7).addBox(-1.5F, 0, -1.5F, 3, 4, 3, cubeDef), PartPose.offset(-5.5F, 3.99F, .5F));
		Body.addOrReplaceChild("MiddleLeftLeg", CubeListBuilder.create().texOffs(31, 36).addBox(-1.5F, 0, -1.5F, 3, 4, 3, cubeDef), PartPose.offset(5.5F, 3.99F, .5F));
		Body.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(0, 18).addBox(-1.5F, 0, -1.5F, 3, 4, 3, cubeDef), PartPose.offset(-5.5F, 3.99F, 4.5F));
		Body.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(0, 25).addBox(-1.5F, 0, -1.5F, 3, 4, 3, cubeDef), PartPose.offset(5.5F, 3.99F, 4.5F));
		return LayerDefinition.create(meshdefinition, 128, 64);
	}
	@Override public void setupAnim(EntityRotatick entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		Head.yRot = netHeadYaw * Mth.DEG_TO_RAD / 2;
		Head.xRot = headPitch * Mth.DEG_TO_RAD / 2;
		float f = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
		float f1 = Mth.cos(limbSwing * .6662F + Mth.PI) * 1.4F * limbSwingAmount;
		Body.zRot = f * .03F;
		FrontLeftLeg.xRot = MiddleRightLeg.xRot = BackRightLeg.xRot = f;
		FrontRightLeg.xRot = BackLeftLeg.xRot = MiddleLeftLeg.xRot = f1;
		BackRightLeg.yRot = .3F;
		MiddleRightLeg.yRot = .2F;
		FrontRightLeg.yRot = .1F;
		BackLeftLeg.yRot = -.3F;
		MiddleLeftLeg.yRot = -.2F;
		FrontLeftLeg.yRot = -.1F;
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {Body.render(poseStack, buffer, packedLight, packedOverlay);}
}