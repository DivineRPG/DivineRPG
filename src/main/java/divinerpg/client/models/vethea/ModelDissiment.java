package divinerpg.client.models.vethea;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelDissiment<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("dissiment");
	private final ModelPart Shape1;
	private final ModelPart Shape2;
	private final ModelPart Shape3;
	private final ModelPart Shape4;
	private final ModelPart Shape5;
	private final ModelPart Shape6;
	private final ModelPart part1;
	private final ModelPart part2;
	private final ModelPart part3;
	private final ModelPart part4;
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
	private final ModelPart part15;
	private final ModelPart part16;
	private final ModelPart part17;
	private final ModelPart part18;
	private final ModelPart part19;
	private final ModelPart part20;
	private final ModelPart part21;
	private final ModelPart part22;
	private final ModelPart part23;

	public ModelDissiment(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Shape1 = root.getChild("Shape1");
		this.Shape2 = root.getChild("Shape2");
		this.Shape3 = root.getChild("Shape3");
		this.Shape4 = root.getChild("Shape4");
		this.Shape5 = root.getChild("Shape5");
		this.Shape6 = root.getChild("Shape6");
		this.part1 = root.getChild("part1");
		this.part2 = root.getChild("part2");
		this.part3 = root.getChild("part3");
		this.part4 = root.getChild("part4");
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
		this.part15 = root.getChild("part15");
		this.part16 = root.getChild("part16");
		this.part17 = root.getChild("part17");
		this.part18 = root.getChild("part18");
		this.part19 = root.getChild("part19");
		this.part20 = root.getChild("part20");
		this.part21 = root.getChild("part21");
		this.part22 = root.getChild("part22");
		this.part23 = root.getChild("part23");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Shape1", CubeListBuilder.create().texOffs(22, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 1.0F, -3.0F));

		partdefinition.addOrReplaceChild("Shape2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 1.0F, -5.0F));

		partdefinition.addOrReplaceChild("Shape3", CubeListBuilder.create().texOffs(41, 12).mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 1.0F, 4.0F));

		partdefinition.addOrReplaceChild("Shape4", CubeListBuilder.create().texOffs(22, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 1.0F, 2.0F));

		partdefinition.addOrReplaceChild("Shape5", CubeListBuilder.create().texOffs(22, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 1.0F, -1.0F));

		partdefinition.addOrReplaceChild("Shape6", CubeListBuilder.create().texOffs(22, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 1.0F, 0.0F));

		partdefinition.addOrReplaceChild("part1", CubeListBuilder.create().texOffs(13, 12).mirror().addBox(-9.0F, -18.0F, -2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		partdefinition.addOrReplaceChild("part2", CubeListBuilder.create().texOffs(36, 24).mirror().addBox(-8.0F, -15.0F, -2.0F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		partdefinition.addOrReplaceChild("part3", CubeListBuilder.create().texOffs(36, 24).mirror().addBox(-5.0F, -13.0F, -2.0F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

		partdefinition.addOrReplaceChild("part4", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(-9.0F, -14.0F, -3.0F, 5.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

		partdefinition.addOrReplaceChild("part5", CubeListBuilder.create().texOffs(36, 24).mirror().addBox(-5.0F, -14.0F, -2.0F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, -0.9599F));

		partdefinition.addOrReplaceChild("part6", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(-9.0F, -15.0F, -3.0F, 5.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, -0.9599F));

		partdefinition.addOrReplaceChild("part7", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(4.0F, -14.0F, -3.0F, 5.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

		partdefinition.addOrReplaceChild("part8", CubeListBuilder.create().texOffs(13, 12).mirror().addBox(-11.0F, -19.0F, 1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		partdefinition.addOrReplaceChild("part9", CubeListBuilder.create().texOffs(13, 12).mirror().addBox(-10.0F, -17.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		partdefinition.addOrReplaceChild("part10", CubeListBuilder.create().texOffs(13, 12).mirror().addBox(6.0F, -16.0F, 1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

		partdefinition.addOrReplaceChild("part11", CubeListBuilder.create().texOffs(13, 12).mirror().addBox(5.0F, -16.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

		partdefinition.addOrReplaceChild("part12", CubeListBuilder.create().texOffs(13, 12).mirror().addBox(7.0F, -16.0F, -2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 4.0F, 0.0F));

		partdefinition.addOrReplaceChild("part13", CubeListBuilder.create().texOffs(13, 12).mirror().addBox(-7.0F, -17.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

		partdefinition.addOrReplaceChild("part14", CubeListBuilder.create().texOffs(13, 12).mirror().addBox(-6.0F, -16.0F, 1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

		partdefinition.addOrReplaceChild("part15", CubeListBuilder.create().texOffs(13, 12).mirror().addBox(-8.0F, -16.0F, -2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 4.0F, 0.0F));

		partdefinition.addOrReplaceChild("part16", CubeListBuilder.create().texOffs(13, 12).mirror().addBox(-8.0F, -18.0F, 1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, -0.9599F));

		partdefinition.addOrReplaceChild("part17", CubeListBuilder.create().texOffs(13, 12).mirror().addBox(-6.0F, -17.0F, 1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, -0.9599F));

		partdefinition.addOrReplaceChild("part18", CubeListBuilder.create().texOffs(13, 12).mirror().addBox(-8.0F, -16.0F, -2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.0F, 0.0F, -0.9599F));

		partdefinition.addOrReplaceChild("part19", CubeListBuilder.create().texOffs(24, 22).mirror().addBox(0.0F, -13.0F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		partdefinition.addOrReplaceChild("part20", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(-12.0F, -16.0F, -3.0F, 5.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		partdefinition.addOrReplaceChild("part21", CubeListBuilder.create().texOffs(24, 22).mirror().addBox(-1.0F, -13.0F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		partdefinition.addOrReplaceChild("part22", CubeListBuilder.create().texOffs(24, 22).mirror().addBox(-6.0F, -12.0F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, -1.0472F));

		partdefinition.addOrReplaceChild("part23", CubeListBuilder.create().texOffs(24, 22).mirror().addBox(-4.0F, -16.0F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, -2.0944F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.part1.zRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.part2.zRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.part3.zRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.part4.zRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.part5.zRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.part6.zRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.part7.zRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.part8.zRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.part9.zRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.part10.zRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.part11.zRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.part12.zRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.part13.zRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.part14.zRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.part15.zRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.part16.zRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.part17.zRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.part18.zRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.part19.zRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.part20.zRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.part21.zRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.part22.zRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.part23.zRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		Shape1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Shape2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Shape3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Shape4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Shape5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Shape6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
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
		part15.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part16.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part17.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part18.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part19.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part20.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part21.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part22.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part23.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}