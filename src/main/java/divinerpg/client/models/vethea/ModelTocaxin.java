package divinerpg.client.models.vethea;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelTocaxin<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("tocaxin");
	private final ModelPart part1;
	private final ModelPart part2;
	private final ModelPart rightarm1;
	private final ModelPart leftarm1;
	private final ModelPart leftleg1;
	private final ModelPart rightleg1;
	private final ModelPart leftleg2;
	private final ModelPart rightleg2;
	private final ModelPart part3;
	private final ModelPart part4;
	private final ModelPart part5;
	private final ModelPart part6;
	private final ModelPart rightarm2;
	private final ModelPart leftarm2;
	private final ModelPart rightarm3;
	private final ModelPart leftarm3;
	private final ModelPart part7;
	private final ModelPart part8;
	private final ModelPart part9;
	private final ModelPart part10;
	private final ModelPart part11;

	public ModelTocaxin(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.part1 = root.getChild("part1");
		this.part2 = root.getChild("part2");
		this.rightarm1 = root.getChild("rightarm1");
		this.leftarm1 = root.getChild("leftarm1");
		this.leftleg1 = root.getChild("leftleg1");
		this.rightleg1 = root.getChild("rightleg1");
		this.leftleg2 = root.getChild("leftleg2");
		this.rightleg2 = root.getChild("rightleg2");
		this.part3 = root.getChild("part3");
		this.part4 = root.getChild("part4");
		this.part5 = root.getChild("part5");
		this.part6 = root.getChild("part6");
		this.rightarm2 = root.getChild("rightarm2");
		this.leftarm2 = root.getChild("leftarm2");
		this.rightarm3 = root.getChild("rightarm3");
		this.leftarm3 = root.getChild("leftarm3");
		this.part7 = root.getChild("part7");
		this.part8 = root.getChild("part8");
		this.part9 = root.getChild("part9");
		this.part10 = root.getChild("part10");
		this.part11 = root.getChild("part11");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("part1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -10.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -22.0F, -7.0F, 0.4014F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part2", CubeListBuilder.create().texOffs(34, 2).mirror().addBox(-2.0F, -15.0F, -4.0F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -12.0F, 0.0F, 0.4014F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm1", CubeListBuilder.create().texOffs(64, 0).mirror().addBox(-2.0F, 8.0F, 4.0F, 2.0F, 2.0F, 30.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, -10.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm1", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, -10.0F, 0.0F, -1.0472F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg1", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 12.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg1", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 12.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg2", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg2", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part3", CubeListBuilder.create().texOffs(46, 9).mirror().addBox(-7.0F, 0.0F, 0.0F, 20.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -12.0F, -4.0F, 0.4014F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part4", CubeListBuilder.create().texOffs(68, 15).mirror().addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -12.0F, -4.0F, 0.4014F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part5", CubeListBuilder.create().texOffs(59, 2).mirror().addBox(-4.0F, -4.0F, 0.0F, 14.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -12.0F, -4.0F, 0.4014F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part6", CubeListBuilder.create().texOffs(59, 2).mirror().addBox(-4.0F, -9.0F, 0.0F, 14.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -12.0F, -4.0F, 0.4014F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm2", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, -10.0F, 0.0F, -1.0472F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm2", CubeListBuilder.create().texOffs(64, 0).mirror().addBox(0.0F, 8.0F, 4.0F, 2.0F, 2.0F, 30.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, -10.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm3", CubeListBuilder.create().texOffs(100, 16).mirror().addBox(-4.0F, 6.0F, 1.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, -10.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm3", CubeListBuilder.create().texOffs(100, 16).mirror().addBox(-2.0F, 6.0F, 1.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, -10.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part7", CubeListBuilder.create().texOffs(41, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -12.0F, 0.0F, 0.4014F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part8", CubeListBuilder.create().texOffs(41, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -12.0F, -4.0F, 0.4014F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part9", CubeListBuilder.create().texOffs(59, 2).mirror().addBox(-4.0F, 10.0F, 0.0F, 14.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -12.0F, -4.0F, 0.4014F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part10", CubeListBuilder.create().texOffs(59, 2).mirror().addBox(-4.0F, 5.0F, 0.0F, 14.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -12.0F, -4.0F, 0.4014F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("part11", CubeListBuilder.create().texOffs(68, 15).mirror().addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -12.0F, 0.0F, 0.4014F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leftleg1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftleg2.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

		this.rightleg1.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.rightleg2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

		this.rightarm1.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F + -1.570796F;
		this.rightarm2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F-1.047198F;
		this.rightarm3.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F-1.570796F;

		this.leftarm1.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F-1.047198F;
		this.leftarm2.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F-1.570796F;
		this.leftarm3.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F-1.570796F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		part1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftleg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightleg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		rightarm3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leftarm3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part7.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part8.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part9.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part10.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		part11.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}