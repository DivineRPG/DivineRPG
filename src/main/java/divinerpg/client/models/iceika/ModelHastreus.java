package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.iceika.EntityHastreus;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelHastreus<T extends EntityHastreus> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("hastreus");
	private final ModelPart Head, Jaw, Body, Tail, FrontRightLeg, BackRightLeg, FrontLeftLeg, BackLeftLeg;

	public ModelHastreus(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Head = root.getChild("Head");
		this.Jaw = this.Head.getChild("Jaw");
		this.Body = root.getChild("Body");
		this.Tail = root.getChild("Tail");
		this.FrontRightLeg = root.getChild("FrontRightLeg");
		this.BackRightLeg = root.getChild("BackRightLeg");
		this.FrontLeftLeg = root.getChild("FrontLeftLeg");
		this.BackLeftLeg = root.getChild("BackLeftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(38, 37).addBox(-2.0F, -2.0F, -12.0F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 37).addBox(-7.0F, -4.0F, -10.0F, 14.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, -9.0F));

		Head.addOrReplaceChild("headspike_r1", CubeListBuilder.create().texOffs(32, 84).addBox(-2.0F, -7.0F, -1.5F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -9.0F, -0.3491F, 0.0F, 0.0F));

		Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(38, 45).addBox(-6.0F, 0.0F, -7.0F, 12.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, -3.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 10.0F, -10.0F));

		Body.addOrReplaceChild("torso_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-13.5F, -12.0F, -1.0F, 18.0F, 12.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 2.0F, 0.5F, 0.1309F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(68, 59).addBox(-8.5F, -2.0F, -3.5F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, 10.0F, -5.5F, 0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(36, 59).addBox(-6.5F, -3.0F, -3.5F, 8.0F, 17.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 10.0F, 9.5F, 0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(0, 76).addBox(0.5F, -2.0F, -3.5F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 10.0F, -5.5F, 0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(61, 0).addBox(-1.5F, -2.0F, -3.5F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 10.0F, 9.5F, 0.0F, 0.0F, 0.0F));

		PartDefinition Tail = partdefinition.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, 14.0F));

		Tail.addOrReplaceChild("tailtip_r1", CubeListBuilder.create().texOffs(72, 37).addBox(-2.0F, -8.5F, -3.5F, 4.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.5F, 9.5F, 0.2182F, 0.0F, 0.0F));

		Tail.addOrReplaceChild("basetail_r1", CubeListBuilder.create().texOffs(0, 55).addBox(-4.0F, -7.5F, -1.0F, 8.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.5F, -1.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition BackRightSpine = Body.addOrReplaceChild("BackRightSpine", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.5F, -9.0F, 6.0F, -0.5236F, 0.0F, 0.0F));

		BackRightSpine.addOrReplaceChild("backrightspine_r1", CubeListBuilder.create().texOffs(48, 84).addBox(-2.5F, -10.0F, -1.0F, 5.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -0.2618F, 0.0F, -0.2618F));

		PartDefinition BackLeftSpine = Body.addOrReplaceChild("BackLeftSpine", CubeListBuilder.create(), PartPose.offsetAndRotation(7.5F, -9.0F, 6.0F, -0.5236F, 0.0F, 0.0F));

		BackLeftSpine.addOrReplaceChild("backleftspine_r1", CubeListBuilder.create().texOffs(86, 24).addBox(-2.5F, -10.0F, -1.0F, 5.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -0.2618F, 0.0F, 0.2618F));

		PartDefinition MiddleRightSpine = Body.addOrReplaceChild("MiddleRightSpine", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, -10.0F, 4.0F, -0.48F, 0.0F, 0.0F));

		MiddleRightSpine.addOrReplaceChild("middlerightspine_r1", CubeListBuilder.create().texOffs(65, 83).addBox(-2.0F, -12.0F, -4.5F, 5.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, 2.5F, -0.1309F, 0.0F, -0.1745F));

		PartDefinition MiddleLeftSpine = Body.addOrReplaceChild("MiddleLeftSpine", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, -10.0F, 4.0F, -0.48F, 0.0F, 0.0F));

		MiddleLeftSpine.addOrReplaceChild("middleleftspine_r1", CubeListBuilder.create().texOffs(81, 83).addBox(-3.0F, -12.0F, -4.5F, 5.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 2.5F, -0.1309F, 0.0F, 0.1745F));

		PartDefinition CenterSpine = Body.addOrReplaceChild("CenterSpine", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -10.0F, -1.0F, -0.3927F, 0.0F, 0.0F));

		CenterSpine.addOrReplaceChild("centerspine_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -17.0F, -1.5F, 5.0F, 17.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, 0.5F, -0.1309F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.yRot = netHeadYaw / (180F / (float)Math.PI);
		this.Head.xRot = headPitch / (180F / (float)Math.PI);

		this.Tail.yRot = Mth.cos(limbSwing * 0.6662F) * 0.7F * limbSwingAmount;
		this.FrontRightLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * limbSwingAmount);
		this.BackRightLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * limbSwingAmount);
		this.FrontLeftLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * limbSwingAmount);
		this.BackLeftLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * limbSwingAmount);
	}

	@Override
	public void prepareMobModel(T p_103621_, float p_103622_, float p_103623_, float p_103624_) {
		super.prepareMobModel(p_103621_, p_103622_, p_103623_, p_103624_);
		int l = p_103621_.getAttackTick();
		if (l > 0) {
			if (l > 5) {
				this.Jaw.xRot = Mth.sin(((float) (-4 + l) - p_103624_) / 4.0F) * (float) Math.PI * 0.4F;
			} else {
				this.Jaw.xRot = 0.15707964F * Mth.sin((float) Math.PI * ((float) l - p_103624_) / 10.0F);
			}
		} else this.Jaw.xRot = 0F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}