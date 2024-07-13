package divinerpg.client.models.vethea;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelAcidHag<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("acid_hag");
	private final ModelPart body;
	private final ModelPart leftarmtop;
	private final ModelPart rightarmtop;
	private final ModelPart leftarmbottom;
	private final ModelPart rightarmbottom;
	private final ModelPart leftarms1;
	private final ModelPart rightarms1;
	private final ModelPart leftarms2;
	private final ModelPart rightarms2;
	private final ModelPart leftarms3;
	private final ModelPart rightarms3;
	private final ModelPart leftlegs1;
	private final ModelPart rightlegs1;
	private final ModelPart rightfoot;
	private final ModelPart leftfoot;
	private final ModelPart rightlegs2;
	private final ModelPart leftlegs2;
	private final ModelPart leftlegs3;
	private final ModelPart rightlegs3;
	private final ModelPart horn1;
	private final ModelPart head;
	private final ModelPart horn2;

	public ModelAcidHag(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.body = root.getChild("body");
		this.leftarmtop = root.getChild("leftarmtop");
		this.rightarmtop = root.getChild("rightarmtop");
		this.leftarmbottom = root.getChild("leftarmbottom");
		this.rightarmbottom = root.getChild("rightarmbottom");
		this.leftarms1 = root.getChild("leftarms1");
		this.rightarms1 = root.getChild("rightarms1");
		this.leftarms2 = root.getChild("leftarms2");
		this.rightarms2 = root.getChild("rightarms2");
		this.leftarms3 = root.getChild("leftarms3");
		this.rightarms3 = root.getChild("rightarms3");
		this.leftlegs1 = root.getChild("leftlegs1");
		this.rightlegs1 = root.getChild("rightlegs1");
		this.rightfoot = root.getChild("rightfoot");
		this.leftfoot = root.getChild("leftfoot");
		this.rightlegs2 = root.getChild("rightlegs2");
		this.leftlegs2 = root.getChild("leftlegs2");
		this.leftlegs3 = root.getChild("leftlegs3");
		this.rightlegs3 = root.getChild("rightlegs3");
		this.horn1 = root.getChild("horn1");
		this.head = root.getChild("head");
		this.horn2 = root.getChild("horn2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarmtop", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarmtop", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarmbottom", CubeListBuilder.create().texOffs(40, 25).mirror().addBox(-1.0F, 18.0F, -5.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarmbottom", CubeListBuilder.create().texOffs(40, 25).mirror().addBox(-3.0F, 18.0F, -5.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarms1", CubeListBuilder.create().texOffs(40, 20).mirror().addBox(-1.0F, 6.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarms1", CubeListBuilder.create().texOffs(40, 20).mirror().addBox(-3.0F, 6.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarms2", CubeListBuilder.create().texOffs(40, 20).mirror().addBox(-1.0F, 10.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarms2", CubeListBuilder.create().texOffs(40, 20).mirror().addBox(-3.0F, 10.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarms3", CubeListBuilder.create().texOffs(40, 20).mirror().addBox(-1.0F, 14.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarms3", CubeListBuilder.create().texOffs(40, 20).mirror().addBox(-3.0F, 14.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftlegs1", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(0.0F, 3.0F, -2.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightlegs1", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 3.0F, -2.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightfoot", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(-2.0F, 6.0F, -6.0F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 15.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftfoot", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(-1.0F, 6.0F, -6.0F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 15.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightlegs2", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftlegs2", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.0F, 0.0F, -2.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftlegs3", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.0F, 6.0F, -2.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightlegs3", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 6.0F, -2.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("horn1", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(1.0F, -7.0F, -12.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

		partdefinition.addOrReplaceChild("horn2", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(-3.0F, -7.0F, -12.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leftlegs1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftlegs2.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftlegs3.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftfoot.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

		this.rightlegs1.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.rightlegs2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.rightlegs3.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.rightfoot.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

		this.rightarms1.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F + 0.0872665F;
		this.rightarms2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F + 0.1745329F;
		this.rightarms3.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F + 0.2617994F;
		this.rightarmtop.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarmbottom.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F + 0.3490659F;

		this.leftarms1.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F + 0.0872665F;
		this.leftarms2.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F + 0.1745329F;
		this.leftarms3.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F + 0.2617994F;
		this.leftarmtop.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarmbottom.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F + 0.3490659F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarmtop.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarmtop.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarmbottom.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarmbottom.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarms1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarms1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarms2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarms2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarms3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarms3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftlegs1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightlegs1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightfoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftfoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightlegs2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftlegs2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftlegs3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightlegs3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		horn1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		horn2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}