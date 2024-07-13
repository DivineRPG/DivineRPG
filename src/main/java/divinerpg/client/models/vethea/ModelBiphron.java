package divinerpg.client.models.vethea;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelBiphron<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("biphron");
	private final ModelPart head;
	private final ModelPart bodytop;
	private final ModelPart rightarmts1;
	private final ModelPart leftarmts1;
	private final ModelPart rightlegts1;
	private final ModelPart leftlegts1;
	private final ModelPart leftlegts2;
	private final ModelPart rightlegts2;
	private final ModelPart rightarmtspike1;
	private final ModelPart leftarmtspike1;
	private final ModelPart rightarmts2;
	private final ModelPart leftarmts2;
	private final ModelPart leftarmtspike2;
	private final ModelPart rightarmtspike2;
	private final ModelPart bodybottom;
	private final ModelPart rightarms1;
	private final ModelPart leftarms1;
	private final ModelPart leftarms2;
	private final ModelPart leftarmspike1;
	private final ModelPart leftarmspike2;
	private final ModelPart rightarmspike1;
	private final ModelPart rightarms2;
	private final ModelPart rightarmspike2;
	private final ModelPart leftlegs1;
	private final ModelPart leftlegs2;
	private final ModelPart rightlegs2;
	private final ModelPart rightlegs1;

	public ModelBiphron(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.head = root.getChild("head");
		this.bodytop = root.getChild("bodytop");
		this.rightarmts1 = root.getChild("rightarmts1");
		this.leftarmts1 = root.getChild("leftarmts1");
		this.rightlegts1 = root.getChild("rightlegts1");
		this.leftlegts1 = root.getChild("leftlegts1");
		this.leftlegts2 = root.getChild("leftlegts2");
		this.rightlegts2 = root.getChild("rightlegts2");
		this.rightarmtspike1 = root.getChild("rightarmtspike1");
		this.leftarmtspike1 = root.getChild("leftarmtspike1");
		this.rightarmts2 = root.getChild("rightarmts2");
		this.leftarmts2 = root.getChild("leftarmts2");
		this.leftarmtspike2 = root.getChild("leftarmtspike2");
		this.rightarmtspike2 = root.getChild("rightarmtspike2");
		this.bodybottom = root.getChild("bodybottom");
		this.rightarms1 = root.getChild("rightarms1");
		this.leftarms1 = root.getChild("leftarms1");
		this.leftarms2 = root.getChild("leftarms2");
		this.leftarmspike1 = root.getChild("leftarmspike1");
		this.leftarmspike2 = root.getChild("leftarmspike2");
		this.rightarmspike1 = root.getChild("rightarmspike1");
		this.rightarms2 = root.getChild("rightarms2");
		this.rightarmspike2 = root.getChild("rightarmspike2");
		this.leftlegs1 = root.getChild("leftlegs1");
		this.leftlegs2 = root.getChild("leftlegs2");
		this.rightlegs2 = root.getChild("rightlegs2");
		this.rightlegs1 = root.getChild("rightlegs1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("bodytop", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, -3.1416F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarmts1", CubeListBuilder.create().texOffs(48, 12).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, -10.0F, 0.0F, -3.1416F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarmts1", CubeListBuilder.create().texOffs(48, 12).mirror().addBox(7.0F, -2.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -10.0F, 0.0F, -3.1416F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightlegts1", CubeListBuilder.create().texOffs(41, 23).mirror().addBox(-3.0F, -3.0F, -3.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, -20.0F, 0.0F, -3.1416F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftlegts1", CubeListBuilder.create().texOffs(41, 23).mirror().addBox(-3.0F, -3.0F, -3.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, -20.0F, 0.0F, -3.1416F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftlegts2", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, -20.0F, 0.0F, -3.1416F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightlegts2", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, -20.0F, 0.0F, -3.1416F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarmtspike1", CubeListBuilder.create().texOffs(33, 0).mirror().addBox(-7.0F, 6.0F, 1.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, -10.0F, 0.0F, -3.1416F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarmtspike1", CubeListBuilder.create().texOffs(33, 0).mirror().addBox(6.0F, 6.0F, 1.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, -10.0F, 0.0F, -3.1416F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarmts2", CubeListBuilder.create().texOffs(37, 0).mirror().addBox(-7.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, -10.0F, 0.0F, -3.1416F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarmts2", CubeListBuilder.create().texOffs(37, 0).mirror().addBox(3.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, -10.0F, 0.0F, -3.1416F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarmtspike2", CubeListBuilder.create().texOffs(33, 0).mirror().addBox(6.0F, 6.0F, -2.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, -10.0F, 0.0F, -3.1416F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarmtspike2", CubeListBuilder.create().texOffs(33, 0).mirror().addBox(-7.0F, 6.0F, -2.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, -10.0F, 0.0F, -3.1416F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("bodybottom", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarms1", CubeListBuilder.create().texOffs(48, 12).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarms1", CubeListBuilder.create().texOffs(48, 12).mirror().addBox(7.0F, -2.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarms2", CubeListBuilder.create().texOffs(37, 0).mirror().addBox(3.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarmspike1", CubeListBuilder.create().texOffs(33, 0).mirror().addBox(6.0F, 6.0F, 1.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarmspike2", CubeListBuilder.create().texOffs(33, 0).mirror().addBox(6.0F, 6.0F, -2.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarmspike1", CubeListBuilder.create().texOffs(33, 0).mirror().addBox(-7.0F, 6.0F, -2.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarms2", CubeListBuilder.create().texOffs(37, 0).mirror().addBox(-7.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarmspike2", CubeListBuilder.create().texOffs(33, 0).mirror().addBox(-7.0F, 6.0F, 1.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftlegs1", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftlegs2", CubeListBuilder.create().texOffs(41, 23).mirror().addBox(-3.0F, -3.0F, -3.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightlegs2", CubeListBuilder.create().texOffs(41, 23).mirror().addBox(-3.0F, -3.0F, -3.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightlegs1", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leftlegs1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftlegs2.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

		this.rightlegs1.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.rightlegs2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

		this.rightarms1.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarms2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarmspike1.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarmspike2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;

		this.leftarms1.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarms2.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarmspike1.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarmspike2.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;

		this.leftlegts1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - (float)Math.PI;
		this.leftlegts2.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - (float)Math.PI;

		this.rightlegts1.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount - (float)Math.PI;
		this.rightlegts2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount - (float)Math.PI;

		this.rightarmts1.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F - (float)Math.PI;
		this.rightarmts2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F - (float)Math.PI;
		this.rightarmtspike1.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F - (float)Math.PI;
		this.rightarmtspike2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F - (float)Math.PI;

		this.leftarmts1.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F - (float)Math.PI;
		this.leftarmts2.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F - (float)Math.PI;
		this.leftarmtspike1.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F - (float)Math.PI;
		this.leftarmtspike2.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F - (float)Math.PI;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		bodytop.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarmts1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarmts1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightlegts1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftlegts1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftlegts2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightlegts2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarmtspike1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarmtspike1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarmts2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarmts2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarmtspike2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarmtspike2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		bodybottom.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarms1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarms1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarms2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarmspike1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarmspike2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarmspike1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarms2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarmspike2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftlegs1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftlegs2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightlegs2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightlegs1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}