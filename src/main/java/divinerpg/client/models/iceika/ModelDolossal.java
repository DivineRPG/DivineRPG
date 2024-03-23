package divinerpg.client.models.iceika;

import static divinerpg.util.ClientUtils.createLocation;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.*;

import divinerpg.entities.iceika.EntityDolossal;
import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.util.Mth;

public class ModelDolossal extends AgeableListModel<EntityDolossal> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("dolossal");
	final ModelPart body, neck, head, rightLeg, leftLeg, leftWing, rightWing;
	final ModelPart[] saddleParts, ridingParts;
	public ModelDolossal(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		body = root.getChild("Body");
		neck = root.getChild("Neck");
		head = neck.getChild("Head");
		rightLeg = body.getChild("RightLeg");
		leftLeg = body.getChild("LeftLeg");
		rightWing = body.getChild("RightWing");
		leftWing = body.getChild("LeftWing");
		saddleParts = new ModelPart[]{body.getChild("saddle"), head.getChild("left_saddle_mouth"), head.getChild("right_saddle_mouth"), head.getChild("head_saddle"), head.getChild("mouth_saddle_wrap")};
		ridingParts = new ModelPart[]{neck.getChild("left_saddle_line"), neck.getChild("right_saddle_line")};
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubedef = new CubeDeformation(0F);
		PartDefinition Body = partdefinition.addOrReplaceChild(
				"Body", CubeListBuilder.create()
				.texOffs(0, 0)
				.addBox(-7.3028F, -7.0F, -4.0304F, 16.0F, 14.0F, 21.0F, cubedef),
				PartPose.offset(0.0F, 5.0F, -5.0F));
		Body.addOrReplaceChild(
				"RightLeg", CubeListBuilder.create()
				.texOffs(0, 57)
				.addBox(-6.0F, -3.0F, -4.0F, 8.0F, 7.0F, 8.0F, cubedef)
				.texOffs(59, 75)
				.addBox(-4.0F, 1.0F, -2.0F, 5.0F, 13.0F, 5.0F, cubedef), PartPose
				.offset(-3.3028F, 5.0F, 8.9696F));
		Body.addOrReplaceChild(
				"LeftLeg", CubeListBuilder.create()
				.texOffs(32, 61)
				.addBox(-2.0F, -3.0F, -4.0F, 8.0F, 7.0F, 8.0F, cubedef)
				.texOffs(0, 72)
				.addBox(-1.0F, 1.0F, -2.0F, 5.0F, 13.0F, 5.0F, cubedef), PartPose
				.offset(4.6972F, 5.0F, 8.9696F));
		Body.addOrReplaceChild(
				"Tail", CubeListBuilder.create()
				.texOffs(68, 26)
				.addBox(-3.0F, -1.0F, 0.5F, 6.0F, 2.0F, 9.0F, cubedef), PartPose
				.offsetAndRotation(0.6972F, -6.0F, 16.4696F, -0.9163F, 0.0F, 0.0F));
		Body.addOrReplaceChild("RightWing", CubeListBuilder.create().texOffs(20, 72).addBox(-3.0F, -1.5F, -1.0F, 2.0F, 7.0F, 8.0F, cubedef), PartPose.offset(-6.3028F, -5.5F, -1.0304F));
		Body.addOrReplaceChild("LeftWing", CubeListBuilder.create().texOffs(76, 37).addBox(1.0F, -1.5F, -1.0F, 2.0F, 7.0F, 8.0F, cubedef), PartPose.offsetAndRotation(7.6972F, -5.5F, -1.0304F, 0.0F, 0.0F, 0.0F));
		Body.addOrReplaceChild(
				"saddle", CubeListBuilder.create()
				.texOffs(48, 101).addBox(-5.0F, -8.0F, -9.0F, 10.0F, 9.0F, 9.0F, new CubeDeformation(0.5F)), PartPose.ZERO);
		PartDefinition Neck = partdefinition.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(40, 35).addBox(-5.0F, -17.0F, -8.0F, 10.0F, 18.0F, 8.0F, cubedef), PartPose.offset(0.0F, 6.0F, -5.0F));
		Neck.addOrReplaceChild(
				"left_saddle_line", CubeListBuilder.create()
				.texOffs(54, 103).addBox(3.1F, -6.0F, -8.0F, 0.0F, 3.0F, 16.0F), PartPose.rotation((-(float)Math.PI / 6F), 0.0F, 0.0F));
		Neck.addOrReplaceChild(
				"right_saddle_line", CubeListBuilder.create()
				.texOffs(54, 103).addBox(-3.1F, -6.0F, -8.0F, 0.0F, 3.0F, 16.0F), PartPose.rotation((-(float)Math.PI / 6F), 0.0F, 0.0F));
		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 35).addBox(-4.0F, -9.0F, -11.0F, 8.0F, 10.0F, 12.0F, cubedef)
		.texOffs(0, 0).addBox(0.0F, -15.0F, 0.0F, 0.0F, 8.0F, 10.0F, cubedef), PartPose.offset(0.0F, -13.0F, -3.0F));
		Head.addOrReplaceChild(
				"left_saddle_mouth", CubeListBuilder.create()
				.texOffs(51, 106).addBox(2.0F, -9.0F, -6.0F, 1.0F, 2.0F, 2.0F, cubedef), PartPose.ZERO);
		Head.addOrReplaceChild(
				"right_saddle_mouth", CubeListBuilder.create()
				.texOffs(51, 106).addBox(-3.0F, -9.0F, -6.0F, 1.0F, 2.0F, 2.0F, cubedef), PartPose.ZERO);
		Head.addOrReplaceChild("head_saddle", CubeListBuilder.create()
				.texOffs(23, 102).addBox(-3.0F, -11.0F, -1.9F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.22F)), PartPose.ZERO);
		Head.addOrReplaceChild(
				"mouth_saddle_wrap", CubeListBuilder.create()
				.texOffs(41, 101).addBox(-2.0F, -11.0F, -4.0F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.ZERO);
		Head.addOrReplaceChild("UpperJaw", CubeListBuilder.create().texOffs(0, 97).addBox(-2.0F, -3.75F, -13.0F, 4.0F, 10.0F, 2.0F, cubedef)
		.texOffs(53, 0).addBox(-3.0F, -3.75F, -11.0F, 6.0F, 5.0F, 10.0F, cubedef), PartPose.offset(0.0F, -5.25F, -10.0F));
		Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(64, 61).addBox(-3.0F, -1.0F, -11.0F, 6.0F, 4.0F, 10.0F, cubedef), PartPose.offset(0.0F, -3.0F, -10.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	@Override
	public void setupAnim(EntityDolossal entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		boolean saddled = entity.isSaddled(), vehicle = entity.isVehicle();
		for(ModelPart modelpart : saddleParts) modelpart.visible = saddled;
		for(ModelPart modelpart1 : ridingParts)  modelpart1.visible = saddled && vehicle;
		rightLeg.xRot = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
		leftLeg.xRot = Mth.cos(limbSwing * .6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		neck.xRot = Mth.sin(limbSwing * .6662F) * .2F * limbSwingAmount;
		head.xRot = -neck.xRot;
		rightWing.zRot = Mth.abs(!entity.onGround() ? (float)Math.PI / 2 + Mth.sin(ageInTicks * .2F) * .5F : Mth.cos(limbSwing * .5F) * .3F * limbSwingAmount);
		leftWing.zRot = -rightWing.zRot;
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		neck.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
	@Override
	protected Iterable<ModelPart> headParts() {
		return ImmutableList.of(neck);
	}
	@Override
	protected Iterable<ModelPart> bodyParts() {
		return ImmutableList.of(body);
	}
}
