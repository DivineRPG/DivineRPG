package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntityCrab;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelCrab extends EntityModel<EntityCrab> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("crab");
	public final ModelPart Body, RightClaw, LeftClaw, BackRightLeg, BackLeftLeg, MiddleRightLeg, MiddleLeftLeg, FrontRightLeg, FrontLeftLeg;
	public ModelCrab(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		Body = root.getChild("Body");
		RightClaw = Body.getChild("RightClaw");
		LeftClaw = Body.getChild("LeftClaw");
		BackRightLeg = Body.getChild("BackRightLeg");
		BackLeftLeg = Body.getChild("BackLeftLeg");
		MiddleRightLeg = Body.getChild("MiddleRightLeg");
		MiddleLeftLeg = Body.getChild("MiddleLeftLeg");
		FrontRightLeg = Body.getChild("FrontRightLeg");
		FrontLeftLeg = Body.getChild("FrontLeftLeg");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-6, -3, -6, 12, 6, 12, cubeDef), PartPose.offset(0, 18, 2));
		Body.addOrReplaceChild("RightClaw", CubeListBuilder.create().texOffs(0, 18).addBox(-4, -2, -6, 4, 5, 6, cubeDef), PartPose.offset(-6, 1, -4));
		Body.addOrReplaceChild("LeftClaw", CubeListBuilder.create().texOffs(20, 20).addBox(0, -2, -6, 4, 5, 6, cubeDef), PartPose.offset(6, 1, -4));
		Body.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(16, 31).addBox(-2, 0, -1, 2, 4, 2, cubeDef), PartPose.offset(-5.99F, 2, 5.01F));
		Body.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(0, 0).addBox(0, 0, -1, 2, 4, 2, cubeDef), PartPose.offset(5.99F, 2, 5.01F));
		Body.addOrReplaceChild("MiddleRightLeg", CubeListBuilder.create().texOffs(8, 29).addBox(-2, 0, -1, 2, 4, 2, cubeDef), PartPose.offset(-5.99F, 2, 2));
		Body.addOrReplaceChild("MiddleLeftLeg", CubeListBuilder.create().texOffs(0, 6).addBox(0, 0, -1, 2, 4, 2, cubeDef), PartPose.offset(5.99F, 2, 2));
		Body.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(0, 29).addBox(-2, 0, -1, 2, 4, 2, cubeDef), PartPose.offset(-5.99F, 2, -1));
		Body.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(14, 18).addBox(0, 0, -1, 2, 4, 2, cubeDef), PartPose.offset(5.99F, 2, -1));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	@Override public void setupAnim(EntityCrab entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
		float f1 = Mth.cos(limbSwing * .6662F + (float)Math.E) * 1.4F * limbSwingAmount;
		float f2 = Mth.PI / 16 + Mth.cos(ageInTicks * .05F + limbSwing * .5F) * (.08F + limbSwingAmount * .1F);
		RightClaw.zRot = -f2;
		LeftClaw.zRot = f2;
		Body.zRot = f * .03F;
		FrontLeftLeg.xRot = MiddleRightLeg.xRot = BackRightLeg.xRot = f;
		FrontRightLeg.xRot = MiddleLeftLeg.xRot = BackLeftLeg.xRot = f1;
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);}
}