package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelWildwoodTomo<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("tomo");
	private final ModelPart body;
	public ModelWildwoodTomo(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.body = root.getChild("body");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(54, 0).mirror().addBox(-16.0F, 6.0F, -2.0F, 2.0F, 5.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(54, 0).mirror().addBox(-2.0F, 6.0F, -2.0F, 2.0F, 5.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 12).mirror().addBox(-4.0F, -2.0F, 5.0F, 2.0F, 6.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(29, 0).mirror().addBox(0.0F, 7.0F, 2.0F, 10.0F, 2.0F, 8.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(27, 0).mirror().addBox(-26.0F, 7.0F, 2.0F, 10.0F, 2.0F, 8.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 13).mirror().addBox(-14.0F, -2.0F, 5.0F, 2.0F, 6.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 7).mirror().addBox(-16.0F, 4.0F, 0.0F, 16.0F, 9.0F, 16.0F, CubeDeformation.NONE).mirror(false), PartPose.offset(8.0F, 10.0F, -8.0F));

		body.addOrReplaceChild("sensorleft_r1", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(3.0F, -16.0F, 4.0F, 6.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(0, 20).mirror().addBox(3.0F, -16.0F, -6.0F, 6.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(28, 0).mirror().addBox(8.0F, -10.0F, -8.0F, 2.0F, 2.0F, 16.0F, CubeDeformation.NONE).mirror(false)
		.texOffs(28, 0).mirror().addBox(8.0F, -3.0F, -8.0F, 2.0F, 2.0F, 16.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-8.0F, 14.0F, 8.0F, 0.0F, 1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}