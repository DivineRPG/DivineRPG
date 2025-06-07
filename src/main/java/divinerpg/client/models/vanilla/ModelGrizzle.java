package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.base.EntityDivineTameable;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelGrizzle<T extends EntityDivineTameable> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("grizzle");
	private final ModelPart leg1, leg2, leg4, leg3, body, head, tail;
	public ModelGrizzle(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.leg4 = root.getChild("leg4");
		this.leg3 = root.getChild("leg3");
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.tail = root.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.9999F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 14.0F, -8.0F));

		partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.9999F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 16.0F, 8.0F));

		partdefinition.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0001F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 16.0F, 8.0F));

		partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0001F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 14.0F, -8.0F));

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 12.0F, 10.0F, 22.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, 4.5F, -11.0F, -0.0873F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(-4.0F, -3.0F, -5.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 46).mirror().addBox(-2.0F, 1.0F, -9.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 14).mirror().addBox(3.0F, -4.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 14).mirror().addBox(-5.0F, -4.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 5.0F, -11.0F));

		partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 26).mirror().addBox(5.0F, 4.0F, 21.54F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, 4.5F, -11.0F, -0.0873F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	@Override public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		head.xRot = headPitch * Mth.DEG_TO_RAD;
		head.yRot = netHeadYaw * Mth.DEG_TO_RAD;
		float f = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
		float f1 = Mth.cos(limbSwing * .6662F + Mth.PI) * 1.4F * limbSwingAmount;
		leg1.xRot = leg2.xRot = f;
        leg3.xRot = leg4.xRot = f1;
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}