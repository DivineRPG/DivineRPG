package divinerpg.client.models.vethea;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelBohemite<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("bohemite");
	private final ModelPart spine1;
	private final ModelPart bodyp1;
	private final ModelPart rightarmp1;
	private final ModelPart leftarmp1;
	private final ModelPart rightlegp1;
	private final ModelPart leftlegp1;
	private final ModelPart head;
	private final ModelPart spine2;
	private final ModelPart spine3;
	private final ModelPart spine4;
	private final ModelPart spine5;
	private final ModelPart spine6;
	private final ModelPart spine7;
	private final ModelPart spine9;
	private final ModelPart spine8;
	private final ModelPart spine10;
	private final ModelPart bodyp2;
	private final ModelPart bodyp3;
	private final ModelPart bodyp4;
	private final ModelPart bodyp5;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart leftarmp2;
	private final ModelPart rightarmp2;
	private final ModelPart leftarmp3;
	private final ModelPart leftarmp4;
	private final ModelPart rightarmp3;
	private final ModelPart rightarmp4;
	private final ModelPart rightarmp5;
	private final ModelPart rightarmp6;
	private final ModelPart leftarmp5;
	private final ModelPart leftarmp6;
	private final ModelPart leftleg;
	private final ModelPart rightleg;
	private final ModelPart rightlegp2;
	private final ModelPart leftlegp2;
	private final ModelPart leftarm7;
	private final ModelPart leftarm8;
	private final ModelPart rightarm7;
	private final ModelPart rightarm8;

	public ModelBohemite(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.spine1 = root.getChild("spine1");
		this.bodyp1 = root.getChild("bodyp1");
		this.rightarmp1 = root.getChild("rightarmp1");
		this.leftarmp1 = root.getChild("leftarmp1");
		this.rightlegp1 = root.getChild("rightlegp1");
		this.leftlegp1 = root.getChild("leftlegp1");
		this.head = root.getChild("head");
		this.spine2 = root.getChild("spine2");
		this.spine3 = root.getChild("spine3");
		this.spine4 = root.getChild("spine4");
		this.spine5 = root.getChild("spine5");
		this.spine6 = root.getChild("spine6");
		this.spine7 = root.getChild("spine7");
		this.spine9 = root.getChild("spine9");
		this.spine8 = root.getChild("spine8");
		this.spine10 = root.getChild("spine10");
		this.bodyp2 = root.getChild("bodyp2");
		this.bodyp3 = root.getChild("bodyp3");
		this.bodyp4 = root.getChild("bodyp4");
		this.bodyp5 = root.getChild("bodyp5");
		this.leftarm = root.getChild("leftarm");
		this.rightarm = root.getChild("rightarm");
		this.leftarmp2 = root.getChild("leftarmp2");
		this.rightarmp2 = root.getChild("rightarmp2");
		this.leftarmp3 = root.getChild("leftarmp3");
		this.leftarmp4 = root.getChild("leftarmp4");
		this.rightarmp3 = root.getChild("rightarmp3");
		this.rightarmp4 = root.getChild("rightarmp4");
		this.rightarmp5 = root.getChild("rightarmp5");
		this.rightarmp6 = root.getChild("rightarmp6");
		this.leftarmp5 = root.getChild("leftarmp5");
		this.leftarmp6 = root.getChild("leftarmp6");
		this.leftleg = root.getChild("leftleg");
		this.rightleg = root.getChild("rightleg");
		this.rightlegp2 = root.getChild("rightlegp2");
		this.leftlegp2 = root.getChild("leftlegp2");
		this.leftarm7 = root.getChild("leftarm7");
		this.leftarm8 = root.getChild("leftarm8");
		this.rightarm7 = root.getChild("rightarm7");
		this.rightarm8 = root.getChild("rightarm8");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("spine1", CubeListBuilder.create().texOffs(45, 2).mirror().addBox(4.0F, -3.0F, -2.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("bodyp1", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 4.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarmp1", CubeListBuilder.create().texOffs(32, 6).mirror().addBox(1.0F, 10.0F, -17.0F, 1.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarmp1", CubeListBuilder.create().texOffs(32, 6).mirror().addBox(3.0F, 10.0F, -17.0F, 1.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(9.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightlegp1", CubeListBuilder.create().texOffs(17, 26).mirror().addBox(-5.0F, 1.0F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftlegp1", CubeListBuilder.create().texOffs(17, 26).mirror().addBox(2.0F, 1.0F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spine2", CubeListBuilder.create().texOffs(45, 2).mirror().addBox(0.0F, -5.0F, 6.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.2217F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spine3", CubeListBuilder.create().texOffs(45, 2).mirror().addBox(4.0F, -6.0F, 0.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spine4", CubeListBuilder.create().texOffs(45, 2).mirror().addBox(-5.0F, -3.0F, -2.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spine5", CubeListBuilder.create().texOffs(45, 2).mirror().addBox(-5.0F, -6.0F, 0.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spine6", CubeListBuilder.create().texOffs(45, 2).mirror().addBox(-5.0F, -8.0F, 1.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6109F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spine7", CubeListBuilder.create().texOffs(45, 2).mirror().addBox(4.0F, -8.0F, 1.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6109F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spine9", CubeListBuilder.create().texOffs(45, 2).mirror().addBox(2.0F, -7.0F, 4.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.9599F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spine8", CubeListBuilder.create().texOffs(45, 2).mirror().addBox(-3.0F, -7.0F, 4.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.9599F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("spine10", CubeListBuilder.create().texOffs(45, 2).mirror().addBox(-1.0F, -5.0F, 6.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.2217F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("bodyp2", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("bodyp3", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 8.0F, 0.0F));

		partdefinition.addOrReplaceChild("bodyp4", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 4.0F, 0.0F));

		partdefinition.addOrReplaceChild("bodyp5", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(9.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarmp2", CubeListBuilder.create().texOffs(32, 6).mirror().addBox(-2.0F, 10.0F, -17.0F, 1.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(9.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarmp2", CubeListBuilder.create().texOffs(32, 6).mirror().addBox(-4.0F, 10.0F, -17.0F, 1.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarmp3", CubeListBuilder.create().texOffs(32, 6).mirror().addBox(3.0F, 8.0F, -3.0F, 1.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(9.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarmp4", CubeListBuilder.create().texOffs(32, 6).mirror().addBox(-2.0F, 8.0F, -3.0F, 1.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(9.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarmp3", CubeListBuilder.create().texOffs(32, 6).mirror().addBox(1.0F, 8.0F, -3.0F, 1.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarmp4", CubeListBuilder.create().texOffs(32, 6).mirror().addBox(-4.0F, 8.0F, -3.0F, 1.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarmp5", CubeListBuilder.create().texOffs(32, 6).mirror().addBox(-4.0F, 8.0F, -10.0F, 1.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarmp6", CubeListBuilder.create().texOffs(32, 6).mirror().addBox(1.0F, 8.0F, -10.0F, 1.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarmp5", CubeListBuilder.create().texOffs(32, 6).mirror().addBox(-2.0F, 8.0F, -10.0F, 1.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(9.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarmp6", CubeListBuilder.create().texOffs(32, 6).mirror().addBox(3.0F, 8.0F, -10.0F, 1.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(9.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightlegp2", CubeListBuilder.create().texOffs(28, 26).mirror().addBox(-5.0F, 6.0F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftlegp2", CubeListBuilder.create().texOffs(28, 26).mirror().addBox(2.0F, 6.0F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm7", CubeListBuilder.create().texOffs(32, 6).mirror().addBox(3.0F, 8.0F, -17.0F, 1.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(9.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm8", CubeListBuilder.create().texOffs(32, 6).mirror().addBox(-2.0F, 8.0F, -17.0F, 1.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(9.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm7", CubeListBuilder.create().texOffs(32, 6).mirror().addBox(1.0F, 8.0F, -17.0F, 1.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm8", CubeListBuilder.create().texOffs(32, 6).mirror().addBox(-4.0F, 8.0F, -17.0F, 1.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 2.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.leftleg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftlegp1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

        this.rightleg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.rightlegp2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

        this.rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.rightarmp1.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.rightarmp2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.rightarmp3.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.rightarmp4.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.rightarmp5.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.rightarmp6.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.rightarm7.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.rightarm8.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;

        this.leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.leftarmp1.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.leftarmp2.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.leftarmp3.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.leftarmp4.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.leftarmp5.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.leftarmp6.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.leftarm7.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.leftarm8.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		spine1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		bodyp1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarmp1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarmp1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightlegp1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftlegp1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		spine2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		spine3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		spine4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		spine5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		spine6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		spine7.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		spine9.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		spine8.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		spine10.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		bodyp2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		bodyp3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		bodyp4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		bodyp5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarmp2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarmp2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarmp3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarmp4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarmp3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarmp4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarmp5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarmp6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarmp5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarmp6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightlegp2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftlegp2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm7.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm8.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarm7.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarm8.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}