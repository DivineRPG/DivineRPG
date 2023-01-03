package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;


public class ModelGreenfeet<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("greenfeet");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart leftarmbox;
	private final ModelPart leftarm;
	private final ModelPart rightlegext;
	private final ModelPart leftlegext;
	private final ModelPart leftleg;
	private final ModelPart rightleg;
	private final ModelPart rightarm;
	private final ModelPart rightarmbox;
	private final ModelPart Shape1;
	private final ModelPart Shape2;
	private final ModelPart Shape3;
	private final ModelPart Shape4;
	private final ModelPart Shape5;
	private final ModelPart Shape6;

	public ModelGreenfeet(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.leftarmbox = root.getChild("leftarmbox");
		this.leftarm = root.getChild("leftarm");
		this.rightlegext = root.getChild("rightlegext");
		this.leftlegext = root.getChild("leftlegext");
		this.leftleg = root.getChild("leftleg");
		this.rightleg = root.getChild("rightleg");
		this.rightarm = root.getChild("rightarm");
		this.rightarmbox = root.getChild("rightarmbox");
		this.Shape1 = root.getChild("Shape1");
		this.Shape2 = root.getChild("Shape2");
		this.Shape3 = root.getChild("Shape3");
		this.Shape4 = root.getChild("Shape4");
		this.Shape5 = root.getChild("Shape5");
		this.Shape6 = root.getChild("Shape6");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 2.0F));

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(25, 16).mirror().addBox(-7.0F, 0.0F, -2.0F, 14.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.4461F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarmbox", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(-2.0F, 10.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(8.0F, 2.0F, 3.0F));

		partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(8.0F, 2.0F, 3.0F));

		partdefinition.addOrReplaceChild("rightlegext", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -6.0F, 4.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 9.0F, 4.0F));

		partdefinition.addOrReplaceChild("leftlegext", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -6.0F, 4.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 9.0F, 4.0F));

		partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 3.0F, -6.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 9.0F, 4.0F));

		partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 3.0F, -6.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 9.0F, 4.0F));

		partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, 2.0F, 3.0F));

		partdefinition.addOrReplaceChild("rightarmbox", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(-4.0F, 10.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, 2.0F, 3.0F));

		partdefinition.addOrReplaceChild("Shape1", CubeListBuilder.create().texOffs(57, 0).mirror().addBox(-5.0F, 0.0F, 0.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -3.0F, 10.0F, -0.5949F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape2", CubeListBuilder.create().texOffs(57, 0).mirror().addBox(-5.0F, 0.0F, 0.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 0.0F, 12.0F, -0.5949F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape3", CubeListBuilder.create().texOffs(57, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -3.0F, 10.0F, -0.5949F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape4", CubeListBuilder.create().texOffs(57, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 0.0F, 12.0F, -0.5949F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape5", CubeListBuilder.create().texOffs(57, 0).mirror().addBox(5.0F, 0.0F, 0.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -3.0F, 10.0F, -0.5949F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("Shape6", CubeListBuilder.create().texOffs(57, 0).mirror().addBox(5.0F, 0.0F, 0.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 0.0F, 12.0F, -0.5949F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float)Math.PI);
		this.head.xRot = headPitch / (180F / (float)Math.PI);
		this.rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarmbox.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarmbox.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarm.zRot = 0.0F;
		this.rightarmbox.zRot = 0.0F;
		this.leftarm.zRot = 0.0F;
		this.leftarmbox.zRot = 0.0F;
		this.rightleg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.rightlegext.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leftleg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.leftlegext.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.rightleg.yRot = 0.0F;
		this.rightlegext.yRot = 0.0F;
		this.leftleg.yRot = 0.0F;
		this.leftlegext.yRot = 0.0F;

		this.rightarm.yRot = 0.0F;
		this.rightarmbox.yRot = 0.0F;
		this.leftarm.yRot = 0.0F;
		this.leftarmbox.yRot = 0.0F;

		this.rightarm.zRot += Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.leftarm.zRot -= Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.rightarmbox.zRot += Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.leftarmbox.zRot -= Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;

		this.rightarm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.leftarm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.rightarmbox.xRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		this.leftarmbox.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.05F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarmbox.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightlegext.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftlegext.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarmbox.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Shape6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}