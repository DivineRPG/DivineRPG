package divinerpg.client.models.vethea;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelDreamwrecker<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("dreamwrecker");
	private final ModelPart head;
	private final ModelPart bodyt1;
	private final ModelPart rightarmb;
	private final ModelPart leftarmb;
	private final ModelPart rightlegb;
	private final ModelPart leftlegb;
	private final ModelPart bodyt2;
	private final ModelPart rightlegt;
	private final ModelPart leftlegt;
	private final ModelPart body1;
	private final ModelPart body2;
	private final ModelPart bodyb1;
	private final ModelPart bodyb2;
	private final ModelPart rightarmt;
	private final ModelPart leftarmt;
	private final ModelPart rightarmspike1;
	private final ModelPart leftarmspike1;
	private final ModelPart body3;
	private final ModelPart seg1;
	private final ModelPart seg2;
	private final ModelPart seg3;
	private final ModelPart seg4;
	private final ModelPart seg5;
	private final ModelPart seg6;
	private final ModelPart seg7;
	private final ModelPart seg8;
	private final ModelPart seg9;
	private final ModelPart seg10;
	private final ModelPart seg11;
	private final ModelPart seg12;
	private final ModelPart seg13;
	private final ModelPart leftarmm;
	private final ModelPart rightarmm;
	private final ModelPart leftarmspike2;
	private final ModelPart rightarmspike2;
	private final ModelPart leftarmspike3;
	private final ModelPart rightarmspike3;
	private final ModelPart rightarmspike4;
	private final ModelPart leftarmspike4;
	private final ModelPart seg14;
	private final ModelPart seg15;
	private final ModelPart seg16;
	private final ModelPart seg17;
	private final ModelPart seg18;

	public ModelDreamwrecker(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.head = root.getChild("head");
		this.bodyt1 = root.getChild("bodyt1");
		this.rightarmb = root.getChild("rightarmb");
		this.leftarmb = root.getChild("leftarmb");
		this.rightlegb = root.getChild("rightlegb");
		this.leftlegb = root.getChild("leftlegb");
		this.bodyt2 = root.getChild("bodyt2");
		this.rightlegt = root.getChild("rightlegt");
		this.leftlegt = root.getChild("leftlegt");
		this.body1 = root.getChild("body1");
		this.body2 = root.getChild("body2");
		this.bodyb1 = root.getChild("bodyb1");
		this.bodyb2 = root.getChild("bodyb2");
		this.rightarmt = root.getChild("rightarmt");
		this.leftarmt = root.getChild("leftarmt");
		this.rightarmspike1 = root.getChild("rightarmspike1");
		this.leftarmspike1 = root.getChild("leftarmspike1");
		this.body3 = root.getChild("body3");
		this.seg1 = root.getChild("seg1");
		this.seg2 = root.getChild("seg2");
		this.seg3 = root.getChild("seg3");
		this.seg4 = root.getChild("seg4");
		this.seg5 = root.getChild("seg5");
		this.seg6 = root.getChild("seg6");
		this.seg7 = root.getChild("seg7");
		this.seg8 = root.getChild("seg8");
		this.seg9 = root.getChild("seg9");
		this.seg10 = root.getChild("seg10");
		this.seg11 = root.getChild("seg11");
		this.seg12 = root.getChild("seg12");
		this.seg13 = root.getChild("seg13");
		this.leftarmm = root.getChild("leftarmm");
		this.rightarmm = root.getChild("rightarmm");
		this.leftarmspike2 = root.getChild("leftarmspike2");
		this.rightarmspike2 = root.getChild("rightarmspike2");
		this.leftarmspike3 = root.getChild("leftarmspike3");
		this.rightarmspike3 = root.getChild("rightarmspike3");
		this.rightarmspike4 = root.getChild("rightarmspike4");
		this.leftarmspike4 = root.getChild("leftarmspike4");
		this.seg14 = root.getChild("seg14");
		this.seg15 = root.getChild("seg15");
		this.seg16 = root.getChild("seg16");
		this.seg17 = root.getChild("seg17");
		this.seg18 = root.getChild("seg18");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -41.0F, -3.0F));

		partdefinition.addOrReplaceChild("bodyt1", CubeListBuilder.create().texOffs(16, 18).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, -30.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarmb", CubeListBuilder.create().texOffs(48, 8).mirror().addBox(-3.0F, 18.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, -26.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarmb", CubeListBuilder.create().texOffs(48, 8).mirror().addBox(-1.0F, 18.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(9.0F, -26.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightlegb", CubeListBuilder.create().texOffs(0, 17).mirror().addBox(-2.0F, 8.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 6.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftlegb", CubeListBuilder.create().texOffs(0, 17).mirror().addBox(-2.0F, 8.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 6.0F, 0.0F));

		partdefinition.addOrReplaceChild("bodyt2", CubeListBuilder.create().texOffs(16, 18).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, -30.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightlegt", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 6.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftlegt", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 6.0F, 0.0F));

		partdefinition.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(16, 18).mirror().addBox(-4.0F, 0.0F, -2.0F, 6.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, -8.0F, 0.0F));

		partdefinition.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(16, 18).mirror().addBox(-4.0F, 0.0F, -2.0F, 6.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, -16.0F, 0.0F));

		partdefinition.addOrReplaceChild("bodyb1", CubeListBuilder.create().texOffs(16, 18).mirror().addBox(-4.0F, 0.0F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("bodyb2", CubeListBuilder.create().texOffs(16, 18).mirror().addBox(-4.0F, 0.0F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarmt", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, -26.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarmt", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(9.0F, -26.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarmspike1", CubeListBuilder.create().texOffs(0, 17).mirror().addBox(1.0F, 21.0F, 0.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, -26.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarmspike1", CubeListBuilder.create().texOffs(0, 17).mirror().addBox(3.0F, 21.0F, 0.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(9.0F, -26.0F, 0.0F));

		partdefinition.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(16, 18).mirror().addBox(-4.0F, 0.0F, -2.0F, 6.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, -24.0F, 0.0F));

		partdefinition.addOrReplaceChild("seg1", CubeListBuilder.create().texOffs(16, 18).mirror().addBox(-4.0F, -8.0F, 2.0F, 6.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, -20.0F, 1.0F));

		partdefinition.addOrReplaceChild("seg2", CubeListBuilder.create().texOffs(16, 18).mirror().addBox(-4.0F, -8.0F, 1.0F, 6.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, -35.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("seg3", CubeListBuilder.create().texOffs(16, 18).mirror().addBox(-4.0F, -3.0F, 2.0F, 6.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, -35.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("seg4", CubeListBuilder.create().texOffs(16, 18).mirror().addBox(-4.0F, 2.0F, 2.0F, 6.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, -35.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("seg5", CubeListBuilder.create().texOffs(16, 18).mirror().addBox(-4.0F, -8.0F, 1.0F, 6.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, -15.0F, 1.0F, -0.1745F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("seg6", CubeListBuilder.create().texOffs(16, 18).mirror().addBox(-4.0F, -3.0F, 1.0F, 6.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, -15.0F, 1.0F, -0.3491F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("seg7", CubeListBuilder.create().texOffs(42, 2).mirror().addBox(-5.0F, -9.0F, 6.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, -33.0F, 0.0F, 1.0472F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("seg8", CubeListBuilder.create().texOffs(16, 18).mirror().addBox(-4.0F, 2.0F, 1.0F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, -15.0F, 1.0F, -0.5236F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("seg9", CubeListBuilder.create().texOffs(36, 0).mirror().addBox(-5.0F, 2.0F, 0.0F, 8.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, -15.0F, 1.0F, -0.6981F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("seg10", CubeListBuilder.create().texOffs(36, 0).mirror().addBox(-5.0F, -4.0F, 0.0F, 8.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, -15.0F, 1.0F, -0.3491F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("seg11", CubeListBuilder.create().texOffs(36, 0).mirror().addBox(-5.0F, -9.0F, 0.0F, 8.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, -15.0F, 1.0F, -0.1745F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("seg12", CubeListBuilder.create().texOffs(36, 0).mirror().addBox(-5.0F, -9.0F, 0.0F, 8.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, -20.0F, 2.0F));

		partdefinition.addOrReplaceChild("seg13", CubeListBuilder.create().texOffs(36, 0).mirror().addBox(-5.0F, -9.0F, 0.0F, 8.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, -26.0F, 3.0F, 0.1745F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarmm", CubeListBuilder.create().texOffs(40, 20).mirror().addBox(-1.0F, 10.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(9.0F, -26.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarmm", CubeListBuilder.create().texOffs(40, 20).mirror().addBox(-3.0F, 10.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, -26.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarmspike2", CubeListBuilder.create().texOffs(0, 17).mirror().addBox(3.0F, 21.0F, -11.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(9.0F, -26.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarmspike2", CubeListBuilder.create().texOffs(0, 17).mirror().addBox(1.0F, 21.0F, -11.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, -26.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarmspike3", CubeListBuilder.create().texOffs(0, 17).mirror().addBox(-2.0F, 21.0F, 0.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(9.0F, -26.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarmspike3", CubeListBuilder.create().texOffs(0, 17).mirror().addBox(-4.0F, 21.0F, 0.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, -26.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarmspike4", CubeListBuilder.create().texOffs(0, 17).mirror().addBox(-4.0F, 21.0F, -11.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, -26.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarmspike4", CubeListBuilder.create().texOffs(0, 17).mirror().addBox(-2.0F, 21.0F, -11.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(9.0F, -26.0F, 0.0F));

		partdefinition.addOrReplaceChild("seg14", CubeListBuilder.create().texOffs(36, 0).mirror().addBox(-5.0F, 0.0F, 0.0F, 8.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, -15.0F, 1.0F, -0.5236F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("seg15", CubeListBuilder.create().texOffs(36, 0).mirror().addBox(-5.0F, -9.0F, 0.0F, 8.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, -31.0F, 2.0F, 0.3491F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("seg16", CubeListBuilder.create().texOffs(42, 2).mirror().addBox(-5.0F, -9.0F, 6.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -33.0F, 0.0F, 1.0472F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("seg17", CubeListBuilder.create().texOffs(36, 0).mirror().addBox(-5.0F, -9.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, -33.0F, 0.0F, 1.0472F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("seg18", CubeListBuilder.create().texOffs(36, 0).mirror().addBox(-5.0F, -9.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -33.0F, 0.0F, 1.0472F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leftlegt.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftlegb.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

		this.rightlegt.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.rightlegb.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

		this.rightarmt.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarmm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarmb.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarmspike1.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarmspike2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarmspike3.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarmspike4.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;

		this.leftarmt.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarmm.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarmb.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarmspike1.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarmspike2.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarmspike3.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarmspike4.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bodyt1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarmb.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarmb.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightlegb.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftlegb.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bodyt2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightlegt.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftlegt.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bodyb1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bodyb2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarmt.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarmt.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarmspike1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarmspike1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		seg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		seg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		seg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		seg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		seg5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		seg6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		seg7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		seg8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		seg9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		seg10.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		seg11.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		seg12.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		seg13.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarmm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarmm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarmspike2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarmspike2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarmspike3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarmspike3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarmspike4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarmspike4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		seg14.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		seg15.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		seg16.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		seg17.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		seg18.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}