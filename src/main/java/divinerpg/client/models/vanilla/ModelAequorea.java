package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntityAequorea;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelAequorea extends EntityModel<EntityAequorea> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("aequorea");
	public final ModelPart body, tentacles;
	public ModelAequorea(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		body = root.getChild("body");
		tentacles = root.getChild("tentacles");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 10).addBox(-3, -5, -3, 6, 3, 6, cubeDef)
		.texOffs(0, 0).addBox(-4, -2, -4, 8, 2, 8, cubeDef), PartPose.offset(0, 24, 0));
		partdefinition.addOrReplaceChild("tentacles", CubeListBuilder.create().texOffs(6, 18).addBox(2, 0, 0, 0, 8, 1, cubeDef)
		.texOffs(4, 19).addBox(-1, 0, 0, 1, 9, 0, cubeDef)
		.texOffs(4, 0).addBox(-2, 0, -2, 0, 7, 1, cubeDef)
		.texOffs(2, 18).addBox(3, 0, -2, 0, 8, 1, cubeDef)
		.texOffs(0, 10).addBox(1, 0, 3, 1, 6, 0, cubeDef)
		.texOffs(0, 19).addBox(-2, 0, 2, 1, 9, 0, cubeDef)
		.texOffs(6, 0).addBox(-1, 0, -3, 1, 6, 0, cubeDef)
		.texOffs(2, 0).addBox(-3, 0, 1, 0, 7, 1, cubeDef)
		.texOffs(0, 0).addBox(1, 0, -3, 0, 7, 1, cubeDef), PartPose.offset(0, 23, 0));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}
	@Override public void setupAnim(EntityAequorea entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		tentacles.xRot = tentacles.zRot = Mth.sin(10 * ageInTicks / Mth.RAD_TO_DEG) * .3F;
	}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
		body.render(poseStack, buffer, packedLight, packedOverlay, color);
		tentacles.render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}