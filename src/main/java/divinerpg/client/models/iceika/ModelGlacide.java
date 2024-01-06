package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;

import divinerpg.entities.iceika.EntityGlacide;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelGlacide extends EntityModel<EntityGlacide> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("glacide");
	private final ModelPart Glacide, FrontLeftLeg, BackLeftLeg, FrontRightLeg, BackRightLeg, Head;

	public ModelGlacide(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Glacide = root.getChild("Glacide");
		this.FrontLeftLeg = root.getChild("FrontLeftLeg");
		this.BackLeftLeg = root.getChild("BackLeftLeg");
		this.FrontRightLeg = root.getChild("FrontRightLeg");
		this.BackRightLeg = root.getChild("BackRightLeg");
		this.Head = root.getChild("Head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Glacide = partdefinition.addOrReplaceChild("Glacide", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition Spine = Glacide.addOrReplaceChild("Spine", CubeListBuilder.create().texOffs(46, 35).addBox(-6.0F, -6.0F, -15.0F, 12.0F, 13.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(48, 0).addBox(-6.0F, -2.0F, -5.0F, 12.0F, 11.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-6.0F, -6.0F, 4.0F, 12.0F, 11.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(90, 0).addBox(-8.0F, 4.0F, -4.0F, 3.0F, 9.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(93, 61).addBox(5.0F, 4.0F, -3.0F, 3.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Spine.addOrReplaceChild("RightSail", CubeListBuilder.create().texOffs(0, 30).addBox(0.0F, -18.0F, -2.0F, 0.0F, 18.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -6.0F, -7.0F));

		Spine.addOrReplaceChild("LeftSail", CubeListBuilder.create().texOffs(0, 12).addBox(0.0F, -18.0F, -2.0F, 0.0F, 18.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -6.0F, -7.0F, 0.0F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(66, 79).addBox(-1.0F, 6.0F, -6.0F, 5.0F, 15.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(90, 40).addBox(0.0F, -5.0F, -3.0F, 3.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 3.0F, -11.0F));

		partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(71, 58).addBox(0.0F, -4.0F, -3.0F, 5.0F, 15.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(46, 79).addBox(2.0F, 5.0F, 1.0F, 4.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 3.0F, 9.0F));

		partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(80, 20).addBox(-4.0F, 6.0F, -6.0F, 5.0F, 15.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(86, 79).addBox(-3.0F, -5.0F, -3.0F, 3.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 3.0F, -11.0F));

		partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -4.0F, -3.0F, 5.0F, 15.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(26, 79).addBox(-6.0F, 5.0F, 1.0F, 4.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 3.0F, 9.0F));

		Spine.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 71).addBox(-4.0F, -19.0F, -5.0F, 8.0F, 23.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, -14.0F));

		partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -4.0F, -12.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 107).addBox(3.0F, -4.0F, -12.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(33, 58).addBox(-3.0F, -4.0F, -12.0F, 6.0F, 8.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(106, 110).addBox(3.0F, -11.0F, -2.0F, 0.0F, 7.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(106, 110).addBox(-3.0F, -11.0F, -2.0F, 0.0F, 7.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -17.0F, -18.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(EntityGlacide entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
		this.Head.xRot = headPitch * ((float)Math.PI / 180F);
		this.FrontLeftLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.BackLeftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.FrontRightLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.BackRightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Glacide.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}