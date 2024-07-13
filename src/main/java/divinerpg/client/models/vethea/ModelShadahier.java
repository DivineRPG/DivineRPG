package divinerpg.client.models.vethea;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelShadahier<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("shadahier");
	private final ModelPart part1;
	private final ModelPart part2;
	private final ModelPart part3;
	private final ModelPart part4;
	private final ModelPart rightleg;
	private final ModelPart leftleg;
	private final ModelPart rightarm1;
	private final ModelPart leftarm1;
	private final ModelPart leftarm2;
	private final ModelPart rightarm2;
	private final ModelPart leftarm3;
	private final ModelPart rightarm3;
	private final ModelPart leftarm4;
	private final ModelPart rightarm4;
	private final ModelPart leftarm5;
	private final ModelPart rightarm5;
	private final ModelPart leftarm6;
	private final ModelPart rightarm6;
	private final ModelPart part5;
	private final ModelPart part6;
	private final ModelPart part7;
	private final ModelPart part8;
	private final ModelPart part9;
	private final ModelPart part10;
	private final ModelPart part11;
	private final ModelPart part12;
	private final ModelPart part13;
	private final ModelPart part14;

	public ModelShadahier(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.part1 = root.getChild("part1");
		this.part2 = root.getChild("part2");
		this.part3 = root.getChild("part3");
		this.part4 = root.getChild("part4");
		this.rightleg = root.getChild("rightleg");
		this.leftleg = root.getChild("leftleg");
		this.rightarm1 = root.getChild("rightarm1");
		this.leftarm1 = root.getChild("leftarm1");
		this.leftarm2 = root.getChild("leftarm2");
		this.rightarm2 = root.getChild("rightarm2");
		this.leftarm3 = root.getChild("leftarm3");
		this.rightarm3 = root.getChild("rightarm3");
		this.leftarm4 = root.getChild("leftarm4");
		this.rightarm4 = root.getChild("rightarm4");
		this.leftarm5 = root.getChild("leftarm5");
		this.rightarm5 = root.getChild("rightarm5");
		this.leftarm6 = root.getChild("leftarm6");
		this.rightarm6 = root.getChild("rightarm6");
		this.part5 = root.getChild("part5");
		this.part6 = root.getChild("part6");
		this.part7 = root.getChild("part7");
		this.part8 = root.getChild("part8");
		this.part9 = root.getChild("part9");
		this.part10 = root.getChild("part10");
		this.part11 = root.getChild("part11");
		this.part12 = root.getChild("part12");
		this.part13 = root.getChild("part13");
		this.part14 = root.getChild("part14");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("part1", CubeListBuilder.create().texOffs(56, 26).mirror().addBox(8.0F, -9.0F, -3.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 10.0F, 0.0F));

		partdefinition.addOrReplaceChild("part2", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 10.0F, 0.0F));

		partdefinition.addOrReplaceChild("part3", CubeListBuilder.create().texOffs(33, 0).mirror().addBox(-3.0F, -3.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("part4", CubeListBuilder.create().texOffs(33, 0).mirror().addBox(-3.0F, -3.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 21).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 17.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 21).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 17.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm1", CubeListBuilder.create().texOffs(58, 0).mirror().addBox(-1.0F, 2.0F, 2.0F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 12.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		partdefinition.addOrReplaceChild("leftarm1", CubeListBuilder.create().texOffs(58, 0).mirror().addBox(-1.0F, 2.0F, 2.0F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, 12.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		partdefinition.addOrReplaceChild("leftarm2", CubeListBuilder.create().texOffs(40, 12).mirror().addBox(0.0F, 6.0F, -7.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm2", CubeListBuilder.create().texOffs(40, 12).mirror().addBox(-2.0F, 6.0F, -7.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm3", CubeListBuilder.create().texOffs(58, 0).mirror().addBox(-1.0F, 2.0F, -1.0F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, 12.0F, 1.0F, 0.0F, 0.0F, -0.5236F));

		partdefinition.addOrReplaceChild("rightarm3", CubeListBuilder.create().texOffs(58, 0).mirror().addBox(-1.0F, 2.0F, -1.0F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 12.0F, 1.0F, 0.0F, 0.0F, 0.5236F));

		partdefinition.addOrReplaceChild("leftarm4", CubeListBuilder.create().texOffs(58, 0).mirror().addBox(-1.0F, 2.0F, -3.0F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, 12.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		partdefinition.addOrReplaceChild("rightarm4", CubeListBuilder.create().texOffs(58, 0).mirror().addBox(-1.0F, 2.0F, -3.0F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 12.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		partdefinition.addOrReplaceChild("leftarm5", CubeListBuilder.create().texOffs(58, 0).mirror().addBox(-1.0F, 2.0F, -1.0F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, 12.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		partdefinition.addOrReplaceChild("rightarm5", CubeListBuilder.create().texOffs(58, 0).mirror().addBox(-1.0F, 2.0F, -1.0F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 12.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		partdefinition.addOrReplaceChild("leftarm6", CubeListBuilder.create().texOffs(40, 20).mirror().addBox(-1.0F, 1.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm6", CubeListBuilder.create().texOffs(40, 20).mirror().addBox(-3.0F, 1.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("part5", CubeListBuilder.create().texOffs(52, 11).mirror().addBox(1.0F, -4.0F, -5.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part6", CubeListBuilder.create().texOffs(56, 26).mirror().addBox(-10.0F, -9.0F, -3.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 10.0F, 0.0F));

		partdefinition.addOrReplaceChild("part7", CubeListBuilder.create().texOffs(33, 11).mirror().addBox(4.0F, -7.0F, -3.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 10.0F, 0.0F));

		partdefinition.addOrReplaceChild("part8", CubeListBuilder.create().texOffs(33, 11).mirror().addBox(-8.0F, -7.0F, -3.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 10.0F, 0.0F));

		partdefinition.addOrReplaceChild("part9", CubeListBuilder.create().texOffs(56, 26).mirror().addBox(-10.0F, -9.0F, 1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 10.0F, 0.0F));

		partdefinition.addOrReplaceChild("part10", CubeListBuilder.create().texOffs(33, 11).mirror().addBox(-8.0F, -7.0F, 1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 10.0F, 0.0F));

		partdefinition.addOrReplaceChild("part11", CubeListBuilder.create().texOffs(33, 11).mirror().addBox(4.0F, -7.0F, 1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 10.0F, 0.0F));

		partdefinition.addOrReplaceChild("part12", CubeListBuilder.create().texOffs(56, 26).mirror().addBox(8.0F, -9.0F, 1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 10.0F, 0.0F));

		partdefinition.addOrReplaceChild("part13", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 10.0F, 0.0F));

		partdefinition.addOrReplaceChild("part14", CubeListBuilder.create().texOffs(52, 11).mirror().addBox(-3.0F, -4.0F, -5.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leftleg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

		this.rightleg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

		this.rightarm1.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarm2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarm3.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarm4.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarm5.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarm6.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;

		this.leftarm1.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarm2.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarm3.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarm4.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarm5.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarm6.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		part1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarm3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarm4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarm5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarm6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part7.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part8.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part9.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part10.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part11.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part12.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part13.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part14.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}