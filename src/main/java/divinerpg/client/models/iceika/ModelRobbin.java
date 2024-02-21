package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;

import divinerpg.entities.iceika.EntityRobbin;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelRobbin extends EntityModel<EntityRobbin> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("robbin");
	public final ModelPart body, leftwing, rightwing, leftleg, rightleg;
	public ModelRobbin(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		body = root.getChild("body");
		leftwing = root.getChild("leftwing");
		rightwing = root.getChild("rightwing");
		leftleg = root.getChild("leftleg");
		rightleg = root.getChild("rightleg");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation def = new CubeDeformation(0F);
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2F, -4F, -4F, 4F, 4F, 4F, def), PartPose.offsetAndRotation(0F, 22F, 1F, -.2618F, 0F, 0F));
		body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 17).addBox(-1F, -2F, 1F, 2F, 2F, 3F, def), PartPose.offsetAndRotation(0F, -3F, -1F, .5672F, 0F, 0F));
		body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 8).addBox(-2F, -4F, -1F, 1F, 1F, 2F, def)
		.texOffs(11, 14).addBox(-1.5F, -3F, -3F, 3F, 3F, 3F, def)
		.texOffs(8, 11).addBox(-1F, -1.5F, -4F, 2F, 1F, 2F, def)
		.texOffs(0, 11).addBox(1F, -4F, -1F, 1F, 1F, 2F, def), PartPose.offsetAndRotation(0F, -3F, -3F, .2618F, 0F, 0F));
		partdefinition.addOrReplaceChild("leftwing", CubeListBuilder.create().texOffs(20, 24).addBox(0F, 0F, 0F, 1F, 3F, 5F, def), PartPose.offset(2F, 18F, -2F));
		partdefinition.addOrReplaceChild("rightwing", CubeListBuilder.create().texOffs(0, 24).addBox(-1F, 0F, 0F, 1F, 3F, 5F, def), PartPose.offset(-2F, 18F, -2F));
		partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(8, 20).addBox(0F, 0F, -2F, 2F, 3F, 2F, def), PartPose.offset(0F, 21F, 0F));
		partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(18, 0).addBox(-2F, 0F, -2F, 2F, 3F, 2F, def), PartPose.offset(0F, 21F, 0F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}
	@Override public void setupAnim(EntityRobbin entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if(!entity.onGround()) {
			rightwing.yRot = Mth.cos(ageInTicks * 74.48451F * ((float)Math.PI / 180F)) * (float)Math.PI * .25F;
			leftwing.yRot = -rightwing.yRot;
			rightleg.xRot = leftleg.xRot = 0;
		} else {
			rightwing.yRot = leftwing.yRot = 0;
			rightleg.xRot = Mth.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
			leftleg.xRot = Mth.cos(limbSwing * .6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		}
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftwing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightwing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}