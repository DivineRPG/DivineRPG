package divinerpg.client.models.vethea;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelVermenous<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("vermenous");
	private final ModelPart part1;
	private final ModelPart part2;
	private final ModelPart rightarm1;
	private final ModelPart leftarm1;
	private final ModelPart rightleg1;
	private final ModelPart leftleg1;
	private final ModelPart part3;
	private final ModelPart part4;
	private final ModelPart part5;
	private final ModelPart part6;
	private final ModelPart part8;
	private final ModelPart part9;
	private final ModelPart part10;
	private final ModelPart part12;
	private final ModelPart part11;
	private final ModelPart part13;
	private final ModelPart part14;
	private final ModelPart part15;
	private final ModelPart part16;
	private final ModelPart part18;
	private final ModelPart part17;
	private final ModelPart rightarm2;
	private final ModelPart leftarm2;
	private final ModelPart rightarm3;
	private final ModelPart rightarm5;
	private final ModelPart leftleg2;
	private final ModelPart rightleg2;
	private final ModelPart leftleg3;
	private final ModelPart rightleg3;
	private final ModelPart leftleg4;
	private final ModelPart rightleg4;
	private final ModelPart leftarm3;
	private final ModelPart rightarm4;
	private final ModelPart leftarm4;
	private final ModelPart leftarm5;

	public ModelVermenous(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.part1 = root.getChild("part1");
		this.part2 = root.getChild("part2");
		this.rightarm1 = root.getChild("rightarm1");
		this.leftarm1 = root.getChild("leftarm1");
		this.rightleg1 = root.getChild("rightleg1");
		this.leftleg1 = root.getChild("leftleg1");
		this.part3 = root.getChild("part3");
		this.part4 = root.getChild("part4");
		this.part5 = root.getChild("part5");
		this.part6 = root.getChild("part6");
		this.part8 = root.getChild("part8");
		this.part9 = root.getChild("part9");
		this.part10 = root.getChild("part10");
		this.part12 = root.getChild("part12");
		this.part11 = root.getChild("part11");
		this.part13 = root.getChild("part13");
		this.part14 = root.getChild("part14");
		this.part15 = root.getChild("part15");
		this.part16 = root.getChild("part16");
		this.part18 = root.getChild("part18");
		this.part17 = root.getChild("part17");
		this.rightarm2 = root.getChild("rightarm2");
		this.leftarm2 = root.getChild("leftarm2");
		this.rightarm3 = root.getChild("rightarm3");
		this.rightarm5 = root.getChild("rightarm5");
		this.leftleg2 = root.getChild("leftleg2");
		this.rightleg2 = root.getChild("rightleg2");
		this.leftleg3 = root.getChild("leftleg3");
		this.rightleg3 = root.getChild("rightleg3");
		this.leftleg4 = root.getChild("leftleg4");
		this.rightleg4 = root.getChild("rightleg4");
		this.leftarm3 = root.getChild("leftarm3");
		this.rightarm4 = root.getChild("rightarm4");
		this.leftarm4 = root.getChild("leftarm4");
		this.leftarm5 = root.getChild("leftarm5");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("part1", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part2", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm1", CubeListBuilder.create().texOffs(42, 20).mirror().addBox(-4.0F, 10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm1", CubeListBuilder.create().texOffs(42, 20).mirror().addBox(2.0F, 10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg1", CubeListBuilder.create().texOffs(0, 26).mirror().addBox(1.0F, 10.0F, -8.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg1", CubeListBuilder.create().texOffs(0, 26).mirror().addBox(1.0F, 10.0F, -8.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("part3", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, -12.0F, -13.0F, 1.5708F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("part4", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, -23.0F, -14.0F));

		partdefinition.addOrReplaceChild("part5", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(8.0F, -8.0F, -14.0F));

		partdefinition.addOrReplaceChild("part6", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-16.0F, -8.0F, -14.0F));

		partdefinition.addOrReplaceChild("part8", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-13.0F, -17.0F, -14.0F));

		partdefinition.addOrReplaceChild("part9", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, -17.0F, -14.0F));

		partdefinition.addOrReplaceChild("part10", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -6.0F, -7.0F));

		partdefinition.addOrReplaceChild("part12", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -6.0F, -13.0F));

		partdefinition.addOrReplaceChild("part11", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -6.0F, -13.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("part13", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -15.0F, -13.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("part14", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, -6.0F, -13.0F, 1.5708F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("part15", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -12.0F, -13.0F, 1.5708F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("part16", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -6.0F, -13.0F, 1.5708F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("part18", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0F, -6.0F, -13.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("part17", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, -15.0F, -13.0F, 0.0F, -1.5708F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm2", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm2", CubeListBuilder.create().texOffs(42, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm3", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-5.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm5", CubeListBuilder.create().texOffs(40, 23).mirror().addBox(-9.0F, 5.0F, -1.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg2", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg2", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg3", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 10.0F, -6.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg3", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 10.0F, -6.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg4", CubeListBuilder.create().texOffs(0, 26).mirror().addBox(-2.0F, 10.0F, -8.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg4", CubeListBuilder.create().texOffs(0, 26).mirror().addBox(-2.0F, 10.0F, -8.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm3", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm4", CubeListBuilder.create().texOffs(40, 23).mirror().addBox(-9.0F, 0.0F, -1.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm4", CubeListBuilder.create().texOffs(40, 23).mirror().addBox(5.0F, 5.0F, -1.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm5", CubeListBuilder.create().texOffs(40, 23).mirror().addBox(5.0F, 0.0F, -1.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leftleg1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

		this.rightleg1.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

		this.rightarm1.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarm2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarm3.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarm4.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarm5.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;

		this.leftarm1.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarm2.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarm3.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarm4.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarm5.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		part1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part8.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part9.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part10.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part12.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part11.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part13.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part14.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part15.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part16.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part18.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part17.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarm3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarm5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarm4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}