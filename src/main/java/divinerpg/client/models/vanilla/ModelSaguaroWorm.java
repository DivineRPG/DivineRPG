package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntitySaguaroWorm;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelSaguaroWorm extends EntityModel<EntitySaguaroWorm> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("saguaro_worm");
	public final ModelPart base, active, inactive;
	public ModelSaguaroWorm(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		base = root.getChild("base");
		active = root.getChild("active");
		inactive = root.getChild("inactive");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		CubeDeformation cubeDef = CubeDeformation.NONE;
		partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 30).addBox(1, 0, 1, 14, 16, 14, cubeDef), PartPose.offset(-8, 8, -8));
		PartDefinition base = partdefinition.addOrReplaceChild("active", CubeListBuilder.create(), PartPose.ZERO);
		base.addOrReplaceChild("connector_bottom", CubeListBuilder.create().texOffs(56, 0).addBox(1, -2, 1, 10, 16, 10, cubeDef), PartPose.offsetAndRotation(-6, -1, -9, .288F, 0, 0));
		base.addOrReplaceChild("middle_active", CubeListBuilder.create().texOffs(0, 30).addBox(1, 0, 0, 14, 16, 14, cubeDef), PartPose.offsetAndRotation(-8, -13, -16, .4363F, 0, 0));
		base.addOrReplaceChild("connector_top", CubeListBuilder.create().texOffs(56, 0).addBox(1, 0, 1, 10, 16, 10, cubeDef), PartPose.offsetAndRotation(-6, -24, -22, .576F, 0, 0));
		base.addOrReplaceChild("head_active", CubeListBuilder.create().texOffs(0, 0).addBox(1, -42.5F, -14, 14, 16, 14, cubeDef), PartPose.offsetAndRotation(-8, -17, 11.5F, 1.0472F, 0, 0));
		partdefinition.addOrReplaceChild("inactive", CubeListBuilder.create()
		.texOffs(0, 0).addBox(1, -32, 1, 14, 16, 14, cubeDef) //Upper Cactus
		.texOffs(0, 30).addBox(1, -16, 1, 14, 16, 14, cubeDef), PartPose.offset(-8, 8, -8)); //Middle Cactus
		return LayerDefinition.create(meshdefinition, 96, 60);
	}
	@Override public void prepareMobModel(EntitySaguaroWorm entity, float limbSwing, float limbSwingAmount, float ageInTicks) {
		active.visible = entity.getProvoked();
		//TODO: it remains inactive after reloading the world while still being angry at the player
		inactive.visible = !active.visible;
	}
	@Override public void setupAnim(EntitySaguaroWorm entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
	@Override public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		base.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		active.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		inactive.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}