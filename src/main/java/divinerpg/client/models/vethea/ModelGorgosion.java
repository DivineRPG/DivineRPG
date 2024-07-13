package divinerpg.client.models.vethea;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelGorgosion<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("gorgosion");
	private final ModelPart rightarm1;
	private final ModelPart leftarm1;
	private final ModelPart rightleg1;
	private final ModelPart leftleg1;
	private final ModelPart body1;
	private final ModelPart body2;
	private final ModelPart body3;
	private final ModelPart body4;
	private final ModelPart body5;
	private final ModelPart body6;
	private final ModelPart body7;
	private final ModelPart body8;
	private final ModelPart rightleg2;
	private final ModelPart leftleg2;
	private final ModelPart leftleg3;
	private final ModelPart rightleg3;
	private final ModelPart rightleg4;
	private final ModelPart leftleg4;
	private final ModelPart rightleg5;
	private final ModelPart leftleg5;
	private final ModelPart leftleg6;
	private final ModelPart leftleg10;
	private final ModelPart rightleg10;
	private final ModelPart rightleg7;
	private final ModelPart rightleg8;
	private final ModelPart leftleg8;
	private final ModelPart rightleg9;
	private final ModelPart leftleg9;
	private final ModelPart rightarm2;
	private final ModelPart leftarm2;
	private final ModelPart rightarm3;
	private final ModelPart leftarm3;
	private final ModelPart rightarm4;
	private final ModelPart leftarm4;
	private final ModelPart rightarm5;
	private final ModelPart leftarm5;

	public ModelGorgosion(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.rightarm1 = root.getChild("rightarm1");
		this.leftarm1 = root.getChild("leftarm1");
		this.rightleg1 = root.getChild("rightleg1");
		this.leftleg1 = root.getChild("leftleg1");
		this.body1 = root.getChild("body1");
		this.body2 = root.getChild("body2");
		this.body3 = root.getChild("body3");
		this.body4 = root.getChild("body4");
		this.body5 = root.getChild("body5");
		this.body6 = root.getChild("body6");
		this.body7 = root.getChild("body7");
		this.body8 = root.getChild("body8");
		this.rightleg2 = root.getChild("rightleg2");
		this.leftleg2 = root.getChild("leftleg2");
		this.leftleg3 = root.getChild("leftleg3");
		this.rightleg3 = root.getChild("rightleg3");
		this.rightleg4 = root.getChild("rightleg4");
		this.leftleg4 = root.getChild("leftleg4");
		this.rightleg5 = root.getChild("rightleg5");
		this.leftleg5 = root.getChild("leftleg5");
		this.leftleg6 = root.getChild("leftleg6");
		this.leftleg10 = root.getChild("leftleg10");
		this.rightleg10 = root.getChild("rightleg10");
		this.rightleg7 = root.getChild("rightleg7");
		this.rightleg8 = root.getChild("rightleg8");
		this.leftleg8 = root.getChild("leftleg8");
		this.rightleg9 = root.getChild("rightleg9");
		this.leftleg9 = root.getChild("leftleg9");
		this.rightarm2 = root.getChild("rightarm2");
		this.leftarm2 = root.getChild("leftarm2");
		this.rightarm3 = root.getChild("rightarm3");
		this.leftarm3 = root.getChild("leftarm3");
		this.rightarm4 = root.getChild("rightarm4");
		this.leftarm4 = root.getChild("leftarm4");
		this.rightarm5 = root.getChild("rightarm5");
		this.leftarm5 = root.getChild("leftarm5");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("rightarm1", CubeListBuilder.create().texOffs(40, 20).mirror().addBox(-3.0F, -5.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm1", CubeListBuilder.create().texOffs(40, 20).mirror().addBox(-3.0F, -5.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg1", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(2.0F, -10.0F, -12.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, 12.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg1", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(2.0F, -10.0F, -12.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(10.0F, 12.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, -4.0F, -2.0F));

		partdefinition.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, -4.0F, 2.0F));

		partdefinition.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, -4.0F, 2.0F));

		partdefinition.addOrReplaceChild("body4", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, -4.0F, -2.0F));

		partdefinition.addOrReplaceChild("body5", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 4.0F, 2.0F));

		partdefinition.addOrReplaceChild("body6", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 4.0F, 2.0F));

		partdefinition.addOrReplaceChild("body7", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0F, 8.0F, -2.0F, 0.0F, 0.0F, 1.5708F));

		partdefinition.addOrReplaceChild("body8", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 8.0F, -2.0F, 0.0F, 0.0F, -1.5708F));

		partdefinition.addOrReplaceChild("rightleg2", CubeListBuilder.create().texOffs(0, 12).mirror().addBox(-3.0F, -6.0F, -3.0F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, 12.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg2", CubeListBuilder.create().texOffs(0, 12).mirror().addBox(-2.0F, -6.0F, -3.0F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(10.0F, 12.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg3", CubeListBuilder.create().texOffs(50, 0).mirror().addBox(-1.0F, 2.0F, 1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(10.0F, 12.0F, 0.0F, -1.2217F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg3", CubeListBuilder.create().texOffs(50, 0).mirror().addBox(-1.0F, 2.0F, 1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, 12.0F, 0.0F, -1.2217F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg4", CubeListBuilder.create().texOffs(22, 12).mirror().addBox(-2.0F, -2.0F, -11.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, 12.0F, 0.0F, 1.2217F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg4", CubeListBuilder.create().texOffs(22, 12).mirror().addBox(-2.0F, -2.0F, -11.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(10.0F, 12.0F, 0.0F, 1.2217F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg5", CubeListBuilder.create().texOffs(8, 22).mirror().addBox(2.0F, -2.0F, -12.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, 12.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg5", CubeListBuilder.create().texOffs(8, 22).mirror().addBox(2.0F, -2.0F, -12.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(10.0F, 12.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg6", CubeListBuilder.create().texOffs(8, 22).mirror().addBox(-4.0F, -2.0F, -12.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(10.0F, 12.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg10", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-4.0F, -10.0F, -12.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(10.0F, 12.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg10", CubeListBuilder.create().texOffs(8, 22).mirror().addBox(-4.0F, -2.0F, -12.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, 12.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg7", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-4.0F, -10.0F, -12.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, 12.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg8", CubeListBuilder.create().texOffs(22, 12).mirror().addBox(-2.0F, -2.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, 12.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg8", CubeListBuilder.create().texOffs(22, 12).mirror().addBox(-2.0F, -2.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(10.0F, 12.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg9", CubeListBuilder.create().texOffs(50, 0).mirror().addBox(-1.0F, 0.0F, -2.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, 12.0F, 0.0F, -1.2217F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg9", CubeListBuilder.create().texOffs(50, 0).mirror().addBox(-1.0F, 0.0F, -2.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(10.0F, 12.0F, 0.0F, -1.2217F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm2", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-11.0F, -4.0F, -2.0F, 11.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm2", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(0.0F, -4.0F, -2.0F, 11.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm3", CubeListBuilder.create().texOffs(22, 12).mirror().addBox(-11.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm3", CubeListBuilder.create().texOffs(22, 12).mirror().addBox(7.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm4", CubeListBuilder.create().texOffs(40, 20).mirror().addBox(-12.0F, 9.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm4", CubeListBuilder.create().texOffs(40, 20).mirror().addBox(6.0F, 9.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm5", CubeListBuilder.create().texOffs(40, 20).mirror().addBox(-12.0F, -5.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm5", CubeListBuilder.create().texOffs(40, 20).mirror().addBox(6.0F, -5.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leftleg1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + 1.570796F;
		this.leftleg2.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + -0.3490659F;
		this.leftleg3.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + -1.22173F;
		this.leftleg4.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + 1.22173F;
		this.leftleg5.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + 1.570796F;
		this.leftleg6.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + 1.570796F;
		this.leftleg8.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + -0.3490659F;
		this.leftleg9.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + -1.22173F;
		this.leftleg10.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + 1.570796F;

		this.rightleg1.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount + 1.570796F;
		this.rightleg2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount + -0.3490659F;
		this.rightleg3.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount + -1.22173F;
		this.rightleg4.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount + 1.22173F;
		this.rightleg5.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount + 1.570796F;
		this.rightleg7.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount + 1.570796F;
		this.rightleg8.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount + -0.3490659F;
		this.rightleg9.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount + -1.22173F;
		this.rightleg10.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount + 1.570796F;

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
		rightarm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		body1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		body2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		body3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		body4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		body5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		body6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		body7.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		body8.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg10.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg10.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg7.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg8.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg8.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg9.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg9.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarm3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarm4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarm5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}