package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.iceika.EntitySeng;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelSeng extends EntityModel<EntitySeng> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("seng");
	public final ModelPart seng, tail, head, backRightLeg, frontRightLeg, frontLeftLeg, backLeftLeg;
	public ModelSeng(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		seng = root.getChild("seng");
		tail = seng.getChild("tail");
		head = seng.getChild("head");
		frontRightLeg = root.getChild("frontRightLeg");
		frontLeftLeg = root.getChild("frontLeftLeg");
		backRightLeg = root.getChild("backRightLeg");
		backLeftLeg = root.getChild("backLeftLeg");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		PartDefinition Seng = partdefinition.addOrReplaceChild("seng", CubeListBuilder.create(), PartPose.offset(0, 14, 0));
		Seng.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(52, 20).addBox(-4, 1, -4, 2, 2, 4, cubeDef)
		.texOffs(52, 20).addBox(2, 1, -4, 2, 2, 4, cubeDef)
		.texOffs(0, 0).addBox(-4, -7, -10, 8, 8, 18, cubeDef), PartPose.offset(0, 2, 1));
		PartDefinition Tail = Seng.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0, -4, 10));
		PartDefinition TailSeg1 = Tail.addOrReplaceChild("TailSeg1", CubeListBuilder.create().texOffs(44, 26).addBox(-2, -1, -2, 4, 3, 4, cubeDef), PartPose.ZERO);
		PartDefinition TailSeg2 = TailSeg1.addOrReplaceChild("TailSeg2", CubeListBuilder.create().texOffs(44, 33).addBox(-1, -1.5F, 0, 2, 3, 4, cubeDef), PartPose.offset(0, .5F, 2));
		PartDefinition TailSeg3 = TailSeg2.addOrReplaceChild("TailSeg3", CubeListBuilder.create().texOffs(46, 0).addBox(-1, -1, 0, 2, 2, 4, cubeDef), PartPose.offset(0, .5F, 4));
		TailSeg3.addOrReplaceChild("TailClub", CubeListBuilder.create().texOffs(34, 0).addBox(0, -3, 4, 0, 6, 8, cubeDef)
		.texOffs(26, 0).addBox(-3, 0, 4, 6, 0, 8, cubeDef)
		.texOffs(38, 40).addBox(-1, -1, 4, 2, 2, 6, cubeDef), PartPose.ZERO);
		Seng.addOrReplaceChild("head", CubeListBuilder.create().texOffs(50, 48).addBox(-3, -1, -6.5F, 6, 3, 1, cubeDef)
		.texOffs(32, 46).addBox(-4, -7, -3, 1, 2, 3, cubeDef) //Right Ear
		.texOffs(47, 11).addBox(3, -7, -3, 1, 2, 3, cubeDef) //Left Ear
		.texOffs(32, 52).addBox(-4.5F, -6, -7, 9, 6, 6, cubeDef) //Mane
		.texOffs(0, 26).addBox(-4, -5, -6, 8, 7, 6, cubeDef)
		.texOffs(0, 59).addBox(-4, 2, -6, 8, 2, 3, cubeDef), PartPose.offset(0, 1.01F, -9));
		partdefinition.addOrReplaceChild("frontRightLeg", CubeListBuilder.create().texOffs(0, 39).addBox(-2, -3, -2, 4, 16, 4, cubeDef), PartPose.offset(-3, 11, -5));
		partdefinition.addOrReplaceChild("backRightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-2, 0, -2, 4, 12, 4, cubeDef), PartPose.offset(-3, 12, 8));
		partdefinition.addOrReplaceChild("frontLeftLeg", CubeListBuilder.create().texOffs(28, 26).addBox(-2, -3, -2, 4, 16, 4, cubeDef), PartPose.offset(3, 11, -5));
		partdefinition.addOrReplaceChild("backLeftLeg", CubeListBuilder.create().texOffs(16, 42).addBox(-2, 0, -2, 4, 12, 4, cubeDef), PartPose.offset(3, 12, 8));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	@Override public void setupAnim(EntitySeng entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		head.yRot = netHeadYaw * Mth.DEG_TO_RAD;
		head.xRot = headPitch * Mth.DEG_TO_RAD;
		tail.xRot = Mth.PI / 4;
		tail.yRot = Mth.cos(ageInTicks * .6662F) * 1.4F * limbSwingAmount;
		float f = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
		float f1 = Mth.cos(limbSwing * .6662F + Mth.PI) * 1.4F * limbSwingAmount;
		seng.zRot = f * .05F;
		frontRightLeg.xRot = backLeftLeg.xRot = f1;
		backRightLeg.xRot = frontLeftLeg.xRot = f;
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		seng.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		frontRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		backRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		frontLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		backLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}