package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntityAequorea;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelAequorea extends EntityModel<EntityAequorea> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("aequorea");
	private final ModelPart tenticles, bb_main;

	public ModelAequorea(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.tenticles = root.getChild("tenticles");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubedef = new CubeDeformation(0.0F);

		partdefinition.addOrReplaceChild("tenticles", CubeListBuilder.create().texOffs(6, 18).addBox(2.0F, 0.0F, 0.0F, 0.0F, 8.0F, 1.0F, cubedef)
		.texOffs(4, 19).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 9.0F, 0.0F, cubedef)
		.texOffs(4, 0).addBox(-2.0F, 0.0F, -2.0F, 0.0F, 7.0F, 1.0F, cubedef)
		.texOffs(2, 18).addBox(3.0F, 0.0F, -2.0F, 0.0F, 8.0F, 1.0F, cubedef)
		.texOffs(0, 10).addBox(1.0F, 0.0F, 3.0F, 1.0F, 6.0F, 0.0F, cubedef)
		.texOffs(0, 19).addBox(-2.0F, 0.0F, 2.0F, 1.0F, 9.0F, 0.0F, cubedef)
		.texOffs(6, 0).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 6.0F, 0.0F, cubedef)
		.texOffs(2, 0).addBox(-3.0F, 0.0F, 1.0F, 0.0F, 7.0F, 1.0F, cubedef)
		.texOffs(0, 0).addBox(1.0F, 0.0F, -3.0F, 0.0F, 7.0F, 1.0F, cubedef), PartPose.offset(0.0F, 24.0F, 0.0F));

		partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 10).addBox(-3.0F, -5.0F, -3.0F, 6.0F, 3.0F, 6.0F, cubedef)
		.texOffs(0, 0).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 8.0F, cubedef), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(EntityAequorea entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		tenticles.xRot = -limbSwingAmount/2;
		tenticles.zRot = -limbSwingAmount/2;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		tenticles.render(poseStack, buffer, packedLight, packedOverlay);
		bb_main.render(poseStack, buffer, packedLight, packedOverlay);
	}
}