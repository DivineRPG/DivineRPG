package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.mortum.EntityBasilisk;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelBasilisk extends EntityModel<EntityBasilisk> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("basilisk");
	private final ModelPart body, leg1, leg2, leg3, leg4, leg5, leg6;

	public ModelBasilisk(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.body = root.getChild("body");
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
		this.leg4 = root.getChild("leg4");
		this.leg5 = root.getChild("leg5");
		this.leg6 = root.getChild("leg6");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(56, 0).mirror().addBox(-1.0F, -1.0F, -9.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 0).mirror().addBox(-5.0F, 1.0F, -17.0F, 10.0F, 6.0F, 7.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(56, 0).mirror().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(56, 0).mirror().addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(56, 0).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(56, 0).mirror().addBox(-1.0F, -1.0F, 3.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(0.0F, 11.0F, 3.0F));

		body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(32, 10).mirror().addBox(-5.0F, -9.0F, -12.0F, 10.0F, 16.0F, 6.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(0.0F, 13.0F, -3.0F, -1.5708F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-3.0F, 19.0F, -5.0F));

		partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(3.0F, 19.0F, -5.0F));

		partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-3.0F, 19.0F, 1.0F));

		partdefinition.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(3.0F, 19.0F, 1.0F));

		partdefinition.addOrReplaceChild("leg5", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-3.0F, 19.0F, 7.0F));

		partdefinition.addOrReplaceChild("leg6", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(3.0F, 19.0F, 7.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}
	@Override
	public void setupAnim(EntityBasilisk entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leg1.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        this.leg2.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
        this.leg3.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
        this.leg4.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        this.leg5.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        this.leg6.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg5.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg6.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}