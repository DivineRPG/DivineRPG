package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.base.EntityDivineTameable;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelEhu<T extends EntityDivineTameable> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("ehu");
	private final ModelPart body, head, BackLeftLeg, BackRightLeg, FrontLeftLeg, FrontRightLeg;

	public ModelEhu(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.BackLeftLeg = root.getChild("BackLeftLeg");
		this.BackRightLeg = root.getChild("BackRightLeg");
		this.FrontLeftLeg = root.getChild("FrontLeftLeg");
		this.FrontRightLeg = root.getChild("FrontRightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(13, 34).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, 3.0F));

		partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(31, 29).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 0.0F, 3.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 46).addBox(-5.0F, -4.0F, -6.01F, 10.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
			.texOffs(0, 25).addBox(0.0F, -7.0F, -6.0F, 0.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
			.texOffs(0, 0).addBox(-5.0F, -4.0F, -6.0F, 10.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		body.addOrReplaceChild("lowerbody", CubeListBuilder.create().texOffs(0, 18).addBox(-5.5F, -5.5F, 0.0F, 11.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

		partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(31, 41).addBox(-1.5F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 0.0F, -3.0F));

		partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(36, 14).addBox(-2.5F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 0.0F, -3.0F));

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(30, 0).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
			.texOffs(0, 0).addBox(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entity.isInSittingPose()) {
			this.head.y = 19.5F;
			this.body.y = 19.5F;
			this.FrontLeftLeg.y = 22.5F;
			this.FrontRightLeg.y = 22.5F;
			this.BackLeftLeg.y = 21.99F;
			this.BackRightLeg.y = 21.99F;
			this.FrontLeftLeg.xRot = 0F;
			this.FrontRightLeg.xRot = 0F;
			this.BackLeftLeg.xRot = 0F;
			this.BackRightLeg.xRot = 0F;
			this.BackRightLeg.zRot = (float)Math.PI / 2F;
			this.BackLeftLeg.zRot = -(float)Math.PI / 2F;
			this.FrontRightLeg.zRot = this.BackRightLeg.zRot;
			this.FrontLeftLeg.zRot = this.BackLeftLeg.zRot;
		} else {
			this.head.y = 16F;
			this.body.y = 16F;
			this.FrontLeftLeg.y = 18F;
			this.FrontRightLeg.y = 18F;
			this.BackLeftLeg.y = 18F;
			this.BackRightLeg.y = 18F;
			this.BackRightLeg.zRot = 0F;
			this.BackLeftLeg.zRot = 0F;
			this.FrontRightLeg.zRot = this.BackRightLeg.zRot;
			this.FrontLeftLeg.zRot = this.BackLeftLeg.zRot;
			this.FrontLeftLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
			this.FrontRightLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
			this.BackLeftLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
			this.BackRightLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
		}
		this.head.xRot = headPitch * ((float)Math.PI / 360F);
		this.head.yRot = netHeadYaw * ((float)Math.PI / 360F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}