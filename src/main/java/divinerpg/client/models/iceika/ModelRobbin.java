package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelRobbin<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("robbin");
	private final ModelPart body, leftwing, rightwing, leftleg, rightleg;

	public ModelRobbin(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.body = root.getChild("body");
		this.leftwing = root.getChild("leftwing");
		this.rightwing = root.getChild("rightwing");
		this.leftleg = root.getChild("leftleg");
		this.rightleg = root.getChild("rightleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -4.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 22.0F, 1.0F, -0.2618F, 0.0F, 0.0F));

		body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, -2.0F, 1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -1.0F, 0.5672F, 0.0F, 0.0F));

		body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 8).addBox(-2.0F, -4.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(11, 14).addBox(-1.5F, -3.0F, -3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(8, 11).addBox(-1.0F, -1.5F, -4.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 11).addBox(1.0F, -4.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -3.0F, 0.2618F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("leftwing", CubeListBuilder.create().texOffs(20, 24).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 18.0F, -2.0F));

		partdefinition.addOrReplaceChild("rightwing", CubeListBuilder.create().texOffs(0, 24).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 18.0F, -2.0F));

		partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(8, 20).addBox(0.0F, 0.0F, -2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.0F, 0.0F));

		partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(18, 0).addBox(-2.0F, 0.0F, -2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		if (!entity.onGround()) {
			this.rightwing.yRot = Mth.cos(ageInTicks * 74.48451F * ((float)Math.PI / 180F)) * (float)Math.PI * 0.25F;
			this.leftwing.yRot = -this.rightwing.yRot;
			this.rightleg.xRot = 0;
			this.leftleg.xRot = 0;
		} else {
			this.rightwing.yRot = 0;
			this.leftwing.yRot = 0;
			this.rightleg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.leftleg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftwing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightwing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}