package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.wildwood.EntityMoonWolf;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelMoonWolf extends EntityModel<EntityMoonWolf> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("moon_wolf");
	public final ModelPart Body, Head, BackRightLeg, BackLeftLeg, FrontRightLeg, FrontLeftLeg, Tail;
	public ModelMoonWolf(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		Body = root.getChild("Body");
		Head = root.getChild("Head");
		BackRightLeg = root.getChild("BackRightLeg");
		BackLeftLeg = root.getChild("BackLeftLeg");
		FrontRightLeg = root.getChild("FrontRightLeg");
		FrontLeftLeg = root.getChild("FrontLeftLeg");
		Tail = root.getChild("Tail");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		PartPose zPose = PartPose.ZERO;
		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), zPose);
		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(), zPose);
		Head.addOrReplaceChild("RightEar_r1", CubeListBuilder.create().texOffs(0, 18).addBox(-2, -5, -1.5F, 2, 4, 1, cubeDef), PartPose.offsetAndRotation(-1, -3, -1.5F, .1745F, .5236F, 0));
		Head.addOrReplaceChild("LeftEar_r1", CubeListBuilder.create().texOffs(13, 18).addBox(0, -5, -1.5F, 2, 4, 1, cubeDef), PartPose.offsetAndRotation(1, -3, -1.5F, .1745F, -.5236F, 0));
		Head.addOrReplaceChild("HeadBase_r1", CubeListBuilder.create().texOffs(0, 18).addBox(-1.5F, -3, -3.5F, 3, 6, 7, cubeDef), PartPose.offsetAndRotation(0, -1, -4.5F, .3491F, 0, 0));
		Head.addOrReplaceChild("Hair_r1", CubeListBuilder.create().texOffs(0, 31).addBox(-2, -20.5F, -1, 4, 4, 6, cubeDef), PartPose.offsetAndRotation(0, 14, 5, .3491F, 0, 0));
		Body.addOrReplaceChild("BodyBase", CubeListBuilder.create().texOffs(0, 44).addBox(-3, -6, -6.01F, 6, 6, 0, cubeDef)
		.texOffs(0, 0).addBox(-3, -6, -6, 6, 6, 12, cubeDef), zPose);
		partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1, 0, -1, 2, 9, 2, cubeDef), zPose);
		partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(20, 18).addBox(-1, 0, -1, 2, 9, 2, cubeDef), zPose);
		partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(24, 0).addBox(-1, 0, -1, 2, 9, 2, cubeDef), zPose);
		partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(26, 27).addBox(-1, 0, -1, 2, 9, 2, cubeDef), zPose);
		PartDefinition Tail = partdefinition.addOrReplaceChild("Tail", CubeListBuilder.create(), zPose);
		PartDefinition LeftTail = Tail.addOrReplaceChild("LeftTail", CubeListBuilder.create(), PartPose.offset(0, 1, 2));
		LeftTail.addOrReplaceChild("LeftTail_r1", CubeListBuilder.create().texOffs(48, -8).addBox(1, -7, -1, 0, 8, 8, cubeDef), PartPose.rotation(.384F, .2007F, .1658F));
		PartDefinition RightTail = Tail.addOrReplaceChild("RightTail", CubeListBuilder.create(), PartPose.offset(0, 1, 2));
		RightTail.addOrReplaceChild("RightTail_r1", CubeListBuilder.create().texOffs(48, 2).addBox(-1, -7, -1, 0, 8, 8, cubeDef), PartPose.rotation(.384F, -.2007F, -.1658F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	@Override public void prepareMobModel(EntityMoonWolf entity, float limbSwing, float limbSwingAmount, float p_102617_) {
		Head.zRot = entity.getHeadRollAngle(p_102617_) + entity.getBodyRollAngle(p_102617_, 0);
		Body.zRot = entity.getBodyRollAngle(p_102617_, -.16F);
		Tail.zRot = entity.getBodyRollAngle(p_102617_, -.2F);
	}
	@Override public void setupAnim(EntityMoonWolf entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
		float f1 = Mth.cos(limbSwing * .6662F + Mth.PI) * 1.4F * limbSwingAmount;
		Head.xRot = headPitch * Mth.DEG_TO_RAD;
		Head.yRot = netHeadYaw * Mth.DEG_TO_RAD;
		if(entity.isAngry()) Tail.yRot = 0;
		else Tail.yRot = f;
		if(entity.isInSittingPose()) {
			Head.setPos(0, 12, -2);
			Body.setPos(0, 20, -2);
			Body.xRot = -Mth.PI / 4;
			Tail.setPos(0, 21, 6);
			BackRightLeg.setPos(-1.99F, 23, 2);
			BackLeftLeg.setPos(1.99F, 23, 2);
			BackRightLeg.xRot = BackLeftLeg.xRot = Mth.PI * 1.5F;
			FrontRightLeg.setPos(-1.9375F, 15, -4);
			FrontLeftLeg.setPos(1.9375F, 15, -4);
			FrontRightLeg.xRot = FrontLeftLeg.xRot = Mth.PI * 1.85F;
		} else {
			Head.setPos(0, 11, -5);
			Body.setPos(0, 15, 0);
			Body.xRot = 0;
			Tail.setPos(0, 10, 6);
			BackRightLeg.setPos(-2, 15, 5);
			BackLeftLeg.setPos(2, 15, 5);
			FrontRightLeg.setPos(-2, 15, -5);
			FrontLeftLeg.setPos(2, 15, -5);
			BackRightLeg.xRot = FrontLeftLeg.xRot = f;
			BackLeftLeg.xRot = FrontRightLeg.xRot = f1;
		}
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}