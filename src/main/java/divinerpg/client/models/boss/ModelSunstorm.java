package divinerpg.client.models.boss;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelSunstorm<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("sunstorm");
	private final ModelPart legR;
	private final ModelPart legL;
	private final ModelPart body;
	private final ModelPart armL;
	private final ModelPart armR;
	private final ModelPart neck;
	private final ModelPart head;
	private final ModelPart headSideL;
	private final ModelPart headSideR;
	private final ModelPart backSpine1;
	private final ModelPart backSpine2;
	private final ModelPart backSpine3;

	public ModelSunstorm(ModelPart root) {
		this.legR = root.getChild("legR");
		this.legL = root.getChild("legL");
		this.body = root.getChild("body");
		this.armL = root.getChild("armL");
		this.armR = root.getChild("armR");
		this.neck = root.getChild("neck");
		this.head = root.getChild("head");
		this.headSideL = root.getChild("headSideL");
		this.headSideR = root.getChild("headSideR");
		this.backSpine1 = root.getChild("backSpine1");
		this.backSpine2 = root.getChild("backSpine2");
		this.backSpine3 = root.getChild("backSpine3");
	}
	public ModelSunstorm(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.legR = root.getChild("legR");
		this.legL = root.getChild("legL");
		this.body = root.getChild("body");
		this.armL = root.getChild("armL");
		this.armR = root.getChild("armR");
		this.neck = root.getChild("neck");
		this.head = root.getChild("head");
		this.headSideL = root.getChild("headSideL");
		this.headSideR = root.getChild("headSideR");
		this.backSpine1 = root.getChild("backSpine1");
		this.backSpine2 = root.getChild("backSpine2");
		this.backSpine3 = root.getChild("backSpine3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("legR", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 8.0F, 0.0F));

		partdefinition.addOrReplaceChild("legL", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 8.0F, 0.0F));

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 12.0F, 20.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, -12.0F, -3.0F));

		PartDefinition armL = partdefinition.addOrReplaceChild("armL", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, -10.0F, 0.0F, -1.0472F, 0.0F, 0.0F));

		armL.addOrReplaceChild("armSpikeL", CubeListBuilder.create().texOffs(0, 62).mirror().addBox(2.0F, 6.0F, -1.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 1.0F, 6.5F, -1.0472F, 0.0F, 0.0F));

		armL.addOrReplaceChild("staffPoleL", CubeListBuilder.create().texOffs(0, 104).mirror().addBox(-1.0F, -9.0F, -17.0F, 2.0F, 22.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 1.5236F, 0.0F, 0.0F));

		armL.addOrReplaceChild("staffCapL", CubeListBuilder.create().texOffs(8, 121).mirror().addBox(-3.0F, -7.0F, -19.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 1.5236F, 0.0F, 0.0F));

		armL.addOrReplaceChild("staffProng1L", CubeListBuilder.create().texOffs(32, 123).mirror().addBox(2.0F, -11.0F, -14.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 1.5236F, 0.0F, 0.0F));

		armL.addOrReplaceChild("staffProng2L", CubeListBuilder.create().texOffs(32, 123).mirror().addBox(2.0F, -11.0F, -19.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 1.5236F, 0.0F, 0.0F));

		armL.addOrReplaceChild("staffProng3L", CubeListBuilder.create().texOffs(32, 123).mirror().addBox(-3.0F, -11.0F, -19.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 1.5236F, 0.0F, 0.0F));

		armL.addOrReplaceChild("staffProng4L", CubeListBuilder.create().texOffs(32, 123).mirror().addBox(-3.0F, -11.0F, -14.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 1.5236F, 0.0F, 0.0F));

		PartDefinition armR = partdefinition.addOrReplaceChild("armR", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, -10.0F, 0.0F, -1.0472F, 0.0F, 0.0F));

		armR.addOrReplaceChild("armSpikeR", CubeListBuilder.create().texOffs(0, 62).mirror().addBox(-8.0F, 6.0F, -1.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.0F, 6.5F, -1.0472F, 0.0F, 0.0F));

		armR.addOrReplaceChild("staffPoleR", CubeListBuilder.create().texOffs(0, 104).mirror().addBox(-1.0F, -9.0F, -17.0F, 2.0F, 22.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 1.5236F, 0.0F, 0.0F));

		armR.addOrReplaceChild("staffCapR", CubeListBuilder.create().texOffs(8, 121).mirror().addBox(-3.0F, -7.0F, -19.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 1.5236F, 0.0F, 0.0F));

		armR.addOrReplaceChild("staffProng1R", CubeListBuilder.create().texOffs(32, 123).mirror().addBox(2.0F, -11.0F, -14.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 1.5236F, 0.0F, 0.0F));

		armR.addOrReplaceChild("staffProng2R", CubeListBuilder.create().texOffs(32, 123).mirror().addBox(2.0F, -11.0F, -19.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 1.5236F, 0.0F, 0.0F));

		armR.addOrReplaceChild("staffProng3R", CubeListBuilder.create().texOffs(32, 123).mirror().addBox(-3.0F, -11.0F, -19.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 1.5236F, 0.0F, 0.0F));

		armR.addOrReplaceChild("staffProng4R", CubeListBuilder.create().texOffs(32, 123).mirror().addBox(-3.0F, -11.0F, -14.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 1.5236F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(60, 0).mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -16.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(60, 10).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -16.0F, 0.0F));

		head.addOrReplaceChild("rayR", CubeListBuilder.create().texOffs(84, 0).mirror().addBox(-2.5F, -15.0F, 0.0F, 5.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		head.addOrReplaceChild("rayMid", CubeListBuilder.create().texOffs(84, 0).mirror().addBox(-2.5F, -15.0F, 0.0F, 5.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -3.0F, 0.0F));

		head.addOrReplaceChild("rayL", CubeListBuilder.create().texOffs(84, 0).mirror().addBox(-2.5F, -15.0F, 0.0F, 5.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		partdefinition.addOrReplaceChild("headSideL", CubeListBuilder.create().texOffs(0, 67).mirror().addBox(4.0F, -3.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -16.0F, 0.0F));

		partdefinition.addOrReplaceChild("headSideR", CubeListBuilder.create().texOffs(0, 67).mirror().addBox(-8.0F, -3.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -16.0F, 0.0F));

		partdefinition.addOrReplaceChild("backSpine1", CubeListBuilder.create().texOffs(0, 71).mirror().addBox(-1.0F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, 2.0F, -0.384F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("backSpine2", CubeListBuilder.create().texOffs(0, 71).mirror().addBox(-1.0F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.0F, 2.0F, -0.384F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("backSpine3", CubeListBuilder.create().texOffs(0, 71).mirror().addBox(-1.0F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -7.0F, 2.0F, -0.384F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.armR.xRot = (Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F);
		this.armL.xRot = (Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount * 0.5F);
		this.legR.xRot = (Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
		this.legL.xRot = (Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		legR.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		legL.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		armL.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		armR.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		neck.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		headSideL.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		headSideR.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		backSpine1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		backSpine2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		backSpine3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}