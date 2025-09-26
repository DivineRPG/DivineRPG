package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.projectile.bullet.EntitySaguaroWormShot;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelSaguaroWormShot extends EntityModel<EntitySaguaroWormShot> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("saguaro_worm_shot");
	public final ModelPart box;
	public ModelSaguaroWormShot(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		box = root.getChild("box");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		meshdefinition.getRoot().addOrReplaceChild("box", CubeListBuilder.create().texOffs(0, 0).addBox(0, 0, 0, 1, 1, 1, CubeDeformation.NONE), PartPose.ZERO);
		return LayerDefinition.create(meshdefinition, 4, 2);
	}
	@Override public void setupAnim(EntitySaguaroWormShot entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		box.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}