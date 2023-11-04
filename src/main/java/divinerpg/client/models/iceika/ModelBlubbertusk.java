package divinerpg.client.models.iceika;

import static divinerpg.util.ClientUtils.createLocation;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import divinerpg.entities.iceika.EntityBlubbertusk;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

public class ModelBlubbertusk extends EntityModel<EntityBlubbertusk> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("blubbertusk");
	private final ModelPart head, body;
	public ModelBlubbertusk(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		head = root.getChild("Head");
		body = root.getChild("Body");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, 21.0F, -7.0F));

		Head.addOrReplaceChild("neck_r1", CubeListBuilder.create().texOffs(0, 26).addBox(-5.5F, -7.0F, -4.3265F, 11.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -1.0F, 0.6109F, 0.0F, 0.0F));

		PartDefinition Skull = Head.addOrReplaceChild("Skull", CubeListBuilder.create().texOffs(48, 43).addBox(-3.0F, -4.0F, -8.0F, 6.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(39, 0).addBox(-4.0F, -5.0F, -6.0F, 8.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-2.5F, -2.0F, -7.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 0).addBox(1.5F, -2.0F, -7.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, -4.0F));

		Skull.addOrReplaceChild("RightWhisker", CubeListBuilder.create().texOffs(8, 0).addBox(-2.0F, -1.5F, 0.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -1.5F, -7.0F));

		Skull.addOrReplaceChild("LeftWhisker", CubeListBuilder.create().texOffs(0, 8).addBox(0.0F, -1.5F, 0.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -1.5F, -7.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -11.0F, -9.0F, 12.0F, 11.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(36, 26).addBox(-4.5F, -6.0F, 0.0F, 9.0F, 9.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 4.0F));

		PartDefinition TailEnd = Tail.addOrReplaceChild("TailEnd", CubeListBuilder.create().texOffs(29, 43).addBox(-3.0F, -3.5F, -2.0F, 6.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

		TailEnd.addOrReplaceChild("leftFin_r1", CubeListBuilder.create().texOffs(0, 52).addBox(-0.5F, -2.5F, -1.0F, 6.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 44).addBox(-7.5F, -2.5F, -1.0F, 6.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 3.0F, 3.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition LeftFin = Body.addOrReplaceChild("LeftFin", CubeListBuilder.create(), PartPose.offset(6.0F, -3.0F, -6.0F));

		LeftFin.addOrReplaceChild("leftFin_r2", CubeListBuilder.create().texOffs(15, 53).addBox(10.0F, -2.2088F, -1.6598F, 2.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition RightFin = Body.addOrReplaceChild("RightFin", CubeListBuilder.create(), PartPose.offset(-6.0F, -3.0F, -6.0F));

		RightFin.addOrReplaceChild("rightFin_r1", CubeListBuilder.create().texOffs(48, 50).addBox(-12.0F, -2.2088F, -1.6598F, 2.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	@Override
	public void setupAnim(EntityBlubbertusk entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}