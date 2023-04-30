package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelRollum<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("rollum");
	private final ModelPart head;
	private final ModelPart connector;
	private final ModelPart rightarmtop;
	private final ModelPart rightlegbottom;
	private final ModelPart rightleg;
	private final ModelPart leftlegbottom;
	private final ModelPart leftleg;
	private final ModelPart rightarm;
	private final ModelPart rightarmext;
	private final ModelPart leftarmtop;
	private final ModelPart leftarm;
	private final ModelPart leftarmext;
	private final ModelPart body;

	public ModelRollum(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.head = root.getChild("head");
		this.connector = root.getChild("connector");
		this.rightarmtop = root.getChild("rightarmtop");
		this.rightlegbottom = root.getChild("rightlegbottom");
		this.rightleg = root.getChild("rightleg");
		this.leftlegbottom = root.getChild("leftlegbottom");
		this.leftleg = root.getChild("leftleg");
		this.rightarm = root.getChild("rightarm");
		this.rightarmext = root.getChild("rightarmext");
		this.leftarmtop = root.getChild("leftarmtop");
		this.leftarm = root.getChild("leftarm");
		this.leftarmext = root.getChild("leftarmext");
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 5.0F, -10.0F));

		partdefinition.addOrReplaceChild("connector", CubeListBuilder.create().texOffs(30, 14).mirror().addBox(-4.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 1.0F, -2.0F, -1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarmtop", CubeListBuilder.create().texOffs(36, 16).mirror().addBox(-6.0F, -3.0F, -2.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, -5.0F, -1.0F));

		partdefinition.addOrReplaceChild("rightlegbottom", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-3.0F, 8.0F, -3.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 7.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 7.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftlegbottom", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-3.0F, 8.0F, -3.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 7.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 7.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-5.0F, 2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, -5.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarmext", CubeListBuilder.create().texOffs(30, 18).mirror().addBox(-5.0F, 9.0F, -10.0F, 4.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, -5.0F, -1.0F));

		partdefinition.addOrReplaceChild("leftarmtop", CubeListBuilder.create().texOffs(36, 16).mirror().addBox(-3.0F, -3.0F, -2.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, -5.0F, -1.0F));

		partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(0.0F, 2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, -5.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarmext", CubeListBuilder.create().texOffs(30, 18).mirror().addBox(0.0F, 9.0F, -10.0F, 4.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, -5.0F, -1.0F));

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(30, 14).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -7.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float)Math.PI);
		this.head.xRot = headPitch / (180F / (float)Math.PI);
		this.rightarmtop.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarmtop.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarmtop.zRot = 0.0F;
		this.leftarmtop.zRot = 0.0F;
		this.rightlegbottom.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftlegbottom.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.rightlegbottom.yRot = 0.0F;
		this.leftlegbottom.yRot = 0.0F;
		this.rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarm.zRot = 0.0F;
		this.leftarm.zRot = 0.0F;
		this.rightleg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftleg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.rightleg.yRot = 0.0F;
		this.leftleg.yRot = 0.0F;

		this.rightarmext.xRot = Mth.cos(-(limbSwing * 0.6662F + (float)Math.PI)) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarmext.xRot = Mth.cos(-(limbSwing * 0.6662F)) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarmext.zRot = 0.0F;
		this.leftarmext.zRot = 0.0F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		connector.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarmtop.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightlegbottom.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftlegbottom.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarmext.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarmtop.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarmext.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}