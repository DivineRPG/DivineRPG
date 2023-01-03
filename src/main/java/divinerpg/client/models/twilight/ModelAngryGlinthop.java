package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelAngryGlinthop<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("angry_glinthop");
	private final ModelPart Spine, FrontRightLeg, BackRightLeg, FrontLeftLeg, BackLeftLeg, Skull;

	public ModelAngryGlinthop(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Spine = root.getChild("Spine");
		this.FrontRightLeg = root.getChild("FrontRightLeg");
		this.BackRightLeg = root.getChild("BackRightLeg");
		this.FrontLeftLeg = root.getChild("FrontLeftLeg");
		this.BackLeftLeg = root.getChild("BackLeftLeg");
		this.Skull = root.getChild("Skull");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Spine = partdefinition.addOrReplaceChild("Spine", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Body = Spine.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(46, 28).addBox(-10.8889F, -16.9444F, -4.6667F, 22.0F, 21.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.8889F, -10.9444F, -7.6667F, 10.0F, 11.0F, 17.0F, new CubeDeformation(0.0F))
		.texOffs(0, 28).addBox(-6.8889F, -12.9444F, -11.6667F, 14.0F, 15.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.1111F, -12.0556F, -0.3333F));

		PartDefinition FrontLeftLeg = partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(37, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.1111F, 13.0556F, -8.6667F));

		PartDefinition BackLeftLeg = partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(0, 74).addBox(-1.0F, 5.0F, 0.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(15, 60).addBox(-1.0F, -4.0F, -5.0F, 4.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(3.1111F, 8.9444F, 6.3333F));

		PartDefinition FrontRightLeg = partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.8889F, 13.0556F, -8.6667F));

		PartDefinition BackRightLeg = partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(41, 69).addBox(-3.0F, 5.0F, 0.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(54, 0).addBox(-3.0F, -4.0F, -5.0F, 4.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.8889F, 8.9444F, 6.3333F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(68, 63).addBox(-3.0F, -9.75F, 0.5F, 6.0F, 10.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 40).addBox(0.0F, -12.75F, -1.5F, 0.0F, 15.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.1111F, -7.1944F, 8.8333F));

		PartDefinition Skull = partdefinition.addOrReplaceChild("Skull", CubeListBuilder.create().texOffs(0, 33).addBox(-1.0F, -2.0F, -9.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(38, 49).addBox(-5.0F, -8.0F, -8.0F, 10.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, -12.0F));

		PartDefinition LeftWhisker = Skull.addOrReplaceChild("LeftWhisker", CubeListBuilder.create().texOffs(71, 0).addBox(-0.5F, -4.5F, 0.0F, 9.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(5.5F, -0.5F, -7.0F));

		PartDefinition RightWhisker = Skull.addOrReplaceChild("RightWhisker", CubeListBuilder.create().texOffs(54, 18).addBox(-8.5F, -4.5F, 0.0F, 9.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.5F, -0.5F, -7.0F));

		PartDefinition LeftEar = Skull.addOrReplaceChild("LeftEar", CubeListBuilder.create().texOffs(37, 28).addBox(-0.5F, -7.5F, 1.5F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(66, 49).addBox(-1.5F, -5.5F, -0.5F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -7.5F, -1.5F));

		PartDefinition RightEar = Skull.addOrReplaceChild("RightEar", CubeListBuilder.create().texOffs(24, 52).addBox(-2.5F, -5.5F, -0.5F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 28).addBox(-3.5F, -7.5F, 1.5F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -7.5F, -1.5F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.FrontLeftLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.BackLeftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.FrontRightLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.BackRightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.Skull.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Skull.xRot = headPitch / (180F / (float) Math.PI);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Spine.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Skull.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}