package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.eden.EntityGlinthop;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelGlinthop extends EntityModel<EntityGlinthop> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("glinthop");
	public final ModelPart Spine, Body, Head, RightEar, LeftEar, BackRightLeg, BackLeftLeg, FrontRightLeg, FrontLeftLeg, Tail;
	public ModelGlinthop(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		Spine = root.getChild("Spine");
		Body = Spine.getChild("Body");
		Head = Body.getChild("Head");
		RightEar = Head.getChild("RightEar");
		LeftEar = Head.getChild("LeftEar");
		BackRightLeg = root.getChild("BackRightLeg");
		BackLeftLeg = root.getChild("BackLeftLeg");
		FrontRightLeg = root.getChild("FrontRightLeg");
		FrontLeftLeg = root.getChild("FrontLeftLeg");
		Tail = Body.getChild("Tail");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		PartPose zPose = PartPose.ZERO;
		PartDefinition Spine = partdefinition.addOrReplaceChild("Spine", CubeListBuilder.create(), PartPose.offset(-2, 19, 1));
		PartDefinition Body = Spine.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 44).addBox(-3.5F, -5.75F, -4.01F, 7, 8, 0, cubeDef)
		.texOffs(0, 0).addBox(-2, -4.75F, -3, 4, 5, 9, cubeDef)
		.texOffs(0, 14).addBox(-3.5F, -5.75F, -4, 7, 8, 5, cubeDef), zPose);
		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 14).addBox(-.5F, 1, -4.5F, 1, 1, 1, cubeDef)
		.texOffs(20, 23).addBox(-2.5F, -2, -4, 5, 6, 4, cubeDef), zPose);
		Head.addOrReplaceChild("RightEar", CubeListBuilder.create().texOffs(22, 33).addBox(-1, -2.5F, -.75F, 2, 2, 1, cubeDef)
		.texOffs(4, 7).addBox(-2, -3.5F, .25F, 2, 2, 0, cubeDef), PartPose.offset(-2, -1.5F, -.25F));
		Head.addOrReplaceChild("LeftEar", CubeListBuilder.create().texOffs(30, 19).addBox(-1, -2.5F, -.75F, 2, 2, 1, cubeDef)
		.texOffs(0, 7).addBox(0, -3.5F, .25F, 2, 2, 0, cubeDef), PartPose.offset(2, -1.5F, -.25F));
		Head.addOrReplaceChild("RightWhisker", CubeListBuilder.create().texOffs(24, 19).addBox(-3.5F, -2, 0, 3, 4, 0, cubeDef), PartPose.offset(-1.5F, 2, -3));
		Head.addOrReplaceChild("LeftWhisker", CubeListBuilder.create().texOffs(9, 27).addBox(.5F, -2, 0, 3, 4, 0, cubeDef), PartPose.offset(1.5F, 2, -3));
		partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(21, 9).addBox(-2, -3, -2.5F, 2, 5, 5, cubeDef)
		.texOffs(14, 31).addBox(-2, 2, .5F, 2, 4, 2, cubeDef), zPose);
		partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(0, 27).addBox(0, -3, -2.5F, 2, 5, 5, cubeDef)
		.texOffs(33, 0).addBox(0, 2, .5F, 2, 4, 2, cubeDef), zPose);
		partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(31, 6).addBox(-1, -1, -1, 2, 5, 2, cubeDef), zPose);
		partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1, -1, -1, 2, 5, 2, cubeDef), zPose);
		Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(17, 0).addBox(-2, -3, -1, 4, 4, 4, cubeDef), zPose);
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	@Override public void setupAnim(EntityGlinthop entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = Mth.TWO_PI + Mth.cos(ageInTicks * .05F + limbSwing * .1F) * .05F + limbSwingAmount * .3F;
		RightEar.zRot = -f;
		LeftEar.zRot = f;
		Head.yRot = netHeadYaw * Mth.DEG_TO_RAD;
		float f1 = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
		float f2 = Mth.cos(limbSwing * .6662F + Mth.PI) * 1.4F * limbSwingAmount;
		if(entity.isAngry()) Tail.yRot = 0;
		else Tail.yRot = f1 * .25F;
		if(entity.isInSittingPose()) {
			Head.setPos(0, -3.5F, -3.5F);
			Body.setPos(2, -1.25F, -2);
			Head.xRot = headPitch * Mth.DEG_TO_RAD + Mth.PI / 6;
			Body.xRot = -Mth.PI / 4;
			Body.zRot = 0;
			Tail.setPos(0, -3.75F, 7);
			BackRightLeg.setPos(-1.01F, 21.5F, 3);
			BackLeftLeg.setPos(1.01F, 21.5F, 3);
			BackRightLeg.xRot = BackLeftLeg.xRot = Mth.PI * 1.5F;
			FrontRightLeg.setPos(-2, 20, -3);
			FrontLeftLeg.setPos(2, 20, -3);
			FrontRightLeg.xRot = FrontLeftLeg.xRot = Mth.PI * 1.85F;
		} else {
			Head.setPos(0, -4.5F, -3);
			Body.setPos(2, -1.25F, -2);
			Head.xRot = headPitch * Mth.DEG_TO_RAD;
			Body.xRot = 0;
			Body.zRot = f1 * .05F;
			Tail.setPos(0, -3.75F, 7);
			BackRightLeg.setPos(-1, 18, 3);
			BackLeftLeg.setPos(1, 18, 3);
			FrontRightLeg.setPos(-2, 20, -3);
			FrontLeftLeg.setPos(2, 20, -3);
			BackRightLeg.xRot = FrontLeftLeg.xRot = f1;
			BackLeftLeg.xRot = FrontRightLeg.xRot = f2;
		}
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Spine.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}