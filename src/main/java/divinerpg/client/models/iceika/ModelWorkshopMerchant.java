package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelWorkshopMerchant<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("workshop_merchant");
	private final ModelPart Head, Body, LeftLeg, RightLeg;

	public ModelWorkshopMerchant(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Head = root.getChild("Head");
		this.Body = root.getChild("Body");
		this.LeftLeg = root.getChild("LeftLeg");
		this.RightLeg = root.getChild("RightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 38).addBox(-4.0F, -4.99F, -4.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(32, 30).addBox(-4.0F, -11.01F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-8.0F, -5.0F, -8.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 16).addBox(-5.0F, -12.0F, -5.0F, 10.0F, 12.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(32, 44).addBox(-4.5F, -13.0F, 5.01F, 9.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

		Body.addOrReplaceChild("Arm", CubeListBuilder.create().texOffs(48, 0).addBox(-9.0F, -2.5F, -4.1667F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(56, 26).addBox(4.0F, -2.5F, -4.1667F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(30, 16).addBox(-9.0F, -2.5F, -9.1657F, 18.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.1667F, 0.4363F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 51).addBox(-1.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 12.01F, 0.0F));

		partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(52, 56).addBox(-5.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 12.01F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
		this.Head.xRot = headPitch * ((float)Math.PI / 180F);

		this.RightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.RightLeg.yRot = 0.0F;
		this.LeftLeg.yRot = 0.0F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}