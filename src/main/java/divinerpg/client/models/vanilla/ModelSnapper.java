package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.base.EntityDivineTameable;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelSnapper<T extends EntityDivineTameable> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("snapper");
	private final ModelPart Head, FrontRightLeg, FrontLeftLeg, BackLeftLeg, BackRightLeg, Body;

	public ModelSnapper(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Head = root.getChild("Head");
		this.FrontRightLeg = root.getChild("FrontRightLeg");
		this.FrontLeftLeg = root.getChild("FrontLeftLeg");
		this.BackLeftLeg = root.getChild("BackLeftLeg");
		this.BackRightLeg = root.getChild("BackRightLeg");
		this.Body = root.getChild("Body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(43, 43).addBox(-4.0F, -2.5F, -6.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -7.0F));

		partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-11.0F, -1.0F, -3.0F, 22.0F, 0.0F, 21.0F, new CubeDeformation(0.0F))
			.texOffs(0, 21).addBox(-9.0F, -5.0F, -1.0F, 18.0F, 5.0F, 17.0F, new CubeDeformation(0.0F))
			.texOffs(0, 43).addBox(-7.0F, 0.0F, 0.0F, 14.0F, 5.0F, 15.0F, new CubeDeformation(0.0F))
			.texOffs(0, 64).addBox(-5.0F, -1.0F, -0.15F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -7.0F));

		partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 0.0F, -4.0F));

		partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(0, 8).addBox(-1.5F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 0.0F, 4.0F));

		partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(0, 24).addBox(-2.5F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 0.0F, -4.0F));

		partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 0.0F, 4.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entity.isInSittingPose()) {
			this.Head.y = 21F;
			this.Body.y = 19F;
			this.FrontLeftLeg.y = 22.49F;
			this.FrontRightLeg.y = 22.49F;
			this.BackLeftLeg.y = 22.49F;
			this.BackRightLeg.y = 22.49F;
			this.FrontLeftLeg.xRot = 0F;
			this.FrontRightLeg.xRot = 0F;
			this.BackLeftLeg.xRot = 0F;
			this.BackRightLeg.xRot = 0F;
			this.BackRightLeg.zRot = (float)Math.PI / 2F;
			this.BackLeftLeg.zRot = -(float)Math.PI / 2F;
			this.FrontRightLeg.zRot = this.BackRightLeg.zRot;
			this.FrontLeftLeg.zRot = this.BackLeftLeg.zRot;
		} else {
			this.Head.y = 18F;
			this.Body.y = 16F;
			this.FrontLeftLeg.y = 20F;
			this.FrontRightLeg.y = 20F;
			this.BackLeftLeg.y = 20F;
			this.BackRightLeg.y = 20F;
			this.BackRightLeg.zRot = 0F;
			this.BackLeftLeg.zRot = 0F;
			this.FrontRightLeg.zRot = this.BackRightLeg.zRot;
			this.FrontLeftLeg.zRot = this.BackLeftLeg.zRot;
			this.FrontLeftLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
			this.FrontRightLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
			this.BackLeftLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
			this.BackRightLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
		}
		this.Head.yRot = netHeadYaw / (360F / (float)Math.PI);
		this.Head.xRot = headPitch / (360F / (float)Math.PI);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}