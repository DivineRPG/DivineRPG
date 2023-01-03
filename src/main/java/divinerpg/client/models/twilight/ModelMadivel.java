package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.eden.EntityMadivel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelMadivel extends EntityModel<EntityMadivel> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("madivel");
	private final ModelPart head, body, rightarm, leftarm, rightleg, leftleg;

	public ModelMadivel(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.rightarm = root.getChild("rightarm");
		this.leftarm = root.getChild("leftarm");
		this.rightleg = root.getChild("rightleg");
		this.leftleg = root.getChild("leftleg");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(36, 20).mirror().addBox(-2.0F, -5.0F, -2.0F, 4.0F, 5.0F, 4.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(2, 1).mirror().addBox(-5.0F, -12.0F, -1.0F, 10.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(2, 1).mirror().addBox(-5.0F, -4.0F, -1.0F, 10.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(35, 0).mirror().addBox(-3.0F, -14.0F, -4.0F, 6.0F, 9.0F, 7.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(0.0F, -7.0F, 0.0F));

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(0.0F, -7.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(40, 24).mirror().addBox(-9.0F, 2.0F, -1.0F, 6.0F, 3.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-5.0F, -5.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(40, 24).mirror().addBox(3.0F, 2.0F, -1.0F, 6.0F, 3.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(5.0F, -5.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 9).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 19.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-2.0F, 5.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 9).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 19.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(2.0F, 5.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}
	@Override
	public void setupAnim(EntityMadivel entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float)Math.PI);
        this.head.xRot = headPitch / (180F / (float)Math.PI);
        this.rightarm.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 2.0F * limbSwingAmount * 0.5F);
        this.leftarm.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F);
        this.rightleg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        this.leftleg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * 1.4F * limbSwingAmount);
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}