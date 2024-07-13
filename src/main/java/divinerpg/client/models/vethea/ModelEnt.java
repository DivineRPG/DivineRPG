package divinerpg.client.models.vethea;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelEnt<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("ent");
	private final ModelPart horn1;
	private final ModelPart Part1;
	private final ModelPart rightarm1;
	private final ModelPart leftarm1;
	private final ModelPart rightleg1;
	private final ModelPart leftleg1;
	private final ModelPart leftleg2;
	private final ModelPart rightleg2;
	private final ModelPart leftleg3;
	private final ModelPart rightleg3;
	private final ModelPart Part2;
	private final ModelPart Part3;
	private final ModelPart Part4;
	private final ModelPart Part5;
	private final ModelPart Part6;
	private final ModelPart Part7;
	private final ModelPart Part8;
	private final ModelPart Part9;
	private final ModelPart Part10;
	private final ModelPart leftarm2;
	private final ModelPart rightarm2;
	private final ModelPart rightarm3;
	private final ModelPart leftarm3;
	private final ModelPart Part11;
	private final ModelPart Part12;
	private final ModelPart Part13;
	private final ModelPart Part14;
	private final ModelPart Part15;
	private final ModelPart Part16;
	private final ModelPart Part17;
	private final ModelPart Part18;
	private final ModelPart Part19;
	private final ModelPart Part20;
	private final ModelPart Part21;
	private final ModelPart Part22;
	private final ModelPart head;
	private final ModelPart horn2;

	public ModelEnt(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.horn1 = root.getChild("horn1");
		this.Part1 = root.getChild("Part1");
		this.rightarm1 = root.getChild("rightarm1");
		this.leftarm1 = root.getChild("leftarm1");
		this.rightleg1 = root.getChild("rightleg1");
		this.leftleg1 = root.getChild("leftleg1");
		this.leftleg2 = root.getChild("leftleg2");
		this.rightleg2 = root.getChild("rightleg2");
		this.leftleg3 = root.getChild("leftleg3");
		this.rightleg3 = root.getChild("rightleg3");
		this.Part2 = root.getChild("Part2");
		this.Part3 = root.getChild("Part3");
		this.Part4 = root.getChild("Part4");
		this.Part5 = root.getChild("Part5");
		this.Part6 = root.getChild("Part6");
		this.Part7 = root.getChild("Part7");
		this.Part8 = root.getChild("Part8");
		this.Part9 = root.getChild("Part9");
		this.Part10 = root.getChild("Part10");
		this.leftarm2 = root.getChild("leftarm2");
		this.rightarm2 = root.getChild("rightarm2");
		this.rightarm3 = root.getChild("rightarm3");
		this.leftarm3 = root.getChild("leftarm3");
		this.Part11 = root.getChild("Part11");
		this.Part12 = root.getChild("Part12");
		this.Part13 = root.getChild("Part13");
		this.Part14 = root.getChild("Part14");
		this.Part15 = root.getChild("Part15");
		this.Part16 = root.getChild("Part16");
		this.Part17 = root.getChild("Part17");
		this.Part18 = root.getChild("Part18");
		this.Part19 = root.getChild("Part19");
		this.Part20 = root.getChild("Part20");
		this.Part21 = root.getChild("Part21");
		this.Part22 = root.getChild("Part22");
		this.head = root.getChild("head");
		this.horn2 = root.getChild("horn2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("horn1", CubeListBuilder.create().texOffs(68, 0).mirror().addBox(4.0F, -8.0F, -11.0F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -36.0F, -2.0F, -0.4363F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Part1", CubeListBuilder.create().texOffs(67, 12).mirror().addBox(-4.0F, 0.0F, -2.0F, 16.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -27.0F, 8.0F, 0.1745F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm1", CubeListBuilder.create().texOffs(159, 0).mirror().addBox(-2.0F, 8.0F, 1.0F, 8.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-16.0F, -30.0F, 2.0F, -0.6905F, 0.0F, 0.1745F));

		partdefinition.addOrReplaceChild("leftarm1", CubeListBuilder.create().texOffs(159, 0).mirror().addBox(-6.0F, 8.0F, 1.0F, 8.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(16.0F, -30.0F, 2.0F, -0.6905F, 0.0F, -0.1745F));

		partdefinition.addOrReplaceChild("rightleg1", CubeListBuilder.create().texOffs(159, 0).mirror().addBox(-10.0F, 2.0F, 3.0F, 12.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.0F, -1.0F, -4.0F, -0.3491F, 0.3491F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg1", CubeListBuilder.create().texOffs(159, 0).mirror().addBox(-2.0F, 2.0F, 3.0F, 12.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.0F, -1.0F, -4.0F, -0.3491F, -0.3491F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg2", CubeListBuilder.create().texOffs(209, 0).mirror().addBox(-4.0F, -13.0F, 2.0F, 10.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.0F, 5.0F, -4.0F, -0.1745F, -0.3491F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg2", CubeListBuilder.create().texOffs(209, 0).mirror().addBox(-6.0F, -13.0F, 2.0F, 10.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.0F, 5.0F, -4.0F, -0.1745F, 0.3491F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg3", CubeListBuilder.create().texOffs(209, 0).mirror().addBox(-1.0F, 7.0F, -2.0F, 10.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(12.0F, 5.0F, -4.0F));

		partdefinition.addOrReplaceChild("rightleg3", CubeListBuilder.create().texOffs(209, 0).mirror().addBox(-9.0F, 7.0F, -2.0F, 10.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-12.0F, 5.0F, -4.0F));

		partdefinition.addOrReplaceChild("Part2", CubeListBuilder.create().texOffs(67, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 16.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -27.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Part3", CubeListBuilder.create().texOffs(67, 4).mirror().addBox(-4.0F, 0.0F, -2.0F, 16.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -27.0F, 12.0F, 0.1745F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Part4", CubeListBuilder.create().texOffs(67, 8).mirror().addBox(-4.0F, 0.0F, -2.0F, 16.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -27.0F, 4.0F, 0.1745F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Part5", CubeListBuilder.create().texOffs(67, 12).mirror().addBox(-4.0F, 0.0F, -2.0F, 18.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, -37.0F, 5.0F, 0.3491F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Part6", CubeListBuilder.create().texOffs(67, 8).mirror().addBox(-4.0F, 0.0F, -2.0F, 18.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, -37.0F, 1.0F, 0.3491F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Part7", CubeListBuilder.create().texOffs(67, 8).mirror().addBox(-4.0F, 0.0F, -2.0F, 18.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, -17.0F, 4.0F));

		partdefinition.addOrReplaceChild("Part8", CubeListBuilder.create().texOffs(67, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 18.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, -17.0F, 0.0F));

		partdefinition.addOrReplaceChild("Part9", CubeListBuilder.create().texOffs(67, 12).mirror().addBox(-4.0F, 0.0F, -2.0F, 18.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, -17.0F, 8.0F));

		partdefinition.addOrReplaceChild("Part10", CubeListBuilder.create().texOffs(67, 4).mirror().addBox(-4.0F, 0.0F, -2.0F, 18.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, -17.0F, 12.0F));

		partdefinition.addOrReplaceChild("leftarm2", CubeListBuilder.create().texOffs(209, 0).mirror().addBox(-7.0F, 14.0F, 2.0F, 10.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(16.0F, -30.0F, 2.0F, -0.8651F, 0.0F, -0.1745F));

		partdefinition.addOrReplaceChild("rightarm2", CubeListBuilder.create().texOffs(209, 0).mirror().addBox(-3.0F, 14.0F, 2.0F, 10.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-16.0F, -30.0F, 2.0F, -0.8651F, 0.0F, 0.1745F));

		partdefinition.addOrReplaceChild("rightarm3", CubeListBuilder.create().texOffs(209, 0).mirror().addBox(-3.0F, -2.0F, -2.0F, 10.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-16.0F, -30.0F, 2.0F, -0.3415F, 0.0F, 0.1745F));

		partdefinition.addOrReplaceChild("leftarm3", CubeListBuilder.create().texOffs(209, 0).mirror().addBox(-7.0F, -2.0F, -2.0F, 10.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(16.0F, -30.0F, 2.0F, -0.3415F, 0.0F, -0.1745F));

		partdefinition.addOrReplaceChild("Part11", CubeListBuilder.create().texOffs(67, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 18.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, -37.0F, -3.0F, 0.3491F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Part12", CubeListBuilder.create().texOffs(67, 4).mirror().addBox(-4.0F, 0.0F, -2.0F, 18.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, -37.0F, 9.0F, 0.3491F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Part13", CubeListBuilder.create().texOffs(33, 4).mirror().addBox(0.0F, -20.0F, -5.0F, 8.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -30.0F, 9.0F, -0.9894F, 0.3346F, -0.0372F));

		partdefinition.addOrReplaceChild("Part14", CubeListBuilder.create().texOffs(113, 4).mirror().addBox(2.0F, -14.0F, -3.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -30.0F, 9.0F, -0.9894F, 0.3346F, -0.0372F));

		partdefinition.addOrReplaceChild("Part15", CubeListBuilder.create().texOffs(33, 4).mirror().addBox(-6.0F, -10.0F, 0.0F, 8.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -37.0F, 9.0F, -0.2086F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Part16", CubeListBuilder.create().texOffs(113, 4).mirror().addBox(-4.0F, -4.0F, 2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -37.0F, 9.0F, -0.2086F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Part17", CubeListBuilder.create().texOffs(33, 4).mirror().addBox(-5.0F, -15.0F, 5.0F, 8.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -30.0F, 9.0F, -0.8406F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Part18", CubeListBuilder.create().texOffs(113, 4).mirror().addBox(-3.0F, -9.0F, 7.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -30.0F, 9.0F, -0.8406F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Part19", CubeListBuilder.create().texOffs(33, 4).mirror().addBox(-5.0F, -12.0F, 12.0F, 8.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -30.0F, 9.0F, -1.1381F, -0.5577F, 0.0F));

		partdefinition.addOrReplaceChild("Part20", CubeListBuilder.create().texOffs(113, 4).mirror().addBox(-3.0F, -6.0F, 14.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -30.0F, 9.0F, -1.1381F, -0.5577F, 0.0F));

		partdefinition.addOrReplaceChild("Part21", CubeListBuilder.create().texOffs(33, 4).mirror().addBox(-5.0F, -14.0F, 10.0F, 8.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -30.0F, 9.0F, -1.1381F, 0.5949F, -0.0372F));

		partdefinition.addOrReplaceChild("Part22", CubeListBuilder.create().texOffs(113, 4).mirror().addBox(-3.0F, -8.0F, 12.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -30.0F, 9.0F, -1.1381F, 0.5949F, -0.0372F));

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -36.0F, -2.0F));

		partdefinition.addOrReplaceChild("horn2", CubeListBuilder.create().texOffs(68, 0).mirror().addBox(-6.0F, -8.0F, -11.0F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -36.0F, -2.0F, -0.4363F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leftleg1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + -0.3490659F;
		this.leftleg2.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + -0.1745329F;
		this.leftleg3.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

		this.rightleg1.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount + -0.3490659F;
		this.rightleg2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount + -0.1745329F;
		this.rightleg3.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

		this.rightarm1.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F + -0.6905433F;
		this.rightarm2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F +  -0.8650762F;
		this.rightarm3.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F + -0.3414775F;

		this.leftarm1.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F + -0.6905433F;
		this.leftarm2.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F +  -0.8650762F;
		this.leftarm3.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F + -0.3414775F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		horn1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Part1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Part2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Part3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Part4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Part5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Part6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Part7.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Part8.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Part9.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Part10.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarm3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Part11.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Part12.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Part13.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Part14.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Part15.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Part16.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Part17.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Part18.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Part19.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Part20.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Part21.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Part22.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		horn2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}