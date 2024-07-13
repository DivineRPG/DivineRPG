package divinerpg.client.models.vanilla;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.vanilla.overworld.EntityTheEye;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelTheEye extends EntityModel<EntityTheEye> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("the_eye");
	private final ModelPart TheEye, Body;

	public ModelTheEye(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.TheEye = root.getChild("TheEye");
		this.Body = root.getChild("Body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("TheEye", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, -2.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(32, 24).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 2.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Trail = Body.addOrReplaceChild("Trail", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -1.0F));

		Trail.addOrReplaceChild("trail_r1", CubeListBuilder.create().texOffs(0, 40).addBox(-3.5F, 0.0F, -2.0F, 7.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.3927F, 0.0F, 0.0F));

		Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(34, 40).addBox(-3.0F, -14.0F, -2.0F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -11.0F, 1.0F, -0.4363F, 0.0F, -0.2182F));

		Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(22, 40).addBox(0.0F, -14.0F, -2.0F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -11.0F, 1.0F, -0.4363F, 0.0F, 0.2182F));

		Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 24).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(EntityTheEye entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		TheEye.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}