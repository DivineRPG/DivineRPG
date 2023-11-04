package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;

import divinerpg.entities.iceika.EntitySabear;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelSabear extends EntityModel<EntitySabear> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("sabear");
	private final ModelPart RearLeftLeg, FrontLeftLeg, RearRightLeg, FrontRightLeg, Head, body;

	public ModelSabear(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.RearLeftLeg = root.getChild("RearLeftLeg");
		this.FrontLeftLeg = root.getChild("FrontLeftLeg");
		this.RearRightLeg = root.getChild("RearRightLeg");
		this.FrontRightLeg = root.getChild("FrontRightLeg");
		this.Head = root.getChild("Head");
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(22, 49).addBox(-2.0F, -1.0F, -4.0F, 5.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 14.0F, -4.0F));

		partdefinition.addOrReplaceChild("RearLeftLeg", CubeListBuilder.create().texOffs(48, 18).addBox(-2.5F, 0.5F, -4.0F, 5.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 12.5F, 12.0F));

		partdefinition.addOrReplaceChild("RearRightLeg", CubeListBuilder.create().texOffs(44, 41).addBox(-2.5F, 0.5F, -4.0F, 5.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, 12.5F, 12.0F));

		partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(0, 49).addBox(-2.5F, -1.5F, -3.0F, 5.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, 14.5F, -5.0F));

		partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 67).addBox(-3.0F, 3.25F, -13.8333F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 67).addBox(2.0F, 3.25F, -13.8333F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(44, 60).addBox(-3.0F, -1.75F, -13.8333F, 6.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(42, 0).addBox(-5.0F, -4.75F, -9.8333F, 10.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 9).addBox(-6.0F, -5.75F, -7.8333F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(6, 9).addBox(4.0F, -5.75F, -7.8333F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.75F, -4.1667F));

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 26).addBox(-7.0F, -22.0F, -8.0F, 14.0F, 11.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-7.0F, -23.0F, 4.0F, 14.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(EntitySabear entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
		this.Head.xRot = headPitch * ((float)Math.PI / 180F);
		this.FrontLeftLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.RearLeftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.FrontRightLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.RearRightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		RearLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RearRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}