package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.nether.EntityScorcher;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelScorcher extends EntityModel<EntityScorcher> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("scorcher");
	private final ModelPart body;

	public ModelScorcher(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.body = root.getChild("body");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(-4.0F, -5.0F, 5.0F, 6.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 48).mirror().addBox(8.0F, 5.0F, 3.0F, 6.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 48).mirror().addBox(6.0F, -5.0F, 5.0F, 6.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 48).mirror().addBox(-6.0F, 5.0F, 3.0F, 6.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 16).mirror().addBox(1.0F, -6.0F, 1.0F, 6.0F, 6.0F, 6.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 8.0F, 8.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(-4.0F, 14.0F, -5.0F));

		body.addOrReplaceChild("leftArm2_r1", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(0.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(14.0F, 5.0F, 4.0F, 0.0F, 0.0F, -1.5708F));

		body.addOrReplaceChild("rightArm2_r1", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(-6.0F, -2.0F, -2.0F, 6.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-6.0F, 5.0F, 5.0F, 0.0F, 0.0F, 1.5708F));

		body.addOrReplaceChild("leftHorn2_r1", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(-1.0F, -1.0F, 0.0F, 6.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(11.0F, -6.0F, 5.0F, 0.0F, 0.0F, -1.5708F));

		body.addOrReplaceChild("rightHorn2_r1", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(2.0F, 0.0F, 0.0F, 6.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-4.0F, -3.0F, 5.0F, 0.0F, 0.0F, -1.5708F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	@Override
	public void setupAnim(EntityScorcher entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}