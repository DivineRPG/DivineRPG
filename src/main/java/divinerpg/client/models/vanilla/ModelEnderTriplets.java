package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.end.EntityEnderTriplets;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelEnderTriplets extends EntityModel<EntityEnderTriplets> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("ender_triplets");
	private final ModelPart Body;

	public ModelEnderTriplets(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Body = root.getChild("Body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(4.0F, -12.0F, -7.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(-14.0F, -12.0F, -7.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(52, 0).mirror().addBox(-10.0F, -15.0F, -3.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(52, 0).mirror().addBox(8.0F, -15.0F, -3.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(-5.0F, -25.0F, -7.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(52, 0).mirror().addBox(-1.0F, -28.0F, -3.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 23.0F, 2.0F));

		Body.addOrReplaceChild("Tentacle32_r1", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -18.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -12.0F, -2.0F, 0.0F, -1.5708F, 0.0F));

		Body.addOrReplaceChild("Tentacle12_r1", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(1.0F, 8.0F, -8.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(40, 0).mirror().addBox(-1.0F, 8.0F, -8.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -12.0F, -2.0F, 0.0F, 1.5708F, -3.1416F));

		Body.addOrReplaceChild("Tentacle21_r1", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-6.0F, -9.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(40, 6).mirror().addBox(-11.0F, -9.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -29.0F, 3.0F, 0.0F, -1.5708F, -3.1416F));

		Body.addOrReplaceChild("Jaw_r1", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(-5.0F, 0.0F, -10.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -15.0F, 3.0F, 0.0873F, 0.0F, 0.0F));

		Body.addOrReplaceChild("Connector3_r1", CubeListBuilder.create().texOffs(11, 10).mirror().addBox(10.0F, -1.0F, 7.0F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, -0.4363F));

		Body.addOrReplaceChild("Connector2_r1", CubeListBuilder.create().texOffs(11, 10).mirror().addBox(-10.4F, 1.0F, -5.0F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.0F, -2.0F, 1.5708F, 0.0F, 1.5708F));

		Body.addOrReplaceChild("Connector1_r1", CubeListBuilder.create().texOffs(11, 10).mirror().addBox(-13.0F, -1.0F, 7.0F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.4363F));

		Body.addOrReplaceChild("Tentacle323_r1", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -18.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, 1.0F, -2.0F, 0.0F, -1.5708F, 0.0F));

		Body.addOrReplaceChild("Tentacle123_r1", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(1.0F, 8.0F, -8.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(40, 0).mirror().addBox(-1.0F, 8.0F, -8.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, 1.0F, -2.0F, 0.0F, 1.5708F, -3.1416F));

		Body.addOrReplaceChild("Tentacle213_r1", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-6.0F, -9.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(40, 6).mirror().addBox(-11.0F, -9.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -16.0F, 3.0F, 0.0F, -1.5708F, -3.1416F));

		Body.addOrReplaceChild("Jaw3_r1", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(-5.0F, 0.0F, -10.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 20).mirror().addBox(-23.0F, 0.0F, -10.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, -2.0F, 3.0F, 0.0873F, 0.0F, 0.0F));

		Body.addOrReplaceChild("Tentacle322_r1", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(-4.0F, -18.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, 1.0F, -2.0F, 0.0F, -1.5708F, 0.0F));

		Body.addOrReplaceChild("Tentacle122_r1", CubeListBuilder.create().texOffs(40, 6).mirror().addBox(1.0F, 8.0F, -8.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(40, 0).mirror().addBox(-1.0F, 8.0F, -8.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, 1.0F, -2.0F, 0.0F, 1.5708F, -3.1416F));

		Body.addOrReplaceChild("Tentacle212_r1", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-6.0F, -9.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(40, 6).mirror().addBox(-11.0F, -9.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-16.0F, -16.0F, 3.0F, 0.0F, -1.5708F, -3.1416F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(EntityEnderTriplets entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}