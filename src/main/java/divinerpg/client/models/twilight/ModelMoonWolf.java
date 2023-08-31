package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.wildwood.EntityMoonWolf;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelMoonWolf<T extends EntityMoonWolf> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("moon_wolf");
	private final ModelPart Body, Head, BackLeftLeg, FrontRightLeg, FrontLeftLeg, BackRightLeg, Tail;

	public ModelMoonWolf(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Body = root.getChild("Body");
		this.Head = root.getChild("Head");
		this.BackLeftLeg = root.getChild("BackLeftLeg");
		this.FrontRightLeg = root.getChild("FrontRightLeg");
		this.FrontLeftLeg = root.getChild("FrontLeftLeg");
		this.BackRightLeg = root.getChild("BackRightLeg");
		this.Tail = root.getChild("Tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 15.0F, 0.0F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 11.0F, -5.0F, 0.0F, 0.0F, 0.0F));

		Head.addOrReplaceChild("RightEar_r1", CubeListBuilder.create().texOffs(0, 18).addBox(-2.0F, -5.0F, -1.5F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -3.0F, -1.5F, 0.1745F, 0.5236F, 0.0F));

		Head.addOrReplaceChild("LeftEar_r1", CubeListBuilder.create().texOffs(13, 18).addBox(0.0F, -5.0F, -1.5F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -3.0F, -1.5F, 0.1745F, -0.5236F, 0.0F));

		Head.addOrReplaceChild("HeadBase_r1", CubeListBuilder.create().texOffs(0, 18).addBox(-1.5F, -3.0F, -3.5F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -4.5F, 0.3491F, 0.0F, 0.0F));

		Head.addOrReplaceChild("Hair_r1", CubeListBuilder.create().texOffs(0, 31).addBox(-2.0F, -20.5F, -1.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.0F, 5.0F, 0.3491F, 0.0F, 0.0F));

		Body.addOrReplaceChild("BodyBase", CubeListBuilder.create().texOffs(0, 44).addBox(-3.0F, -6.0F, -6.2F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-3.0F, -6.0F, -6.0F, 6.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(20, 18).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 15.0F, 5.0F));

		partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 15.0F, -5.0F));

		partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(26, 27).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 15.0F, -5.0F));

		partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 15.0F, 5.0F));

		PartDefinition Tail = partdefinition.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offset(0.0F, 10.0F, 6.0F));

		PartDefinition LeftTail = Tail.addOrReplaceChild("LeftTail", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 2.0F));

		LeftTail.addOrReplaceChild("LeftTail_r1", CubeListBuilder.create().texOffs(48, -8).addBox(1.0F, -7.0F, -1.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.384F, 0.2007F, 0.1658F));

		PartDefinition RightTail = Tail.addOrReplaceChild("RightTail", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 2.0F));

		RightTail.addOrReplaceChild("RightTail_r1", CubeListBuilder.create().texOffs(48, 2).addBox(-1.0F, -7.0F, -1.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.384F, -0.2007F, -0.1658F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void prepareMobModel(EntityMoonWolf entity, float limbSwing, float limbSwingAmount, float p_102617_) {
		if (entity.isAngry()) {
			this.Tail.yRot = 0.0F;
		} else {
			this.Tail.yRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		}

		if (entity.isInSittingPose()) {
			this.Head.setPos(0.0F, 12.0F, -2.0F);
			this.Body.setPos(0.0F, 20.0F, -2.0F);
			this.Body.xRot = -((float)Math.PI / 4F);
			this.Tail.setPos(0.0F, 21.0F, 6.0F);
			this.BackRightLeg.setPos(-1.95F, 23.0F, 2.0F);
			this.BackRightLeg.xRot = ((float)Math.PI * 1.5F);
			this.BackLeftLeg.setPos(1.95F, 23.0F, 2.0F);
			this.BackLeftLeg.xRot = ((float)Math.PI * 1.5F);
			this.FrontRightLeg.xRot = 5.811947F;
			this.FrontRightLeg.setPos(-1.9375F, 15.0F, -4.0F);
			this.FrontLeftLeg.xRot = 5.811947F;
			this.FrontLeftLeg.setPos(1.9375F, 15.0F, -4.0F);
		} else {
			this.Head.setPos(0.0F, 11.0F, -5.0F);
			this.Body.setPos(0.0F, 15.0F, 0.0F);
			this.Body.xRot = 0.0F;
			this.Tail.setPos(0.0F, 10.0F, 6.0F);
			this.BackRightLeg.setPos(-2.0F, 15.0F, 5.0F);
			this.BackLeftLeg.setPos(2.0F, 15.0F, 5.0F);
			this.FrontRightLeg.setPos(-2.0F, 15.0F, -5.0F);
			this.FrontLeftLeg.setPos(2.0F, 15.0F, -5.0F);
			this.BackRightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.BackLeftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.FrontRightLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.FrontLeftLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		}
			this.Head.zRot = entity.getHeadRollAngle(p_102617_) + entity.getBodyRollAngle(p_102617_, 0.0F);
			this.Body.zRot = entity.getBodyRollAngle(p_102617_, -0.16F);
			this.Tail.zRot = entity.getBodyRollAngle(p_102617_, -0.2F);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.xRot = headPitch * ((float)Math.PI / 180F);
		this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}