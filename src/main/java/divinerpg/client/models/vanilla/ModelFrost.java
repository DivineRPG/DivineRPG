package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntityFrost;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelFrost extends EntityModel<EntityFrost> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("frost");
	private final ModelPart frostBody;

	public ModelFrost(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.frostBody = root.getChild("frostBody");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition frostBody = partdefinition.addOrReplaceChild("frostBody", CubeListBuilder.create().texOffs(0, 11).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(-3.0F, -3.7F, 0.0F, 14.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(-3.0F, 10.5333F, 0.0F, 14.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 10.0F, -2.0F));

		frostBody.addOrReplaceChild("horn1_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-20.2F, -7.6F, -2.0F, 8.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(-2.0F, -7.6F, -2.0F, 8.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 14.0F, 2.0F, 0.0F, 0.0F, 0.7854F));

		frostBody.addOrReplaceChild("shard4_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-17.0F, -7.7F, -2.0F, 14.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 14.0F, 2.0F, 0.0F, 0.0F, 1.5708F));

		frostBody.addOrReplaceChild("shard3_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(3.0F, -7.7F, -2.0F, 14.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 14.0F, 2.0F, 0.0F, 0.0F, -1.5708F));

		frostBody.addOrReplaceChild("horn2_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-6.1F, -7.6F, -2.0F, 8.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(12.2F, -7.6F, -2.0F, 8.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 14.0F, 2.0F, 0.0F, 0.0F, -0.7854F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(EntityFrost entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		frostBody.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}