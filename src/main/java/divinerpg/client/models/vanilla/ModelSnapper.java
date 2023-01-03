package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntitySnapper;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelSnapper extends EntityModel<EntitySnapper> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("snapper");
	private final ModelPart leg1, leg2, leg3, leg4, head, body;

	public ModelSnapper(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
		this.leg4 = root.getChild("leg4");
		this.head = root.getChild("head");
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.5F, 20.0F, -5.0F));

		partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.5F, 20.0F, 5.0F));

		partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.5F, 20.0F, -5.0F));

		partdefinition.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.5F, 20.0F, 5.0F));

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 40).mirror().addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 19.0F, -6.0F, 1.309F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.5F, 3.0F, -3.0F, 10.0F, 3.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 46).mirror().addBox(-2.0F, 2.0F, -2.5F, 11.0F, 3.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(84, 49).mirror().addBox(-1.0F, 1.0F, -1.0F, 9.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(52, 52).mirror().addBox(0.0F, 0.0F, 0.0F, 7.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.5F, 14.0F, -4.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(EntitySnapper entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leg1.xRot = (float) (Math.cos(limbSwing * 0.6662F) * limbSwingAmount);
        this.leg3.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * limbSwingAmount);
        this.leg2.xRot = (float) (Math.cos(limbSwing * 0.6662F) * limbSwingAmount);
        this.leg4.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * limbSwingAmount);

        this.head.yRot = 0.75f * netHeadYaw / (180F / (float) Math.PI);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}