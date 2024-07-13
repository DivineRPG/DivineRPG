package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntitySaguaroWorm;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelSaguaroWorm extends EntityModel<EntitySaguaroWorm> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("saguaro_worm");
	private final ModelPart base, inactive;

	public ModelSaguaroWorm(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.base = root.getChild("base");
		this.inactive = root.getChild("inactive");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition base = partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, 8.0F, -8.0F));

		base.addOrReplaceChild("connector1_r1", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(-5.0F, -2.0F, 1.0F, 10.0F, 16.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0F, -9.0F, -1.0F, 0.288F, 0.0F, 0.0F));

		base.addOrReplaceChild("middle_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-8.0F, 0.0F, 0.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0F, -21.0F, -8.0F, 0.4363F, 0.0F, 0.0F));

		base.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-8.0F, -42.5F, -14.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0F, -25.0F, 19.0F, 1.0472F, 0.0F, 0.0F));

		base.addOrReplaceChild("connector2_r1", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(-5.0F, 0.0F, 0.0F, 10.0F, 16.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0F, -32.0F, -13.0F, 0.576F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("inactive", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -16.0F, 0.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(0.0F, -32.0F, 0.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, 8.0F, -8.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	@Override
	public void prepareMobModel(EntitySaguaroWorm entity, float p_102615_, float p_102616_, float p_102617_) {
		base.visible = entity.getProvoked();
		inactive.visible = !base.visible;
	}
	@Override
	public void setupAnim(EntitySaguaroWorm entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		base.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		inactive.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}