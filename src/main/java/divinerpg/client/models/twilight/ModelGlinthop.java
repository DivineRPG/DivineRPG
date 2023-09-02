package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.eden.EntityGlinthop;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelGlinthop<T extends EntityGlinthop> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("glinthop");
	public final ModelPart Spine, Body, Tail, FrontRightLeg, BackRightLeg, FrontLeftLeg, BackLeftLeg, Head;

	public ModelGlinthop(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Spine = root.getChild("Spine");
		this.Body = this.Spine.getChild("Body");
		this.Tail = this.Body.getChild("Tail");
		this.FrontRightLeg = root.getChild("FrontRightLeg");
		this.BackRightLeg = root.getChild("BackRightLeg");
		this.FrontLeftLeg = root.getChild("FrontLeftLeg");
		this.BackLeftLeg = root.getChild("BackLeftLeg");
		this.Head = root.getChild("Head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Spine = partdefinition.addOrReplaceChild("Spine", CubeListBuilder.create(), PartPose.offset(-2.0F, 19.0F, 1.0F));

		PartDefinition Body = Spine.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 44).addBox(-3.5F, -5.75F, -4.01F, 7.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
			.texOffs(0, 0).addBox(-2.0F, -4.75F, -3.0F, 4.0F, 5.0F, 9.0F, new CubeDeformation(0.0F))
			.texOffs(0, 14).addBox(-3.5F, -5.75F, -4.0F, 7.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -1.25F, -2.0F));

		partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(31, 6).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 20.0F, -3.0F));

		partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(21, 9).addBox(-2.0F, -3.0F, -2.5F, 2.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(14, 31).addBox(-2.0F, 2.0F, 0.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 18.0F, 3.0F));

		partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 20.0F, -3.0F));

		partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(0, 27).addBox(0.0F, -3.0F, -2.5F, 2.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(33, 0).addBox(0.0F, 2.0F, 0.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 18.0F, 3.0F));

		Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(17, 0).addBox(-2.0F, -3.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.75F, 7.0F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 14).addBox(-0.5F, 1.0F, -4.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 23).addBox(-2.5F, -2.0F, -4.0F, 5.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, -4.0F));

		Head.addOrReplaceChild("LeftEar", CubeListBuilder.create().texOffs(0, 7).addBox(-0.5F, -1.5F, 0.25F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(30, 19).addBox(-1.5F, -0.5F, -0.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -3.5F, -0.25F));

		Head.addOrReplaceChild("RightEar", CubeListBuilder.create().texOffs(22, 33).addBox(-1.0F, -10.0F, -6.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 7).addBox(-2.0F, -11.0F, -5.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 6.0F, 5.0F));

		Head.addOrReplaceChild("LeftWhisker", CubeListBuilder.create().texOffs(9, 27).addBox(0.5F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 2.0F, -3.0F));

		Head.addOrReplaceChild("RightWhisker", CubeListBuilder.create().texOffs(24, 19).addBox(-3.5F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 2.0F, -3.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);

		this.FrontLeftLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.BackLeftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.FrontRightLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.BackRightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Spine.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}